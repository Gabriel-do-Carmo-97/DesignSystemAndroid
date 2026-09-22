package br.com.wgc.design_system.components.fields.transformations

import androidx.compose.ui.text.input.VisualTransformation

/**
 * Factory de [VisualTransformation] oficial do Design System WGC.
 *
 * Fornece instâncias reutilizáveis de máscaras de entrada comuns para o mercado brasileiro
 * e padrões internacionais.
 */
object WgcVisualTransformations {

    /**
     * Máscara dinâmica de CPF (`000.000.000-00`) com mapeamento bidirecional de cursor.
     */
    fun cpf(): VisualTransformation = CpfVisualTransformation()

    /**
     * Máscara dinâmica de CEP (`00000-000`) com mapeamento bidirecional de cursor.
     */
    fun cep(): VisualTransformation = CepVisualTransformation()

    /**
     * Máscara adaptativa de Telefone brasileiro: celular `(XX) XXXXX-XXXX` ou fixo `(XX) XXXX-XXXX`.
     */
    fun phone(): VisualTransformation = PhoneVisualTransformation()
}
