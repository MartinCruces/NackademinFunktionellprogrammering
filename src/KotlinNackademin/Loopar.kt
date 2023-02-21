package KotlinNackademin

fun printEvenNumbers(){

    //Write all even numbers between 1-20 backwards
    for (i in 20 downTo 1) if (i % 2 == 0)  println(i)
}
fun printMultiplicationTable(table : Int, start : Int, stop : Int) {
    for(i in start..stop) println(i * table)
}

fun isThisAPrime(testNumber:Int) : Boolean{
    if (testNumber == 1 || testNumber == 2) return false

    for (x in 2..testNumber/2){
        if (testNumber % 2 == 0) return false
    }
    return true
}

fun main(){
    //printEvenNumbers()

    //printMultiplicationTable(3,0,10)

    println(isThisAPrime(7))


}