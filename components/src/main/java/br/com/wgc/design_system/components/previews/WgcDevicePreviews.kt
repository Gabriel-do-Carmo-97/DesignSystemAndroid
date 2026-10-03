@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.previews

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotação Multi-Preview corporativa para validar componentes simultaneamente em múltiplas dimensões de tela:
 * - Telefone padrão
 * - Telefone em modo paisagem
 * - Dispositivo dobrável (Foldable)
 * - Tablet 10 polegadas
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Preview(name = "Phone - Portrait", device = Devices.PHONE, showBackground = true)
@Preview(name = "Phone - Landscape", device = "spec:width=891dp,height=411dp", showBackground = true)
@Preview(name = "Foldable", device = Devices.FOLDABLE, showBackground = true)
@Preview(name = "Tablet 10\"", device = Devices.TABLET, showBackground = true)
annotation class WgcDeviceMatrixPreviews
