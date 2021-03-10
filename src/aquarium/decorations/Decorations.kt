package aquarium.decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1) //Since its a data class the contents of the object will be printed instead of the object pointer
                //basically toString() converted already
    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations2("granite", "ebony")
    println(d3)
    val (rock: String, wood: String) = d3
    println("$rock & $wood")
}

//Data classes can be used to store data that only needs to be accessed and it has some
//advantages over the normal class. Like you can compare instances of a data class but can't
//on normal classes
data class Decorations(val rocks: String)

data class Decorations2(val rocks: String, val wood: String)