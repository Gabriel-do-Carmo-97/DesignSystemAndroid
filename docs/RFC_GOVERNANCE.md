# 🏛️ Governança de RFC: Adição de Novos Componentes e Telas

Este documento define o processo obrigatório de submissão, análise e aprovação de novos componentes, tokens e telas no monorepo `DesignSystemAndroid`.

---

## 🎯 Objetivo

Evitar a proliferação desordenada de telas monolíticas e clones de aplicativos de terceiros. 
**O Design System deve crescer prioritariamente por Átomos, Moléculas e Tokens Universais, e não por cópias de telas inteiras.**

---

## 🚦 Regra de Ouro (Átomos Primeiro)

Nenhuma tela nova pode ser adicionada ao módulo `:templates` a menos que responda com **SIM** a pelo menos uma das seguintes perguntas:

1. **Os tokens existentes em `:core` já atendem 100% da demanda visual?**
   - Se a tela exigir cores hexadecimais soltas ou espaçamentos arbitrários → **REPROVADA**. Primeiro solicite os tokens semânticos a `:core`.
2. **Os componentes visuais são construídos a partir de átomos existentes em `:components`?**
   - Se a tela implementar botões próprios, inputs próprios ou cabeçalhos não-hoisted → **REPROVADA**. Decomponha o componente e adicione-o primeiro a `:components`.
3. **A tela é parametrizável via `UiState`, `BaseViewModel` e Slots?**
   - Se for um composable monolítico sem State Hoisting ou com regras de negócio embutidas → **REPROVADA**.

---

## 📝 Processo de RFC (Request for Comments)

Para propor um novo componente ou tela:

1. **Abertura da RFC:** Crie uma Issue com a tag `rfc:proposal` detalhando:
   - Nome descritivo neutro (zero marcas comerciais).
   - Casos de uso e arquétipos atendidos.
   - Lista de tokens de `:core` consumidos.
   - Lista de componentes de `:components` reutilizados.
   - Novos átomos ou moléculas necessários.
2. **Revisão Técnica:** Avaliação pelo Arquiteto / Tech Lead do Design System.
3. **Aprovação / Implementação:** Após aprovação, a implementação deve seguir estritamente o pipeline de qualidade com `@Preview`, testes unitários de ViewModel e conformidade com Detekt.
