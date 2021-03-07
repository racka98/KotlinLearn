import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("What is a?")
    val a = scanner.nextInt()
    println("What is the operator used?")
    val op = scanner.next()
    println("What is b?")
    val b = scanner.nextInt()

    when (op) {
        "+", "plus" -> {
            val sum = a + b
            println(sum)
        }
        "-", "minus" -> {
            val diff = a - b
            println(diff)
        }
        "*", "times" -> {
            val product = a * b
            println(product)
        }
        else -> println("Unknown operator")
    }
    val g = 10

    when (g) {
        in 1..20 -> println("Ok")
        in 1..22 -> println("OK")
        11, 12 -> println("OK")
        g + g -> println("OK")
    }

}