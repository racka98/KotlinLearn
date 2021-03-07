import kotlin.random.Random

fun createDiceGameRandomizer(n: Int): Int {
    var generator: Int = 0
    do {
        val randomizer = Random(generator)
        println(generator)
        val array1 = IntArray(n) { randomizer.nextInt(1, 7)}
        val array2 = IntArray(n) { randomizer.nextInt(1, 7)}
        println(array1.joinToString(" "))
        println(array2.joinToString(" "))
        val player = array1.sum()
        val comp = array2.sum()
        println("player = $player , comp = $comp")
        println(player > comp)
        generator++
    } while (player > comp)
    return generator - 1
}

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    val generator = Random(seed)
    val array = CharArray(10) { generator.nextInt(33, 127).toChar() }
    println(33.toChar())
    println(array.joinToString(""))
    randomPassword = array.joinToString("")
    return randomPassword
}

fun main() {
    println("Insert a number of tries (from 1 and onwards)")
    println(createDiceGameRandomizer(readLine()!!.toInt()))
    println("Enter the seed number")
    generatePredictablePassword(readLine()!!.toInt())
}