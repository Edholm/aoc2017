package pub.edholm.aoc2017.day1

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inverseCaptcha = InverseCaptcha()
  val rawInput = getInputForDay(1)
  val formattedInput = rawInput.formatToInts()

  val solveCaptchaPartOne = inverseCaptcha.solveCaptchaPartOne(formattedInput)
  val solveCaptchaPartTwo = inverseCaptcha.solveCaptchaPartTwo(formattedInput)
  println("Day 1:")
  println("  Part I:  " + solveCaptchaPartOne)
  println("  Part II: " + solveCaptchaPartTwo)
}

internal fun String.formatToInts() = this.map(Character::getNumericValue)

internal class InverseCaptcha {
  private fun solveCaptcha(inputs: List<Int>, stepsBetween: Int): Int {
    return inputs
      .zipWith(stepsBetween)
      .filter { it.valuesAreEqual() }
      .map { it.first }
      .sum()
  }

  fun solveCaptchaPartOne(input: List<Int>): Int {
    return solveCaptcha(input, 1)
  }

  fun solveCaptchaPartTwo(input: List<Int>): Int {
    return solveCaptcha(input, input.size / 2)
  }

  private fun <T> List<T>.zipWith(stepsBetween: Int): List<Pair<T, T>> {
    return List(this.size, { index ->
      Pair(this[index % this.size], this[(index + stepsBetween) % this.size])
    })
  }

  private fun <T> Pair<T, T>.valuesAreEqual() = this.first == this.second
}