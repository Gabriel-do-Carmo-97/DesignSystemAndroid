# 🎨 Design System WGC (Android)

[![Android CI/CD](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions/workflows/android.yml/badge.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/actions)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Min SDK](https://img.shields.io/badge/minSdk-24-green.svg)
![Compile SDK](https://img.shields.io/badge/compileSdk-36-brightgreen.svg)
![Kotlin](https://img.shields.io/badge/kotlin-2.2.0-purple.svg)
![Detekt](https://img.shields.io/badge/Detekt-Passing-success.svg)
![SemVer](https://img.shields.io/badge/SemVer-Conventional%20Commits-orange.svg)
[![Dokka Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/)

Um Design System moderno, modular e escalável construído em **Jetpack Compose** e **Material 3**, seguindo os princípios de **Atomic Design** e arquitetura limpa em Kotlin.

---

## 🏗️ Arquitetura e Módulos

O projeto é estritamente modularizado para garantir desacoplamento, reuso e independência entre as camadas:

```
┌───────────────────────────────────────────────┐
│                     :app                      │  (Catalog App / Sandbox)
└───────┬───────────────────────────────┬───────┘
        │                               │
        ▼                               ▼
┌───────────────┐               ┌───────────────┐
│ :design-system│◄──────────────┤  :ds-templates│  (Átomos, Moléculas e Telas)
└───────────────┘               └───────────────┘
        │
        ▼
┌───────────────┐
│    :core-ds   │  (Tokens Fundamentais: Cores, Spacing, Radius)
└───────────────┘
```

- **`:core-ds`**: Camada fundamental contendo todos os **Tokens de Design** (cores primitivas e semânticas, espaçamentos, tamanhos e raios de borda).
- **`:design-system`**: Biblioteca de componentes atômicos e moleculares reutilizáveis em Jetpack Compose (`ClassicButton`, `SimpleTextField`, `CheckBoxDefault`, etc.), totalmente acessíveis e com suporte a *Screenshot Tests*.
- **`:ds-templates`**: Biblioteca de templates de telas e fluxos completos (Login, Cadastros, Recuperação de Senha) seguindo o padrão `UiState` + `BaseViewModel` + `FakeViewModel`.
- **`:app`**: Aplicativo de Catálogo Interativo (*Storybook*) para visualizar e testar componentes e estados em tempo de execução.

---

## 🚀 Tecnologias e Ferramentas

- **UI Toolkit:** Jetpack Compose & Material 3
- **Linguagem:** Kotlin 2.2+
- **Arquitetura de Estado:** Coroutines, StateFlow, ViewModel
- **Qualidade & CI/CD:** Detekt (Static Analysis), Screenshot Tests, SonarQube, Jacoco, Semantic Pull Request Validation, Dependabot, Dokka.

---

## 🛠️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid.git
   ```
2. Abra o projeto no **Android Studio** (versão Hedgehog ou superior).
3. Sincronize o projeto com o Gradle.
4. Execute o build ou rode os testes:
   ```bash
   ./gradlew assembleDebug
   ./gradlew check
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
    implementation("br.com.wgc:design-system:0.0.x")
    implementation("br.com.wgc:ds-templates:0.0.x")
    implementation("br.com.wgc:core-ds:0.0.x")
}
```

---

## 🤖 Governança de Agentes & Documentação

- **Topologia de Agentes:** Consulte [`AGENTS.md`](./AGENTS.md) para diretrizes sobre o Orquestrador Central e os 7 agentes especialistas.
- **Guia de Contribuição:** Consulte [`CONTRIBUTING.md`](./CONTRIBUTING.md) para padrões de Conventional Commits e validações locais.
- **Política de Segurança:** Consulte [`SECURITY.md`](./SECURITY.md) para procedimentos de divulgação responsável de vulnerabilidades.
- **Documentação de API (Dokka):** Consulte [`docs/DOKKA.md`](./docs/DOKKA.md) ou acesse o [Portal Dokka no GitHub Pages](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/).

---

## 📄 Licença
Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

