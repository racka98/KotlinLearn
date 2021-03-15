package aquarium.buildings

open class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)
class Brick : BaseBuildingMaterial(8)

class Building<T: BaseBuildingMaterial>(val buildingMaterial: T) {
    private val baseMaterialsNeeded = 100
    var actualMaterialsNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded
    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} pieces required")
    }
}
fun <T: BaseBuildingMaterial>isBuildingSmall(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("This is a Small building")
    else println("This is a large building")
}

fun main(args: Array<String>) {
    val wood = Building(Wood())
    wood.build()
    println(wood.buildingMaterial::class.simpleName)
    isBuildingSmall(wood)
}