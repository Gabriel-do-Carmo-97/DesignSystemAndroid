# 💎 Módulo `:core` (Design Tokens Fundamentais)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:core-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)

O módulo **`:core`** é o alicerce agnóstico de plataforma e framework do Design System WGC. Ele centraliza a verdade absoluta sobre todos os **Design Tokens** corporativos, garantindo consistência visual estrita entre aplicações Android, Compose, Views ou qualquer biblioteca consumidora.

---

## 📐 O que este Módulo Contém

Os tokens são expostos através de classes imutáveis e padronizadas:

| Categoria | Objeto / Classe | Descrição |
| :--- | :--- | :--- |
| **Cores Primitivas** | `WgcCoreDsColors` | Paleta pura da organização (`red500`, `blue500`, `grey50` a `grey900`, `white`, `black`). |
| **Cores Semânticas & Domínios** | `WgcCoreDsColors` | Mapeamentos semânticos (`primary`, `secondary`, `background`, `surface`, `error`, `success`, `warning`) e paletas funcionais neutras (FoodDelivery, Marketplace, Fintech, etc.). |
| **Espaçamentos** | `WgcCoreDsSpacing` | Escala padronizada de distanciamento: de `none0` (0) até `giant80` (80px/dp). |
| **Raios de Borda** | `WgcCoreDsBorderRadius` | Curvaturas de cantos: de `none0` (0) até `circular999` (estilo pílula / circular completo). |
| **Tamanhos e Dimensões** | `WgcCoreDsSize` | Dimensões consistentes para ícones, avatares e alvos de toque (mínimo 48dp). |
| **Elevações** | `WgcCoreDsElevation` | Níveis de sombra e profundidade: de `level0` (0dp) até `level8` (8dp para modais). |
| **Movimento & Animações** | `WgcCoreDsMotion` | Durações padronizadas: de `durationFast100` (100ms) a `durationSlow500` (500ms). |
| **Contratos de Tema** | `WgcThemeTokens` | Interface para abstração e injeção de tokens temáticos corporativos. |

---

## 🚫 Regras Invioláveis do Módulo

1. **Zero Compose Runtime (`@Composable`):** O `:core` deve permanecer agnóstico de UI framework. Ele manipula apenas primitivas e objetos leves em Kotlin puro.
2. **Zero Valores Mágicos:** Nenhuma cor, espaçamento ou raio pode ser gerado dinamicamente fora das constantes oficiais.
3. **Cores Semânticas referenciam Primitivas:** As cores semânticas devem sempre delegar seu valor a um token primitivo para garantir integridade do tema corporativo.

---

## 📦 Como Consumir via Gradle

### 1. Configurar Repositório do GitHub Packages (`settings.gradle.kts` ou `build.gradle.kts`)
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

### 2. Adicionar Dependência no seu Módulo (`build.gradle.kts`)
```kotlin
dependencies {
    implementation("br.com.wgc:core:0.0.x")
}
```

> [!NOTE]
> O pacote Kotlin / Android namespace deste módulo é `br.com.wgc.core_ds`.

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo está configurado com o plugin `wgc.android.library` e `maven-publish`, publicando o artefato `core-release.aar`.

### Deploy Local (Ambiente de Testes / Sandbox):
```bash
./gradlew :core:publishToMavenLocal
```

### Deploy Remoto Manual (GitHub Packages):
```bash
./gradlew :core:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O workflow hipergranular `.github/workflows/android.yml` publica automaticamente uma nova versão do `:core` no GitHub Packages sempre que houver um `push` ou merge para a branch `master` com alterações detectadas no diretório `core/**`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc e a referência de classes deste módulo são geradas via **Dokka** e hospedadas no GitHub Pages:

👉 **[Acessar Documentação de API do `:core`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core/)**
