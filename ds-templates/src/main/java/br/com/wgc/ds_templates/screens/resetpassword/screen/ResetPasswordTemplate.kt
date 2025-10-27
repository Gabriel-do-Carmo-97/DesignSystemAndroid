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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreenTemplate(
    modifier: Modifier = Modifier,
    state: ResetPasswordScreenUiState = ResetPasswordScreenUiState(),
    onEmailChange: (String) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
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
                modifier = modifier
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
                    onClick = onRegisterClick,
                    textButton = "Enviar"
                )
            }
        }

    }

}

@Preview
@Composable
private fun ResetPasswordScreenTemplatePreview() = ResetPasswordScreenTemplate()