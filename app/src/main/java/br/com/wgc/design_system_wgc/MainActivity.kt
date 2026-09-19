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
import androidx.compose.ui.unit.sp
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
import br.com.wgc.design_system.components.cards.WgcMerchantListingCard
import br.com.wgc.design_system.components.cards.WgcPromotionalProductCard
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcFloatingCartSummaryBar
import br.com.wgc.design_system.components.navigation.WgcMarketplaceSearchHeaderBar
import br.com.wgc.design_system.components.sections.WgcCircularCategoryRow
import br.com.wgc.design_system.components.sections.WgcDepartmentCategoryGrid
import br.com.wgc.design_system.components.inputs.WgcSlider
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.components.navigation.WgcMenuFactory
import br.com.wgc.design_system.components.navigation.WgcMenuType
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
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.*
import br.com.wgc.ds_templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.ds_templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.ds_templates.screens.common.auth.FakeBrandAddressAuthViewModel
import br.com.wgc.ds_templates.screens.common.auth.WgcBrandAddressRegistrationScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.ds_templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.ds_templates.screens.fooddelivery.FakeFoodDeliveryHomeViewModel
import br.com.wgc.ds_templates.screens.fooddelivery.WgcFoodDeliveryHomeScreenTemplate
import br.com.wgc.ds_templates.screens.fooddelivery.auth.*
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel
import br.com.wgc.ds_templates.screens.map.FakeRealtimeLocationViewModel
import br.com.wgc.ds_templates.screens.map.RealtimeLocationMapScreenTemplate
import br.com.wgc.ds_templates.screens.marketplacescreen.FakeMarketplaceHomeViewModel
import br.com.wgc.ds_templates.screens.marketplacescreen.WgcMarketplaceHomeScreenTemplate
import br.com.wgc.ds_templates.screens.marketplacescreen.auth.*
import br.com.wgc.ds_templates.screens.quickfooddelivery.FakeQuickFoodDeliveryHomeViewModel
import br.com.wgc.ds_templates.screens.quickfooddelivery.WgcQuickFoodDeliveryHomeScreenTemplate
import br.com.wgc.ds_templates.screens.quickfooddelivery.auth.*
import br.com.wgc.ds_templates.screens.profile.FakeSettingsHubViewModel
import br.com.wgc.ds_templates.screens.profile.SettingsHubScreenTemplate
import br.com.wgc.ds_templates.screens.search.FakeSearchAndFilterViewModel
import br.com.wgc.ds_templates.screens.search.SearchAndFilterScreenTemplate
import br.com.wgc.ds_templates.screens.dealmarketplace.auth.*
import br.com.wgc.ds_templates.screens.globalmarketplace.auth.*
import br.com.wgc.ds_templates.screens.social.FakeInstagramStoryViewerViewModel
import br.com.wgc.ds_templates.screens.social.InstagramStoryViewerScreenTemplate
import br.com.wgc.ds_templates.screens.ridehailing.auth.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import br.com.wgc.ds_templates.factories.WgcProfileFactory
import br.com.wgc.ds_templates.factories.WgcProfileType
import br.com.wgc.ds_templates.factories.WgcProfileStatus

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

@Suppress("LongMethod", "CyclomaticComplexMethod")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignSystemCatalogApp() {
    var selectedModule by remember { mutableStateOf<br.com.wgc.design_system_wgc.showcase.DsModule?>(null) }

    if (selectedModule == null) {
        br.com.wgc.design_system_wgc.showcase.DsModuleHubScreen(
            onSelectModule = { selectedModule = it }
        )
        return
    }

    when (selectedModule) {
        br.com.wgc.design_system_wgc.showcase.DsModule.CORE -> {
            br.com.wgc.design_system_wgc.showcase.CoreTokensShowcase(
                onBack = { selectedModule = null }
            )
            return
        }
        br.com.wgc.design_system_wgc.showcase.DsModule.NAVIGATION_FLOWS -> {
            br.com.wgc.design_system_wgc.showcase.NavigationFlowsShowcase(
                onBack = { selectedModule = null }
            )
            return
        }
        else -> Unit
    }

    var primarySection by remember { mutableIntStateOf(0) }
    var selectedComponentSubTab by remember { mutableIntStateOf(0) }
    var selectedTemplateSubTab by remember { mutableIntStateOf(0) }

    // Alinhamento automático com o módulo selecionado
    LaunchedEffect(selectedModule) {
        if (selectedModule == br.com.wgc.design_system_wgc.showcase.DsModule.COMPONENTS) {
            primarySection = 71 // Tab de componentes (:design-system)
        } else if (selectedModule == br.com.wgc.design_system_wgc.showcase.DsModule.TEMPLATES) {
            primarySection = 73 // Tab de Fábricas & Templates (:ds-templates)
        }
    }

    val primaryTabs = listOf(
        // 0-2: Cat 1 - Imobiliárias
        "🏠 Locação Imobiliária (PropertyRental)",
        "🏡 Classificados Imobiliários (PropertyListing)",
        "🏢 Inteligência Imobiliária (PropertyClassifieds)",
        // 3-5: Cat 2 - Fitness
        "🏋️ Treinos & Academia (Gym & Fitness)",
        "💪 Bem-Estar Corporativo (CorporateWellness)",
        "⚡ Treinos Guiados & Metas (Guided Training)",
        // 6-8: Cat 3 - Supermercados
        "🛒 Hipermercado & Descontos (Hypermarket)",
        "🍇 Varejo Premium & Adega (Premium Grocery)",
        "🏪 Supermercado & Nutri-Score (Grocery Store)",
        // 9-11: Cat 4 - Farmácias
        "💊 Farmácia Digital & Receitas (Pharmacy Chain)",
        "🏥 Cuidados Farmacêuticos (Care Pharmacy)",
        "💚 Farmácia Popular (Popular Pharmacy)",
        // 12-14: Cat 5 - FinTech
        "💜 Fintech Neobank (Digital Bank)",
        "🧡 Fintech SuperApp (Shopping & Invest)",
        "🖤 Fintech Carbon (Global Bank)",
        // 15-17: Cat 6 - Mobilidade
        "🟡 Mobilidade Urbana (Urban Mobility)",
        "🟢 Viagens por Lances (Bidding Rides)",
        "🚌 Passagens Rodoviárias (Bus Travel)",
        // 18-20: Cat 7 - Viagem
        "✈️ Viagens & Passagens Aéreas (Flight Travel)",
        "🏡 Hospedagem & Acomodações (Hospitality)",
        "🌐 Reserva de Hotéis (HotelBooking)",
        // 21-23: Cat 8 - Streaming
        "🔴 Streaming de Vídeo (Video Stream)",
        "🟢 Streaming de Áudio (Audio Stream)",
        "🟠 Transmissão & TV Ao Vivo (Broadcast Stream)",
        // 24-26: Cat 9 - Educação
        "🦜 Aprendizado de Idiomas (Language Learning)",
        "🔵 Educação Tech (Tech Education)",
        "🟣 Marketplace de Cursos (Course Marketplace)",
        // 27-29: Cat 10 - Mensageria
        "💬 Mensageria Direta (Direct Messaging)",
        "✈️ Mensageria em Canais (Channel Messaging)",
        "📌 Descoberta Visual (Visual Discovery)",
        // 30-32: Cat 11 - Gaming
        "🎮 Jogos Digitais (Gaming Store)",
        "🟣 Transmissão Ao Vivo (Live Streaming)",
        "💙 Comunidades & Chat (Community Chat)",
        // 33-35: Cat 12 - Produtividade
        "⬛ Workspace & Notas (Workspace Docs)",
        "🟦 Gestão Kanban (Kanban Tasks)",
        "🟪 Colaboração em Equipe (Team Collaboration)",
        // 36-38: Cat 13 - Fast Food
        "🍔 Fast Food Burger (Burger FastFood)",
        "🔥 Fast Food Grelhado (Flame FastFood)",
        "🍕 Pizzaria & Delivery (Pizza Delivery)",
        // 39-41: Cat 14 - Logística
        "🚗 Caronas Compartilhadas (Carpooling)",
        "📦 Envio Expresso & Logística (Express Logistics)",
        "🟠 Frete & Cargas (Freight Logistics)",
        // 42-44: Cat 15 - Moda Fast Fashion
        "🔴 Departamentos Moda (Department Fashion)",
        "🛍️ Moda Urbana (Urban Fashion)",
        "⬛ Tendências em Moda (Trend Apparel)",
        // 45-47: Cat 16 - Beleza
        "🌿 Perfumaria & Beleza (Fragrance & Beauty)",
        "🟠 Beleza Natural (Natural Beauty)",
        "⬛ Cosméticos de Luxo (Prestige Beauty)",
        // 48-50: Cat 17 - Pet Care
        "🐾 Cuidados Pet (Pet Care)",
        "🐕 Superloja Pet (Pet Superstore)",
        "🖤 Estilo de Vida Pet (Pet Lifestyle)",
        // 51-53: Cat 18 - Casa & Decor
        "🟢 Casa & Construção (Home Improvement)",
        "🔴 Móveis & Decoração (Designer Furniture)",
        "🟠 Marketplace Moveleiro (Home Marketplace)",
        // 54-56: Cat 19 - Notícias
        "🔴 Portal Noticioso (Daily News)",
        "🟡 Rede de Notícias (Media Network)",
        "🔵 Notícias de Negócios (Business News)",
        // 57-59: Cat 20 - Serviços Públicos
        "🏛️ Serviços ao Cidadão (Citizen Services)",
        "🚗 Habilitação & Trânsito (Transit Digital)",
        "📋 Trabalho Digital (Employment Record)",
        // 60+: Extras
        "💰 Gestão Financeira (Personal Finance)",
        "🛍️ Moda Boutique (Boutique Fashion)",
        "🌅 Loja Rápida (Quick Shop)",
        "🛒 Loja de Gadgets (Gadget Shop)",
        "🌿 Hortifrúti Fresco (Fresh Grocery)",
        "✨ Mercado Curado (Curated Market)",
        "🧢 Moda Esportiva (Apparel Fashion)",
        "👜 Loja de Variedades (Retail Store)",
        "👗 Megaloja de Moda (Mega Store)",
        "🛍️ Tendências de Moda (Trend Fashion)",
        "🎨 Figma (3 Templates)",
        "🧩 Componentes (:design-system)",
        "📱 Templates (:ds-templates)",
        "🏭 Fábricas & Slots",
        // 74-78: Novas Suítes Especializadas Figma
        "🦷 Odontologia & Raio-X (Dental Clinic)",
        "🩺 Telemedicina & Consultas (Telemedicine)",
        "🍺 Entrega de Bebidas (Beverage Delivery)",
        "🚘 Automotivo & FIPE (Automotive Market)",
        "⚡ Hardware & Specs (Hardware Tech)"
    )

    val propertyRentalScreens = br.com.wgc.ds_templates.factories.WgcPropertyRentalScreen.entries
    var selectedPropertyRentalScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val propertyListingScreens = br.com.wgc.ds_templates.factories.WgcPropertyListingScreen.entries
    var selectedPropertyListingScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val zapScreens = br.com.wgc.ds_templates.factories.WgcPropertyClassifiedsScreen.entries
    var selectedZapScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val gymFitnessScreens = br.com.wgc.ds_templates.factories.WgcGymFitnessScreen.entries
    var selectedGymFitnessScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val wellhubScreens = br.com.wgc.ds_templates.factories.WgcCorporateWellnessScreen.entries
    var selectedCorporateWellnessScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val ntcScreens = br.com.wgc.ds_templates.factories.WgcGuidedTrainingScreen.entries
    var selectedNtcScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val extraScreens = br.com.wgc.ds_templates.factories.WgcHypermarketScreen.entries
    var selectedExtraScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val pdaScreens = br.com.wgc.ds_templates.factories.WgcPremiumGroceryScreen.entries
    var selectedPdaScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val groceryScreens = br.com.wgc.ds_templates.factories.WgcGroceryScreen.entries
    var selectedGroceryScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val drogaRaiaScreens = br.com.wgc.ds_templates.factories.WgcPharmacyChainScreen.entries
    var selectedDrogaRaiaScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val drogasilScreens = br.com.wgc.ds_templates.factories.WgcCarePharmacyScreen.entries
    var selectedDrogasilScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val pagueMenosScreens = br.com.wgc.ds_templates.factories.WgcPopularPharmacyScreen.entries
    var selectedPagueMenosScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    // Cat 5: FinTech
    val fintechNeobankScreens = br.com.wgc.ds_templates.factories.WgcFintechNeobankScreen.entries
    var selectedFintechNeobankScreenIndex by remember { mutableIntStateOf(0) }
    val interScreens = br.com.wgc.ds_templates.factories.WgcFintechSuperAppScreen.entries
    var selectedInterScreenIndex by remember { mutableIntStateOf(0) }
    val c6Screens = br.com.wgc.ds_templates.factories.WgcFintechCarbonScreen.entries
    var selectedC6ScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 6: Mobilidade
    val noveNoveScreens = br.com.wgc.ds_templates.factories.WgcUrbanMobilityScreen.entries
    var selectedNoveNoveScreenIndex by remember { mutableIntStateOf(0) }
    val inDriveScreens = br.com.wgc.ds_templates.factories.WgcBiddingRidesScreen.entries
    var selectedInDriveScreenIndex by remember { mutableIntStateOf(0) }
    val clickBusScreens = br.com.wgc.ds_templates.factories.WgcBusTravelScreen.entries
    var selectedClickBusScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 7: Viagem
    val decolarScreens = br.com.wgc.ds_templates.factories.WgcFlightTravelScreen.entries
    var selectedDecolarScreenIndex by remember { mutableIntStateOf(0) }
    val hospitalityLodgingScreens = br.com.wgc.ds_templates.factories.WgcHospitalityLodgingScreen.entries
    var selectedHospitalityLodgingScreenIndex by remember { mutableIntStateOf(0) }
    val bookingScreens = br.com.wgc.ds_templates.factories.WgcHotelBookingScreen.entries
    var selectedHotelBookingScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 8: Streaming
    val videoStreamScreens = br.com.wgc.ds_templates.factories.WgcVideoStreamScreen.entries
    var selectedVideoStreamScreenIndex by remember { mutableIntStateOf(0) }
    val audioStreamScreens = br.com.wgc.ds_templates.factories.WgcAudioStreamScreen.entries
    var selectedAudioStreamScreenIndex by remember { mutableIntStateOf(0) }
    val globoplayScreens = br.com.wgc.ds_templates.factories.WgcBroadcastStreamingScreen.entries
    var selectedGloboplayScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 9: Educação
    val duolingoScreens = br.com.wgc.ds_templates.factories.WgcLanguageLearningScreen.entries
    var selectedDuolingoScreenIndex by remember { mutableIntStateOf(0) }
    val aluraScreens = br.com.wgc.ds_templates.factories.WgcTechEducationScreen.entries
    var selectedAluraScreenIndex by remember { mutableIntStateOf(0) }
    val udemyScreens = br.com.wgc.ds_templates.factories.WgcCourseMarketplaceScreen.entries
    var selectedUdemyScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 10: Mensageria
    val whatsAppScreens = br.com.wgc.ds_templates.factories.WgcDirectMessagingScreen.entries
    var selectedWhatsAppScreenIndex by remember { mutableIntStateOf(0) }
    val telegramScreens = br.com.wgc.ds_templates.factories.WgcChannelMessagingScreen.entries
    var selectedTelegramScreenIndex by remember { mutableIntStateOf(0) }
    val pinterestScreens = br.com.wgc.ds_templates.factories.WgcVisualDiscoveryScreen.entries
    var selectedPinterestScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 11: Gaming
    val steamScreens = br.com.wgc.ds_templates.factories.WgcGamingStoreScreen.entries
    var selectedSteamScreenIndex by remember { mutableIntStateOf(0) }
    val twitchScreens = br.com.wgc.ds_templates.factories.WgcLiveStreamingScreen.entries
    var selectedTwitchScreenIndex by remember { mutableIntStateOf(0) }
    val communityChatScreens = br.com.wgc.ds_templates.factories.WgcCommunityChatScreen.entries
    var selectedCommunityChatScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 12: Produtividade
    val notionScreens = br.com.wgc.ds_templates.factories.WgcWorkspaceDocsScreen.entries
    var selectedNotionScreenIndex by remember { mutableIntStateOf(0) }
    val trelloScreens = br.com.wgc.ds_templates.factories.WgcKanbanTasksScreen.entries
    var selectedTrelloScreenIndex by remember { mutableIntStateOf(0) }
    val slackScreens = br.com.wgc.ds_templates.factories.WgcTeamCollaborationScreen.entries
    var selectedSlackScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 13: FastFood
    val burgerFastFoodScreens = br.com.wgc.ds_templates.factories.WgcBurgerFastFoodScreen.entries
    var selectedBurgerFastFoodScreenIndex by remember { mutableIntStateOf(0) }
    val burgerKingScreens = br.com.wgc.ds_templates.factories.WgcFlameFastFoodScreen.entries
    var selectedBurgerKingScreenIndex by remember { mutableIntStateOf(0) }
    val pizzaScreens = br.com.wgc.ds_templates.factories.WgcPizzaScreen.entries
    var selectedPizzaScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 14: Logística
    val carpoolingScreens = br.com.wgc.ds_templates.factories.WgcCarpoolingScreen.entries
    var selectedCarpoolingScreenIndex by remember { mutableIntStateOf(0) }
    val loggiScreens = br.com.wgc.ds_templates.factories.WgcExpressLogisticsScreen.entries
    var selectedLoggiScreenIndex by remember { mutableIntStateOf(0) }
    val lalamoveScreens = br.com.wgc.ds_templates.factories.WgcFreightLogisticsScreen.entries
    var selectedLalamoveScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 15: Moda
    val rennerScreens = br.com.wgc.ds_templates.factories.WgcDepartmentFashionScreen.entries
    var selectedRennerScreenIndex by remember { mutableIntStateOf(0) }
    val ceaScreens = br.com.wgc.ds_templates.factories.WgcUrbanFashionScreen.entries
    var selectedCeaScreenIndex by remember { mutableIntStateOf(0) }
    val riachueloScreens = br.com.wgc.ds_templates.factories.WgcTrendApparelScreen.entries
    var selectedRiachueloScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 16: Beleza
    val boticarioScreens = br.com.wgc.ds_templates.factories.WgcFragranceBeautyScreen.entries
    var selectedBoticarioScreenIndex by remember { mutableIntStateOf(0) }
    val naturaScreens = br.com.wgc.ds_templates.factories.WgcNaturalBeautyScreen.entries
    var selectedNaturaScreenIndex by remember { mutableIntStateOf(0) }
    val sephoraScreens = br.com.wgc.ds_templates.factories.WgcPrestigeBeautyScreen.entries
    var selectedSephoraScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 17: Pet Care
    val petzScreens = br.com.wgc.ds_templates.factories.WgcPetCareScreen.entries
    var selectedPetzScreenIndex by remember { mutableIntStateOf(0) }
    val cobasiScreens = br.com.wgc.ds_templates.factories.WgcPetSuperstoreScreen.entries
    var selectedCobasiScreenIndex by remember { mutableIntStateOf(0) }
    val zeeDogScreens = br.com.wgc.ds_templates.factories.WgcPetLifestyleScreen.entries
    var selectedZeeDogScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 18: Casa & Decor
    val leroyMerlinScreens = br.com.wgc.ds_templates.factories.WgcHomeImprovementScreen.entries
    var selectedLeroyMerlinScreenIndex by remember { mutableIntStateOf(0) }
    val tokStokScreens = br.com.wgc.ds_templates.factories.WgcDesignerFurnitureScreen.entries
    var selectedTokStokScreenIndex by remember { mutableIntStateOf(0) }
    val madeiraMadeiraScreens = br.com.wgc.ds_templates.factories.WgcHomeMarketplaceScreen.entries
    var selectedMadeiraMadeiraScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 19: Notícias
    val g1Screens = br.com.wgc.ds_templates.factories.WgcDailyNewsScreen.entries
    var selectedG1ScreenIndex by remember { mutableIntStateOf(0) }
    val uolScreens = br.com.wgc.ds_templates.factories.WgcMediaNetworkScreen.entries
    var selectedUolScreenIndex by remember { mutableIntStateOf(0) }
    val exameScreens = br.com.wgc.ds_templates.factories.WgcBusinessNewsScreen.entries
    var selectedExameScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 20: Serviços Públicos
    val govBrScreens = br.com.wgc.ds_templates.factories.WgcCitizenServicesScreen.entries
    var selectedGovBrScreenIndex by remember { mutableIntStateOf(0) }
    val cdtScreens = br.com.wgc.ds_templates.factories.WgcTransitDigitalScreen.entries
    var selectedCdtScreenIndex by remember { mutableIntStateOf(0) }
    val ctpsScreens = br.com.wgc.ds_templates.factories.WgcEmploymentRecordScreen.entries
    var selectedCtpsScreenIndex by remember { mutableIntStateOf(0) }

    // Novas Suítes Figma
    val dentalScreens = br.com.wgc.ds_templates.factories.WgcDentalScreen.entries
    var selectedDentalScreenIndex by remember { mutableIntStateOf(0) }

    val telemedicineScreens = br.com.wgc.ds_templates.factories.WgcTelemedicineScreen.entries
    var selectedTelemedicineScreenIndex by remember { mutableIntStateOf(0) }

    val beverageDeliveryScreens = br.com.wgc.ds_templates.factories.WgcBeverageDeliveryScreen.entries
    var selectedBeverageDeliveryScreenIndex by remember { mutableIntStateOf(0) }

    val automotiveScreens = br.com.wgc.ds_templates.factories.WgcAutomotiveScreen.entries
    var selectedAutomotiveScreenIndex by remember { mutableIntStateOf(0) }

    val hardwareScreens = br.com.wgc.ds_templates.factories.WgcHardwareScreen.entries
    var selectedHardwareScreenIndex by remember { mutableIntStateOf(0) }

    val organizzeScreens = br.com.wgc.ds_templates.factories.WgcPersonalFinanceScreen.entries
    var selectedOrganizzeScreenIndex by remember { mutableIntStateOf(0) } // Default: Dashboard

    val lazaScreens = br.com.wgc.ds_templates.factories.WgcBoutiqueScreen.entries
    var selectedLazaScreenIndex by remember { mutableIntStateOf(3) } // Default: Home

    val nexkartScreens = br.com.wgc.ds_templates.factories.WgcGadgetShopScreen.entries
    var selectedNexkartScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val shopEaseScreens = br.com.wgc.ds_templates.factories.WgcQuickShopScreen.entries
    var selectedShopEaseScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val shopperScreens = br.com.wgc.ds_templates.factories.WgcFreshGroceryScreen.entries
    var selectedShopperScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val tasselScreens = br.com.wgc.ds_templates.factories.WgcCuratedMarketScreen.entries
    var selectedTasselScreenIndex by remember { mutableIntStateOf(0) } // Default: Market

    val clotheeScreens = br.com.wgc.ds_templates.factories.WgcApparelScreen.entries
    var selectedClotheeScreenIndex by remember { mutableIntStateOf(3) } // Default: Home

    val kutukuScreens = br.com.wgc.ds_templates.factories.WgcRetailScreen.entries
    var selectedKutukuScreenIndex by remember { mutableIntStateOf(2) } // Default: Home

    val shoppeScreens = br.com.wgc.ds_templates.factories.WgcMegaStoreScreen.entries
    var selectedShoppeScreenIndex by remember { mutableIntStateOf(4) } // Default: HomeShop

    val stylishScreens = br.com.wgc.ds_templates.factories.WgcTrendFashionScreen.entries
    var selectedStylishScreenIndex by remember { mutableIntStateOf(8) } // Default: Home

    val figmaSubTabs = listOf(
        "1. Clean Wave Auth",
        "2. Split Card Auth",
        "3. Modern Klok Auth"
    )
    var selectedFigmaSubTab by remember { mutableIntStateOf(0) }

    val componentSubTabs = listOf(
        "WgcClassicButton", "WgcSecondaryClassicButton", "WgcIconButton", "WgcSegmentedButton",
        "WgcSwitch", "WgcRadioButton", "WgcChip", "WgcSlider", "WgcAlert", "WgcAvatar", "WgcListItem",
        "WgcStoryAvatar", "WgcStoryTray", "WgcDeliveryComponents", "WgcFoodListingComponents", "WgcMarketplaceComponents",
        "WgcBiometricButton", "WgcSocialLoginPillButton", "WgcPillTabSwitch"
    )

    val templateSubTabs = listOf(
        "Figma: Clean Wave Auth", "Figma: Split Card Auth", "Figma: Modern Klok Auth",
        "Auth Multi-Brand", "Marketplace Home", "99Food Home", "Food Delivery Home",
        "Instagram Story Viewer", "Home Fintech", "Home E-commerce",
        "Mapa & Tracking", "Carrinho & Checkout", "Perfil & Configurações", "Busca & Filtros", "Login"
    )

    val factorySubTabs = listOf(
        "WgcProfileFactory (22 Perfis)", "WgcButton", "WgcMenuFactory", "WgcFieldFactory", "WgcCardFactory", "WgcAuthFactory", "WgcHomeFactory"
    )

    var selectedFactorySubTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = selectedModule?.title ?: "Catálogo Design System",
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = selectedModule?.moduleBadge ?: "",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { selectedModule = null }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar ao Hub de Módulos")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedPropertyRentalScreenIndex) {
                    propertyRentalScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPropertyRentalScreenIndex == index,
                            onClick = { selectedPropertyRentalScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            1 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPropertyListingScreenIndex) {
                    propertyListingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPropertyListingScreenIndex == index,
                            onClick = { selectedPropertyListingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            2 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedZapScreenIndex) {
                    zapScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedZapScreenIndex == index,
                            onClick = { selectedZapScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            3 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedGymFitnessScreenIndex) {
                    gymFitnessScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedGymFitnessScreenIndex == index,
                            onClick = { selectedGymFitnessScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            4 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCorporateWellnessScreenIndex) {
                    wellhubScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCorporateWellnessScreenIndex == index,
                            onClick = { selectedCorporateWellnessScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            5 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNtcScreenIndex) {
                    ntcScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNtcScreenIndex == index,
                            onClick = { selectedNtcScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            6 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedExtraScreenIndex) {
                    extraScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedExtraScreenIndex == index,
                            onClick = { selectedExtraScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            7 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPdaScreenIndex) {
                    pdaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPdaScreenIndex == index,
                            onClick = { selectedPdaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            8 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedGroceryScreenIndex) {
                    groceryScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedGroceryScreenIndex == index,
                            onClick = { selectedGroceryScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            9 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDrogaRaiaScreenIndex) {
                    drogaRaiaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDrogaRaiaScreenIndex == index,
                            onClick = { selectedDrogaRaiaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            10 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDrogasilScreenIndex) {
                    drogasilScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDrogasilScreenIndex == index,
                            onClick = { selectedDrogasilScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            11 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPagueMenosScreenIndex) {
                    pagueMenosScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPagueMenosScreenIndex == index,
                            onClick = { selectedPagueMenosScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            12 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedFintechNeobankScreenIndex) {
                    fintechNeobankScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedFintechNeobankScreenIndex == index,
                            onClick = { selectedFintechNeobankScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            13 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedInterScreenIndex) {
                    interScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedInterScreenIndex == index,
                            onClick = { selectedInterScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            14 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedC6ScreenIndex) {
                    c6Screens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedC6ScreenIndex == index,
                            onClick = { selectedC6ScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            15 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNoveNoveScreenIndex) {
                    noveNoveScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNoveNoveScreenIndex == index,
                            onClick = { selectedNoveNoveScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            16 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedInDriveScreenIndex) {
                    inDriveScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedInDriveScreenIndex == index,
                            onClick = { selectedInDriveScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            17 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedClickBusScreenIndex) {
                    clickBusScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedClickBusScreenIndex == index,
                            onClick = { selectedClickBusScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            18 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDecolarScreenIndex) {
                    decolarScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDecolarScreenIndex == index,
                            onClick = { selectedDecolarScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            19 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedHospitalityLodgingScreenIndex) {
                    hospitalityLodgingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedHospitalityLodgingScreenIndex == index,
                            onClick = { selectedHospitalityLodgingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            20 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedHotelBookingScreenIndex) {
                    bookingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedHotelBookingScreenIndex == index,
                            onClick = { selectedHotelBookingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            21 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedVideoStreamScreenIndex) {
                    videoStreamScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedVideoStreamScreenIndex == index,
                            onClick = { selectedVideoStreamScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            22 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedAudioStreamScreenIndex) {
                    audioStreamScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedAudioStreamScreenIndex == index,
                            onClick = { selectedAudioStreamScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            23 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedGloboplayScreenIndex) {
                    globoplayScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedGloboplayScreenIndex == index,
                            onClick = { selectedGloboplayScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            24 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDuolingoScreenIndex) {
                    duolingoScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDuolingoScreenIndex == index,
                            onClick = { selectedDuolingoScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            25 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedAluraScreenIndex) {
                    aluraScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedAluraScreenIndex == index,
                            onClick = { selectedAluraScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            26 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedUdemyScreenIndex) {
                    udemyScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedUdemyScreenIndex == index,
                            onClick = { selectedUdemyScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            27 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedWhatsAppScreenIndex) {
                    whatsAppScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedWhatsAppScreenIndex == index,
                            onClick = { selectedWhatsAppScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            28 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTelegramScreenIndex) {
                    telegramScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTelegramScreenIndex == index,
                            onClick = { selectedTelegramScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            29 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPinterestScreenIndex) {
                    pinterestScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPinterestScreenIndex == index,
                            onClick = { selectedPinterestScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            30 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedSteamScreenIndex) {
                    steamScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedSteamScreenIndex == index,
                            onClick = { selectedSteamScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            31 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTwitchScreenIndex) {
                    twitchScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTwitchScreenIndex == index,
                            onClick = { selectedTwitchScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            32 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCommunityChatScreenIndex) {
                    communityChatScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCommunityChatScreenIndex == index,
                            onClick = { selectedCommunityChatScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            33 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNotionScreenIndex) {
                    notionScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNotionScreenIndex == index,
                            onClick = { selectedNotionScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            34 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTrelloScreenIndex) {
                    trelloScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTrelloScreenIndex == index,
                            onClick = { selectedTrelloScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            35 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedSlackScreenIndex) {
                    slackScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedSlackScreenIndex == index,
                            onClick = { selectedSlackScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            36 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBurgerFastFoodScreenIndex) {
                    burgerFastFoodScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBurgerFastFoodScreenIndex == index,
                            onClick = { selectedBurgerFastFoodScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            37 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBurgerKingScreenIndex) {
                    burgerKingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBurgerKingScreenIndex == index,
                            onClick = { selectedBurgerKingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            38 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPizzaScreenIndex) {
                    pizzaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPizzaScreenIndex == index,
                            onClick = { selectedPizzaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            39 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCarpoolingScreenIndex) {
                    carpoolingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCarpoolingScreenIndex == index,
                            onClick = { selectedCarpoolingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            40 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedLoggiScreenIndex) {
                    loggiScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedLoggiScreenIndex == index,
                            onClick = { selectedLoggiScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            41 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedLalamoveScreenIndex) {
                    lalamoveScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedLalamoveScreenIndex == index,
                            onClick = { selectedLalamoveScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            42 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedRennerScreenIndex) {
                    rennerScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedRennerScreenIndex == index,
                            onClick = { selectedRennerScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            43 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCeaScreenIndex) {
                    ceaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCeaScreenIndex == index,
                            onClick = { selectedCeaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            44 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedRiachueloScreenIndex) {
                    riachueloScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedRiachueloScreenIndex == index,
                            onClick = { selectedRiachueloScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            45 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBoticarioScreenIndex) {
                    boticarioScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBoticarioScreenIndex == index,
                            onClick = { selectedBoticarioScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            46 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNaturaScreenIndex) {
                    naturaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNaturaScreenIndex == index,
                            onClick = { selectedNaturaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            47 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedSephoraScreenIndex) {
                    sephoraScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedSephoraScreenIndex == index,
                            onClick = { selectedSephoraScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            48 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedPetzScreenIndex) {
                    petzScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedPetzScreenIndex == index,
                            onClick = { selectedPetzScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            49 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCobasiScreenIndex) {
                    cobasiScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCobasiScreenIndex == index,
                            onClick = { selectedCobasiScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            50 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedZeeDogScreenIndex) {
                    zeeDogScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedZeeDogScreenIndex == index,
                            onClick = { selectedZeeDogScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            51 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedLeroyMerlinScreenIndex) {
                    leroyMerlinScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedLeroyMerlinScreenIndex == index,
                            onClick = { selectedLeroyMerlinScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            52 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTokStokScreenIndex) {
                    tokStokScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTokStokScreenIndex == index,
                            onClick = { selectedTokStokScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            53 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedMadeiraMadeiraScreenIndex) {
                    madeiraMadeiraScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedMadeiraMadeiraScreenIndex == index,
                            onClick = { selectedMadeiraMadeiraScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            54 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedG1ScreenIndex) {
                    g1Screens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedG1ScreenIndex == index,
                            onClick = { selectedG1ScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            55 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedUolScreenIndex) {
                    uolScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedUolScreenIndex == index,
                            onClick = { selectedUolScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            56 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedExameScreenIndex) {
                    exameScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedExameScreenIndex == index,
                            onClick = { selectedExameScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            57 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedGovBrScreenIndex) {
                    govBrScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedGovBrScreenIndex == index,
                            onClick = { selectedGovBrScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            58 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCdtScreenIndex) {
                    cdtScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCdtScreenIndex == index,
                            onClick = { selectedCdtScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            59 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedCtpsScreenIndex) {
                    ctpsScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCtpsScreenIndex == index,
                            onClick = { selectedCtpsScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            60 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedOrganizzeScreenIndex) {
                    organizzeScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedOrganizzeScreenIndex == index,
                            onClick = { selectedOrganizzeScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            61 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedLazaScreenIndex) {
                    lazaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedLazaScreenIndex == index,
                            onClick = { selectedLazaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            62 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedShopEaseScreenIndex) {
                    shopEaseScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedShopEaseScreenIndex == index,
                            onClick = { selectedShopEaseScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            63 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNexkartScreenIndex) {
                    nexkartScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNexkartScreenIndex == index,
                            onClick = { selectedNexkartScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            64 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedShopperScreenIndex) {
                    shopperScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedShopperScreenIndex == index,
                            onClick = { selectedShopperScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            65 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTasselScreenIndex) {
                    tasselScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTasselScreenIndex == index,
                            onClick = { selectedTasselScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            66 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedClotheeScreenIndex) {
                    clotheeScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedClotheeScreenIndex == index,
                            onClick = { selectedClotheeScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            67 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedKutukuScreenIndex) {
                    kutukuScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedKutukuScreenIndex == index,
                            onClick = { selectedKutukuScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            68 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedShoppeScreenIndex) {
                    shoppeScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedShoppeScreenIndex == index,
                            onClick = { selectedShoppeScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            69 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedStylishScreenIndex) {
                    stylishScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedStylishScreenIndex == index,
                            onClick = { selectedStylishScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            70 -> {
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
            71 -> {
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
            72 -> {
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
            73 -> {
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
            74 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDentalScreenIndex) {
                    dentalScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDentalScreenIndex == index,
                            onClick = { selectedDentalScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            75 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedTelemedicineScreenIndex) {
                    telemedicineScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedTelemedicineScreenIndex == index,
                            onClick = { selectedTelemedicineScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            76 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBeverageDeliveryScreenIndex) {
                    beverageDeliveryScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBeverageDeliveryScreenIndex == index,
                            onClick = { selectedBeverageDeliveryScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            77 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedAutomotiveScreenIndex) {
                    automotiveScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedAutomotiveScreenIndex == index,
                            onClick = { selectedAutomotiveScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            78 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedHardwareScreenIndex) {
                    hardwareScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedHardwareScreenIndex == index,
                            onClick = { selectedHardwareScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            when (primarySection) {
                0 -> {
                    val currentScreen = propertyRentalScreens[selectedPropertyRentalScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPropertyRentalFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedPropertyRentalScreenIndex = propertyRentalScreens.indexOf(targetScreen)
                        }
                    )
                }
                1 -> {
                    val currentScreen = propertyListingScreens[selectedPropertyListingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPropertyListingFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedPropertyListingScreenIndex = propertyListingScreens.indexOf(targetScreen)
                        }
                    )
                }
                2 -> {
                    val currentScreen = zapScreens[selectedZapScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPropertyClassifiedsFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedZapScreenIndex = zapScreens.indexOf(targetScreen)
                        }
                    )
                }
                3 -> {
                    val currentScreen = gymFitnessScreens[selectedGymFitnessScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGymFitnessFactory.Screen(
                        screen = currentScreen,
                        onNavigateScreen = { targetScreen ->
                            selectedGymFitnessScreenIndex = gymFitnessScreens.indexOf(targetScreen)
                        }
                    )
                }
                4 -> {
                    val currentScreen = wellhubScreens[selectedCorporateWellnessScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCorporateWellnessFactory.Screen(
                        screen = currentScreen,
                        onNavigateScreen = { targetScreen ->
                            selectedCorporateWellnessScreenIndex = wellhubScreens.indexOf(targetScreen)
                        }
                    )
                }
                5 -> {
                    val currentScreen = ntcScreens[selectedNtcScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGuidedTrainingFactory(
                        screen = currentScreen,
                        onSelectWorkout = { selectedNtcScreenIndex = 2 },
                        onStartWorkout = { selectedNtcScreenIndex = 1 },
                        onOpenProgram = { selectedNtcScreenIndex = 3 },
                        onClosePlayer = { selectedNtcScreenIndex = 0 },
                        onFinishWorkout = { selectedNtcScreenIndex = 4 }
                    )
                }
                6 -> {
                    val currentScreen = extraScreens[selectedExtraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHypermarketFactory(
                        screen = currentScreen,
                        onNavigateToDiscounts = { selectedExtraScreenIndex = 1 },
                        onNavigateToFlyer = { selectedExtraScreenIndex = 2 },
                        onNavigateToCart = { selectedExtraScreenIndex = 3 },
                        onNavigateToLoyalty = { selectedExtraScreenIndex = 4 }
                    )
                }
                7 -> {
                    val currentScreen = pdaScreens[selectedPdaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPremiumGroceryFactory(
                        screen = currentScreen,
                            onNavItemClick = { navItem -> selectedPdaScreenIndex = navItem.ordinal }
                    )
                }
                8 -> {
                    val currentScreen = groceryScreens[selectedGroceryScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGroceryFactory(
                        screen = currentScreen,
                        onTabSelected = { tab ->
                            selectedGroceryScreenIndex = when (tab) {
                                br.com.wgc.design_system.components.navigation.GroceryNavTab.HOME -> 0
                                br.com.wgc.design_system.components.navigation.GroceryNavTab.COUPONS -> 1
                                br.com.wgc.design_system.components.navigation.GroceryNavTab.FLYER -> 2
                                br.com.wgc.design_system.components.navigation.GroceryNavTab.CART -> 3
                                br.com.wgc.design_system.components.navigation.GroceryNavTab.LOYALTY -> 4
                            }
                        }
                    )
                }
                9 -> {
                    val currentScreen = drogaRaiaScreens[selectedDrogaRaiaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPharmacyChainFactory(
                        screen = currentScreen,
                        onTabSelected = { tab ->
                            selectedDrogaRaiaScreenIndex = when (tab) {
                                br.com.wgc.design_system.components.navigation.PharmacyNavTab.HOME -> 0
                                br.com.wgc.design_system.components.navigation.PharmacyNavTab.PRESCRIPTIONS -> 1
                                br.com.wgc.design_system.components.navigation.PharmacyNavTab.SUBSCRIPTION -> 2
                                br.com.wgc.design_system.components.navigation.PharmacyNavTab.CART -> 3
                                br.com.wgc.design_system.components.navigation.PharmacyNavTab.PROFILE -> 4
                            }
                        }
                    )
                }
                10 -> {
                    val currentScreen = drogasilScreens[selectedDrogasilScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCarePharmacyFactory(
                        screen = currentScreen
                    )
                }
                11 -> {
                    val currentScreen = pagueMenosScreens[selectedPagueMenosScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPopularPharmacyFactory(
                        screen = currentScreen
                    )
                }
                12 -> {
                    val currentScreen = fintechNeobankScreens[selectedFintechNeobankScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFintechNeobankFactory(
                        screen = currentScreen
                    )
                }
                13 -> {
                    val currentScreen = interScreens[selectedInterScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFintechSuperAppFactory(
                        screen = currentScreen
                    )
                }
                14 -> {
                    val currentScreen = c6Screens[selectedC6ScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFintechCarbonFactory(
                        screen = currentScreen
                    )
                }
                15 -> {
                    val currentScreen = noveNoveScreens[selectedNoveNoveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcUrbanMobilityFactory(
                        screen = currentScreen
                    )
                }
                16 -> {
                    val currentScreen = inDriveScreens[selectedInDriveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBiddingRidesFactory(
                        screen = currentScreen
                    )
                }
                17 -> {
                    val currentScreen = clickBusScreens[selectedClickBusScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBusTravelFactory(
                        screen = currentScreen
                    )
                }
                18 -> {
                    val currentScreen = decolarScreens[selectedDecolarScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFlightTravelFactory(
                        screen = currentScreen
                    )
                }
                19 -> {
                    val currentScreen = hospitalityLodgingScreens[selectedHospitalityLodgingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHospitalityLodgingFactory(
                        screen = currentScreen
                    )
                }
                20 -> {
                    val currentScreen = bookingScreens[selectedHotelBookingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHotelBookingFactory(
                        screen = currentScreen
                    )
                }
                21 -> {
                    val currentScreen = videoStreamScreens[selectedVideoStreamScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcVideoStreamFactory(
                        screen = currentScreen
                    )
                }
                22 -> {
                    val currentScreen = audioStreamScreens[selectedAudioStreamScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcAudioStreamFactory(
                        screen = currentScreen
                    )
                }
                23 -> {
                    val currentScreen = globoplayScreens[selectedGloboplayScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBroadcastStreamingFactory(
                        screen = currentScreen
                    )
                }
                24 -> {
                    val currentScreen = duolingoScreens[selectedDuolingoScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLanguageLearningFactory(
                        screen = currentScreen
                    )
                }
                25 -> {
                    val currentScreen = aluraScreens[selectedAluraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTechEducationFactory(
                        screen = currentScreen
                    )
                }
                26 -> {
                    val currentScreen = udemyScreens[selectedUdemyScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCourseMarketplaceFactory(
                        screen = currentScreen
                    )
                }
                27 -> {
                    val currentScreen = whatsAppScreens[selectedWhatsAppScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDirectMessagingFactory(
                        screen = currentScreen
                    )
                }
                28 -> {
                    val currentScreen = telegramScreens[selectedTelegramScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcChannelMessagingFactory(
                        screen = currentScreen
                    )
                }
                29 -> {
                    val currentScreen = pinterestScreens[selectedPinterestScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcVisualDiscoveryFactory(
                        screen = currentScreen
                    )
                }
                30 -> {
                    val currentScreen = steamScreens[selectedSteamScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGamingStoreFactory(
                        screen = currentScreen
                    )
                }
                31 -> {
                    val currentScreen = twitchScreens[selectedTwitchScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLiveStreamingFactory(
                        screen = currentScreen
                    )
                }
                32 -> {
                    val currentScreen = communityChatScreens[selectedCommunityChatScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCommunityChatFactory(
                        screen = currentScreen
                    )
                }
                33 -> {
                    val currentScreen = notionScreens[selectedNotionScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcWorkspaceDocsFactory(
                        screen = currentScreen
                    )
                }
                34 -> {
                    val currentScreen = trelloScreens[selectedTrelloScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcKanbanTasksFactory(
                        screen = currentScreen
                    )
                }
                35 -> {
                    val currentScreen = slackScreens[selectedSlackScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTeamCollaborationFactory(
                        screen = currentScreen
                    )
                }
                36 -> {
                    val currentScreen = burgerFastFoodScreens[selectedBurgerFastFoodScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBurgerFastFoodFactory(
                        screen = currentScreen
                    )
                }
                37 -> {
                    val currentScreen = burgerKingScreens[selectedBurgerKingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFlameFastFoodFactory(
                        screen = currentScreen
                    )
                }
                38 -> {
                    val currentScreen = pizzaScreens[selectedPizzaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPizzaFactory(
                        screen = currentScreen
                    )
                }
                39 -> {
                    val currentScreen = carpoolingScreens[selectedCarpoolingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCarpoolingFactory(
                        screen = currentScreen
                    )
                }
                40 -> {
                    val currentScreen = loggiScreens[selectedLoggiScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcExpressLogisticsFactory(
                        screen = currentScreen
                    )
                }
                41 -> {
                    val currentScreen = lalamoveScreens[selectedLalamoveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFreightLogisticsFactory(
                        screen = currentScreen
                    )
                }
                42 -> {
                    val currentScreen = rennerScreens[selectedRennerScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDepartmentFashionFactory(
                        screen = currentScreen
                    )
                }
                43 -> {
                    val currentScreen = ceaScreens[selectedCeaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcUrbanFashionFactory(
                        screen = currentScreen
                    )
                }
                44 -> {
                    val currentScreen = riachueloScreens[selectedRiachueloScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTrendApparelFactory(
                        screen = currentScreen
                    )
                }
                45 -> {
                    val currentScreen = boticarioScreens[selectedBoticarioScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFragranceBeautyFactory(
                        screen = currentScreen
                    )
                }
                46 -> {
                    val currentScreen = naturaScreens[selectedNaturaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNaturalBeautyFactory(
                        screen = currentScreen
                    )
                }
                47 -> {
                    val currentScreen = sephoraScreens[selectedSephoraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPrestigeBeautyFactory(
                        screen = currentScreen
                    )
                }
                48 -> {
                    val currentScreen = petzScreens[selectedPetzScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPetCareFactory(
                        screen = currentScreen
                    )
                }
                49 -> {
                    val currentScreen = cobasiScreens[selectedCobasiScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPetSuperstoreFactory(
                        screen = currentScreen
                    )
                }
                50 -> {
                    val currentScreen = zeeDogScreens[selectedZeeDogScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPetLifestyleFactory(
                        screen = currentScreen
                    )
                }
                51 -> {
                    val currentScreen = leroyMerlinScreens[selectedLeroyMerlinScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHomeImprovementFactory(
                        screen = currentScreen
                    )
                }
                52 -> {
                    val currentScreen = tokStokScreens[selectedTokStokScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDesignerFurnitureFactory(
                        screen = currentScreen
                    )
                }
                53 -> {
                    val currentScreen = madeiraMadeiraScreens[selectedMadeiraMadeiraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHomeMarketplaceFactory(
                        screen = currentScreen
                    )
                }
                54 -> {
                    val currentScreen = g1Screens[selectedG1ScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDailyNewsFactory(
                        screen = currentScreen
                    )
                }
                55 -> {
                    val currentScreen = uolScreens[selectedUolScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcMediaNetworkFactory(
                        screen = currentScreen
                    )
                }
                56 -> {
                    val currentScreen = exameScreens[selectedExameScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBusinessNewsFactory(
                        screen = currentScreen
                    )
                }
                57 -> {
                    val currentScreen = govBrScreens[selectedGovBrScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCitizenServicesFactory(
                        screen = currentScreen
                    )
                }
                58 -> {
                    val currentScreen = cdtScreens[selectedCdtScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTransitDigitalFactory(
                        screen = currentScreen
                    )
                }
                59 -> {
                    val currentScreen = ctpsScreens[selectedCtpsScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcEmploymentRecordFactory(
                        screen = currentScreen
                    )
                }
                60 -> {
                    val currentScreen = organizzeScreens[selectedOrganizzeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPersonalFinanceFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedOrganizzeScreenIndex = organizzeScreens.indexOf(targetScreen)
                        }
                    )
                }
                61 -> {
                    val currentScreen = lazaScreens[selectedLazaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBoutiqueFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedLazaScreenIndex = lazaScreens.indexOf(targetScreen)
                        }
                    )
                }
                62 -> {
                    val currentScreen = shopEaseScreens[selectedShopEaseScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcQuickShopFactory(
                        screen = currentScreen,
                        onNavigateToHome = { selectedShopEaseScreenIndex = 1 },
                        onNavigateToDetail = { selectedShopEaseScreenIndex = 2 },
                        onNavigateToCheckout = { selectedShopEaseScreenIndex = 3 },
                        onNavigateToFavorites = { selectedShopEaseScreenIndex = 4 },
                        onNavigateToProfile = { selectedShopEaseScreenIndex = 5 },
                        onBackClick = { selectedShopEaseScreenIndex = 1 }
                    )
                }
                63 -> {
                    val currentScreen = nexkartScreens[selectedNexkartScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGadgetShopFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedNexkartScreenIndex = nexkartScreens.indexOf(targetScreen)
                        }
                    )
                }
                64 -> {
                    val currentScreen = shopperScreens[selectedShopperScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcFreshGroceryFactory(
                        screen = currentScreen,
                        onNavigateToHome = { selectedShopperScreenIndex = 1 },
                        onNavigateToDetail = { selectedShopperScreenIndex = 2 },
                        onNavigateToCart = { selectedShopperScreenIndex = 3 },
                        onNavigateToProfile = { selectedShopperScreenIndex = 4 },
                        onBackClick = { selectedShopperScreenIndex = 1 }
                    )
                }
                65 -> {
                    val currentScreen = tasselScreens[selectedTasselScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCuratedMarketFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedTasselScreenIndex = tasselScreens.indexOf(targetScreen)
                        }
                    )
                }
                66 -> {
                    val currentScreen = clotheeScreens[selectedClotheeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcApparelFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedClotheeScreenIndex = clotheeScreens.indexOf(targetScreen)
                        }
                    )
                }
                67 -> {
                    val currentScreen = kutukuScreens[selectedKutukuScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcRetailFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedKutukuScreenIndex = kutukuScreens.indexOf(targetScreen)
                        }
                    )
                }
                68 -> {
                    val currentScreen = shoppeScreens[selectedShoppeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcMegaStoreFactory(
                        screen = currentScreen,
                        onNavigate = { targetScreen ->
                            selectedShoppeScreenIndex = shoppeScreens.indexOf(targetScreen)
                        }
                    )
                }
                69 -> {
                    val currentScreen = stylishScreens[selectedStylishScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTrendFashionFactory(
                        screen = currentScreen,
                        onNavigate = { targetScreen ->
                            selectedStylishScreenIndex = stylishScreens.indexOf(targetScreen)
                        }
                    )
                }
                70 -> {
                    when (selectedFigmaSubTab) {
                        0 -> WgcWaveAuthScreenTemplate()
                        1 -> WgcSplitCardAuthScreenTemplate()
                        2 -> WgcKlokAuthScreenTemplate()
                    }
                }
                71 -> {
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
                        13 -> WgcDeliveryComponentsCatalogSection()
                        14 -> WgcFoodListingComponentsCatalogSection()
                        15 -> WgcMarketplaceComponentsCatalogSection()
                        16 -> WgcBiometricButtonCatalogSection()
                        17 -> WgcSocialLoginPillCatalogSection()
                        18 -> WgcPillTabSwitchCatalogSection()
                    }
                }
                72 -> {
                    when (selectedTemplateSubTab) {
                        0 -> WgcWaveAuthScreenTemplate()
                        1 -> WgcSplitCardAuthScreenTemplate()
                        2 -> WgcKlokAuthScreenTemplate()
                        3 -> MultiBrandAuthCatalogSection()
                        4 -> WgcMarketplaceHomeScreenTemplate(viewModel = FakeMarketplaceHomeViewModel())
                        5 -> WgcQuickFoodDeliveryHomeScreenTemplate(viewModel = FakeQuickFoodDeliveryHomeViewModel())
                        6 -> WgcFoodDeliveryHomeScreenTemplate(viewModel = FakeFoodDeliveryHomeViewModel())
                        7 -> InstagramStoryViewerScreenTemplate(viewModel = FakeInstagramStoryViewerViewModel())
                        8 -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                        9 -> RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
                        10 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
                        11 -> FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
                        12 -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel())
                    }
                }
                73 -> {
                    WgcFactoriesAndSlotsCatalogSection(selectedSubTab = selectedFactorySubTab)
                }
                74 -> {
                    val currentScreen = dentalScreens[selectedDentalScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDentalFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedDentalScreenIndex = dentalScreens.indexOf(targetScreen)
                        }
                    )
                }
                75 -> {
                    val currentScreen = telemedicineScreens[selectedTelemedicineScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTelemedicineFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedTelemedicineScreenIndex = telemedicineScreens.indexOf(targetScreen)
                        }
                    )
                }
                76 -> {
                    val currentScreen = beverageDeliveryScreens[selectedBeverageDeliveryScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBeverageDeliveryFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedBeverageDeliveryScreenIndex = beverageDeliveryScreens.indexOf(targetScreen)
                        }
                    )
                }
                77 -> {
                    val currentScreen = automotiveScreens[selectedAutomotiveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcAutomotiveFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedAutomotiveScreenIndex = automotiveScreens.indexOf(targetScreen)
                        }
                    )
                }
                78 -> {
                    val currentScreen = hardwareScreens[selectedHardwareScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcHardwareFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedHardwareScreenIndex = hardwareScreens.indexOf(targetScreen)
                        }
                    )
                }
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
fun WgcDeliveryComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes de Delivery", style = MaterialTheme.typography.titleLarge)
        WgcAddressHeaderBar()
        WgcCircularCategoryRow()
        WgcMerchantListingCard(name = "Burger Bistro", rating = "4.8", deliveryFee = "Grátis")
        WgcFloatingCartSummaryBar()
    }
}

@Composable
fun WgcFoodListingComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes de Estabelecimentos", style = MaterialTheme.typography.titleLarge)
        WgcAddressHeaderBar()
        WgcDepartmentCategoryGrid()
        WgcMerchantListingCard(name = "Pizza Hut", rating = "4.9")
        WgcFloatingCartSummaryBar()
    }
}

@Composable
fun WgcMarketplaceComponentsCatalogSection() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Componentes de Marketplace", style = MaterialTheme.typography.titleLarge)
        WgcMarketplaceSearchHeaderBar()
        WgcDepartmentCategoryGrid()
        WgcPromotionalProductCard(title = "Smart TV 50\" 4K")
    }
}

@Composable
fun MultiBrandAuthCatalogSection() {
    var selectedBrand by remember { mutableIntStateOf(0) }
    var selectedFlow by remember { mutableIntStateOf(0) }
    val brands = listOf("Food Delivery", "Ride Hailing", "Deal Marketplace", "Marketplace", "Quick Delivery", "Global Marketplace")
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
                    0 -> WgcFoodDeliveryLoginScreenTemplate(viewModel = FakeFoodDeliveryAuthViewModel())
                    1 -> WgcFoodDeliveryRegisterScreenTemplate(viewModel = FakeFoodDeliveryAuthViewModel())
                    2 -> WgcFoodDeliveryResetPasswordScreenTemplate(viewModel = FakeFoodDeliveryAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Food Delivery", brandLogoText = "iF", brandColor = brandColors[0])
                }
                1 -> when (selectedFlow) {
                    0 -> WgcRideHailingLoginScreenTemplate(viewModel = FakeRideHailingAuthViewModel())
                    1 -> WgcRideHailingRegisterScreenTemplate(viewModel = FakeRideHailingAuthViewModel())
                    2 -> WgcRideHailingResetPasswordScreenTemplate(viewModel = FakeRideHailingAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Ride Hailing", brandLogoText = "Ride Hailing", brandColor = brandColors[1])
                }
                2 -> when (selectedFlow) {
                    0 -> WgcDealMarketplaceLoginScreenTemplate(viewModel = FakeDealMarketplaceAuthViewModel())
                    1 -> WgcDealMarketplaceRegisterScreenTemplate(viewModel = FakeDealMarketplaceAuthViewModel())
                    2 -> WgcDealMarketplaceResetPasswordScreenTemplate(viewModel = FakeDealMarketplaceAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Deal Marketplace", brandLogoText = "DM", brandColor = brandColors[2])
                }
                3 -> when (selectedFlow) {
                    0 -> WgcMarketplaceLoginScreenTemplate(viewModel = FakeMarketplaceAuthViewModel())
                    1 -> WgcMarketplaceRegisterScreenTemplate(viewModel = FakeMarketplaceAuthViewModel())
                    2 -> WgcMarketplaceResetPasswordScreenTemplate(viewModel = FakeMarketplaceAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Marketplace", brandLogoText = "MP", brandColor = brandColors[3])
                }
                4 -> when (selectedFlow) {
                    0 -> WgcQuickFoodDeliveryLoginScreenTemplate(viewModel = FakeQuickFoodDeliveryAuthViewModel())
                    1 -> WgcQuickFoodDeliveryRegisterScreenTemplate(viewModel = FakeQuickFoodDeliveryAuthViewModel())
                    2 -> WgcQuickFoodDeliveryResetPasswordScreenTemplate(viewModel = FakeQuickFoodDeliveryAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Quick Food Delivery", brandLogoText = "QD", brandColor = brandColors[4])
                }
                5 -> when (selectedFlow) {
                    0 -> WgcGlobalMarketplaceLoginScreenTemplate(viewModel = FakeGlobalMarketplaceAuthViewModel())
                    1 -> WgcGlobalMarketplaceRegisterScreenTemplate(viewModel = FakeGlobalMarketplaceAuthViewModel())
                    2 -> WgcGlobalMarketplaceResetPasswordScreenTemplate(viewModel = FakeGlobalMarketplaceAuthViewModel())
                    else -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel(), brandName = "Global Marketplace", brandLogoText = "GM", brandColor = brandColors[5])
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

@Suppress("LongMethod")
@Composable
fun WgcProfileFactoryShowcase() {
    var selectedType by remember { mutableStateOf(WgcProfileType.CARE_PHARMACY) }
    var selectedStatus by remember { mutableStateOf(WgcProfileStatus.DEFAULT) }
    var customHeader by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("WgcProfileFactory - Catálogo Universal de Perfis (22 Perfis)", style = MaterialTheme.typography.titleLarge)
        Text("Inspecione individualmente cada um dos 22 perfis com 100% de preservação visual:", style = MaterialTheme.typography.bodyMedium)

        Text("Tipo de Perfil (${selectedType.name}):", style = MaterialTheme.typography.titleSmall)
        PrimaryScrollableTabRow(selectedTabIndex = selectedType.ordinal) {
            WgcProfileType.entries.forEach { type ->
                Tab(
                    selected = selectedType == type,
                    onClick = { selectedType = type },
                    text = { Text(type.name, fontSize = 11.sp) }
                )
            }
        }

        Text("Status de Ciclo de Vida:", style = MaterialTheme.typography.titleSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcProfileStatus.entries.forEach { status ->
                FilterChip(
                    selected = selectedStatus == status,
                    onClick = { selectedStatus = status },
                    label = { Text(status.name) }
                )
            }
        }

        if (selectedType == WgcProfileType.STANDARD) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = customHeader, onCheckedChange = { customHeader = it })
                Text("Injetar Slot Customizado de Header")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(560.dp)
        ) {
            WgcProfileFactory(
                type = selectedType,
                status = selectedStatus,
                headerSlot = if (customHeader && selectedType == WgcProfileType.STANDARD) {
                    {
                        Surface(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        ) {
                            Text(
                                "👑 HEADER VIP CUSTOMIZADO VIA SLOT",
                                modifier = Modifier.padding(16.dp),
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        }
                    }
                } else null
            )
        }
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
            0 -> WgcProfileFactoryShowcase()
            1 -> {
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
            2 -> {
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
            3 -> {
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
            4 -> {
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

                Text("4. Farmácia & Prescrição (Pharmacy Chain):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.PharmacyProduct)
                WgcCardFactory(type = WgcCardType.PharmacyPrescription)

                Text("5. Cuidados & Vacinas (Care Pharmacy):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.HealthVaccine)
                WgcCardFactory(type = WgcCardType.HealthLoyalty)

                Text("6. Farmácia Popular & Convênio (Popular Pharmacy):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.MedicalClinic)
                WgcCardFactory(type = WgcCardType.HealthInsurance)

                Text("7. Fintech (Neobank / SuperApp / Carbon):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.NeobankAccount)
                WgcCardFactory(type = WgcCardType.InterSuperApp)
                WgcCardFactory(type = WgcCardType.C6Carbon)

                Text("8. Mobilidade & Viagens (Urban / Bidding / Bus):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.MobilityRide)

                Text("9. Viagem & Hospedagem (Hospedagem / Decolar):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.TravelStay)

                Text("10. Streaming (AudioStream / VideoStream):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.StreamingMedia)

                Text("11. Educação & Cursos (Language / Tech / Marketplace):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.EducationCourse)

                Text("12. Mensageria & Redes (Direct / Channels):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.MessagingConversation)

                Text("13. Games & Streaming (Gaming Store / Live Stream):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.GameStore)

                Text("14. Produtividade & Tarefas (Workspace Docs / Kanban):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.ProductivityTask)

                Text("15. Fast Food & Delivery (Burger / Flame):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.FastFoodMeal)

                Text("16. Logística & Rastreio (Express / Freight):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.LogisticsPackage)

                Text("17. Vestuário & Moda (Department / Urban / Trend):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.FashionItem)

                Text("18. Beleza & Cosméticos (Fragrance / Natural / Prestige):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.BeautyCosmetic)

                Text("19. Pet Shop & Cuidados (Pet Care / Superstore):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.PetCare)

                Text("20. Casa & Construção (Home Improvement / Designer Furniture):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.HomeImprovement)

                Text("21. Notícias & Mídia (G1 / UOL):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.NewsHeadline)

                Text("22. Governo Digital & Cidadania (Gov.br / CDT):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.GovDigitalDocument)
            }
            5 -> {
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
            6 -> {
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
