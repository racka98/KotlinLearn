package aquarium

data class Fish(var name: String)

fun main() {
    fishExample()
}

fun fishExample() {
    val sparky = Fish("Sparky")
    //original with function
    //This creates a copy of the property and doesn't actually modify it
    with(sparky.name) {
        println(toUpperCase())  //Actual changes
        println(this)   //this is unchanged sparky.name
    }
    //My simple with function
        //Without inline an object is created with every call to myWith
    myWith(sparky.name, object: Function1<String, Unit> {
        override fun invoke(name: String) {
            name.toUpperCase()
        }
    })
            //OR
        myWith(sparky.name) {
            toUpperCase()
        }
        //With inline no object is created, and lambda body is inlined here so there's no overhead cost
        //when calling myWith
    sparky.name.toUpperCase()

    //Other functions in the kotlin std library with extension lambdas
    println(sparky.run { name })
    println(sparky.apply { name = "Shark" })
    sparky.apply {
        name = "Pleco"
        println(name)
    }

    val list = listOf(1,2,3,4,5,6,7,8,9,0)
    println(list.isDivBy { it.rem(3) })
}
inline fun myWith(name: String, block: String.() -> Unit) = name.block()

fun List<Int>.isDivBy(block: (Int) -> Int): List<Int> {
    val newList = mutableListOf<Int>()
    for (i in this) {
        if (block(this[i]) == 0) newList.add(this[i])
    }
    return newList
}
