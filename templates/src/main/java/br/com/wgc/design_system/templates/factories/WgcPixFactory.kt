package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.payment.WgcPixScreenFactory
import br.com.wgc.design_system.factories.payment.WgcPixScreenVariant

/**
 * Fábrica universal legada para instanciação padronizada do template de Transferência Pix.
 */
@Deprecated(
    message = "Utilize WgcPixScreenFactory diretamente",
    replaceWith = ReplaceWith("WgcPixScreenFactory(modifier, WgcPixScreenVariant.TRANSFER)")
)
object WgcPixFactory {

    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        customQrSlot: (@Composable () -> Unit)? = null,
        onPaymentConfirmed: () -> Unit = {}
    ) {
        WgcPixScreenFactory(
            modifier = modifier,
            variant = WgcPixScreenVariant.TRANSFER,
            customQrSlot = customQrSlot,
            onPaymentConfirmed = onPaymentConfirmed
        )
    }
}
