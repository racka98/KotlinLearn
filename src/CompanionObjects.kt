class Player(val id: Int, val name: String) {
    companion object {
        var role = "playable character"
    }
    fun getInfo() = "$id, $name, $role"
}
//Use companion objects to create static fields (static variables and static methods)
//companion object can be used to store data that is only passed once during class instantiation
//like company name, book author, etc that is only loaded in the memory once
fun getPlayerInfo(player: Player) = println(player.getInfo())

fun main() {
    getPlayerInfo(player = Player(6, "racka"))
}