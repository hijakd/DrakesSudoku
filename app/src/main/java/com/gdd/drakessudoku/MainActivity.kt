package com.gdd.drakessudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gdd.drakessudoku.ui.components.ColouredText
import com.gdd.drakessudoku.ui.theme.*

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

    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val shuffled = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slice1 = mutableListOf(0)
    val slice2 = mutableListOf(0)

    shuffled.shuffle()

    /* first row */
    val x1y1 = shuffled.first()
    shuffled.removeAt(0)
    val x2y1 = shuffled.first()
    shuffled.removeAt(0)
    val x3y1 = shuffled.first()
    shuffled.removeAt(0)

    val x4y1 = shuffled.first()
    shuffled.removeAt(0)
    val x5y1 = shuffled.first()
    shuffled.removeAt(0)
    val x6y1 = shuffled.first()
    shuffled.removeAt(0)

    val x7y1 = shuffled.first()
    shuffled.removeAt(0)
    val x8y1 = shuffled.first()
    shuffled.removeAt(0)
    val x9y1 = shuffled.first()

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    shuffled.remove(x1y1)
    if (shuffled.last() == x9y1) {
        shuffled.shuffle()
    }

    /* first column */
    /* x1y2 */
    val x1y2 = if (shuffled.first() != x2y1 && shuffled.first() != x3y1) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x1y2)

    /* x1y3 */
    val x1y3 = if (shuffled.first() != x1y2 && shuffled.first() != x2y1 && shuffled.first() != x3y1) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x1y3)

    /* x1y4 */
    val x1y4 = shuffled.first()
    shuffled.removeAt(0)
    /* x1y5 */
    val x1y5 = shuffled.first()
    shuffled.removeAt(0)
    /* x1y6 */
    val x1y6 = shuffled.first()
    shuffled.removeAt(0)

    /* x1y7 */
    val x1y7 = shuffled.first()
    shuffled.removeAt(0)
    /* x1y8 */
    val x1y8 = shuffled.first()
    shuffled.removeAt(0)
    /* x1y9 */
    val x1y9 = shuffled.first()

    /* Grid1 TopLeft */
    shuffled.clear()
    numbers.forEach {
        if (it != x1y1 && it != x2y1 && it != x3y1 && it != x1y2 && it != x1y3) {
            shuffled.add(it)
        }
    }
    shuffled.shuffled()

    /* row 2 */
    /* x2y2 */
    val x2y2 = if (shuffled.first() != x1y2 && shuffled.first() != x2y1) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x2y2)

    /* x3y2 */
    val x3y2 = if (shuffled.first() != x1y2 && shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x3y1) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x3y2)

    /* row 3 */
    /* x2y3 */
    val x2y3 =
        if (shuffled.first() != x1y2 && shuffled.first() != x1y3 && shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x3y1 && shuffled.first() != x3y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y3)

    /* x3y3 */
    val x3y3 = shuffled.first()


    /* Grid2 TopCenter */
    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* filter out values in row 1 of Grid2 */
    shuffled.remove(x4y1)
    shuffled.remove(x5y1)
    shuffled.remove(x6y1)

    /* row 2 */
    slice1.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y2 && it != x2y2 && it != x3y2) {
            slice1.add(it)
        }
    }

    /* x4y2 */
    val x4y2 = slice1.first()
    slice1.remove(x4y2)

    /* x5y2 */
    val x5y2 = slice1.first()
    slice1.remove(x5y2)

    /* x6y2 */
    val x6y2 = slice1.first()


    /* row 3 */
    slice2.clear()
    shuffled.forEach {
        if (it != x1y3 && it != x2y3 && it != x3y3) {
            slice2.add(it)
        }
    }

    /* x4y3 */
    val x4y3 = if (slice2.first() != x4y2 &&
        slice2.first() != x5y2 && slice2.first() != x6y2
    ) {
        slice2.first()
    } else {
        slice2.last()
    }
    slice2.remove(x4y3)

    /* x5y3 */
    val x5y3 = if (slice2.first() != x4y2 &&
        slice2.first() != x4y3 && slice2.first() != x5y2 && slice2.first() != x6y2
    ) {
        slice2.first()
    } else {
        slice2.last()
    }
    slice2.remove(x5y3)

    /* x6y3 */
    val x6y3 = if (slice2.first() != x4y2 &&
        slice2.first() != x4y3 && slice2.first() != x5y2 && slice2.first() != x5y3 && slice2.first() != x6y2
    ) {
        slice2.first()
    } else {
        slice2.last()
    }


    /* Grid3 TopRight */
    shuffled.clear()
    /* filter out values in row 1 of Grid3 */
    numbers.forEach {
        if (it != x7y1 && it != x8y1 && it != x9y1) {
            shuffled.add(it)
        }
    }
    shuffled.shuffled()

    /* row 2 */
    slice1.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y2 && it != x2y2 && it != x3y2 && it != x4y2 && it != x5y2 && it != x6y2) {
            slice1.add(it)
        }
    }

    /* x7y2 */
    // val x7y2 = slice1.first()
    val x7y2 =
        if (shuffled.first() != x1y2 && shuffled.first() != x2y2 && shuffled.first() != x3y2 && shuffled.first() != x4y2 && shuffled.first() != x5y2 && shuffled.first() != x6y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y2)
    // slice1.remove(x7y2)

    /* x8y2 */
    val x8y2 =
        if (shuffled.first() != x1y2 && shuffled.first() != x2y2 && shuffled.first() != x3y2 && shuffled.first() != x4y2 && shuffled.first() != x5y2 && shuffled.first() != x6y2 && shuffled.first() != x7y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y2)

    /* x9y2 */
    val x9y2 =
        if (shuffled.first() != x1y2 && shuffled.first() != x2y2 && shuffled.first() != x3y2 && shuffled.first() != x4y2 && shuffled.first() != x5y2 && shuffled.first() != x6y2 && shuffled.first() != x7y2 && shuffled.first() != x8y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x9y2)

    /* row 3 */
    slice2.clear()
    /* filter out values in row 2 of Grid1 */
    shuffled.forEach {
        if (it != x1y3 && it != x2y3 && it != x3y3 && it != x4y3 && it != x5y3 && it != x6y3) {
            slice2.add(it)
        }
    }

    /* x7y3 */
    val x7y3 =
        if (shuffled.first() != x1y3 && shuffled.first() != x2y3 && shuffled.first() != x3y3 && shuffled.first() != x4y3 && shuffled.first() != x5y3 && shuffled.first() != x6y3 && shuffled.first() != x7y2 && shuffled.first() != x8y2 && shuffled.first() != x9y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y2)

    /* x8y3 */
    val x8y3 =
        if (shuffled.first() != x1y3 && shuffled.first() != x2y3 && shuffled.first() != x3y3 && shuffled.first() != x4y3 && shuffled.first() != x5y3 && shuffled.first() != x6y3 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x8y2 && shuffled.first() != x9y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y3)

    /* x9y3 */
    val x9y3 =
        if (shuffled.first() != x1y3 && shuffled.first() != x2y3 && shuffled.first() != x3y3 && shuffled.first() != x4y3 && shuffled.first() != x5y3 && shuffled.first() != x6y3 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x8y2 && shuffled.first() != x8y3 && shuffled.first() != x9y2) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    // shuffled.remove(x9y3)

    // shuffled.forEach { thisShuffled.add(it) } // for debugging


    /* Grid4 MiddleLeft */
    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* filter out values in column 1 of Grid4 */
    shuffled.remove(x1y4)
    shuffled.remove(x1y5)
    shuffled.remove(x1y6)

    /* row 1 */
    /* x2y4 */
    val x2y4 = if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x2y4)

    /* x3y4 */
    val x3y4 = if (shuffled.first() != x2y4 && shuffled.first() != x3y1 && shuffled.first() != x3y2 && shuffled.first() != x3y3) {
        shuffled.first()
    } else {
        shuffled.last()
    }
    shuffled.remove(x3y4)

    /* row 2 */
    /* x2y5 */
    val x2y5 =
        if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3 && shuffled.first() != x2y4 && shuffled.first() != x3y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y5)

    /* x3y5 */
    val x3y5 =
        if (shuffled.first() != x2y4 && shuffled.first() != x2y5 && shuffled.first() != x3y1 && shuffled.first() != x3y2 && shuffled.first() != x3y3 && shuffled.first() != x3y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x3y5)

    /* row 3 */
    /* x2y6 */
    val x2y6 =
        if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3 && shuffled.first() != x2y4 && shuffled.first() != x2y5 && shuffled.first() != x3y3 && shuffled.first() != x3y4 && shuffled.first() != x3y5) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y6)

    /* x3y6 */
    val x3y6 = shuffled.first()

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* Grid5 Center */
    /* row 1 */
    /* x4y4 */
    val x4y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y4)

    /* x5y4 */
    val x5y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y4 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x5y4)

    /* x6y4 */
    val x6y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y4 && shuffled.first() != x5y4 && shuffled.first() != x6y1 && shuffled.first() != x6y2 && shuffled.first() != x6y3) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x6y4)

    /* row 2 */
    /* x4y5 */
    val x4y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y4 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x6y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y5)

    /* x5y5 */
    val x5y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y5 && shuffled.first() != x4y4 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x6y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x5y5)

    /* x6y5 */
    val x6y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x6y1 && shuffled.first() != x6y2 && shuffled.first() != x6y3 && shuffled.first() != x6y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x6y5)

    /* row 3 */
    /* x4y6 */
    val x4y6 =
        if (shuffled.first() != x1y6 && shuffled.first() != x2y6 && shuffled.first() != x3y6 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x5y4 && shuffled.first() != x5y5 && shuffled.first() != x6y4 && shuffled.first() != x6y5) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y6)

    /* x5y6 */
    val x5y6 =
        if (shuffled.first() != x1y6 && shuffled.first() != x2y6 && shuffled.first() != x3y6 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x4y6 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x5y5 && shuffled.first() != x6y4 && shuffled.first() != x6y5) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y6)

    /* x6y6 */
    val x6y6 = shuffled.first()

    /* Grid6 MiddleRight */

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* row 1 */
    /* x7y4 */
    val x7y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3 && shuffled.first() != x4y4 && shuffled.first() != x5y4 && shuffled.first() != x6y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y4)

    /* x8y4 */
    val x8y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y4 && shuffled.first() != x5y4 && shuffled.first() != x6y4 && shuffled.first() != x7y4 && shuffled.first() != x8y1 && shuffled.first() != x8y2 && shuffled.first() != x8y3) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y4)

    /* x9y4 */
    val x9y4 =
        if (shuffled.first() != x1y4 && shuffled.first() != x2y4 && shuffled.first() != x3y4 && shuffled.first() != x4y4 && shuffled.first() != x5y4 && shuffled.first() != x6y4 && shuffled.first() != x7y4 && shuffled.first() != x8y4 && shuffled.first() != x9y1 && shuffled.first() != x9y2 && shuffled.first() != x9y3) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x9y4)

    /* row 2 */
    /* x7y5 */
    val x7y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y5 && shuffled.first() != x5y5 && shuffled.first() != x6y5 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y5)

    /* x8y5 */
    val x8y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y5 && shuffled.first() != x5y5 && shuffled.first() != x6y5 && shuffled.first() != x7y5 && shuffled.first() != x8y1 && shuffled.first() != x8y2 && shuffled.first() != x8y3 && shuffled.first() != x8y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y5)

    /* x9y5 */
    val x9y5 =
        if (shuffled.first() != x1y5 && shuffled.first() != x2y5 && shuffled.first() != x3y5 && shuffled.first() != x4y5 && shuffled.first() != x5y5 && shuffled.first() != x6y5 && shuffled.first() != x7y5 && shuffled.first() != x8y5 && shuffled.first() != x9y1 && shuffled.first() != x9y2 && shuffled.first() != x9y3 && shuffled.first() != x9y4) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x9y5)

    /* row 3 */
    /* x7y6 */
    val x7y6 =
        if (shuffled.first() != x1y6 && shuffled.first() != x2y6 && shuffled.first() != x3y6 && shuffled.first() != x4y6 && shuffled.first() != x5y6 && shuffled.first() != x6y6 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4 && shuffled.first() != x7y5) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y6)

    /* x8y6 */
    val x8y6 =
        if (shuffled.first() != x1y6 && shuffled.first() != x2y6 && shuffled.first() != x3y6 && shuffled.first() != x4y6 && shuffled.first() != x5y6 && shuffled.first() != x6y6 && shuffled.first() != x7y6 && shuffled.first() != x8y1 && shuffled.first() != x8y2 && shuffled.first() != x8y3 && shuffled.first() != x8y4 && shuffled.first() != x8y5) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y6)

    /* x9y6 */
    val x9y6 = shuffled.first()

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    shuffled.remove(x1y7)
    shuffled.remove(x1y8)
    shuffled.remove(x1y9)

    /* Grid7 BottomLeft */
    /* row 1 */
    /* x2y7 */
    val x2y7 =
        if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3 && shuffled.first() != x2y4 && shuffled.first() != x2y5 && shuffled.first() != x2y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y7)

    /* x3y7 */
    val x3y7 =
        if (shuffled.first() != x2y7 && shuffled.first() != x3y1 && shuffled.first() != x3y2 && shuffled.first() != x3y3 && shuffled.first() != x3y4 && shuffled.first() != x3y5 && shuffled.first() != x3y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x3y7)

    /* row 2 */
    /* x2y8 */
    val x2y8 =
        if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3 && shuffled.first() != x2y4 && shuffled.first() != x2y5 && shuffled.first() != x2y6 && shuffled.first() != x2y7 && shuffled.first() != x3y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y8)

    /* x3y8 */
    val x3y8 =
        if (shuffled.first() != x2y7 && shuffled.first() != x3y1 && shuffled.first() != x3y2 && shuffled.first() != x3y3 && shuffled.first() != x3y4 && shuffled.first() != x3y5 && shuffled.first() != x3y6 && shuffled.first() != x3y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x3y8)

    /* row 3 */
    /* x2y9 */
    val x2y9 =
        if (shuffled.first() != x2y1 && shuffled.first() != x2y2 && shuffled.first() != x2y3 && shuffled.first() != x2y4 && shuffled.first() != x2y5 && shuffled.first() != x2y6 && shuffled.first() != x2y7 && shuffled.first() != x2y8 && shuffled.first() != x3y7 && shuffled.first() != x3y8) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x2y9)

    /* x3y9 */
    val x3y9 = shuffled.first()

    /* Grid8 BottomCenter */
    // grid++

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffled()

    /* row 1 */
    /* x4y7 */
    val x4y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x4y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y7)

    /* x5y7 */
    val x5y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y7 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x5y5 && shuffled.first() != x5y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x5y7)

    /* x6y7 */
    val x6y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y7 && shuffled.first() != x5y7 && shuffled.first() != x6y1 && shuffled.first() != x6y2 && shuffled.first() != x6y3 && shuffled.first() != x6y4 && shuffled.first() != x6y5 && shuffled.first() != x6y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x6y7)

    /* row 2 */
    /* x4y8 */
    val x4y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x4y6 && shuffled.first() != x4y7
        ) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y8)

    /* x5y8 */
    val x5y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y8 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x5y5 && shuffled.first() != x5y6 && shuffled.first() != x5y7
        ) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x5y8)

    /* x6y8 */
    val x6y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y8 && shuffled.first() != x5y8 && shuffled.first() != x6y1 && shuffled.first() != x6y2 && shuffled.first() != x6y3 && shuffled.first() != x6y4 && shuffled.first() != x6y5 && shuffled.first() != x6y6 && shuffled.first() != x6y7
        ) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x6y8)

    /* row 3 */
    /* x4y9 */
    val x4y9 =
        if (shuffled.first() != x1y9 && shuffled.first() != x2y9 && shuffled.first() != x3y9 && shuffled.first() != x4y1 && shuffled.first() != x4y2 && shuffled.first() != x4y3 && shuffled.first() != x4y4 && shuffled.first() != x4y5 && shuffled.first() != x4y6 && shuffled.first() != x4y7 && shuffled.first() != x4y8
        ) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x4y9)

    /* x5y9 */
    val x5y9 =
        if (shuffled.first() != x1y9 && shuffled.first() != x2y9 && shuffled.first() != x3y9 && shuffled.first() != x4y9 && shuffled.first() != x5y1 && shuffled.first() != x5y2 && shuffled.first() != x5y3 && shuffled.first() != x5y4 && shuffled.first() != x5y5 && shuffled.first() != x5y6 && shuffled.first() != x5y7 && shuffled.first() != x5y8) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x5y9)

    /* x6y9 */
    val x6y9 = shuffled.first()


    /* Grid9 BottomRight */
    // grid++

    shuffled.clear()
    numbers.forEach { shuffled.add(it) }
    shuffled.shuffle()

    /* row 1 */
    /* x7y7 */
    val x7y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y7 && shuffled.first() != x5y7 && shuffled.first() != x6y7 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4 && shuffled.first() != x7y5 && shuffled.first() != x7y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y7)

    /* x8y7 */
    val x8y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y7 && shuffled.first() != x5y7 && shuffled.first() != x6y7 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4 && shuffled.first() != x7y5 && shuffled.first() != x7y6 && shuffled.first() != x7y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y7)

    /* x9y7 */
    val x9y7 =
        if (shuffled.first() != x1y7 && shuffled.first() != x2y7 && shuffled.first() != x3y7 && shuffled.first() != x4y7 && shuffled.first() != x5y7 && shuffled.first() != x6y7 && shuffled.first() != x7y7 && shuffled.first() != x8y7 && shuffled.first() != x9y1 && shuffled.first() != x9y2 && shuffled.first() != x9y3 && shuffled.first() != x9y4 && shuffled.first() != x9y5 && shuffled.first() != x9y6) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x9y7)

    /* row 2 */
    /* x7y8 */
    val x7y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y8 && shuffled.first() != x5y8 && shuffled.first() != x6y8 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4 && shuffled.first() != x7y5 && shuffled.first() != x7y6 && shuffled.first() != x7y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y8)

    /* x8y8 */
    val x8y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y8 && shuffled.first() != x5y8 && shuffled.first() != x6y8 && shuffled.first() != x7y7 && shuffled.first() != x7y8 && shuffled.first() != x8y1 && shuffled.first() != x8y2 && shuffled.first() != x8y3 && shuffled.first() != x8y4 && shuffled.first() != x8y5 && shuffled.first() != x8y6 && shuffled.first() != x8y7 && shuffled.first() != x9y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y8)

    /* x9y8 */
    val x9y8 =
        if (shuffled.first() != x1y8 && shuffled.first() != x2y8 && shuffled.first() != x3y8 && shuffled.first() != x4y8 && shuffled.first() != x5y8 && shuffled.first() != x6y8 && shuffled.first() != x7y7 && shuffled.first() != x7y8 && shuffled.first() != x8y7 && shuffled.first() != x8y8 && shuffled.first() != x9y1 && shuffled.first() != x9y2 && shuffled.first() != x9y3 && shuffled.first() != x9y4 && shuffled.first() != x9y5 && shuffled.first() != x9y6 && shuffled.first() != x9y7) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x9y8)

    /* row 3 */
    /* x7y9 */
    val x7y9 =
        if (shuffled.first() != x1y9 && shuffled.first() != x2y9 && shuffled.first() != x3y9 && shuffled.first() != x4y9 && shuffled.first() != x5y9 && shuffled.first() != x6y9 && shuffled.first() != x7y1 && shuffled.first() != x7y2 && shuffled.first() != x7y3 && shuffled.first() != x7y4 && shuffled.first() != x7y5 && shuffled.first() != x7y6 && shuffled.first() != x7y7 && shuffled.first() != x7y8 && shuffled.first() != x8y7 && shuffled.first() != x8y8 && shuffled.first() != x9y7 && shuffled.first() != x9y8) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x7y9)

    /* x8y9 */
    val x8y9 =
        if (shuffled.first() != x1y9 && shuffled.first() != x2y9 && shuffled.first() != x3y9 && shuffled.first() != x4y9 && shuffled.first() != x5y9 && shuffled.first() != x6y9 && shuffled.first() != x7y7 && shuffled.first() != x7y8 && shuffled.first() != x7y9 && shuffled.first() != x8y1 && shuffled.first() != x8y2 && shuffled.first() != x8y3 && shuffled.first() != x8y4 && shuffled.first() != x8y5 && shuffled.first() != x8y6 && shuffled.first() != x8y7 && shuffled.first() != x8y8 && shuffled.first() != x9y7 && shuffled.first() != x9y8) {
            shuffled.first()
        } else {
            shuffled.last()
        }
    shuffled.remove(x8y8)

    /* x9y9 */
    val x9y9 = shuffled.first()

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

        SudokuGrid(
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
}

@Composable
private fun SudokuGrid(
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
} // End of AppCore


@Preview(showBackground = true)
@Composable
fun AppCorePreview() {
    DrakesSudokuTheme {
        AppCore()
    }
}