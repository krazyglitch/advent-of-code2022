package day5

import util.Utils
import java.time.Duration
import java.time.LocalDateTime
import kotlin.collections.ArrayList

class Solution {

    private val stacks = ArrayList<ArrayDeque<Char>>()
    private val instructionRegex = Regex("move (\\d+) from (\\d) to (\\d)")

    // Parse the crate diagram and return only instructions
    private fun parseDiagram(data: List<String>): List<String> {
        stacks.clear()
        val emptyLinePos = (data.indices).find { data[it] == "" } ?: 0
        val stackBottomPos = emptyLinePos - 2
        val lastBracketPos = data[stackBottomPos].lastIndexOf(']')
        val stackCount = (lastBracketPos)/4 + 1
        (0 until stackCount).forEach { _ -> stacks.add(ArrayDeque()) }

        (stackBottomPos downTo 0).forEach { y ->
            (1 until lastBracketPos step 4).forEach { x ->
                if (data[y][x] != ' ') stacks[(x+3)/4 - 1].add(data[y][x])
            }
        }

        val instructionsPos = emptyLinePos + 1
        return data.subList(instructionsPos, data.size)
    }

    private fun processSingleInstruction(moves: Int, origin: Int, destination: Int) {
        if (moves == 0) return

        val crate = stacks[origin-1].removeLast()
        stacks[destination-1].add(crate)

        processSingleInstruction(moves-1, origin, destination)
    }

    private fun processMultipleInstructions(crates: Int, origin: Int, destination: Int) {
        val movingCrates = ArrayDeque<Char>()
        repeat(crates) { movingCrates.add(stacks[origin - 1].removeLast()) }

        while (movingCrates.isNotEmpty()) stacks[destination-1].add(movingCrates.removeLast())
    }

    fun part1(data: List<String>): String {
        val instructions = parseDiagram(data)
        (instructions).forEach {
            val match = instructionRegex.find(it)
            val (movesStr, originStr, destinationStr) = match!!.destructured

            val moves = movesStr.toInt()
            val origin = originStr.toInt()
            val destination = destinationStr.toInt()

            processSingleInstruction(moves, origin, destination)
        }

        return stacks.joinToString("", "", "", -1, "") { s -> s.last().toString() }
    }

    fun part2(data: List<String>): String {
        val instructions = parseDiagram(data)
        (instructions).forEach {
            val match = instructionRegex.find(it)
            val (cratesStr, originStr, destinationStr) = match!!.destructured

            val crates = cratesStr.toInt()
            val origin = originStr.toInt()
            val destination = destinationStr.toInt()

            processMultipleInstructions(crates, origin, destination)
        }

        return stacks.joinToString("", "", "", -1, "") { s -> s.last().toString() }
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 5")
    var start = LocalDateTime.now()
    println("The top crates are: ${input?.let { runner.part1(it) }}")
    var end = LocalDateTime.now()
    println("Solved first part of day 5")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 5")

    println()

    println("Solving second part of day 5")
    start = LocalDateTime.now()
    println("The top crates are: ${input?.let { runner.part2(it) }}")
    end = LocalDateTime.now()
    println("Solved second part of day 5")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 5")
}