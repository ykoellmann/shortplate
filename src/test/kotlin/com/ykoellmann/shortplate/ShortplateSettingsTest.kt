package com.ykoellmann.shortplate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ShortplateSettingsTest {

    private lateinit var settings: ShortplateSettings

    @Before
    fun setUp() {
        settings = ShortplateSettings()
    }

    @Test
    fun `all templates enabled by default`() {
        assertTrue(settings.isEnabled("LiveTemplateShortcuts.Java.sout"))
    }

    @Test
    fun `disabled template is not enabled`() {
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        assertFalse(settings.isEnabled("LiveTemplateShortcuts.Java.sout"))
    }

    @Test
    fun `re-enabling a disabled template makes it enabled again`() {
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", true)
        assertTrue(settings.isEnabled("LiveTemplateShortcuts.Java.sout"))
    }

    @Test
    fun `disabling same template twice does not duplicate entry`() {
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        assertFalse(settings.isEnabled("LiveTemplateShortcuts.Java.sout"))
        // only one entry in the list
        val count = settings.getState().disabledTemplates.count { it == "LiveTemplateShortcuts.Java.sout" }
        assertTrue(count == 1)
    }

    @Test
    fun `disabling one template does not affect others`() {
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        assertTrue(settings.isEnabled("LiveTemplateShortcuts.Java.psvm"))
    }

    @Test
    fun `state round-trips correctly`() {
        settings.setEnabled("LiveTemplateShortcuts.Java.sout", false)
        val state = settings.getState()
        val newSettings = ShortplateSettings()
        newSettings.loadState(state)
        assertFalse(newSettings.isEnabled("LiveTemplateShortcuts.Java.sout"))
        assertTrue(newSettings.isEnabled("LiveTemplateShortcuts.Java.psvm"))
    }
}
