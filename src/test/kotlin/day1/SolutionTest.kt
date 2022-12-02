package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    private val testSolution: Solution = Solution()

    @Test
    fun testPart1() {
        val input = """
            |1000
            |2000
            |3000
            |
            |4000
            |
            |5000
            |6000
            |
            |7000
            |8000
            |9000
            |
            |10000""".trimMargin().split("\n")

        val result = testSolution.part1(input)
        assertEquals(24000, result)
    }

    @Test
    fun testPart2() {
        val input = """
            |1000
            |2000
            |3000
            |
            |4000
            |
            |5000
            |6000
            |
            |7000
            |8000
            |9000
            |
            |10000""".trimMargin().split("\n")

        val result = testSolution.part2(input)
        assertEquals(45000, result)
    }
}