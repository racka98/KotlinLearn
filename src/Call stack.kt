fun repeat(s: String): String {
    return s + s
}

fun printLine(str: String) {
    println(str)
}

fun main() {
    printLine(repeat("Hello!"))
    println("\u0048\u0079\u0070\u0065\u0072\u0073\u006B\u0069\u006C\u006C")
    val myString = "Unicorn"
    println(myString)
}