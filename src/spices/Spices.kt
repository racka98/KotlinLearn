package spices

import java.awt.Color

class SimpleSpice {
    var name = "curry"
    var spiciness = "mild"
    var heat: Int = 0
        get() {
            return when (spiciness) {
                "mild" -> 5
                "hot" -> 10
                else -> field
            }
        }
}

class Spices(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
}

//Helper function
fun makeSalt() = Spices("salt")

open class Book(val title: String, val author: String) {
    private var currentPage: Int = 0

    open fun readPage() = currentPage++
}

class eBook(val format: String = "text"): Book(title = "default", author = "default") {
    private var wordsCount: Int= 0
    override fun readPage(): Int {
        wordsCount += 250
        return wordsCount
    }
}


// Abstract classes, interfaces and delegation
abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String,
            color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {
    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

//Singleton
object YellowSpiceColor : SpiceColor {
    override val color = "Yellow"
}

//Data class
data class SpiceContainer(val spiceName: String)
