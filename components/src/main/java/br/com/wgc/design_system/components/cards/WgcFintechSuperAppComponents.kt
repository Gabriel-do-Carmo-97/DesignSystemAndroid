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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcFintechSuperAppActionItem(
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
                .size(WgcCoreDsSize.s56.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                .background(Color(WgcCoreDsColors.gray100)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(WgcCoreDsColors.fintechOrange),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
        }
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Composable
fun WgcInterCashbackBanner(
    storeName: String,
    cashback: String,
    description: String,
    onShopClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSize.s2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                Text(storeName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(description, fontSize = 14.sp, color = Color.Gray)
                Surface(
                    color = Color(WgcCoreDsColors.fintechOrange).copy(alpha = 0.1f),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                ) {
                    Text(
                        cashback,
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                        color = Color(WgcCoreDsColors.fintechOrange),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
            Button(
                onClick = onShopClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.fintechOrange)),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
            ) {
                Text("Ir à Loja", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
