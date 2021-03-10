package aquarium

// interfaces can not have constructors and are class that can't be instantiated
//Abstract classes also can't be instantiated but can contain constructors

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {
    override val color: String = "grey"
    override fun eat() {
        println("Swallow that b")
        separator()
    }
}
class Plecostomus: AquariumFish(), FishAction {
    override val color: String = "gold"
    override fun eat() {
        println("Munching that b")
        separator()
    }
}

interface FishAction {
    fun eat()
}