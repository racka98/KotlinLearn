//Singleton class: Is instantiated once into an object and constructors (ie Google(val size: Int)) are not allowed
object Google {
    val currentCEO = "Sundar Pichai"
    val parentCompany = "Alphabet Inc"

    fun dontBeEvil() {
        //Probably some evil algorithm
    }
}

//enum class: Is also instantiated once but stores enums
//All constants inside enum class are objects
enum class Color(val rgb: Int) {
    RED(0xff0000),
    GREEN(0x00ff00),
    BLUE(0x0000ff)
}
enum class RectangleSize(val length: Int, val width: Int) {
    SMALL(10, 5),
    LARGE(60, 30),
    MEDIUM(30, 15)
}

//Sealed Class: A class that can be sub classed but only in the same file its declared
//This is a safe way to represent fixed types
sealed class Seal
class SealLion: Seal()
class Walrus: Seal()

fun main() {
    val medium = listOf<Int>(RectangleSize.MEDIUM.length, RectangleSize.MEDIUM.width)
    println(medium.joinToString(" | "))
}