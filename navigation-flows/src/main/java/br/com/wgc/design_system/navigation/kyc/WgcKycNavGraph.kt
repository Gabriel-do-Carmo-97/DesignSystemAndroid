package br.com.wgc.design_system.navigation.kyc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.kyc.WgcKycDocumentUiState
import br.com.wgc.design_system.templates.screens.kyc.WgcKycDocumentVerificationTemplate
import kotlinx.serialization.Serializable

@Serializable
object WgcKycGraphRoute

@Serializable
object WgcKycDocumentCaptureRoute

@Serializable
object WgcKycSuccessRoute

/**
 * Subgrafo de navegação modular para validação cadastral (KYC).
 */
fun NavGraphBuilder.kycNavGraph(
    navController: NavController,
    onKycCompleted: () -> Unit = {}
) {
    navigation<WgcKycGraphRoute>(
        startDestination = WgcKycDocumentCaptureRoute
    ) {
        composable<WgcKycDocumentCaptureRoute> {
            var uiState by remember {
                mutableStateOf(
                    WgcKycDocumentUiState(
                        title = "Verificação de Identidade",
                        description = "Tire uma foto nítida da frente e do verso do seu documento oficial (RG ou CNH)."
                    )
                )
            }

            WgcKycDocumentVerificationTemplate(
                uiState = uiState,
                onCaptureFront = {
                    uiState = uiState.copy(hasFrontPhoto = true)
                },
                onCaptureBack = {
                    uiState = uiState.copy(hasBackPhoto = true)
                },
                onSubmit = {
                    uiState = uiState.copy(isUploading = true)
                    navController.navigate(WgcKycSuccessRoute)
                }
            )
        }

        composable<WgcKycSuccessRoute> {
            Scaffold { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(WgcCoreDsSpacing.lg24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = "Documentos enviados com sucesso",
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Documentos em Análise",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)
                    )
                    Text(
                        text = "Recebemos suas fotos com sucesso. Em até 24 horas úteis você receberá uma notificação com o resultado da análise.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = WgcCoreDsSpacing.md16.dp)
                    )
                    WgcClassicButton(
                        text = "Concluir",
                        onClick = onKycCompleted,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

/**
 * Host independente para o fluxo de KYC.
 */
@Composable
fun WgcKycNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onKycCompleted: () -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = WgcKycGraphRoute,
        modifier = modifier
    ) {
        kycNavGraph(
            navController = navController,
            onKycCompleted = onKycCompleted
        )
    }
}
