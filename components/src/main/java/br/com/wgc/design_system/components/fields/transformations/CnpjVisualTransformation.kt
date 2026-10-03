@file:Suppress("MagicNumber")

package br.com.wgc.design_system.components.fields.transformations

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

private const val CNPJ_MAX_DIGITS = 14
private const val CNPJ_FIRST_DOT_ORIGINAL = 2
private const val CNPJ_SECOND_DOT_ORIGINAL = 5
private const val CNPJ_SLASH_ORIGINAL = 8
private const val CNPJ_DASH_ORIGINAL = 12

private const val CNPJ_FIRST_DOT_TRANSFORMED = 2
private const val CNPJ_SECOND_DOT_TRANSFORMED = 6
private const val CNPJ_SLASH_TRANSFORMED = 10
private const val CNPJ_DASH_TRANSFORMED = 15

/**
 * [VisualTransformation] do Jetpack Compose que mascara dinamicamente um campo de texto no padrão CNPJ (`00.000.000/0000-00`).
 *
 * Mapeia bidirecionalmente a posição do cursor ([OffsetMapping]) para manter a navegação natural
 * sem alterar os dígitos brutos armazenados no estado.
 */
class CnpjVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed =
            if (text.text.length > CNPJ_MAX_DIGITS) {
                text.text.substring(0, CNPJ_MAX_DIGITS)
            } else {
                text.text
            }

        val out = StringBuilder()
        for (i in trimmed.indices) {
            out.append(trimmed[i])
            when (i) {
                1 -> out.append('.')
                4 -> out.append('.')
                7 -> out.append('/')
                11 -> out.append('-')
            }
        }

        val offsetMapping =
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    val clampedOffset = offset.coerceAtMost(trimmed.length)
                    return when {
                        clampedOffset <= CNPJ_FIRST_DOT_ORIGINAL -> clampedOffset
                        clampedOffset <= CNPJ_SECOND_DOT_ORIGINAL -> clampedOffset + 1
                        clampedOffset <= CNPJ_SLASH_ORIGINAL -> clampedOffset + 2
                        clampedOffset <= CNPJ_DASH_ORIGINAL -> clampedOffset + 3
                        else -> (clampedOffset + 4).coerceAtMost(out.length)
                    }
                }

                override fun transformedToOriginal(offset: Int): Int {
                    val clampedOffset = offset.coerceAtMost(out.length)
                    val originalOffset =
                        when {
                            clampedOffset <= CNPJ_FIRST_DOT_TRANSFORMED -> clampedOffset
                            clampedOffset <= CNPJ_SECOND_DOT_TRANSFORMED -> clampedOffset - 1
                            clampedOffset <= CNPJ_SLASH_TRANSFORMED -> clampedOffset - 2
                            clampedOffset <= CNPJ_DASH_TRANSFORMED -> clampedOffset - 3
                            else -> clampedOffset - 4
                        }
                    return originalOffset.coerceIn(0, trimmed.length)
                }
            }

        return TransformedText(AnnotatedString(out.toString()), offsetMapping)
    }
}
