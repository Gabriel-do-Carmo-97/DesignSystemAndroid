package br.com.wgc.design_system.templates.screens.wallet

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcDigitalWalletUiState(
    val cardHolder: String = "GABRIEL DO CARMO",
    val cardNumberMasked: String = "•••• •••• •••• 4092",
    val expiryDate: String = "11/29",
    val cvv: String = "731",
    val availableLimit: String = "R$ 15.000,00",
    val isCardBlocked: Boolean = false
)

/**
 * Template de Carteira Digital com efeito de virada 3D do cartão para visualização de CVV.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcDigitalWalletTemplate(
    uiState: WgcDigitalWalletUiState = WgcDigitalWalletUiState(),
    onBack: () -> Unit = {},
    onToggleCardBlock: () -> Unit = {},
    onAdjustLimit: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var isFlipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "card_flip"
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Carteira Digital", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Cartão 3D Flip
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .graphicsLayer {
                        rotationY = rotation
                        cameraDistance = 12f * density
                    }
                    .clickable { isFlipped = !isFlipped },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                if (rotation <= 90f) {
                    // Frente do cartão
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(WgcCoreDsSpacing.lg24.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "WGC PLATINUM", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimary)
                            Icon(imageVector = Icons.Default.CreditCard, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
                        }

                        Text(
                            text = uiState.cardNumberMasked,
                            style = MaterialTheme.typography.headlineSmall,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = uiState.cardHolder, color = MaterialTheme.colorScheme.onPrimary)
                            Text(text = "VALIDADE ${uiState.expiryDate}", color = MaterialTheme.colorScheme.onPrimary)
                        }
                    }
                } else {
                    // Verso do cartão
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer { rotationY = 180f },
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .background(Color.Black.copy(alpha = 0.8f))
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "CVV: ${uiState.cvv}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        Text(
                            text = "Toque novamente para voltar",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                            modifier = Modifier.padding(WgcCoreDsSpacing.lg24.dp)
                        )
                    }
                }
            }

            // Ações rápidas do cartão
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                WgcClassicButton(
                    text = if (uiState.isCardBlocked) "Desbloquear" else "Bloquear Cartão",
                    onClick = onToggleCardBlock,
                    modifier = Modifier.weight(1f)
                )
                WgcClassicButton(
                    text = "Ajustar Limite",
                    onClick = onAdjustLimit,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
