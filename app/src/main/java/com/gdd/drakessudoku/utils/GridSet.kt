package com.gdd.drakessudoku.utils

import com.gdd.drakessudoku.data.*

fun getGridSet(value1: Int, value2: Int, value3: Int): MutableList<Int> {
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

        3 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Three1.two
                4 -> arrayList = Three1.four
                5 -> arrayList = Three1.five
                6 -> arrayList = Three1.six
                7 -> arrayList = Three1.seven
                8 -> arrayList = Three1.eight
                9 -> arrayList = Three1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Three2.one
                4 -> arrayList = Three2.four
                5 -> arrayList = Three2.five
                6 -> arrayList = Three2.six
                7 -> arrayList = Three2.seven
                8 -> arrayList = Three2.eight
                9 -> arrayList = Three2.nine
            }

            4 -> when (value3) {
                1 -> arrayList = Three4.one
                2 -> arrayList = Three4.two
                5 -> arrayList = Three4.five
                6 -> arrayList = Three4.six
                7 -> arrayList = Three4.seven
                8 -> arrayList = Three4.eight
                9 -> arrayList = Three4.nine
            }

            5 -> when (value3) {
                1 -> arrayList = Three5.one
                2 -> arrayList = Three5.two
                4 -> arrayList = Three5.four
                6 -> arrayList = Three5.six
                7 -> arrayList = Three5.seven
                8 -> arrayList = Three5.eight
                9 -> arrayList = Three5.nine
            }

            6 -> when (value3) {
                1 -> arrayList = Three6.one
                2 -> arrayList = Three6.two
                4 -> arrayList = Three6.four
                5 -> arrayList = Three6.five
                7 -> arrayList = Three6.seven
                8 -> arrayList = Three6.eight
                9 -> arrayList = Three6.nine
            }

            7 -> when (value3) {
                1 -> arrayList = Three7.one
                2 -> arrayList = Three7.two
                4 -> arrayList = Three7.four
                5 -> arrayList = Three7.five
                6 -> arrayList = Three7.six
                8 -> arrayList = Three7.eight
                9 -> arrayList = Three7.nine
            }

            8 -> when (value3) {
                1 -> arrayList = Three8.one
                2 -> arrayList = Three8.two
                4 -> arrayList = Three8.four
                5 -> arrayList = Three8.five
                6 -> arrayList = Three8.six
                7 -> arrayList = Three8.seven
                9 -> arrayList = Three8.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Three9.one
                2 -> arrayList = Three9.two
                4 -> arrayList = Three9.four
                5 -> arrayList = Three9.five
                6 -> arrayList = Three9.six
                7 -> arrayList = Three9.seven
                8 -> arrayList = Three9.eight
            }

        }

        4 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Four1.two
                3 -> arrayList = Four1.three
                5 -> arrayList = Four1.five
                6 -> arrayList = Four1.six
                7 -> arrayList = Four1.seven
                8 -> arrayList = Four1.eight
                9 -> arrayList = Four1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Four2.one
                3 -> arrayList = Four2.three
                5 -> arrayList = Four2.five
                6 -> arrayList = Four2.six
                7 -> arrayList = Four2.seven
                8 -> arrayList = Four2.eight
                9 -> arrayList = Four2.nine
            }

            3 -> when (value3) {
                1 -> arrayList = Four3.one
                2 -> arrayList = Four3.two
                5 -> arrayList = Four3.five
                6 -> arrayList = Four3.six
                7 -> arrayList = Four3.seven
                8 -> arrayList = Four3.eight
                9 -> arrayList = Four3.nine
            }

            5 -> when (value3) {
                1 -> arrayList = Four5.one
                2 -> arrayList = Four5.two
                3 -> arrayList = Four5.three
                6 -> arrayList = Four5.six
                7 -> arrayList = Four5.seven
                8 -> arrayList = Four5.eight
                9 -> arrayList = Four5.nine
            }

            6 -> when (value3) {
                1 -> arrayList = Four6.one
                2 -> arrayList = Four6.two
                3 -> arrayList = Four6.three
                5 -> arrayList = Four6.five
                7 -> arrayList = Four6.seven
                8 -> arrayList = Four6.eight
                9 -> arrayList = Four6.nine
            }

            7 -> when (value3) {
                1 -> arrayList = Four7.one
                2 -> arrayList = Four7.two
                3 -> arrayList = Four7.three
                5 -> arrayList = Four7.five
                6 -> arrayList = Four7.six
                8 -> arrayList = Four7.eight
                9 -> arrayList = Four7.nine
            }

            8 -> when (value3) {
                1 -> arrayList = Four8.one
                2 -> arrayList = Four8.two
                3 -> arrayList = Four8.three
                5 -> arrayList = Four8.five
                6 -> arrayList = Four8.six
                7 -> arrayList = Four8.seven
                8 -> arrayList = Four9.eight
                9 -> arrayList = Four8.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Four9.one
                2 -> arrayList = Four9.two
                3 -> arrayList = Four9.three
                5 -> arrayList = Four9.five
                6 -> arrayList = Four9.six
                7 -> arrayList = Four9.seven
                8 -> arrayList = Four9.eight
            }
        }

        5 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Five1.two
                3 -> arrayList = Five1.three
                4 -> arrayList = Five1.four
                6 -> arrayList = Five1.six
                7 -> arrayList = Five1.seven
                8 -> arrayList = Five1.eight
                9 -> arrayList = Five1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Five2.one
                3 -> arrayList = Five2.three
                4 -> arrayList = Five2.four
                6 -> arrayList = Five2.six
                7 -> arrayList = Five2.seven
                8 -> arrayList = Five2.eight
                9 -> arrayList = Five2.nine
            }

            3 -> when (value3) {
                1 -> arrayList = Five3.one
                2 -> arrayList = Five3.two
                4 -> arrayList = Five3.four
                6 -> arrayList = Five3.six
                7 -> arrayList = Five3.seven
                8 -> arrayList = Five3.eight
                9 -> arrayList = Five3.nine
            }

            4 -> when (value3) {
                1 -> arrayList = Five4.one
                2 -> arrayList = Five4.two
                3 -> arrayList = Five4.three
                6 -> arrayList = Five4.six
                7 -> arrayList = Five4.seven
                8 -> arrayList = Five4.eight
                9 -> arrayList = Five4.nine
            }

            6 -> when (value3) {
                1 -> arrayList = Five6.one
                2 -> arrayList = Five6.two
                3 -> arrayList = Five6.three
                4 -> arrayList = Five6.four
                7 -> arrayList = Five6.seven
                8 -> arrayList = Five6.eight
                9 -> arrayList = Five6.nine
            }

            7 -> when (value3) {
                1 -> arrayList = Five7.one
                2 -> arrayList = Five7.two
                3 -> arrayList = Five7.three
                4 -> arrayList = Five7.four
                6 -> arrayList = Five7.six
                8 -> arrayList = Five7.eight
                9 -> arrayList = Five7.nine
            }

            8 -> when (value3) {
                1 -> arrayList = Five8.one
                2 -> arrayList = Five8.two
                3 -> arrayList = Five8.three
                4 -> arrayList = Five8.four
                6 -> arrayList = Five8.six
                7 -> arrayList = Five8.seven
                9 -> arrayList = Five8.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Five9.one
                2 -> arrayList = Five9.two
                3 -> arrayList = Five9.three
                4 -> arrayList = Five9.four
                6 -> arrayList = Five9.six
                7 -> arrayList = Five9.seven
                8 -> arrayList = Five9.eight
            }
        }

        6 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Six1.two
                3 -> arrayList = Six1.three
                4 -> arrayList = Six1.four
                5 -> arrayList = Six1.five
                7 -> arrayList = Six1.seven
                8 -> arrayList = Six1.eight
                9 -> arrayList = Six1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Six2.one
                3 -> arrayList = Six2.three
                4 -> arrayList = Six2.four
                5 -> arrayList = Six2.five
                7 -> arrayList = Six2.seven
                8 -> arrayList = Six2.eight
                9 -> arrayList = Six2.nine
            }

            3 -> when (value3) {
                1 -> arrayList = Six3.one
                2 -> arrayList = Six3.two
                4 -> arrayList = Six3.four
                5 -> arrayList = Six3.five
                7 -> arrayList = Six3.seven
                8 -> arrayList = Six3.eight
                9 -> arrayList = Six3.nine
            }

            4 -> when (value3) {
                1 -> arrayList = Six4.one
                2 -> arrayList = Six4.two
                3 -> arrayList = Six4.three
                5 -> arrayList = Six4.five
                7 -> arrayList = Six4.seven
                8 -> arrayList = Six4.eight
                9 -> arrayList = Six4.nine
            }

            5 -> when (value3) {
                1 -> arrayList = Six5.one
                2 -> arrayList = Six5.two
                3 -> arrayList = Six5.three
                4 -> arrayList = Six5.four
                7 -> arrayList = Six5.seven
                8 -> arrayList = Six5.eight
                9 -> arrayList = Six5.nine
            }

            7 -> when (value3) {
                1 -> arrayList = Six7.one
                2 -> arrayList = Six7.two
                3 -> arrayList = Six7.three
                4 -> arrayList = Six7.four
                5 -> arrayList = Six7.five
                8 -> arrayList = Six7.eight
                9 -> arrayList = Six7.nine
            }

            8 -> when (value3) {
                1 -> arrayList = Six8.one
                2 -> arrayList = Six8.two
                3 -> arrayList = Six8.three
                4 -> arrayList = Six8.four
                5 -> arrayList = Six8.five
                7 -> arrayList = Six8.seven
                9 -> arrayList = Six8.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Six9.one
                2 -> arrayList = Six9.two
                3 -> arrayList = Six9.three
                4 -> arrayList = Six9.four
                5 -> arrayList = Six9.five
                7 -> arrayList = Six9.seven
                8 -> arrayList = Six9.eight
            }
        }

        7 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Seven1.two
                3 -> arrayList = Seven1.three
                4 -> arrayList = Seven1.four
                5 -> arrayList = Seven1.five
                6 -> arrayList = Seven1.six
                8 -> arrayList = Seven1.eight
                9 -> arrayList = Seven1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Seven2.one
                3 -> arrayList = Seven2.three
                4 -> arrayList = Seven2.four
                5 -> arrayList = Seven2.five
                6 -> arrayList = Seven2.six
                8 -> arrayList = Seven2.eight
                9 -> arrayList = Seven2.nine
            }

            3 -> when (value3) {
                1 -> arrayList = Seven3.one
                2 -> arrayList = Seven3.two
                4 -> arrayList = Seven3.four
                5 -> arrayList = Seven3.five
                6 -> arrayList = Seven3.six
                8 -> arrayList = Seven3.eight
                9 -> arrayList = Seven3.nine
            }

            4 -> when (value3) {
                1 -> arrayList = Seven4.one
                2 -> arrayList = Seven4.two
                3 -> arrayList = Seven4.three
                5 -> arrayList = Seven4.five
                6 -> arrayList = Seven4.six
                8 -> arrayList = Seven4.eight
                9 -> arrayList = Seven4.nine
            }

            5 -> when (value3) {
                1 -> arrayList = Seven5.one
                2 -> arrayList = Seven5.two
                3 -> arrayList = Seven5.three
                4 -> arrayList = Seven5.four
                6 -> arrayList = Seven5.six
                8 -> arrayList = Seven5.eight
                9 -> arrayList = Seven5.nine
            }

            6 -> when (value3) {
                1 -> arrayList = Seven6.one
                2 -> arrayList = Seven6.two
                3 -> arrayList = Seven6.three
                4 -> arrayList = Seven6.four
                5 -> arrayList = Seven6.five
                8 -> arrayList = Seven6.eight
                9 -> arrayList = Seven6.nine
            }

            8 -> when (value3) {
                1 -> arrayList = Seven8.one
                2 -> arrayList = Seven8.two
                3 -> arrayList = Seven8.three
                4 -> arrayList = Seven8.four
                5 -> arrayList = Seven8.five
                6 -> arrayList = Seven8.six
                9 -> arrayList = Seven8.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Seven9.one
                2 -> arrayList = Seven9.two
                3 -> arrayList = Seven9.three
                4 -> arrayList = Seven9.four
                5 -> arrayList = Seven9.five
                6 -> arrayList = Seven9.six
                8 -> arrayList = Seven9.eight
            }
        }

        8 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Eight1.two
                3 -> arrayList = Eight1.three
                4 -> arrayList = Eight1.four
                5 -> arrayList = Eight1.five
                6 -> arrayList = Eight1.six
                7 -> arrayList = Eight1.seven
                9 -> arrayList = Eight1.nine
            }

            2 -> when (value3) {
                1 -> arrayList = Eight2.one
                3 -> arrayList = Eight2.three
                4 -> arrayList = Eight2.four
                5 -> arrayList = Eight2.five
                6 -> arrayList = Eight2.six
                7 -> arrayList = Eight2.seven
                9 -> arrayList = Eight2.nine
            }

            3 -> when (value3) {
                1 -> arrayList = Eight3.one
                2 -> arrayList = Eight3.two
                4 -> arrayList = Eight3.four
                5 -> arrayList = Eight3.five
                6 -> arrayList = Eight3.six
                7 -> arrayList = Eight3.seven
                9 -> arrayList = Eight3.nine
            }

            4 -> when (value3) {
                1 -> arrayList = Eight4.one
                2 -> arrayList = Eight4.two
                3 -> arrayList = Eight4.three
                5 -> arrayList = Eight4.five
                6 -> arrayList = Eight4.six
                7 -> arrayList = Eight4.seven
                9 -> arrayList = Eight4.nine
            }

            5 -> when (value3) {
                1 -> arrayList = Eight5.one
                2 -> arrayList = Eight5.two
                3 -> arrayList = Eight5.three
                4 -> arrayList = Eight5.four
                6 -> arrayList = Eight5.six
                7 -> arrayList = Eight5.seven
                9 -> arrayList = Eight5.nine
            }

            6 -> when (value3) {
                1 -> arrayList = Eight6.one
                2 -> arrayList = Eight6.two
                3 -> arrayList = Eight6.three
                4 -> arrayList = Eight6.four
                5 -> arrayList = Eight6.five
                7 -> arrayList = Eight6.seven
                9 -> arrayList = Eight6.nine
            }

            7 -> when (value3) {
                1 -> arrayList = Eight7.one
                2 -> arrayList = Eight7.two
                3 -> arrayList = Eight7.three
                4 -> arrayList = Eight7.four
                5 -> arrayList = Eight7.five
                6 -> arrayList = Eight7.six
                9 -> arrayList = Eight7.nine
            }

            9 -> when (value3) {
                1 -> arrayList = Eight9.one
                2 -> arrayList = Eight9.two
                3 -> arrayList = Eight9.three
                4 -> arrayList = Eight9.four
                5 -> arrayList = Eight9.five
                6 -> arrayList = Eight9.six
                7 -> arrayList = Eight9.seven
            }
        }

        9 -> when (value2) {
            1 -> when (value3) {
                2 -> arrayList = Nine1.two
                3 -> arrayList = Nine1.three
                4 -> arrayList = Nine1.four
                5 -> arrayList = Nine1.five
                6 -> arrayList = Nine1.six
                7 -> arrayList = Nine1.seven
                8 -> arrayList = Nine1.eight
            }

            2 -> when (value3) {
                1 -> arrayList = Nine2.one
                3 -> arrayList = Nine2.three
                4 -> arrayList = Nine2.four
                5 -> arrayList = Nine2.five
                6 -> arrayList = Nine2.six
                7 -> arrayList = Nine2.seven
                8 -> arrayList = Nine2.eight
            }

            3 -> when (value3) {
                1 -> arrayList = Nine3.one
                2 -> arrayList = Nine3.two
                4 -> arrayList = Nine3.four
                5 -> arrayList = Nine3.five
                6 -> arrayList = Nine3.six
                7 -> arrayList = Nine3.seven
                8 -> arrayList = Nine3.eight
            }

            4 -> when (value3) {
                1 -> arrayList = Nine4.one
                2 -> arrayList = Nine4.two
                3 -> arrayList = Nine4.three
                5 -> arrayList = Nine4.five
                6 -> arrayList = Nine4.six
                7 -> arrayList = Nine4.seven
                8 -> arrayList = Nine4.eight
            }

            5 -> when (value3) {
                1 -> arrayList = Nine5.one
                2 -> arrayList = Nine5.two
                3 -> arrayList = Nine5.three
                4 -> arrayList = Nine5.four
                6 -> arrayList = Nine5.six
                7 -> arrayList = Nine5.seven
                8 -> arrayList = Nine5.eight
            }

            6 -> when (value3) {
                1 -> arrayList = Nine6.one
                2 -> arrayList = Nine6.two
                3 -> arrayList = Nine6.three
                4 -> arrayList = Nine6.four
                5 -> arrayList = Nine6.five
                7 -> arrayList = Nine6.seven
                8 -> arrayList = Nine6.eight
            }

            7 -> when (value3) {
                1 -> arrayList = Nine7.one
                2 -> arrayList = Nine7.two
                3 -> arrayList = Nine7.three
                4 -> arrayList = Nine7.four
                5 -> arrayList = Nine7.five
                6 -> arrayList = Nine7.six
                8 -> arrayList = Nine7.eight
            }

            8 -> when (value3) {
                1 -> arrayList = Nine8.one
                2 -> arrayList = Nine8.two
                3 -> arrayList = Nine8.three
                4 -> arrayList = Nine8.four
                5 -> arrayList = Nine8.five
                6 -> arrayList = Nine8.six
                7 -> arrayList = Nine8.seven
            }
        }
    }

    return arrayList
}