package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.ds_templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.ds_templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel
import br.com.wgc.ds_templates.screens.profile.FakeSettingsHubViewModel
import br.com.wgc.ds_templates.screens.profile.SettingsHubScreenTemplate
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
