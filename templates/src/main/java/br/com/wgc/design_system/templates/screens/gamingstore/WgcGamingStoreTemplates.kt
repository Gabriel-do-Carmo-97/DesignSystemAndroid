package br.com.wgc.design_system.templates.screens.gamingstore

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcGamingStoreCatalogTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.gamingStoreBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("GAMING STORE • Promoção de Fim de Semana", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(GamingStoreMockData.sampleGames) { game ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.gamingStoreCardBg))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(game.title, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${game.discount} • R$ ${"%,.2f".format(game.price)}", color = Color(WgcCoreDsColors.gamingStoreAccent), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcGamingStoreLibraryTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Biblioteca de Jogos Instalados", modifier = modifier)

@Composable
fun WgcGamingStoreCommunityTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Central da Comunidade & Fóruns", modifier = modifier)

@Composable
fun WgcGamingStoreWishlistTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Lista de Desejos & Carrinho", modifier = modifier)

@Composable
fun WgcGamingStoreProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Jogador • Nível 45", modifier = modifier)
