package br.com.wgc.ds_templates.screens.steam

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcSteamStoreTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.steamBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("STEAM • Promoção de Fim de Semana", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(SteamMockData.sampleGames) { game ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF2A475E))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(game.title, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${game.discount} • R$ ${"%,.2f".format(game.price)}", color = Color(0xFF66C0F4), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcSteamLibraryTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Biblioteca de Jogos Instalados", modifier = modifier)

@Composable
fun WgcSteamCommunityTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Central da Comunidade & Fóruns", modifier = modifier)

@Composable
fun WgcSteamWishlistTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Lista de Desejos & Carrinho", modifier = modifier)

@Composable
fun WgcSteamProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Steam • Nível 45 & Insígnias", modifier = modifier)
