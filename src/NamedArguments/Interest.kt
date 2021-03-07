package NamedArguments

import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    when (scanner.next()) {
        "amount" -> println(compoundInterest(startingAmount = scanner.nextInt()))
        "percent" -> println(compoundInterest(yearlyPercent = scanner.nextInt()))
        "years" -> println(compoundInterest(years = scanner.nextInt()))
    }
}

fun compoundInterest(startingAmount: Int = 1000, yearlyPercent: Int = 5, years: Int = 10): Long {
    val base: Double = 1 + yearlyPercent.toDouble() / 100
    val interest: Double = base.pow(years)
    val finalAmount = startingAmount.toDouble() * interest
    return finalAmount.toLong()
}