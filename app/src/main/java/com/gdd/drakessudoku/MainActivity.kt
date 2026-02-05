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
import com.gdd.drakessudoku.utils.TrimToOneElement

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
        }) {
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
    val err = 0
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val shuffled = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    shuffled.shuffle()

    val slice1 = mutableListOf(0)
    val slice2 = mutableListOf(0)
    val slice3 = mutableListOf(0)
    val trimmedShuffle = mutableListOf(0)
    trimmedShuffle.clear()

    /* ROW 01 populate position values */
    val posX1y1 = shuffled[0]
    val posX2y1 = shuffled[1]
    val posX3y1 = shuffled[2]
    val posX4y1 = shuffled[3]
    val posX5y1 = shuffled[4]
    val posX6y1 = shuffled[5]
    val posX7y1 = shuffled[6]
    val posX8y1 = shuffled[7]
    val posX9y1 = shuffled[8]

    val row1 = mutableListOf(0)
    val row2 = mutableListOf(0)
    val row3 = mutableListOf(0)
    val row4 = mutableListOf(0)
    val row5 = mutableListOf(0)
    val row6 = mutableListOf(0)
    val row7 = mutableListOf(0)
    val row8 = mutableListOf(0)
    val row9 = mutableListOf(0)
    row1.clear()
    row2.clear()
    row3.clear()
    row4.clear()
    row5.clear()
    row6.clear()
    row7.clear()
    row8.clear()
    row9.clear()

    shuffled.forEach { row1.add(it) }


    shuffled.shuffle()
    /* shuffled.remove(posX1y1)
    if (shuffled.last() == posX9y1) {
        shuffled.shuffle()
    } */


    /* ROW 02 populate possible values */
    var posX1y2 = 0
    var posX2y2 = 0
    var posX3y2 = 0
    var posX4y2 = 0
    var posX5y2 = 0
    var posX6y2 = 0
    var posX7y2 = 0
    var posX8y2 = 0
    var posX9y2 = 0


    /* ROW 03 populate possible values */
    var posX1y3 = 0
    var posX2y3 = 0
    var posX3y3 = 0
    var posX4y3 = 0
    var posX5y3 = 0
    var posX6y3 = 0
    var posX7y3 = 0
    var posX8y3 = 0
    var posX9y3 = 0



    /* ROW 04 populate possible values */
    var posX1y4 = 0
    var posX2y4 = 0
    var posX3y4 = 0
    var posX4y4 = 0
    var posX5y4 = 0
    var posX6y4 = 0
    var posX7y4 = 0
    var posX8y4 = 0
    var posX9y4 = 0


    /* ROW 05 populate possible values */
    var posX1y5 = 0
    var posX2y5 = 0
    var posX3y5 = 0
    var posX4y5 = 0
    var posX5y5 = 0
    var posX6y5 = 0
    var posX7y5 = 0
    var posX8y5 = 0
    var posX9y5 = 0


    /* ROW 06 populate possible values */
    var posX1y6 = 0
    var posX2y6 = 0
    var posX3y6 = 0
    var posX4y6 = 0
    var posX5y6 = 0
    var posX6y6 = 0
    var posX7y6 = 0
    var posX8y6 = 0
    var posX9y6 = 0


    /* ROW 07 populate possible values */
    var posX1y7 = 0
    var posX2y7 = 0
    var posX3y7 = 0
    var posX4y7 = 0
    var posX5y7 = 0
    var posX6y7 = 0
    var posX7y7 = 0
    var posX8y7 = 0
    var posX9y7 = 0


    /* ROW 08 populate possible values */
    var posX1y8 = 0
    var posX2y8 = 0
    var posX3y8 = 0
    var posX4y8 = 0
    var posX5y8 = 0
    var posX6y8 = 0
    var posX7y8 = 0
    var posX8y8 = 0
    var posX9y8 = 0


    /* ROW 09 populate possible values */
    var posX1y9 = 0
    var posX2y9 = 0
    var posX3y9 = 0
    var posX4y9 = 0
    var posX5y9 = 0
    var posX6y9 = 0
    var posX7y9 = 0
    var posX8y9 = 0
    var posX9y9 = 0


    /* Grid01 eliminate values */
    /* eliminate values - row 2 */
    // slice1.clear()
    // slice1.add(row1[0])
    // slice1.add(row1[1])
    // slice1.add(row1[2])
    //
    // shuffled.forEach {
    //     if (!slice1.contains(it)) {
    //         trimmedShuffle.add(it)
    //     }
    // }

    shuffled.remove(posX1y1)
    shuffled.remove(posX2y1)
    shuffled.remove(posX3y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y2 = err
    } else {
        posX1y2 = shuffled.first()
    }

    // row2.add(trimmedShuffle.first())

    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX2y1)
    shuffled.remove(posX3y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y2 = err
    } else {
        posX2y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y2 = err
    } else {
        posX3y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y1)
    shuffled.remove(posX5y1)
    shuffled.remove(posX6y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y2 = err
    } else {
        posX4y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y1)
    shuffled.remove(posX6y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y2 = err
    } else {
        posX5y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y2 = err
    } else {
        posX6y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y2)
    shuffled.remove(posX7y1)
    shuffled.remove(posX8y1)
    shuffled.remove(posX9y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y2 = err
    } else {
        posX7y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y2)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX8y1)
    shuffled.remove(posX9y1)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y2 = err
    } else {
        posX8y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y2)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y2)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y2)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX9y1)
    /* shuffled.forEach {
        if (
            it == posX1y2 ||
            it == posX2y2 ||
            it == posX3y2 ||
            it == posX4y2 ||
            it == posX5y2 ||
            it == posX6y2 ||
            it == posX7y1 ||
            it == posX7y2 ||
            it == posX8y1 ||
            it == posX8y2 ||
            it == posX9y1
            ) {
            shuffled.remove(it)
        }
    } */
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y2 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y2 = err
    } else {
        posX9y2 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* eliminate values - row 3 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y3 = err
    } else {
        posX1y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y3 = err
    } else {
        posX2y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y3 = err
    } else {
        posX3y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y3 = err
    } else {
        posX4y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y3 = err
    } else {
        posX5y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y3 = err
    } else {
        posX6y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y3)
    shuffled.remove(posX5y3)
    shuffled.remove(posX6y3)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y3 = err
    } else {
        posX7y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y3)
    shuffled.remove(posX5y3)
    shuffled.remove(posX6y3)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y3 = err
    } else {
        posX8y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y3)
    shuffled.remove(posX2y3)
    shuffled.remove(posX3y3)
    shuffled.remove(posX4y3)
    shuffled.remove(posX5y3)
    shuffled.remove(posX6y3)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y3 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y3 = err
    } else {
        posX9y3 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* eliminate values - row 4 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y4 = err
    } else {
        posX1y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y4 = err
    } else {
        posX2y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    shuffled.remove(posX3y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y4 = err
    } else {
        posX3y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y4 = err
    } else {
        posX4y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y4 = err
    } else {
        posX5y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y4 = err
    } else {
        posX6y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y4)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y4 = err
    } else {
        posX7y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y4)
    shuffled.remove(posX7y4)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y4 = err
    } else {
        posX8y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y4)
    shuffled.remove(posX7y4)
    shuffled.remove(posX8y4)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    shuffled.remove(posX9y3)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y4 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y4 = err
    } else {
        posX9y4 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* eliminate values - row 5 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y5 = err
    } else {
        posX1y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX2y4)
    shuffled.remove(posX3y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y5 = err
    } else {
        posX2y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y5 = err
    } else {
        posX3y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX4y4)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y5 = err
    } else {
        posX4y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX5y4)
    shuffled.remove(posX6y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y5 = err
    } else {
        posX5y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    shuffled.remove(posX6y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y5 = err
    } else {
        posX6y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y5)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX7y4)
    shuffled.remove(posX8y4)
    shuffled.remove(posX9y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y5 = err
    } else {
        posX7y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y5)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    shuffled.remove(posX8y4)
    shuffled.remove(posX9y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y5 = err
    } else {
        posX8y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y5)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y5)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y5)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    shuffled.remove(posX9y3)
    shuffled.remove(posX9y4)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y5 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y5 = err
    } else {
        posX9y5 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* eliminate values - row 6 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX3y4)
    shuffled.remove(posX3y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y6 = err
    } else {
        posX1y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y6 = err
    } else {
        posX2y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX1y6)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    shuffled.remove(posX3y3)
    shuffled.remove(posX3y4)
    shuffled.remove(posX3y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y6 = err
    } else {
        posX3y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y6 = err
    } else {
        posX4y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y5)
    shuffled.remove(posX4y6)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y6 = err
    } else {
        posX5y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX4y6)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX5y6)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y6 = err
    } else {
        posX6y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y6)
    shuffled.remove(posX5y6)
    shuffled.remove(posX6y6)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y6 = err
    } else {
        posX7y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y6)
    shuffled.remove(posX5y6)
    shuffled.remove(posX6y6)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX7y6)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y6 = err
    } else {
        posX8y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y6)
    shuffled.remove(posX2y6)
    shuffled.remove(posX3y6)
    shuffled.remove(posX4y6)
    shuffled.remove(posX5y6)
    shuffled.remove(posX6y6)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX7y6)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX8y6)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y6 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y6 = err
    } else {
        posX9y6 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    /* eliminate values - row 7 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX1y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y7 = err
    } else {
        posX1y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX2y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y7 = err
    } else {
        posX2y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    shuffled.remove(posX3y3)
    shuffled.remove(posX3y4)
    shuffled.remove(posX3y5)
    shuffled.remove(posX3y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y7 = err
    } else {
        posX3y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX4y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y7 = err
    } else {
        posX4y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX5y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y7 = err
    } else {
        posX5y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    shuffled.remove(posX6y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y7 = err
    } else {
        posX6y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y7)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX7y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y7 = err
    } else {
        posX7y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y7)
    shuffled.remove(posX7y7)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX8y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y7 = err
    } else {
        posX8y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y7)
    shuffled.remove(posX7y7)
    shuffled.remove(posX8y7)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    shuffled.remove(posX9y3)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    shuffled.remove(posX9y6)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y7 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y7 = err
    } else {
        posX9y7 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* Grid08 eliminate values */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX1y6)
    shuffled.remove(posX1y7)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y8 = err
    } else {
        posX1y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX1y8)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX2y6)
    shuffled.remove(posX2y7)
    shuffled.remove(posX3y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y8 = err
    } else {
        posX2y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX1y8)
    shuffled.remove(posX2y7)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    shuffled.remove(posX3y3)
    shuffled.remove(posX3y4)
    shuffled.remove(posX3y5)
    shuffled.remove(posX3y6)
    shuffled.remove(posX3y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y8 = err
    } else {
        posX3y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX4y6)
    shuffled.remove(posX4y7)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y8 = err
    } else {
        posX4y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y7)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX5y6)
    shuffled.remove(posX5y7)
    shuffled.remove(posX6y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y8 = err
    } else {
        posX5y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y7)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y7)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    shuffled.remove(posX6y6)
    shuffled.remove(posX6y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y8 = err
    } else {
        posX6y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y8)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX7y6)
    shuffled.remove(posX7y7)
    shuffled.remove(posX8y7)
    shuffled.remove(posX9y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y8 = err
    } else {
        posX7y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y8)
    shuffled.remove(posX7y7)
    shuffled.remove(posX7y8)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX8y6)
    shuffled.remove(posX8y7)
    shuffled.remove(posX9y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y8 = err
    } else {
        posX8y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y8)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y8)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y8)
    shuffled.remove(posX7y8)
    shuffled.remove(posX8y7)
    shuffled.remove(posX8y8)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    shuffled.remove(posX9y3)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    shuffled.remove(posX9y6)
    shuffled.remove(posX9y7)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y8 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y8 = err
    } else {
        posX9y8 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* eliminate values - row 9 */
    shuffled.remove(posX1y1)
    shuffled.remove(posX1y2)
    shuffled.remove(posX1y3)
    shuffled.remove(posX1y4)
    shuffled.remove(posX1y5)
    shuffled.remove(posX1y6)
    shuffled.remove(posX1y7)
    shuffled.remove(posX1y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX1y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX1y9 = err
    } else {
        posX1y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX1y8)
    shuffled.remove(posX1y9)
    shuffled.remove(posX2y1)
    shuffled.remove(posX2y2)
    shuffled.remove(posX2y3)
    shuffled.remove(posX2y4)
    shuffled.remove(posX2y5)
    shuffled.remove(posX2y6)
    shuffled.remove(posX2y7)
    shuffled.remove(posX2y8)
    shuffled.remove(posX3y7)
    shuffled.remove(posX3y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX2y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX2y9 = err
    } else {
        posX2y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y7)
    shuffled.remove(posX1y8)
    shuffled.remove(posX1y9)
    shuffled.remove(posX2y7)
    shuffled.remove(posX2y8)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y1)
    shuffled.remove(posX3y2)
    shuffled.remove(posX3y3)
    shuffled.remove(posX3y4)
    shuffled.remove(posX3y5)
    shuffled.remove(posX3y6)
    shuffled.remove(posX3y7)
    shuffled.remove(posX3y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX3y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX3y9 = err
    } else {
        posX3y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y1)
    shuffled.remove(posX4y2)
    shuffled.remove(posX4y3)
    shuffled.remove(posX4y4)
    shuffled.remove(posX4y5)
    shuffled.remove(posX4y6)
    shuffled.remove(posX4y7)
    shuffled.remove(posX4y8)
    shuffled.remove(posX5y7)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y7)
    shuffled.remove(posX6y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX4y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX4y9 = err
    } else {
        posX4y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y7)
    shuffled.remove(posX4y8)
    shuffled.remove(posX4y9)
    shuffled.remove(posX5y1)
    shuffled.remove(posX5y2)
    shuffled.remove(posX5y3)
    shuffled.remove(posX5y4)
    shuffled.remove(posX5y5)
    shuffled.remove(posX5y6)
    shuffled.remove(posX5y7)
    shuffled.remove(posX5y8)
    shuffled.remove(posX6y7)
    shuffled.remove(posX6y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX5y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX5y9 = err
    } else {
        posX5y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y7)
    shuffled.remove(posX4y8)
    shuffled.remove(posX4y9)
    shuffled.remove(posX5y7)
    shuffled.remove(posX5y8)
    shuffled.remove(posX5y9)
    shuffled.remove(posX6y1)
    shuffled.remove(posX6y2)
    shuffled.remove(posX6y3)
    shuffled.remove(posX6y4)
    shuffled.remove(posX6y5)
    shuffled.remove(posX6y6)
    shuffled.remove(posX6y7)
    shuffled.remove(posX6y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX6y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX6y9 = err
    } else {
        posX6y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y9)
    shuffled.remove(posX5y9)
    shuffled.remove(posX6y9)
    shuffled.remove(posX7y1)
    shuffled.remove(posX7y2)
    shuffled.remove(posX7y3)
    shuffled.remove(posX7y4)
    shuffled.remove(posX7y5)
    shuffled.remove(posX7y6)
    shuffled.remove(posX7y7)
    shuffled.remove(posX7y8)
    shuffled.remove(posX8y7)
    shuffled.remove(posX8y8)
    shuffled.remove(posX9y7)
    shuffled.remove(posX9y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX7y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX7y9 = err
    } else {
        posX7y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y9)
    shuffled.remove(posX5y9)
    shuffled.remove(posX6y9)
    shuffled.remove(posX7y7)
    shuffled.remove(posX7y8)
    shuffled.remove(posX7y9)
    shuffled.remove(posX8y1)
    shuffled.remove(posX8y2)
    shuffled.remove(posX8y3)
    shuffled.remove(posX8y4)
    shuffled.remove(posX8y5)
    shuffled.remove(posX8y6)
    shuffled.remove(posX8y7)
    shuffled.remove(posX8y8)
    shuffled.remove(posX9y7)
    shuffled.remove(posX9y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX8y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX8y9 = err
    } else {
        posX8y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)

    shuffled.remove(posX1y9)
    shuffled.remove(posX2y9)
    shuffled.remove(posX3y9)
    shuffled.remove(posX4y9)
    shuffled.remove(posX5y9)
    shuffled.remove(posX6y9)
    shuffled.remove(posX7y7)
    shuffled.remove(posX7y8)
    shuffled.remove(posX7y9)
    shuffled.remove(posX8y7)
    shuffled.remove(posX8y8)
    shuffled.remove(posX8y9)
    shuffled.remove(posX9y1)
    shuffled.remove(posX9y2)
    shuffled.remove(posX9y3)
    shuffled.remove(posX9y4)
    shuffled.remove(posX9y5)
    shuffled.remove(posX9y6)
    shuffled.remove(posX9y7)
    shuffled.remove(posX9y8)
    if (shuffled.size > 1) {
        TrimToOneElement(shuffled)
        posX9y9 = shuffled.first()
    } else if (shuffled.isEmpty()) {
        posX9y9 = err
    } else {
        posX9y9 = shuffled.first()
    }
    ResetShuffled(shuffled, numbers)


    /* assign values to GridCells */

    /* row 01 */
    /* x1y1 - Grid1 TopLeft */
    val x1y1 =
        GridCell(
            xPosition = 1,
            yPosition = 1,
            value = posX1y1,
            txtColour = Black,
            hidden = false
        )

    /* x2y1 - Grid1 TopLeft */
    val x2y1 =
        GridCell(
            xPosition = 2,
            yPosition = 1,
            value = posX2y1,
            txtColour = Black,
            hidden = false
        )

    /* x3y1 - Grid1 TopLeft */
    val x3y1 =
        GridCell(
            xPosition = 3,
            yPosition = 1,
            value = posX3y1,
            txtColour = Black,
            hidden = false
        )

    /* x4y1 - Grid2 TopCenter */
    val x4y1 =
        GridCell(
            xPosition = 4,
            yPosition = 1,
            value = posX4y1,
            txtColour = Red,
            hidden = false
        )

    /* x5y1 - Grid2 TopCenter */
    val x5y1 =
        GridCell(
            xPosition = 5,
            yPosition = 1,
            value = posX5y1,
            txtColour = Red,
            hidden = false
        )

    /* x6y1 - Grid2 TopCenter */
    val x6y1 =
        GridCell(
            xPosition = 6,
            yPosition = 1,
            value = posX6y1,
            txtColour = Red,
            hidden = false
        )

    /* x7y1 - Grid3 TopRight */
    val x7y1 =
        GridCell(
            xPosition = 7,
            yPosition = 1,
            value =
                posX7y1,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x8y1 - Grid3 TopRight */
    val x8y1 =
        GridCell(
            xPosition = 8,
            yPosition = 1,
            value = posX8y1,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x9y1 - Grid3 TopRight */
    val x9y1 =
        GridCell(
            xPosition = 9,
            yPosition = 1,
            value = posX9y1,
            txtColour = NeonGreen,
            hidden = false
        )

    /* column 01 */
    /* x1y2 - Grid1 TopLeft */
    val x1y2 =
        GridCell(
            xPosition = 1,
            yPosition = 2,
            value = posX1y2,
            txtColour = Black,
            hidden = false
        )

    /* x1y3 - Grid1 TopLeft */
    val x1y3 =
        GridCell(
            xPosition = 1,
            yPosition = 3,
            value = posX1y3,
            txtColour = Black,
            hidden = false
        )

    /* x1y4 - Grid4 MiddleLeft */
    val x1y4 =
        GridCell(
            xPosition = 1,
            yPosition = 4,
            value = posX1y4,
            txtColour = Blue,
            hidden = false
        )

    /* x1y5 - Grid4 MiddleLeft */
    val x1y5 =
        GridCell(
            xPosition = 1,
            yPosition = 5,
            value = posX1y5,
            txtColour = Blue,
            hidden = false
        )

    /* x1y6 - Grid4 MiddleLeft */
    val x1y6 =
        GridCell(
            xPosition = 1,
            yPosition = 6,
            value = posX1y6,
            txtColour = Blue,
            hidden = false
        )

    /* x1y7 - Grid7 BottomLeft */
    val x1y7 =
        GridCell(
            xPosition = 1,
            yPosition = 7,
            value = posX1y7,
            txtColour = Purple40,
            hidden = false
        )

    /* x1y8 - Grid7 BottomLeft */
    val x1y8 =
        GridCell(
            xPosition = 1,
            yPosition = 8,
            value = posX1y8,
            txtColour = Purple40,
            hidden = false
        )

    /* x1y9 - Grid7 BottomLeft */
    val x1y9 =
        GridCell(
            xPosition = 1,
            yPosition = 9,
            value = posX1y9,
            txtColour = Purple40,
            hidden = false
        )

    /* Grid1 TopLeft */
    /* row 02 */
    /* x2y2 - Grid1 TopLeft */
    val x2y2 =
        GridCell(
            xPosition = 2,
            yPosition = 2,
            value = posX2y2,
            txtColour = Black,
            hidden = false
        )

    /* x3y2 - Grid1 TopLeft */
    val x3y2 =
        GridCell(
            xPosition = 3,
            yPosition = 2,
            value = posX3y2,
            txtColour = Black,
            hidden = false
        )

    /* row 3 */
    /* x2y3 - Grid1 TopLeft */
    val x2y3 =
        GridCell(
            xPosition = 2,
            yPosition = 3,
            value = posX2y3,
            txtColour = Black,
            hidden = false
        )

    /* x3y3 - Grid1 TopLeft */
    val x3y3 =
        GridCell(
            xPosition = 3,
            yPosition = 3,
            value = posX3y3,
            txtColour = Black,
            hidden = false
        )

    /* Grid2 TopCenter */
    /* row 2 */
    /* x4y2 - Grid2 TopCenter */
    val x4y2 =
        GridCell(
            xPosition = 4,
            yPosition = 2,
            value = posX4y2,
            txtColour = Red,
            hidden = false
        )

    /* x5y2 - Grid2 TopCenter */
    val x5y2 =
        GridCell(
            xPosition = 5,
            yPosition = 2,
            value = posX5y2,
            txtColour = Red,
            hidden = false
        )

    /* x6y2 - Grid2 TopCenter */
    val x6y2 =
        GridCell(
            xPosition = 6,
            yPosition = 2,
            value = posX6y2,
            txtColour = Red,
            hidden = false
        )

    /* Grid2 TopCenter */
    /* row 3 */
    /* x4y3 - Grid2 TopCenter */
    val x4y3 =
        GridCell(
            xPosition = 4,
            yPosition = 3,
            value = posX4y3,
            txtColour = Red,
            hidden = false
        )

    /* x5y3 - Grid2 TopCenter */
    val x5y3 =
        GridCell(
            xPosition = 5,
            yPosition = 3,
            value = posX5y3,
            txtColour = Red,
            hidden = false
        )

    /* x6y3 - Grid2 TopCenter */
    val x6y3 =
        GridCell(
            xPosition = 6,
            yPosition = 3,
            value = posX6y3,
            txtColour = Red,
            hidden = false
        )

    /* Grid3 TopRight */
    /* row 2 */
    /* x7y2 - Grid3 TopRight */
    val x7y2 =
        GridCell(
            xPosition = 7,
            yPosition = 2,
            value = posX7y2,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x8y2 - Grid3 TopRight */
    val x8y2 =
        GridCell(
            xPosition = 8,
            yPosition = 2,
            value = posX8y2,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x9y2 - Grid3 TopRight */
    val x9y2 =
        GridCell(
            xPosition = 9,
            yPosition = 2,
            value = posX9y2,
            txtColour = NeonGreen,
            hidden = false
        )

    /* row 3 */
    /* x7y3 - Grid3 TopRight */
    val x7y3 =
        GridCell(
            xPosition = 7,
            yPosition = 3,
            value = posX7y3,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x8y3 - Grid3 TopRight */
    val x8y3 =
        GridCell(
            xPosition = 8,
            yPosition = 3,
            value = posX8y3,
            txtColour = NeonGreen,
            hidden = false
        )

    /* x9y3 - Grid3 TopRight */
    val x9y3 =
        GridCell(
            xPosition = 9,
            yPosition = 3,
            value = posX9y3,
            txtColour = NeonGreen,
            hidden = false
        )

    /* Grid4 MiddleLeft */
    /* row 4 */
    /* x2y4 - Grid4 MiddleLeft */
    val x2y4 =
        GridCell(
            xPosition = 2,
            yPosition = 4,
            value = posX2y4,
            txtColour = Blue,
            hidden = false
        )

    /* x3y4 - Grid4 MiddleLeft */
    val x3y4 =
        GridCell(
            xPosition = 3,
            yPosition = 4,
            value = posX3y4,
            txtColour = Blue,
            hidden = false
        )

    /* row 2 */
    /* x2y5 - Grid4 MiddleLeft */
    val x2y5 =
        GridCell(
            xPosition = 2,
            yPosition = 5,
            value = posX2y5,
            txtColour = Blue,
            hidden = false
        )

    /* x3y5 - Grid4 MiddleLeft */
    val x3y5 =
        GridCell(
            xPosition = 3,
            yPosition = 5,
            value = posX3y5,
            txtColour = Blue,
            hidden = false
        )

    /* x2y6 - Grid4 MiddleLeft */
    val x2y6 =
        GridCell(
            xPosition = 2,
            yPosition = 6,
            value = posX2y6,
            txtColour = Blue,
            hidden = false
        )

    /* x3y6 - Grid4 MiddleLeft */
    val x3y6 =
        GridCell(
            xPosition = 3,
            yPosition = 6,
            value = posX3y6,
            txtColour = Blue,
            hidden = false
        )

    /* Grid5 Center */
    /* row 4 */
    /* x4y4 - Grid5 Center */
    val x4y4 =
        GridCell(
            xPosition = 4,
            yPosition = 4,
            value = posX4y4,
            txtColour = Gold,
            hidden = false
        )

    /* x5y4 - Grid5 Center */
    val x5y4 =
        GridCell(
            xPosition = 5,
            yPosition = 4,
            value = posX5y4,
            txtColour = Gold,
            hidden = false
        )


    /* x6y4 - Grid5 Center */
    val x6y4 =
        GridCell(
            xPosition = 6,
            yPosition = 4,
            value = posX6y4,
            txtColour = Gold,
            hidden = false
        )


    /* row 5 */
    /* x4y5 - Grid5 Center */
    val x4y5 =
        GridCell(
            xPosition = 4,
            yPosition = 5,
            value = posX4y5,
            txtColour = Gold,
            hidden = false
        )


    /* x5y5 - Grid5 Center */
    val x5y5 =
        GridCell(
            xPosition = 5,
            yPosition = 5,
            value = posX5y5,
            txtColour = Gold,
            hidden = false
        )

    /* x6y5 - Grid5 Center */
    val x6y5 =
        GridCell(
            xPosition = 6,
            yPosition = 5,
            value = posX6y5,
            txtColour = Gold,
            hidden = false
        )

    /* row 6 */
    /* x4y6 - Grid5 Center */
    val x4y6 =
        GridCell(
            xPosition = 4,
            yPosition = 6,
            value = posX4y6,
            txtColour = Gold,
            hidden = false
        )

    /* x5y6 - Grid5 Center */
    val x5y6 =
        GridCell(
            xPosition = 5,
            yPosition = 6,
            value = posX5y6,
            txtColour = Gold,
            hidden = false
        )

    /* x6y6 - Grid5 Center */
    val x6y6 =
        GridCell(
            xPosition = 6,
            yPosition = 6,
            value = posX6y6,
            txtColour = Gold,
            hidden = false
        )

    /* Grid6 MiddleRight */
    /* row 4 */
    /* x7y4 - Grid6 MiddleRight */
    val x7y4 =
        GridCell(
            xPosition = 7,
            yPosition = 4,
            value = posX7y4,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x8y4 - Grid6 MiddleRight */
    val x8y4 =
        GridCell(
            xPosition = 8,
            yPosition = 4,
            value = posX8y4,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x9y4 - Grid6 MiddleRight */
    val x9y4 =
        GridCell(
            xPosition = 9,
            yPosition = 4,
            value = posX9y4,
            txtColour = DarkGrey,
            hidden = false
        )

    /* row 5 */
    /* x7y5 - Grid6 MiddleRight */
    val x7y5 =
        GridCell(
            xPosition = 7,
            yPosition = 5,
            value = posX7y5,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x8y5 - Grid6 MiddleRight */
    val x8y5 =
        GridCell(
            xPosition = 8,
            yPosition = 5,
            value = posX8y5,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x9y5 - Grid6 MiddleRight */
    val x9y5 =
        GridCell(
            xPosition = 9,
            yPosition = 5,
            value = posX9y5,
            txtColour = DarkGrey,
            hidden = false
        )

    /* row 6 */
    /* x7y6 - Grid6 MiddleRight */
    val x7y6 =
        GridCell(
            xPosition = 7,
            yPosition = 6,
            value = posX7y6,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x8y6 - Grid6 MiddleRight */
    val x8y6 =
        GridCell(
            xPosition = 8,
            yPosition = 6,
            value = posX8y6,
            txtColour = DarkGrey,
            hidden = false
        )

    /* x9y6 - Grid6 MiddleRight */
    val x9y6 =
        GridCell(
            xPosition = 8,
            yPosition = 6,
            value = posX9y6,
            txtColour = DarkGrey,
            hidden = false
        )

    /* Grid7 BottomLeft */
    /* row 7 */
    /* x2y7 - Grid7 BottomLeft */
    val x2y7 =
        GridCell(
            xPosition = 2,
            yPosition = 7,
            value = posX2y7,
            txtColour = Purple40,
            hidden = false
        )

    /* x3y7 - Grid7 BottomLeft */
    val x3y7 =
        GridCell(
            xPosition = 3,
            yPosition = 7,
            value = posX3y7,
            txtColour = Purple40,
            hidden = false
        )

    /* row 8 */
    /* x2y8 - Grid7 BottomLeft */
    val x2y8 =
        GridCell(
            xPosition = 2,
            yPosition = 8,
            value = posX2y8,
            txtColour = Purple40,
            hidden = false
        )

    /* x3y8 - Grid7 BottomLeft */
    val x3y8 =
        GridCell(
            xPosition = 3,
            yPosition = 8,
            value = posX3y8,
            txtColour = Purple40,
            hidden = false
        )

    /* row 9 */
    /* x2y9 - Grid7 BottomLeft */
    val x2y9 =
        GridCell(
            xPosition = 2,
            yPosition = 9,
            value = posX2y9,
            txtColour = Purple40,
            hidden = false
        )

    /* x3y9 - Grid7 BottomLeft */
    val x3y9 =
        GridCell(
            xPosition = 3,
            yPosition = 9,
            value = posX3y9,
            txtColour = Purple40,
            hidden = false
        )

    /* Grid8 BottomCenter */
    /* row 7 */
    /* x4y7 - Grid8 BottomCenter */
    val x4y7 =
        GridCell(
            xPosition = 4,
            yPosition = 7,
            value = posX4y7,
            txtColour = MathBlue,
            hidden = false
        )

    /* x5y7 - Grid8 BottomCenter */
    val x5y7 =
        GridCell(
            xPosition = 5,
            yPosition = 7,
            value = posX5y7,
            txtColour = MathBlue,
            hidden = false
        )

    /* x6y7 - Grid8 BottomCenter */
    val x6y7 =
        GridCell(
            xPosition = 6,
            yPosition = 7,
            value = posX6y7,
            txtColour = MathBlue,
            hidden = false
        )

    /* row 8 */
    /* x4y8 - Grid8 BottomCenter */
    val x4y8 =
        GridCell(
            xPosition = 4,
            yPosition = 8,
            value = posX4y8,
            txtColour = MathBlue,
            hidden = false
        )

    /* x5y8 - Grid8 BottomCenter */
    val x5y8 =
        GridCell(
            xPosition = 5,
            yPosition = 8,
            value = posX5y8,
            txtColour = MathBlue,
            hidden = false
        )

    /* x6y8 - Grid8 BottomCenter */
    val x6y8 =
        GridCell(
            xPosition = 6,
            yPosition = 8,
            value = posX6y8,
            txtColour = MathBlue,
            hidden = false
        )

    /* row 9 */
    /* x4y9 - Grid8 BottomCenter */
    val x4y9 =
        GridCell(
            xPosition = 4,
            yPosition = 9,
            value = posX4y9,
            txtColour = MathBlue,
            hidden = false
        )

    /* x5y9 - Grid8 BottomCenter */
    val x5y9 =
        GridCell(
            xPosition = 5,
            yPosition = 9,
            value = posX5y9,
            txtColour = MathBlue,
            hidden = false
        )

    /* x6y9 - Grid8 BottomCenter */
    val x6y9 =
        GridCell(
            xPosition = 5,
            yPosition = 9,
            value = posX6y9,
            txtColour = MathBlue,
            hidden = false
        )

    /* Grid9 BottomRight */
    /* row 7 */
    /* x7y7 - Grid9 BottomRight */
    val x7y7 =
        GridCell(
            xPosition = 7,
            yPosition = 7,
            value = posX7y7,
            txtColour = Pink,
            hidden = false
        )

    /* x8y7 - Grid9 BottomRight */
    val x8y7 =
        GridCell(
            xPosition = 8,
            yPosition = 7,
            value = posX8y7,
            txtColour = Pink,
            hidden = false
        )

    /* x9y7 - Grid9 BottomRight */
    val x9y7 =
        GridCell(
            xPosition = 9,
            yPosition = 7,
            value = posX9y7,
            txtColour = Pink,
            hidden = false
        )

    /* row 8 */
    /* x7y8 - Grid9 BottomRight */
    val x7y8 =
        GridCell(
            xPosition = 7,
            yPosition = 8,
            value = posX7y8,
            txtColour = Pink,
            hidden = false
        )

    /* x8y8 - Grid9 BottomRight */
    val x8y8 =
        GridCell(
            xPosition = 8,
            yPosition = 8,
            value = posX8y8,
            txtColour = Pink,
            hidden = false
        )

    /* x9y8 - Grid9 BottomRight */
    val x9y8 =
        GridCell(
            xPosition = 9,
            yPosition = 8,
            value = posX9y8,
            txtColour = Pink,
            hidden = false
        )

    /* row 9 */
    /* x7y9 - Grid9 BottomRight */
    val x7y9 =
        GridCell(
            xPosition = 7,
            yPosition = 9,
            value = posX7y9,
            txtColour = Pink,
            hidden = false
        )

    /* x8y9 - Grid9 BottomRight */
    val x8y9 =
        GridCell(
            xPosition = 8,
            yPosition = 9,
            value = posX8y9,
            txtColour = Pink,
            hidden = false
        )

    /* x9y9 - Grid9 BottomRight */
    val x9y9 =
        GridCell(
            xPosition = 9,
            yPosition = 9,
            value = posX9y9,
            txtColour = Pink,
            hidden = false
        )

    /* Begin Layout */

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.size(
                5.dp
            )
        )
        // Text("Grid# $grid")
        Text(
            "idx# $xValue"
        )
        // Text("Shuffled: $shuffled  size: ${shuffled.size}")
        // Text("ThisShuffled: $thisShuffled  size: ${thisShuffled.size}")
        if (debug) {
            Text(
                "tmpSlice: $trimmedShuffle  size: ${trimmedShuffle.size}"
            )
        }
        Text(
            "Slice1: $slice1  size: ${slice1.size}"
        )
        Text(
            "Slice2: $slice2  size: ${slice2.size}"
        )
        Text(
            "Slice3: $slice3  size: ${slice3.size}"
        )
        // Text("Slice2 $slice2")
        // Text("Slice2: $tmpSlice2  size: ${tmpSlice2.size}")
        Spacer(
            modifier = Modifier.size(
                5.dp
            )
        )

        var idx =
            0



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

        Spacer(
            modifier = Modifier.size(
                10.dp
            )
        )
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
    slice1.forEach {
        tmpSlice.add(
            it
        )
    }
    tmpSlice.remove(
        slice1.first()
    )
    tmpSlice.remove(
        slice1.last()
    )
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
    slice2.forEach {
        tmpSlice.add(
            it
        )
    }
    tmpSlice.remove(
        slice2.first()
    )
    tmpSlice.remove(
        slice2.last()
    )
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
    slice3.forEach {
        tmpSlice.add(
            it
        )
    }
    tmpSlice.remove(
        slice3.first()
    )
    tmpSlice.remove(
        slice3.last()
    )
    return tmpSlice.random()
}

/**
 * The input list is "reset" using list.clear() before being populated from the source list.
 * @param[inputList] list to be reset (cleared then shuffled)
 * @param numbers source list used to populate the inputList
 * */
@Composable
fun ResetShuffled(
    inputList: MutableList<Int>,
    numbers: MutableList<Int>
) {
    inputList.clear()
    numbers.forEach {
        inputList.add(
            it
        )
    }
    inputList.shuffle()
}

/**
 * The input list is "reset" using list.clear() before being populated from the source list.
 * @param[inputList] list to be reset (cleared then shuffled)
 * */
@Composable
fun ResetShuffled(
    inputList: MutableList<Int>
) {
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    inputList.clear()
    numbers.forEach {
        inputList.add(
            it
        )
    }
    inputList.shuffle()
}

@Preview(
    showBackground = true
)
@Composable
fun AppCorePreview() {
    DrakesSudokuTheme {
        AppCore()
    }
}