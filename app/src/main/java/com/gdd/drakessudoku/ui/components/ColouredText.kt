package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ColouredText(value: Int, colour: Color, modifier: Modifier = Modifier) {
    Text(
        text = "$value",
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp),
        fontWeight = FontWeight.Bold,
        color = colour
    )
}