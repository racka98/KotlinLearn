import aquarium.separator

//Constants: const val is set at compile time while val is set at execution
//Since const val is set at compile time we can not pass a function to set its value
//const val only works at top level and in class declared by object keyword (singletons) and not in regular classes
//only then can you call it inside a class or function
const val thisIsAConstant = "top-level declaration"
const val maximumBooks: Int = 5

object Constant {
    const val thisIsAConstant2 = "object declaration"
}

//You can only declare const val inside a class by passing it inside a companion object
class MyClass {
    companion object {
        const val thisIsAConstant3 = "inside a companion object"
    }
}

fun main(args: Array<String>) {
    val book = BookPairs("KTX", "Google", 2020).triplePair()
    println("Here is your book ${book.first} written by ${book.second} in ${book.third}.")
    // Map
    val assignments: Map<String, String> = mapOf("English" to "Ronald", "Physics" to "Peter", "French" to "Henry")
    //get the value of a key
    var getValue = assignments.get("English")   //OR
    getValue = assignments["English"]
    println(getValue)

    //set a default value or code block for non existent keys
    val doesntExist = assignments.getOrDefault("Maths", "No one is assigned to that subject")
    val doesntExistCodeBlock = assignments.getOrElse("Android") { book.second }
    println("$doesntExist \n$doesntExistCodeBlock")

    //You can also make a mutable map
    val inventory: MutableMap<String, Int> = mutableMapOf("fish net" to 5)
    inventory.put("Rake", 10)
    println(inventory)
    inventory.remove("fish net")
    print(inventory)
    inventory.replace("Rake", 10, 5)
    println(inventory)

    //Sets
    val allBooks = setOf<String>("The Odds", "White Lotus", "Jetpack Compose for Beginners")
    val library = mapOf(allBooks to "Minny")
    println(library.any { it.value.contains("Minny") })

    //Calling a constant value in the singleton
    val constant = Constant.thisIsAConstant2
    println(constant)
    separator()
    val james = BookBorrowed("KotlinEssentials", 5)
    println("Can borrow: ${james.canBorrow()}")
    james.printUrl()
    separator()

}
private class BookBorrowed(val title: String, val numberOfBooks: Int) {
    fun canBorrow(): Boolean {
        return numberOfBooks < maximumBooks
    }
    companion object Constants { const val BASE_URL = "https://thislibrary.com/" }

    fun printUrl() = println("URL: $BASE_URL${title.toLowerCase()}.html")
}

private class BookPairs(val title: String, val author: String, val year: Int) {
    fun bookPair(): Pair<String, String> {
        return title to author
    }

    fun triplePair(): Triple<String, String, Int> {
        return Triple<String, String, Int>(title, author, year)
    }
}
