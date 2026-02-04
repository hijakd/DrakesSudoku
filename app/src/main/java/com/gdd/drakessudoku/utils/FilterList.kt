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