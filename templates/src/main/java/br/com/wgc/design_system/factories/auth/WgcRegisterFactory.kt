package br.com.wgc.design_system.factories.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.register.user.screen.RegisterUserScreenTemplate
import br.com.wgc.design_system.templates.screens.register.user.viewmodel.BaseRegisterUserTemplateViewModel
import br.com.wgc.design_system.templates.screens.register.user.viewmodel.FakeUserViewModel
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Cadastro (WgcRegisterFactory).
 */
@Composable
fun WgcRegisterFactory(
    modifier: Modifier = Modifier,
    variant: WgcRegisterVariant = WgcRegisterVariant.FOOD_DELIVERY,
    viewModel: BaseRegisterUserTemplateViewModel? = null,
    headerSlot: (@Composable () -> Unit)? = null,
    inputSlot: (@Composable () -> Unit)? = null,
    primaryButtonSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || inputSlot != null ||
        primaryButtonSlot != null || footerSlot != null

    if (hasCustomSlots) {
        CustomSlotsRegisterLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            footerSlot = footerSlot,
            onNavigateToLogin = onNavigateToLogin,
            onRegisterSuccess = onRegisterSuccess
        )
    } else if (viewModel != null) {
        RegisterUserScreenTemplate(
            modifier = modifier,
            viewModel = viewModel
        )
    } else if (variant == WgcRegisterVariant.STANDARD) {
        RegisterUserScreenTemplate(
            modifier = modifier,
            viewModel = FakeUserViewModel()
        )
    } else {
        CustomSlotsRegisterLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = null,
            inputSlot = null,
            primaryButtonSlot = null,
            footerSlot = null,
            onNavigateToLogin = onNavigateToLogin,
            onRegisterSuccess = onRegisterSuccess
        )
    }
}

@Composable
private fun CustomSlotsRegisterLayout(
    modifier: Modifier,
    variant: WgcRegisterVariant,
    headerSlot: (@Composable () -> Unit)?,
    inputSlot: (@Composable () -> Unit)?,
    primaryButtonSlot: (@Composable () -> Unit)?,
    footerSlot: (@Composable () -> Unit)?,
    onNavigateToLogin: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            headerSlot?.invoke() ?: WgcBrandAuthHeader(
                brandName = variant.displayName,
                brandLogoText = variant.logoText,
                brandColor = variant.primaryColor,
                title = "Criar conta",
                subtitle = "Junte-se ao ${variant.displayName}"
            )

            inputSlot?.invoke() ?: Column(
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                SimpleTextField(value = "", onValueChange = {}, label = "Nome completo")
                SimpleTextField(value = "", onValueChange = {}, label = "E-mail")
                SimpleTextField(value = "", onValueChange = {}, label = "Senha")
            }

            primaryButtonSlot?.invoke() ?: WgcButton(
                text = "Cadastrar no ${variant.displayName}",
                onClick = onRegisterSuccess,
                modifier = Modifier.fillMaxWidth()
            )

            footerSlot?.invoke() ?: TextButton(
                onClick = onNavigateToLogin,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Já tem uma conta? Entrar")
            }
        }
    }
}

@Preview(name = "WgcRegisterFactory - Preview", showBackground = true)
@Composable
private fun WgcRegisterFactoryPreview() {
    WgcTheme {
        WgcRegisterFactory()
    }
}
