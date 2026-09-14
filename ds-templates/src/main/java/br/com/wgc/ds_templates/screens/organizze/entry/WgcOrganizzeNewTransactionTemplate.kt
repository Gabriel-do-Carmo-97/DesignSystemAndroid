package br.com.wgc.ds_templates.screens.organizze.entry

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcOrganizzeTransactionType
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeCategoryItem
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeMockData

/**
 * Template de Criação de Lançamento (Despesa / Receita / Transferência) do Organizze.
 */
@Composable
fun WgcOrganizzeNewTransactionTemplate(
    modifier: Modifier = Modifier,
    initialType: WgcOrganizzeTransactionType = WgcOrganizzeTransactionType.Expense,
    categories: List<OrganizzeCategoryItem> = OrganizzeMockData.categories,
    onBackClick: () -> Unit = {},
    onSaveClick: (amount: String, description: String, category: String, isPaid: Boolean) -> Unit = { _, _, _, _ -> }
) {
    var selectedType by remember { mutableStateOf(initialType) }
    var amountValue by remember { mutableStateOf("0,00") }
    var description by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull()) }
    var isPaid by remember { mutableStateOf(true) }

    val themeColor = when (selectedType) {
        WgcOrganizzeTransactionType.Expense -> Color(WgcCoreDsColors.organizzeExpenseRed)
        WgcOrganizzeTransactionType.Income -> Color(WgcCoreDsColors.organizzeIncomeGreen)
        WgcOrganizzeTransactionType.Transfer -> Color(WgcCoreDsColors.organizzeTransferBlue)
    }

    val typeTitle = when (selectedType) {
        WgcOrganizzeTransactionType.Expense -> "Nova Despesa"
        WgcOrganizzeTransactionType.Income -> "Nova Receita"
        WgcOrganizzeTransactionType.Transfer -> "Nova Transferência"
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.organizzeBackground),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Button(
                    onClick = {
                        onSaveClick(
                            amountValue,
                            description,
                            selectedCategory?.name ?: "Geral",
                            isPaid
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = themeColor)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Salvar $typeTitle",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header Colorido Dinâmico
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(themeColor)
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar",
                                tint = Color.White
                            )
                        }

                        // Seletor de Tipo (Despesa / Receita / Transferência)
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.display45.dp))
                                .background(Color.Black.copy(alpha = 0.2f))
                                .padding(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            TypeTabPill(
                                label = "Despesa",
                                isSelected = selectedType == WgcOrganizzeTransactionType.Expense,
                                onClick = { selectedType = WgcOrganizzeTransactionType.Expense }
                            )
                            TypeTabPill(
                                label = "Receita",
                                isSelected = selectedType == WgcOrganizzeTransactionType.Income,
                                onClick = { selectedType = WgcOrganizzeTransactionType.Income }
                            )
                        }

                        Box(modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp))
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                    // Input de Valor em Destaque
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Valor",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "R$ ",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            OutlinedTextField(
                                value = amountValue,
                                onValueChange = { amountValue = it },
                                textStyle = MaterialTheme.typography.headlineLarge.copy(
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                ),
                                singleLine = true,
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Transparent,
                                    unfocusedBorderColor = Color.Transparent
                                ),
                                modifier = Modifier.width(WgcCoreDsSize.s200.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                }
            }

            // Formulário de Detalhes
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // Campo de Descrição
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
                ) {
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.xs8.dp),
                        placeholder = { Text("Descrição (ex: Almoço de domingo)") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        singleLine = true
                    )
                }

                // Seletor de Categoria
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(
                            text = "Selecione a categoria",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.organizzeDark)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        // Grid de Categorias
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s180.dp),
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            items(categories) { cat ->
                                val isSelected = selectedCategory?.id == cat.id
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                                        .background(if (isSelected) Color(cat.color).copy(alpha = 0.2f) else Color.Transparent)
                                        .clickable { selectedCategory = cat }
                                        .padding(WgcCoreDsSpacing.xs8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSpacing.xxl40.dp)
                                            .clip(CircleShape)
                                            .background(Color(cat.color)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = cat.icon,
                                            contentDescription = cat.name,
                                            tint = Color.White,
                                            modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                                    Text(
                                        text = cat.name,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = Color(WgcCoreDsColors.organizzeDark)
                                    )
                                }
                            }
                        }
                    }
                }

                // Linha de Conta / Cartão
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.AccountBalance,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.organizzePrimary)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                            Text(
                                text = "Conta ou Cartão",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(WgcCoreDsColors.organizzeDark)
                            )
                        }
                        Text(
                            text = "NuConta >",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.organizzePrimary)
                        )
                    }
                }

                // Linha de Data e Toggle Pago / Pendente
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.organizzeSecondaryText)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                                Text(
                                    text = "Data",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(WgcCoreDsColors.organizzeDark)
                                )
                            }
                            Text(
                                text = "Hoje, 14 de Maio",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.organizzeDark)
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (selectedType == WgcOrganizzeTransactionType.Expense) "Despesa já paga?" else "Receita já recebida?",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(WgcCoreDsColors.organizzeDark)
                            )
                            Switch(
                                checked = isPaid,
                                onCheckedChange = { isPaid = it },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = themeColor
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TypeTabPill(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.display45.dp))
            .background(if (isSelected) Color.White else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xxs4.dp
            )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color(WgcCoreDsColors.organizzeDark) else Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeNewTransactionTemplatePreview() {
    WgcOrganizzeNewTransactionTemplate()
}
