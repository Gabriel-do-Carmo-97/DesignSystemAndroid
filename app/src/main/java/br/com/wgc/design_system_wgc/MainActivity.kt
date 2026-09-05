package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.buttons.secondarybutton.SecondaryClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignSystemWGCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        DesignSystemCatalogApp()
                    }
                }
            }
        }
    }
}

@Composable
fun DesignSystemCatalogApp() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Botões", "Checkboxes", "Template Login")

    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            when (selectedTab) {
                0 -> ButtonsCatalogSection()
                1 -> CheckboxCatalogSection()
                2 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
            }
        }
    }
}

@Composable
fun ButtonsCatalogSection() {
    var isLoading by remember { mutableStateOf(false) }
    var isEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Catálogo de Botões", style = MaterialTheme.typography.headlineMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { isLoading = !isLoading }) {
                Text(text = if (isLoading) "Parar Loading" else "Simular Loading")
            }
            Button(onClick = { isEnabled = !isEnabled }) {
                Text(text = if (isEnabled) "Desabilitar" else "Habilitar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "ClassicButton (Primary)", style = MaterialTheme.typography.titleMedium)
        ClassicButton(
            textButton = "Salvar Alterações",
            isEnabled = isEnabled,
            isLoading = isLoading,
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "SecondaryClassicButton", style = MaterialTheme.typography.titleMedium)
        SecondaryClassicButton(
            textButton = "Cancelar",
            isEnabled = isEnabled,
            onClick = {}
        )
    }
}

@Composable
fun CheckboxCatalogSection() {
    var checkedState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Catálogo de Checkboxes", style = MaterialTheme.typography.headlineMedium)

        CheckboxDefaults(
            label = "Aceito os termos e condições",
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )
    }
}
