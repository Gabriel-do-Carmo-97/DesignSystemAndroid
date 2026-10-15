package br.com.wgc.design_system.factories.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.biometrics.FakeBiometricAuthViewModel
import br.com.wgc.design_system.templates.screens.biometrics.WgcBiometricAuthTemplate
import br.com.wgc.design_system.templates.screens.community.klok.WgcKlokAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.community.split.WgcSplitCardAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.community.wave.WgcWaveAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.dealmarketplace.auth.FakeDealMarketplaceAuthViewModel
import br.com.wgc.design_system.templates.screens.dealmarketplace.auth.WgcDealMarketplaceLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.fooddelivery.auth.FakeFoodDeliveryAuthViewModel
import br.com.wgc.design_system.templates.screens.fooddelivery.auth.WgcFoodDeliveryLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.globalmarketplace.auth.FakeGlobalMarketplaceAuthViewModel
import br.com.wgc.design_system.templates.screens.globalmarketplace.auth.WgcGlobalMarketplaceLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.design_system.templates.screens.login.viewmodel.BaseLoginScreenTemplateViewModel
import br.com.wgc.design_system.templates.screens.marketplacescreen.auth.FakeMarketplaceAuthViewModel
import br.com.wgc.design_system.templates.screens.marketplacescreen.auth.WgcMarketplaceLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.quickfooddelivery.auth.FakeQuickFoodDeliveryAuthViewModel
import br.com.wgc.design_system.templates.screens.quickfooddelivery.auth.WgcQuickFoodDeliveryLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.ridehailing.auth.FakeRideHailingAuthViewModel
import br.com.wgc.design_system.templates.screens.ridehailing.auth.WgcRideHailingLoginScreenTemplate
import br.com.wgc.design_system.templates.screens.trendfashion.auth.WgcStylishLoginScreenTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Login (WgcLoginFactory).
 *
 * Expõe ponto de entrada unificado para todas as variantes de login do Design System,
 * com defaults sensatos de produção e suporte a slots customizados.
 */
@Composable
fun WgcLoginFactory(
    modifier: Modifier = Modifier,
    variant: WgcLoginVariant = WgcLoginVariant.FOOD_DELIVERY,
    viewModel: BaseLoginScreenTemplateViewModel? = null,
    headerSlot: (@Composable () -> Unit)? = null,
    inputSlot: (@Composable () -> Unit)? = null,
    primaryButtonSlot: (@Composable () -> Unit)? = null,
    socialLoginSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    onNavigateToRegister: () -> Unit = {},
    onNavigateToResetPassword: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || inputSlot != null ||
        primaryButtonSlot != null || socialLoginSlot != null || footerSlot != null

    if (hasCustomSlots) {
        CustomSlotsLoginLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            socialLoginSlot = socialLoginSlot,
            footerSlot = footerSlot,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword,
            onLoginSuccess = onLoginSuccess
        )
    } else if (viewModel != null) {
        LoginScreenTemplate(
            modifier = modifier,
            viewModel = viewModel
        )
    } else {
        VariantLoginScreen(
            modifier = modifier,
            variant = variant,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword,
            onLoginSuccess = onLoginSuccess
        )
    }
}

@Composable
private fun VariantLoginScreen(
    modifier: Modifier,
    variant: WgcLoginVariant,
    onNavigateToRegister: () -> Unit,
    onNavigateToResetPassword: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    when (variant) {
        WgcLoginVariant.BIOMETRIC -> WgcBiometricAuthTemplate(
            viewModel = FakeBiometricAuthViewModel(
                onBiometricTrigger = onLoginSuccess,
                onFallbackPinTrigger = onNavigateToResetPassword
            )
        )
        WgcLoginVariant.FOOD_DELIVERY -> WgcFoodDeliveryLoginScreenTemplate(
            viewModel = FakeFoodDeliveryAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.RIDE_HAILING -> WgcRideHailingLoginScreenTemplate(
            viewModel = FakeRideHailingAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.MARKETPLACE,
        WgcLoginVariant.QUICK_FOOD_DELIVERY,
        WgcLoginVariant.DEAL_MARKETPLACE,
        WgcLoginVariant.GLOBAL_MARKETPLACE -> RenderMarketplaceLoginScreen(
            variant = variant,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.TREND_FASHION -> WgcStylishLoginScreenTemplate(
            onSignUpClick = onNavigateToRegister,
            onForgotPasswordClick = onNavigateToResetPassword
        )
        WgcLoginVariant.WAVE -> WgcWaveAuthScreenTemplate(
            onNavigateToForgotPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.SPLIT_CARD -> WgcSplitCardAuthScreenTemplate(
            onNavigateToForgotPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.CLOCK -> WgcKlokAuthScreenTemplate(
            onNavigateToForgotPassword = onNavigateToResetPassword
        )
        else -> CustomSlotsLoginLayout(
            modifier = modifier,
            variant = variant,
            headerSlot = null,
            inputSlot = null,
            primaryButtonSlot = null,
            socialLoginSlot = null,
            footerSlot = null,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword,
            onLoginSuccess = {}
        )
    }
}

@Composable
private fun RenderMarketplaceLoginScreen(
    variant: WgcLoginVariant,
    onNavigateToRegister: () -> Unit,
    onNavigateToResetPassword: () -> Unit
) {
    when (variant) {
        WgcLoginVariant.MARKETPLACE -> WgcMarketplaceLoginScreenTemplate(
            viewModel = FakeMarketplaceAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.QUICK_FOOD_DELIVERY -> WgcQuickFoodDeliveryLoginScreenTemplate(
            viewModel = FakeQuickFoodDeliveryAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.DEAL_MARKETPLACE -> WgcDealMarketplaceLoginScreenTemplate(
            viewModel = FakeDealMarketplaceAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        WgcLoginVariant.GLOBAL_MARKETPLACE -> WgcGlobalMarketplaceLoginScreenTemplate(
            viewModel = FakeGlobalMarketplaceAuthViewModel(),
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword
        )
        else -> Unit
    }
}

@Composable
private fun CustomSlotsLoginLayout(
    modifier: Modifier,
    variant: WgcLoginVariant,
    headerSlot: (@Composable () -> Unit)?,
    inputSlot: (@Composable () -> Unit)?,
    primaryButtonSlot: (@Composable () -> Unit)?,
    socialLoginSlot: (@Composable () -> Unit)?,
    footerSlot: (@Composable () -> Unit)?,
    onNavigateToRegister: () -> Unit,
    onNavigateToResetPassword: () -> Unit,
    onLoginSuccess: () -> Unit
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
                title = "Acesse sua conta",
                subtitle = "Entre com suas credenciais do ${variant.displayName}"
            )

            inputSlot?.invoke() ?: SimpleTextField(
                value = "",
                onValueChange = {},
                label = "E-mail ou celular"
            )

            primaryButtonSlot?.invoke() ?: WgcButton(
                text = "Entrar no ${variant.displayName}",
                onClick = onLoginSuccess,
                modifier = Modifier.fillMaxWidth()
            )

            socialLoginSlot?.invoke() ?: WgcSocialLoginButtons()

            footerSlot?.invoke() ?: DefaultLoginFooter(
                variant = variant,
                onNavigateToRegister = onNavigateToRegister,
                onNavigateToResetPassword = onNavigateToResetPassword
            )
        }
    }
}

@Composable
private fun DefaultLoginFooter(
    variant: WgcLoginVariant,
    onNavigateToRegister: () -> Unit,
    onNavigateToResetPassword: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
        TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
            Text("Esqueci minha senha")
        }
        HorizontalDivider()
        WgcButton(
            text = "Criar nova conta no ${variant.displayName}",
            variant = WgcButtonVariant.Outlined,
            onClick = onNavigateToRegister,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(name = "WgcLoginFactory - Default FoodDelivery", showBackground = true)
@Composable
private fun WgcLoginFactoryDefaultPreview() {
    WgcTheme {
        WgcLoginFactory()
    }
}

@Preview(name = "WgcLoginFactory - RideHailing", showBackground = true)
@Composable
private fun WgcLoginFactoryRideHailingPreview() {
    WgcTheme {
        WgcLoginFactory(variant = WgcLoginVariant.RIDE_HAILING)
    }
}
