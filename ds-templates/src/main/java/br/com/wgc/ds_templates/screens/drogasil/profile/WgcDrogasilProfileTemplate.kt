package br.com.wgc.ds_templates.screens.drogasil.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcDrogasilLoyaltyCard

@Composable
fun WgcDrogasilProfileTemplate(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.drogasilBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Meu Perfil Drogasil",
                    fontSize = WgcCoreDsFontSize.xl20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogasilTextPrimary)
                )
            }

            item {
                WgcDrogasilLoyaltyCard(
                    userName = "Mariana Alves",
                    cpfMasked = "123.***.***-00",
                    pointsBalance = 420
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogasilProfileTemplatePreview() {
    WgcDrogasilProfileTemplate()
}
