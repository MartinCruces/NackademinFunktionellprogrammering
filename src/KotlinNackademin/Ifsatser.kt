package KotlinNackademin

import java.security.Timestamp
import java.sql.Time
import java.time.LocalTime

fun lengthLeft(totalTime : Int, usedTime : Int) = totalTime - usedTime

fun lengthOfShow(startHour : Int, startMin :Int, stopHour : Int, stopMin : Int) = 60*(stopHour-startHour) + stopMin-startMin

fun doesShowFit(lengthLeft : Int, lengthOfShow : Int) = lengthLeft - lengthOfShow >= 0

fun timeLeft(tapeLengthMinutes : Int, usedLength : Int, startHour: Int, startMin: Int, stopHour: Int, stopMin: Int) =
    doesShowFit(
        lengthLeft(tapeLengthMinutes, usedLength), lengthOfShow(startHour, startMin, stopHour, stopMin))



fun main (){

    println(timeLeft(120, 60,19,0,19,45))
    println(timeLeft(120,90,19,45,21,0))







}