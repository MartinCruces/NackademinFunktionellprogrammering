package AdventOfCode
import java.io.File

private fun readTextFileToIntList(fileName: String): List<Int>
        = File(fileName).readLines().map { it.toInt() }

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
    println(find2SumNumbersTo2020AndMultiplyThem(reportNumbers))
    println(find3SumNumbersTo2020AndMultiplyThem(reportNumbers))

}