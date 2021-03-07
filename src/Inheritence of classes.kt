import kotlin.math.round
open class Book(val pages: Int, val author: String, var cost: Float = 0F) {
    fun getFullInfo(): String {
        return "$pages pages, $author author, $$cost cost"
    }
}

open class Comics(pages: Int, author: String, cost: Float) : Book (pages, author, cost)

class BookPricing(pages: Int, cost: Float) : Comics(pages, "", cost) {
    //Default price is in USD
    fun getUSDCost(): String {
        return "$ $cost is the cost in USD"
    }
    fun getEURCost(): String {
        val eurCost = 0.84F * cost
        return "€ $eurCost is the cost in EUR"
    }
    fun getTZSCost(): String {
        val tzsCost = 2319 * cost
        return "TZS $cost is the cost in Tanzanian Shillings"
    }
}

fun getEURCost(book: Book): String {
    val eurCost = book.cost * 0.84F
    return "From fn: € ${round(eurCost * 100) / 100} is the cost in EUR"
}

open class Button(var color: String = "#FFF", var title: String = "Button") {

    //Only use this if you want to acess internal elements of a class or if you want
    //to store variables/objects that have a strong logical link with a class
    companion object {
        fun imagedButton(color: String, title: String) = Button(color, title)
        fun newInstance() = Button
    }
}

//Inherited class
class CircleButton(_color: String, _title: String, radius: Double = 2.0): Button(_color, _title)

//Singleton
object buttonData {
    fun createButton(): Button =  Button("blue")
    fun spinButton(): Button {
        return Button("purple", title = "Spin")
    }
}

fun main() {
    val book1 = Comics(400, "Legit Book", 24.99F)
    val book2 = Comics(43, "Chandler", 3.49F)

    println(book1.getFullInfo())
    println(BookPricing(book1.pages, book1.cost).getEURCost())
    println(BookPricing(book1.pages, book1.cost).getUSDCost())
    println(BookPricing(book1.pages, book1.cost).getTZSCost())
    println(getEURCost(book1))
    println(BookPricing(book2.pages, book2.cost).getEURCost())
    println(getEURCost(book2))

    //Calling the button class
    val myButton = Button()
    val myRedButton = Button(color = "#FFA")
    val textButton = Button(title = "Adopt")
    val customButton = Button("#000", "Accept")
    val stupidNewButton = Button.imagedButton("#DDD", title = "New")


    //Calling the Singleton class
    val createButton = buttonData.createButton()
    val spiButton = buttonData.spinButton()
    println(createButton == spiButton)

    //Lambda Functions calls
    val greeting = { println("Hellow there!") }
    greeting()
}