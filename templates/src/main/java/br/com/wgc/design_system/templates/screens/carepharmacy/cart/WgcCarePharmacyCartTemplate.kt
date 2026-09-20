package br.com.wgc.design_system.templates.screens.carepharmacy.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcDrogasilCartTemplate(
    modifier: Modifier = Modifier,
    onCheckout: () -> Unit = {}
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
                    text = "Sacola da Farmácia (1 item)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.carePharmacyTextPrimary)
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carePharmacySurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(
                            text = "Protetor Solar Facial FPS 60",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.carePharmacyTextPrimary)
                        )
                        Text(
                            text = "1 unidade • R$ 79,90",
                            fontSize = 10.sp,
                            color = Color(WgcCoreDsColors.carePharmacyTextSecondary)
                        )
                    }
                }
            }

            item {
                WgcClassicButton(
                    textButton = "Finalizar Pedido • R$ 79,90",
                    onClick = onCheckout,
                    modifier = Modifier.fillMaxWidth()
                    
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogasilCartTemplatePreview() {
    WgcDrogasilCartTemplate()
}
