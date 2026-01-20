package com.gdd.drakessudoku.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdd.drakessudoku.model.GridCell

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
                    ColouredText(value = x1y1.value, colour = x1y1.txtColour, hidden = x1y1.hidden)
                    ColouredText(value = x2y1.value, colour = x2y1.txtColour, hidden = x2y1.hidden)
                    ColouredText(value = x3y1.value, colour = x3y1.txtColour, hidden = x3y1.hidden)
                }
                Row() {
                    ColouredText(value = x1y2.value, colour = x1y2.txtColour, hidden = x1y2.hidden)
                    ColouredText(value = x2y2.value, colour = x2y2.txtColour, hidden = x2y2.hidden)
                    ColouredText(value = x3y2.value, colour = x3y2.txtColour, hidden = x3y2.hidden)
                }
                Row() {
                    ColouredText(value = x1y3.value, colour = x1y3.txtColour, hidden = x1y3.hidden)
                    ColouredText(value = x2y3.value, colour = x2y3.txtColour, hidden = x2y3.hidden)
                    ColouredText(value = x3y3.value, colour = x3y3.txtColour, hidden = x3y3.hidden)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x4y1.value, colour = x4y1.txtColour, hidden = x4y1.hidden)
                    ColouredText(value = x5y1.value, colour = x5y1.txtColour, hidden = x5y1.hidden)
                    ColouredText(value = x6y1.value, colour = x6y1.txtColour, hidden = x6y1.hidden)
                }
                Row() {
                    ColouredText(value = x4y2.value, colour = x4y2.txtColour, hidden = x4y2.hidden)
                    ColouredText(value = x5y2.value, colour = x5y2.txtColour, hidden = x5y2.hidden)
                    ColouredText(value = x6y2.value, colour = x6y2.txtColour, hidden = x6y2.hidden)
                }
                Row() {
                    ColouredText(value = x4y3.value, colour = x4y3.txtColour, hidden = x4y3.hidden)
                    ColouredText(value = x5y3.value, colour = x5y3.txtColour, hidden = x5y3.hidden)
                    ColouredText(value = x6y3.value, colour = x6y3.txtColour, hidden = x6y3.hidden)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x7y1.value, colour = x7y1.txtColour, hidden = x7y1.hidden)
                    ColouredText(value = x8y1.value, colour = x8y1.txtColour, hidden = x8y1.hidden)
                    ColouredText(value = x9y1.value, colour = x9y1.txtColour, hidden = x9y1.hidden)
                }
                Row() {
                    ColouredText(value = x7y2.value, colour = x7y2.txtColour, hidden = x7y2.hidden)
                    ColouredText(value = x8y2.value, colour = x8y2.txtColour, hidden = x8y2.hidden)
                    ColouredText(value = x9y2.value, colour = x9y2.txtColour, hidden = x9y2.hidden)
                }
                Row() {
                    ColouredText(value = x7y3.value, colour = x7y3.txtColour, hidden = x7y3.hidden)
                    ColouredText(value = x8y3.value, colour = x8y3.txtColour, hidden = x8y3.hidden)
                    ColouredText(value = x9y3.value, colour = x9y3.txtColour, hidden = x9y3.hidden)
                }
            } // End of Right
        } // End Top Row

        /* Middle Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x1y4.value, colour = x1y4.txtColour, hidden = x1y4.hidden)
                    ColouredText(value = x2y4.value, colour = x2y4.txtColour, hidden = x2y4.hidden)
                    ColouredText(value = x3y4.value, colour = x3y4.txtColour, hidden = x3y4.hidden)
                }
                Row() {
                    ColouredText(value = x1y5.value, colour = x1y5.txtColour, hidden = x1y5.hidden)
                    ColouredText(value = x2y5.value, colour = x2y5.txtColour, hidden = x2y5.hidden)
                    ColouredText(value = x3y5.value, colour = x3y5.txtColour, hidden = x3y5.hidden)
                }
                Row() {
                    ColouredText(value = x1y6.value, colour = x1y6.txtColour, hidden = x1y6.hidden)
                    ColouredText(value = x2y6.value, colour = x2y6.txtColour, hidden = x2y6.hidden)
                    ColouredText(value = x3y6.value, colour = x3y6.txtColour, hidden = x3y6.hidden)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x4y4.value, colour = x4y4.txtColour, hidden = x4y4.hidden)
                    ColouredText(value = x5y4.value, colour = x5y4.txtColour, hidden = x5y4.hidden)
                    ColouredText(value = x6y4.value, colour = x6y4.txtColour, hidden = x6y4.hidden)
                }
                Row() {
                    ColouredText(value = x4y5.value, colour = x4y5.txtColour, hidden = x4y5.hidden)
                    ColouredText(value = x5y5.value, colour = x5y5.txtColour, hidden = x5y5.hidden)
                    ColouredText(value = x6y5.value, colour = x6y5.txtColour, hidden = x6y5.hidden)
                }
                Row() {
                    ColouredText(value = x4y6.value, colour = x4y6.txtColour, hidden = x4y6.hidden)
                    ColouredText(value = x5y6.value, colour = x5y6.txtColour, hidden = x5y6.hidden)
                    ColouredText(value = x6y6.value, colour = x6y6.txtColour, hidden = x6y6.hidden)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x7y4.value, colour = x7y4.txtColour, hidden = x7y4.hidden)
                    ColouredText(value = x8y4.value, colour = x8y4.txtColour, hidden = x8y4.hidden)
                    ColouredText(value = x9y4.value, colour = x9y4.txtColour, hidden = x9y4.hidden)
                }
                Row() {
                    ColouredText(value = x7y5.value, colour = x7y5.txtColour, hidden = x7y5.hidden)
                    ColouredText(value = x8y5.value, colour = x8y5.txtColour, hidden = x8y5.hidden)
                    ColouredText(value = x9y5.value, colour = x9y5.txtColour, hidden = x9y5.hidden)
                }
                Row() {
                    ColouredText(value = x7y6.value, colour = x7y6.txtColour, hidden = x7y6.hidden)
                    ColouredText(value = x8y6.value, colour = x8y6.txtColour, hidden = x8y6.hidden)
                    ColouredText(value = x9y6.value, colour = x9y6.txtColour, hidden = x9y6.hidden)
                }
            } // End of Right
        } // End Middle Row

        /* Bottom Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x1y7.value, colour = x1y7.txtColour, hidden = x1y7.hidden)
                    ColouredText(value = x2y7.value, colour = x2y7.txtColour, hidden = x2y7.hidden)
                    ColouredText(value = x3y7.value, colour = x3y7.txtColour, hidden = x3y7.hidden)
                }
                Row() {
                    ColouredText(value = x1y8.value, colour = x1y8.txtColour, hidden = x1y8.hidden)
                    ColouredText(value = x2y8.value, colour = x2y8.txtColour, hidden = x2y8.hidden)
                    ColouredText(value = x3y8.value, colour = x3y8.txtColour, hidden = x3y8.hidden)
                }
                Row() {
                    ColouredText(value = x1y9.value, colour = x1y9.txtColour, hidden = x1y9.hidden)
                    ColouredText(value = x2y9.value, colour = x2y9.txtColour, hidden = x2y9.hidden)
                    ColouredText(value = x3y9.value, colour = x3y9.txtColour, hidden = x3y9.hidden)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x4y7.value, colour = x4y7.txtColour, hidden = x4y7.hidden)
                    ColouredText(value = x5y7.value, colour = x5y7.txtColour, hidden = x5y7.hidden)
                    ColouredText(value = x6y7.value, colour = x6y7.txtColour, hidden = x6y7.hidden)
                }
                Row() {
                    ColouredText(value = x4y8.value, colour = x4y8.txtColour, hidden = x4y8.hidden)
                    ColouredText(value = x5y8.value, colour = x5y8.txtColour, hidden = x5y8.hidden)
                    ColouredText(value = x6y8.value, colour = x6y8.txtColour, hidden = x6y8.hidden)
                }
                Row() {
                    ColouredText(value = x4y9.value, colour = x4y9.txtColour, hidden = x4y9.hidden)
                    ColouredText(value = x5y9.value, colour = x5y9.txtColour, hidden = x5y9.hidden)
                    ColouredText(value = x6y9.value, colour = x6y9.txtColour, hidden = x6y9.hidden)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(value = x7y7.value, colour = x7y7.txtColour, hidden = x7y7.hidden)
                    ColouredText(value = x8y7.value, colour = x8y7.txtColour, hidden = x8y7.hidden)
                    ColouredText(value = x9y7.value, colour = x9y7.txtColour, hidden = x9y7.hidden)
                }
                Row() {
                    ColouredText(value = x7y8.value, colour = x7y8.txtColour, hidden = x7y8.hidden)
                    ColouredText(value = x8y8.value, colour = x8y8.txtColour, hidden = x8y8.hidden)
                    ColouredText(value = x9y8.value, colour = x9y8.txtColour, hidden = x9y8.hidden)
                }
                Row() {
                    ColouredText(value = x7y9.value, colour = x7y9.txtColour, hidden = x7y9.hidden)
                    ColouredText(value = x8y9.value, colour = x8y9.txtColour, hidden = x8y9.hidden)
                    ColouredText(value = x9y9.value, colour = x9y9.txtColour, hidden = x9y9.hidden)
                }
            } // End of Right
        } // End Bottom Row
    }


}