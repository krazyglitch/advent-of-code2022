package util

class Utils {
    companion object {
        fun readLines(callingClass: Any, fileName: String, packageName: String): List<String>? {
            return callingClass::class.java.classLoader.getResource("$packageName/$fileName")?.readText()?.lines()
        }

        fun readFile(callingClass: Any, fileName: String, packageName: String): String? {
            return callingClass::class.java.classLoader.getResource("$packageName/$fileName")?.readText()
        }

    }
}