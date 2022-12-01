package day1

import util.Utils
import java.time.Duration
import java.time.LocalDateTime

class Solution {
    fun part1(input: List<String>): Int {
        val elves = parseElves(input)
        return elves.maxOf { e -> e.calorieCount }
    }

    fun part2(input: List<String>): Int {
        var elves = parseElves(input)
        elves = elves.sortedBy { e -> e.calorieCount }

        return elves.subList(elves.size - 3, elves.size).sumOf { e -> e.calorieCount }
    }

    private fun parseElves(input: List<String>): List<Elf> {
        var addElf = false
        val elves = ArrayList<Elf>()
        var elf = Elf()
        elves.add(elf)

        for (line in input) {
            val parsedInt = line.toIntOrNull()
            if (parsedInt == null) {
                addElf = true
            } else {
                elves[elves.size - 1].calorieCount += parsedInt
            }

            if (addElf) {
                addElf = false
                elf = Elf()
                elves.add(elf)
            }
        }

        return elves
    }

    class Elf {
        var calorieCount: Int = 0

        override fun toString(): String {
            return "Elf calories: $calorieCount"
        }
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 1")
    var start = LocalDateTime.now()
    println("Elf carrying the most calories has: ${input?.let { runner.part1(it) }} calories")
    var end = LocalDateTime.now()
    println("Solved first part of day 1")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 1")

    println()

    println("Solving second part of day 1")
    start = LocalDateTime.now()
    println("The three elves carrying the most calories have ${input?.let { runner.part2(it) }} calories")
    end = LocalDateTime.now()
    println("Solved second part of day 1")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 1")
}