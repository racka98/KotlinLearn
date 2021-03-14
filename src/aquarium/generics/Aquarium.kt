package aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

//Adding in and out types in generic classes to make it safe to work with type T when passed as function parameter
//out types only occur in return values of functions or val properties
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleanerAgent: Cleaner<T>) {
        //Check is present in the standard library. If the value passed inside it is true it proceeds
        //if the value inside it is false it throws an exception with the message provided in the curly brackets
        if (waterSupply.needsProcessed) { cleanerAgent.clean(waterSupply); println("Cleaned the water") }
        println("Adding water from ${waterSupply::class.simpleName}")
    }
}
//in types are used when the generic types are only used as arguments of a function
//in types can be passed into an object, out can only be passed out of an object or returned
//Note: constructors can take out types as arguments but functions can't
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}
class LakeWaterCleaner: Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Item added")
fun genericExample() {
    val aquarium = Aquarium<TapWater>(waterSupply = TapWater())
    println(aquarium.waterSupply::class.simpleName + " added")
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium4 = Aquarium(LakeWater())
    //aquarium4.waterSupply.filter()
    aquarium4.addWater(LakeWaterCleaner())
    addItemTo(aquarium4)
    /*val aquarium2 = Aquarium(waterSupply = "string")
    println(aquarium2.waterSupply)*/   //This happens because T is of type Any? and so it can be accepted as string too
                                    // To fix this specify WaterSupply type in T

    //It can even accept null because because T is of type Any? which is nullable
    //To fix specify Any type in T of Aquarium class
        /*val aquarium3 = Aquarium(waterSupply = null)
        println(aquarium3.waterSupply)*/
}

fun main() {
    genericExample()
}
