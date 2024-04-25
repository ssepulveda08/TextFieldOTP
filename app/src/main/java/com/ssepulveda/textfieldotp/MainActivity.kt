package com.ssepulveda.textfieldotp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ssepulveda.textfieldotp.ui.components.TextFieldOTP
import com.ssepulveda.textfieldotp.ui.theme.TextFIeldOTPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TextFIeldOTPTheme {
                val context = LocalContext.current
                var textOTP by remember { mutableStateOf("") }
                var enabledButton by remember {
                    mutableStateOf(false)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "Enter the verification code:")
                        Spacer(modifier = Modifier.padding(8.dp))
                        TextFieldOTP(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            text = textOTP,
                        ) { code, isCompleted ->
                            textOTP = code
                            enabledButton = isCompleted
                        }
                        Spacer(modifier = Modifier.padding(24.dp))
                        Button(
                            onClick = {
                                Toast.makeText(context, "Completed code: $textOTP", Toast.LENGTH_SHORT).show() },
                            enabled = enabledButton
                            ) {
                            Text(text = "Go to")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFIeldOTPTheme {
        Greeting("Android")
    }
}