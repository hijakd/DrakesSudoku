package com.gdd.drakessudoku.utils

import androidx.compose.runtime.Composable
import com.gdd.drakessudoku.model.GridCell

/* check 2 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 3 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 4 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 5 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 6 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value &&
    inputList.first() != coord06.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value &&
    inputList.last() != coord06.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 7 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value &&
    inputList.first() != coord06.value &&
    inputList.first() != coord07.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value &&
    inputList.last() != coord06.value &&
    inputList.last() != coord07.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 8 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value &&
    inputList.first() != coord06.value &&
    inputList.first() != coord07.value &&
    inputList.first() != coord08.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value &&
    inputList.last() != coord06.value &&
    inputList.last() != coord07.value &&
    inputList.last() != coord08.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 9 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value &&
    inputList.first() != coord06.value &&
    inputList.first() != coord07.value &&
    inputList.first() != coord08.value &&
    inputList.first() != coord09.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value &&
    inputList.last() != coord06.value &&
    inputList.last() != coord07.value &&
    inputList.last() != coord08.value &&
    inputList.last() != coord09.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}

/* check 10 values */
@Composable
fun findXValue(
    inputList: MutableList<Int>,
    tmpSlice: MutableList<Int>,
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell,
    coord10: GridCell
): Int = if (
    inputList.first() != coord01.value &&
    inputList.first() != coord02.value &&
    inputList.first() != coord03.value &&
    inputList.first() != coord04.value &&
    inputList.first() != coord05.value &&
    inputList.first() != coord06.value &&
    inputList.first() != coord07.value &&
    inputList.first() != coord08.value &&
    inputList.first() != coord09.value &&
    inputList.first() != coord10.value
) {
    inputList.first()
} else if (
    inputList.last() != coord01.value &&
    inputList.last() != coord02.value &&
    inputList.last() != coord03.value &&
    inputList.last() != coord04.value &&
    inputList.last() != coord05.value &&
    inputList.last() != coord06.value &&
    inputList.last() != coord07.value &&
    inputList.last() != coord08.value &&
    inputList.last() != coord09.value &&
    inputList.last() != coord10.value
) {
    inputList.last()
} else {
    if (inputList.count() > 2){
        tmpSlice.clear()
        inputList.forEach { tmpSlice.add(it) }
        tmpSlice.remove(inputList.first())
        tmpSlice.remove(inputList.last())
        tmpSlice.random()
    } else if (inputList.count() == 2) {
        inputList.removeAt(0)
        inputList.first()
    } else {
        inputList.first()
    }
}