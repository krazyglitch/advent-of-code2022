package day3

import util.Utils
import java.time.Duration
import java.time.LocalDateTime

class Solution {

    private val offsetLower = 'a'.code
    private val offsetUpper = 'A'.code
    private val priorityMap: Map<Char, Int>

    init {
        priorityMap = HashMap()
        ('a'..'z').forEach { priorityMap.put(it, it.code - offsetLower + 1) }
        ('A'..'Z').forEach { priorityMap.put(it, it.code - offsetUpper + 27) }
    }

    class Rucksack(val input: String) {
        private val first: String
        private val second: String

        init {
            val midPoint = (input.length / 2)
            first = input.substring(0, midPoint)
            second = input.substring(midPoint)
        }

        fun getCommonCharacter(): Char {
            val firstSet = first.toHashSet()
            val secondSet = second.toHashSet()

            firstSet.forEach { c -> if (secondSet.contains(c)) return c }

            return ' '
        }

    }

    class Group(private val rucksacks: Triple<Rucksack, Rucksack, Rucksack>) {

        fun getCommonCharacter(): Char {
            val firstSet = rucksacks.first.input
            val secondSet = rucksacks.second.input
            val thirdSet = rucksacks.third.input

            return firstSet.filter { c -> secondSet.contains(c) }.first { c -> thirdSet.contains(c) }
        }
    }

    fun part1(data: List<String>): Int {
        val rucksacks = data.map { s -> Rucksack(s) }
        return rucksacks.sumOf { r ->
            val commonCharacter = r.getCommonCharacter()

            priorityMap[commonCharacter] ?: 0
        }
    }

    fun part2(data: List<String>): Int {
        val rucksacks = data.map { s -> Rucksack(s) }
        val groups = (0..data.size-2 step 3).map{
            Group(Triple(rucksacks[it], rucksacks[it+1], rucksacks[it+2]))
        }

        return groups.sumOf { g ->
            val commonCharacter = g.getCommonCharacter()

            priorityMap[commonCharacter] ?: 0
        }
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 3")
    var start = LocalDateTime.now()
    println("The priority sum is: ${input?.let { runner.part1(it) }}")
    var end = LocalDateTime.now()
    println("Solved first part of day 3")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 3")

    println()

    println("Solving second part of day 3")
    start = LocalDateTime.now()
    println("The badge priority sum is: ${input?.let { runner.part2(it) }}")
    end = LocalDateTime.now()
    println("Solved second part of day 3")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 3")
}