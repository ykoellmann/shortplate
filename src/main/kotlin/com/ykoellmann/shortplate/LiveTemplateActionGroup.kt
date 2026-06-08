package com.ykoellmann.shortplate

import com.intellij.codeInsight.template.impl.TemplateSettings
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.extensions.PluginId

class LiveTemplateActionGroup : DefaultActionGroup() {

    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        syncRegistrations()
        return super.getChildren(e)
    }

    companion object {
        private val registeredIds = mutableSetOf<String>()

        fun syncRegistrations() {
            val actionManager = ActionManager.getInstance()
            val group = actionManager.getAction("LiveTemplateShortcuts.Group") as? LiveTemplateActionGroup
                ?: return
            val settings = ShortplateSettings.getInstance()
            val pluginId = PluginId.getId("com.ykoellmann.shortplate")

            TemplateSettings.getInstance().templates.forEach { template ->
                val actionId = "LiveTemplateShortcuts.${template.groupName}.${template.key}"
                val isEnabled = settings.isEnabled(actionId)
                val isRegistered = actionId in registeredIds

                if (isEnabled && !isRegistered) {
                    val action = LiveTemplateAction(template.key, template.groupName)
                    actionManager.registerAction(actionId, action, pluginId)
                    group.add(action)
                    registeredIds.add(actionId)
                } else if (!isEnabled && isRegistered) {
                    val action = actionManager.getAction(actionId)
                    if (action != null) group.remove(action)
                    actionManager.unregisterAction(actionId)
                    registeredIds.remove(actionId)
                }
            }
        }
    }
}
