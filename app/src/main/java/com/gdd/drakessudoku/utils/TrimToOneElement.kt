package com.gdd.drakessudoku.utils

import android.util.Log
import androidx.compose.runtime.Composable

@Composable
fun TrimToOneElement(inputList: MutableList<Int>) {
    // val TAG = "trimming"
    // Log.d(TAG, "inputList.size: ${inputList.size} - $inputList")
        while (inputList.size > 1) {
            inputList.remove(
                inputList.last()
            )
        }
    // Log.d(TAG, "trimmed $inputList")
}