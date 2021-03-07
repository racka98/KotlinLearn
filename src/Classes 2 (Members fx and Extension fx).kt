class A {
    fun member() = println("hi from member")
}

fun A.extension() = println("hi from extension")

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
}

class Smartphone(val name: String) {
    var price: Int = -5
        get() = name.length - field
}
