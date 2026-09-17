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
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.FakeAliExpressAuthViewModel
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.WgcAliExpressLoginScreenTemplate
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.WgcAliExpressRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.WgcAliExpressResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.fooddelivery.auth.FakeFoodDeliveryAuthViewModel
import br.com.wgc.ds_templates.screens.fooddelivery.auth.WgcFoodDeliveryLoginScreenTemplate
import br.com.wgc.ds_templates.screens.fooddelivery.auth.WgcFoodDeliveryRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.fooddelivery.auth.WgcFoodDeliveryResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.marketplacescreen.auth.FakeMarketplaceAuthViewModel
import br.com.wgc.ds_templates.screens.marketplacescreen.auth.WgcMarketplaceLoginScreenTemplate
import br.com.wgc.ds_templates.screens.marketplacescreen.auth.WgcMarketplaceRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.marketplacescreen.auth.WgcMarketplaceResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.quickfooddelivery.auth.FakeNineNineAuthViewModel
import br.com.wgc.ds_templates.screens.quickfooddelivery.auth.WgcNineNineLoginScreenTemplate
import br.com.wgc.ds_templates.screens.quickfooddelivery.auth.WgcNineNineRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishForgotPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishLoginScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.quickfooddelivery.auth.WgcNineNineResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.dealmarketplace.auth.FakeShopeeAuthViewModel
import br.com.wgc.ds_templates.screens.dealmarketplace.auth.WgcShopeeLoginScreenTemplate
import br.com.wgc.ds_templates.screens.dealmarketplace.auth.WgcShopeeRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.dealmarketplace.auth.WgcShopeeResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.ridehailing.auth.FakeRideHailingAuthViewModel
import br.com.wgc.ds_templates.screens.ridehailing.auth.WgcRideHailingLoginScreenTemplate
import br.com.wgc.ds_templates.screens.ridehailing.auth.WgcRideHailingRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.ridehailing.auth.WgcRideHailingResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.community.klok.WgcKlokAuthScreenTemplate
import br.com.wgc.ds_templates.screens.community.split.WgcSplitCardAuthScreenTemplate
import br.com.wgc.ds_templates.screens.community.wave.WgcWaveAuthScreenTemplate

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
    brand: WgcBrand = WgcBrand.FoodDelivery,
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
            WgcBrand.FoodDelivery -> {
                val vm = FakeFoodDeliveryAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcFoodDeliveryLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcFoodDeliveryRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcFoodDeliveryResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.RideHailing -> {
                val vm = FakeRideHailingAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcRideHailingLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcRideHailingRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcRideHailingResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.Marketplace -> {
                val vm = FakeMarketplaceAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcMarketplaceLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcMarketplaceRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcMarketplaceResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.QuickFoodDelivery -> {
                val vm = FakeNineNineAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcNineNineLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcNineNineRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcNineNineResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.DealMarketplace -> {
                val vm = FakeShopeeAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcShopeeLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcShopeeRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcShopeeResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.GlobalMarketplace -> {
                val vm = FakeAliExpressAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcAliExpressLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcAliExpressRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcAliExpressResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
            }
            WgcBrand.ClockAuth -> {
                WgcKlokAuthScreenTemplate(
                    onNavigateToForgotPassword = onNavigateToResetPassword
                )
            }
            WgcBrand.WaveAuth -> {
                WgcWaveAuthScreenTemplate(
                    onNavigateToForgotPassword = onNavigateToResetPassword
                )
            }
            WgcBrand.SplitAuth -> {
                WgcSplitCardAuthScreenTemplate(
                    onNavigateToForgotPassword = onNavigateToResetPassword
                )
            }
            WgcBrand.TrendFashion -> {
                when (flow) {
                    WgcAuthFlow.Login -> WgcStylishLoginScreenTemplate(
                        onLoginClick = onNavigateToRegister,
                        onForgotPasswordClick = onNavigateToResetPassword,
                        onSignUpClick = onNavigateToRegister
                    )
                    WgcAuthFlow.Register -> WgcStylishRegisterScreenTemplate(
                        onCreateAccountClick = onNavigateToLogin,
                        onSignInClick = onNavigateToLogin
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcStylishForgotPasswordScreenTemplate(
                        onSubmitClick = onNavigateToLogin,
                        onBackToLoginClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.MegaStore -> {
                when (flow) {
                    WgcAuthFlow.Login -> br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeLoginScreenTemplate(
                        onContinueClick = onNavigateToRegister,
                        onCreateAccountClick = onNavigateToRegister
                    )
                    WgcAuthFlow.Register -> br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeStartScreenTemplate(
                        onGetStartedClick = onNavigateToRegister,
                        onLoginClick = onNavigateToLogin
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeOtpRecoveryScreenTemplate(
                        onSubmitClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.Retail -> {
                when (flow) {
                    WgcAuthFlow.Login -> br.com.wgc.ds_templates.screens.retail.auth.WgcKutukuLoginScreen(
                        onSignInClick = onNavigateToRegister,
                        onSignUpClick = onNavigateToRegister,
                        onForgotPasswordClick = onNavigateToResetPassword
                    )
                    WgcAuthFlow.Register -> br.com.wgc.ds_templates.screens.retail.auth.WgcKutukuLoginScreen(
                        onSignInClick = onNavigateToLogin,
                        onSignUpClick = onNavigateToLogin,
                        onForgotPasswordClick = onNavigateToResetPassword
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.retail.auth.WgcKutukuOnboardingScreen(
                        onGetStartedClick = onNavigateToLogin,
                        onSignInClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.Apparel -> {
                when (flow) {
                    WgcAuthFlow.Login -> br.com.wgc.ds_templates.screens.apparel.auth.WgcClotheeSignInTemplate(
                        onContinueClick = onNavigateToRegister,
                        onCreateAccountClick = onNavigateToRegister,
                        onForgotPasswordClick = onNavigateToResetPassword
                    )
                    WgcAuthFlow.Register -> br.com.wgc.ds_templates.screens.apparel.auth.WgcClotheeSignInTemplate(
                        onContinueClick = onNavigateToLogin,
                        onCreateAccountClick = onNavigateToLogin,
                        onForgotPasswordClick = onNavigateToResetPassword
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.apparel.auth.WgcClotheeForgotPasswordTemplate(
                        onContinueClick = onNavigateToLogin,
                        onBackClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.CuratedMarket -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register -> br.com.wgc.ds_templates.screens.curatedmarket.profile.WgcTasselProfileTemplate(
                        onBackClick = onNavigateToLogin
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.curatedmarket.profile.WgcTasselProfileTemplate(
                        onBackClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.FreshGrocery -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.freshgrocery.splash.WgcShopperSplashTemplate(
                        onGetStartedClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.GadgetShop -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.gadgetshop.onboarding.WgcNexkartOnboardingTemplate(
                        onNextClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.QuickShop -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.quickshop.onboarding.WgcShopEaseOnboardingTemplate(
                        onNextClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.PersonalFinance -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.personalfinance.onboarding.WgcOrganizzeOnboardingTemplate(
                        onGetStartedClick = onNavigateToRegister,
                        onLoginClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.PropertyRental -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.propertyrental.profile.WgcPropertyRentalProfileTemplate(
                        onMyVisitsClick = onNavigateToLogin,
                        onMyProposalsClick = onNavigateToRegister
                    )
                }
            }
            WgcBrand.PropertyListing -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.propertylisting.profile.WgcPropertyListingProfileTemplate(
                        onMessagesClick = onNavigateToLogin,
                        onAdvertisePropertyClick = onNavigateToRegister
                    )
                }
            }
            WgcBrand.PropertyClassifieds -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.propertyclassifieds.profile.WgcZapProfileTemplate(
                        onAnnouncePropertyClick = onNavigateToRegister,
                        onMyPropertiesClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.GymFitness -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.gymfitness.profile.WgcGymFitnessProfilePassTemplate(
                        user = br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessMockData.mockUser,
                        onBackClick = onNavigateToLogin,
                        onManagePlan = onNavigateToRegister
                    )
                }
            }
            WgcBrand.CorporateWellness -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.corporatewellness.plans.WgcCorporateWellnessPlansTemplate(
                        plans = br.com.wgc.ds_templates.screens.corporatewellness.model.CorporateWellnessMockData.mockPlans,
                        currentTier = br.com.wgc.design_system.components.cards.WgcCorporateWellnessPlanTier.GOLD,
                        onBackClick = onNavigateToLogin
                    )
                }
            }
            WgcBrand.GuidedTraining -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.guidedtraining.activity.WgcNtcActivityTemplate(
                        stats = br.com.wgc.ds_templates.screens.guidedtraining.model.GuidedTrainingMockData.mockStats
                    )
                }
            }
            WgcBrand.Hypermarket -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.hypermarket.discounts.WgcExtraDiscountsTemplate(
                        coupons = br.com.wgc.ds_templates.screens.hypermarket.model.HypermarketMockData.mockCoupons,
                        userCpfMasked = br.com.wgc.ds_templates.screens.hypermarket.model.HypermarketMockData.mockUser.cpfMasked
                    )
                }
            }
            WgcBrand.PremiumGrocery -> {
                when (flow) {
                    WgcAuthFlow.Login,
                    WgcAuthFlow.Register,
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.premiumgrocery.profile.WgcPdaClienteMaisProfileTemplate(
                        userProfile = br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData.defaultUser
                    )
                }
            }
            WgcBrand.Boutique -> {
                when (flow) {
                    WgcAuthFlow.Login -> br.com.wgc.ds_templates.screens.boutique.auth.WgcLazaSignInScreenTemplate(
                        onEmailSignInClick = onNavigateToRegister,
                        onCreateAccountClick = onNavigateToRegister
                    )
                    WgcAuthFlow.Register -> br.com.wgc.ds_templates.screens.boutique.auth.WgcLazaEmailSignInTemplate(
                        onSignInClick = onNavigateToLogin
                    )
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> br.com.wgc.ds_templates.screens.boutique.auth.WgcLazaIntroScreenTemplate(
                        onGetStartedClick = onNavigateToLogin,
                        onSkipClick = onNavigateToLogin
                    )
                }
            }
            else -> {
                val vm = FakeShopeeAuthViewModel()
                when (flow) {
                    WgcAuthFlow.Login -> WgcShopeeLoginScreenTemplate(vm, onNavigateToRegister, onNavigateToResetPassword)
                    WgcAuthFlow.Register -> WgcShopeeRegisterScreenTemplate(vm, onNavigateToLogin)
                    WgcAuthFlow.ResetPassword,
                    WgcAuthFlow.OtpVerification -> WgcShopeeResetPasswordScreenTemplate(vm, onNavigateToLogin)
                }
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

@Preview(name = "WgcAuthFactory - Default Food Delivery", showBackground = true)
@Composable
private fun WgcAuthFactoryDefaultPreview() {
    WgcAuthFactory()
}

@Preview(name = "WgcAuthFactory - Ride Hailing Register", showBackground = true)
@Composable
private fun WgcAuthFactoryRideHailingRegisterPreview() {
    WgcAuthFactory(brand = WgcBrand.RideHailing, flow = WgcAuthFlow.Register)
}
