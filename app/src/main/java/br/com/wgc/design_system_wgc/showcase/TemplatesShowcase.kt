@file:Suppress("LongMethod", "CyclomaticComplexMethod", "MagicNumber")
package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.brand.WgcBrand
import br.com.wgc.design_system.templates.factories.WgcHomeFactory
import br.com.wgc.design_system.templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.design_system.templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.design_system.templates.screens.common.auth.FakeBrandAddressAuthViewModel
import br.com.wgc.design_system.templates.screens.common.auth.WgcBrandAddressRegistrationScreenTemplate
import br.com.wgc.design_system.templates.screens.community.klok.WgcKlokAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.community.split.WgcSplitCardAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.community.wave.WgcWaveAuthScreenTemplate
import br.com.wgc.design_system.templates.screens.fooddelivery.FakeFoodDeliveryHomeViewModel
import br.com.wgc.design_system.templates.screens.fooddelivery.WgcFoodDeliveryHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.design_system.templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.design_system.templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.design_system.templates.screens.login.viewmodel.FakeLoginViewModel
import br.com.wgc.design_system.templates.screens.map.FakeRealtimeLocationViewModel
import br.com.wgc.design_system.templates.screens.map.RealtimeLocationMapScreenTemplate
import br.com.wgc.design_system.templates.screens.marketplacescreen.FakeMarketplaceHomeViewModel
import br.com.wgc.design_system.templates.screens.marketplacescreen.WgcMarketplaceHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.notifications.WgcNotificationCenterTemplate
import br.com.wgc.design_system.templates.screens.profile.WgcUserProfileEditTemplate
import br.com.wgc.design_system.templates.screens.quickfooddelivery.FakeQuickFoodDeliveryHomeViewModel
import br.com.wgc.design_system.templates.screens.quickfooddelivery.WgcQuickFoodDeliveryHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.search.FakeSearchAndFilterViewModel
import br.com.wgc.design_system.templates.screens.search.SearchAndFilterScreenTemplate
import br.com.wgc.design_system.templates.screens.social.FakeInstagramStoryViewerViewModel
import br.com.wgc.design_system.templates.screens.social.InstagramStoryViewerScreenTemplate
import br.com.wgc.design_system.templates.screens.checkout.FakeCheckoutViewModel
import br.com.wgc.design_system.templates.screens.checkout.WgcCheckoutTemplate
import br.com.wgc.design_system.templates.screens.product.FakeProductDetailViewModel
import br.com.wgc.design_system.templates.screens.product.WgcProductDetailTemplate
import br.com.wgc.design_system.templates.screens.review.FakeFeedbackReviewViewModel
import br.com.wgc.design_system.templates.screens.review.WgcFeedbackReviewTemplate
import br.com.wgc.design_system.templates.screens.statement.FakeFinancialStatementViewModel
import br.com.wgc.design_system.templates.screens.statement.WgcFinancialStatementTemplate
import br.com.wgc.design_system.templates.screens.support.FakeHelpCenterViewModel
import br.com.wgc.design_system.templates.screens.support.WgcHelpCenterSupportTemplate
import br.com.wgc.design_system.templates.screens.card.FakeCardManagementViewModel
import br.com.wgc.design_system.templates.screens.card.WgcCardManagementTemplate
import br.com.wgc.design_system.templates.screens.loan.FakeLoanSimulatorViewModel
import br.com.wgc.design_system.templates.screens.loan.WgcLoanSimulatorTemplate
import br.com.wgc.design_system.templates.screens.notification.FakeNotificationHubViewModel
import br.com.wgc.design_system.templates.screens.notification.WgcNotificationHubTemplate
import br.com.wgc.design_system.templates.screens.pix.FakePixTransferViewModel
import br.com.wgc.design_system.templates.screens.pix.WgcPixTransferTemplate
import br.com.wgc.design_system.templates.screens.security.FakeSecuritySettingsViewModel
import br.com.wgc.design_system.templates.screens.security.WgcSecuritySettingsTemplate
import br.com.wgc.design_system_wgc.MultiBrandAuthCatalogSection
import br.com.wgc.design_system_wgc.WgcFactoriesAndSlotsCatalogSection
import br.com.wgc.design_system_wgc.WgcProfileFactoryShowcase

enum class TemplateCategory(val title: String) {
    ALL("Todos"),
    FACTORIES("Fábricas Universais"),
    SYSTEM("Telas do Sistema"),
    FIGMA_AUTH("Figma Auth"),
    ECOMMERCE("E-Commerce & Food"),
    FINTECH("Fintech & Bancos")
}

data class TemplateShowcaseItem(
    val id: Int,
    val name: String,
    val category: TemplateCategory,
    val description: String
)

/**
 * Showcase oficial interativo do módulo :templates.
 * Fornece navegação categorizada, busca em tempo real e visualização isolada de cada tela sem sobreposição.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplatesShowcase(
    onBack: () -> Unit
) {
    val allTemplates = remember {
        listOf(
            TemplateShowcaseItem(
                id = 0,
                name = "WgcProfileFactory (22 Perfis)",
                category = TemplateCategory.FACTORIES,
                description = "Fábrica universal de perfis com 22 variações de domínio e slots customizáveis"
            ),
            TemplateShowcaseItem(
                id = 1,
                name = "WgcHomeFactory (Multi-Brand)",
                category = TemplateCategory.FACTORIES,
                description = "Fábrica universal de telas Home com Bottom Navigation dinâmica adaptada"
            ),
            TemplateShowcaseItem(
                id = 2,
                name = "Fábricas & Slots de UI",
                category = TemplateCategory.FACTORIES,
                description = "Demonstração das fábricas universais de Botões, Menus, Cards e Fields"
            ),
            TemplateShowcaseItem(
                id = 3,
                name = "Central de Notificações",
                category = TemplateCategory.SYSTEM,
                description = "Centro de notificações com filtros ALL, UNREAD, TRANSACTIONAL e pull-to-refresh"
            ),
            TemplateShowcaseItem(
                id = 4,
                name = "Edição de Perfil & Cadastro",
                category = TemplateCategory.SYSTEM,
                description = "Formulário desacoplado de edição de usuário com validação em tempo real"
            ),
            TemplateShowcaseItem(
                id = 5,
                name = "Carrinho & Checkout",
                category = TemplateCategory.SYSTEM,
                description = "Fluxo de carrinho com cálculo de frete, cupons de desconto e resumo"
            ),
            TemplateShowcaseItem(
                id = 6,
                name = "Mapa & Tracking Realtime",
                category = TemplateCategory.SYSTEM,
                description = "Rastreamento em tempo real com motorista, rota e status do pedido"
            ),
            TemplateShowcaseItem(
                id = 7,
                name = "Busca & Filtros Avançados",
                category = TemplateCategory.SYSTEM,
                description = "Tela de busca com histórico recente, tags populares e filtros dinâmicos"
            ),
            TemplateShowcaseItem(
                id = 8,
                name = "Login Universal",
                category = TemplateCategory.SYSTEM,
                description = "Tela de autenticação desacoplada baseada em UiState com suporte biométrico"
            ),
            TemplateShowcaseItem(
                id = 9,
                name = "Figma: Clean Wave Auth",
                category = TemplateCategory.FIGMA_AUTH,
                description = "Design oficial Figma com layout ondulado e botões sociais em pílula"
            ),
            TemplateShowcaseItem(
                id = 10,
                name = "Figma: Split Card Auth",
                category = TemplateCategory.FIGMA_AUTH,
                description = "Design oficial Figma com card dividido em duas seções e foco em usabilidade"
            ),
            TemplateShowcaseItem(
                id = 11,
                name = "Figma: Modern Klok Auth",
                category = TemplateCategory.FIGMA_AUTH,
                description = "Design oficial Figma com tema escuro e autenticação touch ID moderna"
            ),
            TemplateShowcaseItem(
                id = 12,
                name = "Auth Multi-Brand (6 Marcas)",
                category = TemplateCategory.FIGMA_AUTH,
                description = "Fluxos de Login, Cadastro, Recuperação e Endereço para 6 marcas distintas"
            ),
            TemplateShowcaseItem(
                id = 13,
                name = "Marketplace Home",
                category = TemplateCategory.ECOMMERCE,
                description = "Home de marketplace com carrossel de ofertas, departamentos e busca rápida"
            ),
            TemplateShowcaseItem(
                id = 14,
                name = "Food Delivery Home",
                category = TemplateCategory.ECOMMERCE,
                description = "Home de delivery de comida com restaurantes, cupons e tempo estimado"
            ),
            TemplateShowcaseItem(
                id = 15,
                name = "Quick Food Delivery Home",
                category = TemplateCategory.ECOMMERCE,
                description = "Home expressa com foco em entregas ultra-rápidas e ofertas relâmpago"
            ),
            TemplateShowcaseItem(
                id = 16,
                name = "Instagram Story Viewer",
                category = TemplateCategory.ECOMMERCE,
                description = "Visualizador de stories imersivo com barras de progresso temporizadas"
            ),
            TemplateShowcaseItem(
                id = 17,
                name = "Fintech Neobank Home",
                category = TemplateCategory.FINTECH,
                description = "Dashboard bancário moderno com saldo ocultável, PIX, cartões e extrato"
            ),
            TemplateShowcaseItem(
                id = 18,
                name = "E-Commerce Home",
                category = TemplateCategory.ECOMMERCE,
                description = "Catálogo completo de produtos com banners sazonais e grade responsiva"
            ),
            TemplateShowcaseItem(
                id = 19,
                name = "Endereço Multi-Brand",
                category = TemplateCategory.SYSTEM,
                description = "Formulário de cadastro de endereço com CEP automático e validação"
            ),
            TemplateShowcaseItem(
                id = 20,
                name = "Checkout Corporativo",
                category = TemplateCategory.ECOMMERCE,
                description = "Checkout com seleção de endereço, pagamento, cupom e resumo financeiro"
            ),
            TemplateShowcaseItem(
                id = 21,
                name = "Extrato da Conta",
                category = TemplateCategory.FINTECH,
                description = "Extrato financeiro com saldo ocultável, filtros de período e lançamentos detalhados"
            ),
            TemplateShowcaseItem(
                id = 22,
                name = "Detalhes do Produto (PDP)",
                category = TemplateCategory.ECOMMERCE,
                description = "Página de produto com galeria de fotos, seleção de cores/tamanhos e sticky CTA"
            ),
            TemplateShowcaseItem(
                id = 23,
                name = "Central de Ajuda & FAQ",
                category = TemplateCategory.SYSTEM,
                description = "Central de ajuda com busca, categorias de dúvidas, chamados recentes e FAQ"
            ),
            TemplateShowcaseItem(
                id = 24,
                name = "Avaliação da Compra",
                category = TemplateCategory.SYSTEM,
                description = "Avaliação de compra com estrelas, tags rápidas, comentário e upload de fotos"
            ),
            TemplateShowcaseItem(
                id = 25,
                name = "Área Pix & Transferência",
                category = TemplateCategory.FINTECH,
                description = "Fluxo completo de Pix com escolha de chave, valor e confirmação"
            ),
            TemplateShowcaseItem(
                id = 26,
                name = "Gestão de Cartões",
                category = TemplateCategory.FINTECH,
                description = "Gestão de cartões com efeito 3D flip, ajuste de limite e bloqueio temporário"
            ),
            TemplateShowcaseItem(
                id = 27,
                name = "Simulador de Empréstimo",
                category = TemplateCategory.FINTECH,
                description = "Simulação de crédito, parcelamento, taxa CET e contratação"
            ),
            TemplateShowcaseItem(
                id = 28,
                name = "Central de Notificações Unificada",
                category = TemplateCategory.SYSTEM,
                description = "Central com abas de categorias, contadores de não lidas e exclusão"
            ),
            TemplateShowcaseItem(
                id = 29,
                name = "Segurança & Acesso",
                category = TemplateCategory.SYSTEM,
                description = "Configurações de biometria, autenticação em duas etapas e dispositivos"
            )
        )
    }

    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(TemplateCategory.ALL) }
    var selectedTemplateId by remember { mutableIntStateOf(0) }

    val filteredTemplates = remember(searchQuery, selectedCategory) {
        allTemplates.filter { item ->
            val matchesCategory = selectedCategory == TemplateCategory.ALL || item.category == selectedCategory
            val matchesSearch = searchQuery.isBlank() ||
                item.name.contains(searchQuery, ignoreCase = true) ||
                item.description.contains(searchQuery, ignoreCase = true)
            matchesCategory && matchesSearch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Módulo :templates",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Telas Completas e Fábricas Desacopladas (UiState)",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar ao Hub de Módulos"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Barra de Busca e Filtros
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Buscar templates por nome ou descrição...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                    trailingIcon = {
                        if (searchQuery.isNotBlank()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Limpar busca")
                            }
                        }
                    },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    singleLine = true
                )

                // Filtros de Categoria
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    items(TemplateCategory.entries.size) { index ->
                        val cat = TemplateCategory.entries[index]
                        FilterChip(
                            selected = selectedCategory == cat,
                            onClick = { selectedCategory = cat },
                            label = { Text(cat.title) }
                        )
                    }
                }
            }

            // Barra de Seleção de Templates
            if (filteredTemplates.isNotEmpty()) {
                val currentSelectedIndex = filteredTemplates.indexOfFirst { it.id == selectedTemplateId }
                    .coerceAtLeast(0)

                PrimaryScrollableTabRow(
                    selectedTabIndex = currentSelectedIndex,
                    edgePadding = WgcCoreDsSpacing.md16.dp
                ) {
                    filteredTemplates.forEachIndexed { index, item ->
                        Tab(
                            selected = currentSelectedIndex == index,
                            onClick = { selectedTemplateId = item.id },
                            text = { Text(item.name, fontWeight = FontWeight.SemiBold) }
                        )
                    }
                }
            }

            // Área de Exibição do Template Selecionado
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                when (selectedTemplateId) {
                    0 -> WgcProfileFactoryShowcase()
                    1 -> {
                        var selectedBrandIndex by remember { mutableIntStateOf(0) }
                        val brands = listOf(
                            WgcBrand.FoodDelivery,
                            WgcBrand.Marketplace,
                            WgcBrand.FintechNeobank,
                            WgcBrand.GymFitness,
                            WgcBrand.UrbanMobility
                        )
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "WgcHomeFactory (Marca Selecionada: ${brands[selectedBrandIndex].brandName})",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                                brands.forEachIndexed { index, brand ->
                                    FilterChip(
                                        selected = selectedBrandIndex == index,
                                        onClick = { selectedBrandIndex = index },
                                        label = { Text(brand.brandName) }
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                WgcHomeFactory(brand = brands[selectedBrandIndex])
                            }
                        }
                    }
                    2 -> WgcFactoriesAndSlotsCatalogSection(selectedSubTab = 0)
                    3 -> WgcNotificationCenterTemplate()
                    4 -> WgcUserProfileEditTemplate()
                    5 -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                    6 -> RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
                    7 -> SearchAndFilterScreenTemplate(viewModel = FakeSearchAndFilterViewModel())
                    8 -> LoginScreenTemplate(viewModel = FakeLoginViewModel())
                    9 -> WgcWaveAuthScreenTemplate()
                    10 -> WgcSplitCardAuthScreenTemplate()
                    11 -> WgcKlokAuthScreenTemplate()
                    12 -> MultiBrandAuthCatalogSection()
                    13 -> WgcMarketplaceHomeScreenTemplate(viewModel = FakeMarketplaceHomeViewModel())
                    14 -> WgcFoodDeliveryHomeScreenTemplate(viewModel = FakeFoodDeliveryHomeViewModel())
                    15 -> WgcQuickFoodDeliveryHomeScreenTemplate(viewModel = FakeQuickFoodDeliveryHomeViewModel())
                    16 -> InstagramStoryViewerScreenTemplate(viewModel = FakeInstagramStoryViewerViewModel())
                    17 -> FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
                    18 -> EcommerceHomeScreenTemplate(viewModel = FakeEcommerceHomeViewModel())
                    19 -> WgcBrandAddressRegistrationScreenTemplate(viewModel = FakeBrandAddressAuthViewModel())
                    20 -> WgcCheckoutTemplate(viewModel = FakeCheckoutViewModel())
                    21 -> WgcFinancialStatementTemplate(viewModel = FakeFinancialStatementViewModel())
                    22 -> WgcProductDetailTemplate(viewModel = FakeProductDetailViewModel())
                    23 -> WgcHelpCenterSupportTemplate(viewModel = FakeHelpCenterViewModel())
                    24 -> WgcFeedbackReviewTemplate(viewModel = FakeFeedbackReviewViewModel())
                    25 -> WgcPixTransferTemplate(viewModel = FakePixTransferViewModel())
                    26 -> WgcCardManagementTemplate(viewModel = FakeCardManagementViewModel())
                    27 -> WgcLoanSimulatorTemplate(viewModel = FakeLoanSimulatorViewModel())
                    28 -> WgcNotificationHubTemplate(viewModel = FakeNotificationHubViewModel())
                    29 -> WgcSecuritySettingsTemplate(viewModel = FakeSecuritySettingsViewModel())
                    else -> WgcNotificationCenterTemplate()
                }
            }
        }
    }
}
