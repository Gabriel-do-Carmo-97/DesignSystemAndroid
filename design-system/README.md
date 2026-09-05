# 🧩 Módulo `:design-system` (Componentes Visuais)

O módulo `:design-system` contém todos os componentes atômicos e moleculares reutilizáveis construídos em **Jetpack Compose**.

## 🧱 O que contém:
- **Botões**: `ClassicButton`, `SecondaryClassicButton`, `FAButton`.
- **Campos de Texto**: `SimpleTextField`, `SearchTextField`.
- **Cards & Seções**: `ProductDetailCard`, `SectionCategories`, `ItemSectionCard`.
- **Utilitários**: Efeito Shimmer, extensões de BigDecimal e permissões.

## 📐 Diretrizes de Desenvolvimento:
- **Stateless por padrão**: Todo componente deve seguir *state hoisting* (`value` + `onValueChange`).
- **Modifiers**: O primeiro parâmetro deve ser `modifier: Modifier = Modifier`, aplicado uma única vez no nó raiz.
- **Acessibilidade**: Todo componente interativo deve ter tamanho mínimo de toque (48dp x 48dp) e semântica adequada (`Role`, `contentDescription`).
- **Screenshot Tests**: Todo componente novo deve ter testes visuais em `src/screenshotTest/`.
