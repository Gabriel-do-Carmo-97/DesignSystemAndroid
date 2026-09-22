# 🎨 Guia de Sincronização e Governança de Tokens: Figma ⟷ DesignSystemAndroid

Este documento define o fluxo de sincronização contínua de Design Tokens entre o Figma oficial da WGC e o monorepo Android (`:core`, `:components`, `:templates`).

---

## 🏛️ 1. Mapeamento de Tokens: Figma ⟷ `:core`

| Categoria Figma | Token Kotlin (`:core`) | Exemplo Figma | Exemplo Código |
| :--- | :--- | :--- | :--- |
| **Cores Primitivas** | `WgcCoreDsColorsPrimitive` | `color/blue/500` | `WgcCoreDsColorsPrimitive.Blue500` |
| **Cores Semânticas** | `WgcCoreDsColorsSemantic` | `semantic/feedback/success` | `WgcCoreDsColorsSemantic.Success` |
| **Espaçamentos** | `WgcCoreDsSpacing` | `spacing/md (16px)` | `WgcCoreDsSpacing.md16.dp` |
| **Raios de Borda** | `WgcCoreDsBorderRadius` | `radius/lg (12px)` | `WgcCoreDsBorderRadius.lg12.dp` |
| **Dimensões & Ícones** | `WgcCoreDsSize` | `size/40 (40px)` | `WgcCoreDsSize.s40.dp` |
| **Elevações & Sombras**| `WgcCoreDsElevation` | `elevation/level2` | `WgcCoreDsElevation.level2.dp` |
| **Transições & Motion**| `WgcCoreDsMotion` | `motion/duration/standard` | `WgcCoreDsMotion.durationStandard300` |
| **Tipografia** | `WgcCoreDsTypography` | `typography/title/large` | `WgcCoreDsTypography.titleLargeSize` |

---

## 🔄 2. Fluxo de Sincronização Automatizada

1. **Design no Figma:** O time de Design atualiza as variáveis ou publica uma versão no Tokens Studio / Figma Variables.
2. **Exportação JSON:** O arquivo `tokens.json` é gerado ou enviado via webhook para o repositório.
3. **Validação de Sintaxe e Nomes:**
   - Prefixos obrigatórios: `wgc-`
   - Nomenclatura camelCase para Kotlin: `durationStandard300`, `md16`, `lg12`.
4. **Geração / Atualização de Código em `:core`:**
   - Tokens nunca quebram compatibilidade retroativa.
   - Depreciações utilizam `@Deprecated` com indicação do substituto.
5. **Verificação de API Binary Compatibility Validator (BCV):**
   - Executar `./gradlew :core:apiDump` e `./gradlew :core:apiCheck`.
6. **Pull Request Automático:**
   - O bot do GitHub Actions submete o PR com o changelog de tokens.

---

## 🚨 3. Regras Invioláveis da Organização

- **Zero Valores Mágicos:** Nenhum componente ou tela pode conter `Color(0xFF...)`, `16.dp`, ou `24.sp` sem consumir um token corporativo de `:core`.
- **Acessibilidade WCAG 2.1 AA:** Todo par de cores de primeiro plano e fundo (`contentColor` vs `containerColor`) deve atender ao contraste mínimo de **4.5:1** para texto normal e **3:1** para texto grande.
