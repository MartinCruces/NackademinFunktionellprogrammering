package AdventOfCode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class _2019Day1TheTyrannyOfRocketEquationKtTest {

    @Test
    fun calFuelPart1Test() {
        val testList1 = listOf(14)
        val testList2 = listOf(100756)
        val testList3 = listOf(14, 100756)

        assertTrue(calFuelPart1(testList1)==2)
        assertTrue(calFuelPart1(testList2)== 33583)
        assertFalse(calFuelPart1(testList1) == 1)
        assertTrue(calFuelPart1(testList3) == 33585)

    }
    @Test
    fun calFuelForFuelMass() {
        val testInt1 = 14
        val testInt2 = 1969
        val testInt3 = 100756

        assertTrue(calFuelForFuelMass(testInt1) == 2)
        assertTrue(calFuelForFuelMass(testInt2) == 966)
        assertTrue(calFuelForFuelMass(testInt3) == 50346)
        assertFalse(calFuelForFuelMass(testInt3) == 50348)

    }

    @Test
    fun calFuelPart2Test() {
        val testList1 = listOf(14)
        val testList2 = listOf(100756)
        val testList3 = listOf(14, 100756)

        assertTrue(calFuelPart2(testList1) == 2)
        assertTrue(calFuelPart2(testList2) == 50346)
        assertTrue(calFuelPart2(testList3) == 50348)
        assertFalse(calFuelPart2(testList3) == 50346)

    }

}