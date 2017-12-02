package pub.edholm.aoc2017.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChecksumTest {

  @Test
  fun calculate() {
    val input = listOf(listOf(5, 1, 9, 5), listOf(7, 5, 3), listOf(2, 4, 6, 8))

    val checksum = Checksum()
    assertThat(checksum.calculate(input)).isEqualTo(18)

  }
}