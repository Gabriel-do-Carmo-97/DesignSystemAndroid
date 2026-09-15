package br.com.wgc.ds_templates.screens.paguemenos.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcPagueMenosCartTemplate(
    modifier: Modifier = Modifier,
    onCheckout: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.pagueMenosBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Cesta de Compras Pague Menos",
                    fontSize = WgcCoreDsFontSize.xl20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pagueMenosSurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(
                            text = "Shampoo Anticaspa Clear Men",
                            fontSize = WgcCoreDsFontSize.sm14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                        )
                        Text(
                            text = "1 unidade • R$ 22,90",
                            fontSize = WgcCoreDsFontSize.xs12.sp,
                            color = Color(WgcCoreDsColors.pagueMenosTextSecondary)
                        )
                    }
                }
            }

            item {
                WgcClassicButton(
                    text = "Concluir Compra • R$ 22,90",
                    onClick = onCheckout,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Color(WgcCoreDsColors.pagueMenosGreen),
                    contentColor = Color(WgcCoreDsColors.pagueMenosSurface)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPagueMenosCartTemplatePreview() {
    WgcPagueMenosCartTemplate()
}
