package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.ctps.*

enum class WgcCtpsScreen {
    CONTRACTS,
    SALARY,
    BENEFITS,
    DECLARATIONS,
    PROFILE
}

@Composable
fun WgcCtpsFactory(
    screen: WgcCtpsScreen = WgcCtpsScreen.CONTRACTS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCtpsScreen.CONTRACTS -> WgcCtpsContractsTemplate(modifier = modifier)
        WgcCtpsScreen.SALARY -> WgcCtpsSalaryTemplate(modifier = modifier)
        WgcCtpsScreen.BENEFITS -> WgcCtpsBenefitsTemplate(modifier = modifier)
        WgcCtpsScreen.DECLARATIONS -> WgcCtpsDeclarationsTemplate(modifier = modifier)
        WgcCtpsScreen.PROFILE -> WgcCtpsProfileTemplate(modifier = modifier)
    }
}
