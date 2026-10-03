package br.com.wgc.design_system.navigation.interceptor

import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Interceptador customizado de botão de voltar (BackHandler) com diálogo nativo de confirmação.
 *
 * @param hasUnsavedChanges Se existem alterações pendentes que justificam o bloqueio.
 * @param onConfirmDiscard Callback executado se o usuário confirmar o descarte.
 * @param title Título do diálogo.
 * @param message Mensagem explicativa.
 */
@Composable
fun WgcBackHandlerInterceptor(
    hasUnsavedChanges: Boolean,
    onConfirmDiscard: () -> Unit,
    title: String = "Descartar alterações?",
    message: String = "Você possui alterações não salvas. Se voltar agora, todos os dados preenchidos serão perdidos."
) {
    var showConfirmationDialog by remember { mutableStateOf(false) }

    BackHandler(enabled = hasUnsavedChanges) {
        showConfirmationDialog = true
    }

    if (showConfirmationDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmationDialog = false },
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                TextButton(
                    onClick = {
                        showConfirmationDialog = false
                        onConfirmDiscard()
                    }
                ) {
                    Text(text = "Descartar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showConfirmationDialog = false }) {
                    Text(text = "Continuar Editando")
                }
            }
        )
    }
}
