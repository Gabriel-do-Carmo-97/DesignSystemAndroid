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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcInterActionItem(
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
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp))
                .background(Color(WgcCoreDsColors.gray100)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(WgcCoreDsColors.interPrimary),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
        }
        Text(
            text = label,
            fontSize = WgcCoreDsFontSize.caption.sp,
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSize.s2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs4.dp)) {
                Text(storeName, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
                Text(description, fontSize = WgcCoreDsFontSize.body2.sp, color = Color.Gray)
                Surface(
                    color = Color(WgcCoreDsColors.interPrimary).copy(alpha = 0.1f),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm8.dp)
                ) {
                    Text(
                        cashback,
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xs4.dp),
                        color = Color(WgcCoreDsColors.interPrimary),
                        fontWeight = FontWeight.Bold,
                        fontSize = WgcCoreDsFontSize.caption.sp
                    )
                }
            }
            Button(
                onClick = onShopClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.interPrimary)),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)
            ) {
                Text("Ir à Loja", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
