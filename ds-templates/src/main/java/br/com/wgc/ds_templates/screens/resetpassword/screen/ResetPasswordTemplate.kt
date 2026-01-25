package br.com.wgc.ds_templates.screens.resetpassword.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.shimmerEffect
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.ds_templates.screens.resetpassword.state.ResetPasswordScreenUiState
import br.com.wgc.ds_templates.screens.resetpassword.viewmodel.BaseResetPasswordScreenTemplateViewModel

/**
 * Tela de redefinição de senha (Stateful).
 *
 * Esta versão é "com estado" (stateful). Ela é responsável por conectar a lógica de negócio
 * (ViewModel) com a interface do usuário (UI). Ela coleta o estado e passa os eventos
 * para a versão stateless desta função.
 *
 * @param modifier O modificador a ser aplicado ao Composable.
 * @param viewModel A instância do ViewModel que provê o estado e os manipuladores de eventos.
 */
@Composable
fun ResetPasswordScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseResetPasswordScreenTemplateViewModel,
) {
    // Coleta o estado (UiState) a partir do ViewModel.
    val uiState by viewModel.uiState.collectAsState()

    // Chama a versão Stateless, passando o estado e as referências das funções.
    ResetPasswordScreenTemplate(
        modifier = modifier,
        state = uiState,
        onEmailChange = viewModel::onEmailChange,
        onResetPasswordClick = viewModel::onResetPasswordClick,
        onBackToLoginClick = viewModel::onBackToLoginClick
    )
}

/**
 * Tela de redefinição de senha (Stateless).
 *
 * Esta versão é "sem estado" (stateless) e puramente declarativa. Ela descreve a UI
 * com base no `state` recebido e delega os eventos para as funções de callback.
 *
 * @param state O estado atual da UI a ser exibido.
 * @param onEmailChange Callback invocado quando o campo de email muda.
 * @param onResetPasswordClick Callback invocado ao clicar no botão de redefinir.
 * @param onBackToLoginClick Callback invocado ao clicar no botão de voltar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ResetPasswordScreenTemplate(
    modifier: Modifier = Modifier,
    state: ResetPasswordScreenUiState,
    onEmailChange: (String) -> Unit,
    onResetPasswordClick: () -> Unit,
    onBackToLoginClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackToLoginClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = state.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold

                )
                Spacer(modifier = Modifier.height(32.dp))
                SimpleTextField(
                    value = state.email,
                    onValueChange = onEmailChange,
                    label = "Email",
                    placeholderText = "Digite seu email:",
                    leadingIcon = Icons.Default.Email,
                    isError = state.emailError != null,
                    errorMessage = state.emailError.orEmpty(),
                    keyboardType = KeyboardType.Email,
                )
                Spacer(modifier = Modifier.height(16.dp))
                ClassicButton(
                    modifier = Modifier.shimmerEffect(isLoading = state.isLoading),
                    onClick = onResetPasswordClick,
                    textButton = "Enviar"
                )
            }
        }
    }
}

// --- PREVIEWS ---

@Preview(showBackground = true, name = "Estado Padrão")
@Composable
private fun ResetPasswordScreenTemplatePreview() {
    MaterialTheme {
        // A preview agora chama a versão stateless (privada)
        ResetPasswordScreenTemplate(
            state = ResetPasswordScreenUiState(title = "Redefinir Senha"),
            onEmailChange = {},
            onResetPasswordClick = {},
            onBackToLoginClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Estado de Carregamento")
@Composable
private fun ResetPasswordScreenTemplateLoadingPreview() {
    MaterialTheme {
        // Exemplo de como visualizar o estado de carregamento
        ResetPasswordScreenTemplate(
            state = ResetPasswordScreenUiState(title = "Redefinir Senha", isLoading = true),
            onEmailChange = {},
            onResetPasswordClick = {},
            onBackToLoginClick = {}
        )
    }
}
