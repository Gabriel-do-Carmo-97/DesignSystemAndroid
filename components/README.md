# 🧩 Módulo `:components` (Componentes Visuais Atômicos & Moleculares)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:components-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/components/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:components`** contém todos os componentes de interface de usuário (UI) atômicos e moleculares da organização WGC construídos em **Jetpack Compose** e **Material 3**.

---

## 🧱 Catálogo de Componentes

O módulo é estruturado em 25 categorias modulares com suporte a acessibilidade, feedback háptico e testes visuais:

| Categoria | Componentes Principais | Destaques & Capacidades |
| :--- | :--- | :--- |
| **Botões de Ação** | `WgcButton`, `WgcClassicButton`, `WgcSecondaryClassicButton`, `WgcFAButton`, `WgcIconButton`, `WgcSegmentedButton` | Estados Habilitado, Desabilitado e Loading (`CircularProgressIndicator`), alvo de toque mínimo de 48dp. |
| **Autenticação & Social** | `WgcBiometricButton`, `WgcSocialLoginPillButton`, `WgcSocialLoginPillGroup`, `WgcBrandAuthHeader` | Biometria (`Circular`, `RoundedSquare`, `OutlinedSquare`), botões sociais padrão (Google, Apple, Facebook). |
| **Alternadores & Switches**| `WgcPillTabSwitch`, `WgcSegmentedControl`, `WgcSwitch`, `WgcSlider` | Alternador deslizante tipo pílula para Login/Cadastro, switches táteis e sliders. |
| **Campos de Texto (Inputs)**| `WgcFieldFactory`, `WgcSimpleTextField`, `WgcSearchTextField`, `WgcPasswordTextField`, `WgcOtpInput` | Leading/Trailing icons, estados de erro, máscara de senha, foco, OTP e **Transformações Visuais** (`CpfVisualTransformation`, `CepVisualTransformation`, `PhoneVisualTransformation`). |
| **Seleção & Seletores** | `WgcCheckBoxDefault`, `WgcRadioButtonDefault`, `WgcSwitchDefault`, `WgcFilterChip`, `WgcChip` | Suporte a estados desabilitados, feedback háptico e `SemanticsProperties`. |
| **Cards de Domínio (90+)** | `WgcCardFactory`, `WgcAutomotiveVehicleCard`, `WgcChilledBeverageCard`, `WgcDentalProcedureCard`, `WgcFinancialBalanceCard`, `WgcTechnicalHardwareCard`, `WgcPlasticCreditCard`, `WgcPractitionerProfileCard`, `WgcMerchantListingCard`, `WgcPromotionalProductCard` | Mais de 90 cards funcionais neutralizados cobrindo fintech, delivery, automotivo, saúde, marketplace e varejo. |
| **Feedback & Notificações** | `WgcAlert`, `WgcToast`, `WgcSnackbar`, `WgcBadge`, `WgcEmptyState`, `WgcErrorState` | Componentes de feedback com ilustrações/ícones semânticos, estados vazios e tratamento de erro de rede. |
| **Diálogos & Sheets** | `WgcStandardBottomSheet`, `WgcBottomSheet`, `WgcAlertDialog` | Folha modal padronizada com cabeçalho corporativo, botão de fechar, elevação e modais acessíveis. |
| **Linha do Tempo (Timeline)**| `WgcTimeline` | Status (Completed, Current, Pending), nós customizáveis, data e slots de ação. |
| **Avaliação & Feedback** | `WgcRatingBar` | Classificação de 1 a 5 estrelas, modo leitura com notas fracionárias e interativo com acessibilidade. |
| **Navegação & Barras** | `WgcMenuFactory`, `WgcAddressHeaderBar`, `WgcFloatingCartSummaryBar`, `WgcMarketplaceSearchHeaderBar` | Headers de pesquisa, endereço e barras flutuantes de carrinho. |
| **Stories & Mídia** | `WgcStoryTray`, `WgcStoryAvatar`, `WgcAvatar` | Bandejas de stories interativas e avatares com estados lidos/não-lidos. |
| **Efeitos Visuais & Loaders**| `WgcShimmer`, `WgcCircularProgress`, `WgcLinearProgress`, `WgcSkeleton` | Skeletons modulares pré-moldados (Card, ListItem, Profile) com shimmer integrado. |

---

## 📐 Diretrizes de Arquitetura dos Componentes

1. **State Hoisting Obrigatório (Stateless por Padrão):**
   Nenhum componente público mantém estado mutável interno. O estado e os eventos são sempre passados como parâmetros:
   ```kotlin
   @Composable
   fun WgcSimpleTextField(
       value: String,
       onValueChange: (String) -> Unit,
       modifier: Modifier = Modifier,
       ...
   )
   ```
2. **Consumo Exclusivo de Tokens do `:core`:**
   Nenhum componente utiliza `Color(...)` solta, `.dp` ou `.sp` avulso. Todas as dimensões utilizam `WgcCoreDsSpacing`, `WgcCoreDsBorderRadius` ou `MaterialTheme.colorScheme`.
3. **Padrão de Nomenclatura com Prefixo `Wgc`:**
   Todo componente corporativo é nomeado com o prefixo `Wgc` para evitar colisão com o Jetpack Compose padrão.
4. **100% de Cobertura com Previews e Testes de Regressão:**
   Todo componente público possui `@Preview` para cada variante de estado e testes visuais em `src/screenshotTest/`.

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
    implementation("br.com.wgc:components:0.0.x")
    implementation("br.com.wgc:core:0.0.x")
}
```

> [!NOTE]
> O pacote Kotlin / Android namespace deste módulo é `br.com.wgc.design_system`.

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo utiliza o plugin corporativo `wgc.android.library` e `maven-publish`, publicando o artefato `components-release.aar`.

### Deploy Local (Maven Local):
```bash
./gradlew :components:publishToMavenLocal
```

### Deploy Remoto Manual (GitHub Packages):
```bash
./gradlew :components:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O pipeline hipergranular do GitHub Actions detecta alterações em `components/**` e realiza o deploy automaticamente no merge para a branch `master`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc completa com todas as funções `@Composable`, parâmetros e slots está disponível em:

👉 **[Acessar Documentação de API do `:components`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/components/)**
