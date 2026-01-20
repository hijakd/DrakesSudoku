package com.gdd.drakessudoku.model

import androidx.compose.ui.graphics.Color
import com.gdd.drakessudoku.ui.theme.Black

data class GridCell(val xPosition: Int, val yPosition: Int, val value: Int, var selectedValue: Int = 0, var txtColour: Color = Black, var hidden: Boolean)