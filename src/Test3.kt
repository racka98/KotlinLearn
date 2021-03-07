import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

   /* val n = scanner.nextInt()
    val inc = IntArray(n) { scanner.nextInt() }
    val tax = IntArray(n)

    for (i in 0..tax.lastIndex) {
        tax[i] = scanner.nextInt() * inc[i]
    }
    println(Arrays.toString(tax)) */
    //while (scanner.hasNext()) {
     //   println(scanner.next())
    //}
    val hey = scanner.next()
    var add = 0

    val a = hey.groupingBy { it }.eachCount().any { it.value < 2 }

    //add = hey.filter { it == 'i' }.count()
    //println(add)
    loop@ for (i in hey.indices) {
        if (hey.filter { it == hey[i] }.count() < 2) add++

    }
    print(add)
    val part = "Hello World"
    val parts: Array<String> = part.split(" ").toTypedArray()
    println(parts.contentToString())
}