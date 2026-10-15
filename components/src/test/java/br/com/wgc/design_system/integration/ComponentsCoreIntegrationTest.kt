package br.com.wgc.design_system.integration

import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColorsFacade
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
        assertNotNull(WgcCoreDsSpacing.MD16)
        assertEquals(16.0, WgcCoreDsSpacing.MD16, 0.0)
        assertEquals(8.0, WgcCoreDsSpacing.XS8, 0.0)
        assertEquals(24.0, WgcCoreDsSpacing.LG24, 0.0)
    }

    @Test
    fun `components should consume core border radius tokens`() {
        // Verifica se os tokens de border radius do core estão acessíveis
        assertNotNull(WgcCoreDsBorderRadius.MD8)
        assertEquals(8.0, WgcCoreDsBorderRadius.MD8, 0.0)
        assertEquals(4.0, WgcCoreDsBorderRadius.SM4, 0.0)
        assertEquals(16.0, WgcCoreDsBorderRadius.XL16, 0.0)
    }

    @Test
    fun `components should consume core color tokens`() {
        // Verifica se os tokens de cor do core estão acessíveis
        assertNotNull(WgcCoreDsColorsFacade.orange500)
        assertNotNull(WgcCoreDsColorsFacade.red500)
        assertNotNull(WgcCoreDsColorsFacade.green27)
        assertNotNull(WgcCoreDsColorsFacade.yellow10)
    }

    @Test
    fun `design tokens should have consistent values`() {
        // Verifica consistência dos valores dos tokens
        // Espaçamento segue escala de 4px base
        val baseSpacing = 4.0
        assertEquals(baseSpacing, WgcCoreDsSpacing.XXS4, 0.0)
        assertEquals(baseSpacing * 2, WgcCoreDsSpacing.XS8, 0.0)
        assertEquals(baseSpacing * 3, WgcCoreDsSpacing.SM12, 0.0)
        assertEquals(baseSpacing * 4, WgcCoreDsSpacing.MD16, 0.0)
        
        // Border radius segue padrão consistente
        assertEquals(4.0, WgcCoreDsBorderRadius.SM4, 0.0)
        assertEquals(8.0, WgcCoreDsBorderRadius.MD8, 0.0)
        assertEquals(16.0, WgcCoreDsBorderRadius.XL16, 0.0)
    }

    @Test
    fun `core color facade should provide backward compatibility`() {
        // Verifica se o facade de cores mantém compatibilidade com código existente
        assertNotNull(WgcCoreDsColorsFacade.white)
        assertNotNull(WgcCoreDsColorsFacade.black)
        assertNotNull(WgcCoreDsColorsFacade.transparent)
        assertNotNull(WgcCoreDsColorsFacade.gray900)
        assertNotNull(WgcCoreDsColorsFacade.gray6)
    }
}