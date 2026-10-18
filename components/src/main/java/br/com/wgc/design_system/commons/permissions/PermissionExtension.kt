package br.com.wgc.design_system.commons.permissions

import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
private fun rememberNotificationPermissionLauncher(
    onPermissionGranted: () -> Unit,
    onPermissionDenied: () -> Unit,
): ActivityResultLauncher<String> = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission(),
    onResult = { isGranted ->
        if (isGranted) onPermissionGranted()
        else onPermissionDenied()
    },
)

/**
 * Solicita uma permissão de runtime e informa o resultado por callback.
 *
 * Use dentro de uma tela Compose para pedir uma permissão de runtime suportada pelo fluxo Android
 * 13+ implementado aqui (por exemplo, notificações). A verificação e o pedido são iniciados ao entrar
 * na composição. Em versões anteriores ao Android 13, esta função não verifica nem solicita a
 * permissão e não chama os callbacks.
 *
 * ```kotlin
 * RequestPermission(
 *     permission = Manifest.permission.POST_NOTIFICATIONS,
 *     onPermissionGranted = { scheduleNotifications() },
 *     onPermissionDenied = { showPermissionExplanation() },
 * )
 * ```
 *
 * @param permission Nome da permissão Android a verificar/solicitar.
 * @param onPermissionGranted Callback se já estiver concedida ou for concedida no pedido.
 * @param onPermissionDenied Callback se o pedido retornar negado.
 */
@Composable
fun RequestPermission(
    permission: String,
    onPermissionGranted: () -> Unit = {},
    onPermissionDenied: () -> Unit = {},
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val context = LocalContext.current

        val permissionLauncher = rememberNotificationPermissionLauncher(
            onPermissionGranted = onPermissionGranted,
            onPermissionDenied = onPermissionDenied,
        )

        LaunchedEffect(Unit) {
            val hasPermission = ContextCompat.checkSelfPermission(
                context,
                permission,
            ) == PackageManager.PERMISSION_GRANTED

            if (!hasPermission) permissionLauncher.launch(permission)
            else onPermissionGranted()
        }
    }
}
