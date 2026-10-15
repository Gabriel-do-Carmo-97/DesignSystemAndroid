package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.auth.WgcLoginFactory
import br.com.wgc.design_system.factories.auth.WgcLoginVariant
import br.com.wgc.design_system.factories.auth.WgcOtpFactory
import br.com.wgc.design_system.factories.auth.WgcOtpVariant
import br.com.wgc.design_system.factories.auth.WgcRegisterFactory
import br.com.wgc.design_system.factories.auth.WgcRegisterVariant
import br.com.wgc.design_system.factories.auth.WgcResetPasswordFactory
import br.com.wgc.design_system.factories.auth.WgcResetPasswordVariant
import br.com.wgc.design_system.templates.brand.WgcBrand
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fluxos de autenticação legados disponíveis em [WgcAuthFactory].
 */
enum class WgcAuthFlow {
    Login,
    Register,
    ResetPassword,
    OtpVerification
}

/**
 * Fábrica Universal de Telas de Autenticação (WgcAuthFactory).
 *
 * Substituída pelas fábricas especializadas [WgcLoginFactory], [WgcRegisterFactory],
 * [WgcResetPasswordFactory] e [WgcOtpFactory].
 */
@Deprecated(
    message = "Utilize as fábricas especializadas WgcLoginFactory, WgcRegisterFactory ou WgcAuthFlowCoordinator",
    replaceWith = ReplaceWith("WgcLoginFactory(modifier)")
)
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
    val loginVariant = WgcLoginVariant.entries.find { it.associatedBrand == brand } ?: WgcLoginVariant.STANDARD
    val registerVariant = WgcRegisterVariant.entries.find { it.associatedBrand == brand } ?: WgcRegisterVariant.STANDARD
    val resetVariant = WgcResetPasswordVariant.entries.find { it.associatedBrand == brand }
        ?: WgcResetPasswordVariant.STANDARD
    val otpVariant = WgcOtpVariant.entries.find { it.associatedBrand == brand } ?: WgcOtpVariant.STANDARD

    when (flow) {
        WgcAuthFlow.Login -> WgcLoginFactory(
            modifier = modifier,
            variant = loginVariant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            footerSlot = footerSlot,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToResetPassword = onNavigateToResetPassword,
            onLoginSuccess = onVerified
        )
        WgcAuthFlow.Register -> WgcRegisterFactory(
            modifier = modifier,
            variant = registerVariant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            footerSlot = footerSlot,
            onNavigateToLogin = onNavigateToLogin,
            onRegisterSuccess = onVerified
        )
        WgcAuthFlow.ResetPassword -> WgcResetPasswordFactory(
            modifier = modifier,
            variant = resetVariant,
            headerSlot = headerSlot,
            inputSlot = inputSlot,
            primaryButtonSlot = primaryButtonSlot,
            footerSlot = footerSlot,
            onNavigateToLogin = onNavigateToLogin,
            onSubmitSuccess = onNavigateToLogin
        )
        WgcAuthFlow.OtpVerification -> WgcOtpFactory(
            modifier = modifier,
            variant = otpVariant,
            headerSlot = headerSlot,
            otpInputSlot = inputSlot,
            confirmButtonSlot = primaryButtonSlot,
            onConfirmOtp = { onVerified() }
        )
    }
}

@Preview(name = "WgcAuthFactory - Login Flow", showBackground = true)
@Composable
private fun WgcAuthFactoryLoginPreview() {
    WgcTheme {
        WgcAuthFactory(flow = WgcAuthFlow.Login)
    }
}

@Preview(name = "WgcAuthFactory - Register Flow", showBackground = true)
@Composable
private fun WgcAuthFactoryRegisterPreview() {
    WgcTheme {
        WgcAuthFactory(brand = WgcBrand.FoodDelivery, flow = WgcAuthFlow.Register)
    }
}

@Preview(name = "WgcAuthFactory - Reset Password Flow", showBackground = true)
@Composable
private fun WgcAuthFactoryResetPasswordPreview() {
    WgcTheme {
        WgcAuthFactory(brand = WgcBrand.FoodDelivery, flow = WgcAuthFlow.ResetPassword)
    }
}

@Preview(name = "WgcAuthFactory - OTP Verification Flow", showBackground = true)
@Composable
private fun WgcAuthFactoryOtpVerificationPreview() {
    WgcTheme {
        WgcAuthFactory(brand = WgcBrand.FoodDelivery, flow = WgcAuthFlow.OtpVerification)
    }
}
