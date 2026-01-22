package com.gdd.drakessudoku.utils

import androidx.compose.runtime.Composable
import com.gdd.drakessudoku.model.GridCell

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


@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal < 10) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal < 10) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal != coord09.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
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
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal != coord09.value &&
        xVal != coord10.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell,
    coord10: GridCell,
    coord11: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal != coord09.value &&
        xVal != coord10.value &&
        xVal != coord11.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell,
    coord10: GridCell,
    coord11: GridCell,
    coord12: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal != coord09.value &&
        xVal != coord10.value &&
        xVal != coord11.value &&
        xVal != coord12.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}

@Composable
fun selectXValue(
    coord01: GridCell,
    coord02: GridCell,
    coord03: GridCell,
    coord04: GridCell,
    coord05: GridCell,
    coord06: GridCell,
    coord07: GridCell,
    coord08: GridCell,
    coord09: GridCell,
    coord10: GridCell,
    coord11: GridCell,
    coord12: GridCell,
    coord13: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
        xVal != coord05.value &&
        xVal != coord06.value &&
        xVal != coord07.value &&
        xVal != coord08.value &&
        xVal != coord09.value &&
        xVal != coord10.value &&
        xVal != coord11.value &&
        xVal != coord12.value &&
        xVal != coord13.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}