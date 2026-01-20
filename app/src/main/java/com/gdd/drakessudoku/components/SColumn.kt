package com.gdd.drakessudoku.components

import androidx.collection.MutableIntList
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SColumn(modifier: Modifier, numbers: MutableIntList) {
    val txtMod = Modifier.padding(horizontal = 10.dp)
    Column(
        modifier = modifier
            .fillMaxHeight().padding(bottom = 10.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(3.dp)),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly
    ) {

        if (numbers.size > 0) {
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