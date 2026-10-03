package br.com.wgc.design_system.components.fields.transformations

import androidx.compose.ui.text.AnnotatedString
import org.junit.Assert.assertEquals
import org.junit.Test

class CnpjVisualTransformationTest {

    private val transformation = CnpjVisualTransformation()

    @Test
    fun `filter should transform 14 digits into CNPJ format`() {
        val input = AnnotatedString("12345678000195")
        val result = transformation.filter(input)

        assertEquals("12.345.678/0001-95", result.text.text)
    }

    @Test
    fun `filter should handle partial input gracefully`() {
        val input = AnnotatedString("1234")
        val result = transformation.filter(input)

        assertEquals("12.34", result.text.text)
    }

    @Test
    fun `offsetMapping should correctly map bidirectional cursor positions`() {
        val input = AnnotatedString("12345678000195")
        val result = transformation.filter(input)
        val mapping = result.offsetMapping

        // Original offset 0 -> Transformed 0
        assertEquals(0, mapping.originalToTransformed(0))
        assertEquals(0, mapping.transformedToOriginal(0))

        // Original offset 2 ("12|") -> Transformed 2
        assertEquals(2, mapping.originalToTransformed(2))

        // Original offset 5 ("12345|") -> Transformed 6 ("12.345|")
        assertEquals(6, mapping.originalToTransformed(5))

        // Original offset 14 (end) -> Transformed 18 ("12.345.678/0001-95|")
        assertEquals(18, mapping.originalToTransformed(14))
        assertEquals(14, mapping.transformedToOriginal(18))
    }

    @Test
    fun `factory method in WgcVisualTransformations should return CnpjVisualTransformation`() {
        val factoryTransformation = WgcVisualTransformations.cnpj()
        val result = factoryTransformation.filter(AnnotatedString("12345678000195"))
        assertEquals("12.345.678/0001-95", result.text.text)
    }
}
