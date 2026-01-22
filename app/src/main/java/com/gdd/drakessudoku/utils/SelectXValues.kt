package com.gdd.drakessudoku.utils

import androidx.compose.runtime.Composable
import com.gdd.drakessudoku.model.GridCell

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
    coord04: GridCell
): Int {
    var xVal = 0
    while (
        xVal != coord01.value &&
        xVal != coord02.value &&
        xVal != coord03.value &&
        xVal != coord04.value &&
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
    val nums = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    nums.forEach {
        if (it == coord01.value ||
            it == coord02.value ||
            it == coord03.value ||
            it == coord04.value ||
            it == coord05.value ||
            it == coord06.value ||
            it == coord07.value ||
            it == coord08.value ||
            it == coord09.value
        ) {
            nums.remove(it)
        }
    }
    xVal = nums.first()
    /*     // while (
        //     xVal != coord01.value &&
        //     xVal != coord02.value &&
        //     xVal != coord03.value &&
        //     xVal != coord04.value &&
        //     xVal != coord05.value &&
        //     xVal != coord06.value &&
        //     xVal != coord07.value &&
        //     xVal != coord08.value &&
        //     xVal != coord09.value &&
        //     xVal < 10
        // ) {
        //     xVal++
        // } */
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
    val nums = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    nums.forEach {
        if (it == coord01.value ||
            it == coord02.value ||
            it == coord03.value ||
            it == coord04.value ||
            it == coord05.value ||
            it == coord06.value ||
            it == coord07.value ||
            it == coord08.value ||
            it == coord09.value ||
            it == coord10.value ||
            it == coord11.value
        ) {
            nums.remove(it)
        }
    }
    xVal = nums.first()
    /* while (
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
    } */
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
    coord13: GridCell,
    coord14: GridCell
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
        xVal != coord14.value &&
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
    coord13: GridCell,
    coord14: GridCell,
    coord15: GridCell
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
        xVal != coord14.value &&
        xVal != coord15.value &&
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
    coord13: GridCell,
    coord14: GridCell,
    coord15: GridCell,
    coord16: GridCell,
    coord17: GridCell,
    coord18: GridCell
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
        xVal != coord14.value &&
        xVal != coord15.value &&
        xVal != coord16.value &&
        xVal != coord17.value &&
        xVal != coord18.value &&
        xVal < 10
    ) {
        xVal++
    }
    return xVal
}