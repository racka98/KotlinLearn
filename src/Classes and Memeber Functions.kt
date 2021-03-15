class Car(val make: String, val year: Int) {

    var speed: Int = 0
    //Member functions
    fun accelerate(times: Int) {
        for (i in 1..times) speed += 5
        println(speed)
    }
    fun decelerate() {
        speed -= 5
        if (speed < 0) speed = 0
        println(speed)
    }
}

class Cat(val name: String) {

    /** The current state of the cat (by default a cat isn't sleeping). */
    var sleeping: Boolean = false

    /**
     * A cat says "meow" if it is not sleeping, otherwise, it says "zzz".
     * After a cat says "meow", it can sometimes fall asleep.
     */
    fun say() {
        if (sleeping) {
            println("zzz")
        } else {
            println("meow")

            if (Math.random() < 0.5) {
                sleeping = true
            }
        }
    }

    /** The function wakes the cat. */
    fun wakeUp() {
        sleeping = false
    }
}
//Now, we can create an instance of a class and invoke its functions. Do not forget that a cat that you have just created is not sleeping.

fun main() {
    val pharaoh = Cat("Pharaoh")  // Create a cat named "Pharaoh"

    repeat (5) {
        pharaoh.say()  // it says "meow" or "zzz"
    }

    pharaoh.wakeUp()  // wake the cat up
    pharaoh.say()  // it says "meow"

    val merc = Car("BenzCL50", 2019)
    merc.accelerate(5)
    merc.accelerate(1)
    Car("Toyota", 2020).accelerate(3)

}