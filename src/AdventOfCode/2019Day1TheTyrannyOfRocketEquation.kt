package AdventOfCode

import java.io.File


const val pathFile = "src/AdventOfCode/massList.txt"

/* bränsle för moduler beräknad på dess massa (mass/3 -2) del 1
   bränsle för moduler plus för bränslet själv del 2*/


//Läser in textfil med massan för alla moduler och mappar till en lista av int.
private fun readTextFileToIntList(fileName: String): List<Int>
        = File(fileName).readLines().map { it.toInt() }

//Funktion som tar in en lista av int och loopar igenom varje rad och räknar ut hur mycket bränsle som behövs. Returnerar totalen.
 fun calFuelPart1(massList :List<Int>) : Int {
    var fuel = 0

    for (rowValue in massList){
        fuel += rowValue / 3 - 2
    }
    return fuel
}

//tar in lista av int, loopar igenom alla rader och beräknar med en rekursiv funktion även bränsle för bränslet coh returnerar summan.
 fun calFuelPart2(massList: List<Int>) : Int {
    var fuel = 0
    for (row in massList){
        fuel += calFuelForFuelMass(row)
    }
    return fuel
}

//funktion med rekursion som tar in massan och beräknar först bränslet för massan och sedan för varje varv bränsle för bränslet så länge bränslet är lika eller mindre än noll, då returnerar den totalsumman.
fun calFuelForFuelMass(mass: Int): Int {
    var fuel = mass/3 -2
    return if (fuel <= 0) 0
    else fuel + calFuelForFuelMass(fuel)

}




fun Int.fuel() :Int = this/3 - 2 //Använder en extension funktion för att beräkna bränslet

fun Int.fuelForFuelMass(): Int =   // rekursion extension function. Mycket smidigare (Ginsberg)
    if(this < 9)  {
        0
    } else {
        val fuel = this.fuel()
        fuel + fuel.fuelForFuelMass()
    }
fun main(){

    println(readTextFileToIntList(pathFile).sumOf { it.fuel() }) //Beräknar bränslet för alla värden i listan på ett mycket smidigare sätt och anropar extension funktion fuel
    println(readTextFileToIntList(pathFile).sumOf { it.fuelForFuelMass() }) //Beräknar även bränsle för bränslets massa med rekursiv extension funktion.

    println(calFuelPart1(readTextFileToIntList(pathFile)))
    println(calFuelPart2(readTextFileToIntList(pathFile)))
}