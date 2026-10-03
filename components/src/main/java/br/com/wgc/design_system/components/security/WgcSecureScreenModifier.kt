package br.com.wgc.design_system.components.security

import android.app.Activity
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

/**
 * Aplica WindowManager.LayoutParams.FLAG_SECURE na Activity enquanto o Composable estiver ativo,
 * prevenindo capturas de tela e ocultando dados sensíveis no gerenciador de tarefas recentes do Android (OWASP Mobile M9).
 */
@Composable
fun WgcSecureScreenEffect(isSecure: Boolean = true) {
    val context = LocalContext.current
    DisposableEffect(isSecure) {
        val window = (context as? Activity)?.window
        if (isSecure && window != null) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }
        onDispose {
            if (isSecure && window != null) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
            }
        }
    }
}
