package aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    //Values are in cm
    open var volume: Int
        get() = length * width * height / 1000     //Calculate volume and change it to liters
        set(value) {
            println("Value has been set")
            height = (value * 1000) / width * length
        }  //Turns it back to cm3 and calculates the height
    open var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        val water: Int = numberOfFish * 2000  //in cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank(): Aquarium() {
    override var water = volume * 0.8

    override var volume: Int
        get() = (length * width * height / 1000 * PI).toInt()    //Calculate volume and change it to liters
        set(value) {
            println("Value has been set")
            height = (value * 1000) / width * length
        }  //Turns it back to cm3 and calculates the height
}