class Player(val id: Int, val name: String) {
    companion object {
        var role = "playable character"
    }
    fun getInfo() = "$id, $name, $role"
}

fun getPlayerInfo(player: Player) = println(player.getInfo())

fun main() {
    getPlayerInfo(player = Player(6, "racka"))
}