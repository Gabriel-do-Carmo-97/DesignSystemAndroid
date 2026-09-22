package br.com.wgc.design_system.navigation.guard

import androidx.navigation.NavController

/**
 * Interface base para interceptação e proteção de rotas (Route Guards).
 */
interface WgcRouteGuard {
    /**
     * Valida se a navegação para [targetRoute] está autorizada.
     */
    fun canNavigate(targetRoute: Any): Boolean

    /**
     * Rota de redirecionamento caso a validação falhe.
     */
    val fallbackRoute: Any
}

/**
 * Guard de autenticação que redireciona usuários não logados.
 */
class WgcAuthGuard(
    private val isAuthenticated: () -> Boolean,
    override val fallbackRoute: Any
) : WgcRouteGuard {
    override fun canNavigate(targetRoute: Any): Boolean = isAuthenticated()
}

/**
 * Guard biométrico para áreas sensíveis (ex: Extratos, Pagamentos, Cartões).
 */
class WgcBiometricGuard(
    private val isBiometricUnlocked: () -> Boolean,
    override val fallbackRoute: Any
) : WgcRouteGuard {
    override fun canNavigate(targetRoute: Any): Boolean = isBiometricUnlocked()
}

/**
 * Guard de validação cadastral / KYC.
 */
class WgcKycGuard(
    private val isKycVerified: () -> Boolean,
    override val fallbackRoute: Any
) : WgcRouteGuard {
    override fun canNavigate(targetRoute: Any): Boolean = isKycVerified()
}

/**
 * Executa navegação protegida aplicando uma esteira de [guards].
 * Se qualquer guard falhar, redireciona imediatamente para o [fallbackRoute] do respectivo guard.
 *
 * @return true se a navegação para [targetRoute] ocorreu com sucesso, false caso tenha ocorrido redirecionamento.
 */
fun NavController.navigateGuarded(
    targetRoute: Any,
    vararg guards: WgcRouteGuard
): Boolean {
    for (guard in guards) {
        if (!guard.canNavigate(targetRoute)) {
            navigate(guard.fallbackRoute)
            return false
        }
    }
    navigate(targetRoute)
    return true
}
