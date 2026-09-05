package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.alert.AlertType
import br.com.wgc.design_system.components.alert.WgcAlert
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.buttons.WgcSegmentedButton
import br.com.wgc.design_system.components.buttons.secondarybutton.SecondaryClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.dialogs.WgcAlertDialog
import br.com.wgc.design_system.components.inputs.WgcSlider
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.components.radio.WgcRadioButton
import br.com.wgc.design_system.components.story.StoryState
import br.com.wgc.design_system.components.story.StoryTrayItem
import br.com.wgc.design_system.components.story.WgcStoryTray
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme
import br.com.wgc.ds_templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.ds_templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel
import br.com.wgc.ds_templates.screens.map.FakeRealtimeLocationViewModel
import br.com.wgc.ds_templates.screens.map.RealtimeLocationMapScreenTemplate
import br.com.wgc.ds_templates.screens.profile.FakeSettingsHubViewModel
import br.com.wgc.ds_templates.screens.profile.SettingsHubScreenTemplate
import br.com.wgc.ds_templates.screens.search.FakeSearchAndFilterViewModel
import br.com.wgc.ds_templates.screens.search.SearchAndFilterScreenTemplate
import br.com.wgc.ds_templates.screens.social.FakeInstagramStoryViewerViewModel
import br.com.wgc.ds_templates.screens.social.InstagramStoryViewerScreenTemplate

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
    val tabs = listOf("Botões", "Inputs & Seleção", "Feedback & Diálogos", "Instagram Story", "Home Fintech", "Home E-commerce", "Mapa & Tracking", "Carrinho", "Perfil", "Busca", "Login")

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
                1 -> InputsCatalogSection()
                2 -> FeedbackCatalogSection()
                3 -> InstagramStoryCatalogSection()
                4 -> FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
                5 -> EcommerceHomeScreenTemplate(viewModel = FakeEcommerceHomeViewModel())
                6 -> RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
                7 -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                8 -> SettingsHubScreenTemplate(viewModel = FakeSettingsHubViewModel())
                9 -> SearchAndFilterScreenTemplate(viewModel = FakeSearchAndFilterViewModel())
                10 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
            }
        }
    }
}

@Composable
fun InstagramStoryCatalogSection() {
    val sampleStories = remember {
        listOf(
            StoryTrayItem("1", "Seu Story", isUserStory = true),
            StoryTrayItem("2", "Maria", storyState = StoryState.UNSEEN),
            StoryTrayItem("3", "Lucas", storyState = StoryState.CLOSE_FRIENDS),
            StoryTrayItem("4", "Ana", storyState = StoryState.SEEN)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Carrossel de Stories (WgcStoryTray)", style = MaterialTheme.typography.titleMedium)
        WgcStoryTray(stories = sampleStories, onStoryClick = {})

        HorizontalDivider()

        Text(text = "Visualizador de Story em Tela Cheia", style = MaterialTheme.typography.titleMedium)
        Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            InstagramStoryViewerScreenTemplate(viewModel = FakeInstagramStoryViewerViewModel())
        }
    }
}

@Composable
fun ButtonsCatalogSection() {
    var isLoading by remember { mutableStateOf(false) }
    var isEnabled by remember { mutableStateOf(true) }
    var segmentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Catálogo de Botões & Ações", style = MaterialTheme.typography.headlineMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { isLoading = !isLoading }) {
                Text(text = if (isLoading) "Parar Loading" else "Simular Loading")
            }
            Button(onClick = { isEnabled = !isEnabled }) {
                Text(text = if (isEnabled) "Desabilitar" else "Habilitar")
            }
        }

        ClassicButton(textButton = "Botão Primário (ClassicButton)", isEnabled = isEnabled, isLoading = isLoading, onClick = {})
        SecondaryClassicButton(textButton = "Botão Secundário", isEnabled = isEnabled, onClick = {})

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcIconButton(onClick = {}, icon = Icons.Default.Star, contentDescription = "Favorito")
        }

        WgcSegmentedButton(
            options = listOf("Opção 1", "Opção 2", "Opção 3"),
            selectedIndex = segmentIndex,
            onOptionSelected = { segmentIndex = it }
        )
    }
}

@Composable
fun InputsCatalogSection() {
    var checkedState by remember { mutableStateOf(false) }
    var switchState by remember { mutableStateOf(true) }
    var radioState by remember { mutableStateOf(true) }
    var chipState by remember { mutableStateOf(true) }
    var sliderValue by remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Catálogo de Entradas & Seleção", style = MaterialTheme.typography.headlineMedium)

        CheckboxDefaults(
            label = "Aceito os termos e condições",
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Interruptor (Switch)")
            WgcSwitch(checked = switchState, onCheckedChange = { switchState = it })
        }

        WgcRadioButton(
            selected = radioState,
            label = "Opção de Rádio Selecionada",
            onClick = { radioState = !radioState }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcChip(label = "Filtro Ativo", selected = chipState, onClick = { chipState = !chipState })
            WgcChip(label = "Filtro Inativo", selected = false, onClick = {})
        }

        Text(text = "Slider: ${(sliderValue * 100).toInt()}%")
        WgcSlider(value = sliderValue, onValueChange = { sliderValue = it })
    }
}

@Composable
fun FeedbackCatalogSection() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Catálogo de Feedback & Listas", style = MaterialTheme.typography.headlineMedium)

        WgcAlert(title = "Sucesso", message = "Operação executada com sucesso.", type = AlertType.SUCCESS)
        WgcAlert(title = "Erro", message = "Falha no processamento.", type = AlertType.ERROR)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcAvatar(initials = "WG")
            Text("Avatar de Usuário com Iniciais")
        }

        WgcListItem(
            headlineText = "Item de Lista Principal",
            supportingText = "Subtítulo explicativo com ação",
            leadingContent = { WgcAvatar(initials = "DS") }
        )

        Button(onClick = { showDialog = true }) {
            Text("Abrir Diálogo de Alerta")
        }

        if (showDialog) {
            WgcAlertDialog(
                onDismissRequest = { showDialog = false },
                title = "Confirmação de Ação",
                message = "Deseja realmente aplicar esta alteração no sistema?",
                onConfirmClick = { showDialog = false },
                onDismissClick = { showDialog = false }
            )
        }
    }
}
