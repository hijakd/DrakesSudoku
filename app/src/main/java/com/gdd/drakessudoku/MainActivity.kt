package com.gdd.drakessudoku

import android.os.Bundle
import android.util.Log
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
import com.gdd.drakessudoku.utils.findXValue
import com.gdd.drakessudoku.utils.selectXValue

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


    /* step 01 - row 01 */
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
    if (shuffled.last() == x9y1.value) {
        shuffled.shuffle()
    }

    /* step 02 - column 01 */
    /* x1y2 -> x1y9 */
    /* x1y2 - Grid1 TopLeft */
    val x1y2 = GridCell(
        xPosition = 1,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x2y1, x3y1),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x1y2.value)

    /* x1y3 - Grid1 TopLeft */
    val x1y3 = GridCell(
        xPosition = 1,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x1y2, x2y1, x3y1),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x1y3.value)

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
    shuffled.remove(x1y2.value)

    /* step 03 - row 02 */
    /* x2y2 - Grid1 TopLeft */
    val x2y2 = GridCell(
        xPosition = 2,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x1y1, x1y3, x2y1, x3y1),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x2y2.value)

    /* x3y2 - Grid1 TopLeft */
    val x3y2 = GridCell(
        xPosition = 3,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x1y1, x1y3, x2y1, x3y1),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x3y2.value)

    /* x4y2 - Grid2 TopCenter */
    val x4y2 = GridCell(
        xPosition = 4,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x4y1, x5y1, x6y1),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x4y2.value)

    /* x5y2 - Grid2 TopCenter */
    val x5y2 = GridCell(
        xPosition = 5,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x4y1, x5y1, x6y1),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x5y2.value)

    /* x6y2 - Grid2 TopCenter */
    val x6y2 = GridCell(
        xPosition = 6,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x4y1, x5y1, x6y1),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x6y2.value)
    // FilterList(shuffled, x1y2, x2y2, x3y2, x4y2, x5y2, x6y2)

    /* x7y2 - Grid3 TopRight */
    val x7y2 = GridCell(
        xPosition = 7,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x7y1, x8y1, x9y1),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x7y2.value)

    /* x8y2 - Grid3 TopRight */
    val x8y2 = GridCell(
        xPosition = 8,
        yPosition = 2,
        value = findXValue(shuffled, tmpSlice, x7y1, x8y1, x9y1),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x8y2.value)

    /* x9y2 - Grid3 TopRight */
    val x9y2 = GridCell(
        xPosition = 9,
        yPosition = 2,
        value = if (shuffled.isEmpty()) {
            Log.d("cactus", "step 03 - row 02: selecting row09 X")
            selectXValue(x1y2, x2y2, x3y2, x4y2, x5y2, x6y2, x7y1, x7y2, x8y1, x8y2, x9y1)
        } else {
            Log.d("cactus", "step 03 - row 02: finding row09 X")
            findXValue(shuffled, tmpSlice, x7y1, x7y2, x8y1, x9y1)
        },
        txtColour = NeonGreen,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x2y1, x2y2)

    /* step 04 - column 02 */
    /* x2y3 - Grid1 TopLeft */
    val x2y3 = GridCell(
        xPosition = 2,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x1y1, x1y2, x1y3, x3y1, x3y2),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x2y3.value)

    ResetShuffled(slice1, shuffled)
    FilterList(slice1, x1y4, x1y5, x1y6)

    /* x2y4 - Grid4 MiddleLeft */
    val x2y4 = GridCell(
        xPosition = 2,
        yPosition = 4,
        // value = findXValue(slice1, tmpSlice, x2y1, x2y2, x2y3),
        value = slice1.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x2y4.value)

    /* x2y5 - Grid4 MiddleLeft */
    val x2y5 = GridCell(
        xPosition = 2,
        yPosition = 5,
        // value = findXValue(slice1, tmpSlice, x2y1, x2y2, x2y3, x2y4),
        value = slice1.first(),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x2y5.value)

    /* x2y6 - Grid4 MiddleLeft */
    val x2y6 = GridCell(
        xPosition = 2,
        yPosition = 6,
        value = findXValue(slice1, tmpSlice, x2y1, x2y2, x2y3, x2y4, x2y5),
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x2y6.value)
    FilterList(shuffled, x2y1, x2y2, x2y3, x2y4, x2y5, x2y6)

    /* x2y7 - Grid7 BottomLeft */
    val x2y7 = GridCell(
        xPosition = 2,
        yPosition = 7,
        value = findXValue(shuffled, tmpSlice, x1y7, x1y8, x1y9),
        txtColour = Purple40,
        hidden = false
    )

    /* x2y8 - Grid7 BottomLeft */
    val x2y8 = GridCell(
        xPosition = 2,
        yPosition = 8,
        value = findXValue(shuffled, tmpSlice, x1y7, x1y8, x1y9, x2y7),
        txtColour = Purple40,
        hidden = false
    )

    /* x2y9 - Grid7 BottomLeft */
    val x2y9 = GridCell(
        xPosition = 2,
        yPosition = 9,
        value = findXValue(shuffled, tmpSlice, x1y7, x1y8, x1y9, x2y7, x2y8),
        txtColour = Purple40,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    ResetShuffled(slice1, shuffled)
    /* eliminate previously assigned values of Grid01 */
    FilterList(slice1, x1y1, x1y2, x1y3, x2y1, x2y2, x2y3, x3y1, x3y2)

    /* step 05 - row 03 */
    /* x3y3 - Grid1 TopLeft */
    val x3y3 = GridCell(
        xPosition = 3,
        yPosition = 3,
        value = slice1.first(),
        txtColour = Black,
        hidden = false
    )
    FilterList(shuffled, x3y1, x3y2, x3y3)

    /* x4y3 - Grid2 TopCenter */
    val x4y3 = GridCell(
        xPosition = 4,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x4y1, x4y2, x5y1, x5y2, x6y1, x6y2),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x4y3.value)

    /* x5y3 - Grid2 TopCenter */
    val x5y3 = GridCell(
        xPosition = 5,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x4y1, x4y2, x5y1, x5y2, x6y1, x6y2),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x5y3.value)

    /* x6y3 - Grid2 TopCenter */
    val x6y3 = GridCell(
        xPosition = 6,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x4y1, x4y2, x5y1, x5y2, x6y1, x6y2),
        txtColour = Red,
        hidden = false
    )
    shuffled.remove(x6y3.value)

    /* x7y3 - Grid3 TopRight */
    val x7y3 = GridCell(
        xPosition = 7,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x7y1, x7y2, x8y1, x8y2, x9y1, x9y2),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x7y3.value)

    /* x8y3 - Grid3 TopRight */
    val x8y3 = GridCell(
        xPosition = 8,
        yPosition = 3,
        value = findXValue(shuffled, tmpSlice, x7y1, x7y2, x8y1, x8y2, x9y1, x9y2),
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x8y3.value)

    /* x9y3 - Grid3 TopRight */
    val x9y3 = GridCell(
        xPosition = 9,
        yPosition = 3,
        // value = findXValue(shuffled, tmpSlice, x7y1, x7y2, x8y1, x8y2, x9y1, x9y2),
        value = if (shuffled.isEmpty()){
            Log.d("cactus", "step 05 - row 03: selecting col09 X")
            selectXValue(x7y1, x7y2, x7y3, x8y1, x8y2, x8y3, x9y1, x9y2)
        } else {
            Log.d("cactus", "step 05 - row 03: finding col09 X")
            findXValue(shuffled, tmpSlice, x7y1, x7y2, x8y1, x8y2, x9y1, x9y2)
        },
        txtColour = NeonGreen,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    // FilterList(shuffled, x3y1, x3y2, x3y3)
    ResetShuffled(slice1, shuffled)
    FilterList(slice1, x1y4, x1y5, x1y6, x2y4, x2y5, x2y6)

    /* step 06 - column 03 */
    /* x3y4 - Grid4 MiddleLeft */
    val x3y4 = GridCell(
        xPosition = 3,
        yPosition = 4,
        value = findXValue(slice1, tmpSlice, x3y1, x3y2, x3y3),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x3y4.value)

    /* x3y5 - Grid4 MiddleLeft */
    val x3y5 = GridCell(
        xPosition = 3,
        yPosition = 5,
        value = findXValue(slice1, tmpSlice, x3y1, x3y2, x3y3),
        txtColour = Blue,
        hidden = false
    )
    slice1.remove(x3y5.value)

    /* x3y6 - Grid4 MiddleLeft */
    val x3y6 = GridCell(
        xPosition = 3,
        yPosition = 6,
        // value = findXValue(slice1, tmpSlice, x3y1, x3y2, x3y3),
        value = if (shuffled.isEmpty()) {
            Log.d("cactus", "step 06 - col 03: selecting row06 X")
            selectXValue(x1y4, x1y5, x1y6, x2y4, x2y5, x2y6, x3y1, x3y2, x3y3, x3y4, x3y5)
        } else {
            Log.d("cactus", "step 06 - col 03: finding row06 X")
            findXValue(slice1, tmpSlice, x3y1, x3y2, x3y3)
        },
        txtColour = Blue,
        hidden = false
    )

    ResetShuffled(slice2, shuffled)
    FilterList(slice2, x1y7, x1y8, x1y9, x2y7, x2y8, x2y9)

    /* x3y7 - Grid7 BottomLeft */
    val x3y7 = GridCell(
        xPosition = 3,
        yPosition = 7,
        value = findXValue(slice2, tmpSlice, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6),
        txtColour = Purple40,
        hidden = false
    )
    slice2.remove(x3y7.value)

    /* x3y8 - Grid7 BottomLeft */
    val x3y8 = GridCell(
        xPosition = 3,
        yPosition = 8,
        value = findXValue(slice2, tmpSlice, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6),
        txtColour = Purple40,
        hidden = false
    )
    slice2.remove(x3y8.value)

    /* x3y9 - Grid7 BottomLeft */
    val x3y9 = GridCell(
        xPosition = 3,
        yPosition = 9,
        // value = findXValue(slice2, tmpSlice, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6),
        value = if (slice2.isEmpty()){
            Log.d("cactus", "step 06 - col 03: selecting row09 X")
            selectXValue(x1y7, x1y8, x1y9, x2y7, x2y8, x2y9, x3y7, x3y8)
        } else {
            Log.d("cactus", "step 06 - col 03: finding row09 X")
            findXValue(slice2, tmpSlice, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6)
        },
        txtColour = Purple40,
        hidden = false
    )

    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x1y4, x2y4, x3y4)

    /* step 07 - row 04 */
    /* x4y4 - Grid5 Center */
    val x4y4 = GridCell(
        xPosition = 4,
        yPosition = 4,
        value = findXValue(shuffled, tmpSlice, x4y1, x4y2, x4y3),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y4.value)

    /* x5y4 - Grid5 Center */
    val x5y4 = GridCell(
        xPosition = 5,
        yPosition = 4,
        value = findXValue(shuffled, tmpSlice, x5y1, x5y2, x5y3),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y4.value)

    /* x6y4 - Grid5 Center */
    val x6y4 = GridCell(
        xPosition = 6,
        yPosition = 4,
        value = findXValue(shuffled, tmpSlice, x6y1, x6y2, x6y3),
        txtColour = Gold,
        hidden = false
    )

    ResetShuffled(slice1, numbers)
    FilterList(slice1, x1y4, x2y4, x3y4, x4y4, x5y4, x6y4)

    /* x7y4 - Grid6 MiddleRight */
    val x7y4 = GridCell(
        xPosition = 7,
        yPosition = 4,
        value = findXValue(slice1, tmpSlice, x7y1, x7y2, x7y3),
        txtColour = DarkGrey,
        hidden = false
    )
    slice1.remove(x7y4.value)

    /* x8y4 - Grid6 MiddleRight */
    val x8y4 = GridCell(
        xPosition = 8,
        yPosition = 4,
        value = findXValue(slice1, tmpSlice, x8y1, x8y2, x8y3),
        txtColour = DarkGrey,
        hidden = false
    )
    slice1.remove(x8y4.value)

    /* x9y4 - Grid6 MiddleRight */
    val x9y4 = GridCell(
        xPosition = 9,
        yPosition = 4,
        value = findXValue(slice1, tmpSlice, x9y1, x9y2, x9y3),
        txtColour = DarkGrey,
        hidden = false
    )

    /* column 04 */
    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x4y1, x4y2, x4y3, x4y4)

    /* x4y5 - Grid5 Center */
    val x4y5 = GridCell(
        xPosition = 4,
        yPosition = 5,
        value = findXValue(shuffled, tmpSlice, x1y5, x2y5, x3y5, x5y4, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y5.value)

    /* x4y6 - Grid5 Center */
    val x4y6 = GridCell(
        xPosition = 4,
        yPosition = 6,
        value = findXValue(shuffled, tmpSlice, x1y6, x2y6, x3y6, x5y4, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y6.value)

    /* x4y7 - Grid8 BottomCenter */
    val x4y7 = GridCell(
        xPosition = 4,
        yPosition = 7,
        value = findXValue(shuffled, tmpSlice, x1y7, x2y7, x3y7),
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x4y7.value)

    /* x4y8 - Grid8 BottomCenter */
    val x4y8 = GridCell(
        xPosition = 4,
        yPosition = 8,
        value = findXValue(shuffled, tmpSlice, x1y8, x2y8, x3y8),
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x4y8.value)

    /* x4y9 - Grid8 BottomCenter */
    val x4y9 = GridCell(
        xPosition = 4,
        yPosition = 9,
        value = findXValue(shuffled, tmpSlice, x1y9, x2y9, x3y9),
        txtColour = MathBlue,
        hidden = false
    )

    /* row 05 */
    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x1y5, x2y5, x3y5, x4y5)

    /* x5y5 - Grid5 Center */
    val x5y5 = GridCell(
        xPosition = 5,
        yPosition = 5,
        value = findXValue(shuffled, tmpSlice, x4y4, x4y5, x4y6, x5y1, x5y2, x5y3, x5y4, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y5.value)

    /* x6y5 - Grid5 Center */
    val x6y5 = GridCell(
        xPosition = 6,
        yPosition = 5,
        value = findXValue(shuffled, tmpSlice, x4y4, x4y6, x5y4, x6y1, x6y2, x6y3, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x6y5.value)

    /* x7y5 - Grid6 MiddleRight */
    val x7y5 = GridCell(
        xPosition = 7,
        yPosition = 5,
        value = findXValue(shuffled, tmpSlice, x7y1, x7y2, x7y3, x7y4, x8y4, x9y4),
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x7y5.value)

    /* x8y5 - Grid6 MiddleRight */
    val x8y5 = GridCell(
        xPosition = 8,
        yPosition = 5,
        value = findXValue(shuffled, tmpSlice, x8y1, x8y2, x8y3, x7y4, x8y4, x9y4),
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x8y5.value)

    /* x9y5 - Grid6 MiddleRight */
    val x9y5 = GridCell(
        xPosition = 9,
        yPosition = 5,
        // value = findXValue(shuffled, tmpSlice, x7y4, x8y4, x9y1, x9y2, x9y3, x9y4),
        value = 0,
        txtColour = DarkGrey,
        hidden = false
    )

    /* step 08 - column 05 */
    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x5y1, x5y2, x5y3, x5y4, x5y5)

    /* x5y6 - Grid5 Center */
    val x5y6 = GridCell(
        xPosition = 5,
        yPosition = 6,
        value = findXValue(shuffled, tmpSlice, x1y5, x2y5, x3y5, x4y4, x4y5, x4y6, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y6.value)

    /* x5y7 - Grid8 BottomCenter */
    val x5y7 = GridCell(
        xPosition = 5,
        yPosition = 7,
        value = findXValue(shuffled, tmpSlice, x1y7, x2y7, x3y7, x4y7, x4y8, x4y9),
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x5y7.value)

    /* x5y8 - Grid8 BottomCenter */
    val x5y8 = GridCell(
        xPosition = 5,
        yPosition = 8,
        value = findXValue(shuffled, tmpSlice, x1y8, x2y8, x3y8, x4y7, x4y8, x4y9),
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x5y8.value)

    /* x5y9 - Grid8 BottomCenter */
    val x5y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        // value = findXValue(shuffled, tmpSlice, x1y9, x2y9, x3y9, x4y9),
        value = 0,
        txtColour = MathBlue,
        hidden = false
    )

    /* step 09 - row 06 */
    ResetShuffled(shuffled, numbers)
    FilterList(shuffled, x1y6, x2y6, x3y6, x4y6, x5y6)

    /* x6y6 - Grid5 Center */
    val x6y6 = GridCell(
        xPosition = 6,
        yPosition = 6,
        value = findXValue(shuffled, tmpSlice, x4y4, x4y5, x5y4, x5y5, x6y1, x6y2, x6y3, x6y4),
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x6y6.value)

    /* x7y6 - Grid6 MiddleRight */
    val x7y6 = GridCell(
        xPosition = 7,
        yPosition = 6,
        value = findXValue(shuffled, tmpSlice, x7y1, x7y2, x7y3, x7y4, x7y5, x8y4, x8y5, x9y4, x9y5),
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x7y6.value)

    /* x8y6 - Grid6 MiddleRight */
    val x8y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = findXValue(shuffled, tmpSlice, x7y4, x7y5, x7y6, x8y1, x8y2, x8y3, x8y4, x8y5, x9y4, x9y5),
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x8y6.value)

    /* x9y6 - Grid6 MiddleRight */
    val x9y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        // value = findXValue(shuffled, tmpSlice, x7y4, x7y5, x7y6, x8y4, x8y5, x8y6, x9y1, x9y2, x9y3, x9y4, x9y5),
        value = 0,
        txtColour = DarkGrey,
        hidden = false
    )

    /* step 10 - column 06 */
    /* x6y7 - Grid8 BottomCenter */
    val x6y7 = GridCell(
        xPosition = 6,
        yPosition = 7,
        value = 0,
        txtColour = MathBlue,
        hidden = false
    )

    /* x6y8 - Grid8 BottomCenter */
    val x6y8 = GridCell(
        xPosition = 6,
        yPosition = 8,
        value = 0,
        txtColour = MathBlue,
        hidden = false
    )

    /* x6y9 - Grid8 BottomCenter */
    val x6y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = 0,
        txtColour = MathBlue,
        hidden = false
    )

    /* step 11 - row 07 */
    /* x7y7 - Grid9 BottomRight */
    val x7y7 = GridCell(
        xPosition = 7,
        yPosition = 7,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x8y7 - Grid9 BottomRight */
    val x8y7 = GridCell(
        xPosition = 8,
        yPosition = 7,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x9y7 - Grid9 BottomRight */
    val x9y7 = GridCell(
        xPosition = 9,
        yPosition = 7,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* step 12 - column 07 */
    /* x7y8 - Grid9 BottomRight */
    val x7y8 = GridCell(
        xPosition = 7,
        yPosition = 8,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x7y9 - Grid9 BottomRight */
    val x7y9 = GridCell(
        xPosition = 7,
        yPosition = 9,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x8y8 - Grid9 BottomRight */
    val x8y8 = GridCell(
        xPosition = 8,
        yPosition = 8,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x9y8 - Grid9 BottomRight */
    val x9y8 = GridCell(
        xPosition = 9,
        yPosition = 8,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* step 13 - row 08 */
    /* x8y9 - Grid9 BottomRight */
    val x8y9 = GridCell(
        xPosition = 8,
        yPosition = 9,
        value = 0,
        txtColour = Pink,
        hidden = false
    )

    /* x9y9 - Grid9 BottomRight */
    val x9y9 = GridCell(
        xPosition = 9,
        yPosition = 9,
        value = 0,
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
            Text("tmpSlice: $tmpSlice  size: ${tmpSlice.size}")
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

/**
 * The input list is "reset" using list.clear() before being populated from the source list.
 * @param[inputList] list to be reset (cleared then shuffled)
 * */
@Composable
fun ResetShuffled(inputList: MutableList<Int>) {
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
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