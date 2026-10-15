package br.com.wgc.design_system.coordinators.auth

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
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador Universal de Fluxo de Autenticação (WgcAuthFlowCoordinator).
 *
 * Orquestra as etapas de autenticação (Login, Cadastro, Recuperação de Senha, OTP)
 * oferecendo defaults sensatos e permitindo customizar a variante global ou
 * sobrescrever cirurgicamente telas individuais via variants ou slots.
 */
@Composable
fun WgcAuthFlowCoordinator(
    step: WgcAuthStep = WgcAuthStep.Login,
    modifier: Modifier = Modifier,
    variant: WgcAuthVariant = WgcAuthVariant.FOOD_DELIVERY,
    loginVariant: WgcLoginVariant? = null,
    registerVariant: WgcRegisterVariant? = null,
    resetPasswordVariant: WgcResetPasswordVariant? = null,
    otpVariant: WgcOtpVariant? = null,
    loginScreen: @Composable () -> Unit = {
        WgcLoginFactory(modifier = modifier, variant = loginVariant ?: variant.toLoginVariant())
    },
    registerScreen: @Composable () -> Unit = {
        WgcRegisterFactory(modifier = modifier, variant = registerVariant ?: variant.toRegisterVariant())
    },
    resetPasswordScreen: @Composable () -> Unit = {
        WgcResetPasswordFactory(
            modifier = modifier,
            variant = resetPasswordVariant ?: variant.toResetPasswordVariant()
        )
    },
    otpScreen: @Composable () -> Unit = {
        WgcOtpFactory(modifier = modifier, variant = otpVariant ?: variant.toOtpVariant())
    }
) {
    when (step) {
        WgcAuthStep.Login -> loginScreen()
        WgcAuthStep.Register -> registerScreen()
        WgcAuthStep.ResetPassword -> resetPasswordScreen()
        WgcAuthStep.Otp -> otpScreen()
    }
}

@Preview(name = "WgcAuthFlowCoordinator - Login", showBackground = true)
@Composable
private fun WgcAuthFlowCoordinatorPreview() {
    WgcTheme {
        WgcAuthFlowCoordinator()
    }
}
