package br.com.wgc.design_system.performance

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.buttons.WgcButtonSize
import org.junit.Rule
import org.junit.Test

/**
 * Testes de performance para componentes Compose do Design System.
 * 
 * Esta classe verifica se os componentes não introduzem regressões de performance
 * através de testes de composição, layout e rendering.
 */
class ComposePerformanceTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testButtonComposePerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            WgcButton(
                text = "Test Button",
                onClick = {}
            )
        }
        
        val composeTime = System.nanoTime() - startTime
        // Componente deve compor em menos de 50ms
        assert(composeTime < 50_000_000) { "Button composition took too long: ${composeTime / 1_000_000}ms" }
    }

    @Test
    fun testButtonRecompositionPerformance() {
        var clickCount by mutableStateOf(0)
        val recompositionTimes = mutableListOf<Long>()
        
        composeRule.setContent {
            WgcButton(
                text = "Clicks: $clickCount",
                onClick = { clickCount++ }
            )
        }
        
        // Simula múltiplas recomposições
        repeat(20) {
            val startTime = System.nanoTime()
            clickCount++
            composeRule.waitForIdle()
            recompositionTimes.add(System.nanoTime() - startTime)
        }
        
        // Verifica se o tempo médio de recomposição é aceitável
        val avgRecompositionTime = recompositionTimes.average()
        assert(avgRecompositionTime < 10_000_000) { 
            "Average recomposition took too long: ${avgRecompositionTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testMultipleButtonsPerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            Column {
                repeat(50) { index ->
                    WgcButton(
                        text = "Button $index",
                        onClick = {}
                    )
                }
            }
        }
        
        val composeTime = System.nanoTime() - startTime
        // 50 botões devem compor em menos de 100ms
        assert(composeTime < 100_000_000) { 
            "Multiple buttons composition took too long: ${composeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonStateChangePerformance() {
        var isLoading by mutableStateOf(false)
        
        composeRule.setContent {
            WgcButton(
                text = "Loading Button",
                isLoading = isLoading,
                onClick = { isLoading = !isLoading }
            )
        }
        
        // Testa performance de mudança de estado
        val stateChangeTimes = mutableListOf<Long>()
        repeat(10) {
            val startTime = System.nanoTime()
            isLoading = !isLoading
            composeRule.waitForIdle()
            stateChangeTimes.add(System.nanoTime() - startTime)
        }
        
        val avgStateChangeTime = stateChangeTimes.average()
        assert(avgStateChangeTime < 15_000_000) { 
            "Average state change took too long: ${avgStateChangeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonVariantsPerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            Column {
                WgcButton(
                    text = "Primary",
                    variant = WgcButtonVariant.Primary,
                    onClick = {}
                )
                WgcButton(
                    text = "Secondary",
                    variant = WgcButtonVariant.Secondary,
                    onClick = {}
                )
                WgcButton(
                    text = "Outlined",
                    variant = WgcButtonVariant.Outlined,
                    onClick = {}
                )
                WgcButton(
                    text = "Ghost",
                    variant = WgcButtonVariant.Ghost,
                    onClick = {}
                )
                WgcButton(
                    text = "Danger",
                    variant = WgcButtonVariant.Danger,
                    onClick = {}
                )
            }
        }
        
        val composeTime = System.nanoTime() - startTime
        assert(composeTime < 30_000_000) { 
            "Button variants composition took too long: ${composeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonSizesPerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            Column {
                WgcButton(
                    text = "Small",
                    size = WgcButtonSize.Small,
                    onClick = {}
                )
                WgcButton(
                    text = "Medium",
                    size = WgcButtonSize.Medium,
                    onClick = {}
                )
                WgcButton(
                    text = "Large",
                    size = WgcButtonSize.Large,
                    onClick = {}
                )
            }
        }
        
        val composeTime = System.nanoTime() - startTime
        assert(composeTime < 20_000_000) { 
            "Button sizes composition took too long: ${composeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonWithIconsPerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            WgcButton(
                text = "Icon Button",
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        androidx.compose.material.icons.Icons.Default.Check,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    androidx.compose.material3.Icon(
                        androidx.compose.material.icons.Icons.Default.Close,
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        }
        
        val composeTime = System.nanoTime() - startTime
        assert(composeTime < 25_000_000) { 
            "Button with icons composition took too long: ${composeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testComplexButtonScenarioPerformance() {
        val startTime = System.nanoTime()
        
        composeRule.setContent {
            androidx.compose.material3.MaterialTheme {
                androidx.compose.material3.Surface {
                    androidx.compose.foundation.layout.Box(
                        modifier = androidx.compose.ui.Modifier.fillMaxSize()
                    ) {
                        Column {
                            repeat(20) { index ->
                                WgcButton(
                                    text = "Button $index",
                                    variant = WgcButtonVariant.values()[index % 5],
                                    size = WgcButtonSize.values()[index % 3],
                                    onClick = {}
                                )
                            }
                        }
                    }
                }
            }
        }
        
        val composeTime = System.nanoTime() - startTime
        assert(composeTime < 80_000_000) { 
            "Complex button scenario composition took too long: ${composeTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonRenderingPerformance() {
        var clickCount by mutableStateOf(0)
        
        composeRule.setContent {
            WgcButton(
                text = "Clicks: $clickCount",
                onClick = { clickCount++ }
            )
        }
        
        // Testa performance de rendering após interação
        val renderingTimes = mutableListOf<Long>()
        repeat(15) {
            val startTime = System.nanoTime()
            composeRule.onNodeWithText("Clicks: $clickCount").performClick()
            composeRule.waitForIdle()
            renderingTimes.add(System.nanoTime() - startTime)
        }
        
        val avgRenderingTime = renderingTimes.average()
        assert(avgRenderingTime < 20_000_000) { 
            "Average rendering time took too long: ${avgRenderingTime / 1_000_000}ms" 
        }
    }

    @Test
    fun testButtonMemoryEfficiency() {
        val runtime = Runtime.getRuntime()
        val initialMemory = runtime.totalMemory() - runtime.freeMemory()
        
        composeRule.setContent {
            Column {
                repeat(100) { index ->
                    WgcButton(
                        text = "Button $index",
                        onClick = {}
                    )
                }
            }
        }
        
        composeRule.waitForIdle()
        System.gc()
        Thread.sleep(100)
        
        val finalMemory = runtime.totalMemory() - runtime.freeMemory()
        val memoryIncrease = finalMemory - initialMemory
        
        // 100 botões não devem consumir mais de 50MB
        assert(memoryIncrease < 50 * 1024 * 1024) { 
            "Memory usage too high: ${memoryIncrease / (1024 * 1024)}MB" 
        }
    }
}