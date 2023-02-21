package KotlinNackademin

import java.lang.NumberFormatException

fun reader() = readln().toInt()

fun main (){
    var randomNumber = (1..10).random()

    while (true){
        println("Gissa ett nummer mellan 1-10")
        try {
            val guess = reader()
            if (randomNumber == guess ) {
                println("rätt gissat! talet var $randomNumber")
                randomNumber = (1..10).random()
            }
            else if (randomNumber < guess) println("gissa lägre")
            else println("gissa högre")
        }
        catch (e : NumberFormatException){
            println("Du måste skriva ett nummer")
        }
    }
}