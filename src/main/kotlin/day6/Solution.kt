package day6

import util.Utils
import java.time.Duration
import java.time.LocalDateTime

class Solution {

    private fun findMarker(buffer: String, counter: Int): Int {
        val hashSet = buffer.substring(0, 4).toHashSet()

        if (hashSet.size == 4) return counter+4

        return findMarker(buffer.substring(1), counter+1)
    }

    private fun findMessage(buffer: String, counter: Int): Int {
        val hashSet = buffer.substring(0, 14).toHashSet()

        if (hashSet.size == 14) return counter+14

        return findMessage(buffer.substring(1), counter+1)
    }

    fun part1(data: String): Int {
        return findMarker(data, 0)
    }

    fun part2(data: String): Int {
        return findMessage(data, 0)
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readFile(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 6")
    var start = LocalDateTime.now()
    println("The first marker is found after position: ${input?.let { runner.part1(it) }}")
    var end = LocalDateTime.now()
    println("Solved first part of day 6")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 6")

    println()

    println("Solving second part of day 6")
    start = LocalDateTime.now()
    println("The first message is found after position: ${input?.let { runner.part2(it) }}")
    end = LocalDateTime.now()
    println("Solved second part of day 6")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 6")
}