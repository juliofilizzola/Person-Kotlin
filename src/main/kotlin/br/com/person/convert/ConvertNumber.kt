package br.com.person.convert

import org.springframework.stereotype.Component

@Component
object ConvertNumber {

    /**
    @param strNumber: value numeric

    @return Double

    Func convert string in number
     */
    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    /**
    @param strNumber: value numeric

    @return Boolean

    Func valid string is number
     */

    fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}