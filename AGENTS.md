# Equipe de Agentes Especialistas: DesignSystemAndroid 🎨

Este documento define a governança, as responsabilidades e a arquitetura de **Agentes Especialistas** que operam no monorepo `DesignSystemAndroid`.

---

## 🏛️ Topologia da Equipe de Agentes

A equipe é liderada por um **Orquestrador Central (Tech Lead / Arquiteto)**, que atua como ponto único de contato e coordena os **Agentes Especialistas de Domínio e Suporte Técnico**.

```text
                               ┌─────────────────────────────────┐
                               │       USUÁRIO / TECH LEAD       │
                               └────────────────┬────────────────┘
                                                │
                                                ▼
                               ┌─────────────────────────────────┐
                               │   DESIGN-SYSTEM-ORCHESTRATOR    │
                               │  (Planejamento, Roteamento, CI) │
                               └────────────────┬────────────────┘
                                                │
        ┌───────────────────────────────┬───────┴───────────────────────┬───────────────────────────────┐
        │                               │                               │                               │
        ▼                               ▼                               ▼                               ▼
┌──────────────┐                ┌──────────────┐                ┌──────────────┐                ┌──────────────┐
│ Figma & UI   │                │ Tokens Core  │                │ Componentes  │                │ Templates &  │
│  Analyser    │                │   (:core)    │                │(:components) │                │    Telas     │
└──────────────┘                └──────────────┘                └──────────────┘                └───────┬──────┘
        │                               │                               │                       │
        ▼                               ▼                               ▼                       ▼
┌──────────────┐                ┌──────────────┐                ┌──────────────┐        ┌──────────────┐
│  Reviewer &  │                │ Gradle Build │                │ GitHub CI/CD │        │  Navigation  │
│  Qualidade   │                │   & Tooling  │                │   & Deploy   │        │    Flows     │
└──────────────┘                └──────────────┘                └──────────────┘        └──────────────┘
```

---

## 👥 Especialistas e Matriz de Responsabilidade

| Agente | Arquivo de Diretrizes | Módulo / Escopo | Responsabilidade Principal |
| :--- | :--- | :--- | :--- |
| **`orchestrator`** | [`agents/design-system-orchestrator.md`](./agents/design-system-orchestrator.md) | Repositório Global | Planeja fluxos cross-module, delega tarefas aos especialistas e consolida resultados. **NUNCA gera código diretamente**. |
| **`figma-analyser`** | [`agents/figma-analyser-agent.md`](./agents/figma-analyser-agent.md) | Design / Figma | Analisa especificações visuais, tokens e componentes existentes. Mapeia o que já existe vs. o que precisa ser criado. |
| **`core`** | [`agents/core-ds-agent.md`](./agents/core-ds-agent.md) | `:core` | Mantém os tokens de design (Cores primitivas e semânticas, Espaçamentos, Raios, Tamanhos, Elevações e Animações). |
| **`components`** | [`agents/design-system-agent.md`](./agents/design-system-agent.md) | `:components` | Desenvolve átomos e moléculas reutilizáveis em Jetpack Compose com State Hoisting, acessibilidade e screenshot tests. |
| **`templates`** | [`agents/ds-templates-agent.md`](./agents/ds-templates-agent.md) | `:templates` | Desenvolve telas completas e fluxos desacoplados baseados em `UiState` + `BaseViewModel` + `FakeViewModel`. |
| **`navigation-flows`** | [`agents/navigation-flows-agent.md`](./agents/navigation-flows-agent.md) | `:navigation-flows` | Orquestra grafos e fluxos de navegação desacoplados (Auth, Checkout, Onboarding) com type-safety e slots customizáveis. |
| **`code-reviewer`** | [`agents/code-reviewer-agent.md`](./agents/code-reviewer-agent.md) | Validação / QA | Audita código gerado, valida checklists de padrões, OWASP, acessibilidade e conformidade com tokens. Parecer: APROVADO / REPROVADO. |
| **`gradle`** | [`agents/gradle-agent.md`](./agents/gradle-agent.md) | Build & Tooling | Gerencia dependências (`libs.versions.toml`), plugins Gradle, Detekt, Dokka e compilação. |
| **`github`** | [`agents/github-agent.md`](./agents/github-agent.md) | CI/CD & Releases | Gerencia branches, convenções de commits, Pull Requests, publicação de AARs no GitHub Packages e releases SemVer. |

---

## 🚨 Regras Invioláveis da Organização

1. **Zero Valores Mágicos em Código Novo:**
   - **NUNCA** utilize valores hexadecimais soltos, `Color(...)`, `.dp`, `.sp` ou dimensões avulsas sem token.
   - Cores devem consumir `MaterialTheme.colorScheme.*` ou tokens mapeados de `:core`. Espaçamentos e raios devem consumir `WgcCoreDsSpacing` e `WgcCoreDsBorderRadius`.
   - Se o token não existe → pause e solicite a criação ao `core-agent`.
2. **State Hoisting Obrigatório (Stateless por Padrão):**
   - Componentes visuais em `:components` **NUNCA** mantêm estado mutável interno via `remember { mutableStateOf(...) }` para valores de negócio.
   - O estado e eventos devem ser passados como parâmetros: `value: String`, `onValueChange: (String) -> Unit`.
3. **Padrão de Nomenclatura com Prefixo `Wgc`:**
   - Componentes oficiais do Design System utilizam o prefixo corporativo: `WgcClassicButton`, `WgcChip`, `WgcAlert`, etc.
4. **100% de Cobertura de Visualização & Regressão:**
   - Todo componente público DEVE ter `@Preview` para cada variante (Default, Loading, Disabled) e `@PreviewTest` no módulo de screenshot testing.
5. **Preservação de APIs Públicas:**
   - Nenhuma alteração que quebre compatibilidade reversa deve ser feita sem aprovação explícita do Tech Lead / Orquestrador.
6. **Arquitetura Universal de Factories, Defaults Sensatos & Slots (Obrigatório para Todos os Componentes e Templates):**
   - **Factories Unificadas:** Todo componente e todo template deve ser exposto através de uma Factory/ponto de entrada unificado (ex: `WgcButton`, `WgcMenuFactory`, `WgcAuthFactory`, `WgcHomeFactory`).
   - **Sensible Defaults:** Todo parâmetro da Factory DEVE possuir um valor padrão corporativo sensato. Uma chamada sem parâmetros adicionais (ou apenas com o texto/ViewModel) DEVE funcionar imediatamente no padrão de produção da WGC.
   - **Decomposição em Componentes & Slots:** Telas e templates NUNCA devem ser blocos monolíticos. Devem sempre ser decompostos em pequenos componentes reutilizáveis e expor slots opcionais (`slot?.invoke() ?: ComponentePadrao()`) para permitir a substituição granular de menus, botões, headers e footers.