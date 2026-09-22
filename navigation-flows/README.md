# 🧭 Módulo `:navigation-flows` (Grafos e Fluxos de Navegação Desacoplados)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:navigation--flows-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/navigation-flows/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:navigation-flows`** orquestra grafos de navegação e fluxos de negócio completos (ex: Autenticação, Onboarding, Checkout) desacoplados da aplicação principal, utilizando **rotas Type-Safe** (`@Serializable`) do Jetpack Navigation Compose e arquitetura de **Flow Factories**.

---

## 🏛️ Arquitetura de Navegação

1. **Rotas Type-Safe com Kotlinx Serialization:**
   Todas as rotas e argumentos são representados por objetos ou data classes tipadas com `@Serializable`:
   ```kotlin
   @Serializable
   sealed interface AuthRoute {
       @Serializable
       data object Login : AuthRoute
       @Serializable
       data object Register : AuthRoute
       @Serializable
       data class ForgotPassword(val initialEmail: String? = null) : AuthRoute
   }
   ```

2. **Extensões no `NavGraphBuilder`:**
   Os fluxos são expostos como extensões idiomáticas do Compose Navigation, garantindo encapsulamento de rotas e transições:
   ```kotlin
   fun NavGraphBuilder.authGraph(
       navController: NavHostController,
       onAuthSuccess: () -> Unit,
       onForgotPasswordClick: () -> Unit
   ) { ... }
   ```

3. **Desacoplamento e Saídas via Lambdas:**
   Nenhum fluxo conhece telas fora de seu escopo. Eventos que cruzam fluxos (ex: "login com sucesso", "ir para checkout") são emitidos através de callbacks funcionais.

4. **Reúso de Telas e Componentes:**
   Consome diretamente as telas de `:templates` e componentes visuais de `:components`, sem duplicar regras de UI.

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
    implementation("br.com.wgc:navigation-flows:0.0.x")
    implementation("br.com.wgc:templates:0.0.x")
    implementation("br.com.wgc:components:0.0.x")
    implementation("br.com.wgc:core:0.0.x")
}
```

> [!NOTE]
> O pacote Kotlin / Android namespace deste módulo é `br.com.wgc.ds_navigation_flows`.

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo utiliza o plugin corporativo `wgc.android.library` e `maven-publish`, publicando o artefato `navigation-flows-release.aar`.

### Deploy Local (Maven Local):
```bash
./gradlew :navigation-flows:publishToMavenLocal
```

### Deploy Remoto Manual (GitHub Packages):
```bash
./gradlew :navigation-flows:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (CI/CD):
A esteira do GitHub Actions detecta alterações em `navigation-flows/**` e realiza o build, testes e deploy automáticos no merge para a branch `master`.

---

## 📚 Documentação Online (GitHub Pages)

👉 **[Acessar Documentação de API do `:navigation-flows`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/navigation-flows/)**
