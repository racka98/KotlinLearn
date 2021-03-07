import kotlin.random.Random

data class Student(val email: String, val age: Int, val workExperience: Int)

fun main(args: Array<String>) {
   val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    // 1. Curries
    val curries = spices.filter { it.contains("curry") }.sortedBy(stringLengthFunc)
    println(curries)
    // 2. Starts with 'c' and ends with 'e'
    val ce = spices.filter { it.first() == 'c' && it.last() == 'e' }
    println(ce)
    // 3. First 3 elements that start with 'c'
    val threeC = spices.take(3).filter { it.startsWith('c') }
    println(threeC)
    println(gamePlay(rollDice(3)))

    val students: List <Student> = listOf (
        Student("toto@gmail.com", 20, 2000),
        Student("hello@gmail.com", 18, 0),
        Student("oc@gmail.com", 35, 1000))

//    println (students.maxStudent {it.experience})
//    println (students.maxStudent {it.age})
    val ans = students.maxBy { it.age }
}

val rollDice: (Int) -> Int = { n: Int -> if (n == 0) 0 else Random.nextInt(1, n + 1) }

fun gamePlay(rollDice1: Int): Int {
  return rollDice1
}



