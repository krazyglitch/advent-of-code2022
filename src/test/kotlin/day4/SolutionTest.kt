package day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    private val testSolution = Solution()

    @Test
    fun testPart1() {
        val input = """
            |2-4,6-8
            |2-3,4-5
            |5-7,7-9
            |2-8,3-7
            |6-6,4-6
            |2-6,4-8
        """.trimMargin().split("\n")

        val result = testSolution.part1(input)
        assertEquals(2, result)
    }

    @Test
    fun testPart2() {
        val input = """
            |2-4,6-8
            |2-3,4-5
            |5-7,7-9
            |2-8,3-7
            |6-6,4-6
            |2-6,4-8
        """.trimMargin().split("\n")

        val result = testSolution.part2(input)
        assertEquals(4, result)
    }
}