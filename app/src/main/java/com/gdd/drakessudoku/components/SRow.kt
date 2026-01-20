package com.gdd.drakessudoku.components

import androidx.collection.MutableIntList
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// fun SRow(modifier: Modifier, nums: MutableIntList) {
/*
@Composable
fun SRow(modifier: Modifier, numbers: MutableList<Int>) {

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "${numbers[0]}")

        if (numbers.size > 1) {
            Text(text = "${numbers[1]}")
        } else {
            Text("0")
        }

        if (numbers.size > 2) {
            Text(text = "${numbers[2]}")
        } else {
            Text("0")
        }

        if (numbers.size > 3) {
            Text(text = "${numbers[3]}")
        } else {
            Text("0")
        }

        if (numbers.size > 4) {
            Text(text = "${numbers[4]}")
        } else {
            Text("0")
        }

        if (numbers.size > 5) {
            Text(text = "${numbers[5]}")
        } else {
            Text("0")
        }

        if (numbers.size > 6) {
            Text(text = "${numbers[6]}")
        } else {
            Text("0")
        }

        if (numbers.size > 7) {
            Text(text = "${numbers[7]}")
        } else {
            Text("0")
        }

        if (numbers.size > 8) {
            Text(text = "${numbers[8]}")
        } else {
            Text("0")
        }
    }
} */

@Composable
fun SRow(modifier: Modifier, numbers: MutableIntList) {
    val txtMod = Modifier.padding(vertical = 5.dp)
    Row(modifier = modifier.fillMaxWidth().border(1.dp, Color.Black, RoundedCornerShape(3.dp)), horizontalArrangement = Arrangement.SpaceEvenly) {

        if (numbers.size > 0){
            Text(text = "${numbers[0]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 1) {
            Text(text = "${numbers[1]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 2) {
            Text(text = "${numbers[2]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 3) {
            Text(text = "${numbers[3]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 4) {
            Text(text = "${numbers[4]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 5) {
            Text(text = "${numbers[5]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 6) {
            Text(text = "${numbers[6]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 7) {
            Text(text = "${numbers[7]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }

        if (numbers.size > 8) {
            Text(text = "${numbers[8]}", modifier = txtMod)
        } else {
            Text("0", modifier = txtMod)
        }
    }
}