import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    val a = BigInteger(readLine()!!)
    val b = BigInteger(readLine()!!)
    println("$a & $b")
    val c = a * BigInteger("100")
    val d = b * BigInteger("100")
    val sum1 = c.div(a + b)
    val sum2 = d.div(a + b)
    println("$sum1% $sum2%")
    val sumObject = ::sum
    val sumResult = sum(1, 6)
    val notPredicate: (Char) -> Boolean = { !con(it) }

    println(sumResult)
    println(sumObject(1, 9))
}

fun sum(a: Int, b: Int): Int = a + b
fun con(a: Char): Boolean = a == 's'

fun originalPredicate(a: Char): (Char) -> Boolean {
    val c: (Char) -> Boolean = ::con
    return c
}