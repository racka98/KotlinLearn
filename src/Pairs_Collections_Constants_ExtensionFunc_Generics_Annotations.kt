import aquarium.separator
import kotlin.random.Random

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
private class BookPairs(val title: String, val author: String, val year: Int) {
    fun bookPair(): Pair<String, String> {
        return title to author
    }

    fun triplePair(): Triple<String, String, Int> {
        return Triple<String, String, Int>(title, author, year)
    }
}


class BookBorrowed(val title: String, val numberOfBooks: Int, var pages: Int) {
    fun canBorrow(): Boolean {
        return numberOfBooks < maximumBooks
    }
    companion object Constants { const val BASE_URL = "https://thislibrary.com/" }

    fun printUrl() = println("URL: $BASE_URL${title.toLowerCase()}.html")
}
//Extension function
fun BookBorrowed.weight() = pages * 1.5     //number of pages multiply by 1.5 grams
fun BookBorrowed.tornPages(tornPages: Int) = if (pages >= tornPages) pages -= tornPages else pages = 0

class Puppy() {
    fun playWithBook(book: BookBorrowed): Int {
        val removedPages: Int = Random.nextInt(12) //Logically the puppy can't tear a large number of pages at once
        println("Pages removed: $removedPages")
        book.tornPages(removedPages)
        return book.pages
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
    val james = BookBorrowed("KotlinEssentials", 5, 200)
    println("Can borrow: ${james.canBorrow()}")
    james.printUrl()
    separator()

    //Calling the extension functions and method functions of BookBorrowed
    val borrowed = BookBorrowed("KT for Android", 2, 350)
    println("Weight of the book: ${borrowed.weight()}")
    println("Original Page number: ${borrowed.pages}")
    borrowed.tornPages(98)
    println("Pages after being torn: ${borrowed.pages}")
    val puppy = Puppy()
    var count1: Int = 0
    var pagesCount = borrowed.pages
    separator()
    while (borrowed.pages > 0) {
        separator(separator = "+")
        puppy.playWithBook(borrowed)
        count1++
        println("Round: $count1 completed \n" +
                "Pages left: ${borrowed.pages}")
    }
    println("Puppy has demolished the ${borrowed.title} book :(")
    separator()

}

