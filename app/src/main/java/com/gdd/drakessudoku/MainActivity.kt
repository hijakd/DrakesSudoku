package com.gdd.drakessudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gdd.drakessudoku.model.GridCell
import com.gdd.drakessudoku.ui.components.DrawSudokuGrid
import com.gdd.drakessudoku.ui.theme.*
import com.gdd.drakessudoku.utils.FilterList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrakesSudokuTheme {
                DrakesSudokuApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun DrakesSudokuApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppCore(modifier = Modifier.padding(innerPadding))
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

@Composable
fun AppCore(modifier: Modifier = Modifier) {

    /* Rows == x's, Columns == y's */
    /* x1y1 x2y1 x3y1 */  /* x4y1 x5y1 x6y1 */  /* x7y1 x8y1 x9y1 */
    /* x1y2 x2y2 x3y2 */  /* x4y2 x5y2 x6y2 */  /* x7y2 x8y2 x9y2 */
    /* x1y3 x2y3 x3y3 */  /* x4y3 x5y3 x6y3 */  /* x7y3 x8y3 x9y3 */

    /* x1y4 x2y4 x3y4 */  /* x4y4 x5y4 x6y4 */  /* x7y4 x8y4 x9y4 */
    /* x1y5 x2y5 x3y5 */  /* x4y5 x5y5 x6y5 */  /* x7y5 x8y5 x9y5 */
    /* x1y6 x2y6 x3y6 */  /* x4y6 x5y6 x6y6 */  /* x7y6 x8y6 x9y6 */

    /* x1y7 x2y7 x3y7 */  /* x4y7 x5y7 x6y7 */  /* x7y7 x8y7 x9y7 */
    /* x1y8 x2y8 x3y8 */  /* x4y8 x5y8 x6y8 */  /* x7y8 x8y8 x9y8 */
    /* x1y9 x2y9 x3y9 */  /* x4y9 x5y9 x6y9 */  /* x7y9 x8y9 x9y9 */

    val debug = true
    var xValue = 0
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val shuffled = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slice1 = mutableListOf(0)
    val slice2 = mutableListOf(0)
    val slice3 = mutableListOf(0)
    val tmpSlice = mutableListOf(0)

    shuffled.shuffle()
    slice1.clear()
    slice2.clear()
    slice3.clear()
    tmpSlice.clear()


    /* row 01 */
    /* x1y1 -> x9y1 */
    /* x1y1 - Grid1 TopLeft */
    val x1y1 = GridCell(
        xPosition = 1,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x2y1 - Grid1 TopLeft */
    val x2y1 = GridCell(
        xPosition = 2,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x3y1 - Grid1 TopLeft */
    val x3y1 = GridCell(
        xPosition = 3,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x4y1 - Grid2 TopCenter */
    val x4y1 = GridCell(
        xPosition = 4,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Red,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x5y1 - Grid2 TopCenter */
    val x5y1 = GridCell(
        xPosition = 5,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Red,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x6y1 - Grid2 TopCenter */
    val x6y1 = GridCell(
        xPosition = 6,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = Red,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x7y1 - Grid3 TopRight */
    val x7y1 = GridCell(
        xPosition = 7,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x8y1 - Grid3 TopRight */
    val x8y1 = GridCell(
        xPosition = 8,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x9y1 - Grid3 TopRight */
    val x9y1 = GridCell(
        xPosition = 9,
        yPosition = 1,
        value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    shuffled.remove(x1y1.value)

    /* column 01 */
    /* x1y2 -> x1y9 */
    /* x1y2 - Grid1 TopLeft */
    val x1y2 = GridCell(
        xPosition = 1,
        yPosition = 2,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y3 - Grid1 TopLeft */
    val x1y3 = GridCell(
        xPosition = 1,
        yPosition = 3,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y4 - Grid4 MiddleLeft */
    val x1y4 = GridCell(
        xPosition = 1,
        yPosition = 4,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y5 - Grid4 MiddleLeft */
    val x1y5 = GridCell(
        xPosition = 1,
        yPosition = 5,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y6 - Grid4 MiddleLeft */
    val x1y6 = GridCell(
        xPosition = 1,
        yPosition = 6,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y7 - Grid7 BottomLeft */
    val x1y7 = GridCell(
        xPosition = 1,
        yPosition = 7,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y8 - Grid7 BottomLeft */
    val x1y8 = GridCell(
        xPosition = 1,
        yPosition = 8,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y9 - Grid7 BottomLeft */
    val x1y9 = GridCell(
        xPosition = 1,
        yPosition = 9,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    if (debug) {
        shuffled.forEach {
            if (it == x1y1.value ||
                it == x1y2.value ||
                it == x1y3.value ||
                it == x2y1.value ||
                it == x3y1.value
            ) {
                tmpSlice.add(it)
            }
        }
    }

    // remove list elements already assigned to row1 & col1 of Grid1
    FilterList(shuffled, x1y1, x2y1, x3y1, x1y2, x1y3)
    shuffled.shuffled()
    xValue = shuffled.count()

    /* Grid1 TopLeft */
    /* row 02 */
    /* x2y2 - Grid1 TopLeft */
    val x2y2 = GridCell(
        xPosition = 2,
        yPosition = 2,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x3y2 - Grid1 TopLeft */
    val x3y2 = GridCell(
        xPosition = 3,
        yPosition = 2,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* row 3 */
    /* x2y3 - Grid1 TopLeft */
    val x2y3 = GridCell(
        xPosition = 2,
        yPosition = 3,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x3y3 - Grid1 TopLeft */
    val x3y3 = GridCell(
        xPosition = 3,
        yPosition = 3,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )

    // reset shuffled list
    ResetShuffled(shuffled, numbers)

    // remove list elements for first row of Grid2
    FilterList(shuffled, x4y1, x5y1, x6y1)

    shuffled.forEach {
        slice1.add(it)
        slice2.add(it)
    }

    // remove list elements for 2nd & 3rd row of Grid1
    FilterList(slice1, x1y2, x2y2, x3y2)
    FilterList(slice2, x1y3, x2y3, x3y3)

    /* Grid2 TopCenter */
    /* row 2 */
    /* x4y2 - Grid2 TopCenter */
    val x4y2 = GridCell(
        xPosition = 4,
        yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )
    slice1.removeAt(0)
    slice2.remove(x4y2.value)

    /* x5y2 - Grid2 TopCenter */
    val x5y2 = GridCell(
        xPosition = 5,
        yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )
    slice1.removeAt(0)
    slice2.remove(x5y2.value)

    /* x6y2 - Grid2 TopCenter */
    val x6y2 = GridCell(
        xPosition = 6,
        yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )
    slice2.remove(x6y2.value)

    /* Grid2 TopCenter */
    /* row 3 */
    /* x4y3 - Grid2 TopCenter */
    val x4y3 = GridCell(
        xPosition = 4,
        yPosition = 3,
        value = if (
            slice2.first() != x4y1.value &&
            slice2.first() != x4y2.value &&
            slice2.first() != x5y1.value &&
            slice2.first() != x5y2.value &&
            slice2.first() != x6y1.value &&
            slice2.first() != x6y2.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x4y1.value &&
            slice2.last() != x4y2.value &&
            slice2.last() != x5y1.value &&
            slice2.last() != x5y2.value &&
            slice2.last() != x6y1.value &&
            slice2.last() != x6y2.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Red,
        hidden = false
    )
    slice2.remove(x4y3.value)

    /* x5y3 - Grid2 TopCenter */
    val x5y3 = GridCell(
        xPosition = 5,
        yPosition = 3,
        value = if (
                slice2.first() != x5y1.value &&
                slice2.first() != x5y2.value &&
                slice2.first() != x6y1.value &&
                slice2.first() != x6y2.value
            ) {
                slice2.first()
            } else if (
                slice2.last() != x5y1.value &&
                slice2.last() != x5y2.value &&
                slice2.last() != x6y1.value &&
                slice2.last() != x6y2.value
            ) {
                slice2.last()
            } else {
                tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
            },
        txtColour = Red,
        hidden = false
    )
    slice2.remove(x5y3.value)

    // if (slice2.isEmpty()) {
    //     ResetShuffled(slice2, numbers)
    //     FilterList(slice2, x4y1, x5y1, x6y1, x4y2, x5y2, x6y2, x4y3, x5y3)
    // }
    // xValue = slice2.count()

    if (slice2.isEmpty()) {
        xValue = 0
        while (
            xValue != x4y1.value &&
            xValue != x5y1.value &&
            xValue != x6y1.value &&
            xValue != x4y2.value &&
            xValue != x5y2.value &&
            xValue != x6y2.value &&
            xValue != x4y3.value &&
            xValue != x5y3.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice2.first()
    }

    /* x6y3 - Grid2 TopCenter */
    val x6y3 = GridCell(
        xPosition = 6,
        yPosition = 3,
        value = xValue,
        txtColour = Red,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    FilterList(inputList = slice1, cell01 = x7y1, cell02 = x8y1, cell03 = x9y1)
    FilterList(inputList = slice1, cell01 = x1y2, cell02 = x2y2, cell03 = x3y2, cell04 = x4y2, cell05 = x5y2, cell06 = x6y2)


    /* Grid3 TopRight */
    /* row 2 */
    /* x7y2 - Grid3 TopRight */
    val x7y2 = GridCell(
        xPosition = 7,
        yPosition = 2,
        value = slice1.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    slice1.remove(x7y2.value)

    if (slice1.isEmpty()) {
        ResetShuffled(slice1, numbers)
        FilterList(slice1, x1y2, x2y2, x3y2, x4y2, x5y2, x6y2, x7y2)
    }

    /* x8y2 - Grid3 TopRight */
    val x8y2 = GridCell(
        xPosition = 8,
        yPosition = 2,
        value = slice1.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    slice1.remove(x8y2.value)

    // if (slice1.isEmpty()) {
    //     ResetShuffled(slice1, numbers)
    //     FilterList(slice1, x1y2, x2y2, x3y2, x4y2, x5y2, x6y2, x7y2, x8y2)
    // }

    /* select the value to assign to the x9 element */
    if (slice1.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y2.value &&
            xValue != x2y2.value &&
            xValue != x3y2.value &&
            xValue != x4y2.value &&
            xValue != x5y2.value &&
            xValue != x6y2.value &&
            xValue != x7y2.value &&
            xValue != x8y2.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice1.first()
    }

    /* x9y2 - Grid3 TopRight */
    val x9y2 = GridCell(
        xPosition = 9,
        yPosition = 2,
        value = xValue,
        txtColour = NeonGreen,
        hidden = false
    )

    ResetShuffled(slice2, numbers)
    FilterList(inputList = slice2, cell01 = x7y1, cell02 = x8y1, cell03 = x9y1, cell04 = x7y2, cell05 = x8y2, cell06 = x9y2)

    /* row 3 */
    /* x7y3 - Grid3 TopRight */
    val x7y3 = GridCell(
        xPosition = 7,
        yPosition = 3,
        value = slice2.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    slice2.remove(x7y3.value)

    /* x8y3 - Grid3 TopRight */
    val x8y3 = GridCell(
        xPosition = 8,
        yPosition = 3,
        value = slice2.first(),
        txtColour = NeonGreen,
        hidden = false
    )
    slice2.remove(x8y3.value)

    // if (slice2.isEmpty()){
    //     ResetShuffled(slice2, numbers)
    //     FilterList(slice2, x1y3, x2y3, x3y3, x4y3, x5y3, x6y3, x7y3, x8y3)
    // }

    if (slice2.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y3.value &&
            xValue != x2y3.value &&
            xValue != x3y3.value &&
            xValue != x4y3.value &&
            xValue != x5y3.value &&
            xValue != x6y3.value &&
            xValue != x7y3.value &&
            xValue != x8y3.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice2.first()
    }

    /* x9y3 - Grid3 TopRight */
    val x9y3 = GridCell(
        xPosition = 9,
        yPosition = 3,
        value = xValue,
        txtColour = NeonGreen,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    // remove values already assigned in col1 of Grid4
    FilterList(shuffled, cell01 = x1y4, cell02 = x1y5, cell03 = x1y6)
    ResetShuffled(slice1, shuffled)
    ResetShuffled(slice2, shuffled)
    // remove values already assigned in col2 & col3 of Grid1
    FilterList(slice1, cell01 = x2y1, cell02 = x2y2, cell03 = x2y3)
    FilterList(slice2, cell01 = x3y1, cell02 = x3y2, cell03 = x3y3)

    /* Grid4 MiddleLeft */
    // Grid4 values are assigned in vertical order not horizontally
    /* row 4 */
    /* x2y4 - Grid4 MiddleLeft */
    val x2y4 = GridCell(
        xPosition = 2,
        yPosition = 4,
        value = slice1.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x2y4.value)
    slice2.remove(x2y4.value)

    /* x3y4 - Grid4 MiddleLeft */
    val x3y4 = GridCell(
        xPosition = 3,
        yPosition = 4,
        value = slice2.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x3y4.value)
    slice2.remove(x3y4.value)

    /* row 2 */
    /* x2y5 - Grid4 MiddleLeft */
    val x2y5 = GridCell(
        xPosition = 2,
        yPosition = 5,
        value = slice1.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x2y5.value)
    slice2.remove(x2y5.value)

    /* x3y5 - Grid4 MiddleLeft */
    val x3y5 = GridCell(
        xPosition = 3,
        yPosition = 5,
        value = slice2.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x3y5.value)
    slice2.remove(x3y5.value)

    /* x2y6 - Grid4 MiddleLeft */
    val x2y6 = GridCell(
        xPosition = 2,
        yPosition = 6,
        value = slice1.first(),
        txtColour = Blue,
        hidden = false
    )

    // if (slice2.isEmpty()) {
    //     numbers.forEach { slice2.add(it) }
    //     slice2.remove(x1y4.value)
    //     slice2.remove(x1y5.value)
    //     slice2.remove(x1y6.value)
    //     slice2.remove(x2y4.value)
    //     slice2.remove(x2y5.value)
    //     slice2.remove(x2y6.value)
    //     slice2.remove(x3y4.value)
    //     slice2.remove(x3y5.value)
    // }

    if (slice2.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y4.value &&
            xValue != x1y5.value &&
            xValue != x1y6.value &&
            xValue != x2y4.value &&
            xValue != x2y5.value &&
            xValue != x2y6.value &&
            xValue != x3y4.value &&
            xValue != x3y5.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice2.first()
    }

    /* x3y6 - Grid4 MiddleLeft */
    val x3y6 = GridCell(
        xPosition = 3,
        yPosition = 6,
        value = xValue,
        txtColour = Blue,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    ResetShuffled(slice2, numbers)
    ResetShuffled(slice3, numbers)
    FilterList(slice1, cell01 = x1y4, cell02 = x2y4, cell03 = x3y4)
    FilterList(slice2, cell01 = x1y5, cell02 = x2y5, cell03 = x3y5)
    FilterList(slice3, cell01 = x1y6, cell02 = x2y6, cell03 = x3y6)


    /* Grid5 Center */
    /* row 4 */
    /* x4y4 - Grid5 Center */
    val x4y4 = GridCell(
        xPosition = 4,
        yPosition = 4,
        value = if (
            slice1.first() != x4y1.value &&
            slice1.first() != x4y2.value &&
            slice1.first() != x4y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x4y1.value &&
            slice1.last() != x4y2.value &&
            slice1.last() != x4y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice1.remove(x4y4.value)
    slice2.remove(x4y4.value)
    slice3.remove(x4y4.value)

    /* x5y4 - Grid5 Center */
    val x5y4 = GridCell(
        xPosition = 5,
        yPosition = 4,
        value = if (
            slice1.first() != x5y1.value &&
            slice1.first() != x5y2.value &&
            slice1.first() != x5y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x5y1.value &&
            slice1.last() != x5y2.value &&
            slice1.last() != x5y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice1.remove(x5y4.value)
    slice2.remove(x5y4.value)
    slice3.remove(x5y4.value)

    /* x6y4 - Grid5 Center */
    val x6y4 = GridCell(
        xPosition = 6,
        yPosition = 4,
        value = if (
            slice1.first() != x6y1.value &&
            slice1.first() != x6y2.value &&
            slice1.first() != x6y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x6y1.value &&
            slice1.last() != x6y2.value &&
            slice1.last() != x6y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice2.remove(x6y4.value)
    slice3.remove(x6y4.value)

    /* row 5 */
    /* x4y5 - Grid5 Center */
    val x4y5 = GridCell(
        xPosition = 4,
        yPosition = 5,
        value = if (
            slice2.first() != x4y1.value &&
            slice2.first() != x4y2.value &&
            slice2.first() != x4y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x4y1.value &&
            slice2.last() != x4y2.value &&
            slice2.last() != x4y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice2.remove(x4y5.value)
    slice3.remove(x4y5.value)

    /* x5y5 - Grid5 Center */
    val x5y5 = GridCell(
        xPosition = 5,
        yPosition = 5,
        value = if (
            slice2.first() != x5y1.value &&
            slice2.first() != x5y2.value &&
            slice2.first() != x5y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x5y1.value &&
            slice2.last() != x5y2.value &&
            slice2.last() != x5y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice2.remove(x5y5.value)
    slice3.remove(x5y5.value)

    /* x6y5 - Grid5 Center */
    val x6y5 = GridCell(
        xPosition = 6,
        yPosition = 5,
        value = if (
            slice2.first() != x6y1.value &&
            slice2.first() != x6y2.value &&
            slice2.first() != x6y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x6y1.value &&
            slice2.last() != x6y2.value &&
            slice2.last() != x6y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice3.remove(x6y5.value)

    /* row 6 */
    /* x4y6 - Grid5 Center */
    val x4y6 = GridCell(
        xPosition = 4,
        yPosition = 6,
        value = if (
            slice3.first() != x4y1.value &&
            slice3.first() != x4y2.value &&
            slice3.first() != x4y3.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x4y1.value &&
            slice3.last() != x4y2.value &&
            slice3.last() != x4y3.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice3.remove(x4y6.value)

    /* x5y6 - Grid5 Center */
    val x5y6 = GridCell(
        xPosition = 5,
        yPosition = 6,
        value = if (
            slice3.first() != x5y1.value &&
            slice3.first() != x5y2.value &&
            slice3.first() != x5y3.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x5y1.value &&
            slice3.last() != x5y2.value &&
            slice3.last() != x5y3.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = Gold,
        hidden = false
    )
    slice3.remove(x5y6.value)

    // if (slice3.isEmpty()) {
    //     ResetShuffled(slice3, numbers)
    //     FilterList(slice3, x1y6, x2y6, x3y6, x4y6, x5y6)
    // }

    if (slice3.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y6.value &&
            xValue != x2y6.value &&
            xValue != x3y6.value &&
            xValue != x4y6.value &&
            xValue != x5y6.value &&
            xValue != x6y1.value &&
            xValue != x6y2.value &&
            xValue != x6y3.value &&
            xValue != x6y4.value &&
            xValue != x6y5.value &&
            xValue < 10
        ) {
            xValue++
        }
    }

    if (slice3.isNotEmpty()) {
        xValue = if (
            slice3.first() != x5y1.value &&
            slice3.first() != x5y2.value &&
            slice3.first() != x5y3.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x5y1.value &&
            slice3.last() != x5y2.value &&
            slice3.last() != x5y3.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        }
    }

    /* x6y6 - Grid5 Center */
    val x6y6 = GridCell(
        xPosition = 6,
        yPosition = 6,
        value = xValue,
        txtColour = Gold,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    ResetShuffled(slice2, numbers)
    ResetShuffled(slice3, numbers)

    FilterList(slice1, x1y4, x2y4, x3y4, x4y4, x5y4, x6y4)
    FilterList(slice2, x1y5, x2y5, x3y5, x4y5, x5y5, x6y5)
    FilterList(slice3, x1y6, x2y6, x3y6, x4y6, x5y6, x6y6)

    /* Grid6 MiddleRight */
    /* row 4 */
    /* x7y4 - Grid6 MiddleRight */
    val x7y4 = GridCell(
        xPosition = 7,
        yPosition = 4,
        value = if (
            slice1.first() != x7y1.value &&
            slice1.first() != x7y2.value &&
            slice1.first() != x7y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x7y1.value &&
            slice1.last() != x7y2.value &&
            slice1.last() != x7y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice1.remove(x7y4.value)
    slice2.remove(x7y4.value)
    slice3.remove(x7y4.value)

    /* x8y4 - Grid6 MiddleRight */
    val x8y4 = GridCell(
        xPosition = 8,
        yPosition = 4,
        value = if (
            slice1.first() != x8y1.value &&
            slice1.first() != x8y2.value &&
            slice1.first() != x8y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x8y1.value &&
            slice1.last() != x8y2.value &&
            slice1.last() != x8y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice1.remove(x8y4.value)
    slice2.remove(x8y4.value)
    slice3.remove(x8y4.value)

    /* x9y4 - Grid6 MiddleRight */
    val x9y4 = GridCell(
        xPosition = 9,
        yPosition = 4,
        value = if (
            slice1.first() != x9y1.value &&
            slice1.first() != x9y2.value &&
            slice1.first() != x9y3.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x9y1.value &&
            slice1.last() != x9y2.value &&
            slice1.last() != x9y3.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice2.remove(x9y4.value)
    slice3.remove(x9y4.value)

    /* row 5 */
    /* x7y5 - Grid6 MiddleRight */
    val x7y5 = GridCell(
        xPosition = 7,
        yPosition = 5,
        value = if (
            slice2.first() != x7y1.value &&
            slice2.first() != x7y2.value &&
            slice2.first() != x7y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x7y1.value &&
            slice2.last() != x7y2.value &&
            slice2.last() != x7y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice2.remove(x7y5.value)
    slice3.remove(x7y5.value)

    /* x8y5 - Grid6 MiddleRight */
    val x8y5 = GridCell(
        xPosition = 8,
        yPosition = 5,
        value = if (
            slice2.first() != x8y1.value &&
            slice2.first() != x8y2.value &&
            slice2.first() != x8y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x8y1.value &&
            slice2.last() != x8y2.value &&
            slice2.last() != x8y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice2.remove(x8y5.value)
    slice3.remove(x8y5.value)

    // if (slice2.isEmpty()) {
    //     ResetShuffled(slice2, numbers)
    //     FilterList(slice2, x1y5, x2y5, x3y5, x4y5, x5y5, x6y5, x7y5, x8y5)
    // }

    if (slice2.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y5.value &&
            xValue != x2y5.value &&
            xValue != x3y5.value &&
            xValue != x4y5.value &&
            xValue != x5y5.value &&
            xValue != x6y5.value &&
            xValue != x7y5.value &&
            xValue != x8y5.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice2.first()
    }

    if (slice2.isNotEmpty()) {
        xValue = if (
            slice2.first() != x9y1.value &&
            slice2.first() != x9y2.value &&
            slice2.first() != x9y3.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x9y1.value &&
            slice2.last() != x9y2.value &&
            slice2.last() != x9y3.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        }
    }

    /* x9y5 - Grid6 MiddleRight */
    val x9y5 = GridCell(
        xPosition = 9,
        yPosition = 5,
        value = xValue,
        txtColour = DarkGrey,
        hidden = false
    )
    slice3.remove(x9y5.value)

    /* row 6 */
    /* x7y6 - Grid6 MiddleRight */
    val x7y6 = GridCell(
        xPosition = 7,
        yPosition = 6,
        value = if (
            slice3.first() != x7y1.value &&
            slice3.first() != x7y2.value &&
            slice3.first() != x7y3.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x7y1.value &&
            slice3.last() != x7y2.value &&
            slice3.last() != x7y3.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice3.remove(x7y6.value)

    /* x8y6 - Grid6 MiddleRight */
    val x8y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = if (
            slice3.first() != x8y1.value &&
            slice3.first() != x8y2.value &&
            slice3.first() != x8y3.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x8y1.value &&
            slice3.last() != x8y2.value &&
            slice3.last() != x8y3.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = DarkGrey,
        hidden = false
    )
    slice3.remove(x8y6.value)


    if (slice3.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y6.value &&
            xValue != x2y6.value &&
            xValue != x3y6.value &&
            xValue != x4y6.value &&
            xValue != x5y6.value &&
            xValue != x6y6.value &&
            xValue != x7y6.value &&
            xValue != x8y6.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice3.first()
    }


    /* x9y6 - Grid6 MiddleRight */
    val x9y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = xValue,
        txtColour = DarkGrey,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x1y7, x1y8, x1y9)
    ResetShuffled(slice1, shuffled)
    ResetShuffled(slice2, shuffled)
    // FilterList(slice1, x2y1, x2y2, x2y3, x2y4, x2y5, x2y6)
    // FilterList(slice2, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6)

    /* Grid7 BottomLeft */
    /* row 7 */
    /* x2y7 - Grid7 BottomLeft */
    val x2y7 = GridCell(
        xPosition = 2,
        yPosition = 7,
        value = if (
            slice1.first() != x2y1.value &&
            slice1.first() != x2y2.value &&
            slice1.first() != x2y3.value &&
            slice1.first() != x2y4.value &&
            slice1.first() != x2y5.value &&
            slice1.first() != x2y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x2y1.value &&
            slice1.last() != x2y2.value &&
            slice1.last() != x2y3.value &&
            slice1.last() != x2y4.value &&
            slice1.last() != x2y5.value &&
            slice1.last() != x2y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Purple40,
        hidden = false
    )
    slice1.remove(x2y7.value)
    slice2.remove(x2y7.value)

    /* x3y7 - Grid7 BottomLeft */
    val x3y7 = GridCell(
        xPosition = 3,
        yPosition = 7,
        value = slice2.first(),
        txtColour = Purple40,
        hidden = false
    )
    slice1.remove(x3y7.value)
    slice2.remove(x3y7.value)

    /* row 8 */
    /* x2y8 - Grid7 BottomLeft */
    val x2y8 = GridCell(
        xPosition = 2,
        yPosition = 8,
        value = slice1.first(),
        txtColour = Purple40,
        hidden = false
    )
    slice1.remove(x2y8.value)
    slice2.remove(x2y8.value)

    /* x3y8 - Grid7 BottomLeft */
    val x3y8 = GridCell(
        xPosition = 3,
        yPosition = 8,
        value = slice2.first(),
        txtColour = Purple40,
        hidden = false
    )
    slice1.remove(x3y8.value)
    slice2.remove(x3y8.value)

    /* row 9 */
    /* x2y9 - Grid7 BottomLeft */
    val x2y9 = GridCell(
        xPosition = 2,
        yPosition = 9,
        value = slice1.first(),
        txtColour = Purple40,
        hidden = false
    )
    slice2.remove(x2y9.value)

    /* x3y9 - Grid7 BottomLeft */
    val x3y9 = GridCell(
        xPosition = 3,
        yPosition = 9,
        value = slice2.first(),
        txtColour = Purple40,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    ResetShuffled(slice2, numbers)
    ResetShuffled(slice3, numbers)

    FilterList(slice1, x1y7, x2y7, x3y7)
    FilterList(slice2, x1y8, x2y8, x3y8)
    FilterList(slice3, x1y9, x2y9, x3y9)

    /* Grid8 BottomCenter */
    /* row 7 */
    /* x4y7 - Grid8 BottomCenter */
    val x4y7 = GridCell(
        xPosition = 4,
        yPosition = 7,
        value = if (
            slice1.first() != x4y1.value &&
            slice1.first() != x4y2.value &&
            slice1.first() != x4y3.value &&
            slice1.first() != x4y4.value &&
            slice1.first() != x4y5.value &&
            slice1.first() != x4y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x4y1.value &&
            slice1.last() != x4y2.value &&
            slice1.last() != x4y3.value &&
            slice1.last() != x4y4.value &&
            slice1.last() != x4y5.value &&
            slice1.last() != x4y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice1.remove(x4y7.value)
    slice2.remove(x4y7.value)
    slice3.remove(x4y7.value)

    /* x5y7 - Grid8 BottomCenter */
    val x5y7 = GridCell(
        xPosition = 5,
        yPosition = 7,
        value = if (
            slice1.first() != x5y1.value &&
            slice1.first() != x5y2.value &&
            slice1.first() != x5y3.value &&
            slice1.first() != x5y4.value &&
            slice1.first() != x5y5.value &&
            slice1.first() != x5y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x5y1.value &&
            slice1.last() != x5y2.value &&
            slice1.last() != x5y3.value &&
            slice1.last() != x5y4.value &&
            slice1.last() != x5y5.value &&
            slice1.last() != x5y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice1.remove(x5y7.value)
    slice2.remove(x5y7.value)
    slice3.remove(x5y7.value)

    /* x6y7 - Grid8 BottomCenter */
    val x6y7 = GridCell(
        xPosition = 6,
        yPosition = 7,
        value = if (
            slice1.first() != x6y1.value &&
            slice1.first() != x6y2.value &&
            slice1.first() != x6y3.value &&
            slice1.first() != x6y4.value &&
            slice1.first() != x6y5.value &&
            slice1.first() != x6y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x6y1.value &&
            slice1.last() != x6y2.value &&
            slice1.last() != x6y3.value &&
            slice1.last() != x6y4.value &&
            slice1.last() != x6y5.value &&
            slice1.last() != x6y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice2.remove(x6y7.value)
    slice3.remove(x6y7.value)

    /* row 8 */
    /* x4y8 - Grid8 BottomCenter */
    val x4y8 = GridCell(
        xPosition = 4,
        yPosition = 8,
        value = if (
            slice2.first() != x4y1.value &&
            slice2.first() != x4y2.value &&
            slice2.first() != x4y3.value &&
            slice2.first() != x4y4.value &&
            slice2.first() != x4y5.value &&
            slice2.first() != x4y6.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x4y1.value &&
            slice2.last() != x4y2.value &&
            slice2.last() != x4y3.value &&
            slice2.last() != x4y4.value &&
            slice2.last() != x4y5.value &&
            slice2.last() != x4y6.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice2.remove(x4y8.value)
    slice3.remove(x4y8.value)

    /* x5y8 - Grid8 BottomCenter */
    val x5y8 = GridCell(
        xPosition = 5,
        yPosition = 8,
        value = if (
            slice2.first() != x5y1.value &&
            slice2.first() != x5y2.value &&
            slice2.first() != x5y3.value &&
            slice2.first() != x5y4.value &&
            slice2.first() != x5y5.value &&
            slice2.first() != x5y6.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x5y1.value &&
            slice2.last() != x5y2.value &&
            slice2.last() != x5y3.value &&
            slice2.last() != x5y4.value &&
            slice2.last() != x5y5.value &&
            slice2.last() != x5y6.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice2.remove(x5y8.value)
    slice3.remove(x5y8.value)

    /* x6y8 - Grid8 BottomCenter */
    val x6y8 = GridCell(
        xPosition = 6,
        yPosition = 8,
        value = if (
            slice2.first() != x6y1.value &&
            slice2.first() != x6y2.value &&
            slice2.first() != x6y3.value &&
            slice2.first() != x6y4.value &&
            slice2.first() != x6y5.value &&
            slice2.first() != x6y6.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x6y1.value &&
            slice2.last() != x6y2.value &&
            slice2.last() != x6y3.value &&
            slice2.last() != x6y4.value &&
            slice2.last() != x6y5.value &&
            slice2.last() != x6y6.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice3.remove(x6y8.value)

    /* row 9 */
    /* x4y9 - Grid8 BottomCenter */
    val x4y9 = GridCell(
        xPosition = 4,
        yPosition = 9,
        value = if (
            slice3.first() != x4y1.value &&
            slice3.first() != x4y2.value &&
            slice3.first() != x4y3.value &&
            slice3.first() != x4y4.value &&
            slice3.first() != x4y5.value &&
            slice3.first() != x4y6.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x4y1.value &&
            slice3.last() != x4y2.value &&
            slice3.last() != x4y3.value &&
            slice3.last() != x4y4.value &&
            slice3.last() != x4y5.value &&
            slice3.last() != x4y6.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice3.remove(x4y9.value)

    /* x5y9 - Grid8 BottomCenter */
    val x5y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = if (
            slice3.first() != x5y1.value &&
            slice3.first() != x5y2.value &&
            slice3.first() != x5y3.value &&
            slice3.first() != x5y4.value &&
            slice3.first() != x5y5.value &&
            slice3.first() != x5y6.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x5y1.value &&
            slice3.last() != x5y2.value &&
            slice3.last() != x5y3.value &&
            slice3.last() != x5y4.value &&
            slice3.last() != x5y5.value &&
            slice3.last() != x5y6.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = MathBlue,
        hidden = false
    )
    slice3.remove(x5y9.value)

    /* if (slice3.isEmpty()){
        numbers.forEach { slice3.add(it) }
        slice3.remove(x1y9.value)
        slice3.remove(x2y9.value)
        slice3.remove(x3y9.value)
        slice3.remove(x4y9.value)
        slice3.remove(x5y9.value)
        slice3.remove(x6y1.value)
        slice3.remove(x6y2.value)
        slice3.remove(x6y3.value)
        slice3.remove(x6y4.value)
        slice3.remove(x6y5.value)
        slice3.remove(x6y6.value)
        slice3.remove(x6y7.value)
        slice3.remove(x6y8.value)
    } */


    /* x6y9 - Grid8 BottomCenter */
    xValue = 0
    while (xValue != x1y9.value &&
        xValue != x2y9.value &&
        xValue != x3y9.value &&
        xValue != x4y9.value &&
        xValue != x5y9.value &&
        xValue != x6y1.value &&
        xValue != x6y2.value &&
        xValue != x6y3.value &&
        xValue != x6y4.value &&
        xValue != x6y5.value &&
        xValue != x6y6.value &&
        xValue != x6y7.value &&
        xValue != x6y8.value &&
        xValue < 10
    ) {
        xValue++
    }

    val x6y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = xValue,
        /* value = if (
            slice3.first() != x6y1.value &&
            slice3.first() != x6y2.value &&
            slice3.first() != x6y3.value &&
            slice3.first() != x6y4.value &&
            slice3.first() != x6y5.value &&
            slice3.first() != x6y6.value
        ) {
            slice3.first()
        } else {
            slice3.last()
        }, */
        txtColour = MathBlue,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    ResetShuffled(slice2, numbers)
    ResetShuffled(slice3, numbers)

    FilterList(slice1, x1y7, x2y7, x3y7, x4y7, x5y7, x6y7)
    FilterList(slice2, x1y8, x2y8, x3y8, x4y8, x5y8, x6y8)
    FilterList(slice3, x1y9, x2y9, x3y9, x4y9, x5y9, x6y9)

    /* Grid9 BottomRight */
    /* row 7 */
    /* x7y7 - Grid9 BottomRight */
    val x7y7 = GridCell(
        xPosition = 7,
        yPosition = 7,
        value = if (
            slice1.first() != x7y1.value &&
            slice1.first() != x7y2.value &&
            slice1.first() != x7y3.value &&
            slice1.first() != x7y4.value &&
            slice1.first() != x7y5.value &&
            slice1.first() != x7y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x7y1.value &&
            slice1.last() != x7y2.value &&
            slice1.last() != x7y3.value &&
            slice1.last() != x7y4.value &&
            slice1.last() != x7y5.value &&
            slice1.last() != x7y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )
    slice1.remove(x7y7.value)
    slice2.remove(x7y7.value)
    slice3.remove(x7y7.value)

    /* x8y7 - Grid9 BottomRight */
    val x8y7 = GridCell(
        xPosition = 8,
        yPosition = 7,
        value = if (
            slice1.first() != x8y1.value &&
            slice1.first() != x8y2.value &&
            slice1.first() != x8y3.value &&
            slice1.first() != x8y4.value &&
            slice1.first() != x8y5.value &&
            slice1.first() != x8y6.value
        ) {
            slice1.first()
        } else if (
            slice1.last() != x8y1.value &&
            slice1.last() != x8y2.value &&
            slice1.last() != x8y3.value &&
            slice1.last() != x8y4.value &&
            slice1.last() != x8y5.value &&
            slice1.last() != x8y6.value
        ) {
            slice1.last()
        } else {
            tmpSlice.clear()
            randomFromSlice1(slice1, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )
    slice1.remove(x8y7.value)
    slice2.remove(x8y7.value)
    slice3.remove(x8y7.value)

    if (slice1.isEmpty()) {
        xValue = 0
        while (
            xValue != x1y7.value &&
            xValue != x2y7.value &&
            xValue != x3y7.value &&
            xValue != x4y7.value &&
            xValue != x5y7.value &&
            xValue != x6y7.value &&
            xValue != x7y7.value &&
            xValue != x8y7.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice1.first()
    }

    /* x9y7 - Grid9 BottomRight */
    val x9y7 = GridCell(
        xPosition = 9,
        yPosition = 7,
        value = xValue,
        txtColour = Pink,
        hidden = false
    )

    slice2.remove(x9y7.value)
    slice3.remove(x9y7.value)

    /* row 8 */
    /* x7y8 - Grid9 BottomRight */
    val x7y8 = GridCell(
        xPosition = 7,
        yPosition = 8,
        value = if (
            slice2.first() != x7y1.value &&
            slice2.first() != x7y2.value &&
            slice2.first() != x7y3.value &&
            slice2.first() != x7y4.value &&
            slice2.first() != x7y5.value &&
            slice2.first() != x7y6.value &&
            slice2.first() != x7y7.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x7y1.value &&
            slice2.last() != x7y2.value &&
            slice2.last() != x7y3.value &&
            slice2.last() != x7y4.value &&
            slice2.last() != x7y5.value &&
            slice2.last() != x7y6.value &&
            slice2.last() != x7y7.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )
    slice2.remove(x7y8.value)
    slice3.remove(x7y8.value)

    /* x8y8 - Grid9 BottomRight */
    val x8y8 = GridCell(
        xPosition = 8,
        yPosition = 8,
        value = if (
            slice2.first() != x8y1.value &&
            slice2.first() != x8y2.value &&
            slice2.first() != x8y3.value &&
            slice2.first() != x8y4.value &&
            slice2.first() != x8y5.value &&
            slice2.first() != x8y6.value &&
            slice2.first() != x8y7.value
        ) {
            slice2.first()
        } else if (
            slice2.last() != x8y1.value &&
            slice2.last() != x8y2.value &&
            slice2.last() != x8y3.value &&
            slice2.last() != x8y4.value &&
            slice2.last() != x8y5.value &&
            slice2.last() != x8y6.value &&
            slice2.last() != x8y7.value
        ) {
            slice2.last()
        } else {
            tmpSlice.clear()
            randomFromSlice2(slice2, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )

    slice2.remove(x8y8.value)
    slice3.remove(x8y8.value)

    if (slice2.isEmpty()) {
        xValue = 0
        while (
            xValue != x9y1.value &&
            xValue != x9y2.value &&
            xValue != x9y3.value &&
            xValue != x9y4.value &&
            xValue != x9y5.value &&
            xValue != x9y6.value &&
            xValue != x9y7.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice2.first()
    }

    /* x9y8 - Grid9 BottomRight */
    val x9y8 = GridCell(
        xPosition = 9,
        yPosition = 8,
        value = xValue,
        txtColour = Pink,
        hidden = false
    )

    slice2.remove(x9y8.value)
    slice3.remove(x9y8.value)

    /* row 9 */
    /* x7y9 - Grid9 BottomRight */
    val x7y9 = GridCell(
        xPosition = 7,
        yPosition = 9,
        value = if (
            slice3.first() != x7y1.value &&
            slice3.first() != x7y2.value &&
            slice3.first() != x7y3.value &&
            slice3.first() != x7y4.value &&
            slice3.first() != x7y5.value &&
            slice3.first() != x7y6.value &&
            slice3.first() != x7y7.value &&
            slice3.first() != x7y8.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x7y1.value &&
            slice3.last() != x7y2.value &&
            slice3.last() != x7y3.value &&
            slice3.last() != x7y4.value &&
            slice3.last() != x7y5.value &&
            slice3.last() != x7y6.value &&
            slice3.last() != x7y7.value &&
            slice3.last() != x7y8.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )

    slice3.remove(x7y9.value)

    /* x8y9 - Grid9 BottomRight */
    val x8y9 = GridCell(
        xPosition = 8,
        yPosition = 9,
        value = if (
            slice3.first() != x8y1.value &&
            slice3.first() != x8y2.value &&
            slice3.first() != x8y3.value &&
            slice3.first() != x8y4.value &&
            slice3.first() != x8y5.value &&
            slice3.first() != x8y6.value &&
            slice3.first() != x8y7.value &&
            slice3.first() != x8y8.value
        ) {
            slice3.first()
        } else if (
            slice3.last() != x8y1.value &&
            slice3.last() != x8y2.value &&
            slice3.last() != x8y3.value &&
            slice3.last() != x8y4.value &&
            slice3.last() != x8y5.value &&
            slice3.last() != x8y6.value &&
            slice3.last() != x8y7.value &&
            slice3.last() != x8y8.value
        ) {
            slice3.last()
        } else {
            tmpSlice.clear()
            randomFromSlice3(slice3, tmpSlice)
        },
        txtColour = Pink,
        hidden = false
    )

    if (slice3.isEmpty()) {
        xValue = 0
        while (
            xValue != x9y1.value &&
            xValue != x9y2.value &&
            xValue != x9y3.value &&
            xValue != x9y4.value &&
            xValue != x9y5.value &&
            xValue != x9y6.value &&
            xValue != x9y7.value &&
            xValue != x9y8.value &&
            xValue < 10
        ) {
            xValue++
        }
    } else {
        xValue = slice3.first()
    }

    /* x9y9 - Grid9 BottomRight */
    val x9y9 = GridCell(
        xPosition = 9,
        yPosition = 9,
        value = xValue,
        txtColour = Pink,
        hidden = false
    )

    /* Begin Layout */

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.size(5.dp))
        // Text("Grid# $grid")
        Text("idx# $xValue")
        // Text("Shuffled: $shuffled  size: ${shuffled.size}")
        // Text("ThisShuffled: $thisShuffled  size: ${thisShuffled.size}")
        if (debug) {
            Text("tmpslice: $tmpSlice  size: ${tmpSlice.size}")
        }
        Text("Slice1: $slice1  size: ${slice1.size}")
        Text("Slice2: $slice2  size: ${slice2.size}")
        Text("Slice3: $slice3  size: ${slice3.size}")
        // Text("Slice2 $slice2")
        // Text("Slice2: $tmpSlice2  size: ${tmpSlice2.size}")
        Spacer(modifier = Modifier.size(5.dp))

        var idx = 0

        DrawSudokuGrid(
            x1y1 = x1y1,
            x2y1 = x2y1,
            x3y1 = x3y1,
            x1y2 = x1y2,
            x2y2 = x2y2,
            x3y2 = x3y2,
            x1y3 = x1y3,
            x2y3 = x2y3,
            x3y3 = x3y3,
            x4y1 = x4y1,
            x5y1 = x5y1,
            x6y1 = x6y1,
            x4y2 = x4y2,
            x5y2 = x5y2,
            x6y2 = x6y2,
            x4y3 = x4y3,
            x5y3 = x5y3,
            x6y3 = x6y3,
            x7y1 = x7y1,
            x8y1 = x8y1,
            x9y1 = x9y1,
            x7y2 = x7y2,
            x8y2 = x8y2,
            x9y2 = x9y2,
            x7y3 = x7y3,
            x8y3 = x8y3,
            x9y3 = x9y3,
            x1y4 = x1y4,
            x2y4 = x2y4,
            x3y4 = x3y4,
            x1y5 = x1y5,
            x2y5 = x2y5,
            x3y5 = x3y5,
            x1y6 = x1y6,
            x2y6 = x2y6,
            x3y6 = x3y6,
            x4y4 = x4y4,
            x5y4 = x5y4,
            x6y4 = x6y4,
            x4y5 = x4y5,
            x5y5 = x5y5,
            x6y5 = x6y5,
            x4y6 = x4y6,
            x5y6 = x5y6,
            x6y6 = x6y6,
            x7y4 = x7y4,
            x8y4 = x8y4,
            x9y4 = x9y4,
            x7y5 = x7y5,
            x8y5 = x8y5,
            x9y5 = x9y5,
            x7y6 = x7y6,
            x8y6 = x8y6,
            x9y6 = x9y6,
            x1y7 = x1y7,
            x2y7 = x2y7,
            x3y7 = x3y7,
            x1y8 = x1y8,
            x2y8 = x2y8,
            x3y8 = x3y8,
            x1y9 = x1y9,
            x2y9 = x2y9,
            x3y9 = x3y9,
            x4y7 = x4y7,
            x5y7 = x5y7,
            x6y7 = x6y7,
            x4y8 = x4y8,
            x5y8 = x5y8,
            x6y8 = x6y8,
            x4y9 = x4y9,
            x5y9 = x5y9,
            x6y9 = x6y9,
            x7y7 = x7y7,
            x8y7 = x8y7,
            x9y7 = x9y7,
            x7y8 = x7y8,
            x8y8 = x8y8,
            x9y8 = x9y8,
            x7y9 = x7y9,
            x8y9 = x8y9,
            x9y9 = x9y9,
            modifier = modifier
        )

        Spacer(modifier = Modifier.size(10.dp))
    }
} // End of AppCore

/**
 * Return a random element from a selected list after trimming the first & last elements
 * @param slice1 source list to select from
 * @param tmpSlice the list used to hold the values for random selection
 * */
@Composable
private fun randomFromSlice1(
    slice1: MutableList<Int>,
    tmpSlice: MutableList<Int>
): Int {
    slice1.forEach { tmpSlice.add(it) }
    tmpSlice.remove(slice1.first())
    tmpSlice.remove(slice1.last())
    return tmpSlice.random()
}

/**
 * Return a random element from a selected list after trimming the first & last elements
 * @param slice2 source list to select from
 * @param tmpSlice the list used to hold the values for random selection
 * */
@Composable
private fun randomFromSlice2(
    slice2: MutableList<Int>,
    tmpSlice: MutableList<Int>
): Int {
    slice2.forEach { tmpSlice.add(it) }
    tmpSlice.remove(slice2.first())
    tmpSlice.remove(slice2.last())
    return tmpSlice.random()
}

/**
 * Return a random element from a selected list after trimming the first & last elements
 * @param slice3 source list to select from
 * @param tmpSlice the list used to hold the values for random selection
 * */
@Composable
private fun randomFromSlice3(
    slice3: MutableList<Int>,
    tmpSlice: MutableList<Int>
): Int {
    slice3.forEach { tmpSlice.add(it) }
    tmpSlice.remove(slice3.first())
    tmpSlice.remove(slice3.last())
    return tmpSlice.random()
}

/**
 * The input list is "reset" using list.clear() before being populated from the source list.
 * @param[inputList] list to be reset (cleared then shuffled)
 * @param numbers source list used to populate the inputList
 * */
@Composable
fun ResetShuffled(inputList: MutableList<Int>, numbers: MutableList<Int>) {
    inputList.clear()
    numbers.forEach { inputList.add(it) }
    inputList.shuffle()
}

@Preview(showBackground = true)
@Composable
fun AppCorePreview() {
    DrakesSudokuTheme {
        AppCore()
    }
}