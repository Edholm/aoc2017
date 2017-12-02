package pub.edholm.aoc2017.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InverseCaptchaTest {
  @Test
  fun solveCaptcha() {
    val inverseCaptcha = InverseCaptcha()
    assertThat(inverseCaptcha.solveCaptchaPartOne("1122")).isEqualTo(3L)
    assertThat(inverseCaptcha.solveCaptchaPartOne("1111")).isEqualTo(4L)
    assertThat(inverseCaptcha.solveCaptchaPartOne("1234")).isEqualTo(0L)
    assertThat(inverseCaptcha.solveCaptchaPartOne("91212129")).isEqualTo(9L)
  }

  @Test
  fun solveCaptchaPartTwo() {
    val inverseCaptcha = InverseCaptcha()
    assertThat(inverseCaptcha.solveCaptchaPartTwo("1212")).isEqualTo(6L)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("1221")).isEqualTo(0L)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("123425")).isEqualTo(4L)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("123123")).isEqualTo(12L)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("12131415")).isEqualTo(4L)
  }

}