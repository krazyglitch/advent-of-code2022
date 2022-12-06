package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    private val testSolution = Solution()


    @Test
    fun testPart1() {
        val input = """
            |vJrwpWtwJgWrhcsFMMfFFhFp
            |jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            |PmmdzqPrVvPwwTWBwg
            |wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            |ttgJtRGJQctTZtZT
            |CrZsJsPPZsGzwwsLwLmpwMDw
        """.trimMargin().split("\n")

        val result = testSolution.part1(input)
        assertEquals(157, result)
    }

    @Test
    fun testPart2() {
        val input = """
            |vJrwpWtwJgWrhcsFMMfFFhFp
            |jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            |PmmdzqPrVvPwwTWBwg
            |wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            |ttgJtRGJQctTZtZT
            |CrZsJsPPZsGzwwsLwLmpwMDw
        """.trimMargin().split("\n")

        val result = testSolution.part2(input)
        assertEquals(70, result)
    }
}