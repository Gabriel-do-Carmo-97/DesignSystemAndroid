# 📱 Módulo `:templates` (Templates de Telas & Fábricas de Fluxos)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:templates-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/templates/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:templates`** orquestra e combina os componentes visuais do `:components` e os tokens do `:core` para formar fluxos completos de negócio, telas desacopladas e **Fábricas de Telas Universais**.

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

### Fábricas e Domínios Funcionais (75 Factories Prontas):
- **`WgcAuthFactory`**: Autenticação unificada suportando marcas e estilos (`Standard`, `CleanWave`, `SplitCard`, `Klok`, etc.).
- **`WgcHomeFactory`**: Telas iniciais (Home) multi-segmento com suporte a troca dinâmica de Menu, Header, Feed e BottomBar.
- **Fábricas de Segmentos Neutros:**
  - `WgcFoodDeliveryFactory` & `WgcBeverageDeliveryFactory` (Alimentação e bebidas)
  - `WgcMarketplaceFactory` (Varejo e e-commerce)
  - `WgcFintechFactory` & `WgcBankingFactory` (Serviços financeiros e banking)
  - `WgcAutomotiveFactory` (Veículos e concessionárias)
  - `WgcDentalFactory` & `WgcTelemedicineFactory` (Saúde e consultas)
  - `WgcHardwareFactory` (Eletrônicos e tecnologia)

---

## 🎨 Catálogo de Templates Prontos

O módulo possui 94 domínios de telas funcionais:

| Categoria / Domínio | Templates Principais | Descrição |
| :--- | :--- | :--- |
| **Figma Community** | `WgcWaveAuthScreenTemplate`, `WgcSplitCardAuthScreenTemplate`, `WgcKlokAuthScreenTemplate` | Templates modernos com ondas orgânicas, cards flutuantes, seletores pílula e biometria integrada. |
| **Food & Delivery** | `WgcFoodDeliveryHomeScreenTemplate`, `WgcBeverageDeliveryTemplates` | Feed com carrossel de restaurantes, busca de pratos, stories e carrinho de compras em tempo real. |
| **Marketplace & Varejo** | `WgcMarketplaceHomeScreenTemplate`, `StandardCartScreenTemplate`, `EcommerceHomeScreenTemplate` | Home com carrossel de ofertas, grid de produtos, frete grátis e cálculo de desconto. |
| **Fintech & Banking** | `FintechHomeScreenTemplate`, `WgcNubankHomeTemplate`, `WgcInterHomeTemplate` | Visão de saldo, extrato com seções, atalhos de transação, cartões físicos/virtuais e investimentos. |
| **Saúde & Especialistas** | `WgcDentalTemplates`, `WgcTelemedicineTemplates` | Agendamento de consultas, perfis de profissionais e procedimentos médicos. |
| **Automotivo & Hardware** | `WgcAutomotiveTemplates`, `WgcHardwareTemplates` | Ficha técnica de veículos, especificações de componentes e catálogo especializado. |
| **Geolocalização & Central**| `RealtimeLocationMapScreenTemplate`, `SettingsHubScreenTemplate`, `SearchAndFilterScreenTemplate` | Mapa em tempo real, central de configurações, busca avançada e múltiplos filtros. |

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
3. **Efeitos Unidirecionais (`UiEffectChannel`):** Suporte nativo a disparo de eventos únicos (Toasts, navegações, alertas de erro) via `UiEffectChannel`.

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
    implementation("br.com.wgc:templates:0.0.x")
    implementation("br.com.wgc:components:0.0.x")
    implementation("br.com.wgc:core:0.0.x")
}
```

> [!NOTE]
> O pacote Kotlin / Android namespace deste módulo é `br.com.wgc.ds_templates`.

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo utiliza o plugin corporativo `wgc.android.library` e `maven-publish`, publicando o artefato `templates-release.aar`.

### Deploy Local:
```bash
./gradlew :templates:publishToMavenLocal
```

### Deploy Remoto Manual:
```bash
./gradlew :templates:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O pipeline hipergranular do GitHub Actions detecta alterações em `templates/**` e publica automaticamente no GitHub Packages após o merge na branch `master`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc com todas as telas, ViewModels, estados e parâmetros de Factories está disponível em:

👉 **[Acessar Documentação de API do `:templates`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/templates/)**
