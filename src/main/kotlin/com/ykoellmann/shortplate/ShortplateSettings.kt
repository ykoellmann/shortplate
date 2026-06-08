package com.ykoellmann.shortplate

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@Service(Service.Level.APP)
@State(name = "ShortplateSettings", storages = [Storage("shortplate.xml")])
class ShortplateSettings : PersistentStateComponent<ShortplateSettings.State> {

    class State {
        var disabledTemplates: MutableList<String> = mutableListOf()
    }

    private var myState = State()

    override fun getState() = myState
    override fun loadState(state: State) { myState = state }

    fun isEnabled(actionId: String) = actionId !in myState.disabledTemplates

    fun setEnabled(actionId: String, enabled: Boolean) {
        if (enabled) myState.disabledTemplates.remove(actionId)
        else if (actionId !in myState.disabledTemplates) myState.disabledTemplates.add(actionId)
    }

    companion object {
        fun getInstance(): ShortplateSettings =
            ApplicationManager.getApplication().getService(ShortplateSettings::class.java)
    }
}
