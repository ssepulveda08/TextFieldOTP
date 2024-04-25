package com.ssepulveda.textfieldotp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleChar(
    index: Int,
    text: String
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .border(
                1.dp,
                Color.Blue,
                RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(2.dp),
            text = if (index >= text.length) "" else text[index].toString(),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
        )
    }
}
