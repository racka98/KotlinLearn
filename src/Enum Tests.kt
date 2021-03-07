import java.util.Scanner
enum class Country (val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian dollar"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar");
   /* companion object {
        fun isAbsent(country1: String, country2: String): Boolean {
            val contains: Boolean =
                    try {
                        Country.valueOf(country1)
                        //Country.valueOf(country2)
                        true
                    } catch (e: IllegalArgumentException) {
                        false
                    }
            /*for (enum in Country.values()) {
                if (country1 == enum.name || country2 == enum.name) return enum.name
            }*/
            //return contains
        }
    } */
   companion object {
       fun isSame(country1: String, country2: String) {
           var firstCurrency = ""
           var secondCurrency = ""
           for (enum in Country.values()) {
               if (enum.name == country1) firstCurrency = enum.currency
               if (enum.name == country2) secondCurrency = enum.currency
           }
           return println(firstCurrency == secondCurrency)
       }
   }
}

enum class DangerLevel(val lv: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int {
        return lv
    }
}

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(width_: Int, height_: Int) {
        println(this.width)
        this.width = width_
        this.height = height_
        println(this.width)
        println(width_)
    }
}

fun main(args: Array<String>) {
    //val input = Scanner(System.`in`)
    //val country1 = input.next()
    //val country2 = input.next()
    //println(Country.isSame(country1, country2))
    val high = DangerLevel.HIGH
    val medium = DangerLevel.MEDIUM
    println(high.getLevel())
    val size = Size(3, 4)

}