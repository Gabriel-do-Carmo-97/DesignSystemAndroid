package br.com.wgc.ds_templates.brand

import androidx.compose.ui.graphics.Color

/**
 * Marcas suportadas pelo ecossistema de templates do WGC Design System.
 */
enum class WgcBrand(
    val brandName: String,
    val brandLogoText: String,
    val primaryColor: Color
) {
    IFood(
        brandName = "iFood",
        brandLogoText = "iF",
        primaryColor = Color(0xFFEA1D2C)
    ),
    Uber(
        brandName = "Uber",
        brandLogoText = "Uber",
        primaryColor = Color(0xFF000000)
    ),
    MercadoLivre(
        brandName = "Mercado Livre",
        brandLogoText = "ML",
        primaryColor = Color(0xFFFFE600)
    ),
    NineNineFood(
        brandName = "99Food",
        brandLogoText = "99",
        primaryColor = Color(0xFFFF5722)
    ),
    Shopee(
        brandName = "Shopee",
        brandLogoText = "Shopee",
        primaryColor = Color(0xFFEE4D2D)
    ),
    AliExpress(
        brandName = "AliExpress",
        brandLogoText = "Ali",
        primaryColor = Color(0xFFFF4747)
    ),
    Klok(
        brandName = "KLOK",
        brandLogoText = "KLOK",
        primaryColor = Color(0xFFFF9800)
    ),
    CleanWave(
        brandName = "Clean Wave",
        brandLogoText = "Wave",
        primaryColor = Color(0xFF1976D2)
    ),
    SplitCard(
        brandName = "Split Card",
        brandLogoText = "Split",
        primaryColor = Color(0xFF0288D1)
    ),
    Stylish(
        brandName = "Stylish",
        brandLogoText = "Stylish",
        primaryColor = Color(0xFFF83758)
    ),
    Shoppe(
        brandName = "Shoppe",
        brandLogoText = "Shoppe",
        primaryColor = Color(0xFF004CFF)
    ),
    Kutuku(
        brandName = "Kutuku",
        brandLogoText = "Kutuku",
        primaryColor = Color(0xFF514EB7)
    ),
    Clothee(
        brandName = "Clothee",
        brandLogoText = "Clothee",
        primaryColor = Color(0xFF8E6CEF)
    ),
    Laza(
        brandName = "Laza",
        brandLogoText = "Laza",
        primaryColor = Color(0xFF9775FA)
    ),
    Tassel(
        brandName = "Tassel",
        brandLogoText = "Tassel",
        primaryColor = Color(0xFF4D38DC)
    ),
    Shopper(
        brandName = "Shopper",
        brandLogoText = "Shopper",
        primaryColor = Color(0xFF00966B)
    ),
    Nexkart(
        brandName = "Nexkart",
        brandLogoText = "Nexkart",
        primaryColor = Color(0xFF2D60FF)
    ),
    ShopEase(
        brandName = "ShopEase",
        brandLogoText = "ShopEase",
        primaryColor = Color(0xFFFF8C42)
    ),
    Organizze(
        brandName = "Organizze",
        brandLogoText = "Organizze",
        primaryColor = Color(0xFF2ECC71)
    ),
    QuintoAndar(
        brandName = "QuintoAndar",
        brandLogoText = "QuintoAndar",
        primaryColor = Color(0xFF1C2A44)
    ),
    VivaReal(
        brandName = "Viva Real",
        brandLogoText = "Viva Real",
        primaryColor = Color(0xFF1C9963)
    ),
    Zap(
        brandName = "Zap Imóveis",
        brandLogoText = "ZAP",
        primaryColor = Color(0xFF002F6C)
    ),
    SmartFit(
        brandName = "Smart Fit",
        brandLogoText = "SF",
        primaryColor = Color(0xFFFFB800)
    ),
    Wellhub(
        brandName = "Wellhub (Gympass)",
        brandLogoText = "WH",
        primaryColor = Color(0xFFFF4338)
    ),
    NikeTrainingClub(
        brandName = "Nike Training Club",
        brandLogoText = "NTC",
        primaryColor = Color(0xFFD0FF00)
    ),
    ClubeExtra(
        brandName = "Clube Extra",
        brandLogoText = "Extra",
        primaryColor = Color(0xFFE30613)
    ),
    PaoDeAcucar(
        brandName = "Pão de Açúcar Mais",
        brandLogoText = "PDA",
        primaryColor = Color(0xFF006837)
    ),
    Carrefour(
        brandName = "Carrefour Brasil",
        brandLogoText = "CRF",
        primaryColor = Color(0xFF00387B)
    ),
    DrogaRaia(
        brandName = "Droga Raia",
        brandLogoText = "Raia",
        primaryColor = Color(0xFFC8102E)
    ),
    Drogasil(
        brandName = "Drogasil",
        brandLogoText = "Drogasil",
        primaryColor = Color(0xFFE30613)
    ),
    PagueMenos(
        brandName = "Pague Menos",
        brandLogoText = "PGM",
        primaryColor = Color(0xFF00A859)
    ),
    Nubank(
        brandName = "Nubank",
        brandLogoText = "Nu",
        primaryColor = Color(0xFF820AD1)
    ),
    BancoInter(
        brandName = "Inter",
        brandLogoText = "Inter",
        primaryColor = Color(0xFFFF7A00)
    ),
    C6Bank(
        brandName = "C6 Bank",
        brandLogoText = "C6",
        primaryColor = Color(0xFF242424)
    ),

    // Cat 6: Mobilidade
    NinetyNine("99", "99", Color(0xFFFFC800)),
    InDrive("inDrive", "inDrive", Color(0xFF29B75F)),
    ClickBus("ClickBus", "ClickBus", Color(0xFF0054A6)),

    // Cat 7: Viagem
    Decolar("Decolar", "Decolar", Color(0xFFE6004C)),
    Airbnb("Airbnb", "Airbnb", Color(0xFFFF5A5F)),
    Booking("Booking.com", "Booking", Color(0xFF003580)),

    // Cat 8: Streaming
    Netflix("Netflix", "Netflix", Color(0xFFE50914)),
    Spotify("Spotify", "Spotify", Color(0xFF1DB954)),
    Globoplay("Globoplay", "Globoplay", Color(0xFFFF5028)),

    // Cat 9: Educação
    Duolingo("Duolingo", "Duolingo", Color(0xFF58CC02)),
    Alura("Alura", "Alura", Color(0xFF0070F3)),
    Udemy("Udemy", "Udemy", Color(0xFFA435F0)),

    // Cat 10: Social
    WhatsApp("WhatsApp", "WA", Color(0xFF25D366)),
    Telegram("Telegram", "TG", Color(0xFF24A1DE)),
    Pinterest("Pinterest", "Pin", Color(0xFFE60023)),

    // Cat 11: Games
    Steam("Steam", "Steam", Color(0xFF171A21)),
    Twitch("Twitch", "Twitch", Color(0xFF9146FF)),
    Discord("Discord", "Discord", Color(0xFF5865F2)),

    // Cat 12: Produtividade
    Notion("Notion", "Notion", Color(0xFF2F3437)),
    Trello("Trello", "Trello", Color(0xFF0079BF)),
    Slack("Slack", "Slack", Color(0xFF4A154B)),

    // Cat 13: Delivery
    McDonalds("McDonald's", "McD", Color(0xFFFFBC0D)),
    BurgerKing("Burger King", "BK", Color(0xFFD62300)),
    Dominos("Domino's Pizza", "Domino's", Color(0xFF006491)),

    // Cat 14: Logística
    BlaBlaCar("BlaBlaCar", "BlaBla", Color(0xFF00AFF5)),
    Loggi("Loggi", "Loggi", Color(0xFF0073FF)),
    Lalamove("Lalamove", "Lalamove", Color(0xFFFF6600)),

    // Cat 15: Vestuário
    Renner("Lojas Renner", "Renner", Color(0xFFC8102E)),
    CeA("C&A", "C&A", Color(0xFF003882)),
    Riachuelo("Riachuelo", "RCHLO", Color(0xFF00965E)),

    // Cat 16: Beleza
    Boticario("O Boticário", "Boticário", Color(0xFF00573D)),
    Natura("Natura", "Natura", Color(0xFFFF6A13)),
    Sephora("Sephora", "Sephora", Color(0xFF000000)),

    // Cat 17: Pet Shop
    Petz("Petz", "Petz", Color(0xFFFED100)),
    Cobasi("Cobasi", "Cobasi", Color(0xFF0071CE)),
    ZeeDog("Zee.Dog", "Zee", Color(0xFF111111)),

    // Cat 18: Casa & Construção
    LeroyMerlin("Leroy Merlin", "Leroy", Color(0xFF78BE20)),
    TokStok("Tok&Stok", "Tok&Stok", Color(0xFFFFCC00)),
    MadeiraMadeira("MadeiraMadeira", "Madeira", Color(0xFFFF5C00)),

    // Cat 19: Notícias
    G1("G1", "G1", Color(0xFFC4170C)),
    UOL("UOL", "UOL", Color(0xFFFF6600)),
    Exame("Exame", "Exame", Color(0xFF003F7F)),

    // Cat 20: Governo
    GovBr("Gov.br", "Gov.br", Color(0xFF003399)),
    CDT("CDT Trânsito", "CDT", Color(0xFF008037)),
    CTPS("CTPS Digital", "CTPS", Color(0xFF005CA9)),

    // Novas Suítes Figma Especializadas
    Dental("DentiCare", "Denti", Color(0xFF00A8B5)),
    Telemedicine("Doctoralia", "Doc", Color(0xFF00B39B)),
    BeverageDelivery("Zé Delivery", "Zé", Color(0xFFFFCC00)),
    Automotive("Webmotors", "WM", Color(0xFFE6192E)),
    Hardware("KaBuM!", "KaBuM", Color(0xFFFF6500))
}
