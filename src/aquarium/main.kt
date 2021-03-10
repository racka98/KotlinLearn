package aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

private fun buildAquarium() {       // Private: Wont be accessible anywhere else
    val myAquarium = Aquarium()     // Uses default arguments passed in the class constructor
    println("Length: ${myAquarium.length} cm " +
            "Width: ${myAquarium.width} cm " +
            "Height: ${myAquarium.height} cm")

    myAquarium.height = 60
    println("Height is now: ${myAquarium.height} cm")

    println("Volume is: ${myAquarium.volume} l")
    // println("New height is: ${myAquarium.height}")

    val smallAquarium = Aquarium(length = 40, width = 10, height = 20)
    separator()
    println("Volume of small aquarium is: ${smallAquarium.volume} l with " +
            "Length: ${smallAquarium.length} " +
            "Width: ${smallAquarium.width} " +
            "Height: ${smallAquarium.height}")
    separator()
    val smallAquarium2 = Aquarium(numberOfFish = 10)
    println("Volume of small aquarium 2 is: ${smallAquarium2.volume} l with " +
            "Length: ${smallAquarium2.length} " +
            "Width: ${smallAquarium2.width} " +
            "Height: ${smallAquarium2.height} \n" +
            "& Number of fish: $smallAquarium2")
    separator()
}

fun separator(n: Int = 30) = println("*".repeat(n))

fun feedTheFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark: ${shark.color} \nPlecostomus: ${shark.color}")
    separator()

    shark.eat()
    plecostomus.eat()
}