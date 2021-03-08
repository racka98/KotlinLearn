package aquarium

class Aquarium {
    //Values are in cm
    var length: Int = 100
    var width: Int = 20
    var height: Int = 40

    var volume: Int
        get() = length * width * height / 1000     //Calculate volume and change it to liters
        set(value) {
            println("Value has been set")
            height = (value * 100) / width * length
        }  //Turns it back to cm3 and calculates the height
}