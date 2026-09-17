package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.employmentrecord.*

enum class WgcEmploymentRecordScreen {
    CONTRACTS,
    SALARY,
    BENEFITS,
    DECLARATIONS,
    PROFILE
}

@Composable
fun WgcEmploymentRecordFactory(
    screen: WgcEmploymentRecordScreen = WgcEmploymentRecordScreen.CONTRACTS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcEmploymentRecordScreen.CONTRACTS -> WgcCtpsContractsTemplate(modifier = modifier)
        WgcEmploymentRecordScreen.SALARY -> WgcCtpsSalaryTemplate(modifier = modifier)
        WgcEmploymentRecordScreen.BENEFITS -> WgcCtpsBenefitsTemplate(modifier = modifier)
        WgcEmploymentRecordScreen.DECLARATIONS -> WgcCtpsDeclarationsTemplate(modifier = modifier)
        WgcEmploymentRecordScreen.PROFILE -> WgcCtpsProfileTemplate(modifier = modifier)
    }
}
