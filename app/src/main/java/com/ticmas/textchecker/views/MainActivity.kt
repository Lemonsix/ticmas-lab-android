package com.ticmas.textchecker.views

import TextCheckerViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.ticmas.textchecker.theme.TextCheckerTheme
import androidx.compose.ui.unit.dp
import com.ticmas.textchecker.model.TextCheckerModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = TextCheckerModel()
        val viewModel = TextCheckerViewModel(model)

        setContent {
            TextCheckerApp(viewModel)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTextField(textValue: TextFieldValue, onTextChange: (TextFieldValue) -> Unit, label: String, onTextChanged: () -> Unit) {
    OutlinedTextField(
        value = textValue,
        onValueChange = { newText ->
            onTextChange(newText)
            onTextChanged()
        },
        label = { Text(label) }
    )
}

@Composable
fun CheckButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Comprobar")
    }
}

@Composable
fun Result(areEqual: Boolean, isVisible: Boolean) {
    if (isVisible) {
    if (areEqual) {
        Text("Son iguales")
    } else {
        Text("No son iguales")
    }
    }
}


@Composable
fun TextCheckerApp(viewModel: TextCheckerViewModel) {
    val text1 by viewModel.text1
    val text2 by viewModel.text2
    val areEqual by viewModel.areEqual
    val showResult by viewModel.showResult

    TextCheckerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserTextField(textValue = text1, onTextChange = { newText -> viewModel.text1.value = newText }, label = "Texto 1") { viewModel.onTextChanged() }
                UserTextField(textValue = text2, onTextChange = { newText -> viewModel.text2.value = newText }, label = "Texto 2") { viewModel.onTextChanged() }
                CheckButton(onClick = {
                    viewModel.checkEquality()
                })
                Result(areEqual = areEqual, isVisible = showResult)
            }
        }
    }
}
