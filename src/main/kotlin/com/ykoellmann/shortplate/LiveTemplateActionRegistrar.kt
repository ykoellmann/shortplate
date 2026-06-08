package com.ykoellmann.shortplate

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class LiveTemplateActionRegistrar : StartupActivity.DumbAware {
    override fun runActivity(project: Project) {
        LiveTemplateActionGroup.syncRegistrations()
    }
}
