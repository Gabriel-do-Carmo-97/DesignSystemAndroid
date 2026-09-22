# 🎨 Design System WGC (Android)

[![Android CI/CD](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions/workflows/android.yml/badge.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions)
![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compile SDK](https://img.shields.io/badge/compileSdk-37-brightgreen.svg)
![Kotlin](https://img.shields.io/badge/kotlin-2.2.20-purple.svg)
![Detekt](https://img.shields.io/badge/Detekt-Strict-success.svg)
![SemVer](https://img.shields.io/badge/SemVer-Conventional%20Commits-orange.svg)
[![Dokka Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/)

Design System enterprise, desacoplado e 100% white-label construído em **Jetpack Compose** e **Material 3**, seguindo os princípios de **Atomic Design**, **State Hoisting** e arquitetura limpa em Kotlin.

---

## 🏗️ Arquitetura e Módulos

O monorepo é dividido em 4 bibliotecas desacopladas + app de catálogo interativo:

```text
┌─────────────────────────────────────────────────────────┐
│                          :app                           │  (Catálogo Interativo / Storybook)
└───────────┬─────────────────────────┬───────────────────┘
            │                         │
            ▼                         ▼
┌───────────────────────┐ ┌───────────────────────┐
│   :navigation-flows   │ │      :templates       │  (Grafos de Navegação e Telas Prontas)
└───────────┬───────────┘ └───────────┬───────────┘
            │                         │
            ▼                         ▼
┌─────────────────────────────────────────────────────────┐
│                       :components                       │  (Átomos e Moléculas Compose)
└───────────────────────────┬─────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────┐
│                          :core                          │  (Tokens: Cores, Spacing, Radius, Tipografia)
└─────────────────────────────────────────────────────────┘
```

- **[`:core`](./core/README.md)**: Camada fundamental agnóstica a Compose UI contendo todos os **Tokens de Design** primitivos e semânticos (Cores, Espaçamento, Raio de Borda, Tipografia, Opacidade, Breakpoints e Curvas de Motion/Easing). 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core/)
- **[`:components`](./components/README.md)**: Biblioteca de componentes atômicos e moleculares reutilizáveis em Jetpack Compose (`WgcButton`, `WgcColorPicker`, `WgcTag`, `WgcBadge`, `WgcSnackbar`, `WgcDatePicker`, `WgcTimePicker`, `WgcNavigationDrawer`, `WgcTabs`, `WgcOtpInput`, `WgcTimeline`, `WgcRatingBar`, `WgcStandardBottomSheet`, `WgcSkeleton`, etc.), totalmente acessíveis, stateless e com suporte a *Screenshot Tests* via AGP. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/components/)
- **[`:templates`](./templates/README.md)**: Telas completas desacopladas, fluxos e **Fábricas Universais** (`WgcAuthFactory`, `WgcHomeFactory`, `WgcCheckoutFactory`, `WgcOnboardingFactory`, `WgcCartFactory`, `WgcSearchFactory`, `WgcSettingsHubFactory`, `WgcNotificationCenterTemplate`, `WgcUserProfileEditTemplate`, `WgcHelpCenterSupportTemplate`, `WgcTransactionReceiptTemplate`, `WgcKycLivenessVerificationTemplate`) baseados em `UiState` + `BaseViewModel` + slots customizáveis. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/templates/)
- **[`:navigation-flows`](./navigation-flows/README.md)**: Grafos de navegação prontos e type-safe (`WgcAuthNavGraph`, `WgcCheckoutNavGraph`, `WgcOnboardingNavGraph`, `WgcSearchNavGraph`, `WgcSettingsNavGraph`, `WgcNotificationsNavGraph`, `WgcProfileNavGraph`) encapsulando fluxos multi-telas de ponta a ponta. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/navigation-flows/)
- **[`:app`](./app/README.md)**: Aplicativo de demonstração e validação para testar componentes, temas e estados em tempo de execução.

---

## 🚀 Tecnologias e Padrões

- **UI Toolkit:** Jetpack Compose (BOM 2025.09.01) & Material 3
- **Linguagem:** Kotlin 2.2.20
- **Android SDK:** `compileSdk = 37`, `minSdk = 29`
- **Arquitetura de Estado:** Coroutines, StateFlow, BaseViewModel + FakeViewModel
- **Qualidade & CI/CD:** Detekt Estrito (`ignoreFailures = false`), Binary Compatibility Validator (`apiCheck`), Unit Tests, SonarQube, Dokka e GitHub Actions com princípio de menor privilégio (`contents: read`).

---

## 🛠️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid.git
   ```
2. Abra o projeto no **Android Studio**.
3. Sincronize o projeto com o Gradle.
4. Execute o build, linters e testes:
   ```bash
   ./gradlew assembleDebug
   ./gradlew testDebugUnitTest
   ./gradlew detekt
   ```

---

## 📦 Como Consumir as Bibliotecas

As bibliotecas são publicadas automaticamente no **GitHub Packages** no pipeline de release com suporte a sources e javadoc:

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
            credentials {
                username = providers.environmentVariable("GPR_USER").getOrElse("")
                password = providers.environmentVariable("GPR_KEY").getOrElse("")
            }
        }
    }
}
```

```kotlin
// build.gradle.kts do seu app consumidor
dependencies {
    implementation("br.com.wgc:core:1.x.x")
    implementation("br.com.wgc:components:1.x.x")
    implementation("br.com.wgc:templates:1.x.x")
    implementation("br.com.wgc:navigation-flows:1.x.x")
}
```

---

## 🤖 Governança & Documentação

- **Changelog:** Consulte [`CHANGELOG.md`](./CHANGELOG.md) para o histórico de versões e notas de atualização.
- **Topologia de Agentes:** Consulte [`AGENTS.md`](./AGENTS.md) para diretrizes da equipe de agentes especialistas.
- **Política de RFC para Novas Telas:** Consulte [`docs/RFC_GOVERNANCE.md`](./docs/RFC_GOVERNANCE.md) para os critérios de submissão de novos componentes.
- **Código & Donos:** Consulte [`.github/CODEOWNERS`](./.github/CODEOWNERS).
- **Política de Segurança:** Consulte [`SECURITY.md`](./SECURITY.md) para reporte responsável de vulnerabilidades.
- **Portal de API (Dokka):** Acesse o [Portal Dokka no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/).

---

## 📄 Licença
Distribuído sob a licença Apache 2.0. Veja `LICENSE` para mais informações.
