# 🧩 Módulo `:design-system` (Componentes Visuais Atômicos & Moleculares)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:design--system-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/design-system/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:design-system`** contém todos os componentes de interface de usuário (UI) atômicos e moleculares da organização WGC construídos em **Jetpack Compose** e **Material 3**.

---

## 🧱 Catálogo de Componentes

| Categoria | Componentes Principais | Destaques de Acessibilidade & Estados |
| :--- | :--- | :--- |
| **Botões de Ação** | `WgcClassicButton`, `WgcSecondaryClassicButton`, `WgcFAButton`, `WgcIconButton` | Estados Habilitado, Desabilitado e Loading (`CircularProgressIndicator`), alvo de toque mínimo de 48dp. |
| **Autenticação & Social** | `WgcBiometricButton`, `WgcSocialLoginPillButton`, `WgcSocialLoginPillGroup` | Biometria (`Circular`, `RoundedSquare`, `OutlinedSquare`), botões sociais padrão (Google, Apple, Facebook). |
| **Alternadores & Switches** | `WgcPillTabSwitch`, `WgcSegmentedControl` | Alternador deslizante tipo pílula para Login/Cadastro com animação suave. |
| **Campos de Texto (Inputs)** | `WgcSimpleTextField`, `WgcSearchTextField`, `WgcPasswordTextField` | Suporte a Leading/Trailing icons, estados de erro, máscara de senha e foco. |
| **Seleção & Seletores** | `WgcCheckBoxDefault`, `WgcRadioButtonDefault`, `WgcSwitchDefault`, `WgcFilterChip` | Feedback háptico, suporte a estados desabilitados e `SemanticsProperties`. |
| **Feedback & Notificações** | `WgcAlert`, `WgcToast`, `WgcSnackbar`, `WgcBadge` | Tipos Informativo, Sucesso, Alerta e Erro com ícones semânticos do `:core-ds`. |
| **Efeitos Visuais & Loaders**| `WgcShimmer`, `WgcCircularProgress`, `WgcLinearProgress` | Efeito shimmer personalizável para skeletons de carregamento. |

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
2. **Consumo Exclusivo de Tokens do `:core-ds`:**
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
    implementation("br.com.wgc:design-system:0.0.x")
    implementation("br.com.wgc:core-ds:0.0.x")
}
```

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo utiliza o plugin `maven-publish` e publica o artefato `design-system-release.aar`.

### Deploy Local (Maven Local):
```bash
./gradlew :design-system:publishToMavenLocal
```

### Deploy Remoto Manual (GitHub Packages):
```bash
./gradlew :design-system:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O pipeline hipergranular do GitHub Actions detecta alterações em `design-system/**` e realiza o deploy automaticamente no merge para a branch `master`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc completa com todas as funções `@Composable`, parâmetros e slots está disponível em:

👉 **[Acessar Documentação de API do `:design-system`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/design-system/)**
