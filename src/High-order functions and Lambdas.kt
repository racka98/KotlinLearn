class Program {
    fun addTwoNums(a: Int, b: Int, action: MyInterface) {        //Interface / OOP way
        val sum = a + b
        action.execute(sum)
//        println(sum)
    }

    fun addTwoNums(a: Int, b: Int, action: (Int) -> Unit) {     //High Level Function with a Lambda as a parameter
        val sum = a + b
        action(sum)     //This will be converted to 's' in the lambda thus being println(s)
    }

    fun addTwoNums(a: Int, b: Int) {        // Simple way
        val sum = a + b
        println(sum)
    }
}


// An interface is a listener
interface MyInterface {
    fun execute(sum: Int)
}

fun main(args: Array<String>) {
    val program = Program()
    program.addTwoNums(2, 5)

    // Call the object keyword then followed by Interface name which will create
    //a new instance that implements the interface
    program.addTwoNums(2, 5, object : MyInterface {
        override fun execute(sum: Int) {
            println(sum)
        }

    })

    val thisIsALambda: (Int) -> Unit = { t: Int -> println(t) }        //Lambda Expression / Function
}