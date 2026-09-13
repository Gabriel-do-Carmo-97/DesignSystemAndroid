# 💎 Módulo `:core-ds` (Design Tokens Fundamentais)

[![Maven Package](https://img.shields.io/badge/GitHub%20Packages-br.com.wgc:core--ds-blue.svg)](https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid/packages)
[![Dokka API Docs](https://img.shields.io/badge/Dokka-API%20Reference-blueviolet.svg)](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core-ds/)
[![Detekt Passing](https://img.shields.io/badge/Detekt-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)

O módulo **`:core-ds`** é o alicerce agnóstico de plataforma e framework do Design System WGC. Ele centraliza a verdade absoluta sobre todos os **Design Tokens** corporativos, garantindo consistência visual estrita entre aplicações Android, Compose, Views ou qualquer biblioteca consumidora.

---

## 📐 O que este Módulo Contém

Os tokens são expostos através de classes imutáveis e padronizadas:

| Categoria | Objeto / Classe | Descrição |
| :--- | :--- | :--- |
| **Cores Primitivas** | `WgcCoreDsColors` | Paleta pura da organização (`red500`, `blue500`, `grey50` a `grey900`, `white`, `black`). |
| **Cores Semânticas** | `WgcCoreDsColors` | Mapeamentos semânticos com significado de negócio (`primary`, `secondary`, `background`, `surface`, `error`, `success`, `warning`). |
| **Espaçamentos** | `WgcCoreDsSpacing` | Escala padronizada de distanciamento: de `none0` (0) até `giant80` (80px/dp). |
| **Raios de Borda** | `WgcCoreDsBorderRadius` | Curvaturas de cantos: de `none0` (0) até `circular999` (estilo pílula / circular completo). |
| **Tamanhos e Dimensões** | `WgcCoreDsSize` | Dimensões consistentes para ícones, avatares e alvos de toque (mínimo 48dp). |

---

## 🚫 Regras Invioláveis do Módulo

1. **Zero Compose Runtime (`@Composable`):** O `:core-ds` deve permanecer agnóstico de UI framework. Ele manipula apenas primitivas e objetos leves.
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
    implementation("br.com.wgc:core-ds:0.0.x")
}
```

---

## 🚀 Como Fazer o Deploy / Publicação

O módulo está configurado com o plugin `maven-publish` e publica o artefato `core-ds-release.aar` com seu respectivo POM.

### Deploy Local (Ambiente de Testes / Sandbox):
Para publicar no repositório Maven local (`~/.m2/repository`):
```bash
./gradlew :core-ds:publishToMavenLocal
```

### Deploy Remoto Manual (GitHub Packages):
```bash
./gradlew :core-ds:publish -PVERSION_NAME=1.0.0
```

### Deploy Automático (Esteira CI/CD):
O workflow hipergranular `.github/workflows/android.yml` publica automaticamente uma nova versão do `:core-ds` no GitHub Packages sempre que houver um `push` ou merge para a branch `master` com alterações detectadas no diretório `core-ds/**`.

---

## 📚 Documentação Online (GitHub Pages)

A documentação KDoc e a referência de classes deste módulo são geradas via **Dokka** e hospedadas no GitHub Pages:

👉 **[Acessar Documentação de API do `:core-ds`](https://gabriel-do-carmo-97.github.io/DesignSystemAndroid/core-ds/)**
