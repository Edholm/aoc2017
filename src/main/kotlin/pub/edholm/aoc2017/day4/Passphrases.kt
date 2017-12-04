package pub.edholm.aoc2017.day4

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val formattedInput = formatInput(getInputForDay(4))
  val passphrases = Passphrases()

  println("Day 4:")
  println("  Part I:  ${passphrases.countValid(formattedInput)}")
  println("  Part II: ${passphrases.countValidWithoutAnagrams(formattedInput)}")
}

private fun formatInput(inputForDay: String): List<List<String>> {
  return inputForDay.split("\n")
    .map { it.split(" ") }
}

fun String.isAnagramOf(other: String): Boolean {
  if (this.length != other.length) {
    return false
  }
  return this.toList().sorted() == other.toList().sorted()
}

class Passphrases {
  fun countValid(formattedInput: List<List<String>>): Int {
    return formattedInput.filter { isValid(it) }.size
  }

  fun countValidWithoutAnagrams(allPhrases: List<List<String>>): Int {
    return allPhrases.filter { isValid(it) && !containsAnagrams(it) }.size
  }

  fun containsAnagrams(phrase: List<String>): Boolean {
    phrase.forEachIndexed { index, value ->
      phrase.subList(index + 1, phrase.size).forEach { other ->
        if (value.isAnagramOf(other)) {
          return true
        }
      }
    }
    return false
  }

  fun isValid(phrase: List<String>) = phrase.distinct().size == phrase.size

}