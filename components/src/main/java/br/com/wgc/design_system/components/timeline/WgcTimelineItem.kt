@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.timeline

import androidx.compose.runtime.Composable

/**
 * Modelo de dados para um item da linha do tempo.
 */
data class WgcTimelineItem(
    val title: String,
    val description: String? = null,
    val timestamp: String? = null,
    val status: WgcTimelineStatus = WgcTimelineStatus.PENDING,
    val icon: (@Composable () -> Unit)? = null
)
