import java.util.Scanner // a class (type) from the Java standard library
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`) // reads data

    val num1 = scanner.nextInt() // reads the first number
    val num2 = scanner.nextInt() // reads the second number

    //println(num2) // prints the second number
    //println(num1) // prints the first number
    val num = 100

    val res: Double = sqrt(num.toDouble())

    learn()
}

fun learn() {
    val d: Double = Double.MAX_VALUE
    val i = d.toInt()
    val s = d.toString()
    val f = d.toFloat()

    println(d)
    println(i)
    println(s)
    println(f)
}