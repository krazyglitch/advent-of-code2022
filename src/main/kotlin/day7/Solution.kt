package day7

import util.Utils
import java.time.Duration
import java.time.LocalDateTime

class Solution {

    enum class FileType {
        FOLDER, FILE
    }

    class File(input: String, val parent: File?) {
        val fileType: FileType
        val fileName: String
        val fileSize: Int
        val children = HashMap<String, File>()

        init {
            if (folderRegex.matches(input)) {
                fileType = FileType.FOLDER

                val match = folderRegex.find(input)
                fileName = match?.groupValues!![1]
                fileSize = 0
            } else {
                fileType = FileType.FILE

                val match = fileRegex.find(input)
                fileName = match?.groupValues!![2]
                fileSize = match.groupValues[1].toInt()
            }
        }

        fun getSize(): Int {
            return when (fileType) {
                FileType.FOLDER -> children.values.sumOf { c -> c.getSize() }
                FileType.FILE -> fileSize
            }
        }

        fun flatten(): List<File> {
            val flatList = ArrayList<File>()
            flatList.add(this)

            children.values.filter { c -> c.fileType == FileType.FOLDER }.forEach { f ->
                flatList.addAll(f.flatten())
            }

            return flatList
        }
    }

    companion object {
        val fileRegex = Regex("^(\\d+) ([\\w.]+)$")
        val folderRegex = Regex("^dir (\\\\|\\w+)$")
    }

    private fun parseCommands(root: File, data: List<String>) {
        var listing = false
        val changeDirRegex = Regex("^\\$ cd (..|\\w+)$")
        var pwd = root
        var level = 0
        var count = 0

        data.forEach { cmd ->
            val isCommand = cmd[0] == '$'
            if (isCommand) listing = false
            count++

            if (listing) {
                val newFile = File(cmd, pwd)
                pwd.children[newFile.fileName] = newFile
            } else if (isCommand) {
                if (changeDirRegex.matches(cmd)) {
                    val match = changeDirRegex.find(cmd)
                    if (match != null) {
                        if (match.groupValues[1] == "..") {
                            pwd = pwd.parent!!
                            level--
                        } else {
                            pwd = pwd.children[match.groupValues[1]]!!
                            level++
                        }
                    }
                } else {
                    listing = true
                }
            }
        }
    }

    fun part1(data: List<String>): Int {
        val root = File("dir \\", null)
        parseCommands(root, data.subList(1, data.size))

        return root.flatten().map { f -> f.getSize() }.filter { fs -> fs <= 100000 }.sum()
    }

    fun part2(data: List<String>): Int {
        val root = File("dir \\", null)
        parseCommands(root, data.subList(1, data.size))
        val fullSize = 70000000
        val requiredSize = 30000000
        val unusedSize = fullSize - root.getSize()
        val missingSize = requiredSize - unusedSize

        return root.flatten().map { f -> f.getSize() }.sorted().first { fs -> fs >= missingSize }
    }
}

fun main() {
    val runner = Solution()
    val input = Utils.readLines(runner, "input.txt", runner.javaClass.packageName)

    println("Solving first part of day 7")
    var start = LocalDateTime.now()
    println("The sum directories below 100k is: ${input?.let { runner.part1(it) }}")
    var end = LocalDateTime.now()
    println("Solved first part of day 7")
    var milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve first part of day 7")

    println()

    println("Solving second part of day 7")
    start = LocalDateTime.now()
    println("The smallest directory that can be deleted is: ${input?.let { runner.part2(it) }}")
    end = LocalDateTime.now()
    println("Solved second part of day 7")
    milliseconds = Duration.between(start, end).toMillis()
    println("Took $milliseconds ms to solve second part of day 7")
}