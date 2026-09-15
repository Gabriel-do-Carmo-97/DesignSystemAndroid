package br.com.wgc.ds_templates.screens.common.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class BrandAddressAuthUiState(
    val zipCode: String = "",
    val street: String = "",
    val number: String = "",
    val complement: String = "",
    val neighborhood: String = "",
    val city: String = "",
    val state: String = "",
    val referencePoint: String = "",
    val isLoading: Boolean = false
)

abstract class BaseBrandAddressAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<BrandAddressAuthUiState>
    abstract fun onZipCodeChange(value: String)
    abstract fun onStreetChange(value: String)
    abstract fun onNumberChange(value: String)
    abstract fun onComplementChange(value: String)
    abstract fun onNeighborhoodChange(value: String)
    abstract fun onCityChange(value: String)
    abstract fun onStateChange(value: String)
    abstract fun onReferencePointChange(value: String)
    abstract fun onSubmit()
}

class FakeBrandAddressAuthViewModel : BaseBrandAddressAuthViewModel() {
    override val uiState: StateFlow<BrandAddressAuthUiState> = MutableStateFlow(BrandAddressAuthUiState()).asStateFlow()
    override fun onZipCodeChange(value: String) {}
    override fun onStreetChange(value: String) {}
    override fun onNumberChange(value: String) {}
    override fun onComplementChange(value: String) {}
    override fun onNeighborhoodChange(value: String) {}
    override fun onCityChange(value: String) {}
    override fun onStateChange(value: String) {}
    override fun onReferencePointChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcBrandAddressRegistrationScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseBrandAddressAuthViewModel,
    brandName: String = "iFood",
    brandLogoText: String = "iF",
    brandColor: Color = Color(0xFFEA1D2C),
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcBrandAuthHeader(
                brandName = brandName,
                brandLogoText = brandLogoText,
                brandColor = brandColor,
                title = "Onde você quer receber seus pedidos?",
                subtitle = "Cadastre seu endereço de entrega padrão 2026"
            )

            SimpleTextField(value = state.zipCode, onValueChange = viewModel::onZipCodeChange, label = "CEP (Apenas números)")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                SimpleTextField(value = state.street, onValueChange = viewModel::onStreetChange, label = "Rua / Avenida", modifier = Modifier.weight(2f))
                SimpleTextField(value = state.number, onValueChange = viewModel::onNumberChange, label = "Nº", modifier = Modifier.weight(1f))
            }

            SimpleTextField(value = state.complement, onValueChange = viewModel::onComplementChange, label = "Complemento (Bloco, Apto, Casa)")
            SimpleTextField(value = state.neighborhood, onValueChange = viewModel::onNeighborhoodChange, label = "Bairro")

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                SimpleTextField(value = state.city, onValueChange = viewModel::onCityChange, label = "Cidade", modifier = Modifier.weight(2f))
                SimpleTextField(value = state.state, onValueChange = viewModel::onStateChange, label = "UF", modifier = Modifier.weight(1f))
            }

            SimpleTextField(value = state.referencePoint, onValueChange = viewModel::onReferencePointChange, label = "Ponto de Referência (Opcional)")

            WgcClassicButton(textButton = "Salvar Endereço no $brandName", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar", onClick = onBackClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BrandAddressAuthPreview() {
    MaterialTheme {
        WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel())
    }
}
