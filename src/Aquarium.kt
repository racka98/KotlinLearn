import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello there ${args[0]}")
    feedTheFish()
    println("Can you fit more fish: ${canFitMoreFish(10.0, listOf(), 7, true)}")

}

fun feedTheFish() {
    val day = dayOfTheWeek()
    val food = fishFood(day)
    println("Today is $day, the food is $food")
    if (shouldChangeWater(day)) println("Change the water today!")
    else println("The water is still fine!")

    dirtyProcessor()
}

fun dayOfTheWeek(): String {
    val days = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return days[Random.nextInt(days.size)]
}

fun fishFood(day: String): String {
    var food = "Fasting"

    return when(day) {
        "Monday" -> "Pellets"
        "Tuesday" -> "Plankton"
        "Wednesday" -> "Bread"
        "Thursday" -> "Biscuits"
        "Friday" -> "Sea weed"
        "Saturday" -> "Lettuce"
        "Sunday" -> "Redworms"
        else -> food
    }
}

// tankSize is gallons, fishSize in inches,
fun canFitMoreFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true): Boolean {
    val totalCurrentFishSize = currentFish.sum()
    val tankDecorations = if (hasDecorations) tankSize * 0.8 else tankSize
    return when {
        tankDecorations >= totalCurrentFishSize + fishSize -> true
        else -> false
    }
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 20,
    dirty: Int = 20): Boolean {

    val isDirty = dirty == 30
    val isHot = temperature > 30
    val isSunday = day == "Sunday"
    return when {
        isHot -> true
        isDirty -> true
        isSunday -> true
        else -> false
    }
}

var dirty1 = 20
//Lambda Function
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
//Named function
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    //Calling updateDirty with a pre defined lambda function
    updateDirty(dirty1, waterFilter)
    //Calling updateDirty with a named function
    updateDirty(dirty1, ::feedFish)
    //Calling updateDirty with a lambda function
    updateDirty(dirty1) { dirty -> dirty + 50 }
    /*this can also be written as:
    updateDirty(dirty1, { dirty -> dirty + 50 })*/
}

fun List<Int>.findTheSmallest(n: (List<Int>) -> Int){

}