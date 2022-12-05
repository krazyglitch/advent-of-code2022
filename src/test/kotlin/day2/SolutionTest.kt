package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class SolutionTest {
    private val testSolution = Solution()

    @Test
    fun testPart1() {
        val input = """
            |A Y
            |B X
            |C Z
        """.trimMargin().split("\n")

        val result = testSolution.part1(input)
        assertEquals(15, result)
    }

    @Test
    fun testPart2() {
        val input = """
            |A Y
            |B X
            |C Z
        """.trimMargin().split("\n")

        val result = testSolution.part2(input)
        assertEquals(12, result)
    }
}