package aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

private fun buildAquarium() {       // Private: Wont be accessible anywhere else
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} cm " +
            "Width: ${myAquarium.width} cm " +
            "Height: ${myAquarium.height} cm")

    myAquarium.height = 60
    println("Height is now: ${myAquarium.height} cm")

    println("Volume is: ${myAquarium.volume} l")
    // println("New height is: ${myAquarium.height}")
}