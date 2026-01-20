package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdd.drakessudoku.ui.theme.Black
import com.gdd.drakessudoku.ui.theme.White

@Composable
fun ColouredText(value: Int, colour: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(Dp.Hairline),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(White),
        /* elevation = TODO(), */
        border = BorderStroke(width = Dp.Hairline, color = Black)
    ) {
        Text(
            text = "$value",
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            color = colour,
        )
    }
}