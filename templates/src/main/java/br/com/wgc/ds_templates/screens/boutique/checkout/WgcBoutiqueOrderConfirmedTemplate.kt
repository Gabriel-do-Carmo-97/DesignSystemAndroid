package br.com.wgc.ds_templates.screens.boutique.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcBoutiqueBottomNavButton

/**
 * Tela de confirmação de pedido oficial do Laza (WgcLazaOrderConfirmedTemplate).
 * Apresenta celebração gráfica com ícone de sucesso, mensagem de confirmação,
 * botão secundário "Go to Orders" e botão inferior fixo "Continue Shopping".
 */
@Composable
fun WgcLazaOrderConfirmedTemplate(
    modifier: Modifier = Modifier,
    orderCode: String = "#LAZA-84920",
    onBackClick: () -> Unit = {},
    onGoToOrdersClick: () -> Unit = {},
    onContinueShoppingClick: () -> Unit = {},
    customIllustrationSlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                WgcBoutiqueBottomNavButton(
                    label = "Continue Shopping",
                    onClick = onContinueShoppingClick
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s44.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.boutiqueSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.boutiqueDark),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            if (customIllustrationSlot != null) {
                customIllustrationSlot()
            } else {
                // Ilustração de Confirmação com fundo suave
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s140.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.boutiquePrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Pedido confirmado",
                        tint = Color(WgcCoreDsColors.boutiquePrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s72.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Text(
                text = "Order Confirmed!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.boutiqueDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Your order $orderCode has been confirmed, we will send you confirmation email shortly.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.boutiqueSecondaryText),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxl48.dp))

            // Botão secundário "Go to Orders"
            Button(
                onClick = onGoToOrdersClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s52.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.boutiqueSurface))
            ) {
                Text(
                    text = "Go to Orders",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(1.5f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaOrderConfirmedTemplatePreview() {
    WgcLazaOrderConfirmedTemplate()
}
