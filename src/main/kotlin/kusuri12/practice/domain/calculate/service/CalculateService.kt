package kusuri12.practice.domain.calculate.service

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalculateService {

    fun sum(a: String, b: String): String {
        return "$a + $b = ${BigDecimal(a) + BigDecimal(b)}"
    }

    fun sub(a: String, b: String): String {
        return "$a - $b = ${BigDecimal(a) - BigDecimal(b)}"
    }

    fun mul(a: String, b: String): String {
        return "$a × $b = ${BigDecimal(a) * BigDecimal(b)}"
    }

    fun div(a: String, b: String): String {
        return if (b == "0") "0으로 나눌 수 없습니다."
        else "$a ÷ $b = ${(BigDecimal(a).divide(BigDecimal(b), 8, RoundingMode.HALF_UP)).stripTrailingZeros()}"
    }
}