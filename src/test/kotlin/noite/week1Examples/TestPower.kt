package noite.week1Examples

import org.junit.jupiter.api.Test
import week1Examples.powerOf
import week1Examples.powerOfIterative
import kotlin.test.assertEquals

class TestPower {
    val power:(Int, Int)-> Int = ::powerOfIterative
    @Test
    fun testExponent0() {
        assertEquals(1, power( 2, 0))
    }
    @Test
    fun testEven() {
        assertEquals(16, power(2, 4))
    }
    @Test
    fun testOdd() {
        assertEquals(32, power( 2, 5))
     }
    @Test
    fun test() {
        for( i in 1 .. 1000000)
           power( 3, 50000)
    }

}