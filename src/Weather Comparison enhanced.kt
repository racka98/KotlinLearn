data class City2(val name: String, val default: Int) {
    var degrees: Int = 0
        set(value) = if (value !in -92..57) field = default else field = value
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City2("Dubai", 30)
    firstCity.degrees = first
    val secondCity = City2("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = City2("Hanoi", 20)
    thirdCity.degrees = third

    print(
        if (firstCity.degrees < secondCity.degrees && firstCity.degrees < thirdCity.degrees) {
            firstCity.name
        } else if (secondCity.degrees < firstCity.degrees && secondCity.degrees < thirdCity.degrees) {
            secondCity.name
        } else if (thirdCity.degrees < firstCity.degrees && thirdCity.degrees < secondCity.degrees) {
            thirdCity.name
        } else {
            "neither"
        }
    )
}