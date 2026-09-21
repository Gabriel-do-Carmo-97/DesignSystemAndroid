@file:Suppress("LongMethod", "CyclomaticComplexMethod", "MagicNumber")
package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.navigation.WgcMenuItem
import br.com.wgc.design_system.components.navigation.WgcMenuType
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system_wgc.WgcAlertCatalogSection
import br.com.wgc.design_system_wgc.WgcAvatarCatalogSection
import br.com.wgc.design_system_wgc.WgcBadgeCatalogSection
import br.com.wgc.design_system_wgc.WgcBiometricButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcBottomSheetCatalogSection
import br.com.wgc.design_system_wgc.WgcChipCatalogSection
import br.com.wgc.design_system_wgc.WgcClassicButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcColorPickerCatalogSection
import br.com.wgc.design_system_wgc.WgcDeliveryComponentsCatalogSection
import br.com.wgc.design_system_wgc.WgcFoodListingComponentsCatalogSection
import br.com.wgc.design_system_wgc.WgcIconButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcListItemCatalogSection
import br.com.wgc.design_system_wgc.WgcMarketplaceComponentsCatalogSection
import br.com.wgc.design_system_wgc.WgcOtpInputCatalogSection
import br.com.wgc.design_system_wgc.WgcPillTabSwitchCatalogSection
import br.com.wgc.design_system_wgc.WgcRadioButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcRatingBarCatalogSection
import br.com.wgc.design_system_wgc.WgcSecondaryClassicButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcSegmentedButtonCatalogSection
import br.com.wgc.design_system_wgc.WgcSkeletonCatalogSection
import br.com.wgc.design_system_wgc.WgcSliderCatalogSection
import br.com.wgc.design_system_wgc.WgcSnackbarCatalogSection
import br.com.wgc.design_system_wgc.WgcSocialLoginPillCatalogSection
import br.com.wgc.design_system_wgc.WgcStoryAvatarCatalogSection
import br.com.wgc.design_system_wgc.WgcStoryTrayCatalogSection
import br.com.wgc.design_system_wgc.WgcSwitchCatalogSection
import br.com.wgc.design_system_wgc.WgcTagCatalogSection
import br.com.wgc.design_system_wgc.WgcTimelineCatalogSection

/**
 * Categoria lógica de componentes para filtragem rápida.
 */
enum class ComponentCategory(val title: String) {
    ALL("Todos"),
    BUTTONS("Botões"),
    INPUTS("Campos & Inputs"),
    FEEDBACK("Feedback & Alertas"),
    STRUCTURE("Estrutura & Navegação"),
    ECOMMERCE("E-Commerce & Delivery")
}

data class ComponentShowcaseItem(
    val id: Int,
    val name: String,
    val category: ComponentCategory,
    val description: String
)

/**
 * Showcase oficial interativo do módulo :components.
 * Permite buscar, filtrar por categoria e inspecionar todos os componentes com seus estados e interatividade.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsShowcase(
    onBack: () -> Unit
) {
    val allComponents = remember {
        listOf(
            ComponentShowcaseItem(0, "WgcClassicButton", ComponentCategory.BUTTONS, "Botão principal com suporte a loading e desabilitado"),
            ComponentShowcaseItem(1, "WgcSecondaryClassicButton", ComponentCategory.BUTTONS, "Botão secundário corporativo"),
            ComponentShowcaseItem(2, "WgcIconButton", ComponentCategory.BUTTONS, "Botão de ícone acessível"),
            ComponentShowcaseItem(3, "WgcSegmentedButton", ComponentCategory.BUTTONS, "Seletor segmentado de opções"),
            ComponentShowcaseItem(4, "WgcSwitch", ComponentCategory.INPUTS, "Interruptor binário com estados"),
            ComponentShowcaseItem(5, "WgcRadioButton", ComponentCategory.INPUTS, "Botão de opção radial"),
            ComponentShowcaseItem(6, "WgcChip", ComponentCategory.FEEDBACK, "Chip de filtro e seleção"),
            ComponentShowcaseItem(7, "WgcSlider", ComponentCategory.INPUTS, "Controle deslizante numérico contínuo"),
            ComponentShowcaseItem(8, "WgcAlert", ComponentCategory.FEEDBACK, "Alertas semânticos de Sucesso, Erro, Aviso e Info"),
            ComponentShowcaseItem(9, "WgcAvatar", ComponentCategory.STRUCTURE, "Avatar de usuário com escala de tamanhos"),
            ComponentShowcaseItem(10, "WgcListItem", ComponentCategory.STRUCTURE, "Item de lista com leading e supporting text"),
            ComponentShowcaseItem(11, "WgcStoryAvatar", ComponentCategory.STRUCTURE, "Avatar de stories com anel de status"),
            ComponentShowcaseItem(12, "WgcStoryTray", ComponentCategory.STRUCTURE, "Bandeja horizontal de stories"),
            ComponentShowcaseItem(13, "WgcDeliveryComponents", ComponentCategory.ECOMMERCE, "Header de endereço, listagem e barra flutuante"),
            ComponentShowcaseItem(14, "WgcFoodListingComponents", ComponentCategory.ECOMMERCE, "Grade de categorias e card de restaurante"),
            ComponentShowcaseItem(15, "WgcMarketplaceComponents", ComponentCategory.ECOMMERCE, "Barra de busca de marketplace e cards"),
            ComponentShowcaseItem(16, "WgcBiometricButton", ComponentCategory.BUTTONS, "Botão de autenticação biométrica com estilos"),
            ComponentShowcaseItem(17, "WgcSocialLoginPill", ComponentCategory.BUTTONS, "Grupo de botões de login social"),
            ComponentShowcaseItem(18, "WgcPillTabSwitch", ComponentCategory.BUTTONS, "Alternador em pílula"),
            ComponentShowcaseItem(19, "WgcColorPicker", ComponentCategory.INPUTS, "Roda cromática 360° com dialog e bottom sheet"),
            ComponentShowcaseItem(20, "WgcBadge", ComponentCategory.FEEDBACK, "Badges numéricos e pontos de notificação"),
            ComponentShowcaseItem(21, "WgcTag", ComponentCategory.FEEDBACK, "Tags de status preenchidas e contornadas"),
            ComponentShowcaseItem(22, "WgcSnackbar", ComponentCategory.FEEDBACK, "Snackbars contextuais com variantes semânticas"),
            ComponentShowcaseItem(23, "WgcOtpInput", ComponentCategory.INPUTS, "Entrada de código PIN/OTP de 4 e 6 dígitos"),
            ComponentShowcaseItem(24, "WgcTimeline", ComponentCategory.STRUCTURE, "Linha do tempo e esteira de rastreamento"),
            ComponentShowcaseItem(25, "WgcRatingBar", ComponentCategory.FEEDBACK, "Avaliação por estrelas interativa e read-only"),
            ComponentShowcaseItem(26, "WgcBottomSheet", ComponentCategory.STRUCTURE, "Folha inferior modal padronizada"),
            ComponentShowcaseItem(27, "WgcSkeleton", ComponentCategory.FEEDBACK, "Placeholders de carregamento para listas, perfis e cards"),
            ComponentShowcaseItem(
                id = 28,
                name = "WgcBottomNavigation",
                category = ComponentCategory.STRUCTURE,
                description = "Barra inferior de 2 a 5 itens com dock central elevado"
            )
        )
    }

    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(ComponentCategory.ALL) }
    var selectedComponentId by remember { mutableIntStateOf(0) }

    val filteredComponents = remember(searchQuery, selectedCategory) {
        allComponents.filter { item ->
            val matchesCategory = selectedCategory == ComponentCategory.ALL || item.category == selectedCategory
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
                            text = "Módulo :components",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Biblioteca Corporativa de Átomos e Moléculas",
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
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Buscar componente... (ex: Button, Slider, Otp)") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Limpar busca")
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                )

                // Chips de Categoria
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    contentPadding = PaddingValues(end = WgcCoreDsSpacing.md16.dp)
                ) {
                    itemsIndexed(ComponentCategory.entries) { _, category ->
                        FilterChip(
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                            label = { Text(category.title, fontSize = 12.sp) }
                        )
                    }
                }
            }

            // Scrollable Tab Row com os Componentes Filtrados
            if (filteredComponents.isNotEmpty()) {
                val currentTabIndex = filteredComponents.indexOfFirst { it.id == selectedComponentId }
                    .coerceAtLeast(0)

                PrimaryScrollableTabRow(
                    selectedTabIndex = currentTabIndex,
                    edgePadding = WgcCoreDsSpacing.md16.dp
                ) {
                    filteredComponents.forEachIndexed { index, comp ->
                        Tab(
                            selected = currentTabIndex == index,
                            onClick = { selectedComponentId = comp.id },
                            text = {
                                Text(
                                    text = comp.name,
                                    fontWeight = if (currentTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                            }
                        )
                    }
                }

                // Conteúdo do Componente Selecionado
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    when (selectedComponentId) {
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
                        19 -> WgcColorPickerCatalogSection()
                        20 -> WgcBadgeCatalogSection()
                        21 -> WgcTagCatalogSection()
                        22 -> WgcSnackbarCatalogSection()
                        23 -> WgcOtpInputCatalogSection()
                        24 -> WgcTimelineCatalogSection()
                        25 -> WgcRatingBarCatalogSection()
                        26 -> WgcBottomSheetCatalogSection()
                        27 -> WgcSkeletonCatalogSection()
                        28 -> WgcBottomNavigationCatalogSection()
                        else -> WgcClassicButtonCatalogSection()
                    }
                }
            } else {
                // Estado Vazio
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WgcCoreDsSpacing.xl32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Nenhum componente encontrado",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Tente alterar os termos da busca ou selecione a categoria 'Todos'.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

/**
 * Seção de demonstração interativa da Bottom Navigation Bar.
 * Demonstra a variação dinâmica de 2 a 5 itens e o botão central elevado estilo e-commerce (Dock / ProminentCenter).
 */
@Composable
fun WgcBottomNavigationCatalogSection() {
    var selectedType by remember { mutableStateOf(WgcMenuType.ProminentCenter) }
    var itemCount by remember { mutableIntStateOf(5) }
    var showBadges by remember { mutableStateOf(true) }
    var selectedItemIndex by remember { mutableIntStateOf(2) }

    val allPossibleItems = remember {
        listOf(
            WgcMenuItem(id = "home", label = "Início", icon = Icons.Default.Home),
            WgcMenuItem(id = "search", label = "Buscar", icon = Icons.Default.Search),
            WgcMenuItem(
                id = "cart",
                label = "Carrinho",
                icon = Icons.Default.ShoppingCart,
                isProminent = true,
                badgeCount = 3
            ),
            WgcMenuItem(
                id = "orders",
                label = "Pedidos",
                icon = Icons.Default.Receipt,
                badgeCount = 1
            ),
            WgcMenuItem(id = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    val currentItems = remember(itemCount, showBadges) {
        when (itemCount) {
            2 -> listOf(
                allPossibleItems[0].copy(badgeCount = 0),
                allPossibleItems[4].copy(badgeCount = if (showBadges) 1 else 0)
            )
            3 -> listOf(
                allPossibleItems[0].copy(badgeCount = 0),
                allPossibleItems[2].copy(badgeCount = if (showBadges) 3 else 0),
                allPossibleItems[4].copy(badgeCount = 0)
            )
            4 -> listOf(
                allPossibleItems[0].copy(badgeCount = 0),
                allPossibleItems[1].copy(badgeCount = 0),
                allPossibleItems[3].copy(badgeCount = if (showBadges) 2 else 0),
                allPossibleItems[4].copy(badgeCount = 0)
            )
            else -> allPossibleItems.map { it.copy(badgeCount = if (showBadges) it.badgeCount else 0) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        Text(
            text = "WgcBottomNavBar & WgcMenuFactory",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Barra de navegação inferior dinâmica de 2 a 5 itens e estilo " +
                "e-commerce com botão central elevado (Dock / ProminentCenter).",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // 1. Controles: Tipo de Menu
        Text("1. Variante da Barra Inferior:", style = MaterialTheme.typography.titleSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
            WgcMenuType.entries.forEach { type ->
                FilterChip(
                    selected = selectedType == type,
                    onClick = { selectedType = type },
                    label = {
                        Text(
                            when (type) {
                                WgcMenuType.ProminentCenter -> "⭐ ProminentCenter"
                                WgcMenuType.ClassicBottomBar -> "Clássica (M3)"
                                WgcMenuType.FloatingPill -> "Pílula Flutuante"
                                WgcMenuType.CollapsibleHeader -> "Abas Superiores"
                            },
                            fontSize = 12.sp
                        )
                    }
                )
            }
        }

        // 2. Controles: Quantidade de Itens (2 a 5)
        Text("2. Quantidade de Itens Dinâmica ($itemCount itens):", style = MaterialTheme.typography.titleSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
            listOf(2, 3, 4, 5).forEach { count ->
                FilterChip(
                    selected = itemCount == count,
                    onClick = {
                        itemCount = count
                        selectedItemIndex = if (count % 2 != 0) count / 2 else 0
                    },
                    label = { Text("$count Itens") }
                )
            }
        }

        // 3. Toggle de Badges
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            androidx.compose.material3.Checkbox(
                checked = showBadges,
                onCheckedChange = { showBadges = it }
            )
            Text("Exibir Badges de Notificação / Carrinho")
        }

        // 4. Área de Demonstração Interativa
        Text("3. Demonstração Interativa em Tempo Real:", style = MaterialTheme.typography.titleSmall)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                val activeItem = currentItems.getOrNull(selectedItemIndex.coerceIn(0, currentItems.size - 1))
                Text(
                    text = "Aba Ativa: ${activeItem?.label ?: "Nenhuma"}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        )
                        .padding(top = WgcCoreDsSpacing.xl32.dp, bottom = WgcCoreDsSpacing.xs8.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    br.com.wgc.design_system.components.navigation.WgcMenuFactory(
                        type = selectedType,
                        items = currentItems,
                        selectedIndex = selectedItemIndex.coerceIn(0, currentItems.size - 1),
                        onItemSelected = { selectedItemIndex = it }
                    )
                }
            }
        }
    }
}

