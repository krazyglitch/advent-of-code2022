package day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class SolutionTest {
    private val testSolution = Solution()

    @Test
    fun testPart1A() {
        val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        val result = testSolution.part1(input)

        assertEquals(5, result)
    }

    @Test
    fun testPart1B() {
        val input = "nppdvjthqldpwncqszvftbrmjlhg"
        val result = testSolution.part1(input)

        assertEquals(6, result)
    }

    @Test
    fun testPart1C() {
        val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
        val result = testSolution.part1(input)

        assertEquals(10, result)
    }

    @Test
    fun testPart1D() {
        val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
        val result = testSolution.part1(input)

        assertEquals(11, result)
    }

    @Test
    fun testPart2A() {
        val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        val result = testSolution.part2(input)

        assertEquals(19, result)
    }

    @Test
    fun testPart2B() {
        val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        val result = testSolution.part2(input)

        assertEquals(23, result)
    }

    @Test
    fun testPart2C() {
        val input = "nppdvjthqldpwncqszvftbrmjlhg"
        val result = testSolution.part2(input)

        assertEquals(23, result)
    }

    @Test
    fun testPart2D() {
        val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
        val result = testSolution.part2(input)

        assertEquals(29, result)
    }

    @Test
    fun testPart2E() {
        val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
        val result = testSolution.part2(input)

        assertEquals(26, result)
    }
}