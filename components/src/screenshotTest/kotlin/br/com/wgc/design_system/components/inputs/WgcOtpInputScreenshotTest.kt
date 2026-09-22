package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest

class WgcOtpInputScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "OTP Input 6 Digits")
    @Composable
    private fun OtpInputSixDigitsPreview() {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcOtpInput(
                otpValue = "123",
                onOtpChange = {},
                length = 6
            )
        }
    }

    @PreviewTest
    @Preview(showBackground = true, name = "OTP Input 4 Digits Masked")
    @Composable
    private fun OtpInputFourDigitsMaskedPreview() {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcOtpInput(
                otpValue = "1234",
                onOtpChange = {},
                length = 4,
                isMasked = true
            )
        }
    }

    @PreviewTest
    @Preview(showBackground = true, name = "OTP Input Error State")
    @Composable
    private fun OtpInputErrorStatePreview() {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcOtpInput(
                otpValue = "987",
                onOtpChange = {},
                length = 6,
                isError = true,
                errorMessage = "Código inválido"
            )
        }
    }
}
