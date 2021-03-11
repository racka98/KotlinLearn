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

}

private class BookPairs(val title: String, val author: String, val year: Int) {
    fun bookPair(): Pair<String, String> {
        return title to author
    }

    fun triplePair(): Triple<String, String, Int> {
        return Triple<String, String, Int>(title, author, year)
    }
}
