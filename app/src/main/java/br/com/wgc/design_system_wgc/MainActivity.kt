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
        // 0-2: Cat 1 - Imobiliárias
        "🏠 QuintoAndar (Imobiliária & Aluguel)",
        "🏡 Viva Real (Classificados Imobiliários)",
        "🏢 Zap Imóveis (Inteligência & Classificados)",
        // 3-5: Cat 2 - Fitness
        "🏋️ Smart Fit (Treinos, Lotação & Acesso)",
        "💪 Wellhub / Gympass (Redes, Check-in & Planos)",
        "⚡ Nike Training Club (Treinos, Player & Metas)",
        // 6-8: Cat 3 - Supermercados
        "🛒 Clube Extra (Supermercado & Meus Descontos)",
        "🍇 Pão de Açúcar Mais (Gourmet, Adega & Cliente Mais)",
        "🏪 Carrefour Brasil (Hipermercado, Moedas & Nutri-Score)",
        // 9-11: Cat 4 - Farmácias
        "💊 Droga Raia (Sua Farmácia Digital & Receitas)",
        "🏥 Drogasil (Farmácia Vizinha, Vacinas & Fidelidade)",
        "💚 Pague Menos (Sempre Bem, Clinic Farma & Convênios)",
        // 12-14: Cat 5 - FinTech
        "💜 Nubank (NuConta, Cartão & Caixinhas)",
        "🧡 Banco Inter (Super App, Inter Shop & Invest)",
        "🖤 C6 Bank (Carbon, Átomos & Conta Global)",
        // 15-17: Cat 6 - Mobilidade
        "🟡 99 (Rides, 99Pay & Corridas)",
        "🟢 inDrive (Negocie o Preço & Lances)",
        "🚌 ClickBus (Passagens Rodoviárias & Poltrona)",
        // 18-20: Cat 7 - Viagem
        "✈️ Decolar (Pacotes & Passaporte Decolar)",
        "🏡 Airbnb (Acomodações Únicas & Experiências)",
        "🌐 Booking.com (Genius & Hotéis com Desconto)",
        // 21-23: Cat 8 - Streaming
        "🔴 Netflix (Séries, Top 10 & Minha Lista)",
        "🟢 Spotify (Player, Playlists & Premium)",
        "🟠 Globoplay (TV Ao Vivo, Novelas & Premiere)",
        // 24-26: Cat 9 - Educação
        "🦜 Duolingo (Inglês, Ofensivas & Ligas)",
        "🔵 Alura (Cursos Tech, Trilhas & Certificados)",
        "🟣 Udemy (200K Cursos & Meus Matriculados)",
        // 27-29: Cat 10 - Mensageria
        "💬 WhatsApp (Chats, Status & Comunidades)",
        "✈️ Telegram (Chats, Cloud & Pastas)",
        "📌 Pinterest (Feed, Criar Pins & Perfil)",
        // 30-32: Cat 11 - Gaming
        "🎮 Steam (Loja, Biblioteca & Wishlist)",
        "🟣 Twitch (Ao Vivo, Emotes & Nitro Subs)",
        "💙 Discord (Servidores, Voz & DMs)",
        // 33-35: Cat 12 - Produtividade
        "⬛ Notion (Workspace, Kanban & Editor)",
        "🟦 Trello (Quadro, Cards & Power-Ups)",
        "🟪 Slack (Canais, Threads & DMs)",
        // 36-38: Cat 13 - Fast Food
        "🍔 McDonald's (Cardápio, Cupons & Meu Méqui)",
        "🔥 Burger King (Menu, Clube BK & Whopper)",
        "🍕 Domino's (Monte sua Pizza & Tracker)",
        // 39-41: Cat 14 - Logística
        "🚗 BlaBlaCar (Caronas Compartilhadas & Oferecer)",
        "📦 Loggi (Rastreamento & Envio Inteligente)",
        "🟠 Lalamove (Cotação Frete & Carreto Express)",
        // 42-44: Cat 15 - Moda Fast Fashion
        "🔴 Lojas Renner (Coleções & Cartão Renner)",
        "🛍️ C&A Brasil (Muito Eu & C&A Pay)",
        "⬛ Riachuelo (Moda, Casa & RCHLO)",
        // 45-47: Cat 16 - Beleza
        "🌿 O Boticário (Perfumaria & Clube Viva)",
        "🟠 Natura (Ekos, Chronos & Refis)",
        "⬛ Sephora (Beauty Club & Luxo)",
        // 48-50: Cat 17 - Pet Care
        "🐾 Petz (Pet Shop Completo & Assinatura)",
        "🐕 Cobasi (Shopping do Animal & Amigo Cobasi)",
        "🖤 Zee.Dog (Design & Kitchen Natural)",
        // 51-53: Cat 18 - Casa & Decor
        "🟢 Leroy Merlin (Construção & Calculadora)",
        "🔴 Tok&Stok (Móveis Design & RA 3D)",
        "🟠 MadeiraMadeira (Planejados & Frete Grátis)",
        // 54-56: Cat 19 - Notícias
        "🔴 g1 (Portal Globo & Fato ou Boato)",
        "🟡 UOL (Cotações, Esportes & Colunistas)",
        "🔵 Exame (Negócios, ESG & Invest)",
        // 57-59: Cat 20 - Serviços Públicos
        "🇧🇷 Gov.br (Serviços Cidadão & Conta Ouro)",
        "🚗 CDT (CNH Digital & CRLV Online)",
        "📋 CTPS (Carteira de Trabalho & Vínculos)",
        // 60+: Extras
        "💰 Organizze (Controle Financeiro)",
        "🛍️ Laza (Streetwear Suite)",
        "🌅 ShopEase (Sunset Orange Store)",
        "🛒 Nexkart (Premium Store)",
        "🌿 Shopper (Emerald Green Store)",
        "✨ Tassel (Minimalist Store)",
        "🧢 Clothee (Sportswear Suite)",
        "👜 Kutuku (Luxury Store)",
        "👗 Shoppe (Fashion Suite)",
        "🛍️ Stylish (16 Telas Figma)",
        "🎨 Figma (3 Templates)",
        "🧩 Componentes (:design-system)",
        "📱 Templates (:ds-templates)",
        "🏭 Fábricas & Slots",
        // 74-78: Novas Suítes Especializadas Figma
        "🦷 DentiCare (Odontologia & Raio-X)",
        "🩺 Doctoralia (Telemedicina & Consultas)",
        "🍺 Zé Delivery (Bebidas Geladas)",
        "🚘 Webmotors (Carros & Tabela FIPE)",
        "⚡ KaBuM! (Hardware & Ofertas Ninja)"
    )

    val quintoAndarScreens = br.com.wgc.ds_templates.factories.WgcQuintoAndarScreen.entries
    var selectedQuintoAndarScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val vivaRealScreens = br.com.wgc.ds_templates.factories.WgcVivaRealScreen.entries
    var selectedVivaRealScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val zapScreens = br.com.wgc.ds_templates.factories.WgcZapScreen.entries
    var selectedZapScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val smartFitScreens = br.com.wgc.ds_templates.factories.WgcSmartFitScreen.entries
    var selectedSmartFitScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val wellhubScreens = br.com.wgc.ds_templates.factories.WgcWellhubScreen.entries
    var selectedWellhubScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val ntcScreens = br.com.wgc.ds_templates.factories.WgcNtcScreen.entries
    var selectedNtcScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val extraScreens = br.com.wgc.ds_templates.factories.WgcExtraScreen.entries
    var selectedExtraScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val pdaScreens = br.com.wgc.ds_templates.factories.WgcPdaScreen.entries
    var selectedPdaScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val carrefourScreens = br.com.wgc.ds_templates.factories.WgcCarrefourScreen.entries
    var selectedCarrefourScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val drogaRaiaScreens = br.com.wgc.ds_templates.factories.WgcDrogaRaiaScreen.entries
    var selectedDrogaRaiaScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val drogasilScreens = br.com.wgc.ds_templates.factories.WgcDrogasilScreen.entries
    var selectedDrogasilScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    val pagueMenosScreens = br.com.wgc.ds_templates.factories.WgcPagueMenosScreen.entries
    var selectedPagueMenosScreenIndex by remember { mutableIntStateOf(0) } // Default: Home

    // Cat 5: FinTech
    val nubankScreens = br.com.wgc.ds_templates.factories.WgcNubankScreen.entries
    var selectedNubankScreenIndex by remember { mutableIntStateOf(0) }
    val interScreens = br.com.wgc.ds_templates.factories.WgcInterScreen.entries
    var selectedInterScreenIndex by remember { mutableIntStateOf(0) }
    val c6Screens = br.com.wgc.ds_templates.factories.WgcC6Screen.entries
    var selectedC6ScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 6: Mobilidade
    val noveNoveScreens = br.com.wgc.ds_templates.factories.WgcNoveNoveScreen.entries
    var selectedNoveNoveScreenIndex by remember { mutableIntStateOf(0) }
    val inDriveScreens = br.com.wgc.ds_templates.factories.WgcInDriveScreen.entries
    var selectedInDriveScreenIndex by remember { mutableIntStateOf(0) }
    val clickBusScreens = br.com.wgc.ds_templates.factories.WgcClickBusScreen.entries
    var selectedClickBusScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 7: Viagem
    val decolarScreens = br.com.wgc.ds_templates.factories.WgcDecolarScreen.entries
    var selectedDecolarScreenIndex by remember { mutableIntStateOf(0) }
    val airbnbScreens = br.com.wgc.ds_templates.factories.WgcAirbnbScreen.entries
    var selectedAirbnbScreenIndex by remember { mutableIntStateOf(0) }
    val bookingScreens = br.com.wgc.ds_templates.factories.WgcBookingScreen.entries
    var selectedBookingScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 8: Streaming
    val netflixScreens = br.com.wgc.ds_templates.factories.WgcNetflixScreen.entries
    var selectedNetflixScreenIndex by remember { mutableIntStateOf(0) }
    val spotifyScreens = br.com.wgc.ds_templates.factories.WgcSpotifyScreen.entries
    var selectedSpotifyScreenIndex by remember { mutableIntStateOf(0) }
    val globoplayScreens = br.com.wgc.ds_templates.factories.WgcGloboplayScreen.entries
    var selectedGloboplayScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 9: Educação
    val duolingoScreens = br.com.wgc.ds_templates.factories.WgcDuolingoScreen.entries
    var selectedDuolingoScreenIndex by remember { mutableIntStateOf(0) }
    val aluraScreens = br.com.wgc.ds_templates.factories.WgcAluraScreen.entries
    var selectedAluraScreenIndex by remember { mutableIntStateOf(0) }
    val udemyScreens = br.com.wgc.ds_templates.factories.WgcUdemyScreen.entries
    var selectedUdemyScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 10: Mensageria
    val whatsAppScreens = br.com.wgc.ds_templates.factories.WgcWhatsAppScreen.entries
    var selectedWhatsAppScreenIndex by remember { mutableIntStateOf(0) }
    val telegramScreens = br.com.wgc.ds_templates.factories.WgcTelegramScreen.entries
    var selectedTelegramScreenIndex by remember { mutableIntStateOf(0) }
    val pinterestScreens = br.com.wgc.ds_templates.factories.WgcPinterestScreen.entries
    var selectedPinterestScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 11: Gaming
    val steamScreens = br.com.wgc.ds_templates.factories.WgcSteamScreen.entries
    var selectedSteamScreenIndex by remember { mutableIntStateOf(0) }
    val twitchScreens = br.com.wgc.ds_templates.factories.WgcTwitchScreen.entries
    var selectedTwitchScreenIndex by remember { mutableIntStateOf(0) }
    val discordScreens = br.com.wgc.ds_templates.factories.WgcDiscordScreen.entries
    var selectedDiscordScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 12: Produtividade
    val notionScreens = br.com.wgc.ds_templates.factories.WgcNotionScreen.entries
    var selectedNotionScreenIndex by remember { mutableIntStateOf(0) }
    val trelloScreens = br.com.wgc.ds_templates.factories.WgcTrelloScreen.entries
    var selectedTrelloScreenIndex by remember { mutableIntStateOf(0) }
    val slackScreens = br.com.wgc.ds_templates.factories.WgcSlackScreen.entries
    var selectedSlackScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 13: Fast Food
    val mcDonaldsScreens = br.com.wgc.ds_templates.factories.WgcMcDonaldsScreen.entries
    var selectedMcDonaldsScreenIndex by remember { mutableIntStateOf(0) }
    val burgerKingScreens = br.com.wgc.ds_templates.factories.WgcBurgerKingScreen.entries
    var selectedBurgerKingScreenIndex by remember { mutableIntStateOf(0) }
    val dominosScreens = br.com.wgc.ds_templates.factories.WgcDominosScreen.entries
    var selectedDominosScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 14: Logística
    val blaBlaCarScreens = br.com.wgc.ds_templates.factories.WgcBlaBlaCarScreen.entries
    var selectedBlaBlaCarScreenIndex by remember { mutableIntStateOf(0) }
    val loggiScreens = br.com.wgc.ds_templates.factories.WgcLoggiScreen.entries
    var selectedLoggiScreenIndex by remember { mutableIntStateOf(0) }
    val lalamoveScreens = br.com.wgc.ds_templates.factories.WgcLalamoveScreen.entries
    var selectedLalamoveScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 15: Moda
    val rennerScreens = br.com.wgc.ds_templates.factories.WgcRennerScreen.entries
    var selectedRennerScreenIndex by remember { mutableIntStateOf(0) }
    val ceaScreens = br.com.wgc.ds_templates.factories.WgcCeaScreen.entries
    var selectedCeaScreenIndex by remember { mutableIntStateOf(0) }
    val riachueloScreens = br.com.wgc.ds_templates.factories.WgcRiachueloScreen.entries
    var selectedRiachueloScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 16: Beleza
    val boticarioScreens = br.com.wgc.ds_templates.factories.WgcBoticarioScreen.entries
    var selectedBoticarioScreenIndex by remember { mutableIntStateOf(0) }
    val naturaScreens = br.com.wgc.ds_templates.factories.WgcNaturaScreen.entries
    var selectedNaturaScreenIndex by remember { mutableIntStateOf(0) }
    val sephoraScreens = br.com.wgc.ds_templates.factories.WgcSephoraScreen.entries
    var selectedSephoraScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 17: Pet Care
    val petzScreens = br.com.wgc.ds_templates.factories.WgcPetzScreen.entries
    var selectedPetzScreenIndex by remember { mutableIntStateOf(0) }
    val cobasiScreens = br.com.wgc.ds_templates.factories.WgcCobasiScreen.entries
    var selectedCobasiScreenIndex by remember { mutableIntStateOf(0) }
    val zeeDogScreens = br.com.wgc.ds_templates.factories.WgcZeeDogScreen.entries
    var selectedZeeDogScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 18: Casa & Decor
    val leroyMerlinScreens = br.com.wgc.ds_templates.factories.WgcLeroyMerlinScreen.entries
    var selectedLeroyMerlinScreenIndex by remember { mutableIntStateOf(0) }
    val tokStokScreens = br.com.wgc.ds_templates.factories.WgcTokStokScreen.entries
    var selectedTokStokScreenIndex by remember { mutableIntStateOf(0) }
    val madeiraMadeiraScreens = br.com.wgc.ds_templates.factories.WgcMadeiraMadeiraScreen.entries
    var selectedMadeiraMadeiraScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 19: Notícias
    val g1Screens = br.com.wgc.ds_templates.factories.WgcG1Screen.entries
    var selectedG1ScreenIndex by remember { mutableIntStateOf(0) }
    val uolScreens = br.com.wgc.ds_templates.factories.WgcUolScreen.entries
    var selectedUolScreenIndex by remember { mutableIntStateOf(0) }
    val exameScreens = br.com.wgc.ds_templates.factories.WgcExameScreen.entries
    var selectedExameScreenIndex by remember { mutableIntStateOf(0) }
    // Cat 20: Serviços Públicos
    val govBrScreens = br.com.wgc.ds_templates.factories.WgcGovBrScreen.entries
    var selectedGovBrScreenIndex by remember { mutableIntStateOf(0) }
    val cdtScreens = br.com.wgc.ds_templates.factories.WgcCdtScreen.entries
    var selectedCdtScreenIndex by remember { mutableIntStateOf(0) }
    val ctpsScreens = br.com.wgc.ds_templates.factories.WgcCtpsScreen.entries
    var selectedCtpsScreenIndex by remember { mutableIntStateOf(0) }

    // Novas Suítes Figma
    val dentiCareScreens = br.com.wgc.ds_templates.factories.WgcDentiCareScreen.entries
    var selectedDentiCareScreenIndex by remember { mutableIntStateOf(0) }

    val doctoraliaScreens = br.com.wgc.ds_templates.factories.WgcDoctoraliaScreen.entries
    var selectedDoctoraliaScreenIndex by remember { mutableIntStateOf(0) }

    val zeDeliveryScreens = br.com.wgc.ds_templates.factories.WgcZeDeliveryScreen.entries
    var selectedZeDeliveryScreenIndex by remember { mutableIntStateOf(0) }

    val webmotorsScreens = br.com.wgc.ds_templates.factories.WgcWebmotorsScreen.entries
    var selectedWebmotorsScreenIndex by remember { mutableIntStateOf(0) }

    val kabumScreens = br.com.wgc.ds_templates.factories.WgcKaBuMScreen.entries
    var selectedKaBuMScreenIndex by remember { mutableIntStateOf(0) }

    val organizzeScreens = br.com.wgc.ds_templates.factories.WgcOrganizzeScreen.entries
    var selectedOrganizzeScreenIndex by remember { mutableIntStateOf(0) } // Default: Dashboard

    val lazaScreens = br.com.wgc.ds_templates.factories.WgcLazaScreen.entries
    var selectedLazaScreenIndex by remember { mutableIntStateOf(3) } // Default: Home

    val nexkartScreens = br.com.wgc.ds_templates.factories.WgcNexkartScreen.entries
    var selectedNexkartScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val shopEaseScreens = br.com.wgc.ds_templates.factories.WgcShopEaseScreen.entries
    var selectedShopEaseScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val shopperScreens = br.com.wgc.ds_templates.factories.WgcShopperScreen.entries
    var selectedShopperScreenIndex by remember { mutableIntStateOf(1) } // Default: Home

    val tasselScreens = br.com.wgc.ds_templates.factories.WgcTasselScreen.entries
    var selectedTasselScreenIndex by remember { mutableIntStateOf(0) } // Default: Market

    val clotheeScreens = br.com.wgc.ds_templates.factories.WgcClotheeScreen.entries
    var selectedClotheeScreenIndex by remember { mutableIntStateOf(3) } // Default: Home

    val kutukuScreens = br.com.wgc.ds_templates.factories.WgcKutukuScreen.entries
    var selectedKutukuScreenIndex by remember { mutableIntStateOf(2) } // Default: Home

    val shoppeScreens = br.com.wgc.ds_templates.factories.WgcShoppeScreen.entries
    var selectedShoppeScreenIndex by remember { mutableIntStateOf(4) } // Default: HomeShop

    val stylishScreens = br.com.wgc.ds_templates.factories.WgcStylishScreen.entries
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedQuintoAndarScreenIndex) {
                    quintoAndarScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedQuintoAndarScreenIndex == index,
                            onClick = { selectedQuintoAndarScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            1 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedVivaRealScreenIndex) {
                    vivaRealScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedVivaRealScreenIndex == index,
                            onClick = { selectedVivaRealScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedSmartFitScreenIndex) {
                    smartFitScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedSmartFitScreenIndex == index,
                            onClick = { selectedSmartFitScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            4 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedWellhubScreenIndex) {
                    wellhubScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedWellhubScreenIndex == index,
                            onClick = { selectedWellhubScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedCarrefourScreenIndex) {
                    carrefourScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedCarrefourScreenIndex == index,
                            onClick = { selectedCarrefourScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedNubankScreenIndex) {
                    nubankScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNubankScreenIndex == index,
                            onClick = { selectedNubankScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedAirbnbScreenIndex) {
                    airbnbScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedAirbnbScreenIndex == index,
                            onClick = { selectedAirbnbScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            20 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBookingScreenIndex) {
                    bookingScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBookingScreenIndex == index,
                            onClick = { selectedBookingScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            21 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedNetflixScreenIndex) {
                    netflixScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedNetflixScreenIndex == index,
                            onClick = { selectedNetflixScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            22 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedSpotifyScreenIndex) {
                    spotifyScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedSpotifyScreenIndex == index,
                            onClick = { selectedSpotifyScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedDiscordScreenIndex) {
                    discordScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDiscordScreenIndex == index,
                            onClick = { selectedDiscordScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedMcDonaldsScreenIndex) {
                    mcDonaldsScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedMcDonaldsScreenIndex == index,
                            onClick = { selectedMcDonaldsScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedDominosScreenIndex) {
                    dominosScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDominosScreenIndex == index,
                            onClick = { selectedDominosScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            39 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedBlaBlaCarScreenIndex) {
                    blaBlaCarScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedBlaBlaCarScreenIndex == index,
                            onClick = { selectedBlaBlaCarScreenIndex = index },
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
                PrimaryScrollableTabRow(selectedTabIndex = selectedDentiCareScreenIndex) {
                    dentiCareScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDentiCareScreenIndex == index,
                            onClick = { selectedDentiCareScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            75 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedDoctoraliaScreenIndex) {
                    doctoraliaScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedDoctoraliaScreenIndex == index,
                            onClick = { selectedDoctoraliaScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            76 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedZeDeliveryScreenIndex) {
                    zeDeliveryScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedZeDeliveryScreenIndex == index,
                            onClick = { selectedZeDeliveryScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            77 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedWebmotorsScreenIndex) {
                    webmotorsScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedWebmotorsScreenIndex == index,
                            onClick = { selectedWebmotorsScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
            78 -> {
                PrimaryScrollableTabRow(selectedTabIndex = selectedKaBuMScreenIndex) {
                    kabumScreens.forEachIndexed { index, screen ->
                        Tab(
                            selected = selectedKaBuMScreenIndex == index,
                            onClick = { selectedKaBuMScreenIndex = index },
                            text = { Text(text = "${index + 1}. ${screen.name}", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold) }
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            when (primarySection) {
                0 -> {
                    val currentScreen = quintoAndarScreens[selectedQuintoAndarScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcQuintoAndarFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedQuintoAndarScreenIndex = quintoAndarScreens.indexOf(targetScreen)
                        }
                    )
                }
                1 -> {
                    val currentScreen = vivaRealScreens[selectedVivaRealScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcVivaRealFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedVivaRealScreenIndex = vivaRealScreens.indexOf(targetScreen)
                        }
                    )
                }
                2 -> {
                    val currentScreen = zapScreens[selectedZapScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcZapFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedZapScreenIndex = zapScreens.indexOf(targetScreen)
                        }
                    )
                }
                3 -> {
                    val currentScreen = smartFitScreens[selectedSmartFitScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcSmartFitFactory.Screen(
                        screen = currentScreen,
                        onNavigateScreen = { targetScreen ->
                            selectedSmartFitScreenIndex = smartFitScreens.indexOf(targetScreen)
                        }
                    )
                }
                4 -> {
                    val currentScreen = wellhubScreens[selectedWellhubScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcWellhubFactory.Screen(
                        screen = currentScreen,
                        onNavigateScreen = { targetScreen ->
                            selectedWellhubScreenIndex = wellhubScreens.indexOf(targetScreen)
                        }
                    )
                }
                5 -> {
                    val currentScreen = ntcScreens[selectedNtcScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNtcFactory(
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
                    br.com.wgc.ds_templates.factories.WgcExtraFactory(
                        screen = currentScreen,
                        onNavigateToDiscounts = { selectedExtraScreenIndex = 1 },
                        onNavigateToFlyer = { selectedExtraScreenIndex = 2 },
                        onNavigateToCart = { selectedExtraScreenIndex = 3 },
                        onNavigateToLoyalty = { selectedExtraScreenIndex = 4 }
                    )
                }
                7 -> {
                    val currentScreen = pdaScreens[selectedPdaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPdaFactory(
                        screen = currentScreen,
                        onNavSelect = { navIdx -> selectedPdaScreenIndex = navIdx }
                    )
                }
                8 -> {
                    val currentScreen = carrefourScreens[selectedCarrefourScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCarrefourFactory(
                        screen = currentScreen,
                        onTabSelected = { tab ->
                            selectedCarrefourScreenIndex = when (tab) {
                                br.com.wgc.design_system.components.navigation.CarrefourNavTab.HOME -> 0
                                br.com.wgc.design_system.components.navigation.CarrefourNavTab.COUPONS -> 1
                                br.com.wgc.design_system.components.navigation.CarrefourNavTab.FLYER -> 2
                                br.com.wgc.design_system.components.navigation.CarrefourNavTab.CART -> 3
                                br.com.wgc.design_system.components.navigation.CarrefourNavTab.MEU_CARREFOUR -> 4
                            }
                        }
                    )
                }
                9 -> {
                    val currentScreen = drogaRaiaScreens[selectedDrogaRaiaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDrogaRaiaFactory(
                        screen = currentScreen,
                        onTabSelected = { tab ->
                            selectedDrogaRaiaScreenIndex = when (tab) {
                                br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab.HOME -> 0
                                br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab.PRESCRIPTIONS -> 1
                                br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab.SUBSCRIPTION -> 2
                                br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab.CART -> 3
                                br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab.PROFILE -> 4
                            }
                        }
                    )
                }
                10 -> {
                    val currentScreen = drogasilScreens[selectedDrogasilScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDrogasilFactory(
                        screen = currentScreen
                    )
                }
                11 -> {
                    val currentScreen = pagueMenosScreens[selectedPagueMenosScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPagueMenosFactory(
                        screen = currentScreen
                    )
                }
                12 -> {
                    val currentScreen = nubankScreens[selectedNubankScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNubankFactory(
                        screen = currentScreen
                    )
                }
                13 -> {
                    val currentScreen = interScreens[selectedInterScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcInterFactory(
                        screen = currentScreen
                    )
                }
                14 -> {
                    val currentScreen = c6Screens[selectedC6ScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcC6Factory(
                        screen = currentScreen
                    )
                }
                15 -> {
                    val currentScreen = noveNoveScreens[selectedNoveNoveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNoveNoveFactory(
                        screen = currentScreen
                    )
                }
                16 -> {
                    val currentScreen = inDriveScreens[selectedInDriveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcInDriveFactory(
                        screen = currentScreen
                    )
                }
                17 -> {
                    val currentScreen = clickBusScreens[selectedClickBusScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcClickBusFactory(
                        screen = currentScreen
                    )
                }
                18 -> {
                    val currentScreen = decolarScreens[selectedDecolarScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDecolarFactory(
                        screen = currentScreen
                    )
                }
                19 -> {
                    val currentScreen = airbnbScreens[selectedAirbnbScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcAirbnbFactory(
                        screen = currentScreen
                    )
                }
                20 -> {
                    val currentScreen = bookingScreens[selectedBookingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBookingFactory(
                        screen = currentScreen
                    )
                }
                21 -> {
                    val currentScreen = netflixScreens[selectedNetflixScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNetflixFactory(
                        screen = currentScreen
                    )
                }
                22 -> {
                    val currentScreen = spotifyScreens[selectedSpotifyScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcSpotifyFactory(
                        screen = currentScreen
                    )
                }
                23 -> {
                    val currentScreen = globoplayScreens[selectedGloboplayScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGloboplayFactory(
                        screen = currentScreen
                    )
                }
                24 -> {
                    val currentScreen = duolingoScreens[selectedDuolingoScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDuolingoFactory(
                        screen = currentScreen
                    )
                }
                25 -> {
                    val currentScreen = aluraScreens[selectedAluraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcAluraFactory(
                        screen = currentScreen
                    )
                }
                26 -> {
                    val currentScreen = udemyScreens[selectedUdemyScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcUdemyFactory(
                        screen = currentScreen
                    )
                }
                27 -> {
                    val currentScreen = whatsAppScreens[selectedWhatsAppScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcWhatsAppFactory(
                        screen = currentScreen
                    )
                }
                28 -> {
                    val currentScreen = telegramScreens[selectedTelegramScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTelegramFactory(
                        screen = currentScreen
                    )
                }
                29 -> {
                    val currentScreen = pinterestScreens[selectedPinterestScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPinterestFactory(
                        screen = currentScreen
                    )
                }
                30 -> {
                    val currentScreen = steamScreens[selectedSteamScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcSteamFactory(
                        screen = currentScreen
                    )
                }
                31 -> {
                    val currentScreen = twitchScreens[selectedTwitchScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTwitchFactory(
                        screen = currentScreen
                    )
                }
                32 -> {
                    val currentScreen = discordScreens[selectedDiscordScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDiscordFactory(
                        screen = currentScreen
                    )
                }
                33 -> {
                    val currentScreen = notionScreens[selectedNotionScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNotionFactory(
                        screen = currentScreen
                    )
                }
                34 -> {
                    val currentScreen = trelloScreens[selectedTrelloScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTrelloFactory(
                        screen = currentScreen
                    )
                }
                35 -> {
                    val currentScreen = slackScreens[selectedSlackScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcSlackFactory(
                        screen = currentScreen
                    )
                }
                36 -> {
                    val currentScreen = mcDonaldsScreens[selectedMcDonaldsScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcMcDonaldsFactory(
                        screen = currentScreen
                    )
                }
                37 -> {
                    val currentScreen = burgerKingScreens[selectedBurgerKingScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBurgerKingFactory(
                        screen = currentScreen
                    )
                }
                38 -> {
                    val currentScreen = dominosScreens[selectedDominosScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDominosFactory(
                        screen = currentScreen
                    )
                }
                39 -> {
                    val currentScreen = blaBlaCarScreens[selectedBlaBlaCarScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBlaBlaCarFactory(
                        screen = currentScreen
                    )
                }
                40 -> {
                    val currentScreen = loggiScreens[selectedLoggiScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLoggiFactory(
                        screen = currentScreen
                    )
                }
                41 -> {
                    val currentScreen = lalamoveScreens[selectedLalamoveScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLalamoveFactory(
                        screen = currentScreen
                    )
                }
                42 -> {
                    val currentScreen = rennerScreens[selectedRennerScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcRennerFactory(
                        screen = currentScreen
                    )
                }
                43 -> {
                    val currentScreen = ceaScreens[selectedCeaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCeaFactory(
                        screen = currentScreen
                    )
                }
                44 -> {
                    val currentScreen = riachueloScreens[selectedRiachueloScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcRiachueloFactory(
                        screen = currentScreen
                    )
                }
                45 -> {
                    val currentScreen = boticarioScreens[selectedBoticarioScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcBoticarioFactory(
                        screen = currentScreen
                    )
                }
                46 -> {
                    val currentScreen = naturaScreens[selectedNaturaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcNaturaFactory(
                        screen = currentScreen
                    )
                }
                47 -> {
                    val currentScreen = sephoraScreens[selectedSephoraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcSephoraFactory(
                        screen = currentScreen
                    )
                }
                48 -> {
                    val currentScreen = petzScreens[selectedPetzScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcPetzFactory(
                        screen = currentScreen
                    )
                }
                49 -> {
                    val currentScreen = cobasiScreens[selectedCobasiScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCobasiFactory(
                        screen = currentScreen
                    )
                }
                50 -> {
                    val currentScreen = zeeDogScreens[selectedZeeDogScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcZeeDogFactory(
                        screen = currentScreen
                    )
                }
                51 -> {
                    val currentScreen = leroyMerlinScreens[selectedLeroyMerlinScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLeroyMerlinFactory(
                        screen = currentScreen
                    )
                }
                52 -> {
                    val currentScreen = tokStokScreens[selectedTokStokScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcTokStokFactory(
                        screen = currentScreen
                    )
                }
                53 -> {
                    val currentScreen = madeiraMadeiraScreens[selectedMadeiraMadeiraScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcMadeiraMadeiraFactory(
                        screen = currentScreen
                    )
                }
                54 -> {
                    val currentScreen = g1Screens[selectedG1ScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcG1Factory(
                        screen = currentScreen
                    )
                }
                55 -> {
                    val currentScreen = uolScreens[selectedUolScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcUolFactory(
                        screen = currentScreen
                    )
                }
                56 -> {
                    val currentScreen = exameScreens[selectedExameScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcExameFactory(
                        screen = currentScreen
                    )
                }
                57 -> {
                    val currentScreen = govBrScreens[selectedGovBrScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcGovBrFactory(
                        screen = currentScreen
                    )
                }
                58 -> {
                    val currentScreen = cdtScreens[selectedCdtScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCdtFactory(
                        screen = currentScreen
                    )
                }
                59 -> {
                    val currentScreen = ctpsScreens[selectedCtpsScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcCtpsFactory(
                        screen = currentScreen
                    )
                }
                60 -> {
                    val currentScreen = organizzeScreens[selectedOrganizzeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcOrganizzeFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedOrganizzeScreenIndex = organizzeScreens.indexOf(targetScreen)
                        }
                    )
                }
                61 -> {
                    val currentScreen = lazaScreens[selectedLazaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcLazaFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedLazaScreenIndex = lazaScreens.indexOf(targetScreen)
                        }
                    )
                }
                62 -> {
                    val currentScreen = shopEaseScreens[selectedShopEaseScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcShopEaseFactory(
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
                    br.com.wgc.ds_templates.factories.WgcNexkartFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedNexkartScreenIndex = nexkartScreens.indexOf(targetScreen)
                        }
                    )
                }
                64 -> {
                    val currentScreen = shopperScreens[selectedShopperScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcShopperFactory(
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
                    br.com.wgc.ds_templates.factories.WgcTasselFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedTasselScreenIndex = tasselScreens.indexOf(targetScreen)
                        }
                    )
                }
                66 -> {
                    val currentScreen = clotheeScreens[selectedClotheeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcClotheeFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedClotheeScreenIndex = clotheeScreens.indexOf(targetScreen)
                        }
                    )
                }
                67 -> {
                    val currentScreen = kutukuScreens[selectedKutukuScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcKutukuFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedKutukuScreenIndex = kutukuScreens.indexOf(targetScreen)
                        }
                    )
                }
                68 -> {
                    val currentScreen = shoppeScreens[selectedShoppeScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcShoppeFactory(
                        screen = currentScreen,
                        onNavigate = { targetScreen ->
                            selectedShoppeScreenIndex = shoppeScreens.indexOf(targetScreen)
                        }
                    )
                }
                69 -> {
                    val currentScreen = stylishScreens[selectedStylishScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcStylishFactory(
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
                        4 -> MercadoLivreHomeScreenTemplate(viewModel = FakeMercadoLivreHomeViewModel())
                        5 -> NineNineFoodHomeScreenTemplate(viewModel = FakeNineNineFoodHomeViewModel())
                        6 -> IFoodHomeScreenTemplate(viewModel = FakeIFoodHomeViewModel())
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
                    val currentScreen = dentiCareScreens[selectedDentiCareScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDentiCareFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedDentiCareScreenIndex = dentiCareScreens.indexOf(targetScreen)
                        }
                    )
                }
                75 -> {
                    val currentScreen = doctoraliaScreens[selectedDoctoraliaScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcDoctoraliaFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedDoctoraliaScreenIndex = doctoraliaScreens.indexOf(targetScreen)
                        }
                    )
                }
                76 -> {
                    val currentScreen = zeDeliveryScreens[selectedZeDeliveryScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcZeDeliveryFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedZeDeliveryScreenIndex = zeDeliveryScreens.indexOf(targetScreen)
                        }
                    )
                }
                77 -> {
                    val currentScreen = webmotorsScreens[selectedWebmotorsScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcWebmotorsFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedWebmotorsScreenIndex = webmotorsScreens.indexOf(targetScreen)
                        }
                    )
                }
                78 -> {
                    val currentScreen = kabumScreens[selectedKaBuMScreenIndex]
                    br.com.wgc.ds_templates.factories.WgcKaBuMFactory(
                        screen = currentScreen,
                        onNavigateToScreen = { targetScreen ->
                            selectedKaBuMScreenIndex = kabumScreens.indexOf(targetScreen)
                        }
                    )
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
        WgcMerchantListingCard(name = "McDonald's", rating = "4.8", deliveryFee = "Grátis")
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

                Text("4. Droga Raia (Farmácia & Prescrição):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.DrogaRaiaProduct)
                WgcCardFactory(type = WgcCardType.DrogaRaiaPrescription)

                Text("5. Drogasil (Vacinas & Fidelidade):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.DrogasilVaccine)
                WgcCardFactory(type = WgcCardType.DrogasilLoyalty)

                Text("6. Pague Menos (Clinic Farma & Convênio):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.PagueMenosClinic)
                WgcCardFactory(type = WgcCardType.PagueMenosConvenio)

                Text("7. Nubank / Inter / C6 Bank (FinTech):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.NubankAccount)
                WgcCardFactory(type = WgcCardType.InterSuperApp)
                WgcCardFactory(type = WgcCardType.C6Carbon)

                Text("8. Mobilidade (99 / inDrive / ClickBus):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.MobilityRide)

                Text("9. Viagem & Hospedagem (Airbnb / Decolar):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.TravelStay)

                Text("10. Streaming (Spotify / Netflix):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.StreamingMedia)

                Text("11. Educação (Duolingo / Alura):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.EducationCourse)

                Text("12. Mensageria & Redes (WhatsApp / Telegram):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.MessagingConversation)

                Text("13. Games (Steam / Twitch):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.GameStore)

                Text("14. Produtividade (Notion / Trello):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.ProductivityTask)

                Text("15. Fast Food & Delivery (McDonald's / BK):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.FastFoodMeal)

                Text("16. Logística & Rastreio (Loggi / Lalamove):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.LogisticsPackage)

                Text("17. Vestuário & Moda (Renner / C&A):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.FashionItem)

                Text("18. Beleza & Cosméticos (O Boticário / Sephora):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.BeautyCosmetic)

                Text("19. Pet Shop & Cuidados (Petz / Cobasi):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.PetCare)

                Text("20. Casa & Construção (Leroy Merlin / Tok&Stok):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.HomeImprovement)

                Text("21. Notícias & Mídia (G1 / UOL):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.NewsHeadline)

                Text("22. Governo Digital & Cidadania (Gov.br / CDT):", style = MaterialTheme.typography.titleSmall)
                WgcCardFactory(type = WgcCardType.GovDigitalDocument)
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
