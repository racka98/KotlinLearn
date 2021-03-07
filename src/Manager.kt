import java.util.*

class Task(var name: String)
object Manager {
    var solvedTask: Int = 0
    fun solveTask (task: Task) {
        val ans = println("Task ${task.name} solved!")
        solvedTask ++
        return ans
    }
}

fun main() {
    val tasks = arrayOf("one", "two", "three", "four")
    for (task in tasks) {
        Manager.solveTask(Task(task))
        println("Task count: ${Manager.solvedTask}")
    }
    val input = Scanner(System.`in`)
    val data = arrayOf("red", "orange", "yellow", "green", "blue", "indigo", "violet")
    val color = input.next().toLowerCase()
    for (x in data) {
        if (x == color) println(data.indexOf(x) + 1)
    }
}