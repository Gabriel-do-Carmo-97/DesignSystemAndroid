# 🛡️ Guia de Proteção de Branch (Branch Protection Rules)

Para garantir que nenhum código quebre o Design System WGC ou viole nossos padrões de qualidade, configure as seguintes **Branch Protection Rules** na branch `master` no GitHub:

## Configurações Recomendadas no GitHub:

1. **Vá em:** `Settings` > `Branches` > `Branch protection rules` > `Add rule`.
2. **Branch name pattern:** `master`
3. **Marque as seguintes opções:**
   - [x] **Require a pull request before merging**
     - [x] Require approvals (1 approval)
     - [x] Dismiss stale pull request approvals when new commits are pushed
   - [x] **Require status checks to pass before merging**
     - [x] Require branches to be up to date before merging
     - **Status checks obrigatórios:**
       - `🧪 Build, Test & Lint`
       - `🏷️ Validate PR Title` (Semantic Pull Request)
   - [x] **Require conversation resolution before merging**
   - [x] **Do not allow bypassing the above settings**
