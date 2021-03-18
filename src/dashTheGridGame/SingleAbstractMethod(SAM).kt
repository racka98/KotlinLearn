package dashTheGridGame


//SAM just means an interface with one method on it
interface Runnable {
    fun run()
}

interface Callable<T> {
    fun call(): T
}

fun example() {
    val runnable = object : Runnable {
        override fun run() {
            println("This is a runnable!")
        }
    }
}
val a = 200
val b = 34
val res = if (a == b) 0 else b

fun main() {
    for (i in 1..50 step 5) println(i)
    val message = "Hey"
    val number = message as? Int
    println(number)
}
