package com.ykoellmann.shortplate

import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TemplateSettings
import com.intellij.openapi.options.Configurable
import com.intellij.ui.CheckboxTree
import com.intellij.ui.CheckedTreeNode
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.components.JBScrollPane
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode

class LiveTemplateShortcutsConfigurable : Configurable {

    private var tree: CheckboxTree? = null
    private val panel = JPanel(BorderLayout())

    override fun getDisplayName() = "Live Template Shortcuts"

    override fun createComponent(): JComponent {
        buildTree()
        return panel
    }

    override fun isModified(): Boolean {
        val root = tree?.model?.root as? CheckedTreeNode ?: return false
        val settings = ShortplateSettings.getInstance()
        return collectLeafStates(root).any { (actionId, enabled) ->
            settings.isEnabled(actionId) != enabled
        }
    }

    override fun apply() {
        val root = tree?.model?.root as? CheckedTreeNode ?: return
        val settings = ShortplateSettings.getInstance()
        collectLeafStates(root).forEach { (actionId, enabled) ->
            settings.setEnabled(actionId, enabled)
        }
        LiveTemplateActionGroup.syncRegistrations()
    }

    override fun reset() {
        buildTree()
    }

    private fun buildTree() {
        LiveTemplateActionGroup.syncRegistrations()
        val root = CheckedTreeNode(null)
        val settings = ShortplateSettings.getInstance()

        TemplateSettings.getInstance().templates
            .groupBy { it.groupName }
            .toSortedMap()
            .forEach { (groupName, templates) ->
                val groupNode = CheckedTreeNode(groupName)
                templates.sortedBy { it.key }.forEach { template ->
                    val actionId = "LiveTemplateShortcuts.${template.groupName}.${template.key}"
                    groupNode.add(CheckedTreeNode(template).apply {
                        isChecked = settings.isEnabled(actionId)
                    })
                }
                root.add(groupNode)
            }

        val renderer = object : CheckboxTree.CheckboxTreeCellRenderer() {
            override fun customizeRenderer(
                tree: JTree, value: Any, selected: Boolean,
                expanded: Boolean, leaf: Boolean, row: Int, hasFocus: Boolean
            ) {
                val node = value as? DefaultMutableTreeNode ?: return
                when (val obj = node.userObject) {
                    is TemplateImpl -> {
                        textRenderer.append(obj.key)
                        if (!obj.description.isNullOrBlank()) {
                            textRenderer.append("  ${obj.description}", SimpleTextAttributes.GRAYED_ATTRIBUTES)
                        }
                    }
                    is String -> textRenderer.append(obj, SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES)
                }
            }
        }

        tree = object : CheckboxTree(renderer, root) {
            override fun onNodeStateChanged(node: CheckedTreeNode?) {}
        }

        panel.removeAll()
        panel.add(JBScrollPane(tree!!), BorderLayout.CENTER)
        panel.revalidate()
    }

    private fun collectLeafStates(root: CheckedTreeNode): Map<String, Boolean> {
        val result = mutableMapOf<String, Boolean>()
        for (i in 0 until root.childCount) {
            val groupNode = root.getChildAt(i) as? CheckedTreeNode ?: continue
            for (j in 0 until groupNode.childCount) {
                val leafNode = groupNode.getChildAt(j) as? CheckedTreeNode ?: continue
                val template = leafNode.userObject as? TemplateImpl ?: continue
                result["LiveTemplateShortcuts.${template.groupName}.${template.key}"] = leafNode.isChecked
            }
        }
        return result
    }
}
