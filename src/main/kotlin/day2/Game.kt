package day2

class Game() {

    enum class Resolution(val score: Int) {
        WIN(6), DRAW(3), LOSS(0)
    }

    enum class MoveType(val score: Int) {
        ROCK(1), PAPER(2), SCISSORS(3)
    }

    private val rock: Move = Move(MoveType.ROCK)
    private val paper: Move = Move(MoveType.PAPER)
    private val scissors: Move = Move(MoveType.SCISSORS)

    // To make usage easier, this list is seen from the opponent's point of view
    // When we use move.getResolution(other), move is the opponent and other is us
    init {
        rock.addResult(rock, Resolution.DRAW)
        rock.addResult(paper, Resolution.WIN)
        rock.addResult(scissors, Resolution.LOSS)

        paper.addResult(rock, Resolution.LOSS)
        paper.addResult(paper, Resolution.DRAW)
        paper.addResult(scissors, Resolution.WIN)

        scissors.addResult(rock, Resolution.WIN)
        scissors.addResult(paper, Resolution.LOSS)
        scissors.addResult(scissors, Resolution.DRAW)
    }

    fun getMoveFromChar(char: Char): Move? {
        return when (char) {
            'A', 'X' -> rock
            'B', 'Y' -> paper
            'C', 'Z' -> scissors
            else -> { null }
        }
    }

    fun getResolutionFromChar(char: Char): Resolution? {
        return when(char) {
            'X' -> Resolution.LOSS
            'Y' -> Resolution.DRAW
            'Z' -> Resolution.WIN
            else -> { null }
        }
    }

    class Move(var type: MoveType) {
        private var results = ArrayList<Pair<Move, Resolution>>()

        fun addResult(ourMove: Move, resolution: Resolution) {
            results += Pair(ourMove, resolution)
        }

        fun getResolution(ourMove: Move): Resolution? {
            return results.find { pair -> pair.first == ourMove }?.second
        }

        fun getMove(resolution: Resolution): Move? {
            return results.find { pair -> pair.second == resolution }?.first
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Move

            if (type != other.type) return false

            return true
        }

        override fun hashCode(): Int {
            return type.hashCode()
        }

        override fun toString(): String {
            return "${type.name}: ${type.score} points"
        }
    }
}