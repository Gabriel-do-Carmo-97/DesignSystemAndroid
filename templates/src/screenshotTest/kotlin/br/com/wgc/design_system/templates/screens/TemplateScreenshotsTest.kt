package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.cart.templates.FakeStandardCartViewModel
import br.com.wgc.design_system.factories.cart.templates.StandardCartScreenTemplate
import br.com.wgc.design_system.factories.home.templates.fintech.FakeFintechHomeViewModel
import br.com.wgc.design_system.factories.home.templates.fintech.FintechHomeScreenTemplate
import br.com.wgc.design_system.factories.auth.templates.screen.LoginScreenTemplate
import br.com.wgc.design_system.factories.auth.templates.viewmodel.FakeLoginViewModel
import br.com.wgc.design_system.factories.profile.templates.FakeSettingsHubViewModel
import br.com.wgc.design_system.factories.profile.templates.SettingsHubScreenTemplate
import com.android.tools.screenshot.PreviewTest

class TemplateScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Login Screen Template")
    @Composable
    private fun LoginScreenTemplatePreview() {
        LoginScreenTemplate(viewModel = FakeLoginViewModel())
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Fintech Home Template")
    @Composable
    private fun FintechHomeScreenTemplatePreview() {
        FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Standard Cart Template")
    @Composable
    private fun StandardCartScreenTemplatePreview() {
        StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Settings Hub Template")
    @Composable
    private fun SettingsHubScreenTemplatePreview() {
        SettingsHubScreenTemplate(viewModel = FakeSettingsHubViewModel())
    }
}
