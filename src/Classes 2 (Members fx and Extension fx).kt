import aquarium.separator

class A(val memberName: String, val age: Int) {
    //Members functions inside class A
    fun memberFunc() = println("hi from $memberName, I am $age year(s) old")
}

//Extends the functionality of a class
fun A.extensionFunc() {
    println("hi from $memberName extension, I am $age year${if (age > 1) "s" else ""} old")
}
//You can also extend classes into variables (Extension properties)
val A.isOld: Boolean
    get() = age >= 18
/* class Task(var name: String)
object Manager {
    var solvedTask: Int = 3
    fun solveTask (task: Task) {
        val ans = println("Task ${task.name} solved!")
        solvedTask ++
        return ans
    }
} */

class Block(val color: String) {
    object DimProperties{
        var length = 10
        var width = 4
        var area = length * width

        fun blocksInBox(width: Int, length: Int): Int {
            var c1 = length / this.length
            var c2 = width / this.width
            println("c1 is: $c1 & c2 is: $c2")
            return (c1 + c2) / 2
        }
    }
}

fun main() {
    val smartOne = Smartphone("Ericsong")
    //smartOne.price = -24
    val smartTwo = Smartphone("iNokhe")
    //print(smartTwo.price - smartOne.price)

    //Block.DimProperties.blockInBox(15, 6)
    val block = Block("red")
    println(block.color)
    println(Block.DimProperties.blocksInBox(16, 30))
    Manager.solveTask(Task("racka"))
    println(Manager.solvedTask)
    repeat(2) { separator(separator = "=", n = 40) }
    //Calling member functions, extension functions and Extension properties
    val member1 = A("Member 1", 19)
    val member2 = A("Member 2", 17)
    val member3 = A("Member 3", 1)
    //Member function
    member1.memberFunc()
    member2.memberFunc()
    member3.memberFunc()
    separator("+", 50)
    member1.extensionFunc()
    member2.extensionFunc()
    member3.extensionFunc()
    separator("+", 50)
    println("Is ${member1.memberName} old enough: ${member1.isOld}")
    println("Is ${member2.memberName} old enough: ${member2.isOld}")
    println("Is ${member3.memberName} old enough: ${member3.isOld}")
    repeat(2) { separator(separator = "=", n = 40) }
}

class Smartphone(val name: String) {
    var price: Int = -5
        get() = name.length - field
}
