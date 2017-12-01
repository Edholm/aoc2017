package pub.edholm.aoc2017.day1

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inverseCaptcha = InverseCaptcha()
  println("Sum: " + inverseCaptcha.solveCaptcha(getInputForDay(1)))
}

class InverseCaptcha {
  fun solveCaptcha(input: String): Long {
    val inputs = input.convertToListOfLongs()
    val initial = if (inputs.firstAndLastAreEqual()) inputs.first() else 0L

    return inputs
      .zipWithNext()
      .filter { it.valuesAreEqual() }
      .map { it.first }
      .sum()
      .plus(initial)
  }

  fun solveCaptchaPartTwo(input: String): Long {
    return 0
  }

  private fun <T> List<T>.firstAndLastAreEqual() = this.first() == this.last()
  private fun <T> Pair<T, T>.valuesAreEqual() = this.first == this.second
  private fun String.convertToListOfLongs() = this.trim().map { it.toString().toLong() }
}