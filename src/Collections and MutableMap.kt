fun solution(numbers: List<Int>) {
    for (nums in numbers) {
        if (nums % 2 == 0) {
            print("$nums ")
        }
    }
}

fun main() {
    val list = mutableListOf(3, 5, 6, 8)
    val map = mutableMapOf(1 to "Luke", 2 to "Kevin", 3 to "Kevin", 4 to "Max", 5 to "Luke")
    val set = mutableSetOf("kev", "frank")
    list
    //val numbersByElement = map.values.toList().groupingBy { it }.eachCount()
    //println(numbersByElement.maxBy { it.value }?.key)
    //println(map.values)
    val letters = mutableMapOf<Int ,String>()
    var i = 1
    println("Enter letter, enter z to stop")
    do {
        letters[i] = readLine()!!
        i++
        println("Increment check = $i")
    } while (letters[i - 1] != "z")
    println(letters[4])

    val words = mutableMapOf<Int, String>()
    var n = 1
    println("Enter words for a collection, enter 'stop' to terminate")
    do {
        val input = readLine()!!
        words[n] = input
        n++
    } while (input != "stop")

    if (words[1] == "stop") println(null)
    else println(words.values.toList().groupingBy { it }.eachCount().maxBy { it.value }?.key)
    println("Enter a list size")
    val size = readLine()!!.toInt()
    println("Enter $size products")
    val products = List(size) { readLine()!! }
    println("Enter product you are searching for")
    val product = readLine()!!
    for (index in products.indices) {
        if (products[index] == product) print("$index ")
    }
}