package pub.edholm.aoc2017.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChecksumTest {

  @Test
  fun calculatePartOne() {
    val input = listOf(listOf(5, 1, 9, 5), listOf(7, 5, 3), listOf(2, 4, 6, 8))

    val checksum = Checksum()
    assertThat(checksum.calculatePartOne(input)).isEqualTo(18)

  }

  @Test
  fun calculatePartTwo() {
    val input = listOf(listOf(5, 9, 2, 8), listOf(9, 4, 7, 3), listOf(3, 8, 6, 5))

    val checksum = Checksum()
    assertThat(checksum.calculatePartTwo(input)).isEqualTo(9)

  }
}