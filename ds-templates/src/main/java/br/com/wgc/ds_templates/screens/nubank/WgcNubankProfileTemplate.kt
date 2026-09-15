package br.com.wgc.ds_templates.screens.nubank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNubankProfileTemplate(
    onLogoutClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Meu Perfil & Segurança", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.nubankPrimary),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s60.dp)
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.AccountCircle, contentDescription = null, modifier = Modifier.size(WgcCoreDsSize.s60.dp), tint = Color(WgcCoreDsColors.nubankPrimary))
                        }
                        Text("Gabriel do Carmo", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
                        Text("Agência 0001 • Conta 1234567-8", color = Color.Gray, fontSize = WgcCoreDsFontSize.body2.sp)
                        Text("Banco 0260 - Nu Pagamentos S.A.", color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                            Icon(Icons.Default.Security, contentDescription = null, tint = Color(WgcCoreDsColors.nubankPrimary))
                            Text("Modo Rua (Proteção Extra)", fontWeight = FontWeight.SemiBold)
                        }
                        HorizontalDivider()
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                            Icon(Icons.Default.Fingerprint, contentDescription = null, tint = Color(WgcCoreDsColors.nubankPrimary))
                            Text("Acesso com Biometria", fontWeight = FontWeight.SemiBold)
                        }
                        HorizontalDivider()
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                            Icon(Icons.Default.Notifications, contentDescription = null, tint = Color(WgcCoreDsColors.nubankPrimary))
                            Text("Configurar Notificações", fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            item {
                OutlinedButton(
                    onClick = onLogoutClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)
                ) {
                    Icon(Icons.Default.ExitToApp, contentDescription = null)
                    Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text("Sair do Aplicativo")
                }
            }
        }
    }
}
