package day5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolutionTest {
    private val testSolution = Solution()

    @Test
    fun testPart1() {
        val input = """
                |    [D]    
                |[N] [C]    
                |[Z] [M] [P]
                | 1   2   3 
                |
                |move 1 from 2 to 1
                |move 3 from 1 to 3
                |move 2 from 2 to 1
                |move 1 from 1 to 2
        """.trimMargin().lines()

        val result = testSolution.part1(input)
        assertEquals("CMZ", result)
    }

    @Test
    fun testPart2() {
        val input = """
                |    [D]    
                |[N] [C]    
                |[Z] [M] [P]
                | 1   2   3 
                |
                |move 1 from 2 to 1
                |move 3 from 1 to 3
                |move 2 from 2 to 1
                |move 1 from 1 to 2
        """.trimMargin().lines()

        val result = testSolution.part2(input)
        assertEquals("MCD", result)
    }
}