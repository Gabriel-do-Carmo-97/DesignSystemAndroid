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
import br.com.wgc.design_system.components.auth.WgcBiometricButton
import br.com.wgc.design_system.components.auth.WgcBiometricStyle
import br.com.wgc.design_system.components.auth.WgcSocialLoginPillGroup
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonSize
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.buttons.WgcPillTabSwitch
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.buttons.WgcSegmentedButton
import br.com.wgc.design_system.components.cards.WgcCardFactory
import br.com.wgc.design_system.components.cards.WgcCardType
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.dialogs.WgcAlertDialog
import br.com.wgc.design_system.components.fields.WgcFieldFactory
import br.com.wgc.design_system.components.fields.WgcFieldType
import br.com.wgc.design_system.components.ifood.*
import br.com.wgc.design_system.components.inputs.WgcSlider
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.components.mercadolivre.*
import br.com.wgc.design_system.components.navigation.WgcMenuFactory
import br.com.wgc.design_system.components.navigation.WgcMenuType
import br.com.wgc.design_system.components.nineninefood.*
import br.com.wgc.design_system.components.radio.WgcRadioButton
import br.com.wgc.design_system.components.story.StoryState
import br.com.wgc.design_system.components.story.StoryTrayItem
import br.com.wgc.design_system.components.story.WgcStoryAvatar
import br.com.wgc.design_system.components.story.WgcStoryTray
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme
import br.com.wgc.ds_templates.brand.WgcBrand
import br.com.wgc.ds_templates.factories.WgcAuthFactory
import br.com.wgc.ds_templates.factories.WgcAuthFlow
import br.com.wgc.ds_templates.factories.WgcHomeFactory
import br.com.wgc.ds_templates.screens.community.klok.WgcKlokAuthScreenTemplate
import br.com.wgc.ds_templates.screens.community.split.WgcSplitCardAuthScreenTemplate
import br.com.wgc.ds_templates.screens.community.wave.WgcWaveAuthScreenTemplate
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
    var primarySection by remember { mutableIntStateOf(0) }
    var selectedComponentSubTab by remember { mutableIntStateOf(0) }
    var selectedTemplateSubTab by remember { mutableIntStateOf(0) }

    val primaryTabs = listOf(
        "🎨 Figma (3 Templates)",
        "🧩 Componentes (:design-system)",
        "📱 Templates (:ds-templates)",
        "🏭 Fábricas & Slots"
    )

    val figmaSubTabs = listOf(
        "1. Clean Wave Auth",
        "2. Split Card Auth",
        "3. Modern Klok Auth"
    )
    var selectedFigmaSubTab by remember { mutableIntStateOf(0) }

    val componentSubTabs = listOf(
        "WgcClassicButton", "WgcSecondaryClassicButton", "WgcIconButton", "WgcSegmentedButton",
        "WgcSwitch", "WgcRadioButton", "WgcChip", "WgcSlider", "WgcAlert", "WgcAvatar", "WgcListItem",
        "WgcStoryAvatar", "WgcStoryTray", "WgcIFoodComponents", "WgcNineNineComponents", "WgcMercadoLivreComponents",
        "WgcBiometricButton", "WgcSocialLoginPillButton", "WgcPillTabSwitch"
    )

    val templateSubTabs = listOf(
        "Figma: Clean Wave Auth", "Figma: Split Card Auth", "Figma: Modern Klok Auth",
        "Auth Multi-Brand", "Mercado Livre Home", "99Food Home", "iFood Home",
        "Instagram Story Viewer", "Home Fintech", "Home E-commerce",
        "Mapa & Tracking", "Carrinho & Checkout", "Perfil & Configurações", "Busca & Filtros", "Login"
    )

    val factorySubTabs = listOf(
        "WgcButton", "WgcMenuFactory", "WgcFieldFactory", "WgcCardFactory", "WgcAuthFactory", "WgcHomeFactory"
    )

    var selectedFactorySubTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        PrimaryTabRow(selectedTabIndex = primarySection) {
            primaryTabs.forEachIndexed { index, title ->
                Tab(
                    selected = primarySection == index,
                    onClick = { primarySection = index },
                    text = { Text(text = title, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold) }
                )
            }
        }

        when (primarySection) {
            0 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedFigmaSubTab) {
                    figmaSubTabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedFigmaSubTab == index,
                            onClick = { selectedFigmaSubTab = index },
                            text = { Text(text = title, fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            1 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedComponentSubTab) {
                    componentSubTabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedComponentSubTab == index,
                            onClick = { selectedComponentSubTab = index },
                            text = { Text(text = title) }
                        )
                    }
                }
            }
            2 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTemplateSubTab) {
                    templateSubTabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTemplateSubTab == index,
                            onClick = { selectedTemplateSubTab = index },
                            text = { Text(text = title) }
                        )
                    }
                }
            }
            3 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedFactorySubTab) {
                    factorySubTabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedFactorySubTab == index,
                            onClick = { selectedFactorySubTab = index },
                            text = { Text(text = title) }
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            when (primarySection) {
                0 -> {
                    when (selectedFigmaSubTab) {
                        0 -> WgcWaveAuthScreenTemplate()
                        1 -> WgcSplitCardAuthScreenTemplate()
                        2 -> WgcKlokAuthScreenTemplate()
                    }
                }
                1 -> {
                    when (selectedComponentSubTab) {
                        0 -> WgcClassicButtonCatalogSection()
                        1 -> WgcSecondaryClassicButtonCatalogSection()
                        2 -> WgcIconButtonCatalogSection()
                        3 -> WgcSegmentedButtonCatalogSection()
                        4 -> WgcSwitchCatalogSection()
                        5 -> WgcRadioButtonCatalogSection()
                        6 -> WgcChipCatalogSection()
                        7 -> WgcSliderCatalogSection()
                        8 -> WgcAlertCatalogSection()
                        9 -> WgcAvatarCatalogSection()
                        10 -> WgcListItemCatalogSection()
                        11 -> WgcStoryAvatarCatalogSection()
                        12 -> WgcStoryTrayCatalogSection()
                        13 -> WgcIFoodComponentsCatalogSection()
                        14 -> WgcNineNineComponentsCatalogSection()
                        15 -> WgcMercadoLivreComponentsCatalogSection()
                        16 -> WgcBiometricButtonCatalogSection()
                        17 -> WgcSocialLoginPillCatalogSection()
                        18 -> WgcPillTabSwitchCatalogSection()
                    }
                }
                2 -> {
                    when (selectedTemplateSubTab) {
                        0 -> WgcWaveAuthScreenTemplate()
                        1 -> WgcSplitCardAuthScreenTemplate()
                        2 -> WgcKlokAuthScreenTemplate()
                        3 -> MultiBrandAuthCatalogSection()
                        4 -> MercadoLivreHomeScreenTemplate(viewModel = FakeMercadoLivreHomeViewModel())
                        5 -> NineNineFoodHomeScreenTemplate(viewModel = FakeNineNineFoodHomeViewModel())
                        6 -> IFoodHomeScreenTemplate(viewModel = FakeIFoodHomeViewModel())
                        7 -> InstagramStoryViewerScreenTemplate(viewModel = FakeInstagramStoryViewerViewModel())
                        8 -> FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
                        9 -> EcommerceHomeScreenTemplate(viewModel = FakeEcommerceHomeViewModel())
                        10 -> RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
                        11 -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                        12 -> SettingsHubScreenTemplate(viewModel = FakeSettingsHubViewModel())
                        13 -> SearchAndFilterScreenTemplate(viewModel = FakeSearchAndFilterViewModel())
                        14 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
                    }
                }
                3 -> {
                    WgcFactoriesAndSlotsCatalogSection(selectedSubTab = selectedFactorySubTab)
                }
            }
        }
    }
}

// --- SEÇÕES ISOLADAS PARA CADA COMPONENTE INDIVIDUAL COM SEUS ESTADOS ---

@Composable
fun WgcClassicButtonCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcClassicButton (Todos os Estados)", style = MaterialTheme.typography.titleLarge)
        Text("1. Habilitado:")
        WgcClassicButton(textButton = "Salvar Alterações", onClick = {})
        Text("2. Carregando (Loading):")
        WgcClassicButton(textButton = "Carregando", isLoading = true, onClick = {})
        Text("3. Desabilitado:")
        WgcClassicButton(textButton = "Desabilitado", isEnabled = false, onClick = {})
    }
}

@Composable
fun WgcSecondaryClassicButtonCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcSecondaryClassicButton (Todos os Estados)", style = MaterialTheme.typography.titleLarge)
        Text("1. Habilitado:")
        WgcSecondaryClassicButton(textButton = "Cancelar Operação", onClick = {})
        Text("2. Desabilitado:")
        WgcSecondaryClassicButton(textButton = "Desabilitado", isEnabled = false, onClick = {})
    }
}

@Composable
fun WgcIconButtonCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcIconButton", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            WgcIconButton(onClick = {}, icon = Icons.Default.Star, contentDescription = "Favoritar")
        }
    }
}

@Composable
fun WgcSegmentedButtonCatalogSection() {
    var segmentIndex by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcSegmentedButton", style = MaterialTheme.typography.titleLarge)
        WgcSegmentedButton(options = listOf("Dia", "Semana", "Mês"), selectedIndex = segmentIndex, onOptionSelected = { segmentIndex = it })
    }
}

@Composable
fun WgcSwitchCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcSwitch (Todos os Estados)", style = MaterialTheme.typography.titleLarge)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { Text("Ativado & Habilitado"); WgcSwitch(checked = true, onCheckedChange = {}) }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { Text("Desativado & Habilitado"); WgcSwitch(checked = false, onCheckedChange = {}) }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { Text("Ativado & Desabilitado"); WgcSwitch(checked = true, onCheckedChange = {}, isEnabled = false) }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { Text("Desativado & Desabilitado"); WgcSwitch(checked = false, onCheckedChange = {}, isEnabled = false) }
    }
}

@Composable
fun WgcRadioButtonCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcRadioButton (Todos os Estados)", style = MaterialTheme.typography.titleLarge)
        WgcRadioButton(selected = true, label = "Selecionado & Habilitado", onClick = {}, isEnabled = true)
        WgcRadioButton(selected = false, label = "Não Selecionado & Habilitado", onClick = {}, isEnabled = true)
        WgcRadioButton(selected = true, label = "Selecionado & Desabilitado", onClick = {}, isEnabled = false)
        WgcRadioButton(selected = false, label = "Não Selecionado & Desabilitado", onClick = {}, isEnabled = false)
    }
}

@Composable
fun WgcChipCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcChip (Todos os Estados)", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcChip(label = "Selecionado", selected = true, onClick = {})
            WgcChip(label = "Não Selecionado", selected = false, onClick = {})
            WgcChip(label = "Desabilitado", selected = false, isEnabled = false, onClick = {})
        }
    }
}

@Composable
fun WgcSliderCatalogSection() {
    var value by remember { mutableFloatStateOf(0.6f) }
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcSlider (Valor: ${(value * 100).toInt()}%)", style = MaterialTheme.typography.titleLarge)
        WgcSlider(value = value, onValueChange = { value = it })
    }
}

@Composable
fun WgcAlertCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcAlert (Variantes Semânticas)", style = MaterialTheme.typography.titleLarge)
        WgcAlert(title = "Sucesso", message = "Operação concluída.", type = AlertType.SUCCESS)
        WgcAlert(title = "Erro", message = "Erro ao processar.", type = AlertType.ERROR)
        WgcAlert(title = "Aviso", message = "Atenção necessária.", type = AlertType.WARNING)
        WgcAlert(title = "Informação", message = "Dica útil.", type = AlertType.INFO)
    }
}

@Composable
fun WgcAvatarCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcAvatar (Tamanhos)", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            WgcAvatar(initials = "SM", size = 32.dp)
            WgcAvatar(initials = "MD", size = 48.dp)
            WgcAvatar(initials = "LG", size = 64.dp)
            WgcAvatar(initials = "XL", size = 96.dp)
        }
    }
}

@Composable
fun WgcListItemCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcListItem", style = MaterialTheme.typography.titleLarge)
        WgcListItem(headlineText = "Título do Item", supportingText = "Descrição de suporte do item", leadingContent = { WgcAvatar(initials = "DS") })
    }
}

@Composable
fun WgcStoryAvatarCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcStoryAvatar (Estados do Anel)", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            WgcStoryAvatar(userName = "Seu Story", isUserStory = true, onClick = {})
            WgcStoryAvatar(userName = "Maria", storyState = StoryState.UNSEEN, onClick = {})
            WgcStoryAvatar(userName = "Lucas", storyState = StoryState.CLOSE_FRIENDS, onClick = {})
            WgcStoryAvatar(userName = "Ana", storyState = StoryState.SEEN, onClick = {})
        }
    }
}

@Composable
fun WgcStoryTrayCatalogSection() {
    val sampleStories = remember {
        listOf(
            StoryTrayItem("1", "Seu Story", isUserStory = true),
            StoryTrayItem("2", "Maria", storyState = StoryState.UNSEEN),
            StoryTrayItem("3", "Lucas", storyState = StoryState.CLOSE_FRIENDS),
            StoryTrayItem("4", "Ana", storyState = StoryState.SEEN)
        )
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("WgcStoryTray (Carrossel Horizontal)", style = MaterialTheme.typography.titleLarge)
        WgcStoryTray(stories = sampleStories, onStoryClick = {})
    }
}

@Composable
fun WgcIFoodComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes iFood", style = MaterialTheme.typography.titleLarge)
        WgcIFoodAddressHeader()
        WgcIFoodCategoryGrid()
        WgcIFoodRestaurantCard(name = "McDonald's", rating = "4.8", deliveryFee = "Grátis")
        WgcIFoodStickyCartBar()
    }
}

@Composable
fun WgcNineNineComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes 99Food", style = MaterialTheme.typography.titleLarge)
        WgcNineNineAddressHeader()
        WgcNineNineCategoryGrid()
        WgcNineNineRestaurantCard(name = "Pizza Hut", rating = "4.9")
        WgcNineNineStickyCartBar()
    }
}

@Composable
fun WgcMercadoLivreComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes Mercado Livre", style = MaterialTheme.typography.titleLarge)
        WgcMercadoLivreHeader()
        WgcMercadoLivreCategoryGrid()
        WgcMercadoLivreProductCard(title = "Smart TV 50\" 4K")
    }
}

@Composable
fun MultiBrandAuthCatalogSection() {
    var selectedBrand by remember { mutableIntStateOf(0) }
    var selectedFlow by remember { mutableIntStateOf(0) }
    val brands = listOf("iFood", "Uber", "Shopee", "Mercado Livre", "99Food", "AliExpress")
    val flows = listOf("Login", "Cadastro", "Recuperar", "Endereço 2026")

    val brandColors = listOf(
        Color(0xFFEA1D2C),
        Color(0xFF111111),
        Color(0xFFEE4D2D),
        Color(0xFFFFE600),
        Color(0xFF0B2545),
        Color(0xFFFF4747)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Escolha a Marca:", style = MaterialTheme.typography.titleMedium)
        PrimaryScrollableTabRow(selectedTabIndex = selectedBrand) {
            brands.forEachIndexed { index, name ->
                Tab(selected = selectedBrand == index, onClick = { selectedBrand = index }, text = { Text(name) })
            }
        }

        Spacer(Modifier.height(8.dp))

        Text("Escolha o Fluxo:", style = MaterialTheme.typography.titleMedium)
        PrimaryScrollableTabRow(selectedTabIndex = selectedFlow) {
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
fun WgcBiometricButtonCatalogSection() {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("WgcBiometricButton (Autenticação por Impressão Digital)", style = MaterialTheme.typography.titleLarge)
        Text("1. Estilo Circular (Template 1 Figma):")
        WgcBiometricButton(label = "Login with touch", style = WgcBiometricStyle.Circular)

        Text("2. Estilo Rounded Square (Template 2 Figma):")
        WgcBiometricButton(label = "Login with touch ID", style = WgcBiometricStyle.RoundedSquare)

        Text("3. Estilo Outlined Square (Template 3 Klok Figma):")
        WgcBiometricButton(
            label = "Login with touch ID",
            style = WgcBiometricStyle.OutlinedSquare,
            borderColor = Color(0xFFFFA000)
        )
    }
}

@Composable
fun WgcSocialLoginPillCatalogSection() {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("WgcSocialLoginPillButton (Botões Sociais em Barra - Template 3 Figma)", style = MaterialTheme.typography.titleLarge)
        WgcSocialLoginPillGroup()
    }
}

@Composable
fun WgcPillTabSwitchCatalogSection() {
    var selectedTab by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("WgcPillTabSwitch (Seletor Dual-Pill - Template 3 Figma)", style = MaterialTheme.typography.titleLarge)
        WgcPillTabSwitch(
            selectedIndex = selectedTab,
            onTabSelected = { selectedTab = it },
            tabs = listOf("Login", "Register")
        )
    }
}

@Composable
fun WgcFactoriesAndSlotsCatalogSection(selectedSubTab: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when (selectedSubTab) {
            0 -> {
                Text("WgcButton - Fábrica Universal de Botões", style = MaterialTheme.typography.titleLarge)
                Text(
                    "Ponto de entrada unificado para botões do Design System com defaults de produção e variações por enum.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text("1. Padrão Absoluto (Zero Parâmetros):", style = MaterialTheme.typography.titleSmall)
                WgcButton()

                Text("2. Variantes:", style = MaterialTheme.typography.titleSmall)
                WgcButton(text = "Primary (Default)", variant = WgcButtonVariant.Primary)
                WgcButton(text = "Secondary", variant = WgcButtonVariant.Secondary)
                WgcButton(text = "Outlined", variant = WgcButtonVariant.Outlined)
                WgcButton(text = "Ghost", variant = WgcButtonVariant.Ghost)
                WgcButton(text = "Danger", variant = WgcButtonVariant.Danger)

                Text("3. Tamanhos:", style = MaterialTheme.typography.titleSmall)
                WgcButton(text = "Small (36dp)", size = WgcButtonSize.Small)
                WgcButton(text = "Medium (56dp - Default)", size = WgcButtonSize.Medium)
                WgcButton(text = "Large (64dp)", size = WgcButtonSize.Large)

                Text("4. Estado de Carregamento:", style = MaterialTheme.typography.titleSmall)
                WgcButton(text = "Processando...", isLoading = true)
            }
            1 -> {
                var menuIndex by remember { mutableIntStateOf(0) }
                Text("WgcMenuFactory - Fábrica Universal de Navegação", style = MaterialTheme.typography.titleLarge)
                Text(
                    "Alternância rápida entre estilos de menu com defaults de produção e suporte a custom slot.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text("1. ClassicBottomBar (Padrão):", style = MaterialTheme.typography.titleSmall)
                WgcMenuFactory(
                    type = WgcMenuType.ClassicBottomBar,
                    selectedIndex = menuIndex,
                    onItemSelected = { menuIndex = it }
                )

                Spacer(Modifier.height(8.dp))
                Text("2. FloatingPill:", style = MaterialTheme.typography.titleSmall)
                WgcMenuFactory(
                    type = WgcMenuType.FloatingPill,
                    selectedIndex = menuIndex,
                    onItemSelected = { menuIndex = it }
                )

                Spacer(Modifier.height(8.dp))
                Text("3. CollapsibleHeader / Tabs:", style = MaterialTheme.typography.titleSmall)
                WgcMenuFactory(
                    type = WgcMenuType.CollapsibleHeader,
                    selectedIndex = menuIndex,
                    onItemSelected = { menuIndex = it }
                )
            }
            2 -> {
                var textInput by remember { mutableStateOf("") }
                var passwordInput by remember { mutableStateOf("") }
                var otpInput by remember { mutableStateOf("") }

                Text("WgcFieldFactory - Fábrica Universal de Campos", style = MaterialTheme.typography.titleLarge)
                Text("Campos padronizados com defaults e tipagem via enum:", style = MaterialTheme.typography.bodyMedium)

                Text("1. Standard (Padrão):", style = MaterialTheme.typography.titleSmall)
                WgcFieldFactory(
                    type = WgcFieldType.Standard,
                    value = textInput,
                    onValueChange = { textInput = it },
                    label = "Nome Completo",
                    placeholderText = "Digite seu nome..."
                )

                Text("2. Search:", style = MaterialTheme.typography.titleSmall)
                WgcFieldFactory(
                    type = WgcFieldType.Search,
                    value = textInput,
                    onValueChange = { textInput = it },
                    placeholderText = "Buscar no aplicativo..."
                )

                Text("3. Password:", style = MaterialTheme.typography.titleSmall)
                WgcFieldFactory(
                    type = WgcFieldType.Password,
                    value = passwordInput,
                    onValueChange = { passwordInput = it }
                )

                Text("4. OtpCode (6 dígitos):", style = MaterialTheme.typography.titleSmall)
                WgcFieldFactory(
                    type = WgcFieldType.OtpCode,
                    value = otpInput,
                    onValueChange = { otpInput = it }
                )
            }
            3 -> {
                var customSlotEnabled by remember { mutableStateOf(false) }
                Text("WgcCardFactory - Fábrica Universal de Cards", style = MaterialTheme.typography.titleLarge)
                Text("Cards prontos para catálogo com slots customizáveis:", style = MaterialTheme.typography.bodyMedium)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Checkbox(
                        checked = customSlotEnabled,
                        onCheckedChange = { customSlotEnabled = it }
                    )
                    Text("Injetar Slot de Ação Customizado")
                }

                Text("1. ProductDetail (Padrão):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(
                    type = WgcCardType.ProductDetail,
                    title = "Pizza Especial Quatro Queijos",
                    subtitle = "Massa fina artesanal, molho pelati e queijos nobres",
                    price = "R$ 64,90",
                    badgeText = "Destaque da Semana",
                    actionSlot = if (customSlotEnabled) {
                        {
                            WgcButton(
                                text = "Adicionar",
                                size = WgcButtonSize.Small,
                                modifier = Modifier.width(120.dp)
                            )
                        }
                    } else null
                )

                Text("2. RestaurantCard:", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(
                    type = WgcCardType.RestaurantCard,
                    title = "Churrascaria Fogo Nobre",
                    subtitle = "Carnes nobres & Grelhados"
                )

                Text("3. StatusCard:", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(
                    type = WgcCardType.StatusCard,
                    title = "Pedido em Preparo",
                    subtitle = "O restaurante confirmou seu pedido #1042",
                    badgeText = "15-25 min",
                    actionSlot = if (customSlotEnabled) {
                        {
                            WgcButton(
                                text = "Rastrear",
                                variant = WgcButtonVariant.Outlined,
                                size = WgcButtonSize.Small,
                                modifier = Modifier.width(110.dp)
                            )
                        }
                    } else null
                )
            }
            4 -> {
                var authBrandIndex by remember { mutableIntStateOf(0) }
                var authFlowIndex by remember { mutableIntStateOf(0) }
                var overrideHeaderSlot by remember { mutableStateOf(false) }

                val brands = WgcBrand.entries
                val flows = WgcAuthFlow.entries

                Text("WgcAuthFactory - Fábrica Universal de Autenticação", style = MaterialTheme.typography.titleLarge)
                Text("Alterne marca e fluxo instantaneamente com defaults completos:", style = MaterialTheme.typography.bodyMedium)

                Text("Marca:", style = MaterialTheme.typography.titleSmall)
                PrimaryScrollableTabRow(selectedTabIndex = authBrandIndex) {
                    brands.forEachIndexed { idx, b ->
                        Tab(
                            selected = authBrandIndex == idx,
                            onClick = { authBrandIndex = idx },
                            text = { Text(b.brandName) }
                        )
                    }
                }

                Text("Fluxo:", style = MaterialTheme.typography.titleSmall)
                PrimaryScrollableTabRow(selectedTabIndex = authFlowIndex) {
                    flows.forEachIndexed { idx, f ->
                        Tab(
                            selected = authFlowIndex == idx,
                            onClick = { authFlowIndex = idx },
                            text = { Text(f.name) }
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Checkbox(
                        checked = overrideHeaderSlot,
                        onCheckedChange = { overrideHeaderSlot = it }
                    )
                    Text("Substituir Header via Slot Customizado")
                }

                Box(modifier = Modifier.fillMaxWidth().height(480.dp)) {
                    WgcAuthFactory(
                        brand = brands[authBrandIndex],
                        flow = flows[authFlowIndex],
                        headerSlot = if (overrideHeaderSlot) {
                            {
                                Surface(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                                ) {
                                    Text(
                                        text = "🎯 HEADER INJETADO VIA SLOT NO ${brands[authBrandIndex].brandName.uppercase()}",
                                        modifier = Modifier.padding(16.dp),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                                    )
                                }
                            }
                        } else null
                    )
                }
            }
            5 -> {
                var homeBrandIndex by remember { mutableIntStateOf(0) }
                var overrideBottomNav by remember { mutableStateOf(false) }
                val brands = WgcBrand.entries

                Text("WgcHomeFactory - Fábrica Universal de Home", style = MaterialTheme.typography.titleLarge)
                Text("Alterne telas Home completas simplesmente escolhendo a marca:", style = MaterialTheme.typography.bodyMedium)

                Text("Marca:", style = MaterialTheme.typography.titleSmall)
                PrimaryScrollableTabRow(selectedTabIndex = homeBrandIndex) {
                    brands.forEachIndexed { idx, b ->
                        Tab(
                            selected = homeBrandIndex == idx,
                            onClick = { homeBrandIndex = idx },
                            text = { Text(b.brandName) }
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Checkbox(
                        checked = overrideBottomNav,
                        onCheckedChange = { overrideBottomNav = it }
                    )
                    Text("Substituir BottomBar por FloatingPill via Slot")
                }

                Box(modifier = Modifier.fillMaxWidth().height(520.dp)) {
                    WgcHomeFactory(
                        brand = brands[homeBrandIndex],
                        bottomNavSlot = if (overrideBottomNav) {
                            {
                                WgcMenuFactory(type = WgcMenuType.FloatingPill)
                            }
                        } else null
                    )
                }
            }
        }
    }
}
