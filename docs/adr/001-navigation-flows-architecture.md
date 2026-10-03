# ADR 001: Arquitetura Desacoplada do Módulo :navigation-flows

## Status
**Aprovado** (2026-10-03)

## Contexto
O monorepo do Design System WGC necessitava de uma estratégia robusta para orquestrar fluxos de ponta a ponta (como Autenticação, Onboarding, Checkout e KYC) sem acoplar regras de negócio das aplicações clientes às bibliotecas de UI.

## Decisão
1. Criação do módulo dedicado `:navigation-flows` baseado em Jetpack Compose Navigation com Kotlinx Serialization type-safe.
2. Cada fluxo é exposto como uma função de extensão `NavGraphBuilder.<flowName>NavGraph(...)` e um `<flowName>NavHost(...)` autônomo com navegação padrão.
3. Comunicação entre destinos ocorre exclusivamente através de `SavedStateHandle` com contratos fortemente tipados (`WgcFlowResultContract`).
4. Cada tela no subgrafo consome templates desacoplados de `:templates` com injeção de `UiState` e lambdas de callback.

## Consequências
- **Positivas:** Fluxos 100% plugáveis e testáveis em isolamento; zero dependência circular entre módulos; suporte nativo a deep links e telemetria uniforme.
- **Negativas:** Requer a definição explícita de rotas `@Serializable` para cada destino.
