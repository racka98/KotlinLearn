import java.awt.List
import kotlin.math.roundToInt

fun parseCardNumber(cardNumber: String): String {
    val cardNums = cardNumber.split(" ")
    if (cardNums.count() == 4) return cardNums.joinToString("")
    try {
        throw Exception()
    } catch (e: Exception) {
        return "Dodo card number"
    }
}

fun exception() {
    println("Before the try-catch block") // it will be printed
    try {
        println("Inside the try block before an exception") // it will be printed
        println(2 / 0) // it throws ArithmeticException
        //"yehhd".toInt()
        println("Inside the try block after the exception") // it won't be printed
    }
    catch (e: Exception) {
        println("Division by zero!") // it will be printed
        println(e.message)
    }

    println("After the try-catch block") // it will be printed
}

fun npe() {
    val age: Int? = null
    val name: String? = "Bob"
    val nickname: String? = null
    val length: Int = nickname?.length ?: 0
    println("$age ${name?.length} $length")
}

fun isNumber(input: String?): Any? {
    return try {
        val isNum: Int? = input?.toInt()
        isNum
    } catch (e: Exception) {
        input
    }
}

fun main() {
    val leatherCase = LeatherCase(190, "brown")
    val softCase = SoftCase(120, "yellow")
    val woodCase = WoodCase(230, "orange")
    println(getCaseTax(leatherCase) + getCaseTax(softCase) + getCaseTax(woodCase))
    //print(parseCardNumber(readLine()!!))
    //exception()
    npe()
    //val line: String? = readLine()
    //var ans: String? = "Elvis says: $line"
    //if (line == null) ans = null
    //println(ans ?: throw IllegalStateException())
    println(isNumber(readLine()))
    val regex = Regex("cat.")
    val regex1 = Regex("cat?")
    val string1 = "cat"
    val string2 = "cot"
    val string3 = "cat?"

    println(string1.matches(regex))
    println(string2.matches(regex))
    println(string3.matches(regex))

    println(string1.matches(regex1))
    println(string2.matches(regex1))
    println(string3.matches(regex1))
    val list = mutableListOf(3, 5, 6, 8)
    val map = mutableMapOf(1 to "Luke", 2 to "Kevin", 3 to "Kevin", 4 to "Max", 5 to "Luke")
    val set = mutableSetOf("kev", "frank")
    list
    val numbersByElement = map.values.toList().groupingBy { it }.eachCount()
    println(numbersByElement.maxBy { it.value }?.key)
    println(map.values)
    val letters = mutableMapOf<Int ,String>()
    var i = 1
    do {
        letters[i] = readLine()!!
        i++
        println("Increment check = $i")
    } while (letters[i - 1] != "z")
    print(letters[4])
}

open class Case(val cost: Int) {
    fun getFullInfo(): String = "$$cost cost" + getTax()

    open fun getTax(): Int = (cost * 0.25).roundToInt()
}

open class SoftCase(cost: Int, val color: String) : Case(cost) {
    override fun getTax(): Int = super.getTax() + 100
}

open class WoodCase(cost: Int, val color: String) : Case(cost)

open class LeatherCase(cost: Int, color: String) : SoftCase(cost, color) {
    override fun getTax(): Int = (cost * 0.35).roundToInt()
}

fun getCaseTax(case: Case): Int = case.getTax()

