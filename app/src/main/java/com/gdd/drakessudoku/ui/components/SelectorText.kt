package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdd.drakessudoku.ui.theme.Black
import com.gdd.drakessudoku.ui.theme.LightGrey
import com.gdd.drakessudoku.ui.theme.White

@Composable
fun SelectorText(value: Int, colour: Color, selected: Boolean, modifier: Modifier = Modifier) {
    var clicked by rememberSaveable { mutableStateOf(false) }
    if (selected){clicked = false}

    Card(
        modifier = modifier.padding(Dp.Hairline),
        shape = RectangleShape,
        colors = if (clicked) {
            CardDefaults.cardColors(White)
        } else {
            CardDefaults.cardColors(LightGrey)
        },
        /* elevation = TODO(), */
        border = BorderStroke(width = Dp.Hairline, color = Black),
        onClick = { clicked = !clicked }
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