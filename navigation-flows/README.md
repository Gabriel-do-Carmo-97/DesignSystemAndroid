# 🧭 Módulo `:navigation-flows` (Grafos de Navegação Type-Safe)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:navigation--flows-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/navigation-flows/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:navigation-flows`** fornece grafos e hosts de navegação desacoplados, modulares e 100% type-safe construídos com o **Navigation Compose** moderno (rotas serializáveis via `@Serializable`).

---

## 🗺️ Catálogo de Grafos & Fluxos

| Grafo / Host | Descrição do Fluxo | Rotas Inclusas |
| :--- | :--- | :--- |
| **`WgcAuthNavGraph`** / **`WgcAuthNavHost`** | Fluxo completo de autenticação e onboarding de conta | `AuthRoute.Login`, `AuthRoute.Register`, `AuthRoute.ForgotPassword`, `AuthRoute.ResetPassword` |
| **`WgcCheckoutNavGraph`** / **`WgcCheckoutNavHost`** | Fluxo de pagamento e finalização de compras | `CheckoutRoute.Address`, `CheckoutRoute.PaymentMethod`, `CheckoutRoute.Confirmation` |
| **`WgcOnboardingNavGraph`** / **`WgcOnboardingNavHost`** | Apresentação inicial do aplicativo / tour interativo | `OnboardingRoute.Step(index)` |
| **`WgcSearchNavGraph`** / **`WgcSearchNavHost`** | Fluxo de busca, exploração de categorias e detalhes | `SearchRoute.Search`, `SearchRoute.ProductDetails(productId)` |
| **`WgcSettingsNavGraph`** / **`WgcSettingsNavHost`** | Hub de configurações, perfil, termos e logout dialog | `SettingsRoute.Hub`, `SettingsRoute.Terms`, `SettingsRoute.Profile`, `SettingsRoute.LogoutDialog` |

---

## 📐 Diretrizes de Arquitetura

1. **Rotas Type-Safe com `@Serializable`:**
   Nenhuma rota utiliza strings literais ou argumentos manuais via URL encoding. Toda rota é um `data object` ou `data class` serializável.
2. **Desacoplamento e Customização por Slots:**
   Cada tela dentro do grafo delega a interface para os templates do `:templates` ou aceita lambdas customizados (`onNavigateTo*`, `onFinish`, etc.).
3. **Hosts Prontos para Uso:**
   Além das funções de extensão `NavGraphBuilder.wgc*NavGraph(...)`, cada fluxo expõe um `@Composable fun Wgc*NavHost(...)` autocontido pronto para inclusão direta em telas ou abas de navegação.

---

## 📦 Como Consumir via Gradle

```kotlin
dependencies {
    implementation("br.com.wgc:navigation-flows:1.x.x")
    implementation("br.com.wgc:templates:1.x.x")
    implementation("br.com.wgc:components:1.x.x")
    implementation("br.com.wgc:core:1.x.x")
}
```
