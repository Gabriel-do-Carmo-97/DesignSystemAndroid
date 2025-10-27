package br.com.wgc.ds_templates.screens.register.car.state

import kotlinx.serialization.Serializable

/**
 * Representa o estado da UI para a tela de cadastro de um novo veículo.
 * A tela é genérica e se adapta para coletar informações extras se o veículo for um Food Truck.
 *
 * @property brand Marca do veículo (ex: "Volkswagen", "Ford").
 * @property brandError Mensagem de erro para a marca.
 *
 * @property model Modelo do veículo (ex: "Kombi", "Transit").
 * @property modelError Mensagem de erro para o modelo.
 *
 * @property year Ano de fabricação do veículo.
 * @property yearError Mensagem de erro para o ano.
 *
 * @property licensePlate Placa do veículo, usada como identificador único.
 * @property licensePlateError Mensagem de erro para a placa.
 *
 * @property ownerName Nome do proprietário do veículo.
 * @property ownerNameError Mensagem de erro para o nome do proprietário.
 *
 * @property email E-mail de contato e login do proprietário.
 * @property emailError Mensagem de erro para o e-mail.
 *
 * @property password Senha de acesso para a conta do proprietário.
 * @property passwordError Mensagem de erro para a senha.
 *
 * @property isFoodTruck Flag que indica se o veículo é um Food Truck. Controla a visibilidade e validação de campos adicionais.
 *
 * @property vehicleName Nome do negócio/fantasia, aplicável apenas se [isFoodTruck] for true.
 * @property vehicleNameError Mensagem de erro para o nome do negócio.
 *
 * @property foodCategory Categoria da comida, aplicável apenas se [isFoodTruck] for true.
 * @property foodCategoryError Mensagem de erro para a categoria da comida.
 *
 * @property isLoading Controla a exibição de indicadores de progresso durante operações de rede.
 */

@Serializable
data class RegisterCarScreenUiState(
    // --- Dados do Veículo (Genérico) ---
    val brand: String = "",
    val brandError: String? = null,

    val model: String = "",
    val modelError: String? = null,

    val year: String = "",
    val yearError: String? = null,

    val licensePlate: String = "",
    val licensePlateError: String? = null,

    // --- Dados do Proprietário ---
    val ownerName: String = "",
    val ownerNameError: String? = null,

    // --- Dados de Login ---
    val email: String = "",
    val emailError: String? = null,

    val password: String = "",
    val passwordError: String? = null,

    // --- Controle de UI e Lógica Condicional ---
    val isFoodTruck: Boolean = false,
    val isLoading: Boolean = false,

    // --- Dados Específicos de Food Truck ---
    val vehicleName: String = "", // Nome do Negócio
    val vehicleNameError: String? = null,

    val foodCategory: String = "",
    val foodCategoryError: String? = null
) {
    /**
     * Determina se o botão de registro deve estar habilitado.
     * Valida os campos de veículo e proprietário sempre.
     * Valida os campos de Food Truck (nome do negócio e categoria) apenas se a flag [isFoodTruck] for verdadeira.
     */
    val isRegisterButtonEnabled: Boolean
        get() {
            val isBaseValid = brand.isNotBlank() && brandError == null &&
                    model.isNotBlank() && modelError == null &&
                    year.isNotBlank() && yearError == null &&
                    licensePlate.isNotBlank() && licensePlateError == null &&
                    ownerName.isNotBlank() && ownerNameError == null &&
                    email.isNotBlank() && emailError == null &&
                    password.isNotBlank() && passwordError == null

            val isFoodTruckDataValid = if (isFoodTruck) {
                vehicleName.isNotBlank() && vehicleNameError == null &&
                        foodCategory.isNotBlank() && foodCategoryError == null
            } else true
            return !isLoading && isBaseValid && isFoodTruckDataValid
        }
}
