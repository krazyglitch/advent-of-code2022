package day4

import util.Utils
import java.lang.IllegalArgumentException
import java.time.Duration
import java.time.LocalDateTime

class Solution {

    class Elf(input: String) {
        private val left: Int
        private val right: Int

        init {
            val splitString = input.split("-")
            if (splitString.size < 2) throw IllegalArgumentException("$input is not a valid assignment")
            left = splitString[0].toInt()
            right = splitString[1].toInt()
        }

        fun contains(other: Elf): Boolean {
            return left <= other.left && right >= other.right
        }

        fun overlaps(other: Elf): Boolean {
            return right - other.left >= 0 && other.right - left >= 0
        }
    }

    fun part1(data: List<String>): Int {
        val containingPairs = data.filter { s -> s.contains(",") }.count { s ->
            val splitString = s.split(",")
            val danny = Elf(splitString[0])
            val evans = Elf(splitString[1])

            danny.contains(evans) || evans.contains(danny)
        }

        return containingPairs
    }

    fun part2(data: List<String>): Int {
        val overlappingPairs = data.filter { s -> s.contains(",") }.count { s->
            val splitString = s.split(",")
            val charlie = Elf(splitString[0])
            val birdie = Elf(splitString[1])

            charlie.overlaps(birdie)
        }

        return overlappingPairs
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 4")
    var start = LocalDateTime.now()
    println("The amount of pairs that overlap fully are: ${input?.let { runner.part1(it) }}")
    var end = LocalDateTime.now()
    println("Solved first part of day 4")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 4")

    println()

    println("Solving second part of day 4")
    start = LocalDateTime.now()
    println("The amount of pairs that overlap is: ${input?.let { runner.part2(it) }}")
    end = LocalDateTime.now()
    println("Solved second part of day 4")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 4")
}