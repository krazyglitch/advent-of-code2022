package day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class SolutionTest {
    private val testSolution = Solution()

    @Test
    fun testPart1() {
        val input = """
            |${'$'} cd /
            |${'$'} ls
            |dir a
            |14848514 b.txt
            |8504156 c.dat
            |dir d
            |${'$'} cd a
            |${'$'} ls
            |dir e
            |29116 f
            |2557 g
            |62596 h.lst
            |${'$'} cd e
            |${'$'} ls
            |584 i
            |${'$'} cd ..
            |${'$'} cd ..
            |${'$'} cd d
            |${'$'} ls
            |4060174 j
            |8033020 d.log
            |5626152 d.ext
            |7214296 k
        """.trimMargin().lines()

        val result = testSolution.part1(input)
        assertEquals(95437, result)
    }

    @Test
    fun testPart2() {
        val input = """
            |${'$'} cd /
            |${'$'} ls
            |dir a
            |14848514 b.txt
            |8504156 c.dat
            |dir d
            |${'$'} cd a
            |${'$'} ls
            |dir e
            |29116 f
            |2557 g
            |62596 h.lst
            |${'$'} cd e
            |${'$'} ls
            |584 i
            |${'$'} cd ..
            |${'$'} cd ..
            |${'$'} cd d
            |${'$'} ls
            |4060174 j
            |8033020 d.log
            |5626152 d.ext
            |7214296 k
        """.trimMargin().lines()

        val result = testSolution.part2(input)
        assertEquals(24933642, result)
    }
}