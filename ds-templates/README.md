# 📱 Módulo `:ds-templates` (Templates de Telas & Fluxos)

O módulo `:ds-templates` combina os componentes do `:design-system` para formar telas completas e fluxos prontos para uso.

## 📂 Estrutura por Feature:
```
screens/[feature]/
  screen/    → ScreenTemplate.kt (stateless + stateful)
  state/     → ScreenUiState.kt
  viewmodel/ → BaseViewModel.kt + FakeViewModel.kt
```

## 📐 Diretrizes de Arquitetura:
- **Separation of Concerns**: Cada tela possui uma versão stateful (que coleta o `StateFlow` da ViewModel) e uma versão stateless (que recebe o `UiState` e callbacks puros, ideal para Previews).
- **Zero Lógica de Navegação/API Concreta**: Os templates recebem apenas lambdas de callback (`onLoginClick`, etc.).
