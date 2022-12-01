package util

class Utils {
    companion object {
        fun readLines(callingClass: Any, fileName: String, packageName: String): List<String>? {
            return callingClass::class.java.classLoader.getResource("$packageName/$fileName")?.readText()?.split("\n")
        }

    }
}