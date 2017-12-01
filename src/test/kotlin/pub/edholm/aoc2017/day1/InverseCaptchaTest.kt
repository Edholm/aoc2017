package pub.edholm.aoc2017.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InverseCaptchaTest {
  @Test
  fun solveCaptcha() {
    val inverseCaptcha = InverseCaptcha()
    assertThat(inverseCaptcha.solveCaptcha("1122")).isEqualTo(3)
    assertThat(inverseCaptcha.solveCaptcha("1111")).isEqualTo(4)
    assertThat(inverseCaptcha.solveCaptcha("1234")).isEqualTo(0)
    assertThat(inverseCaptcha.solveCaptcha("91212129")).isEqualTo(9)
  }

}