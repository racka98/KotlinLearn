package aquarium.generics

import aquarium.separator

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
    init {
        println("${waterSupply::class.simpleName} object has been created")
    }
    fun addWater(cleanerAgent: Cleaner<T>) {
        //Check is present in the standard library. If the value passed inside it is true it proceeds
        //if the value inside it is false it throws an exception with the message provided in the curly brackets
        if (waterSupply.needsProcessed) { cleanerAgent.clean(waterSupply); println("Cleaned the water") }
        println("Adding water from ${waterSupply::class.simpleName}")
    }
}
//To use generic functions inside classes or as member or extension functions, like to check if type R is same as T;
//We need to make the function inline and reified implying that it is a real type.
//In simple words this means that: declare a type parameter R but make it a real type
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyType() = waterSupply is R
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

//Generic Function:
fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>) {
    println("Aquarium water is clean: ${!aquarium.waterSupply.needsProcessed}")
}
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

//Executor function (contains all the logic for execution of the the classes and functions)
fun genericExample() {
    separator()
    val aquarium = Aquarium<TapWater>(waterSupply = TapWater())
    isWaterClean(aquarium)
    aquarium.waterSupply.addChemicalCleaners()
    separator()

    val aquarium4 = Aquarium(LakeWater())
    //aquarium4.waterSupply.filter()
    aquarium4.addWater(LakeWaterCleaner())
    addItemTo(aquarium4)
    isWaterClean(aquarium4)
    println(aquarium4.hasWaterSupplyType<LakeWater>())
    println(aquarium4.waterSupply.isOfType<TapWater>())
    /*val aquarium2 = Aquarium(waterSupply = "string")
    println(aquarium2.waterSupply)*/   //This happens because T is of type Any? and so it can be accepted as string too
                                    // To fix this specify WaterSupply type in T

    //It can even accept null because because T is of type Any? which is nullable
    //To fix specify Any type in T of Aquarium class
        /*val aquarium3 = Aquarium(waterSupply = null)
        println(aquarium3.waterSupply)*/
    separator()
}

fun main() {
    genericExample()
}
