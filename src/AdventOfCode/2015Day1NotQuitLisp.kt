package AdventOfCode

import java.io.File

private fun readFileToList(fileName: String): String
        = File(fileName).bufferedReader().readLines().toString()

//loopar igenom en string, har två variabler som ökar vid steg upp och steg ned för att sedan returnera våningen
fun countStairsPart1(step : String) :Int{
    var countUp = 0
    var countDown = 0
    for (UoD in step){
        if(UoD.equals('('))countUp++
        else if (UoD.equals(')'))countDown++
    }
     return countUp-countDown

}

//loopar igenom en string, steg upp adderas på, steg ned subtraheras. Hamnar man på våning -1 returneras en räknare för positionen.
fun countStairsPart2(step : String) : Int{
    var countUp = 0
    var counter = 0
    for (UoD in step){

        if(UoD == '(')counter++
        else if (UoD == ')')counter--
        if (counter == -1) return countUp
        countUp++
    }
    return 0

}

//En mycket smidigare sätt att räkna stegen funktionellt.
fun stairs1(stairs: String) : Int{
   return stairs.count{ it == '(' } - stairs.count{ it == ')' }
}

fun main (){

    val filePath = "src/AdventOfCode/paranthesis.txt"

    println(countStairsPart1(readFileToList(filePath)))
    println(countStairsPart2(readFileToList(filePath)))

    val stairList = readFileToList(filePath)

    println(stairs1(stairList))

}




