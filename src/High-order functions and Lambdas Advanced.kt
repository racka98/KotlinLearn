class Program2 {
    fun addTwoNums(a: Int, b: Int, action: (Int, Int) -> Int) {     //High Level Function with a Lambda as a parameter
        val result = action(a, b)     // x + y (from lambda) = a + b Respectively
        println(result)
    }

    fun addTwoNums2(a: Int, b: Int, action: (Int, Int) -> Unit) {     //High Level Function with a Lambda as a parameter
        action(a, b)     // result = x + y (from lambda) = a + b Respectively
    }

    fun reverseAndDisplay(str: String, myRev: (String) -> String) {
        val result = myRev(str)     // it.reversed == str.reversed
        println(result)
    }
}

class Person1(var name: String = "", var age: Int = -1) {
    fun startRun() {
        println("I'm ready for the run")
    }
}

fun main(args: Array<String>) {
    val program = Program2()
    var result = 0
    /*val thisIsALambda: (Int, Int) -> Int = { x: Int, y: Int -> x + y }        //Lambda Expression / Function
    program.addTwoNums(2, 5, thisIsALambda)*/
    program.addTwoNums(2, 5, {x, y -> x + y})
    program.addTwoNums(2, 5) {x, y -> x + y}   //You can also declare the lambda outside the parenthesis

    // Modifying outside variables inside the lambda
    program.addTwoNums2(2, 5) {x, y -> result = x + y}
    println(result)

    program.reverseAndDisplay("Yellow") { it.reversed()}    // 'it' is the name of the single parameter inside the lambda
    val person = Person1()
    with(person) {
        name = "Racka"
        age = 21
    }

    person.apply {
        name = "Rose"
        age = 20
    }.startRun()

    println(person.name)
    println(person.age)
}
