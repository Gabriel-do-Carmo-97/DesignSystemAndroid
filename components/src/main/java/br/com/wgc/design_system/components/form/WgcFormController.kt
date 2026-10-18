package br.com.wgc.design_system.components.form

/**
 * Validador de campo individual.
 */
fun interface WgcFieldValidator<T> {
    fun validate(value: T): String?
}

/**
 * Controlador de formulários reativos corporativo (WgcFormController).
 */
class WgcFormController {

    private val validators = mutableMapOf<String, WgcFieldValidator<*>>()

    fun <T> registerField(name: String, validator: WgcFieldValidator<T>) {
        validators[name] = validator
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> validateField(name: String, value: T): String? {
        val validator = validators[name] as? WgcFieldValidator<T>
        return validator?.validate(value)
    }

    companion object {
        val RequiredValidator = WgcFieldValidator<String> { value ->
            if (value.isBlank()) "Este campo é obrigatório" else null
        }

        val EmailValidator = WgcFieldValidator<String> { value ->
            if (value.isBlank()) {
                "E-mail obrigatório"
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                "E-mail inválido"
            } else {
                null
            }
        }
    }
}
