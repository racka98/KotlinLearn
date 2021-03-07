class Person(name: String, num: String) {
    var userName: String = name
    var number: String = num
    var data: String = ""
    init {
        data = "$name $num"
    }
    fun addNumbers (a:Int, b:Int): Int {
        return a + b
    }
}

fun main () {
    //Classes, Objects and Constructors
    // Class - blueprint - design (designs a flag)
        // Object - implementation of the blueprint
    // Constructor is a type of function that initiates properties of a class
    val person = Person("Racka", "12345")
    println(person.userName)
    println(person.number)
    println(person.addNumbers(2, 45))
    println(person.data)
}