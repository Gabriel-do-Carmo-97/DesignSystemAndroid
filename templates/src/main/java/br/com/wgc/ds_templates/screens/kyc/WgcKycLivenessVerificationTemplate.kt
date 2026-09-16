package br.com.wgc.ds_templates.screens.kyc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class WgcKycLivenessUiState(
    val title: String = "Verificação de Identidade",
    val subtitle: String = "Posicione seu rosto dentro da moldura para validar sua biometria com segurança.",
    val isFaceDetected: Boolean = true,
    val isLightingAdequate: Boolean = true,
    val instructions: String = "Mantenha a cabeça reta e olhe para a câmera",
    val isProcessing: Boolean = false,
    val verificationSuccess: Boolean = false
)

abstract class BaseKycLivenessViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcKycLivenessUiState>
    abstract fun onCaptureClick()
    abstract fun onHelpClick()
}

class FakeKycLivenessViewModel : BaseKycLivenessViewModel() {
    private val _uiState = MutableStateFlow(WgcKycLivenessUiState())
    override val uiState: StateFlow<WgcKycLivenessUiState> = _uiState.asStateFlow()
    override fun onCaptureClick() {}
    override fun onHelpClick() {}
}

@Composable
fun WgcKycLivenessVerificationTemplate(
    viewModel: BaseKycLivenessViewModel = FakeKycLivenessViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    cameraFrameSlot: (@Composable () -> Unit)? = null,
    actionButtonSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()
    WgcKycLivenessVerificationContent(
        state = state,
        onCaptureClick = viewModel::onCaptureClick,
        onHelpClick = viewModel::onHelpClick,
        headerSlot = headerSlot,
        cameraFrameSlot = cameraFrameSlot,
        actionButtonSlot = actionButtonSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcKycLivenessVerificationContent(
    state: WgcKycLivenessUiState,
    onCaptureClick: () -> Unit,
    onHelpClick: () -> Unit,
    modifier: Modifier = Modifier,
    headerSlot: (@Composable () -> Unit)? = null,
    cameraFrameSlot: (@Composable () -> Unit)? = null,
    actionButtonSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = state.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    if (actionButtonSlot != null) {
                        actionButtonSlot()
                    } else {
                        WgcClassicButton(
                            textButton = if (state.isProcessing) "Processando Biometria..." else "Capturar Foto",
                            isLoading = state.isProcessing,
                            onClick = onCaptureClick,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)
            ) {
                Text(
                    text = state.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Frame visual da Câmera / Liveness
                if (cameraFrameSlot != null) {
                    cameraFrameSlot()
                } else {
                    Box(
                        modifier = Modifier
                            .size(260.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .border(
                                width = 3.dp,
                                color = if (state.isFaceDetected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = "Rosto para validação",
                            modifier = Modifier.size(160.dp),
                            tint = if (state.isFaceDetected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Card de status/instrução
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = if (state.isLightingAdequate) Icons.Default.CheckCircle else Icons.Default.Lightbulb,
                                contentDescription = null,
                                tint = if (state.isLightingAdequate) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                            )
                            Text(
                                text = state.instructions,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Shield,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Dados protegidos por criptografia de ponta a ponta.",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun WgcKycLivenessVerificationTemplatePreview() {
    MaterialTheme {
        WgcKycLivenessVerificationTemplate()
    }
}
