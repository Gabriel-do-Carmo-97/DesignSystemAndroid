package br.com.wgc.design_system.templates.screens.feedback

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.buttons.WgcButtonFactory
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Tipos de estados de erro e resiliência offline suportados pelo template.
 */
enum class WgcErrorStateType {
    EMPTY_STATE,
    NO_INTERNET,
    UNDER_MAINTENANCE,
    GENERIC_ERROR
}

/**
 * Estado corporativo para telas de erro, vazio e resiliência offline.
 */
data class WgcErrorStateUiState(
    val type: WgcErrorStateType = WgcErrorStateType.GENERIC_ERROR,
    val title: String = "Algo deu errado",
    val description: String = "Não foi possível carregar as informações no momento. Verifique sua conexão e tente novamente.",
    val actionButtonText: String? = "Tentar Novamente",
    val secondaryButtonText: String? = "Voltar ao Início",
    val isLoading: Boolean = false
)

/**
 * ViewModel base desacoplada para gerenciamento de estados de erro.
 */
abstract class BaseErrorStateViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcErrorStateUiState>
    abstract fun onPrimaryActionClick()
    abstract fun onSecondaryActionClick()
}

/**
 * Fake ViewModel para renderização em @Preview e testes unitários rápidos.
 */
class FakeErrorStateViewModel(
    initialState: WgcErrorStateUiState = WgcErrorStateUiState()
) : BaseErrorStateViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcErrorStateUiState> = _uiState.asStateFlow()

    override fun onPrimaryActionClick() {
        _uiState.value = _uiState.value.copy(isLoading = true)
    }

    override fun onSecondaryActionClick() {
        // Ação secundária simulada
    }
}

/**
 * Template corporativo universal de Telas de Erro, Vazio e Resiliência Offline (WgcErrorStateTemplate).
 *
 * @param modifier Modificador de layout.
 * @param viewModel ViewModel que fornece o estado [WgcErrorStateUiState].
 * @param illustrationSlot Slot customizável para ilustração vetorial ou animação Lottie.
 * @param actionsSlot Slot customizável para botões de ação alternativos.
 */
@Composable
fun WgcErrorStateTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseErrorStateViewModel = FakeErrorStateViewModel(),
    illustrationSlot: (@Composable () -> Unit)? = null,
    actionsSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    val defaultIcon: ImageVector = when (state.type) {
        WgcErrorStateType.EMPTY_STATE -> Icons.Default.Inbox
        WgcErrorStateType.NO_INTERNET -> Icons.Default.WifiOff
        WgcErrorStateType.UNDER_MAINTENANCE -> Icons.Default.Build
        WgcErrorStateType.GENERIC_ERROR -> Icons.Default.ErrorOutline
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.xl32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (illustrationSlot != null) {
                illustrationSlot()
            } else {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = defaultIcon,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = when (state.type) {
                            WgcErrorStateType.GENERIC_ERROR -> MaterialTheme.colorScheme.error
                            WgcErrorStateType.NO_INTERNET -> MaterialTheme.colorScheme.secondary
                            else -> MaterialTheme.colorScheme.primary
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = state.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = state.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            if (actionsSlot != null) {
                actionsSlot()
            } else {
                state.actionButtonText?.let { primaryText ->
                    WgcButtonFactory.Primary(
                        text = primaryText,
                        onClick = { viewModel.onPrimaryActionClick() },
                        isLoading = state.isLoading,
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = { Icon(Icons.Default.Refresh, contentDescription = null) }
                    )
                }

                state.secondaryButtonText?.let { secondaryText ->
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    WgcButtonFactory.Ghost(
                        text = secondaryText,
                        onClick = { viewModel.onSecondaryActionClick() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(name = "Erro Genérico", showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcErrorStateGenericPreview() {
    MaterialTheme {
        WgcErrorStateTemplate(
            viewModel = FakeErrorStateViewModel(
                initialState = WgcErrorStateUiState(
                    type = WgcErrorStateType.GENERIC_ERROR,
                    title = "Ops! Ocorreu uma falha",
                    description = "Nosso servidor não conseguiu processar sua solicitação. Tente novamente em instantes."
                )
            )
        )
    }
}

@Preview(name = "Sem Conexão", showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcErrorStateNoInternetPreview() {
    MaterialTheme {
        WgcErrorStateTemplate(
            viewModel = FakeErrorStateViewModel(
                initialState = WgcErrorStateUiState(
                    type = WgcErrorStateType.NO_INTERNET,
                    title = "Sem Conexão com a Internet",
                    description = "Parece que você está offline. Conecte-se a uma rede Wi-Fi ou dados móveis para continuar.",
                    actionButtonText = "Verificar Conexão"
                )
            )
        )
    }
}

@Preview(name = "Estado Vazio", showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcErrorStateEmptyPreview() {
    MaterialTheme {
        WgcErrorStateTemplate(
            viewModel = FakeErrorStateViewModel(
                initialState = WgcErrorStateUiState(
                    type = WgcErrorStateType.EMPTY_STATE,
                    title = "Nenhum resultado encontrado",
                    description = "Não localizamos itens para os filtros aplicados. Tente ajustar os termos da sua pesquisa.",
                    actionButtonText = "Limpar Filtros"
                )
            )
        )
    }
}
