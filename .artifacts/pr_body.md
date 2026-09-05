## feat(nineninefood): clone completo da Home da 99Food com cor predominantemente Azul Escuro (#0B2545) e componentes Wgc

### 📋 Mapeamento Arquitetural por Módulo:
1. **Módulo `:core-ds` (Tokens de Marca):**
   - Inclusão dos tokens da 99Food: `nineNineDarkBlue` (`#0B2545`) e `nineNineLightBlue` (`#1E88E5`).
2. **Módulo `:design-system` (Átomos e Moléculas com prefixo `Wgc`):**
   - `WgcNineNineAddressHeader`: Cabeçalho em Azul Escuro (#0B2545) com seleção de endereço, busca rápida e notificações.
   - `WgcNineNineCategoryGrid`: Carrossel de categorias da 99Food (*Entrega 15m, Restaurantes, Cupons, Mercado, Bebidas*).
   - `WgcNineNineRestaurantCard`: Card oficial de restaurante com selo 99Club, nota ★ 4.9, tempo e cupons de desconto (*"R$ 10 OFF"*).
   - `WgcNineNineStickyCartBar`: Barra flutuante de sacola em Azul Escuro com quantidade de itens, restaurante e valor total.
3. **Módulo `:ds-templates` (Template Completo de Tela):**
   - `NineNineFoodHomeScreenTemplate`: Tela Home completa integrando o cabeçalho Azul Escuro, busca, categorias, banner do 99Club com cupons de R$ 20,00, lista de restaurantes e sacola flutuante.
   - Inclui `NineNineFoodHomeUiState`, `BaseNineNineFoodHomeViewModel`, `FakeNineNineFoodHomeViewModel` e Previews.
4. **Módulo `:app` (Catálogo / Storybook):**
   - Nova aba **"99Food Home"** integrada em `MainActivity.kt`.
5. **Testes:**
   - Suíte de testes unitários (`NineNineFoodHomeViewModelTest`) e testes instrumentados de UI (`NineNineFoodHomeScreenTemplateTest`).

### 🧪 Verificação:
- `./gradlew check` e `./gradlew assembleDebug` 100% aprovados.
