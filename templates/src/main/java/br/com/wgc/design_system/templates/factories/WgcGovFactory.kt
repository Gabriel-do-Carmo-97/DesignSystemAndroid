package br.com.wgc.design_system.templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcGovDigitalDocumentCard

enum class WgcGovScreen {
    GOV_BR,
    CDT,
    CTPS
}

@Composable
fun WgcGovFactory(
    modifier: Modifier = Modifier,
    screen: WgcGovScreen = WgcGovScreen.GOV_BR
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcGovDigitalDocumentCard(
                    documentTitle = "Conta Oficial Gov.br",
                    citizenName = "Gabriel do Carmo",
                    documentNumberMasked = "058.***.***-91",
                    securityLevel = "Nível Ouro"
                )
            }
        }
    }
}
