package br.com.wgc.core_ds

import android.graphics.Color
import androidx.core.graphics.toColorInt

object WgcCoreDsColors {
    // --- 1. CORES PRIMITIVAS ---
    val red500 = "#F44336".toColorInt()
    val red700 = "#D32F2F".toColorInt()

    val blue500 = "#2196F3".toColorInt()
    val orange500 = "#FF5722".toColorInt()

    val grey50 = "#FAFAFA".toColorInt()
    val grey100 = "#F5F5F5".toColorInt()
    val grey900 = "#212121".toColorInt()

    const val white = Color.WHITE
    const val black = Color.BLACK
    const val transparent = Color.TRANSPARENT

    // --- 2. CORES BRAND FOOD DELIVERY ---
    val foodDeliveryRed = "#EA1D2C".toColorInt()
    val foodDeliveryRedDark = "#CC1825".toColorInt()
    val foodDeliveryGreen = "#00A251".toColorInt()
    val foodDeliveryBgGray = "#F7F7F7".toColorInt()

    // --- 3. CORES BRAND 99FOOD ---
    val foodDeliveryDarkBlue = "#0B2545".toColorInt()
    val foodDeliveryLightBlue = "#1E88E5".toColorInt()

    // --- 4. CORES MARKETPLACE ---
    val marketplaceYellow = "#FFE600".toColorInt()
    val marketplaceBlue = "#2D3277".toColorInt()
    val marketplaceGreen = "#00A650".toColorInt()
    val marketplaceBgGray = "#EBEBEB".toColorInt()

    // --- 5. NOVOS TEMAS ECOMMERCE & MOBILIDADE ---
    val dealMarketplaceOrange = "#EE4D2D".toColorInt()
    val rideHailingBlack = "#111111".toColorInt()
    val globalMarketplaceRed = "#FF4747".toColorInt()
    val globalMarketplaceOrange = "#FF6E00".toColorInt()
    val trendFashionPink = "#F83758".toColorInt()
    val trendFashionBlue = "#4392F9".toColorInt()
    val trendFashionDark = "#17223B".toColorInt()
    val trendFashionGold = "#EDB310".toColorInt()
    val trendFashionLightGray = "#F9F9F9".toColorInt()
    val trendFashionBorderGray = "#A8A8A9".toColorInt()

    // --- 5.1 CORES BRAND SHOPPE (FASHION STORE) ---
    val megaStorePrimary = "#004CFF".toColorInt()
    val megaStorePrimaryLight = "#DFE9FF".toColorInt()
    val megaStoreDark = "#202020".toColorInt()
    val megaStoreSecondaryText = "#707070".toColorInt()
    val megaStoreBackground = "#F5F5F5".toColorInt()
    val megaStoreGold = "#F1B11C".toColorInt()
    val megaStoreBorder = "#D2D2D2".toColorInt()
    val megaStoreAlertRed = "#FFEBEB".toColorInt()

    // --- 6. TOKENS SEMÂNTICOS ---
    val primary = orange500
    val secondary = white
    val background = grey50

    val error = red500
    val success = "#4CAF50".toColorInt()
    val warning = "#FFC107".toColorInt()

    val textPrimary = grey900
    val textSecondary = "#757575".toColorInt()

    // --- 7. CORES BRAND KUTUKU (LUXURY / ACCESSORIES) ---
    val retailPrimary = "#514EB7".toColorInt()
    val retailPrimaryLight = "#EAE9FB".toColorInt()
    val retailSecondary = "#C4C3FF".toColorInt()
    val retailDark = "#101010".toColorInt()
    val retailSecondaryText = "#707070".toColorInt()
    val retailBackground = "#FBFBFC".toColorInt()
    val retailSurface = Color.WHITE
    val retailBorder = "#E8E8EE".toColorInt()
    val retailGold = "#F1B11C".toColorInt()
    val retailAlertRed = "#E74C3C".toColorInt()

    // --- 8. CORES BRAND CLOTHEE (SPORTSWEAR / STREETWEAR STORE) ---
    val apparelPrimary = "#8E6CEF".toColorInt()
    val apparelPrimaryLight = "#F4F0FF".toColorInt()
    val apparelDark = "#272727".toColorInt()
    val apparelSecondaryText = "#8E8E93".toColorInt()
    val apparelBackground = Color.WHITE
    val apparelSurface = "#F4F4F4".toColorInt()
    val apparelDarkBackground = "#1D182A".toColorInt()
    val apparelDarkSurface = "#272239".toColorInt()
    val apparelBorder = "#E4E4E7".toColorInt()
    val apparelAlertRed = "#FA3636".toColorInt()
    val apparelSuccessGreen = "#2ECC71".toColorInt()

    // --- 9. CORES BRAND LAZA (STREETWEAR & BRAND STORE) ---
    val boutiquePrimary = "#9775FA".toColorInt()
    val boutiquePrimaryLight = "#F4F0FF".toColorInt()
    val boutiqueDark = "#1D1E20".toColorInt()
    val boutiqueSecondaryText = "#8F959E".toColorInt()
    val boutiqueBackground = Color.WHITE
    val boutiqueSurface = "#F5F6FA".toColorInt()
    val boutiqueDarkBackground = "#1B262C".toColorInt()
    val boutiqueDarkSurface = "#29363D".toColorInt()
    val boutiqueBorder = "#E7E8EB".toColorInt()
    val boutiqueAlertRed = "#EA4335".toColorInt()
    val boutiqueSuccessGreen = "#34A853".toColorInt()
    val boutiqueGold = "#FF7043".toColorInt()
    val boutiqueFacebook = "#4267B2".toColorInt()
    val boutiqueTwitter = "#1DA1F2".toColorInt()
    val boutiqueGoogle = "#EA4335".toColorInt()

    // --- 10. CORES BRAND TASSEL (MINIMALIST MULTI-BRAND ECOMMERCE) ---
    val curatedMarketPrimary = "#4D38DC".toColorInt()
    val curatedMarketPrimaryLight = "#F0EFFF".toColorInt()
    val curatedMarketDark = "#1B1B1E".toColorInt()
    val curatedMarketSecondaryText = "#7C7C8A".toColorInt()
    val curatedMarketBackground = Color.WHITE
    val curatedMarketSurface = "#F4F4F6".toColorInt()
    val curatedMarketDarkBackground = "#121214".toColorInt()
    val curatedMarketDarkSurface = "#1E1E24".toColorInt()
    val curatedMarketBorder = "#E5E5EA".toColorInt()
    val curatedMarketSalePink = "#FFF0F0".toColorInt()
    val curatedMarketSalePinkText = "#FF5A5F".toColorInt()
    val curatedMarketNewInPurple = "#F0EFFF".toColorInt()
    val curatedMarketNewInPurpleText = "#4D38DC".toColorInt()
    val curatedMarketSuccessGreen = "#2ECC71".toColorInt()
    val curatedMarketAlertRed = "#FA3636".toColorInt()
    val curatedMarketGold = "#FFB800".toColorInt()
    val curatedMarketDenimBlue = "#4A90E2".toColorInt()

    // --- 11. CORES BRAND SHOPPER (EMERALD GREEN MODERN ECOMMERCE) ---
    val megaStorerPrimary = "#00966B".toColorInt()
    val megaStorerPrimaryDark = "#007A56".toColorInt()
    val megaStorerPrimaryLight = "#E6F7F2".toColorInt()
    val megaStorerSecondary = "#00BF8A".toColorInt()
    val megaStorerAccent = "#FF6B6B".toColorInt()
    val megaStorerDark = "#1B2A26".toColorInt()
    val megaStorerSecondaryText = "#7A8B87".toColorInt()
    val megaStorerBackground = Color.WHITE
    val megaStorerSurface = "#F5F9F7".toColorInt()
    val megaStorerDarkBackground = "#0F1A17".toColorInt()
    val megaStorerDarkSurface = "#172622".toColorInt()
    val megaStorerBorder = "#E1EAE6".toColorInt()
    val megaStorerSaleOrange = "#FFF3E0".toColorInt()
    val megaStorerSaleOrangeText = "#FF9800".toColorInt()
    val megaStorerSuccessGreen = "#00966B".toColorInt()
    val megaStorerGold = "#FFC107".toColorInt()

    // --- 12. CORES BRAND NEXKART (ROYAL BLUE PREMIUM ECOMMERCE) ---
    val gadgetShopPrimary = "#2D60FF".toColorInt()
    val gadgetShopPrimaryLight = "#F0F4FF".toColorInt()
    val gadgetShopPrimaryDark = "#1A46D6".toColorInt()
    val gadgetShopAccentPink = "#FF3B6A".toColorInt()
    val gadgetShopDark = "#1A1D26".toColorInt()
    val gadgetShopSecondaryText = "#8C91A0".toColorInt()
    val gadgetShopBackground = Color.WHITE
    val gadgetShopSurface = "#F8F9FD".toColorInt()
    val gadgetShopDarkBackground = "#12141D".toColorInt()
    val gadgetShopDarkSurface = "#1E2230".toColorInt()
    val gadgetShopBorder = "#E8ECF4".toColorInt()
    val gadgetShopCatBeauty = "#FFE5EC".toColorInt()
    val gadgetShopCatGadgets = "#FFF3D6".toColorInt()
    val gadgetShopCatGames = "#D8F8EE".toColorInt()
    val gadgetShopCatCine = "#FFEAD8".toColorInt()
    val gadgetShopCatFashion = "#E6F0FF".toColorInt()
    val gadgetShopGold = "#FFB800".toColorInt()
    val gadgetShopSuccessGreen = "#34A853".toColorInt()
    val gadgetShopAlertRed = "#FF3B6A".toColorInt()

    // --- 13. CORES BRAND SHOPEASE (SUNSET ORANGE ECOMMERCE UI KIT) ---
    val quickShopPrimary = "#FF8C42".toColorInt()
    val quickShopPrimaryDark = "#E66A1F".toColorInt()
    val quickShopPrimaryLight = "#FFF3EC".toColorInt()
    val quickShopSecondary = "#FFA07A".toColorInt()
    val quickShopPeachBg = "#FFDFC7".toColorInt()
    val quickShopDark = "#2B2B2B".toColorInt()
    val quickShopSecondaryText = "#757575".toColorInt()
    val quickShopBackground = Color.WHITE
    val quickShopSurface = "#F9F9FB".toColorInt()
    val quickShopBorder = "#EAEAEA".toColorInt()
    val quickShopSuccessGreen = "#2ECC71".toColorInt()
    val quickShopCardRed = "#FFEBEE".toColorInt()
    val quickShopCardPurple = "#F3E5F5".toColorInt()
    val quickShopCardGreen = "#E8F5E9".toColorInt()
    val quickShopCardOrange = "#FFF3E0".toColorInt()
    val quickShopCardBlue = "#E3F2FD".toColorInt()

    // --- 14. CORES BRAND ORGANIZZE (PERSONAL FINANCE SUITE) ---
    val personalFinancePrimary = "#00A389".toColorInt()
    val personalFinancePrimaryDark = "#007E6A".toColorInt()
    val personalFinancePrimaryLight = "#E0F5F1".toColorInt()
    val personalFinanceSecondary = "#1ABC9C".toColorInt()
    val personalFinanceExpenseRed = "#E74C3C".toColorInt()
    val personalFinanceExpenseRedLight = "#FDEDEC".toColorInt()
    val personalFinanceIncomeGreen = "#2ECC71".toColorInt()
    val personalFinanceIncomeGreenLight = "#EAFAF1".toColorInt()
    val personalFinanceTransferBlue = "#3498DB".toColorInt()
    val personalFinanceTransferBlueLight = "#EBF5FB".toColorInt()
    val personalFinanceDark = "#2C3E50".toColorInt()
    val personalFinanceSecondaryText = "#7F8C8D".toColorInt()
    val personalFinanceBackground = "#F4F6F8".toColorInt()
    val personalFinanceSurface = Color.WHITE
    val personalFinanceBorder = "#E5E9EC".toColorInt()
    val personalFinanceCardPurple = "#820AD1".toColorInt()
    val personalFinanceCardNavy = "#EC7000".toColorInt()
    val personalFinanceCardOrange = "#FF7A00".toColorInt()
    val personalFinanceWarningYellow = "#F39C12".toColorInt()

    // Property Rental Real Estate Tokens
    val propertyRentalPrimary = "#1C2A44".toColorInt()
    val propertyRentalPrimaryDark = "#0C182B".toColorInt()
    val propertyRentalPrimaryLight = "#E8EEF5".toColorInt()
    val propertyRentalYellow = "#FFD200".toColorInt()
    val propertyRentalYellowDark = "#E6BC00".toColorInt()
    val propertyRentalYellowLight = "#FFF9D6".toColorInt()
    val propertyRentalCoral = "#FF5A5F".toColorInt()
    val propertyRentalCoralLight = "#FFEBEB".toColorInt()
    val propertyRentalGreen = "#00875A".toColorInt()
    val propertyRentalGreenLight = "#E3FCEF".toColorInt()
    val propertyRentalDark = "#1C2A44".toColorInt()
    val propertyRentalSecondaryText = "#687182".toColorInt()
    val propertyRentalBackground = "#F7F8FA".toColorInt()
    val propertyRentalSurface = Color.WHITE
    val propertyRentalBorder = "#E2E8F0".toColorInt()
    val propertyRentalCardPlaceholder = "#CBD5E1".toColorInt()

    // Property Listing Real Estate Tokens
    val propertyListingPrimary = "#1C9963".toColorInt()
    val propertyListingPrimaryDark = "#0E5C3A".toColorInt()
    val propertyListingPrimaryLight = "#E8F8F0".toColorInt()
    val propertyListingOrange = "#FF6600".toColorInt()
    val propertyListingOrangeDark = "#E05A00".toColorInt()
    val propertyListingOrangeLight = "#FFF0E6".toColorInt()
    val propertyListingWhatsApp = "#25D366".toColorInt()
    val propertyListingWhatsAppLight = "#E7F9EE".toColorInt()
    val propertyListingSuperDestaque = "#E02424".toColorInt()
    val propertyListingSuperDestaqueLight = "#FDE8E8".toColorInt()
    val propertyListingDark = "#1E293B".toColorInt()
    val propertyListingSecondaryText = "#64748B".toColorInt()
    val propertyListingBackground = "#F8FAFC".toColorInt()
    val propertyListingSurface = Color.WHITE
    val propertyListingBorder = "#E2E8F0".toColorInt()
    val propertyListingCardPlaceholder = "#CBD5E1".toColorInt()

    // --- ZAP IMÓVEIS TOKENS (CATEGORIA 1: IMOBILIÁRIA) ---
    val propertyClassifiedsPrimary = "#002F6C".toColorInt() // Azul Marinho Zap Oficial
    val propertyClassifiedsPrimaryDark = "#001C42".toColorInt()
    val propertyClassifiedsPrimaryLight = "#E6EDF5".toColorInt()
    val propertyClassifiedsBlue = "#0066CC".toColorInt() // Azul Royal Zap
    val propertyClassifiedsBlueDark = "#004C99".toColorInt()
    val propertyClassifiedsBlueLight = "#EBF3FC".toColorInt()
    val propertyClassifiedsOrange = "#FF6500".toColorInt() // Laranja Zap para Destaques e Ações
    val propertyClassifiedsOrangeDark = "#D65400".toColorInt()
    val propertyClassifiedsOrangeLight = "#FFF0E6".toColorInt()
    val propertyClassifiedsFipeGreen = "#00875A".toColorInt() // Selo FipeZAP - Bom Preço / Na Média
    val propertyClassifiedsFipeGreenLight = "#E3FCEF".toColorInt()
    val propertyClassifiedsFipeYellow = "#FFAB00".toColorInt() // Selo FipeZAP - Atenção
    val propertyClassifiedsFipeYellowLight = "#FFF0B3".toColorInt()
    val propertyClassifiedsFipeRed = "#DE350B".toColorInt() // Selo FipeZAP - Acima da Média
    val propertyClassifiedsFipeRedLight = "#FFEBE6".toColorInt()
    val propertyClassifiedsDark = "#1A202C".toColorInt()
    val propertyClassifiedsSecondaryText = "#64748B".toColorInt()
    val propertyClassifiedsBackground = "#F8FAFC".toColorInt()
    val propertyClassifiedsSurface = Color.WHITE
    val propertyClassifiedsBorder = "#E2E8F0".toColorInt()
    val propertyClassifiedsCardPlaceholder = "#CBD5E1".toColorInt()

    // --- GYM FITNESS TOKENS (CATEGORIA 2: ACADEMIA & FITNESS) ---
    val gymYellow = "#FFB800".toColorInt() // Amarelo icônico Gym & Fitness
    val gymYellowDark = "#E0A300".toColorInt()
    val gymYellowLight = "#FFF8E7".toColorInt()
    val gymBlack = "#0D0D0D".toColorInt() // Fundo atlético escuro
    val gymDarkGray = "#1A1A1A".toColorInt() // Superfícies e cards escuros
    val gymMediumGray = "#2D2D2D".toColorInt() // Bordas e separadores
    val gymLightGray = "#404040".toColorInt() // Bordas ativas e ícones secundários
    val gymCrowdLow = "#10B981".toColorInt() // Lotação tranquila - Verde
    val gymCrowdLowLight = "#E6F9F2".toColorInt()
    val gymCrowdMedium = "#F59E0B".toColorInt() // Lotação moderada - Laranja
    val gymCrowdMediumLight = "#FEF3C7".toColorInt()
    val gymCrowdHigh = "#EF4444".toColorInt() // Lotação intensa - Vermelho
    val gymCrowdHighLight = "#FEE2E2".toColorInt()
    val gymTextPrimary = Color.WHITE
    val gymTextSecondary = "#A3A3A3".toColorInt()
    val gymTextInverse = "#000000".toColorInt()
    val gymCardPlaceholder = "#242424".toColorInt()
    val gymAccentCyan = "#00E5FF".toColorInt()

    // --- CORPORATE WELLNESS TOKENS ---
    val wellnessCoral = "#FF4338".toColorInt() // Coral vibrante Corporate Wellness
    val wellnessCoralDark = "#E0342A".toColorInt()
    val wellnessCoralLight = "#FFF0EE".toColorInt()
    val wellnessForest = "#00382B".toColorInt() // Verde escuro corporativo Corporate Wellness
    val wellnessForestDark = "#00261D".toColorInt()
    val wellnessForestLight = "#E6F2EE".toColorInt()
    val wellnessCreamBg = "#FBF9F6".toColorInt() // Fundo suave editorial
    val wellnessSurface = Color.WHITE
    val wellnessDark = "#1A1A1A".toColorInt()
    val wellnessSecondaryText = "#6B7280".toColorInt()
    val wellnessBorder = "#E5E7EB".toColorInt()
    val wellnessPlaceholder = "#E2E8F0".toColorInt()
    val wellnessTierStarter = "#4B5563".toColorInt()
    val wellnessTierBasic = "#0284C7".toColorInt()
    val wellnessTierSilver = "#6B7280".toColorInt()
    val wellnessTierGold = "#D97706".toColorInt()
    val wellnessTierPlatinum = "#6366F1".toColorInt()
    val wellnessTierDiamond = "#059669".toColorInt()
    val wellnessCheckInGreen = "#10B981".toColorInt()
    val wellnessCheckInGreenLight = "#E6F9F2".toColorInt()
    val wellnessCheckInTimer = "#F59E0B".toColorInt()

    // --- NIKE TRAINING CLUB (NTC) TOKENS (CATEGORIA 2: ACADEMIA & FITNESS) ---
    val trainingBlack = "#111111".toColorInt() // Fundo escuro premium NTC
    val trainingDarkGray = "#1C1C1E".toColorInt() // Superfície de cards NTC
    val trainingMediumGray = "#2C2C2E".toColorInt() // Bordas e divisores
    val trainingLightGray = "#3A3A3C".toColorInt() // Elementos secundários inativos
    val trainingVolt = "#D0FF00".toColorInt() // Amarelo Volt elétrico icônico da Nike
    val trainingVoltDark = "#A6CC00".toColorInt()
    val trainingVoltGlow = "#263300".toColorInt() // Fundo sutil com matiz Volt
    val trainingWhite = "#FFFFFF".toColorInt() // Texto principal de alto contraste
    val trainingSecondaryText = "#8E8E93".toColorInt() // Texto secundário acinzentado
    val trainingOrange = "#FF5722".toColorInt() // Destaque para treinos HIIT/Queima intensa
    val trainingOrangeDark = "#D84315".toColorInt()
    val trainingOrangeLight = "#3E1C12".toColorInt()
    val trainingBlue = "#00A3FF".toColorInt() // Destaque para treinos de Mobilidade/Yoga
    val trainingBlueDark = "#0077B6".toColorInt()
    val trainingBlueLight = "#0D2838".toColorInt()
    val trainingPurple = "#9D4EDD".toColorInt() // Destaque para Recuperação e Mindfulness
    val trainingPlaceholder = "#242426".toColorInt()
    val trainingStreakGold = "#FFD700".toColorInt() // Medalhas e sequências

    // --- CLUBE EXTRA TOKENS (CATEGORIA 3: SUPERMERCADO & VAREJO ALIMENTAR) ---
    val hypermarketRed = "#E30613".toColorInt() // Vermelho principal Clube Extra
    val hypermarketRedDark = "#B8000B".toColorInt()
    val hypermarketRedLight = "#FEEBEB".toColorInt()
    val hypermarketBlue = "#002B7F".toColorInt() // Azul corporativo de destaque GPA
    val hypermarketBlueDark = "#001D59".toColorInt()
    val hypermarketBlueLight = "#EBF1FB".toColorInt()
    val hypermarketYellow = "#FFD100".toColorInt() // Amarelo de ofertas "Meu Desconto"
    val hypermarketYellowLight = "#FFFBE6".toColorInt()
    val hypermarketOrange = "#FF6E00".toColorInt() // Laranja de fidelidade "Juntou Ganhou"
    val hypermarketOrangeLight = "#FFF0E5".toColorInt()
    val hypermarketBackground = "#F6F7F9".toColorInt()
    val hypermarketSurface = Color.WHITE
    val hypermarketDark = "#1A1A1A".toColorInt()
    val hypermarketSecondaryText = "#6E7787".toColorInt()
    val hypermarketBorder = "#E5E7EB".toColorInt()
    val hypermarketPlaceholder = "#E2E8F0".toColorInt()
    val hypermarketSuccessGreen = "#00875A".toColorInt()
    val hypermarketSuccessGreenLight = "#E3FCEF".toColorInt()

    // --- PREMIUM GROCERY TOKENS (CATEGORIA 3: SUPERMERCADO & VAREJO ALIMENTAR) ---
    val premiumGroceryGreen = "#006837".toColorInt() // Verde Clássico Gourmet
    val premiumGroceryGreenDark = "#004D26".toColorInt() // Verde Escuro Floresta
    val premiumGroceryGreenLight = "#E8F5E9".toColorInt() // Verde Claro Suave
    val premiumGroceryGold = "#C5A059".toColorInt() // Dourado Cliente Mais Black/Gold
    val premiumGroceryGoldDark = "#9E7D3B".toColorInt()
    val premiumGroceryGoldLight = "#FDF8ED".toColorInt()
    val premiumGroceryWineRed = "#8E1B32".toColorInt() // Vinho Adega Gourmet
    val premiumGroceryWineRedDark = "#630E20".toColorInt()
    val premiumGroceryWineRedLight = "#F9EBEF".toColorInt()
    val premiumGroceryOrangeOrganic = "#E67E22".toColorInt() // Laranja Orgânicos & Saudáveis
    val premiumGroceryOrangeOrganicLight = "#FDF2E9".toColorInt()
    val premiumGroceryBackground = "#FBFBF8".toColorInt() // Fundo creme orgânico sofisticado
    val premiumGrocerySurface = Color.WHITE
    val premiumGroceryTextPrimary = "#1C2826".toColorInt()
    val premiumGroceryTextSecondary = "#607274".toColorInt()
    val premiumGroceryBorder = "#E2E7E4".toColorInt()
    val premiumGroceryPlaceholder = "#CBD5E1".toColorInt()
    val premiumGrocerySuccessGreen = "#2E7D32".toColorInt()
    val premiumGrocerySuccessGreenLight = "#E8F5E9".toColorInt()

    // --- GROCERY & SUPERMARKET TOKENS ---
    val groceryBlue = "#00387B".toColorInt() // Azul Corporativo Supermercado
    val groceryBlueDark = "#00204A".toColorInt()
    val groceryBlueLight = "#E8EFF8".toColorInt()
    val groceryRed = "#ED1C24".toColorInt() // Vermelho Losango Supermercado
    val groceryRedDark = "#B80D14".toColorInt()
    val groceryRedLight = "#FDE8E9".toColorInt()
    val groceryYellow = "#F8B600".toColorInt() // Amarelo de Ofertas & Posto
    val groceryOrange = "#FF6E00".toColorInt()
    val groceryBackground = "#F5F6F9".toColorInt()
    val grocerySurface = Color.WHITE
    val groceryTextPrimary = "#1D232C".toColorInt()
    val groceryTextSecondary = "#6C757D".toColorInt()
    val groceryBorder = "#E4E7EB".toColorInt()
    val groceryPlaceholder = "#CBD5E1".toColorInt()

    // Escala Nutri-Score Oficial
    val groceryNutriScoreA = "#038141".toColorInt() // Verde Escuro - Altamente Saudável
    val groceryNutriScoreB = "#85BB2F".toColorInt() // Verde Claro
    val groceryNutriScoreC = "#FECB02".toColorInt() // Amarelo
    val groceryNutriScoreD = "#EE8100".toColorInt() // Laranja
    val groceryNutriScoreE = "#E63E11".toColorInt() // Vermelho

    // --- PHARMACY CHAIN TOKENS (CATEGORIA 4: FARMÁCIA & SAÚDE) ---
    val pharmacyChainRed = "#C8102E".toColorInt() // Vermelho Raia Oficial
    val pharmacyChainRedDark = "#960B21".toColorInt()
    val pharmacyChainRedLight = "#FCECEF".toColorInt()
    val pharmacyChainNavy = "#0C2340".toColorInt() // Azul Marinho Corporativo
    val pharmacyChainNavyDark = "#061324".toColorInt()
    val pharmacyChainNavyLight = "#E8EDF3".toColorInt()
    val pharmacyChainGreen = "#008559".toColorInt() // Verde Saúde / Suplementos
    val pharmacyChainGreenLight = "#E6F5F0".toColorInt()
    val pharmacyChainPrescriptionYellow = "#FFB81C".toColorInt() // Alerta de Retenção de Receita
    val pharmacyChainPrescriptionYellowLight = "#FFF8E7".toColorInt()
    val pharmacyChainBackground = "#F8F9FA".toColorInt()
    val pharmacyChainSurface = Color.WHITE
    val pharmacyChainTextPrimary = "#1B2A4A".toColorInt()
    val pharmacyChainTextSecondary = "#5A6B82".toColorInt()
    val pharmacyChainBorder = "#E2E8F0".toColorInt()
    val pharmacyChainPlaceholder = "#CBD5E1".toColorInt()

    // --- CARE PHARMACY TOKENS (CATEGORIA 4: FARMÁCIA & SAÚDE) ---
    val carePharmacyRed = "#E30613".toColorInt() // Vermelho Cruz Farmácia
    val carePharmacyRedDark = "#AD040E".toColorInt()
    val carePharmacyRedLight = "#FDE8E9".toColorInt()
    val carePharmacyBlue = "#004B87".toColorInt() // Azul Cuidados & Exames
    val carePharmacyBlueLight = "#E6F0F8".toColorInt()
    val carePharmacyGold = "#D4AF37".toColorInt() // Cartão Vantagens Fidelidade
    val carePharmacyGoldLight = "#FDF9EB".toColorInt()
    val carePharmacyVaccineGreen = "#008060".toColorInt() // Agendamento de Vacinas
    val carePharmacyVaccineGreenLight = "#E6F4EF".toColorInt()
    val carePharmacyBackground = "#F7F8FA".toColorInt()
    val carePharmacySurface = Color.WHITE
    val carePharmacyTextPrimary = "#212529".toColorInt()
    val carePharmacyTextSecondary = "#6C757D".toColorInt()
    val carePharmacyBorder = "#E9ECEF".toColorInt()
    val carePharmacyPlaceholder = "#CBD5E1".toColorInt()

    // --- POPULAR PHARMACY TOKENS (CATEGORIA 4: FARMÁCIA & SAÚDE) ---
    val popularPharmacyGreen = "#00A859".toColorInt() // Verde Vibrante Farmácia Popular
    val popularPharmacyGreenDark = "#007A40".toColorInt()
    val popularPharmacyGreenLight = "#E6F7EF".toColorInt()
    val popularPharmacyBlue = "#003399".toColorInt() // Azul Corporativo Forte
    val popularPharmacyBlueDark = "#002266".toColorInt()
    val popularPharmacyBlueLight = "#E8EEF8".toColorInt()
    val popularPharmacyOrange = "#F58220".toColorInt() // Laranja Sempre Bem
    val popularPharmacyOrangeLight = "#FEF3E9".toColorInt()
    val popularPharmacyClinicTeal = "#00838F".toColorInt() // Clinic Farma
    val popularPharmacyClinicTealLight = "#E0F2F1".toColorInt()
    val popularPharmacyBackground = "#F4F7F6".toColorInt()
    val popularPharmacySurface = Color.WHITE
    val popularPharmacyTextPrimary = "#1A2B3C".toColorInt()
    val popularPharmacyTextSecondary = "#5B6B7C".toColorInt()
    val popularPharmacyBorder = "#E0E6ED".toColorInt()
    val popularPharmacyPlaceholder = "#CBD5E1".toColorInt()

    // --- FINTECH NEOBANK TOKENS ---
    val fintechPurple = "#820AD1".toColorInt() // Roxo Neobank Oficial
    val fintechPurpleDark = "#5A0594".toColorInt()
    val fintechPurpleLight = "#F4EAFB".toColorInt()
    val fintechBackground = "#F5F5F5".toColorInt()
    val fintechPurpleSurface = Color.WHITE
    val fintechPurpleTextPrimary = "#111111".toColorInt()
    val fintechPurpleTextSecondary = "#767676".toColorInt()
    val fintechPurpleBorder = "#E5E5E5".toColorInt()
    val fintechMoneyGreen = "#00875A".toColorInt()

    // --- FINTECH SUPERAPP TOKENS ---
    val fintechOrange = "#FF7A00".toColorInt() // Laranja Oficial SuperApp
    val fintechOrangeDark = "#CC6200".toColorInt()
    val fintechOrangeLight = "#FFF2E6".toColorInt()
    val fintechSuperAppBackground = "#F5F6F8".toColorInt()
    val fintechSuperAppSurface = Color.WHITE
    val fintechSuperAppTextPrimary = "#1F2D3D".toColorInt()
    val fintechSuperAppTextSecondary = "#8492A6".toColorInt()
    val fintechSuperAppBorder = "#E0E6ED".toColorInt()
    val fintechSuperAppGoldCashback = "#F7BA2A".toColorInt()

    // --- FINTECH CARBON TOKENS ---
    val fintechCarbon = "#242424".toColorInt() // Carbon Black Fintech
    val fintechCarbonDark = "#141414".toColorInt()
    val fintechCarbonLight = "#EAEAEA".toColorInt()
    val fintechYellow = "#FFD100".toColorInt() // Amarelo Pontos Recompensa
    val fintechCarbonYellowLight = "#FFFBE6".toColorInt()
    val fintechCarbonBackground = "#121212".toColorInt()
    val fintechSurface = "#1E1E1E".toColorInt()
    val fintechTextPrimary = Color.WHITE
    val fintechTextSecondary = "#A0A0A0".toColorInt()
    val fintechCarbonBorder = "#2D2D2D".toColorInt()

    // --- CATEGORIA 6: MOBILIDADE & TRANSPORTE ---
    val mobilityYellow99 = "#FFC800".toColorInt()
    val biddingRidesGreen = "#29B75F".toColorInt()
    val busTravelBlue = "#0054A6".toColorInt()

    // --- CATEGORIA 7: VIAGEM & TURISMO ---
    val flightTravelRed = "#E6004C".toColorInt()
    val lodgingCoral = "#FF5A5F".toColorInt()
    val hotelBookingNavy = "#003580".toColorInt()

    // --- CATEGORIA 8: STREAMING DE VÍDEO & MÚSICA ---
    val videoStreamingRed = "#E50914".toColorInt()
    val audioStreamingGreen = "#1DB954".toColorInt()
    val broadcastStreamingSalmon = "#FF5028".toColorInt()

    // --- CATEGORIA 9: EDUCAÇÃO & CURSOS ONLINE ---
    val languageLearningGreen = "#58CC02".toColorInt()
    val techEducationBlue = "#0070F3".toColorInt()
    val courseMarketplacePurple = "#A435F0".toColorInt()

    // --- CATEGORIA 10: MENSAGERIA & REDES SOCIAIS ---
    val directMessagingGreen = "#25D366".toColorInt()
    val channelMessagingBlue = "#24A1DE".toColorInt()
    val visualDiscoveryRed = "#E60023".toColorInt()

    // --- CATEGORIA 11: GAMES & ENTRETENIMENTO ---
    val gamingStoreNavy = "#171A21".toColorInt()
    val liveStreamingPurple = "#9146FF".toColorInt()
    val communityChatBlurple = "#5865F2".toColorInt()

    // --- CATEGORIA 12: PRODUTIVIDADE & TRABALHO ---
    val workspaceDocsDark = "#2F3437".toColorInt()
    val kanbanTasksBlue = "#0079BF".toColorInt()
    val teamCollaborationAubergine = "#4A154B".toColorInt()

    // --- CATEGORIA 13: DELIVERY & RESTAURANTES ---
    val burgerFastFoodYellow = "#FFBC0D".toColorInt()
    val burgerFastFoodRed = "#DA291C".toColorInt()
    val flameFastFoodFlame = "#D62300".toColorInt()
    val pizzaBlue = "#006491".toColorInt()

    // --- CATEGORIA 14: CARONA & LOGÍSTICA ---
    val carpoolingBlue = "#00AFF5".toColorInt()
    val expressLogisticsBlue = "#0073FF".toColorInt()
    val freightLogisticsOrange = "#FF6600".toColorInt()

    // --- CATEGORIA 15: VESTUÁRIO & MODA NACIONAL ---
    val departmentFashionRed = "#C8102E".toColorInt()
    val urbanFashionBlue = "#003882".toColorInt()
    val trendApparelGreen = "#00965E".toColorInt()

    // --- CATEGORIA 16: BELEZA, PERFUMARIA & COSMÉTICOS ---
    val fragranceBeautyGreen = "#00573D".toColorInt()
    val naturalBeautyOrange = "#FF6A13".toColorInt()
    val prestigeBeautyBlack = "#000000".toColorInt()

    // --- CATEGORIA 17: PET SHOP & VETERINÁRIA ---
    val petCareYellow = "#FED100".toColorInt()
    val petCareBlue = "#004A97".toColorInt()
    val petSuperstoreBlue = "#0071CE".toColorInt()
    val petLifestyleSkull = "#111111".toColorInt()

    // --- CATEGORIA 18: CASA, CONSTRUÇÃO & DECORAÇÃO ---
    val leroyGreen = "#78BE20".toColorInt()
    val designerFurnitureYellow = "#FFCC00".toColorInt()
    val madeiraOrange = "#FF5C00".toColorInt()

    // --- CATEGORIA 19: NOTÍCIAS & MÍDIA ---
    val dailyNewsRed = "#C4170C".toColorInt()
    val mediaNetworkOrange = "#FF6600".toColorInt()
    val businessNewsBlue = "#003F7F".toColorInt()

    // --- CATEGORIA 20: GOVERNO & CIDADANIA DIGITAL ---
    val govBlue = "#003399".toColorInt()
    val govYellow = "#FFCC00".toColorInt()
    val transitDigitalGreen = "#008037".toColorInt()
    val employmentRecordBlue = "#005CA9".toColorInt()

    // --- ALIASES & UTILITY COLORS ---
    val gray100 = "#F5F5F5".toColorInt()
    val gray200 = "#EEEEEE".toColorInt()
    val gray300 = "#E0E0E0".toColorInt()
    val gray400 = "#BDBDBD".toColorInt()
    val gray500 = "#9E9E9E".toColorInt()
    val gray600 = "#757575".toColorInt()
    val gray700 = "#616161".toColorInt()
    val gray800 = "#424242".toColorInt()

    // Domain & Utility Tokens
    val fintechSuperAppSecondary = "#FF5000".toColorInt()
    val fintechDark = "#242424".toColorInt()
    val urbanMobilityYellow = "#FFCC00".toColorInt()
    val mediaNetworkYellow = "#FFCC00".toColorInt()

    val homeImprovementGreen = Color.parseColor("#78BE20")
    val homeMarketplaceOrange = Color.parseColor("#FF5C00")
    val workspaceDocsBlack = Color.parseColor("#2F3437")
    val trendApparelDark = "#1C1C1C".toColorInt()
    val gamingStoreBlue = "#1B2838".toColorInt()
    val designerFurnitureRed = "#E60000".toColorInt()
    val petLifestyleBlack = Color.parseColor("#111111")
    val hotelBookingBlue = Color.parseColor("#003580")
    val hotelBookingYellow = Color.parseColor("#FEBB02")
    val flameFastFoodBrown = Color.parseColor("#502314")
    val flameFastFoodOrange = Color.parseColor("#D62300")
    val broadcastStreamingOrange = Color.parseColor("#FF5028")
    val citizenServicesBlue = Color.parseColor("#003399")
    val citizenServicesGold = Color.parseColor("#FFCC00")
    val urbanFashionRed = Color.parseColor("#E60000")
    val busTravelGreen = Color.parseColor("#00A650")
    val flightTravelBlue = Color.parseColor("#003580")
    val flightTravelPurple = Color.parseColor("#432874")
    val pizzaRed = Color.parseColor("#E31837")

    // --- NOVAS SUÍTES ESPECIALIZADAS ---
    // 1. Odontologia Clínica
    val dentalTeal = Color.parseColor("#00A8B5")
    val dentalTealLight = Color.parseColor("#E0F7FA")
    val dentalDark = Color.parseColor("#004D54")

    // 2. Telemedicina
    val telemedicineGreen = Color.parseColor("#00B39B")
    val telemedicineNavy = Color.parseColor("#002B49")
    val telemedicineGreenLight = Color.parseColor("#E6F8F5")

    // 3. Drinks Delivery
    val beverageDeliveryYellow = Color.parseColor("#FFCC00")
    val beverageDeliveryDark = Color.parseColor("#111111")
    val beverageDeliveryRed = Color.parseColor("#E31837")

    // 4. Automotivo & Car Marketplace
    val automotiveRed = Color.parseColor("#E6192E")
    val automotiveDark = Color.parseColor("#1A1D20")
    val automotiveGray = Color.parseColor("#2C3238")
    val automotiveGreen = Color.parseColor("#00A868")

    // 5. Eletrônicos & Hardware Specs (Hardware Tech / Hardware)
    val hardwareOrange = Color.parseColor("#FF6500")
    val hardwareNavy = Color.parseColor("#002B49")
    val hardwareOrangeLight = Color.parseColor("#FFF0E6")
    val hardwareNinjaBlack = Color.parseColor("#121212")

    // Provedores Sociais de Autenticação
    val socialFacebook = Color.parseColor("#1877F2")
    val socialInstagram = Color.parseColor("#E4405F")
    val socialLinkedIn = Color.parseColor("#0A66C2")

    // Gaming Store & Live Streaming
    val gamingStoreCardBg = Color.parseColor("#2A475E")
    val gamingStoreAccent = Color.parseColor("#66C0F4")
    val liveStreamingDarkCard = Color.parseColor("#1F1F23")

    // Product Variant Colors
    val productLemon = Color.parseColor("#F9E79F")
    val productTan = Color.parseColor("#A0522D")
    val productTeal = Color.parseColor("#20B2AA")
    val productGreen = Color.parseColor("#00C853")

    // Fresh Grocery
    val freshGroceryEmerald = Color.parseColor("#00B368")
}
