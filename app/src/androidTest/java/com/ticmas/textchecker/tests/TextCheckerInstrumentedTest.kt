package com.ticmas.textchecker.tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ticmas.textchecker.views.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ContextInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.ticmas.textchecker", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testComparisonButton() {
        // Introduce texto en los campos de texto
        composeTestRule.onNodeWithText("Texto 1").performTextInput("Hola")
        composeTestRule.onNodeWithText("Texto 2").performTextInput("Hola")

        // Haz clic en el botón "Comprobar"
        composeTestRule.onNodeWithText("Comprobar").performClick()

        // Comprueba que el resultado es "Son iguales"
        composeTestRule.onNodeWithText("Son iguales").assertExists()
    }
}
