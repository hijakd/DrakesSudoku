package com.gdd.drakessudoku.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GridBlockN(
    numbers: MutableList<Int>,
    txtMod: Modifier,
    modifier: Modifier
) {
    Column(modifier) {
        Row() {
            Text(text = "${numbers[0]}", modifier = txtMod)
            Text(text = "${numbers[1]}", modifier = txtMod)
            Text(text = "${numbers[2]}", modifier = txtMod)
        }
        Row() {
            Text(text = "${numbers[3]}", modifier = txtMod)
            Text(text = "${numbers[4]}", modifier = txtMod)
            Text(text = "${numbers[5]}", modifier = txtMod)
        }
        Row() {
            Text(text = "${numbers[6]}", modifier = txtMod)
            Text(text = "${numbers[7]}", modifier = txtMod)
            Text(text = "${numbers[8]}", modifier = txtMod)
        }
    }
}

@Composable
fun GridBlockS(
    values: MutableList<String>,
    txtMod: Modifier,
    modifier: Modifier
) {
    Column(modifier) {
        Row() {
            Text(text = values[0], modifier = txtMod)
            Text(text = values[1], modifier = txtMod)
            Text(text = values[2], modifier = txtMod)
        }
        Row() {
            Text(text = values[3], modifier = txtMod)
            Text(text = values[4], modifier = txtMod)
            Text(text = values[5], modifier = txtMod)
        }
        Row() {
            Text(text = values[6], modifier = txtMod)
            Text(text = values[7], modifier = txtMod)
            Text(text = values[8], modifier = txtMod)
        }
    }
}