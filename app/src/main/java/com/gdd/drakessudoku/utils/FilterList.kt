package com.gdd.drakessudoku.utils

import androidx.compose.runtime.Composable
import com.gdd.drakessudoku.model.GridCell

/**
 * @param[inputList] list of values to be filtered
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
) {
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * @param cell04 4th value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell,
    cell04: GridCell,
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
    inputList.remove(cell04.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * @param cell04 4th value to be removed from the list
 * @param cell05 5th value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell,
    cell04: GridCell,
    cell05: GridCell,
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
    inputList.remove(cell04.value)
    inputList.remove(cell05.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * @param cell04 4th value to be removed from the list
 * @param cell05 5th value to be removed from the list
 * @param cell06 6th value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell,
    cell04: GridCell,
    cell05: GridCell,
    cell06: GridCell
){
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
    inputList.remove(cell04.value)
    inputList.remove(cell05.value)
    inputList.remove(cell06.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * @param cell04 4th value to be removed from the list
 * @param cell05 5th value to be removed from the list
 * @param cell06 6th value to be removed from the list
 * @param cell07 7th value to be removed from the list
 */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell,
    cell04: GridCell,
    cell05: GridCell,
    cell06: GridCell,
    cell07: GridCell
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
    inputList.remove(cell04.value)
    inputList.remove(cell05.value)
    inputList.remove(cell06.value)
    inputList.remove(cell07.value)
}

/**
 * @param[inputList] list of values to be filtered
 * @param cell01 1st value to be removed from the list
 * @param cell02 2nd value to be removed from the list
 * @param cell03 3rd value to be removed from the list
 * @param cell04 4th value to be removed from the list
 * @param cell05 5th value to be removed from the list
 * @param cell06 6th value to be removed from the list
 * @param cell07 7th value to be removed from the list
 * @param cell08 8th value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    cell01: GridCell,
    cell02: GridCell,
    cell03: GridCell,
    cell04: GridCell,
    cell05: GridCell,
    cell06: GridCell,
    cell07: GridCell,
    cell08: GridCell,
) {
    inputList.remove(cell01.value)
    inputList.remove(cell02.value)
    inputList.remove(cell03.value)
    inputList.remove(cell04.value)
    inputList.remove(cell05.value)
    inputList.remove(cell06.value)
    inputList.remove(cell07.value)
    inputList.remove(cell08.value)
}


/**
 * @param[inputList] list of values to be filtered
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 * @param position05 5th value to be removed from the list
 * @param position06 6th value to be removed from the list
 * @param position07 7th value to be removed from the list
 * @param position08 8th value to be removed from the list
 * @param position09 9th value to be removed from the list
 * @param position10 10th value to be removed from the list
 * @param position11 11th value to be removed from the list
 * */
@Composable
fun FilterList(
    inputList: MutableList<Int>,
    position01: Int,
    position02: Int,
    position03: Int,
    position04: Int,
    position05: Int,
    position06: Int,
    position07: Int,
    position08: Int,
    position09: Int,
    position10: Int,
    position11: Int,
) {
    if (inputList.contains(position01)) {
        inputList.remove(position01)
    }
    if (inputList.contains(position02)) {
        inputList.remove(position02)
    }
    if (inputList.contains(position03)) {
        inputList.remove(position03)
    }
    if (inputList.contains(position04)) {
        inputList.remove(position04)
    }
    if (inputList.contains(position05)) {
        inputList.remove(position05)
    }
    if (inputList.contains(position06)) {
        inputList.remove(position06)
    }
    if (inputList.contains(position07)) {
        inputList.remove(position07)
    }
    if (inputList.contains(position08)) {
        inputList.remove(position08)
    }
    if (inputList.contains(position09)) {
        inputList.remove(position09)
    }
    if (inputList.contains(position10)) {
        inputList.remove(position10)
    }
    if (inputList.contains(position11)) {
        inputList.remove(position11)
    }
}