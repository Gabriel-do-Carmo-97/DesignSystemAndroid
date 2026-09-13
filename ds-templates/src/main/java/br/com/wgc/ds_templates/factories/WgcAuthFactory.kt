package br.com.wgc.ds_templates.factories

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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.ds_templates.brand.WgcBrand
import br.com.wgc.ds_templates.screens.aliexpress.auth.FakeAliExpressAuthViewModel
import br.com.wgc.ds_templates.screens.aliexpress.auth.WgcAliExpressLoginScreenTemplate
import br.com.wgc.ds_templates.screens.aliexpress.auth.WgcAliExpressRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.aliexpress.auth.WgcAliExpressResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.ifood.auth.FakeIFoodAuthViewModel
import br.com.wgc.ds_templates.screens.ifood.auth.WgcIFoodLoginScreenTemplate
import br.com.wgc.ds_templates.screens.ifood.auth.WgcIFoodRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.ifood.auth.WgcIFoodResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.auth.FakeMercadoLivreAuthViewModel
import br.com.wgc.ds_templates.screens.mercadolivre.auth.WgcMercadoLivreLoginScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.auth.WgcMercadoLivreRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.auth.WgcMercadoLivreResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.nineninefood.auth.FakeNineNineAuthViewModel
import br.com.wgc.ds_templates.screens.nineninefood.auth.WgcNineNineLoginScreenTemplate
import br.com.wgc.ds_templates.screens.nineninefood.auth.WgcNineNineRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.nineninefood.auth.WgcNineNineResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.shopee.auth.FakeShopeeAuthViewModel
import br.com.wgc.ds_templates.screens.shopee.auth.WgcShopeeLoginScreenTemplate
import br.com.wgc.ds_templates.screens.shopee.auth.WgcShopeeRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.shopee.auth.WgcShopeeResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.uber.auth.FakeUberAuthViewModel
import br.com.wgc.ds_templates.screens.uber.auth.WgcUberLoginScreenTemplate
import br.com.wgc.ds_templates.screens.uber.auth.WgcUberRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.uber.auth.WgcUberResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.community.klok.WgcKlokAuthScreenTemplate

/**
 * Fluxos de autenticação disponíveis nas fábricas.
 */
enum class WgcAuthFlow {
    Login,
    Register,
    ResetPassword,
    OtpVerification
}

/**
 * Fábrica Universal de Telas de Autenticação (WgcAuthFactory).
 * Permite alternar instantaneamente de marca ([brand]) e fluxo ([flow]) com defaults completos de produção.
 * Permite também substituição granular de blocos estruturais via Slots ([headerSlot], [inputSlot], [primaryButtonSlot], [footerSlot]).
 */
@Composable
fun WgcAuthFactory(
    modifier: Modifier = Modifier,
    brand: WgcBrand = WgcBrand.IFood,
    flow: WgcAuthFlow = WgcAuthFlow.Login,
    headerSlot: (@Composable () -> Unit)? = null,
    inputSlot: (@Composable () -> Unit)? = null,
    primaryButtonSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    onNavigateToRegister: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    onNavigateToResetPassword: () -> Unit = {},
    onVerified: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || inputSlot != null || primaryButtonSlot != null || footerSlot != null

    if (!hasCustomSlots) {
        // Delega diretamente para os templates oficiais padronizados com seus ViewModels default
        when (brand) {
            WgcBrand.IFood -> {
                val vm = FakeIFoodAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcIFoodLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcIFoodRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcIFoodResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.Uber -> {
                val vm = FakeUberAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcUberLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcUberRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcUberResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.MercadoLivre -> {
                val vm = FakeMercadoLivreAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcMercadoLivreLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcMercadoLivreRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcMercadoLivreResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.NineNineFood -> {
                val vm = FakeNineNineAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcNineNineLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcNineNineRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcNineNineResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.Shopee -> {
                val vm = FakeShopeeAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcShopeeLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcShopeeRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcShopeeResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.AliExpress -> {
                val vm = FakeAliExpressAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcAliExpressLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcAliExpressRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcAliExpressResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.Klok -> {
                WgcKlokAuthScreenTemplate(
                    onNavigateToForgotPassword = onNavigateToResetPassword
                )
            }
        }
        return
    }

    // Renderização com suporte a slots granulares e fallback sensato
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header Slot
            if (headerSlot != null) {
                headerSlot()
            } else {
                WgcBrandAuthHeader(
                    brandName = brand.brandName,
                    brandLogoText = brand.brandLogoText,
                    brandColor = brand.primaryColor,
                    title = when (flow) {
                        WgcAuthFlow.Login -> "Acesse sua conta no ${brand.brandName}"
                        WgcAuthFlow.Register -> "Crie sua conta no ${brand.brandName}"
                        WgcAuthFlow.ResetPassword -> "Recuperar Conta ${brand.brandName}"
                        WgcAuthFlow.OtpVerification -> "Validação de Segurança"
                    },
                    subtitle = when (flow) {
                        WgcAuthFlow.Login -> "Como deseja continuar?"
                        WgcAuthFlow.Register -> "Preencha seus dados para começar"
                        WgcAuthFlow.ResetPassword -> "Digite o código enviado por SMS/E-mail"
                        WgcAuthFlow.OtpVerification -> "Insira o código de 6 dígitos recebido"
                    }
                )
            }

            // Input Slot
            if (inputSlot != null) {
                inputSlot()
            } else {
                when (flow) {
                    WgcAuthFlow.Login -> {
                        SimpleTextField(
                            value = "",
                            onValueChange = {},
                            label = "E-mail ou número de celular"
                        )
                    }
                    WgcAuthFlow.Register -> {
                        SimpleTextField(value = "", onValueChange = {}, label = "Nome completo")
                        SimpleTextField(value = "", onValueChange = {}, label = "E-mail ou Celular")
                        SimpleTextField(value = "", onValueChange = {}, label = "Senha", isPasswordField = true)
                    }
                    WgcAuthFlow.ResetPassword -> {
                        SimpleTextField(value = "", onValueChange = {}, label = "E-mail cadastrado")
                    }
                    WgcAuthFlow.OtpVerification -> {
                        WgcOtpCodeInput(otpCode = "", onOtpCodeChange = {})
                    }
                }
            }

            // Primary Button Slot
            if (primaryButtonSlot != null) {
                primaryButtonSlot()
            } else {
                WgcButton(
                    text = when (flow) {
                        WgcAuthFlow.Login -> "Continuar no ${brand.brandName}"
                        WgcAuthFlow.Register -> "Cadastrar no ${brand.brandName}"
                        WgcAuthFlow.ResetPassword -> "Redefinir Senha"
                        WgcAuthFlow.OtpVerification -> "Confirmar Código"
                    }
                )
            }

            // Footer Slot
            if (footerSlot != null) {
                footerSlot()
            } else {
                when (flow) {
                    WgcAuthFlow.Login -> {
                        Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                                Text("Esqueci minha senha / Verificar por SMS")
                            }
                            HorizontalDivider()
                            WgcSocialLoginButtons()
                            WgcButton(
                                text = "Criar nova conta no ${brand.brandName}",
                                variant = WgcButtonVariant.Outlined,
                                onClick = onNavigateToRegister
                            )
                        }
                    }
                    WgcAuthFlow.Register -> {
                        WgcButton(
                            text = "Já tenho uma conta no ${brand.brandName}",
                            variant = WgcButtonVariant.Ghost,
                            onClick = onNavigateToLogin
                        )
                    }
                    else -> {}
                }
            }
        }
    }
}

@Preview(name = "WgcAuthFactory - Default iFood", showBackground = true)
@Composable
private fun WgcAuthFactoryDefaultPreview() {
    WgcAuthFactory()
}

@Preview(name = "WgcAuthFactory - Uber Register", showBackground = true)
@Composable
private fun WgcAuthFactoryUberRegisterPreview() {
    WgcAuthFactory(brand = WgcBrand.Uber, flow = WgcAuthFlow.Register)
}
