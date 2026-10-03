package br.com.wgc.design_system.components.accessibility

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics

/**
 * Utilitários para enriquecer acessibilidade semântica e TalkBack custom actions.
 */
object WgcSemanticsHelper {

    /**
     * Adiciona ações semânticas personalizadas ao TalkBack para cartões e itens de lista complexos.
     */
    fun Modifier.wgcCustomActions(vararg actions: Pair<String, () -> Boolean>): Modifier {
        return this.semantics {
            customActions = actions.map { (label, action) ->
                CustomAccessibilityAction(label, action)
            }
        }
    }
}
