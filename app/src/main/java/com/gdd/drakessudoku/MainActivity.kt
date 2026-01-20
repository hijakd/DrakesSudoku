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
import com.gdd.drakessudoku.model.Grid
import com.gdd.drakessudoku.model.GridCell
import com.gdd.drakessudoku.ui.components.DrawSudokuGrid
import com.gdd.drakessudoku.ui.theme.Black
import com.gdd.drakessudoku.ui.theme.Blue
import com.gdd.drakessudoku.ui.theme.DarkGrey
import com.gdd.drakessudoku.ui.theme.DrakesSudokuTheme
import com.gdd.drakessudoku.ui.theme.Gold
import com.gdd.drakessudoku.ui.theme.MathBlue
import com.gdd.drakessudoku.ui.theme.NeonGreen
import com.gdd.drakessudoku.ui.theme.Pink
import com.gdd.drakessudoku.ui.theme.Purple40
import com.gdd.drakessudoku.ui.theme.Red

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
                item(icon = {
                    Icon(
                        it.icon, contentDescription = it.label
                    )
                }, label = { Text(it.label) }, selected = it == currentDestination, onClick = { currentDestination = it })
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
    HOME("Home", Icons.Default.Home), FAVORITES("Favorites", Icons.Default.Favorite), PROFILE(
        "Profile",
        Icons.Default.AccountBox
    ),
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

    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val shuffled = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slice1 = mutableListOf(0)
    val slice2 = mutableListOf(0)

    shuffled.shuffle()

    val grid: Grid


    /* first row */
    // val x1y1 = shuffled.first()
    val x1y1 = GridCell(
        xPosition = 1, yPosition = 1, value = shuffled.first(),
        txtColour = Black,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x2y1 = GridCell(
        xPosition = 2, yPosition = 1, value = shuffled.first(),
        txtColour = Black,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x3y1 = GridCell(
        xPosition = 3, yPosition = 1, value = shuffled.first(),
        txtColour = Black,
        hidden = false,
    )
    shuffled.removeAt(0)

    val x4y1 = GridCell(
        xPosition = 4, yPosition = 1, value = shuffled.first(),
        txtColour = Red,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x5y1 = GridCell(
        xPosition = 5, yPosition = 1, value = shuffled.first(),
        txtColour = Red,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x6y1 = GridCell(
        xPosition = 6, yPosition = 1, value = shuffled.first(),
        txtColour = Red,
        hidden = false,
    )
    shuffled.removeAt(0)

    val x7y1 = GridCell(
        xPosition = 7, yPosition = 1, value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x8y1 = GridCell(
        xPosition = 8, yPosition = 1, value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false,
    )
    shuffled.removeAt(0)
    val x9y1 = GridCell(
        xPosition = 9, yPosition = 1, value = shuffled.first(),
        txtColour = NeonGreen,
        hidden = false,
    )

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    shuffled.remove(x1y1.value)
    if (shuffled.last() == x9y1.value) {
        shuffled.shuffle()
    }

    /* first column */
    /* x1y2 */
    // val x1y2 = if (shuffled.first() != x2y1 && shuffled.first() != x3y1) {
    //     shuffled.first()
    // } else {
    //     shuffled.last()
    // }
    // shuffled.remove(x1y2)

    val x1y2 = GridCell(
        xPosition = 1,
        yPosition = 2,
        value = if (shuffled.first() != x2y1.value && shuffled.first() != x3y1.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x1y2.value)

    /* x1y3 */
    val x1y3 = GridCell(
        xPosition = 1,
        yPosition = 3,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x2y1.value && shuffled.first() != x3y1.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x1y3.value)

    /* x1y4 */
    val x1y4 = GridCell(
        xPosition = 1,
        yPosition = 4,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)
    /* x1y5 */
    val x1y5 = GridCell(
        xPosition = 1,
        yPosition = 5,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)
    /* x1y6 */
    val x1y6 = GridCell(
        xPosition = 1,
        yPosition = 6,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )
    shuffled.removeAt(0)

    /* x1y7 */
    val x1y7 = GridCell(
        xPosition = 1,
        yPosition = 7,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )
    shuffled.removeAt(0)
    /* x1y8 */
    val x1y8 = GridCell(
        xPosition = 1,
        yPosition = 8,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )
    shuffled.removeAt(0)
    /* x1y9 */
    val x1y9 = GridCell(
        xPosition = 1,
        yPosition = 9,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )

    /* Grid1 TopLeft */
    shuffled.clear()
    numbers.forEach {
        if (it != x1y1.value && it != x2y1.value && it != x3y1.value && it != x1y2.value && it != x1y3.value) {
            shuffled.add(it)
        }
    }
    shuffled.shuffled()

    /* row 2 */
    /* x2y2 */
    val x2y2 = GridCell(
        xPosition = 2,
        yPosition = 2,
        value = (if (shuffled.first() != x1y2.value && shuffled.first() != x2y1.value) {
            shuffled.first()
        } else {
            shuffled.last()
        }),
        txtColour = Black,
        hidden = false
    )
    shuffled.remove(x2y2.value)

    /* x3y2 */
    val x3y2 = GridCell(
        xPosition = 3,
        yPosition = 2,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x3y1.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Black,
        hidden = false
    )

    shuffled.remove(x3y2.value)

    /* row 3 */
    /* x2y3 */
    val x2y3 = GridCell(
        xPosition = 2,
        yPosition = 3,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x1y3.value && shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x3y1.value && shuffled.first() != x3y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Black,
        hidden = false
    )

    shuffled.remove(x2y3.value)

    /* x3y3 */
    val x3y3 = GridCell(
        xPosition = 3,
        yPosition = 3,
        value = shuffled.first(),
        txtColour = Black,
        hidden = false
    )


    /* Grid2 TopCenter */
    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* filter out values in row 1 of Grid2 */
    shuffled.remove(x4y1.value)
    shuffled.remove(x5y1.value)
    shuffled.remove(x6y1.value)

    /* row 2 */
    slice1.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y2.value && it != x2y2.value && it != x3y2.value) {
            slice1.add(it)
        }
    }

    /* x4y2 */
    val x4y2 = GridCell(
        xPosition = 4, yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )
    slice1.remove(x4y2.value)

    /* x5y2 */
    val x5y2 = GridCell(
        xPosition = 5, yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )
    slice1.remove(x5y2.value)

    /* x6y2 */
    val x6y2 = GridCell(
        xPosition = 6, yPosition = 2,
        value = slice1.first(),
        txtColour = Red,
        hidden = false
    )


    /* row 3 */
    slice2.clear()
    shuffled.forEach {
        if (it != x1y3.value && it != x2y3.value && it != x3y3.value) {
            slice2.add(it)
        }
    }

    /* x4y3 */
    val x4y3 = GridCell(
        xPosition = 4,
        yPosition = 3,
        value = if (slice2.first() != x4y2.value &&
            slice2.first() != x5y2.value && slice2.first() != x6y2.value
        ) {
            slice2.first()
        } else {
            slice2.last()
        },
        txtColour = Red,
        hidden = false
    )


    slice2.remove(x4y3.value)

    /* x5y3 */
    val x5y3 = GridCell(
        xPosition = 5,
        yPosition = 3,
        value = if (slice2.first() != x4y2.value &&
            slice2.first() != x4y3.value && slice2.first() != x5y2.value && slice2.first() != x6y2.value
        ) {
            slice2.first()
        } else {
            slice2.last()
        },
        txtColour = Red,
        hidden = false
    )
    slice2.remove(x5y3.value)

    /* x6y3 */
    val x6y3 = GridCell(
        xPosition = 6,
        yPosition = 3,
        value = if (slice2.first() != x4y2.value &&
            slice2.first() != x4y3.value && slice2.first() != x5y2.value && slice2.first() != x5y3.value && slice2.first() != x6y2.value
        ) {
            slice2.first()
        } else {
            slice2.last()
        },
        txtColour = Red,
        hidden = false
    )


    /* Grid3 TopRight */
    shuffled.clear()
    /* filter out values in row 1 of Grid3 */
    numbers.forEach {
        if (it != x7y1.value && it != x8y1.value && it != x9y1.value) {
            shuffled.add(it)
        }
    }
    shuffled.shuffled()

    /* row 2 */
    slice1.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y2.value && it != x2y2.value && it != x3y2.value && it != x4y2.value && it != x5y2.value && it != x6y2.value) {
            slice1.add(it)
        }
    }

    /* x7y2 */
    // val x7y2 = slice1.first()
    val x7y2 = GridCell(
        xPosition = 7,
        yPosition = 2,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x2y2.value && shuffled.first() != x3y2.value && shuffled.first() != x4y2.value && shuffled.first() != x5y2.value && shuffled.first() != x6y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x7y2.value)
    // slice1.remove(x7y2)

    /* x8y2 */
    val x8y2 = GridCell(
        xPosition = 8,
        yPosition = 2,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x2y2.value && shuffled.first() != x3y2.value && shuffled.first() != x4y2.value && shuffled.first() != x5y2.value && shuffled.first() != x6y2.value && shuffled.first() != x7y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x8y2.value)

    /* x9y2 */
    val x9y2 = GridCell(
        xPosition = 9,
        yPosition = 2,
        value = if (shuffled.first() != x1y2.value && shuffled.first() != x2y2.value && shuffled.first() != x3y2.value && shuffled.first() != x4y2.value && shuffled.first() != x5y2.value && shuffled.first() != x6y2.value && shuffled.first() != x7y2.value && shuffled.first() != x8y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x9y2.value)

    /* row 3 */
    slice2.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y3.value && it != x2y3.value && it != x3y3.value && it != x4y3.value && it != x5y3.value && it != x6y3.value) {
            slice2.add(it)
        }
    }

    /* x7y3 */
    val x7y3 = GridCell(
        xPosition = 7,
        yPosition = 3,
        value = if (shuffled.first() != x1y3.value && shuffled.first() != x2y3.value && shuffled.first() != x3y3.value && shuffled.first() != x4y3.value && shuffled.first() != x5y3.value && shuffled.first() != x6y3.value && shuffled.first() != x7y2.value && shuffled.first() != x8y2.value && shuffled.first() != x9y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x7y3.value)

    /* x8y3 */
    val x8y3 = GridCell(
        xPosition = 8,
        yPosition = 3,
        value = if (shuffled.first() != x1y3.value && shuffled.first() != x2y3.value && shuffled.first() != x3y3.value && shuffled.first() != x4y3.value && shuffled.first() != x5y3.value && shuffled.first() != x6y3.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x8y2.value && shuffled.first() != x9y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    shuffled.remove(x8y3.value)

    /* x9y3 */
    val x9y3 = GridCell(
        xPosition = 9,
        yPosition = 3,
        value = if (shuffled.first() != x1y3.value && shuffled.first() != x2y3.value && shuffled.first() != x3y3.value && shuffled.first() != x4y3.value && shuffled.first() != x5y3.value && shuffled.first() != x6y3.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value && shuffled.first() != x9y2.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = NeonGreen,
        hidden = false
    )
    // shuffled.remove(x9y3)

    // shuffled.forEach { thisShuffled.add(it) } // for debugging


    /* Grid4 MiddleLeft */
    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* filter out values in column 1 of Grid4 */
    shuffled.remove(x1y4.value)
    shuffled.remove(x1y5.value)
    shuffled.remove(x1y6.value)

    /* row 1 */
    /* x2y4 */
    val x2y4 = GridCell(
        xPosition = 2,
        yPosition = 4,
        value = if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x2y4.value)

    /* x3y4 */
    val x3y4 = GridCell(
        xPosition = 3,
        yPosition = 4,
        value = if (shuffled.first() != x2y4.value && shuffled.first() != x3y1.value && shuffled.first() != x3y2.value && shuffled.first() != x3y3.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x3y4.value)

    /* row 2 */
    /* x2y5 */
    val x2y5 = GridCell(
        xPosition = 2,
        yPosition = 5,
        value = if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x2y5.value)

    /* x3y5 */
    val x3y5 = GridCell(
        xPosition = 3,
        yPosition = 5,
        value = if (shuffled.first() != x2y4.value && shuffled.first() != x2y5.value && shuffled.first() != x3y1.value && shuffled.first() != x3y2.value && shuffled.first() != x3y3.value && shuffled.first() != x3y4.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x3y5.value)

    /* row 3 */
    /* x2y6 */
    val x2y6 = GridCell(
        xPosition = 2,
        yPosition = 6,
        value = if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value && shuffled.first() != x2y4.value && shuffled.first() != x2y5.value && shuffled.first() != x3y3.value && shuffled.first() != x3y4.value && shuffled.first() != x3y5.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Blue,
        hidden = false
    )
    shuffled.remove(x2y6.value)

    /* x3y6 */
    val x3y6 = GridCell(
        xPosition = 3,
        yPosition = 6,
        value = shuffled.first(),
        txtColour = Blue,
        hidden = false
    )

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* Grid5 Center */
    /* row 1 */
    /* x4y4 */
    val x4y4 = GridCell(
        xPosition = 4,
        yPosition = 4,
        value = if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value) {
            shuffled.first()
        } else {
            shuffled.last()
        },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y4.value)

    /* x5y4 */
    val x5y4 = GridCell(
        xPosition = 5,
        yPosition = 4,
        value =
            if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y4.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y4.value)

    /* x6y4 */
    val x6y4 = GridCell(
        xPosition = 6,
        yPosition = 4,
        value =
            if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y4.value && shuffled.first() != x5y4.value && shuffled.first() != x6y1.value && shuffled.first() != x6y2.value && shuffled.first() != x6y3.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x6y4.value)

    /* row 2 */
    /* x4y5 */
    val x4y5 = GridCell(
        xPosition = 4,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y4.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x6y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y5.value)

    /* x5y5 */
    val x5y5 = GridCell(
        xPosition = 5,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y5.value && shuffled.first() != x4y4.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x6y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y5.value)

    /* x6y5 */
    val x6y5 = GridCell(
        xPosition = 6,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x6y1.value && shuffled.first() != x6y2.value && shuffled.first() != x6y3.value && shuffled.first() != x6y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x6y5.value)

    /* row 3 */
    /* x4y6 */
    val x4y6 = GridCell(
        xPosition = 4,
        yPosition = 6,
        value =
            if (shuffled.first() != x1y6.value && shuffled.first() != x2y6.value && shuffled.first() != x3y6.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x5y4.value && shuffled.first() != x5y5.value && shuffled.first() != x6y4.value && shuffled.first() != x6y5.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x4y6.value)

    /* x5y6 */
    val x5y6 = GridCell(
        xPosition = 5,
        yPosition = 6,
        value =
            if (shuffled.first() != x1y6.value && shuffled.first() != x2y6.value && shuffled.first() != x3y6.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x4y6.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x5y5.value && shuffled.first() != x6y4.value && shuffled.first() != x6y5.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Gold,
        hidden = false
    )
    shuffled.remove(x5y6.value)

    /* x6y6 */
    val x6y6 = GridCell(
        xPosition = 6,
        yPosition = 6,
        value = shuffled.first(),
        txtColour = Gold,
        hidden = false
    )

    /* Grid6 MiddleRight */

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* row 1 */
    /* x7y4 */
    val x7y4 = GridCell(
        xPosition = 7,
        yPosition = 4,
        value =
            if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value && shuffled.first() != x4y4.value && shuffled.first() != x5y4.value && shuffled.first() != x6y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x7y4.value)

    /* x8y4 */
    val x8y4 = GridCell(
        xPosition = 8,
        yPosition = 4,
        value =
            if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y4.value && shuffled.first() != x5y4.value && shuffled.first() != x6y4.value && shuffled.first() != x7y4.value && shuffled.first() != x8y1.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x8y4.value)

    /* x9y4 */
    val x9y4 = GridCell(
        xPosition = 9,
        yPosition = 4,
        value =
            if (shuffled.first() != x1y4.value && shuffled.first() != x2y4.value && shuffled.first() != x3y4.value && shuffled.first() != x4y4.value && shuffled.first() != x5y4.value && shuffled.first() != x6y4.value && shuffled.first() != x7y4.value && shuffled.first() != x8y4.value && shuffled.first() != x9y1.value && shuffled.first() != x9y2.value && shuffled.first() != x9y3.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x9y4.value)

    /* row 2 */
    /* x7y5 */
    val x7y5 = GridCell(
        xPosition = 7,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y5.value && shuffled.first() != x5y5.value && shuffled.first() != x6y5.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x7y5.value)

    /* x8y5 */
    val x8y5 = GridCell(
        xPosition = 8,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y5.value && shuffled.first() != x5y5.value && shuffled.first() != x6y5.value && shuffled.first() != x7y5.value && shuffled.first() != x8y1.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value && shuffled.first() != x8y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x8y5.value)

    /* x9y5 */
    val x9y5 = GridCell(
        xPosition = 9,
        yPosition = 5,
        value =
            if (shuffled.first() != x1y5.value && shuffled.first() != x2y5.value && shuffled.first() != x3y5.value && shuffled.first() != x4y5.value && shuffled.first() != x5y5.value && shuffled.first() != x6y5.value && shuffled.first() != x7y5.value && shuffled.first() != x8y5.value && shuffled.first() != x9y1.value && shuffled.first() != x9y2.value && shuffled.first() != x9y3.value && shuffled.first() != x9y4.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x9y5.value)

    /* row 3 */
    /* x7y6 */
    val x7y6 = GridCell(
        xPosition = 7,
        yPosition = 6,
        value =
            if (shuffled.first() != x1y6.value && shuffled.first() != x2y6.value && shuffled.first() != x3y6.value && shuffled.first() != x4y6.value && shuffled.first() != x5y6.value && shuffled.first() != x6y6.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value && shuffled.first() != x7y5.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x7y6.value)

    /* x8y6 */
    val x8y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value =
            if (shuffled.first() != x1y6.value && shuffled.first() != x2y6.value && shuffled.first() != x3y6.value && shuffled.first() != x4y6.value && shuffled.first() != x5y6.value && shuffled.first() != x6y6.value && shuffled.first() != x7y6.value && shuffled.first() != x8y1.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value && shuffled.first() != x8y4.value && shuffled.first() != x8y5.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = DarkGrey,
        hidden = false
    )
    shuffled.remove(x8y6.value)

    /* x9y6 */
    val x9y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = shuffled.first(),
        txtColour = DarkGrey,
        hidden = false
    )

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    shuffled.remove(x1y7.value)
    shuffled.remove(x1y8.value)
    shuffled.remove(x1y9.value)

    /* Grid7 BottomLeft */
    /* row 1 */
    /* x2y7 */
    val x2y7 = GridCell(
        xPosition = 2,
        yPosition = 7,
        value =
            if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value && shuffled.first() != x2y4.value && shuffled.first() != x2y5.value && shuffled.first() != x2y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Purple40,
        hidden = false
    )
    shuffled.remove(x2y7.value)

    /* x3y7 */
    val x3y7 = GridCell(
        xPosition = 3,
        yPosition = 7,
        value =
            if (shuffled.first() != x2y7.value && shuffled.first() != x3y1.value && shuffled.first() != x3y2.value && shuffled.first() != x3y3.value && shuffled.first() != x3y4.value && shuffled.first() != x3y5.value && shuffled.first() != x3y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Purple40,
        hidden = false
    )
    shuffled.remove(x3y7.value)

    /* row 2 */
    /* x2y8 */
    val x2y8 = GridCell(
        xPosition = 2,
        yPosition = 8,
        value =
            if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value && shuffled.first() != x2y4.value && shuffled.first() != x2y5.value && shuffled.first() != x2y6.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Purple40,
        hidden = false
    )
    shuffled.remove(x2y8.value)

    /* x3y8 */
    val x3y8 = GridCell(
        xPosition = 3,
        yPosition = 8,
        value =
            if (shuffled.first() != x2y7.value && shuffled.first() != x3y1.value && shuffled.first() != x3y2.value && shuffled.first() != x3y3.value && shuffled.first() != x3y4.value && shuffled.first() != x3y5.value && shuffled.first() != x3y6.value && shuffled.first() != x3y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Purple40,
        hidden = false
    )
    shuffled.remove(x3y8.value)

    /* row 3 */
    /* x2y9 */
    val x2y9 = GridCell(
        xPosition = 2,
        yPosition = 9,
        value =
            if (shuffled.first() != x2y1.value && shuffled.first() != x2y2.value && shuffled.first() != x2y3.value && shuffled.first() != x2y4.value && shuffled.first() != x2y5.value && shuffled.first() != x2y6.value && shuffled.first() != x2y7.value && shuffled.first() != x2y8.value && shuffled.first() != x3y7.value && shuffled.first() != x3y8.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Purple40,
        hidden = false
    )
    shuffled.remove(x2y9.value)

    /* x3y9 */
    val x3y9 = GridCell(
        xPosition = 3,
        yPosition = 9,
        value = shuffled.first(),
        txtColour = Purple40,
        hidden = false
    )

    /* Grid8 BottomCenter */
    // grid++

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* row 1 */
    /* x4y7 */
    val x4y7 = GridCell(
        xPosition = 4,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x4y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x4y7.value)

    /* x5y7 */
    val x5y7 = GridCell(
        xPosition = 5,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y7.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x5y5.value && shuffled.first() != x5y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x5y7.value)

    /* x6y7 */
    val x6y7 = GridCell(
        xPosition = 6,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y7.value && shuffled.first() != x5y7.value && shuffled.first() != x6y1.value && shuffled.first() != x6y2.value && shuffled.first() != x6y3.value && shuffled.first() != x6y4.value && shuffled.first() != x6y5.value && shuffled.first() != x6y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x6y7.value)

    /* row 2 */
    /* x4y8 */
    val x4y8 = GridCell(
        xPosition = 4,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x4y6.value && shuffled.first() != x4y7.value
            ) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x4y8.value)

    /* x5y8 */
    val x5y8 = GridCell(
        xPosition = 5,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y8.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x5y5.value && shuffled.first() != x5y6.value && shuffled.first() != x5y7.value
            ) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x5y8.value)

    /* x6y8 */
    val x6y8 = GridCell(
        xPosition = 6,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y8.value && shuffled.first() != x5y8.value && shuffled.first() != x6y1.value && shuffled.first() != x6y2.value && shuffled.first() != x6y3.value && shuffled.first() != x6y4.value && shuffled.first() != x6y5.value && shuffled.first() != x6y6.value && shuffled.first() != x6y7.value
            ) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x6y8.value)

    /* row 3 */
    /* x4y9 */
    val x4y9 = GridCell(
        xPosition = 4,
        yPosition = 9,
        value =
            if (shuffled.first() != x1y9.value && shuffled.first() != x2y9.value && shuffled.first() != x3y9.value && shuffled.first() != x4y1.value && shuffled.first() != x4y2.value && shuffled.first() != x4y3.value && shuffled.first() != x4y4.value && shuffled.first() != x4y5.value && shuffled.first() != x4y6.value && shuffled.first() != x4y7.value && shuffled.first() != x4y8.value
            ) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x4y9.value)

    /* x5y9 */
    val x5y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value =
            if (shuffled.first() != x1y9.value && shuffled.first() != x2y9.value && shuffled.first() != x3y9.value && shuffled.first() != x4y9.value && shuffled.first() != x5y1.value && shuffled.first() != x5y2.value && shuffled.first() != x5y3.value && shuffled.first() != x5y4.value && shuffled.first() != x5y5.value && shuffled.first() != x5y6.value && shuffled.first() != x5y7.value && shuffled.first() != x5y8.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = MathBlue,
        hidden = false
    )
    shuffled.remove(x5y9.value)

    /* x6y9 */
    val x6y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = shuffled.first(),
        txtColour = MathBlue,
        hidden = false
    )


    /* Grid9 BottomRight */
    // grid++

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* row 1 */
    /* x7y7 */
    val x7y7 = GridCell(
        xPosition = 7,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y7.value && shuffled.first() != x5y7.value && shuffled.first() != x6y7.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value && shuffled.first() != x7y5.value && shuffled.first() != x7y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x7y7.value)

    /* x8y7 */
    val x8y7 = GridCell(
        xPosition = 8,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y7.value && shuffled.first() != x5y7.value && shuffled.first() != x6y7.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value && shuffled.first() != x7y5.value && shuffled.first() != x7y6.value && shuffled.first() != x7y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x8y7.value)

    /* x9y7 */
    val x9y7 = GridCell(
        xPosition = 9,
        yPosition = 7,
        value =
            if (shuffled.first() != x1y7.value && shuffled.first() != x2y7.value && shuffled.first() != x3y7.value && shuffled.first() != x4y7.value && shuffled.first() != x5y7.value && shuffled.first() != x6y7.value && shuffled.first() != x7y7.value && shuffled.first() != x8y7.value && shuffled.first() != x9y1.value && shuffled.first() != x9y2.value && shuffled.first() != x9y3.value && shuffled.first() != x9y4.value && shuffled.first() != x9y5.value && shuffled.first() != x9y6.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x9y7.value)

    /* row 2 */
    /* x7y8 */
    val x7y8 = GridCell(
        xPosition = 7,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y8.value && shuffled.first() != x5y8.value && shuffled.first() != x6y8.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value && shuffled.first() != x7y5.value && shuffled.first() != x7y6.value && shuffled.first() != x7y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x7y8.value)

    /* x8y8 */
    val x8y8 = GridCell(
        xPosition = 8,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y8.value && shuffled.first() != x5y8.value && shuffled.first() != x6y8.value && shuffled.first() != x7y7.value && shuffled.first() != x7y8.value && shuffled.first() != x8y1.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value && shuffled.first() != x8y4.value && shuffled.first() != x8y5.value && shuffled.first() != x8y6.value && shuffled.first() != x8y7.value && shuffled.first() != x9y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x8y8.value)

    /* x9y8 */
    val x9y8 = GridCell(
        xPosition = 9,
        yPosition = 8,
        value =
            if (shuffled.first() != x1y8.value && shuffled.first() != x2y8.value && shuffled.first() != x3y8.value && shuffled.first() != x4y8.value && shuffled.first() != x5y8.value && shuffled.first() != x6y8.value && shuffled.first() != x7y7.value && shuffled.first() != x7y8.value && shuffled.first() != x8y7.value && shuffled.first() != x8y8.value && shuffled.first() != x9y1.value && shuffled.first() != x9y2.value && shuffled.first() != x9y3.value && shuffled.first() != x9y4.value && shuffled.first() != x9y5.value && shuffled.first() != x9y6.value && shuffled.first() != x9y7.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x9y8.value)

    /* row 3 */
    /* x7y9 */
    val x7y9 = GridCell(
        xPosition = 7,
        yPosition = 9,
        value =
            if (shuffled.first() != x1y9.value && shuffled.first() != x2y9.value && shuffled.first() != x3y9.value && shuffled.first() != x4y9.value && shuffled.first() != x5y9.value && shuffled.first() != x6y9.value && shuffled.first() != x7y1.value && shuffled.first() != x7y2.value && shuffled.first() != x7y3.value && shuffled.first() != x7y4.value && shuffled.first() != x7y5.value && shuffled.first() != x7y6.value && shuffled.first() != x7y7.value && shuffled.first() != x7y8.value && shuffled.first() != x8y7.value && shuffled.first() != x8y8.value && shuffled.first() != x9y7.value && shuffled.first() != x9y8.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x7y9.value)

    /* x8y9 */
    val x8y9 = GridCell(
        xPosition = 8,
        yPosition = 9,
        value =
            if (shuffled.first() != x1y9.value && shuffled.first() != x2y9.value && shuffled.first() != x3y9.value && shuffled.first() != x4y9.value && shuffled.first() != x5y9.value && shuffled.first() != x6y9.value && shuffled.first() != x7y7.value && shuffled.first() != x7y8.value && shuffled.first() != x7y9.value && shuffled.first() != x8y1.value && shuffled.first() != x8y2.value && shuffled.first() != x8y3.value && shuffled.first() != x8y4.value && shuffled.first() != x8y5.value && shuffled.first() != x8y6.value && shuffled.first() != x8y7.value && shuffled.first() != x8y8.value && shuffled.first() != x9y7.value && shuffled.first() != x9y8.value) {
                shuffled.first()
            } else {
                shuffled.last()
            },
        txtColour = Pink,
        hidden = false
    )
    shuffled.remove(x8y9.value)

    /* x9y9 */
    val x9y9 =  GridCell(
        xPosition = 9,
        yPosition = 9,
        value =shuffled.first(),
        txtColour = Pink,
        hidden = false
    )

    shuffled.clear()
    slice1.clear()
    slice2.clear()

    /* Begin Layout */

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.size(5.dp))
        // Text("Grid# $grid")
        // Text("idx# $tmp")
        // Text("Shuffled: $shuffled  size: ${shuffled.size}")
        // Text("ThisShuffled: $thisShuffled  size: ${thisShuffled.size}")
        // Text("Slice1 $slice1")
        // Text("Slice1: $tmpSlice1  size: ${tmpSlice1.size}")
        // Text("Slice2 $slice2")
        // Text("Slice2: $tmpSlice2  size: ${tmpSlice2.size}")
        Spacer(modifier = Modifier.size(5.dp))

        DrawSudokuGrid(
            modifier,
            x1y1,
            x2y1,
            x3y1,
            x1y2,
            x2y2,
            x3y2,
            x1y3,
            x2y3,
            x3y3,
            x4y1,
            x5y1,
            x6y1,
            x4y2,
            x5y2,
            x6y2,
            x4y3,
            x5y3,
            x6y3,
            x7y1,
            x8y1,
            x9y1,
            x7y2,
            x8y2,
            x9y2,
            x7y3,
            x8y3,
            x9y3,
            x1y4,
            x2y4,
            x3y4,
            x1y5,
            x2y5,
            x3y5,
            x1y6,
            x2y6,
            x3y6,
            x4y4,
            x5y4,
            x6y4,
            x4y5,
            x5y5,
            x6y5,
            x4y6,
            x5y6,
            x6y6,
            x7y4,
            x8y4,
            x9y4,
            x7y5,
            x8y5,
            x9y5,
            x7y6,
            x8y6,
            x9y6,
            x1y7,
            x2y7,
            x3y7,
            x1y8,
            x2y8,
            x3y8,
            x1y9,
            x2y9,
            x3y9,
            x4y7,
            x5y7,
            x6y7,
            x4y8,
            x5y8,
            x6y8,
            x4y9,
            x5y9,
            x6y9,
            x7y7,
            x8y7,
            x9y7,
            x7y8,
            x8y8,
            x9y8,
            x7y9,
            x8y9,
            x9y9
        )

        Spacer(modifier = Modifier.size(10.dp))
    }
} // End of AppCore

@Preview(showBackground = true)
@Composable
fun AppCorePreview() {
    DrakesSudokuTheme {
        AppCore()
    }
}