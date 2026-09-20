package br.com.wgc.design_system.templates.screens.profile

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado de UI da tela de edição de perfil de usuário.
 */
data class WgcUserProfileEditUiState(
    val name: String = "Gabriel do Carmo",
    val email: String = "gabriel.carmo@wgc.com.br",
    val phone: String = "(11) 98765-4321",
    val bio: String = "Tech Lead & Android Architect apaixonado por Design Systems.",
    val avatarUrl: String? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val nameError: String? = null,
    val emailError: String? = null,
    val phoneError: String? = null,
    val successMessage: String? = null
)

abstract class BaseUserProfileEditViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcUserProfileEditUiState>
    abstract fun onNameChange(name: String)
    abstract fun onEmailChange(email: String)
    abstract fun onPhoneChange(phone: String)
    abstract fun onBioChange(bio: String)
    abstract fun onSaveClick()
    abstract fun onCancelClick()
    abstract fun onChangeAvatarClick()
}

class FakeUserProfileEditViewModel : BaseUserProfileEditViewModel() {
    private val _uiState = MutableStateFlow(WgcUserProfileEditUiState())
    override val uiState: StateFlow<WgcUserProfileEditUiState> = _uiState.asStateFlow()

    override fun onNameChange(name: String) {
        val error = if (name.isBlank()) "Nome não pode ficar em branco" else null
        _uiState.value = _uiState.value.copy(name = name, nameError = error)
    }

    override fun onEmailChange(email: String) {
        val error = if (!email.contains("@")) "E-mail inválido" else null
        _uiState.value = _uiState.value.copy(email = email, emailError = error)
    }

    override fun onPhoneChange(phone: String) {
        _uiState.value = _uiState.value.copy(phone = phone, phoneError = null)
    }

    override fun onBioChange(bio: String) {
        _uiState.value = _uiState.value.copy(bio = bio)
    }

    override fun onSaveClick() {
        _uiState.value = _uiState.value.copy(
            isSaving = false,
            successMessage = "Perfil atualizado com sucesso!"
        )
    }

    override fun onCancelClick() {
        // Implementação fake para preview e testes sem efeitos colaterais
    }

    override fun onChangeAvatarClick() {
        // Implementação fake para preview e testes sem efeitos colaterais
    }
}

/**
 * Template completo de Edição de Perfil de Usuário com State Hoisting e slots customizáveis.
 */
@Composable
fun WgcUserProfileEditTemplate(
    viewModel: BaseUserProfileEditViewModel = FakeUserProfileEditViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    avatarSlot: (@Composable () -> Unit)? = null,
    extraFieldsSlot: (@Composable () -> Unit)? = null,
    onNavigateBack: (() -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcUserProfileEditContent(
        state = state,
        onNameChange = viewModel::onNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPhoneChange = viewModel::onPhoneChange,
        onBioChange = viewModel::onBioChange,
        onSaveClick = viewModel::onSaveClick,
        onCancelClick = viewModel::onCancelClick,
        onChangeAvatarClick = viewModel::onChangeAvatarClick,
        headerSlot = headerSlot,
        avatarSlot = avatarSlot,
        extraFieldsSlot = extraFieldsSlot,
        onNavigateBack = onNavigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod", "CyclomaticComplexMethod", "LongParameterList")
@Composable
private fun WgcUserProfileEditContent(
    state: WgcUserProfileEditUiState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onCancelClick: () -> Unit,
    onChangeAvatarClick: () -> Unit,
    headerSlot: (@Composable () -> Unit)?,
    avatarSlot: (@Composable () -> Unit)?,
    extraFieldsSlot: (@Composable () -> Unit)?,
    onNavigateBack: (() -> Unit)?
) {
    Scaffold(
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = "Editar Perfil",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (onNavigateBack != null) {
                            IconButton(onClick = onNavigateBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar"
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
    ) { paddingValues ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState())
                    .padding(WgcCoreDsSpacing.lg.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Seção Avatar
                if (avatarSlot != null) {
                    avatarSlot()
                } else {
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md.dp)
                    ) {
                        WgcAvatar(
                            imageUrl = state.avatarUrl,
                            initials = state.name.take(2),
                            size = 100.dp
                        )
                        IconButton(
                            onClick = onChangeAvatarClick,
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {
                            Icon(
                                imageVector = Icons.Default.CameraAlt,
                                contentDescription = "Trocar foto de perfil",
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

                // Campos de entrada
                OutlinedTextField(
                    value = state.name,
                    onValueChange = onNameChange,
                    label = { Text("Nome Completo") },
                    isError = state.nameError != null,
                    supportingText = state.nameError?.let { { Text(it) } },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors()
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                OutlinedTextField(
                    value = state.email,
                    onValueChange = onEmailChange,
                    label = { Text("E-mail") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = state.emailError != null,
                    supportingText = state.emailError?.let { { Text(it) } },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors()
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                OutlinedTextField(
                    value = state.phone,
                    onValueChange = onPhoneChange,
                    label = { Text("Telefone") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    isError = state.phoneError != null,
                    supportingText = state.phoneError?.let { { Text(it) } },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors()
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                OutlinedTextField(
                    value = state.bio,
                    onValueChange = onBioChange,
                    label = { Text("Biografia") },
                    minLines = 3,
                    maxLines = 5,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors()
                )

                extraFieldsSlot?.invoke()

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

                // Botões de ação
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
                ) {
                    WgcSecondaryClassicButton(
                        textButton = "Cancelar",
                        onClick = onCancelClick,
                        modifier = Modifier.weight(1f)
                    )

                    WgcClassicButton(
                        textButton = "Salvar Alterações",
                        onClick = onSaveClick,
                        isLoading = state.isSaving,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(name = "User Profile Edit Preview", showBackground = true)
@Composable
private fun WgcUserProfileEditTemplatePreview() {
    Surface {
        WgcUserProfileEditTemplate()
    }
}
