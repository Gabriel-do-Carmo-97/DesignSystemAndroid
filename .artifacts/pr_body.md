## feat(design-system): evolução arquitetural para Nível Pro (Staff/Principal Engineer)

### 📋 O que foi implementado em 6 Commits Atômicos:
1. **Multipreview Annotations (`WgcComponentPreviews`):**
   - Criada anotação composta para testar componentes automaticamente em Modo Claro, Modo Escuro e Escala de Fonte Alta (1.5x) simultaneamente em tempo de design.
2. **CompositionLocal para Tokens (`LocalWgcSpacing`):**
   - Adicionado suporte a `CompositionLocal` para injeção dinâmica de tokens de design, abrindo caminho para suporte a *White-labels* e temas customizados.
3. **Strict Modifier Ordering & Semantic Role:**
   - Padronizada a ordem de modificadores e adicionada semântica explícita de `Role.Button` em botões essenciais.
4. **Advanced Semantic Accessibility (A11y):**
   - Adicionado suporte a `mergeDescendants = true`, `stateDescription` ("Marcado" / "Desmarcado") e `Role.Checkbox` no `CheckboxDefaults`.
5. **Native Loading State (`isLoading`):**
   - Adicionado suporte nativo a `isLoading: Boolean` com `CircularProgressIndicator` embutido no `ClassicButton`.
6. **Dokka Documentation Plugin Setup:**
   - Configurado o plugin **Dokka** em todos os subprojetos para geração automatizada de documentação KDoc de nível profissional para a API pública do Design System.

### 🎯 Por quê?
Levar o Design System WGC ao mais alto nível de engenharia de software em Jetpack Compose, garantindo escalabilidade, acessibilidade de ponta, flexibilidade de temas e robustez de documentação.

### 🔍 Módulos Afetados
- `design-system/`
- Raiz do projeto (`build.gradle.kts`, `libs.versions.toml`)
