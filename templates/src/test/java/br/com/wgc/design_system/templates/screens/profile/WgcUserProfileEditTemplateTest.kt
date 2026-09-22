package br.com.wgc.design_system.templates.screens.profile

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class WgcUserProfileEditTemplateTest {

    private lateinit var viewModel: FakeUserProfileEditViewModel

    @Before
    fun setup() {
        viewModel = FakeUserProfileEditViewModel()
    }

    @Test
    fun nameValidation_flagsBlankName() {
        viewModel.onNameChange("")
        assertNotNull(viewModel.uiState.value.nameError)

        viewModel.onNameChange("Gabriel Silva")
        assertNull(viewModel.uiState.value.nameError)
    }

    @Test
    fun emailValidation_flagsInvalidEmail() {
        viewModel.onEmailChange("invalid-email")
        assertNotNull(viewModel.uiState.value.emailError)

        viewModel.onEmailChange("valid@wgc.com.br")
        assertNull(viewModel.uiState.value.emailError)
    }

    @Test
    fun onSaveClick_setsSuccessMessage() {
        viewModel.onSaveClick()
        assertEquals("Perfil atualizado com sucesso!", viewModel.uiState.value.successMessage)
    }
}
