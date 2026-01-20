package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdd.drakessudoku.model.GridCell
import com.gdd.drakessudoku.ui.theme.Black
import com.gdd.drakessudoku.ui.theme.Blue
import com.gdd.drakessudoku.ui.theme.DarkGrey
import com.gdd.drakessudoku.ui.theme.Gold
import com.gdd.drakessudoku.ui.theme.MathBlue
import com.gdd.drakessudoku.ui.theme.NeonGreen
import com.gdd.drakessudoku.ui.theme.Purple40
import com.gdd.drakessudoku.ui.theme.Red

@Suppress("RemoveEmptyParenthesesFromLambdaCall")
@Composable
fun DrawSudokuGrid(
    modifier: Modifier,
    x1y1: GridCell,
    x2y1: GridCell,
    x3y1: GridCell,
    x1y2: GridCell,
    x2y2: GridCell,
    x3y2: GridCell,
    x1y3: GridCell,
    x2y3: GridCell,
    x3y3: GridCell,
    x4y1: GridCell,
    x5y1: GridCell,
    x6y1: GridCell,
    x4y2: GridCell,
    x5y2: GridCell,
    x6y2: GridCell,
    x4y3: GridCell,
    x5y3: GridCell,
    x6y3: GridCell,
    x7y1: GridCell,
    x8y1: GridCell,
    x9y1: GridCell,
    x7y2: GridCell,
    x8y2: GridCell,
    x9y2: GridCell,
    x7y3: GridCell,
    x8y3: GridCell,
    x9y3: GridCell,
    x1y4: GridCell,
    x2y4: GridCell,
    x3y4: GridCell,
    x1y5: GridCell,
    x2y5: GridCell,
    x3y5: GridCell,
    x1y6: GridCell,
    x2y6: GridCell,
    x3y6: GridCell,
    x4y4: GridCell,
    x5y4: GridCell,
    x6y4: GridCell,
    x4y5: GridCell,
    x5y5: GridCell,
    x6y5: GridCell,
    x4y6: GridCell,
    x5y6: GridCell,
    x6y6: GridCell,
    x7y4: GridCell,
    x8y4: GridCell,
    x9y4: GridCell,
    x7y5: GridCell,
    x8y5: GridCell,
    x9y5: GridCell,
    x7y6: GridCell,
    x8y6: GridCell,
    x9y6: GridCell,
    x1y7: GridCell,
    x2y7: GridCell,
    x3y7: GridCell,
    x1y8: GridCell,
    x2y8: GridCell,
    x3y8: GridCell,
    x1y9: GridCell,
    x2y9: GridCell,
    x3y9: GridCell,
    x4y7: GridCell,
    x5y7: GridCell,
    x6y7: GridCell,
    x4y8: GridCell,
    x5y8: GridCell,
    x6y8: GridCell,
    x4y9: GridCell,
    x5y9: GridCell,
    x6y9: GridCell,
    x7y7: GridCell,
    x8y7: GridCell,
    x9y7: GridCell,
    x7y8: GridCell,
    x8y8: GridCell,
    x9y8: GridCell,
    x7y9: GridCell,
    x8y9: GridCell,
    x9y9: GridCell
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        /* Top Row */
        Row {
            /* Left */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y1.value, x1y1.txtColour)
                    ColouredText(x2y1.value, x2y1.txtColour)
                    ColouredText(x3y1.value, x3y1.txtColour)
                }
                Row() {
                    ColouredText(x1y2.value, x1y2.txtColour)
                    ColouredText(x2y2.value, x2y2.txtColour)
                    ColouredText(x3y2.value, x3y2.txtColour)
                }
                Row() {
                    ColouredText(x1y3.value, x1y3.txtColour)
                    ColouredText(x2y3.value, x2y3.txtColour)
                    ColouredText(x3y3.value, x3y3.txtColour)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y1.value, x4y1.txtColour)
                    ColouredText(x5y1.value, x5y1.txtColour)
                    ColouredText(x6y1.value, x6y1.txtColour)
                }
                Row() {
                    ColouredText(x4y2.value, x4y2.txtColour)
                    ColouredText(x5y2.value, x5y2.txtColour)
                    ColouredText(x6y2.value, x6y2.txtColour)
                }
                Row() {
                    ColouredText(x4y3.value, x4y3.txtColour)
                    ColouredText(x5y3.value, x5y3.txtColour)
                    ColouredText(x6y3.value, x6y3.txtColour)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y1.value, x7y1.txtColour)
                    ColouredText(x8y1.value, x8y1.txtColour)
                    ColouredText(x9y1.value, x9y1.txtColour)
                }
                Row() {
                    ColouredText(x7y2.value, x7y2.txtColour)
                    ColouredText(x8y2.value, x8y2.txtColour)
                    ColouredText(x9y2.value, x9y2.txtColour)
                }
                Row() {
                    ColouredText(x7y3.value, x7y3.txtColour)
                    ColouredText(x8y3.value, x8y3.txtColour)
                    ColouredText(x9y3.value, x9y3.txtColour)
                }
            } // End of Right
        } // End Top Row

        /* Middle Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y4.value, x1y4.txtColour)
                    ColouredText(x2y4.value, x2y4.txtColour)
                    ColouredText(x3y4.value, x3y4.txtColour)
                }
                Row() {
                    ColouredText(x1y5.value, x1y5.txtColour)
                    ColouredText(x2y5.value, x2y5.txtColour)
                    ColouredText(x3y5.value, x3y5.txtColour)
                }
                Row() {
                    ColouredText(x1y6.value, x1y6.txtColour)
                    ColouredText(x2y6.value, x2y6.txtColour)
                    ColouredText(x3y6.value, x3y6.txtColour)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y4.value, x4y4.txtColour)
                    ColouredText(x5y4.value, x5y4.txtColour)
                    ColouredText(x6y4.value, x6y4.txtColour)
                }
                Row() {
                    ColouredText(x4y5.value, x4y5.txtColour)
                    ColouredText(x5y5.value, x5y5.txtColour)
                    ColouredText(x6y5.value, x6y5.txtColour)
                }
                Row() {
                    ColouredText(x4y6.value, x4y6.txtColour)
                    ColouredText(x5y6.value, x5y6.txtColour)
                    ColouredText(x6y6.value, x6y6.txtColour)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y4.value, x7y4.txtColour)
                    ColouredText(x8y4.value, x8y4.txtColour)
                    ColouredText(x9y4.value, x9y4.txtColour)
                }
                Row() {
                    ColouredText(x7y5.value, x7y5.txtColour)
                    ColouredText(x8y5.value, x8y5.txtColour)
                    ColouredText(x9y5.value, x9y5.txtColour)
                }
                Row() {
                    ColouredText(x7y6.value, x7y6.txtColour)
                    ColouredText(x8y6.value, x8y6.txtColour)
                    ColouredText(x9y6.value, x9y6.txtColour)
                }
            } // End of Right
        } // End Middle Row

        /* Bottom Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x1y7.value, x1y7.txtColour)
                    ColouredText(x2y7.value, x2y7.txtColour)
                    ColouredText(x3y7.value, x3y7.txtColour)
                }
                Row() {
                    ColouredText(x1y8.value, x1y8.txtColour)
                    ColouredText(x2y8.value, x2y8.txtColour)
                    ColouredText(x3y8.value, x3y8.txtColour)
                }
                Row() {
                    ColouredText(x1y9.value, x1y9.txtColour)
                    ColouredText(x2y9.value, x2y9.txtColour)
                    ColouredText(x3y9.value, x3y9.txtColour)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x4y7.value, x4y7.txtColour)
                    ColouredText(x5y7.value, x5y7.txtColour)
                    ColouredText(x6y7.value, x6y7.txtColour)
                }
                Row() {
                    ColouredText(x4y8.value, x4y8.txtColour)
                    ColouredText(x5y8.value, x5y8.txtColour)
                    ColouredText(x6y8.value, x6y8.txtColour)
                }
                Row() {
                    ColouredText(x4y9.value, x4y9.txtColour)
                    ColouredText(x5y9.value, x5y9.txtColour)
                    ColouredText(x6y9.value, x6y9.txtColour)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(x7y7.value, x7y7.txtColour)
                    ColouredText(x8y7.value, x8y7.txtColour)
                    ColouredText(x9y7.value, x9y7.txtColour)
                }
                Row() {
                    ColouredText(x7y8.value, x7y8.txtColour)
                    ColouredText(x8y8.value, x8y8.txtColour)
                    ColouredText(x9y8.value, x9y8.txtColour)
                }
                Row() {
                    ColouredText(x7y9.value, x7y9.txtColour)
                    ColouredText(x8y9.value, x8y9.txtColour)
                    ColouredText(x9y9.value, x9y9.txtColour)
                }
            } // End of Right
        } // End Bottom Row
    }


}