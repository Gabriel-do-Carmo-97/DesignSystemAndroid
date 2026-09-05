# Plano de Implementação: Suíte Completa de Templates de Telas (4 Grupos & Variações)

Este plano descreve a criação de uma suíte robusta de templates de telas no módulo `:ds-templates`, dividida em 4 grupos principais com múltiplas variações. Cada variação será desenvolvida e commitada de forma atômica e independente em uma nova branch (`feature/m3-all-templates-suite`) criada a partir da `master` atualizada.

## User Review Required

> [!IMPORTANT]
> Todos os templates seguirão o padrão arquitetural Pro estabelecido no projeto: `UiState` imutável, `BaseViewModel` abstrato, `FakeViewModel` para Previews e separação estrita entre Stateless e Stateful.

## Proposed Implementation Roadmap & Atomic Commits

### Grupo 1: Home / Dashboard (5 Variações)
1. **Fintech Home**: Saldo principal, atalhos de transação e lista de movimentações.
2. **E-commerce Home**: Banner hero, grade de categorias e produtos em destaque.
3. **SaaS Dashboard**: Resumo de métricas, tarefas e gráficos de progresso.
4. **Social Feed**: Stories, posts com avatares e interações.
5. **Health Fitness**: Metas diárias, calorias e lembretes.

### Grupo 2: Carrinho & Checkout (3 Variações)
1. **Standard Cart**: Lista de itens, cupom e totalizador.
2. **Stepper Checkout**: Passo a passo de endereço, frete e pagamento.
3. **SaaS Subscription**: Comparativo de planos (*Pricing Table*).

### Grupo 3: Perfil & Configurações (3 Variações)
1. **Social Profile**: Capa, avatar, bio e contadores.
2. **Settings Hub**: Lista agrupada de opções com switches e toggles.
3. **Edit Profile Form**: Formulário completo de edição de dados pessoais.

### Grupo 4: Listagem & Busca (3 Variações)
1. **Search & Filter**: Barra de busca, chips de filtro e resultados.
2. **Notification Feed**: Lista cronológica de avisos e alertas.
3. **Grid Catalog**: Catálogo em grade de 2 colunas com paginação.

## Verification Plan

### Automated Tests
- Executar `./gradlew assembleDebug` e `./gradlew check` após a conclusão de cada grupo para garantir estabilidade absoluta.
