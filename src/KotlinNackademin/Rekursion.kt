package KotlinNackademin


fun getInterestOnInterest(interest: Double, amount : Double, numberOfYears : Int ) : Double {
    if (numberOfYears <= 0) return amount

    return getInterestOnInterest(interest, (amount + amount*interest/100), numberOfYears -1)
}

fun sumOfNumbersInList(number : List<Int>) : Int {
    tailrec fun doSum(sum :Int, counter :Int) :Int{
        return if (counter == -1) sum
        else doSum(sum+number[counter],counter -1)
    }
    return doSum(0, number.size -1)

}

fun maxValueInList(number: List<Int>) : Int {
    tailrec fun doMax(maxValue :Int, counter : Int) :Int {
        return if (counter == number.size ) maxValue
        else doMax(if (number[counter]> maxValue)number[counter] else maxValue, counter + 1)
    }
    //var maxValue = Int.MIN_VALUE
    return doMax(0,  0)
}

tailrec fun parenthesesCount( sentence : String, count :Int ) :Int {
    if (sentence.length == 0) return count
    return when (sentence.first()){
        '(' -> parenthesesCount(sentence.takeLast(sentence.count() -1), count + 1)
        ')' -> parenthesesCount(sentence.takeLast(sentence.count() - 1), count - 1)
        else -> parenthesesCount(sentence.takeLast(sentence.count()- 1), count)
    }

}

fun checkParenthesesBalance(sentence: String) :Boolean{
    return if (parenthesesCount(sentence, 0) == 0) true else false
}

tailrec fun fibCounter(prevPrev: Int, prev: Int) {
    val next = prevPrev + prev
    println(next)
    if (next > 10000000) System.exit(0)
    fibCounter(prev, next)
}

tailrec fun fibElementFinder(prevPrev: Int, prev: Int, i : Int) {
    val next = prevPrev + prev
    when  {
        (i == 0) -> println(1)
        (i == 1) -> println(2)
        (i-2 == 0) -> println(next)
    }
    if (i <= 2) System.exit(0)
    fibElementFinder(prev, next, i -1)
}



fun main (){

    val listOfNumbers = listOf(1,2,3,4,5,600,7,8,9,10,33,56,109)

    val stringWithParentheses = "Hej()(()))() på (dig)("

    //listOfNumbers.stream().forEach{numbers -> print(numbers)}

    //println(sumOfNumbersInList(listOfNumbers))

    //println(getInterestOnInterest(2.25, 320000.0, 100))
    //println(maxValueInList(listOfNumbers))

   //println(checkParenthesesBalance(stringWithParentheses))
    println(fibCounter(1,2))

    //println(fibElementFinder(1,1, 10))
}