@file:Suppress("MagicNumber")

package br.com.wgc.design_system.mock

import java.util.Random

/**
 * Fábrica corporativa de massa de dados brasileiros válidos para Previews do Jetpack Compose,
 * Fakes de ViewModel e testes de Screenshot do Design System WGC.
 */
object WgcBrazilFixtureDataFactory {
    private val random = Random()

    /**
     * Gera um CPF matematicamente válido com cálculo real de dígitos verificadores (módulo 11).
     */
    fun generateCpf(formatted: Boolean = true): String {
        val n = IntArray(9) { random.nextInt(10) }

        var sum1 = 0
        for (i in 0 until 9) {
            sum1 += n[i] * (10 - i)
        }
        val remainder1 = sum1 % 11
        val d1 = if (remainder1 < 2) 0 else 11 - remainder1

        var sum2 = 0
        for (i in 0 until 9) {
            sum2 += n[i] * (11 - i)
        }
        sum2 += d1 * 2
        val remainder2 = sum2 % 11
        val d2 = if (remainder2 < 2) 0 else 11 - remainder2

        val raw = "${n.joinToString("")}$d1$d2"
        return if (formatted) {
            "${raw.substring(0, 3)}.${raw.substring(3, 6)}.${raw.substring(6, 9)}-${raw.substring(9, 11)}"
        } else {
            raw
        }
    }

    /**
     * Gera um CNPJ matematicamente válido com dígitos verificadores ponderados.
     */
    fun generateCnpj(formatted: Boolean = true): String {
        val n = IntArray(12)
        for (i in 0 until 8) n[i] = random.nextInt(10)
        n[8] = 0
        n[9] = 0
        n[10] = 0
        n[11] = 1 // Matriz padrão 0001

        val weights1 = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        var sum1 = 0
        for (i in 0 until 12) sum1 += n[i] * weights1[i]
        val rem1 = sum1 % 11
        val d1 = if (rem1 < 2) 0 else 11 - rem1

        val weights2 = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        var sum2 = 0
        for (i in 0 until 12) sum2 += n[i] * weights2[i]
        sum2 += d1 * weights2[12]
        val rem2 = sum2 % 11
        val d2 = if (rem2 < 2) 0 else 11 - rem2

        val raw = "${n.joinToString("")}$d1$d2"
        return if (formatted) {
            "${raw.substring(0, 2)}.${raw.substring(2, 5)}.${raw.substring(5, 8)}/" +
                "${raw.substring(8, 12)}-${raw.substring(12, 14)}"
        } else {
            raw
        }
    }

    /**
     * Gera um CEP brasileiro de 8 dígitos.
     */
    fun generateCep(formatted: Boolean = true): String {
        val num = 10000000 + random.nextInt(89999999)
        val raw = num.toString()
        return if (formatted) {
            "${raw.substring(0, 5)}-${raw.substring(5, 8)}"
        } else {
            raw
        }
    }

    /**
     * Gera um número telefônico brasileiro válido (móvel com 11 dígitos ou fixo com 10 dígitos).
     */
    fun generatePhone(isMobile: Boolean = true, formatted: Boolean = true): String {
        val ddd = 11 + random.nextInt(80)
        return if (isMobile) {
            val suffix = 10000000 + random.nextInt(89999999)
            val raw = "$ddd" + "9" + "$suffix"
            if (formatted) "($ddd) 9${raw.substring(3, 7)}-${raw.substring(7, 11)}" else raw
        } else {
            val prefix = 2 + random.nextInt(4)
            val suffix = 1000000 + random.nextInt(8999999)
            val raw = "$ddd$prefix$suffix"
            if (formatted) "($ddd) $prefix${raw.substring(3, 6)}-${raw.substring(6, 10)}" else raw
        }
    }
}
