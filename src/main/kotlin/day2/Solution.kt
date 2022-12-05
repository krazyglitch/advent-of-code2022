package day2

import util.Utils
import java.lang.IllegalArgumentException
import java.time.Duration
import java.time.LocalDateTime

class Solution {

    /** A = rock, B = paper, C = scissors
     *
     *  First task:
     *      Assume second parameter maps to rock, paper, scissors.
     *      X = rock, Y = paper, Z = scissors
     *      Calculate score with following table:
     *
     *      Win: 6 points
     *      Draw: 3 points
     *      Loss: 0 points
     *
     *      Rock: 1 point
     *      Paper: 2 points
     *      Scissors: 3 points
     *
     *  Second task:
     *      The second parameter maps to LOSS, DRAW, WIN.
     *      X = loss, Y = draw, Z = win
     *      Use the same logic for scoring
     */

    private fun parseInput(input: String): Pair<Char, Char> {
        if (input.length == 3) return Pair(input[0], input[2])

        throw IllegalArgumentException("$input is not a valid format for a round")
    }

    fun part1(data: List<String>): Int {
        val game = Game()
        val commands = data.map { parseInput(it) }
        var sum = 0

        commands.forEach { c ->
            val theirMove = game.getMoveFromChar(c.first)
            val ourMove = game.getMoveFromChar(c.second)

            if (theirMove != null) {
                if (ourMove != null) {
                    val resolution = theirMove.getResolution(ourMove)
                    sum += ourMove.type.score + (resolution?.score ?: 0)
                }
            }
        }

        return sum
    }

    fun part2(data: List<String>): Int {
        val game = Game()
        val commands = data.map { parseInput(it) }
        var sum = 0

        commands.forEach{ c ->
            val theirMove = game.getMoveFromChar(c.first)
            val resolution = game.getResolutionFromChar(c.second)

            if (theirMove != null) {
                if (resolution != null) {
                    val ourMove = theirMove.getMove(resolution)

                    if (ourMove != null) {
                        sum += ourMove.type.score + resolution.score
                    }
                }
            }
        }

        return sum
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 2")
    var start = LocalDateTime.now()
    println("The score would be: ${input?.let { runner.part1(it) }} points")
    var end = LocalDateTime.now()
    println("Solved first part of day 2")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 2")

    println()

    println("Solving second part of day 2")
    start = LocalDateTime.now()
    println("The score would be ${input?.let { runner.part2(it) }} points using the new strategy")
    end = LocalDateTime.now()
    println("Solved second part of day 2")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 2")
}