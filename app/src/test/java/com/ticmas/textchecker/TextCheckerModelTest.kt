package com.ticmas.textchecker


import com.ticmas.textchecker.model.TextCheckerModel
import org.junit.Test

import org.junit.Assert.*


class TextCheckerModelTest {

    private val textCheckerModel = TextCheckerModel()

    @Test
    fun `when texts are equal, returns true`() {
        val text1 = "Hello, World!"
        val text2 = "Hello, World!"

        val result = textCheckerModel.areTextsEqual(text1, text2)

        assertTrue("Expected texts to be equal",result)
    }

    @Test
    fun `when texts are not equal, returns false`() {
        val text1 = "Hello, World!"
        val text2 = "Goodbye, World!"
        val result = textCheckerModel.areTextsEqual(text1, text2)

        assertFalse( "Expected texts to be not equal",result)
    }
}