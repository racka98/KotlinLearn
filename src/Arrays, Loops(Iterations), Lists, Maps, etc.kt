import java.util.*
import kotlin.math.pow

var fish = 12
var plant = 5
val swarm = listOf(fish, plant)
val school = arrayOf("tuna", "Salmon", "shark")
val numbers = intArrayOf(1,2, 3, 4)
val mix = arrayOf("fish", 2)

fun main() {
    val interestingThings = arrayOf("Kotlin", "Java", "Programming", "Books")
    //println(Arrays.toString(mix))
    //Nesting arrays. (Putting arrays inside arrays/Array of array)
    val bigSwarm = arrayOf(swarm, arrayOf("dolphin", "whale", "orka", "seal"))
    //println(Arrays.toString(bigSwarm))

    /*val array = Array(7) {1000.0.pow(it)}
    val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte",
            "terabyte", "petabyte", "exabyte")
    for ((i, value) in array.withIndex()) {
        println("1 ${sizes[i]} = ${value.toLong()} bytes")
    }*/

    val numbers = intArrayOf( 11, 12, 13, 14, 15)
    val emptyList = mutableListOf( "" )

    print("1")
    print("2")
    println("3")
    println()
    println("4")


}
