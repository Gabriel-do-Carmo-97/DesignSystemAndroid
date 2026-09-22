# Governança de Arquitetura & Documentação Dokka: WGC Design System 🎨

Este documento define os padrões rigorosos de governança, ciclo de vida de componentes, herança de tokens de design e automação de documentação do ecossistema `DesignSystemAndroid`.

---

## 🏛️ Princípios Arquiteturais Invioláveis

1. **Zero Valores Mágicos:**
   - Nenhum valor de cor hexadecimal, `.dp`, `.sp` ou dimensões avulsas deve ser declarado diretamente em componentes de UI.
   - Todas as medidas e atributos visuais devem obrigatoriamente derivar dos tokens corporativos de `:core`:
     - **Espaçamento:** `WgcCoreDsSpacing` (ex: `xxs4`, `xs8`, `sm12`, `md16`, `lg24`, `xl32`, `xxl40`, `xxxl48`).
     - **Raios de Borda:** `WgcCoreDsBorderRadius` (ex: `none`, `xs4`, `sm6`, `md8`, `lg12`, `xl16`, `sl18`, `circular999`).
     - **Elevação:** `WgcCoreDsElevation` (níveis 0 a 5).
     - **Movimento e Animações:** `WgcCoreDsMotion` (durações `durationShort100`, `durationStandard300` e interpolações).
     - **Cores:** `MaterialTheme.colorScheme` mapeado através dos temas semânticos da WGC.

2. **State Hoisting Obrigatório (Stateless por Padrão):**
   - Componentes em `:components` **nunca** armazenam estado interno mutável para regras de negócio.
   - O estado e os callbacks de evento são passados explicitamente como parâmetros de entrada:
     ```kotlin
     @Composable
     fun WgcCustomField(
         value: String,
         onValueChange: (String) -> Unit,
         modifier: Modifier = Modifier
     )
     ```

3. **Arquitetura Universal de Fábricas, Defaults Sensatos & Slots:**
   - **Fábricas Unificadas:** Todo template complexo possui uma fábrica unificada (ex: `WgcPixFactory`, `WgcCardFactory`, `WgcCreditFactory`).
   - **Defaults Sensatos:** Uma chamada sem parâmetros adicionais (ou apenas com o texto/ViewModel) deve funcionar imediatamente no padrão corporativo da WGC.
   - **Decomposição em Componentes & Slots:** Telas e templates são decompostos em pequenos componentes e expõem slots opcionais (`slot?.invoke() ?: ComponentePadrao()`).

---

## 📚 Geração Automatizada de Documentação Dokka

O monorepo utiliza o plugin **Dokka** para gerar documentação técnica navegável em formato HTML a partir dos comentários em formato KDoc presentes no código-fonte.

### Comandos de Compilação de Documentação

- **Gerar documentação em todos os módulos:**
  ```bash
  ./gradlew dokkaHtmlMultiModule
  ```
- **Gerar documentação isolada de um módulo específico:**
  ```bash
  ./gradlew :components:dokkaHtml
  ./gradlew :templates:dokkaHtml
  ./gradlew :navigation-flows:dokkaHtml
  ```

Os artefatos compilados são disponibilizados no diretório:
`build/dokka/htmlMultiModule/`

---

## 🧪 Pipeline de Qualidade e Gates de Release

Antes de cada release ou merge na branch `master`, o código deve ser validado integralmente:

```bash
./gradlew apiDump detekt testDebugUnitTest
```

1. **`apiDump` (Binary Compatibility Validator):** Valida que nenhuma alteração quebrou compatibilidade binária pública sem versionamento SemVer adequado.
2. **`detekt`:** Audita o código Kotlin garantindo 0 violações de complexidade ciclomática, métodos longos e convenções de código.
3. **`testDebugUnitTest`:** Executa a suíte completa de testes unitários em todos os módulos.
