package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.payment.WgcCardScreenFactory

/**
 * Fábrica universal legada para instanciação padronizada do template de Gestão de Cartões.
 */
@Deprecated(
    message = "Utilize WgcCardScreenFactory diretamente",
    replaceWith = ReplaceWith("WgcCardScreenFactory(modifier)")
)
object WgcCardFactory {

    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        customFormSlot: (@Composable () -> Unit)? = null,
        onPaymentSuccess: () -> Unit = {}
    ) {
        WgcCardScreenFactory(
            modifier = modifier,
            customFormSlot = customFormSlot,
            onPaymentSuccess = onPaymentSuccess
        )
    }
}
