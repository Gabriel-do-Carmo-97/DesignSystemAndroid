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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.alert.AlertType
import br.com.wgc.design_system.components.alert.WgcAlert
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.buttons.WgcSegmentedButton
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
import br.com.wgc.ds_templates.screens.aliexpress.auth.*
import br.com.wgc.ds_templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.ds_templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.ds_templates.screens.common.auth.FakeBrandAddressAuthViewModel
import br.com.wgc.ds_templates.screens.common.auth.WgcBrandAddressRegistrationScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.ds_templates.screens.ifood.FakeIFoodHomeViewModel
import br.com.wgc.ds_templates.screens.ifood.IFoodHomeScreenTemplate
import br.com.wgc.ds_templates.screens.ifood.auth.*
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel
import br.com.wgc.ds_templates.screens.map.FakeRealtimeLocationViewModel
import br.com.wgc.ds_templates.screens.map.RealtimeLocationMapScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.FakeMercadoLivreHomeViewModel
import br.com.wgc.ds_templates.screens.mercadolivre.MercadoLivreHomeScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.auth.*
import br.com.wgc.ds_templates.screens.nineninefood.FakeNineNineFoodHomeViewModel
import br.com.wgc.ds_templates.screens.nineninefood.NineNineFoodHomeScreenTemplate
import br.com.wgc.ds_templates.screens.nineninefood.auth.*
import br.com.wgc.ds_templates.screens.profile.FakeSettingsHubViewModel
import br.com.wgc.ds_templates.screens.profile.SettingsHubScreenTemplate
import br.com.wgc.ds_templates.screens.search.FakeSearchAndFilterViewModel
import br.com.wgc.ds_templates.screens.search.SearchAndFilterScreenTemplate
import br.com.wgc.ds_templates.screens.shopee.auth.*
import br.com.wgc.ds_templates.screens.social.FakeInstagramStoryViewerViewModel
import br.com.wgc.ds_templates.screens.social.InstagramStoryViewerScreenTemplate
import br.com.wgc.ds_templates.screens.uber.auth.*

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
    val tabs = listOf("Auth Multi-Brand", "Botões", "Inputs & Seleção", "Feedback & Diálogos", "Mercado Livre Home", "99Food Home", "iFood Home", "Instagram Story", "Home Fintech", "Home E-commerce", "Mapa & Tracking", "Carrinho", "Perfil", "Busca", "Login")

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
                0 -> MultiBrandAuthCatalogSection()
                1 -> ButtonsCatalogSection()
                2 -> InputsCatalogSection()
                3 -> FeedbackCatalogSection()
                4 -> MercadoLivreHomeScreenTemplate(viewModel = FakeMercadoLivreHomeViewModel())
                5 -> NineNineFoodHomeScreenTemplate(viewModel = FakeNineNineFoodHomeViewModel())
                6 -> IFoodHomeScreenTemplate(viewModel = FakeIFoodHomeViewModel())
                7 -> InstagramStoryCatalogSection()
                8 -> FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
                9 -> EcommerceHomeScreenTemplate(viewModel = FakeEcommerceHomeViewModel())
                10 -> RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
                11 -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                12 -> SettingsHubScreenTemplate(viewModel = FakeSettingsHubViewModel())
                13 -> SearchAndFilterScreenTemplate(viewModel = FakeSearchAndFilterViewModel())
                14 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
            }
        }
    }
}

@Composable
fun MultiBrandAuthCatalogSection() {
    var selectedBrand by remember { mutableStateOf(0) }
    var selectedFlow by remember { mutableStateOf(0) }
    val brands = listOf("iFood", "Uber", "Shopee", "Mercado Livre", "99Food", "AliExpress")
    val flows = listOf("Login", "Cadastro", "Recuperar", "Endereço 2026")

    val brandColors = listOf(
        Color(0xFFEA1D2C), // iFood Red
        Color(0xFF111111), // Uber Black
        Color(0xFFEE4D2D), // Shopee Orange
        Color(0xFFFFE600), // Mercado Livre Yellow
        Color(0xFF0B2545), // 99Food Dark Blue
        Color(0xFFFF4747)  // AliExpress Red
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Escolha a Marca:", style = MaterialTheme.typography.titleMedium)
        ScrollableTabRow(selectedTabIndex = selectedBrand) {
            brands.forEachIndexed { index, name ->
                Tab(selected = selectedBrand == index, onClick = { selectedBrand = index }, text = { Text(name) })
            }
        }

        Spacer(Modifier.height(8.dp))

        Text("Escolha o Fluxo:", style = MaterialTheme.typography.titleMedium)
        ScrollableTabRow(selectedTabIndex = selectedFlow) {
            flows.forEachIndexed { index, name ->
                Tab(selected = selectedFlow == index, onClick = { selectedFlow = index }, text = { Text(name) })
            }
        }

        Spacer(Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedBrand) {
                0 -> when (selectedFlow) {
                    0 -> WgcIFoodLoginScreenTemplate(viewModel = FakeIFoodAuthViewModel())
                    1 -> WgcIFoodRegisterScreenTemplate(viewModel = FakeIFoodAuthViewModel())
                    2 -> WgcIFoodResetPasswordScreenTemplate(viewModel = FakeIFoodAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "iFood", brandLogoText = "iF", brandColor = brandColors[0])
                }
                1 -> when (selectedFlow) {
                    0 -> WgcUberLoginScreenTemplate(viewModel = FakeUberAuthViewModel())
                    1 -> WgcUberRegisterScreenTemplate(viewModel = FakeUberAuthViewModel())
                    2 -> WgcUberResetPasswordScreenTemplate(viewModel = FakeUberAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Uber", brandLogoText = "Uber", brandColor = brandColors[1])
                }
                2 -> when (selectedFlow) {
                    0 -> WgcShopeeLoginScreenTemplate(viewModel = FakeShopeeAuthViewModel())
                    1 -> WgcShopeeRegisterScreenTemplate(viewModel = FakeShopeeAuthViewModel())
                    2 -> WgcShopeeResetPasswordScreenTemplate(viewModel = FakeShopeeAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Shopee", brandLogoText = "S", brandColor = brandColors[2])
                }
                3 -> when (selectedFlow) {
                    0 -> WgcMercadoLivreLoginScreenTemplate(viewModel = FakeMercadoLivreAuthViewModel())
                    1 -> WgcMercadoLivreRegisterScreenTemplate(viewModel = FakeMercadoLivreAuthViewModel())
                    2 -> WgcMercadoLivreResetPasswordScreenTemplate(viewModel = FakeMercadoLivreAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Mercado Livre", brandLogoText = "ML", brandColor = brandColors[3])
                }
                4 -> when (selectedFlow) {
                    0 -> WgcNineNineLoginScreenTemplate(viewModel = FakeNineNineAuthViewModel())
                    1 -> WgcNineNineRegisterScreenTemplate(viewModel = FakeNineNineAuthViewModel())
                    2 -> WgcNineNineResetPasswordScreenTemplate(viewModel = FakeNineNineAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "99Food", brandLogoText = "99", brandColor = brandColors[4])
                }
                5 -> when (selectedFlow) {
                    0 -> WgcAliExpressLoginScreenTemplate(viewModel = FakeAliExpressAuthViewModel())
                    1 -> WgcAliExpressRegisterScreenTemplate(viewModel = FakeAliExpressAuthViewModel())
                    2 -> WgcAliExpressResetPasswordScreenTemplate(viewModel = FakeAliExpressAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "AliExpress", brandLogoText = "Ali", brandColor = brandColors[5])
                }
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

        WgcClassicButton(textButton = "Botão Primário (WgcClassicButton)", isEnabled = isEnabled, isLoading = isLoading, onClick = {})
        WgcSecondaryClassicButton(textButton = "Botão Secundário (WgcSecondaryClassicButton)", isEnabled = isEnabled, onClick = {})

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
