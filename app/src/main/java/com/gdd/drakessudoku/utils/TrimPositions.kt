package com.gdd.drakessudoku.utils

import androidx.compose.runtime.Composable

/**
 * Trim 2 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 3 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 4 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
    position04: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    inputList.remove(position04[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 5 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 * @param position05 5th value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
    position04: MutableList<Int>,
    position05: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    inputList.remove(position04[0])
    inputList.remove(position05[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 6 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 * @param position05 5th value to be removed from the list
 * @param position06 6th value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
    position04: MutableList<Int>,
    position05: MutableList<Int>,
    position06: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    inputList.remove(position04[0])
    inputList.remove(position05[0])
    inputList.remove(position06[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 7 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 * @param position05 5th value to be removed from the list
 * @param position06 6th value to be removed from the list
 * @param position07 7th value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
    position04: MutableList<Int>,
    position05: MutableList<Int>,
    position06: MutableList<Int>,
    position07: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    inputList.remove(position04[0])
    inputList.remove(position05[0])
    inputList.remove(position06[0])
    inputList.remove(position07[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}

/**
 * Trim 8 position values
 * @param inputList list of values to be trimmed
 * @param position01 1st value to be removed from the list
 * @param position02 2nd value to be removed from the list
 * @param position03 3rd value to be removed from the list
 * @param position04 4th value to be removed from the list
 * @param position05 5th value to be removed from the list
 * @param position06 6th value to be removed from the list
 * @param position07 7th value to be removed from the list
 * @param position08 8th value to be removed from the list
 */
@Composable
fun TrimPosition(
    inputList: MutableList<Int>,
    position01: MutableList<Int>,
    position02: MutableList<Int>,
    position03: MutableList<Int>,
    position04: MutableList<Int>,
    position05: MutableList<Int>,
    position06: MutableList<Int>,
    position07: MutableList<Int>,
    position08: MutableList<Int>,
) {
    var tmpValue = 0
    inputList.remove(position01[0])
    inputList.remove(position02[0])
    inputList.remove(position03[0])
    inputList.remove(position04[0])
    inputList.remove(position05[0])
    inputList.remove(position06[0])
    inputList.remove(position07[0])
    inputList.remove(position08[0])
    tmpValue = inputList.first()
    inputList.clear()
    inputList.add(tmpValue)
}