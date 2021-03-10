package codewars

import aquarium.separator
//Find the maximum length difference between strings of two arrays

import kotlin.math.abs

fun mxdiflg(a1:Array<String>, a2:Array<String>): Int {
    var temp: Int = -1
    for (x in a1) {
        for (y in a2) {
            val dif = abs(x.length - y.length)
            if (dif > temp) temp = dif
        }
    }
    return temp
}

fun mxdiflgAlternate(a1: Array<String>, a2: Array<String>): Int {
    return if (a1.isEmpty() || a2.isEmpty() ) -1
    else listOf(
        a1.maxBy { it.length }!!.length - a2.minBy { it.length }!!.length,
        a2.maxBy { it.length }!!.length - a1.minBy { it.length }!!.length
    ).max()!!.toInt()
}

fun main() {
    val ans = mxdiflg(
        arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"),
        arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
    )
    val empty = mxdiflg(arrayOf("hey", "jukk", "jjdkhhdkl"), arrayOf())
    println(ans)
    println(empty)
    separator(5)
    val alternate = mxdiflgAlternate(
        arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"),
        arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
    )
    val emptyAlternate = mxdiflgAlternate(arrayOf(), arrayOf("jkkj"))
    println(alternate)
    println(emptyAlternate)

}