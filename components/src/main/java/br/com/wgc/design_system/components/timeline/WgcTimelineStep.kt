@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.timeline

/**
 * Modelo de dados de um item da linha do tempo.
 */
data class WgcTimelineStep(
    val id: String,
    val title: String,
    val description: String? = null,
    val timestamp: String? = null,
    val state: WgcTimelineState = WgcTimelineState.Pending
)
