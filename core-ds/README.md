# 💎 Módulo `:core-ds` (Design Tokens)

O módulo `:core-ds` é a fundação do Design System WGC. Ele armazena todos os **tokens de design** agnósticos de plataforma e de framework UI.

## 📐 O que contém:
- **Cores (`WgcCoreDsColors`)**: Cores primitivas (`red500`, `blue500`, `grey50`, etc.) e cores semânticas (`primary`, `secondary`, `background`, `error`, `success`, `warning`).
- **Espaçamentos (`WgcCoreDsSpacing`)**: Escala consistente de espaçamento de `none0` (0) até `giant80` (80px).
- **Raios de Borda (`WgcCoreDsBorderRadius`)**: Escala de arredondamento de `none0` até `circular999`.
- **Tamanhos (`WgcCoreDsSize`)**: Dimensões padronizadas.

## 🚫 Regras Invioláveis:
- **NÃO** insira dependências do Compose (`@Composable`).
- **NÃO** insira lógica de UI ou views.
- Cores semânticas devem sempre referenciar cores primitivas.
