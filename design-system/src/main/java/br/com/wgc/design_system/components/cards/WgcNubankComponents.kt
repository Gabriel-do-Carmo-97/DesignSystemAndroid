package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcNubankPixActionItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s60.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.gray100)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.Black,
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
        }
        Text(
            text = label,
            fontSize = 14.sp.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Composable
fun WgcNubankCreditCard(
    currentInvoice: Double,
    availableLimit: Double,
    dueDate: String,
    onPayInvoiceClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSize.s2.dp)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Icon(Icons.Default.CreditCard, contentDescription = null, tint = Color(WgcCoreDsColors.nubankPrimary))
                    Text("Cartão de Crédito", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
                }
                Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
            }
            Text("Fatura atual", fontSize = 14.sp.sp, color = Color.Gray)
            Text("R$ ${"%,.2f".format(currentInvoice)}", fontSize = 14.sp.sp, fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.nubankPrimary))
            Text("Limite disponível: R$ ${"%,.2f".format(availableLimit)}", fontSize = 14.sp.sp, color = Color.Gray)
            Text("Vencimento: $dueDate", fontSize = 14.sp.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
            Button(
                onClick = onPayInvoiceClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.nubankPrimary)),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
            ) {
                Text("Pagar Fatura", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Composable
fun WgcNubankCaixinhaCard(
    title: String,
    currentAmount: Double,
    targetAmount: Double,
    yieldLabel: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSize.s2.dp)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
                Text(yieldLabel, fontSize = 14.sp.sp, color = Color(WgcCoreDsColors.nubankPrimary), fontWeight = FontWeight.SemiBold)
            }
            Text("R$ ${"%,.2f".format(currentAmount)}", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp.sp, color = Color.Black)
            val progress = (currentAmount / targetAmount).toFloat().coerceIn(0f, 1f)
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth().height(WgcCoreDsSize.s8.dp).clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)),
                color = Color(WgcCoreDsColors.nubankPrimary),
                trackColor = Color(WgcCoreDsColors.gray200)
            )
            Text("Meta: R$ ${"%,.2f".format(targetAmount)}", fontSize = 14.sp.sp, color = Color.Gray)
        }
    }
}
