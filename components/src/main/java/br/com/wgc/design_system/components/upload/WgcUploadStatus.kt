@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.upload

/**
 * Estado do upload de um arquivo.
 */
enum class WgcUploadStatus {
    IDLE,
    UPLOADING,
    SUCCESS,
    ERROR
}
