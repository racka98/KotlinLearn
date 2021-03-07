import java.io.File
import kotlin.math.*

fun main() {
    val filename = "src/words.txt"
    val file = File(filename)
    val list = mutableListOf<String>()
    var map = file.forEachLine { list.add(it) }
    println(list.maxBy { it.length }?.length)

    var n = 0
    val filenamenum = "src/wordsnum.txt"

    val numList = File(filenamenum).forEachLine { if (it?.toIntOrNull()?.let { true } ?: false) n++}
    println(n)

    val inputArray = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9),
        arrayOf(10, 11, 12)
    )

    val ans = inputArray[2].joinToString(", ")
    println(ans)

    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()

    val determinant = b * b - 4.0 * a * c

    val root1 = (-b + sqrt(determinant)).div(2 * a)
    val root2 = (-b - sqrt(determinant)).div(2 * a)

    val ans2 = arrayOf(root1, root2)
    ans2.sort()
    println(ans2.joinToString(" "))

    println(floor(sqrt(14.0)))
}
