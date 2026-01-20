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
import com.gdd.drakessudoku.components.ColouredText
import com.gdd.drakessudoku.ui.theme.*
import com.gdd.drakessudoku.utils.getGridSet

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

@Composable
fun AppCore(modifier: Modifier = Modifier) {

    val seed = 1
    // val initialSeed = (1..9).random()
    val txtMod = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod2 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod3 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod4 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod5 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod6 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod7 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod8 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
    val txtMod9 = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)


    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val tmpNums = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val row2Tmp = mutableListOf(0)
    val row1 = mutableListOf(seed)
    val col1 = mutableListOf(seed)
    val row2 = mutableListOf(seed)
    val row3 = mutableListOf(seed)
    val grid1 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // val grid2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid2 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid3 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid3 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid4 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid4 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid5 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid5 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid6 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid6 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid7 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid7 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid8 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid8 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    // val grid9 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val grid9 = mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)

    row2.clear()
    row3.clear()
    grid1.clear()
    row2Tmp.clear()

    // numbers.random()
    numbers.forEach { number ->
        // tmpNums.add(number)
        if (number != seed) {
            row1.add(number)
        }
    }

    // var possibleSize = One2.three.size
    var possibleSize = getGridSet(row1[0], row1[1], row1[2]).size
    val grid1Seed = (0..possibleSize).random()
    val grid2Seed = (0..possibleSize).random()

    // val grid1Set = One2.three[grid1Seed].toString()
    val grid1Set = getGridSet(row1[0], row1[1], row1[2])[grid1Seed].toString()
    val grid2Set = getGridSet(row1[3], row1[4], row1[5])[grid1Seed].toString()
    val grid1List = mutableListOf(0)

    grid1Set.forEach { char -> grid1List.add(char.digitToInt()) }
    if (grid1List.contains(0)) {
        grid1List.remove(0)
    }

    grid1Set.forEach { char -> grid1.add(char.digitToInt()) }
    grid1Set.forEach { char -> grid2.add(char.digitToInt()) }
    // if (grid1List.contains(0)){
    //     grid1List.remove(0)
    // }

    // tmpNums.remove(row1[1])
    // tmpNums.remove(row1[2])


    /* // numbers.random()
    // tmpNums.random()
    tmpNums.random()
    numbers.forEach { number ->
    // tmpNums.forEach { number ->
        // if (number != seed || number != row1[1] || number != row1[2]) {
        if (!col1.contains(number) || number != row1[1] || number != row1[2]) {
        // if (number != seed) {
            col1.add(number)
        }
    } */


    /*
        // numbers.forEach { number ->
        //     if(!col1.contains(number)){
        //         col1.add(number)
        //     }
        // }
     */

    /*
        // /* if col1[1] == 2 */
        // if (col1[1] == 2 && row1[1] == 2){
        //     Two3.list.forEach { numbers -> row2Tmp.add(numbers)}
        //
        // }
        */

    /* grid1.add(seed)     // grid1[0]
    grid1.add(row1[1])  // grid1[1]
    grid1.add(row1[2])  // grid1[2]
    // grid1.add(col1[1])  // grid1[3]
    grid1.add(0)  // grid1[3]
    grid1.add(0)        // grid1[4]
    grid1.add(0)        // grid1[5]
    // grid1.add(col1[2])  // grid1[6]
    grid1.add(0)  // grid1[6]
    grid1.add(0)        // grid1[7]
    grid1.add(0)        // grid1[8] */

    // grid1.add(grid1List[0])  // grid1[0]
    // grid1.add(grid1List[1])  // grid1[1]
    // grid1.add(grid1List[2])  // grid1[2]
    // grid1.add(grid1List[3])  // grid1[3]
    // grid1.add(grid1List[4])  // grid1[4]
    // grid1.add(grid1List[5])  // grid1[5]
    // grid1.add(grid1List[6])  // grid1[6]
    // grid1.add(grid1List[7])  // grid1[7]
    // grid1.add(grid1List[8])  // grid1[8]


    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.size(5.dp))
        Text("Seed $seed")
        Text("grid1Seed $grid1Seed")
        Text("grid1Set $grid1Set")
        Text("Row1 $row1")
        Spacer(modifier = Modifier.size(5.dp))

        /* Top Row */
        Row {
            /* Left */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid1[0], Black)
                    // ColouredText(col1[0], Black)
                    ColouredText(grid1[1], Black)
                    // ColouredText(row1[1], Black)
                    ColouredText(grid1[2], Black)
                    // ColouredText(row1[2], Black)
                }
                Row() {
                    ColouredText(grid1[3], Black)
                    // ColouredText(col1[1], Black)
                    ColouredText(grid1[4], Black)
                    // ColouredText(row2[1], Black)
                    ColouredText(grid1[5], Black)
                    // ColouredText(row2[2], Black)
                }
                Row() {
                    ColouredText(grid1[6], Black)
                    // ColouredText(col1[2], Black)
                    ColouredText(grid1[7], Black)
                    // ColouredText(row3[1], Black)
                    ColouredText(grid1[8], Black)
                    // ColouredText(row3[2], Black)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid2[0], Red)
                    ColouredText(grid2[1], Red)
                    ColouredText(grid2[2], Red)
                }
                Row() {
                    ColouredText(grid2[3], Red)
                    ColouredText(grid2[4], Red)
                    ColouredText(grid2[5], Red)
                }
                Row() {
                    ColouredText(grid2[6], Red)
                    ColouredText(grid2[7], Red)
                    ColouredText(grid2[8], Red)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid3[0], NeonGreen)
                    ColouredText(grid3[1], NeonGreen)
                    ColouredText(grid3[2], NeonGreen)
                }
                Row() {
                    ColouredText(grid3[3], NeonGreen)
                    ColouredText(grid3[4], NeonGreen)
                    ColouredText(grid3[5], NeonGreen)
                }
                Row() {
                    ColouredText(grid3[6], NeonGreen)
                    ColouredText(grid3[7], NeonGreen)
                    ColouredText(grid3[8], NeonGreen)
                }
            } // End of Right
        } // End Top Row

        /* Middle Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid4[0], Blue)
                    ColouredText(grid4[1], Blue)
                    ColouredText(grid4[2], Blue)
                }
                Row() {
                    ColouredText(grid4[3], Blue)
                    ColouredText(grid4[4], Blue)
                    ColouredText(grid4[5], Blue)
                }
                Row() {
                    ColouredText(grid4[6], Blue)
                    ColouredText(grid4[7], Blue)
                    ColouredText(grid4[8], Blue)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid5[0], Gold)
                    ColouredText(grid5[1], Gold)
                    ColouredText(grid5[2], Gold)
                }
                Row() {
                    ColouredText(grid5[3], Gold)
                    ColouredText(grid5[4], Gold)
                    ColouredText(grid5[5], Gold)
                }
                Row() {
                    ColouredText(grid5[6], Gold)
                    ColouredText(grid5[7], Gold)
                    ColouredText(grid5[8], Gold)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid6[0], DarkGrey)
                    ColouredText(grid6[1], DarkGrey)
                    ColouredText(grid6[2], DarkGrey)
                }
                Row() {
                    ColouredText(grid6[3], DarkGrey)
                    ColouredText(grid6[4], DarkGrey)
                    ColouredText(grid6[5], DarkGrey)
                }
                Row() {
                    ColouredText(grid6[6], DarkGrey)
                    ColouredText(grid6[7], DarkGrey)
                    ColouredText(grid6[8], DarkGrey)
                }
            } // End of Right
        } // End Middle Row

        /* Bottom Row */
        Row {
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid7[0], Purple40)
                    ColouredText(grid7[1], Purple40)
                    ColouredText(grid7[2], Purple40)
                }
                Row() {
                    ColouredText(grid7[3], Purple40)
                    ColouredText(grid7[4], Purple40)
                    ColouredText(grid7[5], Purple40)
                }
                Row() {
                    ColouredText(grid7[6], Purple40)
                    ColouredText(grid7[7], Purple40)
                    ColouredText(grid7[8], Purple40)
                }
            } // End of Left

            /* Center */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid8[0], MathBlue)
                    ColouredText(grid8[1], MathBlue)
                    ColouredText(grid8[2], MathBlue)
                }
                Row() {
                    ColouredText(grid8[3], MathBlue)
                    ColouredText(grid8[4], MathBlue)
                    ColouredText(grid8[5], MathBlue)
                }
                Row() {
                    ColouredText(grid8[6], MathBlue)
                    ColouredText(grid8[7], MathBlue)
                    ColouredText(grid8[8], MathBlue)
                }
            } // End of Center

            /* Right */
            Column(modifier = Modifier) {
                Row() {
                    ColouredText(grid9[0], Red)
                    ColouredText(grid9[1], Red)
                    ColouredText(grid9[2], Red)
                }
                Row() {
                    ColouredText(grid9[3], Red)
                    ColouredText(grid9[4], Red)
                    ColouredText(grid9[5], Red)
                }
                Row() {
                    ColouredText(grid9[6], Red)
                    ColouredText(grid9[7], Red)
                    ColouredText(grid9[8], Red)
                }
            } // End of Right
        } // End Bottom Row
    }

} // End of AppCore

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

@Preview(showBackground = true)
@Composable
fun AppCorePreview() {
    DrakesSudokuTheme {
        AppCore()
    }
}