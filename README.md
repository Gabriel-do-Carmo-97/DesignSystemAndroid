# 🎨 Design System WGC (Android)

[![Android CI/CD](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions/workflows/android.yml/badge.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compile SDK](https://img.shields.io/badge/compileSdk-37-brightgreen.svg)
![Kotlin](https://img.shields.io/badge/kotlin-2.2.20-purple.svg)
![Detekt](https://img.shields.io/badge/Detekt-Passing-success.svg)
![SemVer](https://img.shields.io/badge/SemVer-Conventional%20Commits-orange.svg)
[![Dokka Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/)

Um Design System moderno, modular e escalável construído em **Jetpack Compose** e **Material 3**, seguindo os princípios de **Atomic Design** e arquitetura limpa em Kotlin.

---

## 🏗️ Arquitetura e Módulos

O projeto é estritamente modularizado para garantir desacoplamento, reuso e independência entre as camadas:

```
┌───────────────────────────────────────────────────────────────┐
│                             :app                              │ (Catalog App / Storybook)
└───────┬───────────────────────┬───────────────────────┬───────┘
        │                       │                       │
        ▼                       ▼                       │
┌───────────────┐       ┌───────────────┐               │
│:navigation-   │──────►│  :templates   │               │
│    flows      │       └───────┬───────┘               │
└───────┬───────┘               │                       │
        │                       ▼                       │
        │               ┌───────────────┐               │
        └──────────────►│  :components  │◄──────────────┘
                        └───────┬───────┘
                                │
                                ▼
                        ┌───────────────┐
                        │     :core     │ (Design Tokens: Cores, Spacing, Radius, Motion)
                        └───────────────┘
```

- **[`:core`](./core/README.md)**: Camada fundamental contendo todos os **Tokens de Design** (cores primitivas e semânticas, espaçamentos, tamanhos, elevações, movimento e raios de borda). 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core/)
- **[`:components`](./components/README.md)**: Biblioteca de componentes atômicos e moleculares reutilizáveis em Jetpack Compose (`WgcButton`, `WgcSimpleTextField`, 90+ Cards funcionais neutralizados, feedback `WgcEmptyState`/`WgcErrorState`), totalmente acessíveis e com *Screenshot Tests*. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/components/)
- **[`:templates`](./templates/README.md)**: Biblioteca de telas completas, fluxos desacoplados e **75 Fábricas Universais** (`WgcAuthFactory`, `WgcHomeFactory`, `WgcFoodDeliveryFactory`, etc.) com arquitetura de Slots e `UiEffectChannel`. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/templates/)
- **[`:navigation-flows`](./navigation-flows/README.md)**: Grafos de navegação desacoplados (Auth, Onboarding, Checkout) com rotas Type-Safe (`@Serializable`) e extensões de `NavGraphBuilder`. 👉 [Docs no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/navigation-flows/)
- **[`:app`](./app/README.md)**: Aplicativo de Catálogo Interativo (*Storybook*) para visualizar e testar componentes, fluxos e estados em tempo de execução.

### Mapeamento de Módulos e Namespaces Kotlin

| Módulo Gradle | ArtifactId (GitHub Packages) | Namespace Android & Pacote Kotlin |
| :--- | :--- | :--- |
| `:core` | `br.com.wgc:core` | `br.com.wgc.core_ds` |
| `:components` | `br.com.wgc:components` | `br.com.wgc.design_system` |
| `:templates` | `br.com.wgc:templates` | `br.com.wgc.ds_templates` |
| `:navigation-flows` | `br.com.wgc:navigation-flows` | `br.com.wgc.ds_navigation_flows` |

---

## 🚀 Tecnologias e Ferramentas

- **UI Toolkit:** Jetpack Compose & Material 3
- **Linguagem:** Kotlin 2.2.20 (minSdk 29, compileSdk 37)
- **Arquitetura de Estado:** Coroutines, StateFlow, ViewModel, UiEffectChannel
- **Navegação:** Type-Safe Navigation Compose (Kotlinx Serialization)
- **Qualidade & CI/CD:** Detekt, Screenshot Tests nativos Android, SonarQube, Jacoco, Semantic PRs, Dependabot, Dokka.

---

## 🛠️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid.git
   ```
2. Abra o projeto no **Android Studio** (versão Ladybug ou superior).
3. Sincronize o projeto com o Gradle.
4. Execute o build ou rode os testes:
   ```bash
   ./gradlew assembleDebug
   ./gradlew test
   ```

---

## 📦 Como Consumir as Bibliotecas

As bibliotecas são publicadas automaticamente via GitHub Packages no pipeline de CI/CD.

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
        credentials {
            username = project.property("gpr.user") as String
            password = project.property("gpr.key") as String
        }
    }
}

dependencies {
    implementation("br.com.wgc:core:0.0.x")
    implementation("br.com.wgc:components:0.0.x")
    implementation("br.com.wgc:templates:0.0.x")
    implementation("br.com.wgc:navigation-flows:0.0.x")
}
```

---

## 🤖 Governança de Agentes & Documentação

- **Topologia de Agentes:** Consulte [`AGENTS.md`](./AGENTS.md) para diretrizes sobre o Orquestrador Central e os 8 agentes especialistas (9 no total).
- **Guia de Contribuição:** Consulte [`CONTRIBUTING.md`](./CONTRIBUTING.md) para padrões de Conventional Commits e validações locais.
- **Política de Segurança:** Consulte [`SECURITY.md`](./SECURITY.md) para procedimentos de divulgação responsável de vulnerabilidades.
- **Documentação de API (Dokka):** Consulte [`docs/DOKKA.md`](./docs/DOKKA.md) ou acesse o [Portal Dokka no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/).

---

## 📄 Licença
Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

