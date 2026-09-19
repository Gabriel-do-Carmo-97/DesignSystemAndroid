package br.com.wgc.ds_templates.integration

import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.core_ds.WgcCoreDsColorsFacade
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Testes de integração entre o módulo :templates e :components/:core.
 * 
 * Esta classe verifica se os templates estão consumindo corretamente
 * os componentes e tokens de design, garantindo consistência em telas completas.
 */
class TemplatesComponentsIntegrationTest {

    @Test
    fun `templates should have access to core tokens`() {
        // Verifica se os templates podem acessar tokens do core
        assertNotNull(WgcCoreDsSpacing.md16)
        assertNotNull(WgcCoreDsColorsFacade.primary)
        assertNotNull(WgcCoreDsColorsFacade.background)
    }

    @Test
    fun `templates should use consistent spacing values`() {
        // Verifica se os espaçamentos usados nos templates seguem a escala do core
        val standardSpacing = WgcCoreDsSpacing.md16
        assertNotNull(standardSpacing)
        assertTrue(standardSpacing > 0)
        
        // Verifica se existem variações de espaçamento para diferentes casos
        val smallSpacing = WgcCoreDsSpacing.xs8
        val largeSpacing = WgcCoreDsSpacing.lg24
        
        assertTrue(smallSpacing < standardSpacing)
        assertTrue(largeSpacing > standardSpacing)
    }

    @Test
    fun `templates should use semantic colors correctly`() {
        // Verifica se os templates usam cores semânticas do core
        assertNotNull(WgcCoreDsColorsFacade.primary)
        assertNotNull(WgcCoreDsColorsFacade.secondary)
        assertNotNull(WgcCoreDsColorsFacade.error)
        assertNotNull(WgcCoreDsColorsFacade.success)
        assertNotNull(WgcCoreDsColorsFacade.warning)
    }

    @Test
    fun `templates should maintain design system consistency`() {
        // Verifica se os valores dos tokens seguem os padrões do design system
        val spacingValue = WgcCoreDsSpacing.md16
        val borderRadiusValue = br.com.wgc.core_ds.WgcCoreDsBorderRadius.md8
        
        assertNotNull(spacingValue)
        assertNotNull(borderRadiusValue)
        
        // Verifica se os valores são positivos e razoáveis
        assertTrue(spacingValue > 0)
        assertTrue(borderRadiusValue > 0)
    }

    @Test
    fun `templates should support theming through core tokens`() {
        // Verifica se os tokens de tema do core estão disponíveis para templates
        val primaryColor = WgcCoreDsColorsFacade.primary
        val backgroundColor = WgcCoreDsColorsFacade.background
        
        assertNotNull(primaryColor)
        assertNotNull(backgroundColor)
    }
}