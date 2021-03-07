val greeting = "Hello"
val languageName: String? = null


fun main() {
    println(greeting)
    if (languageName != null) {
        println(languageName.toUpperCase())
    }
}