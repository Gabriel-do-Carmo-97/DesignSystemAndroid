package br.com.wgc.design_system.commons.locals

import androidx.compose.runtime.compositionLocalOf
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Fornece os tokens de espaçamento WGC pela árvore Compose.
 *
 * O valor padrão é [WgcCoreDsSpacing]. Use para consumir ou substituir o conjunto de espaçamentos
 * em uma subárvore, normalmente por meio de `LocalWgcSpacing.current` ou
 * `CompositionLocalProvider(LocalWgcSpacing provides customSpacing)`.
 */
val LocalWgcSpacing = compositionLocalOf { WgcCoreDsSpacing }
