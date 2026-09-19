package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Showcase interativo do módulo :core (Design Tokens).
 * Apresenta o catálogo visual de Cores, Tipografia, Espaçamentos, Raios e Elevações.
 */
@Suppress("MagicNumber")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoreTokensShowcase(
    onBack: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("🎨 Cores", "📐 Espaçamentos", "🔲 Raios de Borda", "⛰️ Elevações")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Módulo :core", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("Design Tokens Corporativos (SSOT)", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar ao Hub")
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
            PrimaryTabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title, fontWeight = FontWeight.SemiBold) }
                    )
                }
            }

            when (selectedTab) {
                0 -> ColorsSection()
                1 -> SpacingSection()
                2 -> BorderRadiusSection()
                3 -> ElevationSection()
            }
        }
    }
}

@Composable
private fun ColorsSection() {
    val sampleColors = listOf(
        Pair("primary (orange500)", Color(WgcCoreDsColors.primary)),
        Pair("secondary (white)", Color(WgcCoreDsColors.secondary)),
        Pair("success (green)", Color(WgcCoreDsColors.success)),
        Pair("warning (yellow)", Color(WgcCoreDsColors.warning)),
        Pair("error (red500)", Color(WgcCoreDsColors.error)),
        Pair("foodDeliveryRed", Color(WgcCoreDsColors.foodDeliveryRed)),
        Pair("marketplaceYellow", Color(WgcCoreDsColors.marketplaceYellow)),
        Pair("dealMarketplaceOrange", Color(WgcCoreDsColors.dealMarketplaceOrange)),
        Pair("freshGroceryEmerald", Color(WgcCoreDsColors.freshGroceryEmerald)),
        Pair("apparelPrimary", Color(WgcCoreDsColors.apparelPrimary)),
        Pair("gamingStoreBlue", Color(WgcCoreDsColors.gamingStoreBlue)),
        Pair("gamingStoreAccent", Color(WgcCoreDsColors.gamingStoreAccent)),
        Pair("liveStreamingPurple", Color(WgcCoreDsColors.liveStreamingPurple)),
        Pair("liveStreamingDarkCard", Color(WgcCoreDsColors.liveStreamingDarkCard)),
        Pair("socialFacebook", Color(WgcCoreDsColors.socialFacebook)),
        Pair("socialInstagram", Color(WgcCoreDsColors.socialInstagram)),
        Pair("socialLinkedIn", Color(WgcCoreDsColors.socialLinkedIn))
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        items(sampleColors.size) { index ->
            val (name, color) = sampleColors[index]
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.sm12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(color)
                            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    )
                    Column {
                        Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("WgcCoreDsColors.$name", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@Composable
private fun SpacingSection() {
    val spacings = listOf(
        Pair("none0", WgcCoreDsSpacing.none0),
        Pair("xxxs2", WgcCoreDsSpacing.xxxs2),
        Pair("xxs4", WgcCoreDsSpacing.xxs4),
        Pair("xs8", WgcCoreDsSpacing.xs8),
        Pair("sm12", WgcCoreDsSpacing.sm12),
        Pair("md16", WgcCoreDsSpacing.md16),
        Pair("lg24", WgcCoreDsSpacing.lg24),
        Pair("xl32", WgcCoreDsSpacing.xl32),
        Pair("xxl40", WgcCoreDsSpacing.xxl40),
        Pair("xxxl48", WgcCoreDsSpacing.xxxl48)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        items(spacings.size) { index ->
            val (name, value) = spacings[index]
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(name, fontWeight = FontWeight.Bold)
                    Text("${value}dp", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                }
                Spacer(Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(value.dp.coerceAtLeast(4.dp))
                        .clip(RoundedCornerShape(2.dp))
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.6f))
                )
            }
        }
    }
}

@Composable
private fun BorderRadiusSection() {
    val radiuses = listOf(
        Pair("none0", WgcCoreDsBorderRadius.none0),
        Pair("xs2", WgcCoreDsBorderRadius.xs2),
        Pair("sm4", WgcCoreDsBorderRadius.sm4),
        Pair("md8", WgcCoreDsBorderRadius.md8),
        Pair("lg12", WgcCoreDsBorderRadius.lg12),
        Pair("xl16", WgcCoreDsBorderRadius.xl16),
        Pair("xxl24", WgcCoreDsBorderRadius.xxl24)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        items(radiuses.size) { index ->
            val (name, value) = radiuses[index]
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(value.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .border(1.5.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(value.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("${value}dp", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
                Column {
                    Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("WgcCoreDsBorderRadius.$name = ${value}.dp", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
private fun ElevationSection() {
    val elevations = listOf(
        Pair("level0 (0dp)", WgcCoreDsElevation.level0),
        Pair("level1 (1dp)", WgcCoreDsElevation.level1),
        Pair("level2 (2dp)", WgcCoreDsElevation.level2),
        Pair("level3 (3dp)", WgcCoreDsElevation.level3),
        Pair("level6 (6dp)", WgcCoreDsElevation.level6),
        Pair("level8 (8dp)", WgcCoreDsElevation.level8)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
    ) {
        items(elevations.size) { index ->
            val (name, value) = elevations[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(value.dp, RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(name, fontWeight = FontWeight.Bold)
                    Text("WgcCoreDsElevation.$name", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}
