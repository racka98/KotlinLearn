fun main() {
    val james = Guy()
    println("----------")
    james.actualAge = 10
    james.age = 10

    println("* James' actual age is ${james.actualAge}")
    println("* James' altered age is ${james.age}")
    println("----------")
}


class Guy() {
    var age: Int = 0
        get() {
            println("- Age has been accessed")
            return field
        }
        set(value) {
            field = when {
                value < 18 -> 18
                value in 18..45 -> value
                else -> 45
            }
            println("- Age has been set")
        }
    var actualAge: Int = 0
}