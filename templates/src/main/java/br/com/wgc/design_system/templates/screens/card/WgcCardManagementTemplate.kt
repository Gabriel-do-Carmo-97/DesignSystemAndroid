@file:Suppress("LongMethod", "UnusedPrivateMember", "MagicNumber")

package br.com.wgc.design_system.templates.screens.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Nfc
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.roundToInt

private const val CARD_ASPECT_RATIO = 1.58f
private const val FLIP_ROTATION_THRESHOLD = 90f
private const val FULL_FLIP_ROTATION = 180f
private const val FLIP_DURATION_MS = 600

/**
 * Estado corporativo de gerenciamento de cartões de crédito e débito.
 */
data class WgcCardManagementUiState(
    val title: String = "Meus Cartões",
    val cardholderName: String = "GABRIEL DO CARMO",
    val cardNumberMasked: String = "•••• •••• •••• 8842",
    val expirationDate: String = "12/29",
    val cvv: String = "891",
    val cardBrand: String = "WGC Black",
    val currentLimit: Float = 5000f,
    val maxLimit: Float = 15000f,
    val usedLimit: Float = 1850f,
    val isLocked: Boolean = false,
    val isVirtual: Boolean = false
)

/**
 * ViewModel base desacoplada para gerenciamento de cartões.
 */
abstract class BaseCardManagementViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcCardManagementUiState>
    abstract fun onToggleLock()
    abstract fun onLimitChange(newLimit: Float)
    abstract fun onCreateVirtualCard()
}

/**
 * Fake ViewModel para Preview e Testes.
 */
class FakeCardManagementViewModel(
    initialState: WgcCardManagementUiState = WgcCardManagementUiState()
) : BaseCardManagementViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcCardManagementUiState> = _uiState.asStateFlow()

    override fun onToggleLock() {
        _uiState.value = _uiState.value.copy(isLocked = !_uiState.value.isLocked)
    }

    override fun onLimitChange(newLimit: Float) {
        _uiState.value = _uiState.value.copy(currentLimit = newLimit)
    }

    override fun onCreateVirtualCard() {
        _uiState.value = _uiState.value.copy(
            isVirtual = true,
            cardNumberMasked = "•••• •••• •••• 4129",
            cardBrand = "WGC Virtual Express"
        )
    }
}

/**
 * Template completo corporativo de gestão de cartões de crédito/débito.
 */
@Composable
fun WgcCardManagementTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseCardManagementViewModel = FakeCardManagementViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    cardSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcCardManagementContent(
        state = state,
        modifier = modifier,
        onToggleLock = viewModel::onToggleLock,
        onLimitChange = viewModel::onLimitChange,
        onCreateVirtualCard = viewModel::onCreateVirtualCard,
        headerSlot = headerSlot,
        cardSlot = cardSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcCardManagementContent(
    state: WgcCardManagementUiState,
    modifier: Modifier = Modifier,
    onToggleLock: () -> Unit = {},
    onLimitChange: (Float) -> Unit = {},
    onCreateVirtualCard: () -> Unit = {},
    onBackClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    cardSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = { Text(state.title, style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            if (cardSlot != null) {
                cardSlot()
            } else {
                InteractiveFlipCard(state = state)
            }

            CardLimitAdjustmentSection(
                currentLimit = state.currentLimit,
                maxLimit = state.maxLimit,
                usedLimit = state.usedLimit,
                onLimitChange = onLimitChange
            )

            CardQuickActionsCard(
                isLocked = state.isLocked,
                onToggleLock = onToggleLock,
                onCreateVirtualCard = onCreateVirtualCard
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun InteractiveFlipCard(state: WgcCardManagementUiState) {
    var isFlipped by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) FULL_FLIP_ROTATION else 0f,
        animationSpec = tween(durationMillis = FLIP_DURATION_MS),
        label = "CardFlipAnimation"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(CARD_ASPECT_RATIO)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .clickable { isFlipped = !isFlipped }
        ) {
            if (rotation <= FLIP_ROTATION_THRESHOLD) {
                CardFrontFace(state = state)
            } else {
                Box(modifier = Modifier.graphicsLayer { rotationY = FULL_FLIP_ROTATION }) {
                    CardBackFace(state = state)
                }
            }
        }

        Text(
            text = "Toque no cartão para girar e ver o CVV",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
private fun CardFrontFace(state: WgcCardManagementUiState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = WgcCoreDsSpacing.xs8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = state.cardBrand,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Icon(
                    imageVector = Icons.Default.Nfc,
                    contentDescription = "Contactless",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Text(
                text = state.cardNumberMasked,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "TITULAR", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                    Text(text = state.cardholderName, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text(text = "VALIDADE", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                    Text(text = state.expirationDate, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun CardBackFace(state: WgcCardManagementUiState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shadowElevation = WgcCoreDsSpacing.xs8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSpacing.xxxl48.dp)
                    .background(Color.Black.copy(alpha = 0.8f))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "CÓDIGO DE SEGURANÇA (CVV)", style = MaterialTheme.typography.labelSmall)
                    Surface(
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                        color = MaterialTheme.colorScheme.surface,
                        modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = state.cvv,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                        )
                    }
                }
            }

            Text(
                text = "Central de Atendimento 24h: 0800 123 4567",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)
            )
        }
    }
}

@Composable
private fun CardLimitAdjustmentSection(
    currentLimit: Float,
    maxLimit: Float,
    usedLimit: Float,
    onLimitChange: (Float) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(text = "Ajuste de Limite do Cartão", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Limite Atual:", style = MaterialTheme.typography.bodyMedium)
                Text(text = "R$ ${currentLimit.roundToInt()}", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
            }

            Slider(
                value = currentLimit,
                onValueChange = onLimitChange,
                valueRange = usedLimit..maxLimit,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Fatura Atual: R$ ${usedLimit.roundToInt()}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.error
                )
                Text(
                    text = "Disponível Máximo: R$ ${maxLimit.roundToInt()}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun CardQuickActionsCard(
    isLocked: Boolean,
    onToggleLock: () -> Unit,
    onCreateVirtualCard: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.LockOpen,
                        contentDescription = null,
                        tint = if (isLocked) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(text = "Bloqueio Temporário", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text(
                            text = if (isLocked) "Cartão bloqueado para compras" else "Cartão liberado para uso",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
                Switch(checked = isLocked, onCheckedChange = { onToggleLock() })
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            WgcClassicButton(
                textButton = "Gerar Novo Cartão Virtual",
                onClick = onCreateVirtualCard,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(name = "WgcCardManagementTemplate Preview", showBackground = true)
@Composable
private fun WgcCardManagementTemplatePreview() {
    MaterialTheme {
        WgcCardManagementContent(state = WgcCardManagementUiState())
    }
}
