# 📱 Módulo `:ds-templates` (Templates de Telas & Fábricas de Fluxos)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:ds--templates-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/ds-templates/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:ds-templates`** orquestra e combina os componentes visuais do `:design-system` e os tokens do `:core-ds` para formar fluxos completos de negócio, telas desacopladas e **Fábricas de Telas Universais**.

---

## 🏛️ Arquitetura de Factories Universais & Slots

Todo template corporativo é exposto através de uma Factory unificada com **Sensible Defaults** (valores padrão corporativos que funcionam com zero configuração adicional) e suporte completo a injeção granular de **Slots**:

```kotlin
// Invocação imediata com padrões corporativos
WgcAuthFactory(brand = WgcBrand.Klok)

// Invocação customizada substituindo partes específicas via Slots
WgcAuthFactory(
    brand = WgcBrand.CleanWave,
    headerSlot = { MeuLogoCustomizado() },
    actionSlot = { MeuBotaoEspecial() }
)
```

### Fábricas Disponíveis:
- **`WgcAuthFactory`**: Autenticação unificada suportando marcas e estilos (`Standard`, `CleanWave`, `SplitCard`, `Klok`, etc.).
- **`WgcHomeFactory`**: Telas iniciais (Home) multi-segmento com suporte a troca dinâmica de Menu, Header, Feed e BottomBar.

---

## 🎨 Catálogo de Templates Prontos

| Categoria / Origem | Template / Screen | Descrição |
| :--- | :--- | :--- |
| **Figma Community (Novos)** | `WgcWaveAuthScreenTemplate` | Template limpo com onda azul inferior decorativa e autenticação biométrica por digital. |
| **Figma Community (Novos)** | `WgcSplitCardAuthScreenTemplate` | Card superior elevado, login limpo, botões lado a lado e biometria em card arredondado. |
| **Figma Community (Novos)** | `WgcKlokAuthScreenTemplate` | Switch estilo pílula dupla (Login / Register), inputs pill e botão de biometria dourado. |
| **E-Commerce & Food** | `EcommerceHomeScreenTemplate`, `IFoodHomeScreenTemplate`, `StandardCartScreenTemplate` | Home com carrossel de banners, grid de produtos, stories e carrinho de compras completo. |
| **Fintech & Banking** | `FintechHomeScreenTemplate` | Visão de saldo, extrato com seções, atalhos PIX e transferências. |
| **Geolocalização & Hubs** | `RealtimeLocationMapScreenTemplate`, `SettingsHubScreenTemplate`, `SearchAndFilterScreenTemplate` | Mapa em tempo real, central de configurações e busca com filtros. |

---

## 📐 Estrutura Padrão por Feature

```
screens/[feature]/
  screen/    → WgcScreenTemplate.kt (Versão Stateful + Versão Stateless)
  state/     → ScreenUiState.kt (Imutável com dados e estados de Loading/Erro)
  viewmodel/ → BaseViewModel.kt + FakeViewModel.kt (Para previews e testes)
```

1. **Separação Stateless vs Stateful:** Cada tela possui uma função que observa a ViewModel e outra pura que recebe apenas o `UiState` e callbacks lambdas.
2. **Zero Dependência de Navegação Concreta:** O template nunca chama diretamente `NavController.navigate()`; ele emite eventos via lambdas (`onNavigateBack`, `onConfirmClick`).

---

## 📦 Como Consumir via Gradle

### 1. Configurar Repositório (`settings.gradle.kts` ou `build.gradle.kts`)
```kotlin
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as? String ?: ""
                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.key") as? String ?: ""
            }
        }
    }
}
```

### 2. Adicionar Dependência (`build.gradle.kts`)
```kotlin
dependencies {
    implementation("br.com.wgc:ds-templates:0.0.x")
    implementation("br.com.wgc:design-system:0.0.x")
    implementation("br.com.wgc:core-ds:0.0.x")
}
```

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo utiliza o plugin `maven-publish` e publica o artefato `ds-templates-release.aar`.

### Deploy Local:
```bash
./gradlew :ds-templates:publishToMavenLocal
```

### Deploy Remoto Manual:
```bash
./gradlew :ds-templates:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O pipeline hipergranular do GitHub Actions detecta alterações em `ds-templates/**` e publica automaticamente no GitHub Packages após o merge na branch `master`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc com todas as telas, ViewModels, estados e parâmetros de Factories está disponível em:

👉 **[Acessar Documentação de API do `:ds-templates`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/ds-templates/)**
