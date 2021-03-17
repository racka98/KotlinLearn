package dashTheGridGame

import kotlin.math.absoluteValue


class Locations(private var width: Int = 4, private var height: Int = 4) {
    private val map = Array(width) { arrayOfNulls<String>(height)}
    var currentLocation = Pair(0,0)     //(x,y) coordinates
    init {
        map[0][0] = "This is the beginning of the journey great traveller! Possible moves: S | E"
        map[0][1] = "You have taken a step. Next moves: S | E | W"
        map[0][2] = "Look out, a dragon! Quick, pick the next move: S | E | W"
        map[0][3] = "The floor is about to collapse, move! S | W"

        map[1][0] = "Next grid, now's your chance to take another step: N | S | E"
        map[1][1] = "The floor is about to collapse. Jump to the next grid: N | S | E | W"
        map[1][2] = "This is getting boring, hope on to the grid to find out new territories: N | S | E | W"
        map[1][3] = "Interesting choice good sir, unfortunately there's nothing here. N | S | W"

        map[2][0] = "You cross an old stone bridge. Your hear the murmuring of water. And another grumbling sound. N | S | E"
        map[2][1] = "A bridge troll appears. It swings a club and demands gold. You give them all your coins. N | S | E | W"
        map[2][2] = "It is getting cooler. A dense fog rolls in. You can hear strange voices. N | S | E | W"
        map[2][3] = "The foothills promise a strenuous journey. You thread your way around gigantic boulders. N | S | W"

        map[3][0] = "Your journey continues. A fox runs across the path with a chicken in its mouth. N | E"
        map[3][1] = "In the distance, you see a house. You almost bump into a farmer with a large shotgun. They pay you no heed. N | W | E"
        map[3][2] = "It is getting hot, and dry, and very, very quiet. You think of water and wish you had brought a canteen. N | E | W"
        map[3][3] = "You have reached the infinite desert. There is nothing here but sand dunes. You are bitten by a sand flea. N | W"

    }
    fun updateLocation(directions: Directions) {
        when (directions) {
            Directions.NORTH -> currentLocation = Pair(currentLocation.first, (currentLocation.second + 1).rem(height))
            Directions.SOUTH -> currentLocation = Pair(currentLocation.first, (currentLocation.second - 1).absoluteValue.rem(height))
            Directions.EAST -> currentLocation = Pair((currentLocation.first + 1).rem(width), currentLocation.second)
            Directions.WEST -> currentLocation = Pair((currentLocation.first - 1).absoluteValue.rem(width), currentLocation.second)
            else -> currentLocation
        }
    }
    fun getDescription(): String? = map[currentLocation.first][currentLocation.second]
}