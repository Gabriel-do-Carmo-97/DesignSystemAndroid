package br.com.wgc.design_system.components.fields

import androidx.compose.ui.text.AnnotatedString
import br.com.wgc.design_system.components.fields.transformations.CepVisualTransformation
import br.com.wgc.design_system.components.fields.transformations.CpfVisualTransformation
import br.com.wgc.design_system.components.fields.transformations.PhoneVisualTransformation
import br.com.wgc.design_system.components.fields.transformations.WgcVisualTransformations
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class VisualTransformationsTest {

    @Test
    fun factory_shouldCreateTransformations() {
        assertNotNull(WgcVisualTransformations.cpf())
        assertNotNull(WgcVisualTransformations.cep())
        assertNotNull(WgcVisualTransformations.phone())
    }

    @Test
    fun cpfVisualTransformation_shouldFormatTextAndMapOffsets() {
        val transformation = CpfVisualTransformation()

        val transformed = transformation.filter(AnnotatedString("12345678901"))
        assertEquals("123.456.789-01", transformed.text.text)

        val offsetMapping = transformed.offsetMapping
        assertEquals(0, offsetMapping.originalToTransformed(0))
        assertEquals(3, offsetMapping.originalToTransformed(3))
        assertEquals(5, offsetMapping.originalToTransformed(4))
        assertEquals(14, offsetMapping.originalToTransformed(11))

        assertEquals(0, offsetMapping.transformedToOriginal(0))
        assertEquals(4, offsetMapping.transformedToOriginal(5))
        assertEquals(11, offsetMapping.transformedToOriginal(14))
    }

    @Test
    fun cepVisualTransformation_shouldFormatTextAndMapOffsets() {
        val transformation = CepVisualTransformation()

        val transformed = transformation.filter(AnnotatedString("01001000"))
        assertEquals("01001-000", transformed.text.text)

        val offsetMapping = transformed.offsetMapping
        assertEquals(0, offsetMapping.originalToTransformed(0))
        assertEquals(5, offsetMapping.originalToTransformed(5))
        assertEquals(7, offsetMapping.originalToTransformed(6))
        assertEquals(9, offsetMapping.originalToTransformed(8))

        assertEquals(0, offsetMapping.transformedToOriginal(0))
        assertEquals(5, offsetMapping.transformedToOriginal(5))
        assertEquals(6, offsetMapping.transformedToOriginal(7))
    }

    @Test
    fun phoneVisualTransformation_shouldFormatMobileAndFixedNumbers() {
        val transformation = PhoneVisualTransformation()

        val mobileTransformed = transformation.filter(AnnotatedString("11987654321"))
        assertEquals("(11) 98765-4321", mobileTransformed.text.text)

        val fixedTransformed = transformation.filter(AnnotatedString("1133224455"))
        assertEquals("(11) 3322-4455", fixedTransformed.text.text)
    }
}
