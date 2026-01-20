package com.gdd.drakessudoku.utils

import com.gdd.drakessudoku.data.*

fun GridSet(value1: Int, value2: Int, value3: Int): MutableList<Int> {
    var arrayList = mutableListOf<Int>()
    when (value1) {
        1 -> when (value2) {
            2 -> when (value3) {
                3 -> arrayList = One2.three
                4 -> arrayList = One2.four
                5 -> arrayList = One2.five
                6 -> arrayList = One2.six
                7 -> arrayList = One2.seven
                8 -> arrayList = One2.eight
                9 -> arrayList = One2.nine
            }

            3 -> when (value3) {
                2 -> arrayList = One3.two
                4 -> arrayList = One3.four
                5 -> arrayList = One3.five
                6 -> arrayList = One3.six
                7 -> arrayList = One3.seven
                8 -> arrayList = One3.eight
                9 -> arrayList = One3.nine
            }

            4 -> when (value3) {
                2 -> arrayList = One4.two
                3 -> arrayList = One4.three
                5 -> arrayList = One4.five
                6 -> arrayList = One4.six
                7 -> arrayList = One4.seven
                8 -> arrayList = One4.eight
                9 -> arrayList = One4.nine
            }

            5 -> when (value3) {
                2 -> arrayList = One5.two
                3 -> arrayList = One5.three
                4 -> arrayList = One5.four
                6 -> arrayList = One5.six
                7 -> arrayList = One5.seven
                8 -> arrayList = One5.eight
                9 -> arrayList = One5.nine
            }

            6 -> when (value3) {
                2 -> arrayList = One6.two
                3 -> arrayList = One6.three
                4 -> arrayList = One6.four
                5 -> arrayList = One6.five
                7 -> arrayList = One6.seven
                8 -> arrayList = One6.eight
                9 -> arrayList = One6.nine
            }

            7 -> when (value3) {
                2 -> arrayList = One7.two
                3 -> arrayList = One7.three
                4 -> arrayList = One7.four
                5 -> arrayList = One7.five
                6 -> arrayList = One7.six
                8 -> arrayList = One7.eight
                9 -> arrayList = One7.nine
            }

            8 -> when (value3) {
                2 -> arrayList = One8.two
                3 -> arrayList = One8.three
                4 -> arrayList = One8.four
                5 -> arrayList = One8.five
                6 -> arrayList = One8.six
                7 -> arrayList = One8.seven
                9 -> arrayList = One8.nine
            }

            9 -> when (value3) {
                2 -> arrayList = One9.two
                3 -> arrayList = One9.three
                4 -> arrayList = One9.four
                5 -> arrayList = One9.five
                6 -> arrayList = One9.six
                7 -> arrayList = One9.seven
                8 -> arrayList = One9.eight
            }
        }

        2 -> when (value2) {
            1 -> when (value3) {
                3 -> arrayList = Two1.three
                4 -> arrayList = Two1.four
                5 -> arrayList = Two1.five
                6 -> arrayList = Two1.six
                7 -> arrayList = Two1.seven
                8 -> arrayList = Two1.eight
                9 -> arrayList = Two1.nine
            }

            3 -> when (value3) {
                4 -> arrayList = Two3.four
                5 -> arrayList = Two3.five
                6 -> arrayList = Two3.six
                7 -> arrayList = Two3.seven
                8 -> arrayList = Two3.eight
                9 -> arrayList = Two3.nine
            }

            4 -> when (value3) {
                3 -> arrayList = Two4.three
                5 -> arrayList = Two4.five
                6 -> arrayList = Two4.six
                7 -> arrayList = Two4.seven
                8 -> arrayList = Two4.eight
                9 -> arrayList = Two4.nine
            }

            5 -> when (value3) {
                3 -> arrayList = Two5.three
                4 -> arrayList = Two5.four
                6 -> arrayList = Two5.six
                7 -> arrayList = Two5.seven
                8 -> arrayList = Two5.eight
                9 -> arrayList = Two5.nine
            }

            6 -> when (value3) {
                3 -> arrayList = Two6.three
                4 -> arrayList = Two6.four
                5 -> arrayList = Two6.five
                7 -> arrayList = Two6.seven
                8 -> arrayList = Two6.eight
                9 -> arrayList = Two6.nine
            }

            7 -> when (value3) {
                3 -> arrayList = Two7.three
                4 -> arrayList = Two7.four
                5 -> arrayList = Two7.five
                6 -> arrayList = Two7.six
                8 -> arrayList = Two7.eight
                9 -> arrayList = Two7.nine
            }

            8 -> when (value3) {
                3 -> arrayList = Two8.three
                4 -> arrayList = Two8.four
                5 -> arrayList = Two8.five
                6 -> arrayList = Two8.six
                7 -> arrayList = Two8.seven
                9 -> arrayList = Two8.nine
            }

            9 -> when (value3) {
                3 -> arrayList = Two9.three
                4 -> arrayList = Two9.four
                5 -> arrayList = Two9.five
                6 -> arrayList = Two9.six
                7 -> arrayList = Two9.seven
                8 -> arrayList = Two9.eight
            }
        }

        /* 3 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        4 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        5 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        6 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        7 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        8 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        }

        9 -> when (value2) {
            1 ->
                2

            ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
                8

            ->
            else ->
        } */
    }

    return arrayList
}