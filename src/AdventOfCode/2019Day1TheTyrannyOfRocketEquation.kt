package AdventOfCode

fun calFuelPart2(list: List<Int>) : Int {
    var fuel = 0
    for (weight in list){
        fuel += calFuelforFuelMass(weight)
    }
    return fuel
}

fun calFuelforFuelMass(weight: Int): Int {
    var fuel = weight/3 -2
    return if (fuel <= 0) 0
    else fuel + calFuelforFuelMass(fuel)

}fun calFuelPart1(list :List<Int>) : Int {
    var fuel = 0

    for (row in list){
        fuel += row / 3 - 2
    }
    return fuel
}

fun main(){
    val pathFile = "src/AdventOfCode/massList.txt"
    println(calFuelPart1(readTextFileToIntList(pathFile)))
    println(calFuelPart2(readTextFileToIntList(pathFile)))
}