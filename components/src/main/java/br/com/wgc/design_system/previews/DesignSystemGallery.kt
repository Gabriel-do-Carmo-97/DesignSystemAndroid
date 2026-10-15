package br.com.wgc.design_system.previews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.components.alert.AlertType
import br.com.wgc.design_system.components.alert.WgcAlert
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.badge.WgcBadge
import br.com.wgc.design_system.components.badge.WgcBadgeVariant
import br.com.wgc.design_system.components.buttons.WgcBrandPill
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.buttons.WgcSegmentedButton
import br.com.wgc.design_system.components.cards.WgcMerchantListingCard
import br.com.wgc.design_system.components.cards.WgcPromotionalProductCard
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.dialogs.WgcAlertDialog
import br.com.wgc.design_system.components.feedback.WgcRatingBar
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.components.inputs.WgcQuantityStepper
import br.com.wgc.design_system.components.inputs.WgcSlider
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.components.navigation.NavItem
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcBottomNavBar
import br.com.wgc.design_system.components.navigation.WgcMarketplaceSearchHeaderBar
import br.com.wgc.design_system.components.navigation.WgcTopAppBar
import br.com.wgc.design_system.components.radio.WgcRadioButton
import br.com.wgc.design_system.components.sections.WgcCircularCategoryRow
import br.com.wgc.design_system.components.sections.WgcDepartmentCategoryGrid
import br.com.wgc.design_system.components.story.StoryState
import br.com.wgc.design_system.components.story.StoryTrayItem
import br.com.wgc.design_system.components.story.WgcStoryTray
import br.com.wgc.design_system.components.tooltip.WgcTooltip

/**
 * Galeria Centralizada e Completa (Master Gallery Sheet) de Todos os Componentes do Design System.
 * Agrupa átomos, moléculas e organismos por categorias com todas as suas variações (Default, Loading, Disabled, Estados, etc.).
 */
@Composable
fun DesignSystemGalleryScreen(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    var radioState by remember { mutableStateOf(true) }
    var chipState by remember { mutableStateOf(true) }
    var sliderValue by remember { mutableStateOf(0.65f) }
    var segmentIndex by remember { mutableStateOf(0) }
    var stepperQuantity by remember { mutableStateOf(1) }
    var textInputState by remember { mutableStateOf("") }
    var ratingState by remember { mutableStateOf(4f) }
    var bottomNavIndex by remember { mutableStateOf(0) }

    val sampleStories = remember {
        listOf(
            StoryTrayItem("1", "Seu Story", isUserStory = true),
            StoryTrayItem("2", "Mariana", storyState = StoryState.UNSEEN),
            StoryTrayItem("3", "Lucas", storyState = StoryState.CLOSE_FRIENDS),
            StoryTrayItem("4", "Ana", storyState = StoryState.SEEN)
        )
    }

    val bottomNavItems = listOf(
        NavItem("Início", Icons.Default.Home, onClick = {}),
        NavItem("Carrinho", Icons.Default.ShoppingCart, badgeCount = 2, onClick = {}),
        NavItem("Perfil", Icons.Default.Person, onClick = {})
    )

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            Text(
                text = "🎨 WGC Design System Master Gallery Sheet",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Visão consolidada de todos os componentes, átomos, moléculas e suas variações de estado.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // --- 1. BOTÕES & AÇÕES ---
            GallerySection(title = "1. Botões & Ações (Variantes & Estados)") {
                Text(text = "Classic Buttons:", style = MaterialTheme.typography.labelMedium)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                    WgcClassicButton(textButton = "Primário", onClick = {}, modifier = Modifier.weight(1f))
                    WgcSecondaryClassicButton(textButton = "Secundário", onClick = {}, modifier = Modifier.weight(1f))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                    WgcClassicButton(textButton = "Carregando", isLoading = true, onClick = {}, modifier = Modifier.weight(1f))
                    WgcClassicButton(textButton = "Desabilitado", isEnabled = false, onClick = {}, modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Segmented & Pill Buttons:", style = MaterialTheme.typography.labelMedium)
                WgcSegmentedButton(
                    options = listOf("Visão Geral", "Detalhes", "Avaliações"),
                    selectedIndex = segmentIndex,
                    onOptionSelected = { segmentIndex = it }
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    WgcBrandPill(brandName = "Destaque WGC")
                    WgcIconButton(onClick = {}, icon = Icons.Default.Star, contentDescription = "Favorito")
                }
            }

            // --- 2. INPUTS & CONTROLES ---
            GallerySection(title = "2. Entradas, Inputs & Controles") {
                SimpleTextField(
                    value = textInputState,
                    onValueChange = { textInputState = it },
                    label = "Campo de Texto Padrão",
                    placeholderText = "Digite algo..."
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(text = "Switch (Ligado/Desligado)")
                    WgcSwitch(checked = switchState, onCheckedChange = { switchState = it })
                }

                WgcRadioButton(
                    selected = radioState,
                    label = "Opção de Rádio Selecionada",
                    onClick = { radioState = !radioState }
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    WgcChip(label = "Chip Selecionado", selected = chipState, onClick = { chipState = !chipState })
                    WgcChip(label = "Chip Padrão", selected = false, onClick = {})
                }

                Column {
                    Text(text = "Slider Value: ${(sliderValue * 100).toInt()}%")
                    WgcSlider(value = sliderValue, onValueChange = { sliderValue = it })
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(text = "Steppers de Quantidade:")
                    WgcQuantityStepper(
                        quantity = stepperQuantity,
                        onQuantityChange = { stepperQuantity = it }
                    )
                }
            }

            // --- 3. AVISOS, BADGES & FEEDBACK ---
            GallerySection(title = "3. Feedback, Alertas & Badges") {
                WgcAlert(title = "Sucesso", message = "Operação concluída com êxito.", type = AlertType.SUCCESS)
                WgcAlert(title = "Atenção", message = "Verifique os dados antes de prosseguir.", type = AlertType.WARNING)
                WgcAlert(title = "Erro Crítico", message = "Falha ao conectar com o servidor.", type = AlertType.ERROR)
                WgcAlert(title = "Informativo", message = "Nova versão disponível para atualização.", type = AlertType.INFO)

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    WgcBadge(text = "Novo", variant = WgcBadgeVariant.Primary)
                    WgcBadge(text = "Promoção", variant = WgcBadgeVariant.Success)
                    WgcBadge(text = "Esgotado", variant = WgcBadgeVariant.Warning)
                }

                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(text = "Avaliação:")
                    WgcRatingBar(
                        rating = ratingState,
                        onRatingChange = { ratingState = it },
                        isInteractive = true
                    )
                }
            }

            // --- 4. AVATARES, STORIES & LISTAS ---
            GallerySection(title = "4. Avatares, Stories & Listas") {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    WgcAvatar(initials = "WG", size = 48.dp)
                    WgcAvatar(initials = "MA", size = 40.dp)
                    WgcAvatar(initials = "DS", size = 32.dp)
                }

                WgcStoryTray(stories = sampleStories, onStoryClick = {})

                WgcListItem(
                    headlineText = "Item de Lista Principal",
                    supportingText = "Texto de suporte explicativo do item da lista",
                    leadingContent = { WgcAvatar(initials = "LT") }
                )

                WgcTooltip(text = "Tooltip explicativo de ajuda ao usuário") {
                    Text(text = "Toque ou passe o mouse aqui para exibir o Tooltip")
                }
            }

            // --- 5. NAVEGAÇÃO & HEADERS ---
            GallerySection(title = "5. Navegação & Cabeçalhos") {
                WgcAddressHeaderBar()
                WgcMarketplaceSearchHeaderBar()
                WgcTopAppBar(title = "Título da Tela")
                WgcBottomNavBar(
                    items = bottomNavItems,
                    selectedIndex = bottomNavIndex,
                    onItemSelected = { bottomNavIndex = it }
                )
            }

            // --- 6. CARDS & ORGANISMOS ---
            GallerySection(title = "6. Cards & Vitrines Comerciais") {
                WgcMerchantListingCard(
                    name = "Restaurante Sabor & Arte",
                    rating = "4.9",
                    deliveryFee = "Grátis"
                )

                WgcPromotionalProductCard(
                    title = "Smart TV 55\" 4K UHD LED",
                    originalPrice = "R$ 1.999",
                    currentPrice = "R$ 1.499"
                )
            }

            // --- 7. SEÇÕES & CATEGORIAS ---
            GallerySection(title = "7. Seções & Categorias") {
                WgcCircularCategoryRow()
                WgcDepartmentCategoryGrid()
            }
        }
    }
}

@Composable
fun GallerySection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            HorizontalDivider()
            content()
        }
    }
}

@WgcComponentPreviews
@Composable
private fun DesignSystemGalleryPreview() {
    MaterialTheme {
        DesignSystemGalleryScreen()
    }
}
