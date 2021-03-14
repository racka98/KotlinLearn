package spices
import aquarium.separator

fun main(args: Array<String>) {
    val spice = SimpleSpice()
    spice.spiciness = "hot"
    println("Spice name: ${spice.name} \n" +
            "Spiciness level: ${spice.heat}")

    val spices1 = listOf(
        Spices("curry", "mild"),
        Spices("pepper", "medium"),
        Spices("cayenne", "spicy"),
        Spices("ginger", "mild"),
        Spices("red curry", "medium"),
        Spices("green curry", "mild"),
        Spices("hot pepper", "extremely spicy")
    )

    val spiceList = spices1.filter { it.heat >= 3 }
    separator(n = 40)
    for (spices in spiceList) {
        println("Name : ${spices.name}, Spiciness : ${spices.spiciness}")
        separator(n = 40)
    }

    val (curry, jalapinó, pepper) = listOf( SpiceContainer("curry"), SpiceContainer("jalapino"), SpiceContainer("pepper") )
}