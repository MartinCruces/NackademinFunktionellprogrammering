package AdventOfCode
import java.io.File

private fun readTextFileToIntList(fileName: String): List<Int>
        = File(fileName).readLines().map { it.toInt() }


//Hitta två tal i listan av tal vars summa blir 2020. Nästlad loop som jämför talen och vi träff multiplicera de två talen och returnera svaret.
fun find2SumNumbersTo2020AndMultiplyThem(list: List<Int>): Int {
    for (number1 in list) {
        for (number2 in list) {
            if (number1 + number2 == 2020) {
                return number1*number2
            }
        }
    }
    return -1
}
//I stort sett som ovan men nu ska det vara tre tal så ökar på med ytterligare en nestlad loop för att få fram det tredje talet.
fun find3SumNumbersTo2020AndMultiplyThem(list: List<Int>): Int {
    for (number1 in list) {
        for (number2 in list) {
            for(number3 in list){
                if (number1 + number2 + number3 == 2020) {
                    return number1*number2*number3
                }
            }
        }
    }
    return -1
}


fun main(){
    val pathWay = "src/AdventOfCode/expenceReport.txt"
    val reportNumbers = readTextFileToIntList(pathWay)

    //Från Jetbrains blog, mappar tal som i relation till talen i listan ger summan 2020
    val numbersTo2020 = reportNumbers.associateBy { 2020 -it }
    //Dessa kan sedan jämföras mot talen originallistan och hittar första numret med matchande relation
    val checkMatch = reportNumbers.mapNotNull { reportNumbers -> val numbersTo2020 = numbersTo2020[reportNumbers]
        if(numbersTo2020 !=null ) Pair(reportNumbers, numbersTo2020) else null}.firstOrNull()

    //Extended funktion av metoden ovan för att användas i andra delen för att hitta tre delar av summan 2020
    fun List<Int>.find2NumbersOfSum2020(sum : Int): Pair<Int, Int>?{
        val matchingNumber = associateBy { sum - it }
        return firstNotNullOfOrNull { number -> val matchingNumber = matchingNumber[number]
            if (matchingNumber != null) Pair(number, matchingNumber) else null }
    }
    //Extended funktion att hitta tre tal som ger 2020, anropar ovan för att jämföra listan med paren och hitta tripllar. Returnerar tre Int
    fun List<Int>.find3NumbersOfSum2020() : Triple<Int, Int, Int>? = firstNotNullOfOrNull { x  -> find2NumbersOfSum2020(2020 - x)?.let { pair -> Triple(x, pair.first, pair.second) }  }

    val tripleMatch = reportNumbers.find3NumbersOfSum2020()

    //Tar ut de matchade numren och multiplicerar dem med varandra
    println(checkMatch?.let {(x, y) -> x*y })
    println(tripleMatch?.let { (x, y, z) -> x*y*z })





    println(find2SumNumbersTo2020AndMultiplyThem(reportNumbers))
    println(find3SumNumbersTo2020AndMultiplyThem(reportNumbers))

}