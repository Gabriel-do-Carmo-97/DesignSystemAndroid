@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.timeline

/**
 * Estados possíveis para uma etapa na linha do tempo.
 */
enum class WgcTimelineState {
    Completed,
    InProgress,
    Pending,
    Failed
}
