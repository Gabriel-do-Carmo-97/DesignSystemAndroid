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
import br.com.wgc.design_system.templates.screens.resetpassword.screen.ResetPasswordScreenTemplate
import br.com.wgc.design_system.templates.screens.resetpassword.viewmodel.BaseResetPasswordScreenTemplateViewModel
import br.com.wgc.design_system.templates.screens.resetpassword.viewmodel.FakeResetPasswordViewModel
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Recuperação de Senha (WgcResetPasswordFactory).
 */
@Composable
fun WgcResetPasswordFactory(
    modifier: Modifier = Modifier,
    variant: WgcResetPasswordVariant = WgcResetPasswordVariant.FOOD_DELIVERY,
    viewModel: BaseResetPasswordScreenTemplateViewModel? = null,
    headerSlot: (@Composable () -> Unit)? = null,
    inputSlot: (@Composable () -> Unit)? = null,
    primaryButtonSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    onNavigateToLogin: () -> Unit = {},
    onSubmitSuccess: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || inputSlot != null ||
        primaryButtonSlot != null || footerSlot != null

    if (hasCustomSlots) {
        CustomSlotsResetPasswordLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            footerSlot = footerSlot,
            onNavigateToLogin = onNavigateToLogin,
            onSubmitSuccess = onSubmitSuccess
        )
    } else if (viewModel != null) {
        ResetPasswordScreenTemplate(
            modifier = modifier,
            viewModel = viewModel
        )
    } else if (variant == WgcResetPasswordVariant.STANDARD) {
        ResetPasswordScreenTemplate(
            modifier = modifier,
            viewModel = FakeResetPasswordViewModel()
        )
    } else {
        CustomSlotsResetPasswordLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = null,
            inputSlot = null,
            primaryButtonSlot = null,
            footerSlot = null,
            onNavigateToLogin = onNavigateToLogin,
            onSubmitSuccess = onSubmitSuccess
        )
    }
}

@Composable
private fun CustomSlotsResetPasswordLayout(
    modifier: Modifier,
    variant: WgcResetPasswordVariant,
    headerSlot: (@Composable () -> Unit)?,
    inputSlot: (@Composable () -> Unit)?,
    primaryButtonSlot: (@Composable () -> Unit)?,
    footerSlot: (@Composable () -> Unit)?,
    onNavigateToLogin: () -> Unit,
    onSubmitSuccess: () -> Unit
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
                title = "Recuperar senha",
                subtitle = "Informe seu e-mail cadastrado no ${variant.displayName}"
            )

            inputSlot?.invoke() ?: SimpleTextField(
                value = "",
                onValueChange = {},
                label = "E-mail cadastrado"
            )

            primaryButtonSlot?.invoke() ?: WgcButton(
                text = "Enviar instruções",
                onClick = onSubmitSuccess,
                modifier = Modifier.fillMaxWidth()
            )

            footerSlot?.invoke() ?: TextButton(
                onClick = onNavigateToLogin,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar para o Login")
            }
        }
    }
}

@Preview(name = "WgcResetPasswordFactory - Preview", showBackground = true)
@Composable
private fun WgcResetPasswordFactoryPreview() {
    WgcTheme {
        WgcResetPasswordFactory()
    }
}
