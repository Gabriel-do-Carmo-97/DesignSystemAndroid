package br.com.wgc.ds_templates.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LoginScreenTemplate(
    modifier: Modifier = Modifier,
    imageLogo: String = "",
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }
}


@Preview(showBackground = true, name = "Only Component")
@Composable
private fun LoginScreenTemplatePreview() {
    LoginScreenTemplate()
}

@Preview(showSystemUi = true, showBackground = true, name = "Component and SystemUi")
@Composable
private fun LoginScreenTemplatePreview2() {
    LoginScreenTemplate()
}