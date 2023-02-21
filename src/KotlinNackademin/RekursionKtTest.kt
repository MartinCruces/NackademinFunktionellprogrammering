package KotlinNackademin

import org.junit.jupiter.api.Assertions.*

internal class RekursionKtTest {

    @org.junit.jupiter.api.Test
    fun getInterestOnInterest() {
        //1000 kr 10 % 10 år
        assert(KotlinNackademin.getInterestOnInterest(10.0,1000.0, 1).equals(1100.0))
        assert(!KotlinNackademin.getInterestOnInterest(10.0,1000.0, 1).equals(1000.0))
    }
}