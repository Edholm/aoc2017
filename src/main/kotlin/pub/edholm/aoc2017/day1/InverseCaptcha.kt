package pub.edholm.aoc2017.day1

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inverseCaptcha = InverseCaptcha()
  val day1Input = getInputForDay(1)
  println("Part I:  " + inverseCaptcha.solveCaptchaPartOne(day1Input))
  println("Part II: " + inverseCaptcha.solveCaptchaPartTwo(day1Input))
}

internal class InverseCaptcha {
  private fun solveCaptcha(inputs: List<Long>, stepsBetween: Int): Long {
    return inputs
      .zipWith(stepsBetween)
      .filter { it.valuesAreEqual() }
      .map { it.first }
      .sum()
  }

  fun solveCaptchaPartOne(input: String): Long {
    val inputs = input.convertToListOfLongs()
    return solveCaptcha(inputs, 1)
  }

  fun solveCaptchaPartTwo(input: String): Long {
    val inputs = input.convertToListOfLongs()
    return solveCaptcha(inputs, inputs.size / 2)
  }

  private fun <T> List<T>.zipWith(stepsBetween: Int): List<Pair<T, T>> {
    val subList = this.subList(0, stepsBetween)
    val workingList = this.toMutableList()
    workingList.addAll(subList)

    val result = mutableListOf<Pair<T, T>>()
    var i = 0
    while (i < this.size) {
      result.add(Pair(workingList[i], workingList[i + stepsBetween]))
      i++
    }

    return result
  }

  private fun <T> List<T>.firstAndLastAreEqual() = this.first() == this.last()
  private fun <T> Pair<T, T>.valuesAreEqual() = this.first == this.second
  private fun String.convertToListOfLongs() = this.trim().map { it.toString().toLong() }
}