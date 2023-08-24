import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import com.ticmas.textchecker.model.TextCheckerModel

class TextCheckerViewModel(private val model: TextCheckerModel) {
    var text1 = mutableStateOf(TextFieldValue(""))
    var text2 = mutableStateOf(TextFieldValue(""))
    var areEqual = mutableStateOf(false)
    var showResult = mutableStateOf(false)

    fun checkEquality() {
        areEqual.value = model.areTextsEqual(text1.value.text, text2.value.text)
        showResult.value = true
    }

    fun onTextChanged() {
        showResult.value = false
    }
}
