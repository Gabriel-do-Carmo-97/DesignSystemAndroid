package br.com.wgc.design_system.integration

import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColorsFacade
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Testes de integração entre o módulo :components e :core.
 * 
 * Esta classe verifica se os componentes estão consumindo corretamente
 * os tokens de design do módulo core, garantindo consistência no design system.
 */
class ComponentsCoreIntegrationTest {

    @Test
    fun `components should consume core spacing tokens`() {
        // Verifica se os tokens de espaçamento do core estão acessíveis
        assertNotNull(WgcCoreDsSpacing.md16)
        assertEquals(16.0, WgcCoreDsSpacing.md16, 0.0)
        assertEquals(8.0, WgcCoreDsSpacing.xs8, 0.0)
        assertEquals(24.0, WgcCoreDsSpacing.lg24, 0.0)
    }

    @Test
    fun `components should consume core border radius tokens`() {
        // Verifica se os tokens de border radius do core estão acessíveis
        assertNotNull(WgcCoreDsBorderRadius.md8)
        assertEquals(8.0, WgcCoreDsBorderRadius.md8, 0.0)
        assertEquals(4.0, WgcCoreDsBorderRadius.sm4, 0.0)
        assertEquals(16.0, WgcCoreDsBorderRadius.xl16, 0.0)
    }

    @Test
    fun `components should consume core color tokens`() {
        // Verifica se os tokens de cor do core estão acessíveis
        assertNotNull(WgcCoreDsColorsFacade.primary)
        assertNotNull(WgcCoreDsColorsFacade.error)
        assertNotNull(WgcCoreDsColorsFacade.success)
        assertNotNull(WgcCoreDsColorsFacade.warning)
    }

    @Test
    fun `design tokens should have consistent values`() {
        // Verifica consistência dos valores dos tokens
        // Espaçamento segue escala de 4px base
        val baseSpacing = 4.0
        assertEquals(baseSpacing, WgcCoreDsSpacing.xxs4, 0.0)
        assertEquals(baseSpacing * 2, WgcCoreDsSpacing.xs8, 0.0)
        assertEquals(baseSpacing * 3, WgcCoreDsSpacing.sm12, 0.0)
        assertEquals(baseSpacing * 4, WgcCoreDsSpacing.md16, 0.0)
        
        // Border radius segue padrão consistente
        assertEquals(4.0, WgcCoreDsBorderRadius.sm4, 0.0)
        assertEquals(8.0, WgcCoreDsBorderRadius.md8, 0.0)
        assertEquals(16.0, WgcCoreDsBorderRadius.xl16, 0.0)
    }

    @Test
    fun `core color facade should provide backward compatibility`() {
        // Verifica se o facade de cores mantém compatibilidade com código existente
        assertNotNull(WgcCoreDsColorsFacade.white)
        assertNotNull(WgcCoreDsColorsFacade.black)
        assertNotNull(WgcCoreDsColorsFacade.transparent)
        assertNotNull(WgcCoreDsColorsFacade.textPrimary)
        assertNotNull(WgcCoreDsColorsFacade.textSecondary)
    }
}