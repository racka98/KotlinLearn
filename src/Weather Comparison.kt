class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = when {
                value < -92 -> when (name) {
                    "Dubai" -> 30
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    else -> value
                }
                value > 57 -> when (name) {
                    "Dubai" -> 30
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    else -> value
                }
                else -> value
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    var placeholder: City = City("K")

    if (firstCity.degrees < secondCity.degrees) {
        when {
            firstCity.degrees < thirdCity.degrees -> println(firstCity.name)
            firstCity.degrees == thirdCity.degrees -> print("neither")
            else -> print(thirdCity.name)
        }
    } else if (secondCity.degrees < thirdCity.degrees) {
        when {
            secondCity.degrees == firstCity.degrees -> print("neither")
            secondCity.degrees < thirdCity.degrees -> print(secondCity.name)
            else -> print("neither")
        }
    } else if (thirdCity.degrees < secondCity.degrees) print(thirdCity.name)
    else print("neither")
}