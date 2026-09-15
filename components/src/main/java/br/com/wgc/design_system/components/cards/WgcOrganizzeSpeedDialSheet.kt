package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Menu de Lançamento Rápido (Speed Dial) do Organizze.
 * Oferece os 3 caminhos de entrada: Nova Despesa (Vermelho), Nova Receita (Verde), Nova Transferência (Azul).
 */
@Composable
fun WgcOrganizzeSpeedDialSheet(
    modifier: Modifier = Modifier,
    onNewExpenseClick: () -> Unit = {},
    onNewIncomeClick: () -> Unit = {},
    onNewTransferClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = WgcCoreDsBorderRadius.xxl24.dp,
            topEnd = WgcCoreDsBorderRadius.xxl24.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.md16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Drag handle pill
            Box(
                modifier = Modifier
                    .width(WgcCoreDsSpacing.xxl40.dp)
                    .height(WgcCoreDsSpacing.xxs4.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color(WgcCoreDsColors.organizzeBorder))
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = "O que deseja lançar?",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.organizzeDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Botão 1: Despesa
                SpeedDialActionButton(
                    title = "Despesa",
                    icon = Icons.Default.ArrowDownward,
                    color = Color(WgcCoreDsColors.organizzeExpenseRed),
                    onClick = onNewExpenseClick
                )

                // Botão 2: Receita
                SpeedDialActionButton(
                    title = "Receita",
                    icon = Icons.Default.ArrowUpward,
                    color = Color(WgcCoreDsColors.organizzeIncomeGreen),
                    onClick = onNewIncomeClick
                )

                // Botão 3: Transferência
                SpeedDialActionButton(
                    title = "Transferência",
                    icon = Icons.Default.SwapHoriz,
                    color = Color(WgcCoreDsColors.organizzeTransferBlue),
                    onClick = onNewTransferClick
                )
            }
        }
    }
}

@Composable
private fun SpeedDialActionButton(
    title: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.xs8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s56.dp)
                .clip(CircleShape)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)
            )
        }
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.organizzeDark)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeSpeedDialSheetPreview() {
    WgcOrganizzeSpeedDialSheet()
}
