@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.support.BaseHelpCenterViewModel
import br.com.wgc.design_system.templates.screens.support.FakeHelpCenterViewModel
import br.com.wgc.design_system.templates.screens.support.WgcHelpCenterSupportTemplate

/**
 * Variantes da Central de Ajuda suportadas pela [WgcHelpCenterFactory].
 */
enum class WgcHelpCenterType {
    STANDARD
}

/**
 * Fábrica Universal de Telas de Central de Ajuda e Suporte (WgcHelpCenterFactory).
 */
@Composable
fun WgcHelpCenterFactory(
    modifier: Modifier = Modifier,
    type: WgcHelpCenterType = WgcHelpCenterType.STANDARD,
    viewModel: BaseHelpCenterViewModel = FakeHelpCenterViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    contactActionSlot: (@Composable () -> Unit)? = null
) {
    when (type) {
        WgcHelpCenterType.STANDARD -> {
            WgcHelpCenterSupportTemplate(
                modifier = modifier,
                viewModel = viewModel,
                headerSlot = headerSlot,
                contactActionSlot = contactActionSlot
            )
        }
    }
}
