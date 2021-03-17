package dashTheGridGame

import aquarium.separator

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}
class Game(var path: MutableList<Directions> = mutableListOf(Directions.START)) {
    private val north = { path.add(Directions.NORTH) }
    private val south = { path.add(Directions.SOUTH) }
    private val east = { path.add(Directions.EAST) }
    private val west = { path.add(Directions.WEST) }
    private val end = {
        path.add(Directions.END)
        separator()
        println("Game over: ${path.joinToString(" -> ")}")
        path.clear()
        false
    }
    private val retry = {
        separator()
        println("Wrong entry! Try again")
        false
    }
    val map = Locations()
    init {
        separator(separator = "==")
        println("$path: the game has started at location ${map.currentLocation}")
        println("To quit the game type \"Q\" or \"Cancel\"")
        separator()
    }
    fun makeMove(arg: String?) {
        try {
            when (arg?.toUpperCase()?.first()) {
                Directions.NORTH.toString().first() -> {
                    move(north)
                    map.updateLocation(Directions.NORTH)
                }
                Directions.EAST.toString().first() -> {
                    move(east)
                    map.updateLocation(Directions.EAST)
                }
                Directions.SOUTH.toString().first() -> {
                    move(south)
                    map.updateLocation(Directions.SOUTH)
                }
                Directions.WEST.toString().first() -> {
                    move(west)
                    map.updateLocation(Directions.WEST)
                }
                "Q".first() -> move(end)
                "Cancel".first() -> move(end)
                else -> move(retry)
            }
        } catch (e: Exception) {
            println("The field cannot be empty! Enter a direction")
        }
    }
}

fun main() {
    val game = Game()
    while (true) {
        print("Enter a direction: N | S | E | W:")
        val console = readLine()
        game.makeMove(console)
        if (!console.equals("")){ println("Current state: ${ game.map.getDescription() }"); separator() }
        if (game.path.isEmpty()) {
            separator(separator = "==")
            return
        }
    }

}

fun move(where: () -> Boolean) {
    where()
}