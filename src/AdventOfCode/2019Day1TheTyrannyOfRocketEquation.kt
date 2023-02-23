package AdventOfCode

import java.io.File


private const val pathFile = "src/AdventOfCode/massList.txt"


//Läser in textfil med massan för alla moduler och mappar till en lista av int.
private fun readTextFileToIntList(fileName: String): List<Int>
        = File(fileName).bufferedReader().readLines().map { it.toInt() }

//Funktion som tar in en lista av int och loopar igenom varje rad och räknar ut hur mycket bränsle som behövs. returnerar totalen.
private fun calFuelPart1(massList :List<Int>) : Int {
    var fuel = 0

    for (rowValue in massList){
        fuel += rowValue / 3 - 2
    }
    return fuel
}

//tar in lista av int, loppar igenom alla rader och beräknar med en rekursiv funktion även bränsle för bränslet coh returnerar summan.
private fun calFuelPart2(massList: List<Int>) : Int {
    var fuel = 0
    for (row in massList){
        fuel += calFuelForFuelMass(row)
    }
    return fuel
}

//rekrusiv funktion som tar in massan och beräknar  förs bränslet för massan och sedan för varje varv bränsle för bränslet så länge bränset är lika eller mindre än noll, då returnerar den totalsumman.
private fun calFuelForFuelMass(mass: Int): Int {
    var fuel = mass/3 -2
    return if (fuel <= 0) 0
    else fuel + calFuelForFuelMass(fuel)

}




private fun Int.fuel() :Int = this/3 - 2 //Använder en extention funktion för att beräkna bränslet

private fun Int.fuelForFuelMass(): Int =   //En rekursiv extended function. Mycket smidigare
    if(this < 9)  {
        0
    } else {
        val fuel = this.fuel()
        fuel + fuel.fuelForFuelMass()
    }


fun main(){



    println(readTextFileToIntList(pathFile).sumOf { it.fuel() }) //Beräknar bränslet för alla värden i listan på ett mycket smidigare sätt
    println(readTextFileToIntList(pathFile).sumOf { it.fuelForFuelMass() }) //Beräknar även bränsle för bränslets massa.



    println(calFuelPart1(readTextFileToIntList(pathFile)))
    println(calFuelPart2(readTextFileToIntList(pathFile)))
}