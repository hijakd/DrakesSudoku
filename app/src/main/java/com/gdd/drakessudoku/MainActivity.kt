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
import com.gdd.drakessudoku.model.GridList
import com.gdd.drakessudoku.ui.components.DrawSudokuGrid
import com.gdd.drakessudoku.ui.theme.*
import com.gdd.drakessudoku.utils.TrimPosition

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
    shuffled.shuffle()


    /* ROW 01 position values */
    val posX1y1 = mutableListOf(shuffled[0])
    val posX2y1 = mutableListOf(shuffled[1])
    val posX3y1 = mutableListOf(shuffled[2])
    val posX4y1 = mutableListOf(shuffled[3])
    val posX5y1 = mutableListOf(shuffled[4])
    val posX6y1 = mutableListOf(shuffled[5])
    val posX7y1 = mutableListOf(shuffled[6])
    val posX8y1 = mutableListOf(shuffled[7])
    val posX9y1 = mutableListOf(shuffled[8])

    shuffled.shuffle()
    shuffled.remove(posX1y1.first())
    if (shuffled.last() == posX9y1.first()){
        shuffled.shuffle()
    }


    /* ROW 02 position values */
    val posX1y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y2.shuffle()
    posX1y2.remove(posX1y1.first())
    posX1y2.remove(posX2y1.first())
    posX1y2.remove(posX3y1.first())

    val posX2y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y2.shuffle()
    posX2y2.remove(posX1y1.first())
    posX2y2.remove(posX1y2.first())
    posX2y2.remove(posX2y1.first())
    posX2y2.remove(posX3y1.first())

    val posX3y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y2.shuffle()
    posX3y2.remove(posX1y1.first())
    posX3y2.remove(posX1y2.first())
    posX3y2.remove(posX2y1.first())
    posX3y2.remove(posX2y2.first())
    posX3y2.remove(posX3y1.first())

    val posX4y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y2.shuffle()
    posX4y2.remove(posX1y2.first())
    posX4y2.remove(posX2y2.first())
    posX4y2.remove(posX3y2.first())
    posX4y2.remove(posX4y1.first())
    posX4y2.remove(posX5y1.first())
    posX4y2.remove(posX6y1.first())

    val posX5y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y2.shuffle()
    posX5y2.remove(posX1y2.first())
    posX5y2.remove(posX2y2.first())
    posX5y2.remove(posX3y2.first())
    posX5y2.remove(posX4y1.first())
    posX5y2.remove(posX4y2.first())
    posX5y2.remove(posX5y1.first())
    posX5y2.remove(posX6y1.first())

    val posX6y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y2.shuffle()
    posX6y2.remove(posX1y2.first())
    posX6y2.remove(posX2y2.first())
    posX6y2.remove(posX3y2.first())
    posX6y2.remove(posX4y1.first())
    posX6y2.remove(posX4y2.first())
    posX6y2.remove(posX5y1.first())
    posX6y2.remove(posX5y2.first())
    posX6y2.remove(posX6y1.first())

    val posX7y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y2.shuffle()
    posX7y2.remove(posX1y2.first())
    posX7y2.remove(posX2y2.first())
    posX7y2.remove(posX3y2.first())
    posX7y2.remove(posX4y2.first())
    posX7y2.remove(posX5y2.first())
    posX7y2.remove(posX6y2.first())
    posX7y2.remove(posX7y1.first())
    posX7y2.remove(posX8y1.first())
    posX7y2.remove(posX9y1.first())

    val posX8y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y2.shuffle()
    posX8y2.remove(posX1y2.first())
    posX8y2.remove(posX2y2.first())
    posX8y2.remove(posX3y2.first())
    posX8y2.remove(posX4y2.first())
    posX8y2.remove(posX5y2.first())
    posX8y2.remove(posX6y2.first())
    posX8y2.remove(posX7y1.first())
    posX8y2.remove(posX7y2.first())
    posX8y2.remove(posX8y1.first())
    posX8y2.remove(posX9y1.first())

    val posX9y2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y2.shuffle()
    posX9y2.remove(posX1y2.first())
    posX9y2.remove(posX2y2.first())
    posX9y2.remove(posX3y2.first())
    posX9y2.remove(posX4y2.first())
    posX9y2.remove(posX5y2.first())
    posX9y2.remove(posX6y2.first())
    posX9y2.remove(posX7y1.first())
    posX9y2.remove(posX7y2.first())
    posX9y2.remove(posX8y1.first())
    posX9y2.remove(posX8y2.first())
    posX9y2.remove(posX9y1.first())


    /* ROW 03 position values */
    val posX1y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y3.shuffle()
    posX1y3.remove(posX1y1.first())
    posX1y3.remove(posX1y2.first())
    posX1y3.remove(posX2y1.first())
    posX1y3.remove(posX2y2.first())
    posX1y3.remove(posX3y1.first())
    posX1y3.remove(posX3y2.first())

    val posX2y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y3.shuffle()
    posX2y3.remove(posX1y1.first())
    posX2y3.remove(posX1y2.first())
    posX2y3.remove(posX1y3.first())
    posX2y3.remove(posX2y1.first())
    posX2y3.remove(posX2y2.first())
    posX2y3.remove(posX3y1.first())
    posX2y3.remove(posX3y2.first())

    val posX3y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y3.shuffle()
    posX3y3.remove(posX1y1.first())
    posX3y3.remove(posX1y2.first())
    posX3y3.remove(posX1y3.first())
    posX3y3.remove(posX2y1.first())
    posX3y3.remove(posX2y2.first())
    posX3y3.remove(posX2y3.first())
    posX3y3.remove(posX3y1.first())
    posX3y3.remove(posX3y2.first())

    val posX4y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y3.shuffle()
    posX4y3.remove(posX1y3.first())
    posX4y3.remove(posX2y3.first())
    posX4y3.remove(posX3y3.first())
    posX4y3.remove(posX4y1.first())
    posX4y3.remove(posX4y2.first())
    posX4y3.remove(posX5y1.first())
    posX4y3.remove(posX5y2.first())
    posX4y3.remove(posX6y1.first())
    posX4y3.remove(posX6y2.first())

    val posX5y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y3.shuffle()
    posX5y3.remove(posX1y3.first())
    posX5y3.remove(posX2y3.first())
    posX5y3.remove(posX3y3.first())
    posX5y3.remove(posX4y1.first())
    posX5y3.remove(posX4y2.first())
    posX5y3.remove(posX4y3.first())
    posX5y3.remove(posX5y1.first())
    posX5y3.remove(posX5y2.first())
    posX5y3.remove(posX6y1.first())
    posX5y3.remove(posX6y2.first())

    val posX6y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y3.shuffle()
    posX6y3.remove(posX1y3.first())
    posX6y3.remove(posX2y3.first())
    posX6y3.remove(posX3y3.first())
    posX6y3.remove(posX4y1.first())
    posX6y3.remove(posX4y2.first())
    posX6y3.remove(posX4y3.first())
    posX6y3.remove(posX5y1.first())
    posX6y3.remove(posX5y2.first())
    posX6y3.remove(posX5y3.first())
    posX6y3.remove(posX6y1.first())
    posX6y3.remove(posX6y2.first())

    val posX7y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y3.shuffle()
    posX7y3.remove(posX1y3.first())
    posX7y3.remove(posX2y3.first())
    posX7y3.remove(posX3y3.first())
    posX7y3.remove(posX4y3.first())
    posX7y3.remove(posX5y3.first())
    posX7y3.remove(posX6y3.first())
    posX7y3.remove(posX7y1.first())
    posX7y3.remove(posX8y1.first())
    posX7y3.remove(posX9y1.first())

    val posX8y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y3.shuffle()
    posX8y3.remove(posX1y3.first())
    posX8y3.remove(posX2y3.first())
    posX8y3.remove(posX3y3.first())
    posX8y3.remove(posX4y3.first())
    posX8y3.remove(posX5y3.first())
    posX8y3.remove(posX6y3.first())
    posX8y3.remove(posX7y1.first())
    posX8y3.remove(posX7y2.first())
    posX8y3.remove(posX7y3.first())
    posX8y3.remove(posX8y1.first())
    posX8y3.remove(posX8y2.first())
    posX8y3.remove(posX9y1.first())
    posX8y3.remove(posX9y2.first())

    val posX9y3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y3.shuffle()
    posX9y3.remove(posX1y3.first())
    posX9y3.remove(posX2y3.first())
    posX9y3.remove(posX3y3.first())
    posX9y3.remove(posX4y3.first())
    posX9y3.remove(posX5y3.first())
    posX9y3.remove(posX6y3.first())
    posX9y3.remove(posX7y1.first())
    posX9y3.remove(posX7y2.first())
    posX9y3.remove(posX7y3.first())
    posX9y3.remove(posX8y1.first())
    posX9y3.remove(posX8y2.first())
    posX9y3.remove(posX8y3.first())
    posX9y3.remove(posX9y1.first())
    posX9y3.remove(posX9y2.first())


    /* ROW 04 position values */
    val posX1y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y4.shuffle()
    posX1y4.remove(posX1y1.first())
    posX1y4.remove(posX1y2.first())
    posX1y4.remove(posX1y3.first())

    val posX2y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y4.shuffle()
    posX2y4.remove(posX1y4.first())
    posX2y4.remove(posX2y1.first())
    posX2y4.remove(posX2y2.first())
    posX2y4.remove(posX2y3.first())

    val posX3y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y4.shuffle()
    posX3y4.remove(posX1y4.first())
    posX3y4.remove(posX2y4.first())
    posX3y4.remove(posX3y1.first())
    posX3y4.remove(posX3y2.first())
    posX3y4.remove(posX3y3.first())

    val posX4y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y4.shuffle()
    posX4y4.remove(posX1y4.first())
    posX4y4.remove(posX2y4.first())
    posX4y4.remove(posX3y4.first())
    posX4y4.remove(posX4y1.first())
    posX4y4.remove(posX4y2.first())
    posX4y4.remove(posX4y3.first())

    val posX5y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y4.shuffle()
    posX5y4.remove(posX1y4.first())
    posX5y4.remove(posX2y4.first())
    posX5y4.remove(posX3y4.first())
    posX5y4.remove(posX4y4.first())
    posX5y4.remove(posX5y1.first())
    posX5y4.remove(posX5y2.first())
    posX5y4.remove(posX5y3.first())

    val posX6y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y4.shuffle()
    posX6y4.remove(posX1y4.first())
    posX6y4.remove(posX2y4.first())
    posX6y4.remove(posX3y4.first())
    posX6y4.remove(posX4y4.first())
    posX6y4.remove(posX5y4.first())
    posX6y4.remove(posX6y1.first())
    posX6y4.remove(posX6y2.first())
    posX6y4.remove(posX6y3.first())

    val posX7y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y4.shuffle()
    posX7y4.remove(posX1y4.first())
    posX7y4.remove(posX2y4.first())
    posX7y4.remove(posX3y4.first())
    posX7y4.remove(posX4y4.first())
    posX7y4.remove(posX5y4.first())
    posX7y4.remove(posX6y4.first())
    posX7y4.remove(posX7y1.first())
    posX7y4.remove(posX7y2.first())
    posX7y4.remove(posX7y3.first())

    val posX8y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y4.shuffle()
    posX8y4.remove(posX1y4.first())
    posX8y4.remove(posX2y4.first())
    posX8y4.remove(posX3y4.first())
    posX8y4.remove(posX4y4.first())
    posX8y4.remove(posX5y4.first())
    posX8y4.remove(posX6y4.first())
    posX8y4.remove(posX7y4.first())
    posX8y4.remove(posX8y1.first())
    posX8y4.remove(posX8y2.first())
    posX8y4.remove(posX8y3.first())

    val posX9y4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y4.shuffle()
    posX9y4.remove(posX1y4.first())
    posX9y4.remove(posX2y4.first())
    posX9y4.remove(posX3y4.first())
    posX9y4.remove(posX4y4.first())
    posX9y4.remove(posX5y4.first())
    posX9y4.remove(posX6y4.first())
    posX9y4.remove(posX7y4.first())
    posX9y4.remove(posX8y4.first())
    posX9y4.remove(posX9y1.first())
    posX9y4.remove(posX9y2.first())
    posX9y4.remove(posX9y3.first())


    /* ROW 05 position values */
    val posX1y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y5.shuffle()
    posX1y5.remove(posX1y1.first())
    posX1y5.remove(posX1y2.first())
    posX1y5.remove(posX1y3.first())
    posX1y5.remove(posX1y4.first())
    posX1y5.remove(posX2y4.first())
    posX1y5.remove(posX3y4.first())

    val posX2y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y5.shuffle()
    posX2y5.remove(posX1y1.first())
    posX2y5.remove(posX1y2.first())
    posX2y5.remove(posX1y3.first())
    posX2y5.remove(posX1y4.first())
    posX2y5.remove(posX1y5.first())
    posX2y5.remove(posX2y4.first())
    posX2y5.remove(posX3y4.first())

    val posX3y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y5.shuffle()
    posX3y5.remove(posX1y1.first())
    posX3y5.remove(posX1y2.first())
    posX3y5.remove(posX1y3.first())
    posX3y5.remove(posX1y4.first())
    posX3y5.remove(posX1y5.first())
    posX3y5.remove(posX2y4.first())
    posX3y5.remove(posX2y5.first())
    posX3y5.remove(posX3y4.first())

    val posX4y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y5.shuffle()
    posX4y5.remove(posX1y5.first())
    posX4y5.remove(posX2y5.first())
    posX4y5.remove(posX3y5.first())
    posX4y5.remove(posX4y1.first())
    posX4y5.remove(posX4y2.first())
    posX4y5.remove(posX4y3.first())
    posX4y5.remove(posX4y4.first())
    posX4y5.remove(posX5y4.first())
    posX4y5.remove(posX6y4.first())

    val posX5y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y5.shuffle()
    posX5y5.remove(posX1y5.first())
    posX5y5.remove(posX2y5.first())
    posX5y5.remove(posX3y5.first())
    posX5y5.remove(posX4y4.first())
    posX5y5.remove(posX4y5.first())
    posX5y5.remove(posX5y1.first())
    posX5y5.remove(posX5y2.first())
    posX5y5.remove(posX5y3.first())
    posX5y5.remove(posX5y4.first())
    posX5y5.remove(posX6y4.first())

    val posX6y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y5.shuffle()
    posX6y5.remove(posX1y5.first())
    posX6y5.remove(posX2y5.first())
    posX6y5.remove(posX3y5.first())
    posX6y5.remove(posX4y4.first())
    posX6y5.remove(posX4y5.first())
    posX6y5.remove(posX5y4.first())
    posX6y5.remove(posX5y5.first())
    posX6y5.remove(posX6y1.first())
    posX6y5.remove(posX6y2.first())
    posX6y5.remove(posX6y3.first())
    posX6y5.remove(posX6y4.first())

    val posX7y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y5.shuffle()
    posX7y5.remove(posX1y5.first())
    posX7y5.remove(posX2y5.first())
    posX7y5.remove(posX3y5.first())
    posX7y5.remove(posX4y5.first())
    posX7y5.remove(posX5y5.first())
    posX7y5.remove(posX6y5.first())
    posX7y5.remove(posX7y1.first())
    posX7y5.remove(posX7y2.first())
    posX7y5.remove(posX7y3.first())
    posX7y5.remove(posX7y4.first())
    posX7y5.remove(posX8y4.first())
    posX7y5.remove(posX9y4.first())

    val posX8y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y5.shuffle()
    posX8y5.remove(posX1y5.first())
    posX8y5.remove(posX2y5.first())
    posX8y5.remove(posX3y5.first())
    posX8y5.remove(posX4y5.first())
    posX8y5.remove(posX5y5.first())
    posX8y5.remove(posX6y5.first())
    posX8y5.remove(posX7y4.first())
    posX8y5.remove(posX7y5.first())
    posX8y5.remove(posX8y1.first())
    posX8y5.remove(posX8y2.first())
    posX8y5.remove(posX8y3.first())
    posX8y5.remove(posX8y4.first())
    posX8y5.remove(posX9y4.first())

    val posX9y5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y5.shuffle()
    posX9y5.remove(posX1y5.first())
    posX9y5.remove(posX2y5.first())
    posX9y5.remove(posX3y5.first())
    posX9y5.remove(posX4y5.first())
    posX9y5.remove(posX5y5.first())
    posX9y5.remove(posX6y5.first())
    posX9y5.remove(posX7y4.first())
    posX9y5.remove(posX7y5.first())
    posX9y5.remove(posX8y4.first())
    posX9y5.remove(posX8y5.first())
    posX9y5.remove(posX9y1.first())
    posX9y5.remove(posX9y2.first())
    posX9y5.remove(posX9y3.first())
    posX9y5.remove(posX9y4.first())


    /* ROW 06 position values */
    val posX1y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y6.shuffle()
    posX1y6.remove(posX1y1.first())
    posX1y6.remove(posX1y2.first())
    posX1y6.remove(posX1y3.first())
    posX1y6.remove(posX1y4.first())
    posX1y6.remove(posX1y5.first())
    posX1y6.remove(posX2y4.first())
    posX1y6.remove(posX2y5.first())
    posX1y6.remove(posX3y4.first())
    posX1y6.remove(posX3y5.first())

    val posX2y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y6.shuffle()
    posX2y6.remove(posX1y6.first())
    posX2y6.remove(posX2y1.first())
    posX2y6.remove(posX2y2.first())
    posX2y6.remove(posX2y3.first())
    posX2y6.remove(posX2y4.first())
    posX2y6.remove(posX2y5.first())

    val posX3y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y6.shuffle()
    posX3y6.remove(posX1y4.first())
    posX3y6.remove(posX1y5.first())
    posX3y6.remove(posX1y6.first())
    posX3y6.remove(posX2y4.first())
    posX3y6.remove(posX2y5.first())
    posX3y6.remove(posX2y6.first())
    posX3y6.remove(posX3y1.first())
    posX3y6.remove(posX3y2.first())
    posX3y6.remove(posX3y3.first())
    posX3y6.remove(posX3y4.first())
    posX3y6.remove(posX3y5.first())

    val posX4y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y6.shuffle()
    posX4y6.remove(posX1y6.first())
    posX4y6.remove(posX2y6.first())
    posX4y6.remove(posX3y6.first())
    posX4y6.remove(posX4y1.first())
    posX4y6.remove(posX4y2.first())
    posX4y6.remove(posX4y3.first())
    posX4y6.remove(posX4y4.first())
    posX4y6.remove(posX4y5.first())
    posX4y6.remove(posX5y4.first())
    posX4y6.remove(posX5y5.first())
    posX4y6.remove(posX6y4.first())
    posX4y6.remove(posX6y5.first())

    val posX5y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y6.shuffle()
    posX5y6.remove(posX1y6.first())
    posX5y6.remove(posX2y6.first())
    posX5y6.remove(posX3y6.first())
    posX5y6.remove(posX4y5.first())
    posX5y6.remove(posX4y6.first())
    posX5y6.remove(posX5y1.first())
    posX5y6.remove(posX5y2.first())
    posX5y6.remove(posX5y3.first())
    posX5y6.remove(posX5y4.first())
    posX5y6.remove(posX5y5.first())
    posX5y6.remove(posX6y4.first())
    posX5y6.remove(posX6y5.first())

    val posX6y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y6.shuffle()
    posX6y6.remove(posX1y6.first())
    posX6y6.remove(posX2y6.first())
    posX6y6.remove(posX3y6.first())
    posX6y6.remove(posX4y4.first())
    posX6y6.remove(posX4y5.first())
    posX6y6.remove(posX4y6.first())
    posX6y6.remove(posX5y4.first())
    posX6y6.remove(posX5y5.first())
    posX6y6.remove(posX5y6.first())
    posX6y6.remove(posX6y1.first())
    posX6y6.remove(posX6y2.first())
    posX6y6.remove(posX6y3.first())
    posX6y6.remove(posX6y4.first())
    posX6y6.remove(posX6y5.first())

    val posX7y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y6.shuffle()
    posX7y6.remove(posX1y6.first())
    posX7y6.remove(posX2y6.first())
    posX7y6.remove(posX3y6.first())
    posX7y6.remove(posX4y6.first())
    posX7y6.remove(posX5y6.first())
    posX7y6.remove(posX6y6.first())
    posX7y6.remove(posX7y1.first())
    posX7y6.remove(posX7y2.first())
    posX7y6.remove(posX7y3.first())
    posX7y6.remove(posX7y4.first())
    posX7y6.remove(posX7y5.first())
    posX7y6.remove(posX8y4.first())
    posX7y6.remove(posX8y5.first())
    posX7y6.remove(posX9y4.first())
    posX7y6.remove(posX9y5.first())

    val posX8y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y6.shuffle()
    posX8y6.remove(posX1y6.first())
    posX8y6.remove(posX2y6.first())
    posX8y6.remove(posX3y6.first())
    posX8y6.remove(posX4y6.first())
    posX8y6.remove(posX5y6.first())
    posX8y6.remove(posX6y6.first())
    posX8y6.remove(posX7y4.first())
    posX8y6.remove(posX7y5.first())
    posX8y6.remove(posX7y6.first())
    posX8y6.remove(posX8y4.first())
    posX8y6.remove(posX8y5.first())
    posX8y6.remove(posX9y4.first())
    posX8y6.remove(posX9y5.first())

    val posX9y6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y6.shuffle()
    posX9y6.remove(posX1y6.first())
    posX9y6.remove(posX2y6.first())
    posX9y6.remove(posX3y6.first())
    posX9y6.remove(posX4y6.first())
    posX9y6.remove(posX5y6.first())
    posX9y6.remove(posX6y6.first())
    posX9y6.remove(posX7y4.first())
    posX9y6.remove(posX7y5.first())
    posX9y6.remove(posX7y6.first())
    posX9y6.remove(posX8y4.first())
    posX9y6.remove(posX8y5.first())
    posX9y6.remove(posX8y6.first())
    posX9y6.remove(posX9y4.first())
    posX9y6.remove(posX9y5.first())


    /* ROW 07 position values */
    val posX1y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y7.shuffle()
    posX1y7.remove(posX1y1.first())
    posX1y7.remove(posX1y2.first())
    posX1y7.remove(posX1y3.first())
    posX1y7.remove(posX1y4.first())
    posX1y7.remove(posX1y5.first())
    posX1y7.remove(posX1y6.first())


    val posX2y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y7.shuffle()
    posX2y7.remove(posX1y7.first())
    posX2y7.remove(posX2y1.first())
    posX2y7.remove(posX2y2.first())
    posX2y7.remove(posX2y3.first())
    posX2y7.remove(posX2y4.first())
    posX2y7.remove(posX2y5.first())
    posX2y7.remove(posX2y6.first())

    val posX3y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y7.shuffle()
    posX3y7.remove(posX1y7.first())
    posX3y7.remove(posX2y7.first())
    posX3y7.remove(posX3y1.first())
    posX3y7.remove(posX3y2.first())
    posX3y7.remove(posX3y3.first())
    posX3y7.remove(posX3y4.first())
    posX3y7.remove(posX3y5.first())
    posX3y7.remove(posX3y6.first())

    val posX4y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y7.shuffle()
    posX4y7.remove(posX1y7.first())
    posX4y7.remove(posX2y7.first())
    posX4y7.remove(posX3y7.first())
    posX4y7.remove(posX4y1.first())
    posX4y7.remove(posX4y2.first())
    posX4y7.remove(posX4y3.first())
    posX4y7.remove(posX4y4.first())
    posX4y7.remove(posX4y5.first())
    posX4y7.remove(posX4y6.first())

    val posX5y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y7.shuffle()
    posX5y7.remove(posX1y7.first())
    posX5y7.remove(posX2y7.first())
    posX5y7.remove(posX3y7.first())
    posX5y7.remove(posX4y7.first())
    posX5y7.remove(posX5y1.first())
    posX5y7.remove(posX5y2.first())
    posX5y7.remove(posX5y3.first())
    posX5y7.remove(posX5y4.first())
    posX5y7.remove(posX5y5.first())
    posX5y7.remove(posX5y6.first())

    val posX6y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y7.shuffle()
    posX6y7.remove(posX1y7.first())
    posX6y7.remove(posX2y7.first())
    posX6y7.remove(posX3y7.first())
    posX6y7.remove(posX4y7.first())
    posX6y7.remove(posX5y7.first())
    posX6y7.remove(posX6y1.first())
    posX6y7.remove(posX6y2.first())
    posX6y7.remove(posX6y3.first())
    posX6y7.remove(posX6y4.first())
    posX6y7.remove(posX6y5.first())
    posX6y7.remove(posX6y6.first())

    val posX7y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y7.shuffle()
    posX7y7.remove(posX1y7.first())
    posX7y7.remove(posX2y7.first())
    posX7y7.remove(posX3y7.first())
    posX7y7.remove(posX4y7.first())
    posX7y7.remove(posX5y7.first())
    posX7y7.remove(posX6y7.first())
    posX7y7.remove(posX7y1.first())
    posX7y7.remove(posX7y2.first())
    posX7y7.remove(posX7y3.first())
    posX7y7.remove(posX7y4.first())
    posX7y7.remove(posX7y5.first())
    posX7y7.remove(posX7y6.first())

    val posX8y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y7.shuffle()
    posX8y7.remove(posX1y7.first())
    posX8y7.remove(posX2y7.first())
    posX8y7.remove(posX3y7.first())
    posX8y7.remove(posX4y7.first())
    posX8y7.remove(posX5y7.first())
    posX8y7.remove(posX6y7.first())
    posX8y7.remove(posX7y7.first())
    posX8y7.remove(posX8y1.first())
    posX8y7.remove(posX8y2.first())
    posX8y7.remove(posX8y3.first())
    posX8y7.remove(posX8y4.first())
    posX8y7.remove(posX8y5.first())
    posX8y7.remove(posX8y6.first())

    val posX9y7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y7.shuffle()
    posX9y7.remove(posX1y7.first())
    posX9y7.remove(posX2y7.first())
    posX9y7.remove(posX3y7.first())
    posX9y7.remove(posX4y7.first())
    posX9y7.remove(posX5y7.first())
    posX9y7.remove(posX6y7.first())
    posX9y7.remove(posX7y7.first())
    posX9y7.remove(posX8y7.first())
    posX9y7.remove(posX9y1.first())
    posX9y7.remove(posX9y2.first())
    posX9y7.remove(posX9y3.first())
    posX9y7.remove(posX9y4.first())
    posX9y7.remove(posX9y5.first())
    posX9y7.remove(posX9y6.first())


    /* ROW 08 position values */
    val posX1y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y8.shuffle()
    posX1y8.remove(posX1y1.first())
    posX1y8.remove(posX1y2.first())
    posX1y8.remove(posX1y3.first())
    posX1y8.remove(posX1y4.first())
    posX1y8.remove(posX1y5.first())
    posX1y8.remove(posX1y6.first())
    posX1y8.remove(posX1y7.first())
    posX1y8.remove(posX2y7.first())
    posX1y8.remove(posX3y7.first())

    val posX2y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y8.shuffle()
    posX2y8.remove(posX1y7.first())
    posX2y8.remove(posX1y8.first())
    posX2y8.remove(posX2y1.first())
    posX2y8.remove(posX2y2.first())
    posX2y8.remove(posX2y3.first())
    posX2y8.remove(posX2y4.first())
    posX2y8.remove(posX2y5.first())
    posX2y8.remove(posX2y6.first())
    posX2y8.remove(posX2y7.first())
    posX2y8.remove(posX3y7.first())

    val posX3y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y8.shuffle()
    posX3y8.remove(posX1y7.first())
    posX3y8.remove(posX1y8.first())
    posX3y8.remove(posX2y7.first())
    posX3y8.remove(posX2y8.first())
    posX3y8.remove(posX3y1.first())
    posX3y8.remove(posX3y2.first())
    posX3y8.remove(posX3y3.first())
    posX3y8.remove(posX3y4.first())
    posX3y8.remove(posX3y5.first())
    posX3y8.remove(posX3y6.first())
    posX3y8.remove(posX3y7.first())

    val posX4y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y8.shuffle()
    posX4y8.remove(posX1y8.first())
    posX4y8.remove(posX2y8.first())
    posX4y8.remove(posX3y8.first())
    posX4y8.remove(posX4y1.first())
    posX4y8.remove(posX4y2.first())
    posX4y8.remove(posX4y3.first())
    posX4y8.remove(posX4y4.first())
    posX4y8.remove(posX4y5.first())
    posX4y8.remove(posX4y6.first())
    posX4y8.remove(posX4y7.first())
    posX4y8.remove(posX5y7.first())
    posX4y8.remove(posX6y7.first())

    val posX5y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y8.shuffle()
    posX5y8.remove(posX1y8.first())
    posX5y8.remove(posX2y8.first())
    posX5y8.remove(posX3y8.first())
    posX5y8.remove(posX4y7.first())
    posX5y8.remove(posX4y8.first())
    posX5y8.remove(posX5y1.first())
    posX5y8.remove(posX5y2.first())
    posX5y8.remove(posX5y3.first())
    posX5y8.remove(posX5y4.first())
    posX5y8.remove(posX5y5.first())
    posX5y8.remove(posX5y6.first())
    posX5y8.remove(posX5y7.first())
    posX5y8.remove(posX6y7.first())

    val posX6y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y8.shuffle()
    posX6y8.remove(posX1y8.first())
    posX6y8.remove(posX2y8.first())
    posX6y8.remove(posX3y8.first())
    posX6y8.remove(posX4y7.first())
    posX6y8.remove(posX4y8.first())
    posX6y8.remove(posX5y1.first())
    posX6y8.remove(posX5y2.first())
    posX6y8.remove(posX5y3.first())
    posX6y8.remove(posX5y4.first())
    posX6y8.remove(posX5y5.first())
    posX6y8.remove(posX5y6.first())
    posX6y8.remove(posX5y7.first())
    posX6y8.remove(posX5y8.first())
    posX6y8.remove(posX6y7.first())

    val posX7y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y8.shuffle()
    posX7y8.remove(posX1y8.first())
    posX7y8.remove(posX2y8.first())
    posX7y8.remove(posX3y8.first())
    posX7y8.remove(posX4y8.first())
    posX7y8.remove(posX5y8.first())
    posX7y8.remove(posX6y8.first())
    posX7y8.remove(posX7y1.first())
    posX7y8.remove(posX7y2.first())
    posX7y8.remove(posX7y3.first())
    posX7y8.remove(posX7y4.first())
    posX7y8.remove(posX7y5.first())
    posX7y8.remove(posX7y6.first())
    posX7y8.remove(posX7y7.first())
    posX7y8.remove(posX8y7.first())
    posX7y8.remove(posX9y7.first())

    val posX8y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y8.shuffle()
    posX8y8.remove(posX1y8.first())
    posX8y8.remove(posX2y8.first())
    posX8y8.remove(posX3y8.first())
    posX8y8.remove(posX4y8.first())
    posX8y8.remove(posX5y8.first())
    posX8y8.remove(posX6y8.first())
    posX8y8.remove(posX7y8.first())
    posX8y8.remove(posX8y1.first())
    posX8y8.remove(posX8y2.first())
    posX8y8.remove(posX8y3.first())
    posX8y8.remove(posX8y4.first())
    posX8y8.remove(posX8y5.first())
    posX8y8.remove(posX8y6.first())
    posX8y8.remove(posX8y7.first())
    posX8y8.remove(posX9y7.first())

    val posX9y8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y8.shuffle()
    posX9y8.remove(posX1y8.first())
    posX9y8.remove(posX2y8.first())
    posX9y8.remove(posX3y8.first())
    posX9y8.remove(posX4y8.first())
    posX9y8.remove(posX5y8.first())
    posX9y8.remove(posX6y8.first())
    posX9y8.remove(posX7y8.first())
    posX9y8.remove(posX8y7.first())
    posX9y8.remove(posX8y8.first())
    posX9y8.remove(posX9y1.first())
    posX9y8.remove(posX9y2.first())
    posX9y8.remove(posX9y3.first())
    posX9y8.remove(posX9y4.first())
    posX9y8.remove(posX9y5.first())
    posX9y8.remove(posX9y6.first())
    posX9y8.remove(posX9y7.first())


    /* ROW 09 position values */
    val posX1y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX1y9.shuffle()
    posX1y9.remove(posX1y1.first())
    posX1y9.remove(posX1y2.first())
    posX1y9.remove(posX1y3.first())
    posX1y9.remove(posX1y4.first())
    posX1y9.remove(posX1y5.first())
    posX1y9.remove(posX1y6.first())
    posX1y9.remove(posX1y7.first())
    posX1y9.remove(posX1y8.first())

    val posX2y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX2y9.shuffle()
    posX2y9.remove(posX1y7.first())
    posX2y9.remove(posX1y8.first())
    posX2y9.remove(posX1y9.first())
    posX2y9.remove(posX2y1.first())
    posX2y9.remove(posX2y2.first())
    posX2y9.remove(posX2y3.first())
    posX2y9.remove(posX2y4.first())
    posX2y9.remove(posX2y5.first())
    posX2y9.remove(posX2y6.first())
    posX2y9.remove(posX2y7.first())
    posX2y9.remove(posX2y8.first())
    posX2y9.remove(posX3y7.first())
    posX2y9.remove(posX3y8.first())

    val posX3y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX3y9.shuffle()
    posX3y9.remove(posX1y7.first())
    posX3y9.remove(posX1y8.first())
    posX3y9.remove(posX1y9.first())
    posX3y9.remove(posX2y7.first())
    posX3y9.remove(posX2y8.first())
    posX3y9.remove(posX2y9.first())
    posX3y9.remove(posX3y1.first())
    posX3y9.remove(posX3y2.first())
    posX3y9.remove(posX3y3.first())
    posX3y9.remove(posX3y4.first())
    posX3y9.remove(posX3y5.first())
    posX3y9.remove(posX3y6.first())
    posX3y9.remove(posX3y7.first())
    posX3y9.remove(posX3y8.first())
    posX3y9.remove(posX3y7.first())
    posX3y9.remove(posX3y8.first())

    val posX4y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX4y9.shuffle()
    posX4y9.remove(posX1y9.first())
    posX4y9.remove(posX2y9.first())
    posX4y9.remove(posX3y9.first())
    posX4y9.remove(posX4y1.first())
    posX4y9.remove(posX4y2.first())
    posX4y9.remove(posX4y3.first())
    posX4y9.remove(posX4y4.first())
    posX4y9.remove(posX4y5.first())
    posX4y9.remove(posX4y6.first())
    posX4y9.remove(posX4y7.first())
    posX4y9.remove(posX4y8.first())
    posX4y9.remove(posX5y7.first())
    posX4y9.remove(posX5y8.first())
    posX4y9.remove(posX6y7.first())
    posX4y9.remove(posX6y8.first())

    val posX5y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX5y9.shuffle()
    posX5y9.remove(posX1y9.first())
    posX5y9.remove(posX2y9.first())
    posX5y9.remove(posX3y9.first())
    posX5y9.remove(posX4y7.first())
    posX5y9.remove(posX4y8.first())
    posX5y9.remove(posX4y9.first())
    posX5y9.remove(posX5y1.first())
    posX5y9.remove(posX5y2.first())
    posX5y9.remove(posX5y3.first())
    posX5y9.remove(posX5y4.first())
    posX5y9.remove(posX5y5.first())
    posX5y9.remove(posX5y6.first())
    posX5y9.remove(posX5y7.first())
    posX5y9.remove(posX5y8.first())
    posX5y9.remove(posX6y7.first())
    posX5y9.remove(posX6y8.first())

    val posX6y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX6y9.shuffle()
    posX6y9.remove(posX1y9.first())
    posX6y9.remove(posX2y9.first())
    posX6y9.remove(posX3y9.first())
    posX6y9.remove(posX4y7.first())
    posX6y9.remove(posX4y8.first())
    posX6y9.remove(posX4y9.first())
    posX6y9.remove(posX5y7.first())
    posX6y9.remove(posX5y8.first())
    posX6y9.remove(posX5y9.first())
    posX6y9.remove(posX6y1.first())
    posX6y9.remove(posX6y2.first())
    posX6y9.remove(posX6y3.first())
    posX6y9.remove(posX6y4.first())
    posX6y9.remove(posX6y5.first())
    posX6y9.remove(posX6y6.first())
    posX6y9.remove(posX6y7.first())
    posX6y9.remove(posX6y8.first())

    val posX7y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX7y9.shuffle()
    posX7y9.remove(posX1y9.first())
    posX7y9.remove(posX2y9.first())
    posX7y9.remove(posX3y9.first())
    posX7y9.remove(posX4y9.first())
    posX7y9.remove(posX5y9.first())
    posX7y9.remove(posX6y9.first())
    posX7y9.remove(posX7y1.first())
    posX7y9.remove(posX7y2.first())
    posX7y9.remove(posX7y3.first())
    posX7y9.remove(posX7y4.first())
    posX7y9.remove(posX7y5.first())
    posX7y9.remove(posX7y6.first())
    posX7y9.remove(posX7y7.first())
    posX7y9.remove(posX7y8.first())
    posX7y9.remove(posX8y7.first())
    posX7y9.remove(posX8y8.first())
    posX7y9.remove(posX9y7.first())
    posX7y9.remove(posX9y8.first())

    val posX8y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX8y9.shuffle()
    posX8y9.remove(posX1y9.first())
    posX8y9.remove(posX2y9.first())
    posX8y9.remove(posX3y9.first())
    posX8y9.remove(posX4y9.first())
    posX8y9.remove(posX5y9.first())
    posX8y9.remove(posX6y9.first())
    posX8y9.remove(posX7y7.first())
    posX8y9.remove(posX7y8.first())
    posX8y9.remove(posX7y9.first())
    posX8y9.remove(posX8y1.first())
    posX8y9.remove(posX8y2.first())
    posX8y9.remove(posX8y3.first())
    posX8y9.remove(posX8y4.first())
    posX8y9.remove(posX8y5.first())
    posX8y9.remove(posX8y6.first())
    posX8y9.remove(posX8y7.first())
    posX8y9.remove(posX8y8.first())
    posX8y9.remove(posX9y7.first())
    posX8y9.remove(posX9y8.first())

    val posX9y9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    posX9y9.shuffle()
    posX9y9.remove(posX1y9.first())
    posX9y9.remove(posX2y9.first())
    posX9y9.remove(posX3y9.first())
    posX9y9.remove(posX4y9.first())
    posX9y9.remove(posX5y9.first())
    posX9y9.remove(posX6y9.first())
    posX9y9.remove(posX7y7.first())
    posX9y9.remove(posX7y8.first())
    posX9y9.remove(posX7y9.first())
    posX9y9.remove(posX8y7.first())
    posX9y9.remove(posX8y8.first())
    posX9y9.remove(posX8y9.first())
    posX9y9.remove(posX9y1.first())
    posX9y9.remove(posX9y2.first())
    posX9y9.remove(posX9y3.first())
    posX9y9.remove(posX9y4.first())
    posX9y9.remove(posX9y5.first())
    posX9y9.remove(posX9y6.first())
    posX9y9.remove(posX9y7.first())
    posX9y9.remove(posX9y8.first())


    val slice1 = mutableListOf(0)
    val slice2 = mutableListOf(0)
    val slice3 = mutableListOf(0)
    val tmpSlice = mutableListOf(0)

    val grid01 = GridList(
        x1y1 = posX1y1[0],
        x2y1 = posX2y1[0],
        x3y1 = posX3y1[0],
        x1y2 = posX1y2.first(),
        x2y2 = posX2y2[0],
        x3y2 = posX3y2[0],
        x1y3 = posX1y3[0],
        x2y3 = posX2y3[0],
        x3y3 = posX3y3[0]
    )

    val grid02 = GridList(
        x1y1 = posX4y1[0],
        x2y1 = posX5y1[0],
        x3y1 = posX6y1[0],
        x1y2 = posX4y2[0],
        x2y2 = posX5y2[0],
        x3y2 = posX6y2[0],
        x1y3 = posX4y3[0],
        x2y3 = posX5y3[0],
        x3y3 = posX6y3[0]
    )

    val grid03 = GridList(
        x1y1 = posX7y1[0],
        x2y1 = posX8y1[0],
        x3y1 = posX9y1[0],
        x1y2 = posX7y2[0],
        x2y2 = posX8y2[0],
        x3y2 = posX9y2[0],
        x1y3 = posX7y3[0],
        x2y3 = posX8y3[0],
        x3y3 = posX9y3[0]
    )

    val grid04 = GridList(
        x1y1 = posX1y4[0],
        x2y1 = posX2y4[0],
        x3y1 = posX3y4[0],
        x1y2 = posX1y5[0],
        x2y2 = posX2y5[0],
        x3y2 = posX3y5[0],
        x1y3 = posX1y6[0],
        x2y3 = posX2y6[0],
        x3y3 = posX3y6[0]
    )

    val grid05 = GridList(
        x1y1 = posX4y4[0],
        x2y1 = posX5y4[0],
        x3y1 = posX6y4[0],
        x1y2 = posX4y5[0],
        x2y2 = posX5y5[0],
        x3y2 = posX6y5[0],
        x1y3 = posX4y6[0],
        x2y3 = posX5y6[0],
        x3y3 = posX6y6[0]
    )

    val grid06 = GridList(
        x1y1 = posX7y4[0],
        x2y1 = posX8y4[0],
        x3y1 = posX9y4[0],
        x1y2 = posX7y5[0],
        x2y2 = posX8y5[0],
        x3y2 = posX9y5[0],
        x1y3 = posX7y6[0],
        x2y3 = posX8y6[0],
        x3y3 = posX9y6[0]
    )

    val grid07 = GridList(
        x1y1 = posX1y7[0],
        x2y1 = posX2y7[0],
        x3y1 = posX3y7[0],
        x1y2 = posX1y8[0],
        x2y2 = posX2y8[0],
        x3y2 = posX3y8[0],
        x1y3 = posX1y9[0],
        x2y3 = posX2y9[0],
        x3y3 = posX3y9[0]
    )

    val grid08 = GridList(
        x1y1 = posX4y7[0],
        x2y1 = posX5y7[0],
        x3y1 = posX6y7[0],
        x1y2 = posX4y8[0],
        x2y2 = posX5y8[0],
        x3y2 = posX6y8[0],
        x1y3 = posX4y9[0],
        x2y3 = posX5y9[0],
        x3y3 = posX6y9[0]
    )

    val grid09 = GridList(
        x1y1 = posX7y7[0],
        x2y1 = posX8y7[0],
        x3y1 = posX9y7[0],
        x1y2 = posX7y8[0],
        x2y2 = posX8y8[0],
        x3y2 = posX9y8[0],
        x1y3 = posX7y9[0],
        x2y3 = posX8y9[0],
        x3y3 = posX9y9[0]
    )

    // while (grid01.x1y1.count() > 1){
    //     grid01.x1y1.remove(grid01.x1y1.last())
    // }

    // if (grid01.x1y1.count() > 1){
    //     val tmp = grid01.x1y1[0]
    //     grid01.x1y1.clear()
    //     grid01.x1y1.add(tmp)
    // }

    // xValue = grid01.x1y1.first()

    // grid02.x1y1.remove(grid01.x1y1.first())
    // grid03.x1y1.remove(grid01.x1y1.first())
    // grid04.x1y1.remove(grid01.x1y1.first())
    // grid05.x1y1.remove(grid01.x1y1.first())
    // grid06.x1y1.remove(grid01.x1y1.first())
    // grid07.x1y1.remove(grid01.x1y1.first())
    // grid08.x1y1.remove(grid01.x1y1.first())
    // grid09.x1y1.remove(grid01.x1y1.first())



    /* row 01 */
    /* x1y1 - Grid1 TopLeft */
    val x1y1 = GridCell(
        xPosition = 1,
        yPosition = 1,
        value = grid01.x1y1,
        txtColour = Black,
        hidden = false
    )

    /* x2y1 - Grid1 TopLeft */
    val x2y1 = GridCell(
        xPosition = 2,
        yPosition = 1,
        value = grid01.x2y1,
        txtColour = Black,
        hidden = false
    )

    /* x3y1 - Grid1 TopLeft */
    val x3y1 = GridCell(
        xPosition = 3,
        yPosition = 1,
        value = grid01.x3y1,
        txtColour = Black,
        hidden = false
    )

    /* x4y1 - Grid2 TopCenter */
    val x4y1 = GridCell(
        xPosition = 4,
        yPosition = 1,
        value = grid02.x1y1,
        txtColour = Red,
        hidden = false
    )

    /* x5y1 - Grid2 TopCenter */
    val x5y1 = GridCell(
        xPosition = 5,
        yPosition = 1,
        value = grid02.x2y1,
        txtColour = Red,
        hidden = false
    )

    /* x6y1 - Grid2 TopCenter */
    val x6y1 = GridCell(
        xPosition = 6,
        yPosition = 1,
        value = grid02.x3y1,
        txtColour = Red,
        hidden = false
    )

    /* x7y1 - Grid3 TopRight */
    val x7y1 = GridCell(
        xPosition = 7,
        yPosition = 1,
        value = grid03.x1y1,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x8y1 - Grid3 TopRight */
    val x8y1 = GridCell(
        xPosition = 8,
        yPosition = 1,
        value = grid03.x2y1,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x9y1 - Grid3 TopRight */
    val x9y1 = GridCell(
        xPosition = 9,
        yPosition = 1,
        value = grid03.x3y1,
        txtColour = NeonGreen,
        hidden = false
    )


    /* column 01 */
    /* x1y2 - Grid1 TopLeft */
    val x1y2 = GridCell(
        xPosition = 1,
        yPosition = 2,
        value = grid01.x1y2,
        txtColour = Black,
        hidden = false
    )

    /* x1y3 - Grid1 TopLeft */
    val x1y3 = GridCell(
        xPosition = 1,
        yPosition = 3,
        value = grid01.x1y3,
        txtColour = Black,
        hidden = false
    )

    /* x1y4 - Grid4 MiddleLeft */
    val x1y4 = GridCell(
        xPosition = 1,
        yPosition = 4,
        value = grid04.x1y1,
        txtColour = Blue,
        hidden = false
    )

    /* x1y5 - Grid4 MiddleLeft */
    val x1y5 = GridCell(
        xPosition = 1,
        yPosition = 5,
        value = grid04.x1y2,
        txtColour = Blue,
        hidden = false
    )

    /* x1y6 - Grid4 MiddleLeft */
    val x1y6 = GridCell(
        xPosition = 1,
        yPosition = 6,
        value = grid04.x1y3,
        txtColour = Blue,
        hidden = false
    )

    /* x1y7 - Grid7 BottomLeft */
    val x1y7 = GridCell(
        xPosition = 1,
        yPosition = 7,
        value = grid07.x1y1,
        txtColour = Purple40,
        hidden = false
    )

    /* x1y8 - Grid7 BottomLeft */
    val x1y8 = GridCell(
        xPosition = 1,
        yPosition = 8,
        value = grid07.x1y2,
        txtColour = Purple40,
        hidden = false
    )

    /* x1y9 - Grid7 BottomLeft */
    val x1y9 = GridCell(
        xPosition = 1,
        yPosition = 9,
        value = grid07.x1y3,
        txtColour = Purple40,
        hidden = false
    )

    /* Grid1 TopLeft */
    /* row 02 */
    /* x2y2 - Grid1 TopLeft */
    val x2y2 = GridCell(
        xPosition = 2,
        yPosition = 2,
        value = grid01.x2y2,
        txtColour = Black,
        hidden = false
    )

    /* x3y2 - Grid1 TopLeft */
    val x3y2 = GridCell(
        xPosition = 3,
        yPosition = 2,
        value = grid01.x3y2,
        txtColour = Black,
        hidden = false
    )

    /* row 3 */
    /* x2y3 - Grid1 TopLeft */
    val x2y3 = GridCell(
        xPosition = 2,
        yPosition = 3,
        value = grid01.x2y3,
        txtColour = Black,
        hidden = false
    )

    /* x3y3 - Grid1 TopLeft */
    val x3y3 = GridCell(
        xPosition = 3,
        yPosition = 3,
        value = grid01.x3y3,
        txtColour = Black,
        hidden = false
    )

    /* Grid2 TopCenter */
    /* row 2 */
    /* x4y2 - Grid2 TopCenter */
    val x4y2 = GridCell(
        xPosition = 4,
        yPosition = 2,
        value = grid02.x1y2,
        txtColour = Red,
        hidden = false
    )

    /* x5y2 - Grid2 TopCenter */
    val x5y2 = GridCell(
        xPosition = 5,
        yPosition = 2,
        value = grid02.x2y2,
        txtColour = Red,
        hidden = false
    )

    /* x6y2 - Grid2 TopCenter */
    val x6y2 = GridCell(
        xPosition = 6,
        yPosition = 2,
        value = grid02.x3y2,
        txtColour = Red,
        hidden = false
    )


    /* Grid2 TopCenter */
    /* row 3 */
    /* x4y3 - Grid2 TopCenter */
    val x4y3 = GridCell(
        xPosition = 4,
        yPosition = 3,
        value = grid02.x1y3,
        txtColour = Red,
        hidden = false
    )

    /* x5y3 - Grid2 TopCenter */
    val x5y3 = GridCell(
        xPosition = 5,
        yPosition = 3,
        value = grid02.x2y3,
        txtColour = Red,
        hidden = false
    )

    /* x6y3 - Grid2 TopCenter */
    val x6y3 = GridCell(
        xPosition = 6,
        yPosition = 3,
        value = grid02.x3y3,
        txtColour = Red,
        hidden = false
    )


    /* Grid3 TopRight */
    /* row 2 */
    /* x7y2 - Grid3 TopRight */
    val x7y2 = GridCell(
        xPosition = 7,
        yPosition = 2,
        value = grid03.x1y2,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x8y2 - Grid3 TopRight */
    val x8y2 = GridCell(
        xPosition = 8,
        yPosition = 2,
        value = grid03.x2y2,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x9y2 - Grid3 TopRight */
    val x9y2 = GridCell(
        xPosition = 9,
        yPosition = 2,
        value = grid03.x3y2,
        txtColour = NeonGreen,
        hidden = false
    )

    /* row 3 */
    /* x7y3 - Grid3 TopRight */
    val x7y3 = GridCell(
        xPosition = 7,
        yPosition = 3,
        value = grid03.x1y3,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x8y3 - Grid3 TopRight */
    val x8y3 = GridCell(
        xPosition = 8,
        yPosition = 3,
        value = grid03.x2y3,
        txtColour = NeonGreen,
        hidden = false
    )

    /* x9y3 - Grid3 TopRight */
    val x9y3 = GridCell(
        xPosition = 9,
        yPosition = 3,
        value = grid03.x3y3,
        txtColour = NeonGreen,
        hidden = false
    )

    /* Grid4 MiddleLeft */
    /* row 4 */
    /* x2y4 - Grid4 MiddleLeft */
    val x2y4 = GridCell(
        xPosition = 2,
        yPosition = 4,
        value = grid04.x2y1,
        txtColour = Blue,
        hidden = false
    )

    /* x3y4 - Grid4 MiddleLeft */
    val x3y4 = GridCell(
        xPosition = 3,
        yPosition = 4,
        value = grid04.x3y1,
        txtColour = Blue,
        hidden = false
    )

    /* row 2 */
    /* x2y5 - Grid4 MiddleLeft */
    val x2y5 = GridCell(
        xPosition = 2,
        yPosition = 5,
        value = grid04.x2y2,
        txtColour = Blue,
        hidden = false
    )

    /* x3y5 - Grid4 MiddleLeft */
    val x3y5 = GridCell(
        xPosition = 3,
        yPosition = 5,
        value = grid04.x3y2,
        txtColour = Blue,
        hidden = false
    )

    /* x2y6 - Grid4 MiddleLeft */
    val x2y6 = GridCell(
        xPosition = 2,
        yPosition = 6,
        value = grid04.x2y3,
        txtColour = Blue,
        hidden = false
    )

    /* x3y6 - Grid4 MiddleLeft */
    val x3y6 = GridCell(
        xPosition = 3,
        yPosition = 6,
        value = grid04.x3y3,
        txtColour = Blue,
        hidden = false
    )

    /* Grid5 Center */
    /* row 4 */
    /* x4y4 - Grid5 Center */
    val x4y4 = GridCell(
        xPosition = 4,
        yPosition = 4,
        value = grid05.x1y1,
        txtColour = Gold,
        hidden = false
    )


    /* x5y4 - Grid5 Center */
    val x5y4 = GridCell(
        xPosition = 5,
        yPosition = 4,
        value = grid05.x2y1,
        txtColour = Gold,
        hidden = false
    )


    /* x6y4 - Grid5 Center */
    val x6y4 = GridCell(
        xPosition = 6,
        yPosition = 4,
        value = grid05.x3y1,
        txtColour = Gold,
        hidden = false
    )


    /* row 5 */
    /* x4y5 - Grid5 Center */
    val x4y5 = GridCell(
        xPosition = 4,
        yPosition = 5,
        value = grid05.x1y2,
        txtColour = Gold,
        hidden = false
    )


    /* x5y5 - Grid5 Center */
    val x5y5 = GridCell(
        xPosition = 5,
        yPosition = 5,
        value = grid05.x2y2,
        txtColour = Gold,
        hidden = false
    )

    /* x6y5 - Grid5 Center */
    val x6y5 = GridCell(
        xPosition = 6,
        yPosition = 5,
        value = grid05.x3y2,
        txtColour = Gold,
        hidden = false
    )


    /* row 6 */
    /* x4y6 - Grid5 Center */
    val x4y6 = GridCell(
        xPosition = 4,
        yPosition = 6,
        value = grid05.x1y3,
        txtColour = Gold,
        hidden = false
    )


    /* x5y6 - Grid5 Center */
    val x5y6 = GridCell(
        xPosition = 5,
        yPosition = 6,
        value = grid05.x2y3,
        txtColour = Gold,
        hidden = false
    )


    /* x6y6 - Grid5 Center */
    val x6y6 = GridCell(
        xPosition = 6,
        yPosition = 6,
        value = grid05.x3y3,
        txtColour = Gold,
        hidden = false
    )

    /* Grid6 MiddleRight */
    /* row 4 */
    /* x7y4 - Grid6 MiddleRight */
    val x7y4 = GridCell(
        xPosition = 7,
        yPosition = 4,
        value = grid06.x1y1,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x8y4 - Grid6 MiddleRight */
    val x8y4 = GridCell(
        xPosition = 8,
        yPosition = 4,
        value = grid06.x2y1,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x9y4 - Grid6 MiddleRight */
    val x9y4 = GridCell(
        xPosition = 9,
        yPosition = 4,
        value = grid06.x3y1,
        txtColour = DarkGrey,
        hidden = false
    )


    /* row 5 */
    /* x7y5 - Grid6 MiddleRight */
    val x7y5 = GridCell(
        xPosition = 7,
        yPosition = 5,
        value = grid06.x1y2,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x8y5 - Grid6 MiddleRight */
    val x8y5 = GridCell(
        xPosition = 8,
        yPosition = 5,
        value = grid06.x2y2,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x9y5 - Grid6 MiddleRight */
    val x9y5 = GridCell(
        xPosition = 9,
        yPosition = 5,
        value = grid06.x3y2,
        txtColour = DarkGrey,
        hidden = false
    )

    /* row 6 */
    /* x7y6 - Grid6 MiddleRight */
    val x7y6 = GridCell(
        xPosition = 7,
        yPosition = 6,
        value = grid06.x1y3,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x8y6 - Grid6 MiddleRight */
    val x8y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = grid06.x2y3,
        txtColour = DarkGrey,
        hidden = false
    )

    /* x9y6 - Grid6 MiddleRight */
    val x9y6 = GridCell(
        xPosition = 8,
        yPosition = 6,
        value = grid06.x3y3,
        txtColour = DarkGrey,
        hidden = false
    )

    /* Grid7 BottomLeft */
    /* row 7 */
    /* x2y7 - Grid7 BottomLeft */
    val x2y7 = GridCell(
        xPosition = 2,
        yPosition = 7,
        value = grid07.x1y1,
        txtColour = Purple40,
        hidden = false
    )

    /* x3y7 - Grid7 BottomLeft */
    val x3y7 = GridCell(
        xPosition = 3,
        yPosition = 7,
        value = grid07.x2y1,
        txtColour = Purple40,
        hidden = false
    )

    /* row 8 */
    /* x2y8 - Grid7 BottomLeft */
    val x2y8 = GridCell(
        xPosition = 2,
        yPosition = 8,
        value = grid07.x3y1,
        txtColour = Purple40,
        hidden = false
    )

    /* x3y8 - Grid7 BottomLeft */
    val x3y8 = GridCell(
        xPosition = 3,
        yPosition = 8,
        value = grid07.x1y2,
        txtColour = Purple40,
        hidden = false
    )

    /* row 9 */
    /* x2y9 - Grid7 BottomLeft */
    val x2y9 = GridCell(
        xPosition = 2,
        yPosition = 9,
        value = grid07.x2y2,
        txtColour = Purple40,
        hidden = false
    )

    /* x3y9 - Grid7 BottomLeft */
    val x3y9 = GridCell(
        xPosition = 3,
        yPosition = 9,
        value = grid07.x3y2,
        txtColour = Purple40,
        hidden = false
    )

    /* Grid8 BottomCenter */
    /* row 7 */
    /* x4y7 - Grid8 BottomCenter */
    val x4y7 = GridCell(
        xPosition = 4,
        yPosition = 7,
        value = grid07.x1y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* x5y7 - Grid8 BottomCenter */
    val x5y7 = GridCell(
        xPosition = 5,
        yPosition = 7,
        value = grid07.x2y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* x6y7 - Grid8 BottomCenter */
    val x6y7 = GridCell(
        xPosition = 6,
        yPosition = 7,
        value = grid07.x3y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* row 8 */
    /* x4y8 - Grid8 BottomCenter */
    val x4y8 = GridCell(
        xPosition = 4,
        yPosition = 8,
        value = grid08.x1y2,
        txtColour = MathBlue,
        hidden = false
    )

    /* x5y8 - Grid8 BottomCenter */
    val x5y8 = GridCell(
        xPosition = 5,
        yPosition = 8,
        value = grid08.x2y2,
        txtColour = MathBlue,
        hidden = false
    )

    /* x6y8 - Grid8 BottomCenter */
    val x6y8 = GridCell(
        xPosition = 6,
        yPosition = 8,
        value = grid08.x3y2,
        txtColour = MathBlue,
        hidden = false
    )

    /* row 9 */
    /* x4y9 - Grid8 BottomCenter */
    val x4y9 = GridCell(
        xPosition = 4,
        yPosition = 9,
        value = grid08.x1y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* x5y9 - Grid8 BottomCenter */
    val x5y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = grid08.x2y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* x6y9 - Grid8 BottomCenter */
    val x6y9 = GridCell(
        xPosition = 5,
        yPosition = 9,
        value = grid08.x3y3,
        txtColour = MathBlue,
        hidden = false
    )

    /* Grid9 BottomRight */
    /* row 7 */
    /* x7y7 - Grid9 BottomRight */
    val x7y7 = GridCell(
        xPosition = 7,
        yPosition = 7,
        value = grid09.x1y1,
        txtColour = Pink,
        hidden = false
    )

    /* x8y7 - Grid9 BottomRight */
    val x8y7 = GridCell(
        xPosition = 8,
        yPosition = 7,
        value = grid09.x2y1,
        txtColour = Pink,
        hidden = false
    )

    /* x9y7 - Grid9 BottomRight */
    val x9y7 = GridCell(
        xPosition = 9,
        yPosition = 7,
        value = grid09.x3y1,
        txtColour = Pink,
        hidden = false
    )

    /* row 8 */
    /* x7y8 - Grid9 BottomRight */
    val x7y8 = GridCell(
        xPosition = 7,
        yPosition = 8,
        value = grid09.x1y2,
        txtColour = Pink,
        hidden = false
    )

    /* x8y8 - Grid9 BottomRight */
    val x8y8 = GridCell(
        xPosition = 8,
        yPosition = 8,
        value = grid09.x2y2,
        txtColour = Pink,
        hidden = false
    )

    /* x9y8 - Grid9 BottomRight */
    val x9y8 = GridCell(
        xPosition = 9,
        yPosition = 8,
        value = grid09.x3y2,
        txtColour = Pink,
        hidden = false
    )

    /* row 9 */
    /* x7y9 - Grid9 BottomRight */
    val x7y9 = GridCell(
        xPosition = 7,
        yPosition = 9,
        value = grid09.x1y3,
        txtColour = Pink,
        hidden = false
    )

    /* x8y9 - Grid9 BottomRight */
    val x8y9 = GridCell(
        xPosition = 8,
        yPosition = 9,
        value = grid09.x2y3,
        txtColour = Pink,
        hidden = false
    )

    /* x9y9 - Grid9 BottomRight */
    val x9y9 = GridCell(
        xPosition = 9,
        yPosition = 9,
        value = grid09.x3y3,
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