fun main(args: Array<String>) {
    println(if (args[0] < 12.toString()) "Good morning, Kotlin" else "Good night, Kotlin")

    println("Your fortune is: ${getFortuneCookie(getBirthday())}")
}

fun getFortuneCookie(birthday: Int): String {
    val fortune = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
//    birthday = readLine()!!.toInt()
    return when (birthday){
        21 -> "Oh that sucks"
        in 1..10 -> "You are way too early"
        else -> fortune[birthday.rem(fortune.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday in DD format:")
    return readLine()!!.toInt()
}