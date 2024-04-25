package com.ssepulveda.textfieldotp.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldOTP(
    modifier: Modifier = Modifier,
    text: String,
    count: Int = 4,
    onTextChanges: (String, Boolean) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    BasicTextField(
        modifier = Modifier.then(modifier),
        value = TextFieldValue(text, selection = TextRange(text.length)),
        onValueChange = {
            if (it.text.length <= count) {
                if (it.text.length == count) {
                    keyboardController?.hide()
                }
                onTextChanges.invoke(it.text, it.text.length == count)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(count) { index ->
                    SingleChar(
                        index = index,
                        text = text
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}


@Preview
@Composable
fun PreviewOtpTextField() {
    var otpValue by remember {
        mutableStateOf("")
    }
    Column {
        TextFieldOTP(
            text = otpValue,
            onTextChanges = { value, _ ->
                otpValue = value
            },
            count = 4,
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldOTP(
            text = otpValue,
            onTextChanges = { value, _ ->
                otpValue = value
            },
            count = 6,
        )
    }
}
