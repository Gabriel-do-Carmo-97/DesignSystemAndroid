package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcProductivityTaskCard(
    taskTitle: String,
    tag: String,
    dueDate: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color.LightGray)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.CheckCircleOutline,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                )
                Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs8.dp))
                Text(
                    text = taskTitle,
                    fontSize = WgcCoreDsFontSize.md16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = tag,
                    fontSize = WgcCoreDsFontSize.xxs10.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Vence em: $dueDate",
                    fontSize = WgcCoreDsFontSize.xxs10.sp,
                    color = Color.Red
                )
            }
        }
    }
}
