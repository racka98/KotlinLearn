val name = "Nate"
var greet: String? = null


fun main() {
    greet = "Hello"
    val greet2 = when (greet){
        null -> "Hi"
        else -> greet
    }
    println(greet2)
    println(name)
}

