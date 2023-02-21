package AdventOfCode

import java.io.File

fun readTextFileToList(fileName: String): List<String>
        = File(fileName).bufferedReader().readLines()

fun part1HowManyCorrectPasswords(passwordList :List<String>) : Int{
    var counter = 0
    for (line in passwordList){
        var part = line.split(" ")
        var minMax = part[0].split('-')
        var min = minMax[0].toInt()
        var max = minMax[1].toInt()
        var pointerChar = part[1].first()
        var password = part[2]
        var charCheck = 0
        for (char in password){
            if (pointerChar == char) {
                charCheck++
            }
        }
        if (charCheck in min..max)counter++
    }
    return counter
}
/*Given the same example list from above:

1-3 a: abcde is valid: position 1 contains a and position 3 does not.
1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.*/

fun part2HowManyCorrectPasswords(passwordList :List<String>) : Int{
    var counter = 0
    for (line in passwordList){
        var part = line.split(" ")
        var minMax = part[0].split('-')
        var min = minMax[0].toInt()
        var max = minMax[1].toInt()
        var pointerChar = part[1].first()
        var password = part[2]
        var charCheck = 0

        if (password[min-1] == pointerChar && password[max-1] != pointerChar) counter++
        else if (password[max-1] == pointerChar && password[min-1] != pointerChar) counter++

    }
    return counter
}

fun main(){
    val filePath = "src/Kotlin_inlämingsuppgifter/passwordList.txt"

    val passwordList = readTextFileToList(filePath)

    println(part1HowManyCorrectPasswords(passwordList))
    println(part2HowManyCorrectPasswords(passwordList))

}