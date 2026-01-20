package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdd.drakessudoku.ui.theme.Black
import com.gdd.drakessudoku.ui.theme.Blue
import com.gdd.drakessudoku.ui.theme.DarkGrey
import com.gdd.drakessudoku.ui.theme.Gold
import com.gdd.drakessudoku.ui.theme.MathBlue
import com.gdd.drakessudoku.ui.theme.NeonGreen
import com.gdd.drakessudoku.ui.theme.Purple40
import com.gdd.drakessudoku.ui.theme.Red

@Composable
fun SudokuGrid(
    modifier: Modifier,
    x1y1: Int,
    x2y1: Int,
    x3y1: Int,
    x1y2: Int,
    x2y2: Int,
    x3y2: Int,
    x1y3: Int,
    x2y3: Int,
    x3y3: Int,
    x4y1: Int,
    x5y1: Int,
    x6y1: Int,
    x4y2: Int,
    x5y2: Int,
    x6y2: Int,
    x4y3: Int,
    x5y3: Int,
    x6y3: Int,
    x7y1: Int,
    x8y1: Int,
    x9y1: Int,
    x7y2: Int,
    x8y2: Int,
    x9y2: Int,
    x7y3: Int,
    x8y3: Int,
    x9y3: Int,
    x1y4: Int,
    x2y4: Int,
    x3y4: Int,
    x1y5: Int,
    x2y5: Int,
    x3y5: Int,
    x1y6: Int,
    x2y6: Int,
    x3y6: Int,
    x4y4: Int,
    x5y4: Int,
    x6y4: Int,
    x4y5: Int,
    x5y5: Int,
    x6y5: Int,
    x4y6: Int,
    x5y6: Int,
    x6y6: Int,
    x7y4: Int,
    x8y4: Int,
    x9y4: Int,
    x7y5: Int,
    x8y5: Int,
    x9y5: Int,
    x7y6: Int,
    x8y6: Int,
    x9y6: Int,
    x1y7: Int,
    x2y7: Int,
    x3y7: Int,
    x1y8: Int,
    x2y8: Int,
    x3y8: Int,
    x1y9: Int,
    x2y9: Int,
    x3y9: Int,
    x4y7: Int,
    x5y7: Int,
    x6y7: Int,
    x4y8: Int,
    x5y8: Int,
    x6y8: Int,
    x4y9: Int,
    x5y9: Int,
    x6y9: Int,
    x7y7: Int,
    x8y7: Int,
    x9y7: Int,
    x7y8: Int,
    x8y8: Int,
    x9y8: Int,
    x7y9: Int,
    x8y9: Int,
    x9y9: Int
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        /* Top Row */
        Row {
            /* Left */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y1, Black)
                    ColouredText(x2y1, Black)
                    ColouredText(x3y1, Black)
                }
                Row() {
                    ColouredText(x1y2, Black)
                    ColouredText(x2y2, Black)
                    ColouredText(x3y2, Black)
                }
                Row() {
                    ColouredText(x1y3, Black)
                    ColouredText(x2y3, Black)
                    ColouredText(x3y3, Black)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y1, Red)
                    ColouredText(x5y1, Red)
                    ColouredText(x6y1, Red)
                }
                Row() {
                    ColouredText(x4y2, Red)
                    ColouredText(x5y2, Red)
                    ColouredText(x6y2, Red)
                }
                Row() {
                    ColouredText(x4y3, Red)
                    ColouredText(x5y3, Red)
                    ColouredText(x6y3, Red)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y1, NeonGreen)
                    ColouredText(x8y1, NeonGreen)
                    ColouredText(x9y1, NeonGreen)
                }
                Row() {
                    ColouredText(x7y2, NeonGreen)
                    ColouredText(x8y2, NeonGreen)
                    ColouredText(x9y2, NeonGreen)
                }
                Row() {
                    ColouredText(x7y3, NeonGreen)
                    ColouredText(x8y3, NeonGreen)
                    ColouredText(x9y3, NeonGreen)
                }
            } // End of Right
        } // End Top Row

        /* Middle Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y4, Blue)
                    ColouredText(x2y4, Blue)
                    ColouredText(x3y4, Blue)
                }
                Row() {
                    ColouredText(x1y5, Blue)
                    ColouredText(x2y5, Blue)
                    ColouredText(x3y5, Blue)
                }
                Row() {
                    ColouredText(x1y6, Blue)
                    ColouredText(x2y6, Blue)
                    ColouredText(x3y6, Blue)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y4, Gold)
                    ColouredText(x5y4, Gold)
                    ColouredText(x6y4, Gold)
                }
                Row() {
                    ColouredText(x4y5, Gold)
                    ColouredText(x5y5, Gold)
                    ColouredText(x6y5, Gold)
                }
                Row() {
                    ColouredText(x4y6, Gold)
                    ColouredText(x5y6, Gold)
                    ColouredText(x6y6, Gold)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y4, DarkGrey)
                    ColouredText(x8y4, DarkGrey)
                    ColouredText(x9y4, DarkGrey)
                }
                Row() {
                    ColouredText(x7y5, DarkGrey)
                    ColouredText(x8y5, DarkGrey)
                    ColouredText(x9y5, DarkGrey)
                }
                Row() {
                    ColouredText(x7y6, DarkGrey)
                    ColouredText(x8y6, DarkGrey)
                    ColouredText(x9y6, DarkGrey)
                }
            } // End of Right
        } // End Middle Row

        /* Bottom Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y7, Purple40)
                    ColouredText(x2y7, Purple40)
                    ColouredText(x3y7, Purple40)
                }
                Row() {
                    ColouredText(x1y8, Purple40)
                    ColouredText(x2y8, Purple40)
                    ColouredText(x3y8, Purple40)
                }
                Row() {
                    ColouredText(x1y9, Purple40)
                    ColouredText(x2y9, Purple40)
                    ColouredText(x3y9, Purple40)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y7, MathBlue)
                    ColouredText(x5y7, MathBlue)
                    ColouredText(x6y7, MathBlue)
                }
                Row() {
                    ColouredText(x4y8, MathBlue)
                    ColouredText(x5y8, MathBlue)
                    ColouredText(x6y8, MathBlue)
                }
                Row() {
                    ColouredText(x4y9, MathBlue)
                    ColouredText(x5y9, MathBlue)
                    ColouredText(x6y9, MathBlue)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y7, Red)
                    ColouredText(x8y7, Red)
                    ColouredText(x9y7, Red)
                }
                Row() {
                    ColouredText(x7y8, Red)
                    ColouredText(x8y8, Red)
                    ColouredText(x9y8, Red)
                }
                Row() {
                    ColouredText(x7y9, Red)
                    ColouredText(x8y9, Red)
                    ColouredText(x9y9, Red)
                }
            } // End of Right
        } // End Bottom Row
    }
}