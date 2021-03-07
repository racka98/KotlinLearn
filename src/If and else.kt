var count = 10
val countB = 20
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

fun generateAnswerToString(countThreshold: Int): String {
    return when {
        count + countB == countThreshold -> "I have the answer"
        count + countB > countThreshold -> "Answer out of range"
        else -> "Answer is below the range"
    }
}
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}

fun main() {
    println(generateAnswerToString(40))
    val stringlength: Int = stringLengthFunc("Kotlin")
    println(stringlength)
    println(stringMapper("Android") { input ->
        input.length
    })

}
