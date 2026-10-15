package br.com.wgc.design_system.factories.address

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Cadastro de Novo Endereço (WgcAddressRegistrationFactory).
 */
@Composable
fun WgcAddressRegistrationFactory(
    modifier: Modifier = Modifier,
    customFormSlot: (@Composable () -> Unit)? = null,
    onSaveAddress: (WgcSavedAddressItem) -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text("Cadastrar Novo Endereço")

            if (customFormSlot != null) {
                customFormSlot()
            } else {
                DefaultAddressForm()
            }

            WgcButton(
                text = "Salvar Endereço",
                onClick = {
                    onSaveAddress(
                        WgcSavedAddressItem(
                            id = System.currentTimeMillis().toString(),
                            title = "Novo Endereço",
                            street = "Rua Cadastrada",
                            number = "123",
                            city = "São Paulo",
                            state = "SP",
                            zipCode = "01000-000"
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun DefaultAddressForm() {
    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
        SimpleTextField(value = "", onValueChange = {}, label = "Apelido (ex: Casa, Trabalho)")
        SimpleTextField(value = "", onValueChange = {}, label = "CEP")
        SimpleTextField(value = "", onValueChange = {}, label = "Logradouro (Rua, Av.)")
        SimpleTextField(value = "", onValueChange = {}, label = "Número e Complemento")
        SimpleTextField(value = "", onValueChange = {}, label = "Bairro")
        SimpleTextField(value = "", onValueChange = {}, label = "Cidade e Estado")
    }
}

@Preview(name = "WgcAddressRegistrationFactory - Preview", showBackground = true)
@Composable
private fun WgcAddressRegistrationFactoryPreview() {
    WgcTheme {
        WgcAddressRegistrationFactory()
    }
}
