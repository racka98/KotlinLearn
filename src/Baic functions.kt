

fun sayHello(greet:String, vararg itemstogreet:String) {
    itemstogreet.forEach {itemtogreet ->
        println("$greet $itemtogreet")
    }
}

fun main() {
    val interestingThings = listOf("Kotlin", "Program", "Books")
    sayHello(greet = "Hi", itemstogreet = *arrayOf("Kotlin", "Program", "Books"))
}
   val interestingThings = mutableListOf("Kotlin", "Program", "Books")