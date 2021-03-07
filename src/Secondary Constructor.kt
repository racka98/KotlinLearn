class Fabric(var color: String = "grey", var size: String = "10x10cm") {
    var pattern: String = "none"
    var patternColor: String = "none"
    //var size: String = "10x10cm"
    init {
        println("$color fabric of size $size is created")
    }

    constructor(color: String, pattern: String, patternColor: String): this(color = "blue", size = "1x1cm") {
        this.color = color
        this.pattern = pattern
        this.patternColor = patternColor
        println("the fabric is dyed $color")
        println("$patternColor $pattern pattern is printed on the fabric")
    }
}

fun main() {
    val fabric0 = Fabric("yellow", "5x5cm")
    val fabric = Fabric("purple", "cross", "red")
}