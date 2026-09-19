package br.com.wgc.ds_templates.screens.carepharmacy.profile

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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcHealthLoyaltyCard

import br.com.wgc.design_system.commons.WgcDevicePreviews

@Composable
fun WgcCarePharmacyProfileTemplate(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Meu Perfil de Saúde",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.carePharmacyTextPrimary)
                )
            }

            item {
                WgcHealthLoyaltyCard(
                    userName = "Mariana Alves",
                    cpfMasked = "123.***.***-00",
                    pointsBalance = 420
                )
            }
        }
    }
}

@WgcDevicePreviews
@Preview(showBackground = true)
@Composable
private fun WgcCarePharmacyProfileTemplatePreview() {
    WgcCarePharmacyProfileTemplate()
}

@Deprecated("Use WgcCarePharmacyProfileTemplate instead", ReplaceWith("WgcCarePharmacyProfileTemplate(modifier)"))
@Composable
fun WgcDrogasilProfileTemplate(modifier: Modifier = Modifier) {
    WgcCarePharmacyProfileTemplate(modifier = modifier)
}
