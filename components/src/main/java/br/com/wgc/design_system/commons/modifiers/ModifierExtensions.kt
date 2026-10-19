package br.com.wgc.design_system.commons.modifiers

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Extensão de Modifier para prevenir múltiplos cliques acidentais rápidos (debounce temporal).
 *
 * Garante que cliques subsequentes dentro da janela de tempo configurada sejam descartados,
 * prevenindo abertura repetida de telas, requisições duplicadas e submissões indesejadas.
 *
 * @param debounceTimeMs Intervalo mínimo entre cliques válidos em milissegundos. Padrão: 600ms.
 * @param enabled Controla se o clique está ativo. Padrão: true.
 * @param showRipple Se verdadeiro, exibe a indicação visual de clique (ripple). Se falso, o clique é invisível.
 * @param onClickLabel Descrição de acessibilidade para a ação de clique (TalkBack).
 * @param role Tipo de elemento semântico para acessibilidade (ex: Role.Button).
 * @param onClick Ação executada quando o clique respeita o intervalo de debounce.
 *
 * Use em ações que não devem ser disparadas repetidamente em rápida sucessão, como envio de formulário.
 * A primeira chamada também precisa respeitar a janela desde o tempo inicial zero; normalmente isso
 * permite a interação imediatamente. Exemplo: `Modifier.debouncedClick { submit() }`.
 */
fun Modifier.debouncedClick(
    debounceTimeMs: Long = ComponentsConstants.Modifiers.DEFAULT_DEBOUNCE_TIME_MS,
    enabled: Boolean = true,
    showRipple: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier =
    composed {
        var lastClickTime by remember {
            mutableLongStateOf(ComponentsConstants.Modifiers.INITIAL_CLICK_TIME_MS)
        }

        val debouncedOnClick = {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTimeMs) {
                lastClickTime = currentTime
                onClick()
            }
        }

        if (showRipple) {
            this.clickable(
                enabled = enabled,
                onClickLabel = onClickLabel,
                role = role,
                onClick = debouncedOnClick,
            )
        } else {
            this.clickable(
                enabled = enabled,
                onClickLabel = onClickLabel,
                role = role,
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = debouncedOnClick,
            )
        }
    }

/**
 * Extensão de Modifier para cliques com debounce com customização explícita
 * de [MutableInteractionSource] e [Indication].
 *
 * Use esta sobrecarga quando o componente já compartilha uma fonte de interação ou precisa controlar
 * a indicação visual. Exemplo: `Modifier.debouncedClick(source, indication) { onSelect() }`.
 *
 * @param interactionSource Fonte de interações compartilhada com outros elementos.
 * @param indication Indicação visual do clique; `null` desativa o ripple.
 * @param debounceTimeMs Intervalo mínimo entre cliques aceitos, em milissegundos.
 * @param enabled Se o clique está habilitado.
 * @param onClickLabel Rótulo de acessibilidade para a ação.
 * @param role Papel semântico do elemento.
 * @param onClick Ação executada para clique aceito.
 */
fun Modifier.debouncedClick(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    debounceTimeMs: Long = ComponentsConstants.Modifiers.DEFAULT_DEBOUNCE_TIME_MS,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier =
    composed {
        var lastClickTime by remember {
            mutableLongStateOf(ComponentsConstants.Modifiers.INITIAL_CLICK_TIME_MS)
        }

        this.clickable(
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
        ) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTimeMs) {
                lastClickTime = currentTime
                onClick()
            }
        }
    }
