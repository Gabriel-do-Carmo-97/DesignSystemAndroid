package br.com.wgc.ds_templates.screens.smartfit.classes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcSmartFitBottomNav
import br.com.wgc.design_system.components.navigation.WgcSmartFitNavItem
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitClass
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitMockData

/**
 * Template da Grade de Aulas Coletivas da Smart Fit.
 *
 * Permite filtrar por modalidade, dia da semana, visualizar vagas restantes
 * e reservar presença com State Hoisting completo.
 *
 * 100% tokenizado com WgcCoreDs.
 */
@Composable
fun WgcSmartFitClassesTemplate(
    classes: List<SmartFitClass>,
    selectedDayIndex: Int,
    onSelectDay: (Int) -> Unit,
    selectedCategoryIndex: Int,
    onSelectCategory: (Int) -> Unit,
    modifier: Modifier = Modifier,
    unitName: String = "Smart Fit - Paulista Bela Cintra",
    onBackClick: (() -> Unit)? = null,
    onToggleBooking: ((classId: String, booked: Boolean) -> Unit)? = null,
    selectedNavItem: WgcSmartFitNavItem = WgcSmartFitNavItem.CLASSES,
    onNavItemClick: (WgcSmartFitNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val days = listOf("Hoje", "Amanhã", "Quarta", "Quinta", "Sexta", "Sábado")
    val categories = listOf("Todas", "Smart Box", "FitDance", "Pilates", "Funcional")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcSmartFitBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemClick
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        if (onBackClick != null) {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar",
                                    tint = Color(WgcCoreDsColors.smartfitTextPrimary),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "AULAS COLETIVAS",
                                color = Color(WgcCoreDsColors.smartfitYellow),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Grade & Reservas",
                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
                                modifier = Modifier.padding(top = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.smartfitYellow),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                                Text(
                                    text = unitName,
                                    color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }
                }
            }

            // Seletor de Dias
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    itemsIndexed(days) { index, day ->
                        val isSelected = index == selectedDayIndex
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.smartfitYellow)
                                    else Color(WgcCoreDsColors.smartfitDarkGray)
                                )
                                .border(
                                    BorderStroke(
                                        WgcCoreDsSize.s1.dp,
                                        if (isSelected) Color(WgcCoreDsColors.smartfitYellow)
                                        else Color(WgcCoreDsColors.smartfitMediumGray)
                                    ),
                                    RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectDay(index) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = day,
                                color = if (isSelected) Color(WgcCoreDsColors.smartfitTextInverse)
                                else Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            // Filtros de Categoria
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    itemsIndexed(categories) { index, cat ->
                        val isSelected = index == selectedCategoryIndex
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.smartfitMediumGray)
                                    else Color.Transparent
                                )
                                .clickable { onSelectCategory(index) }
                                .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Text(
                                text = cat,
                                color = if (isSelected) Color(WgcCoreDsColors.smartfitYellow)
                                else Color(WgcCoreDsColors.smartfitTextSecondary),
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            // Lista de Aulas
            items(classes, key = { it.id }) { itemClass ->
                val isSoldOut = itemClass.spotsLeft <= 0 && !itemClass.isBooked

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.smartfitDarkGray)
                    ),
                    border = BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        if (itemClass.isBooked) Color(WgcCoreDsColors.smartfitYellow)
                        else Color(WgcCoreDsColors.smartfitMediumGray)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        // Horário
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.smartfitBlack))
                                .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = itemClass.time.split(" - ").firstOrNull() ?: "",
                                color = Color(WgcCoreDsColors.smartfitYellow),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "${itemClass.durationMinutes} min",
                                color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                fontSize = 10.sp
                            )
                        }

                        // Informações
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Text(
                                text = itemClass.title,
                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.smartfitTextSecondary),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                                Text(
                                    text = itemClass.instructor,
                                    color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                    fontSize = 11.sp
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                                modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = itemClass.room,
                                    color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                    fontSize = 11.sp
                                )
                                Text(
                                    text = "•",
                                    color = Color(WgcCoreDsColors.smartfitMediumGray),
                                    fontSize = 11.sp
                                )
                                Text(
                                    text = if (isSoldOut) "Vagas Esgotadas" else "${itemClass.spotsLeft} vagas restantes",
                                    color = if (isSoldOut) Color(WgcCoreDsColors.smartfitCrowdHigh)
                                    else Color(WgcCoreDsColors.smartfitCrowdLow),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // Botão de Reserva
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(
                                    when {
                                        itemClass.isBooked -> Color(WgcCoreDsColors.smartfitYellow)
                                        isSoldOut -> Color(WgcCoreDsColors.smartfitMediumGray)
                                        else -> Color(WgcCoreDsColors.smartfitLightGray)
                                    }
                                )
                                .clickable(enabled = !isSoldOut || itemClass.isBooked) {
                                    onToggleBooking?.invoke(itemClass.id, !itemClass.isBooked)
                                }
                                .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                if (itemClass.isBooked) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.smartfitTextInverse),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                }
                                Text(
                                    text = when {
                                        itemClass.isBooked -> "RESERVADO"
                                        isSoldOut -> "ESGOTADO"
                                        else -> "RESERVAR"
                                    },
                                    color = if (itemClass.isBooked) Color(WgcCoreDsColors.smartfitTextInverse)
                                    else Color(WgcCoreDsColors.smartfitTextPrimary),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            item {
                Box(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(name = "Smart Fit Classes Template - Preview")
@Composable
fun WgcSmartFitClassesTemplatePreview() {
    WgcSmartFitClassesTemplate(
        classes = SmartFitMockData.mockClasses,
        selectedDayIndex = 0,
        onSelectDay = {},
        selectedCategoryIndex = 0,
        onSelectCategory = {}
    )
}
