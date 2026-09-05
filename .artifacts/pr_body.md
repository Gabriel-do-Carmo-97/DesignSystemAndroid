## feat(ifood): clone completo da Home do iFood organizado por módulos (:core-ds, :design-system, :ds-templates e :app)

### 📋 Mapeamento Arquitetural por Módulo:
1. **Módulo `:core-ds` (Tokens de Marca):**
   - Inclusão das cores oficiais do iFood (`ifoodRed` `#EA1D2C`, `ifoodRedDark` `#CC1825`, `ifoodGreen` `#00A251`, `ifoodBgGray` `#F7F7F7`).
2. **Módulo `:design-system` (Átomos e Moléculas):**
   - `IFoodAddressHeader`: Barra superior de seleção de endereço, busca rápida e notificações.
   - `IFoodCategoryGrid`: Carrossel de categorias circulares (*Restaurantes, Mercado, Farmácia, Bebidas, Pet*).
   - `IFoodRestaurantCard`: Card oficial de restaurante com nota ★ 4.8, distância, tempo de entrega, selo "SUPER" e frete grátis.
   - `IFoodStickyCartBar`: Barra flutuante inferior do carrinho vermelha com contagem de itens, restaurante e valor total.
3. **Módulo `:ds-templates` (Template Completo de Tela):**
   - `IFoodHomeScreenTemplate`: Tela Home completa integrando endereço, busca, categorias, banner de cupons de R$ 15,00 OFF, lista de restaurantes populares e barra de carrinho flutuante.
   - Inclui `IFoodHomeUiState`, `BaseIFoodHomeViewModel`, `FakeIFoodHomeViewModel` e Previews.
4. **Módulo `:app` (Catálogo / Storybook):**
   - Nova aba **"iFood Home"** integrada em `MainActivity.kt`.
5. **Testes:**
   - Suíte de testes unitários (`IFoodHomeViewModelTest`) e testes instrumentados de UI (`IFoodHomeScreenTemplateTest`).

### 🧪 Verificação:
- `./gradlew check` e `./gradlew assembleDebug` 100% aprovados.
