# Política de Segurança — DesignSystemAndroid 🔒

O **DesignSystemAndroid** é a base visual corporativa da organização **WGC**, fornecendo componentes de UI, campos de dados sensíveis (inputs de senha, dados de pagamento, cartões) e fluxos completos de autenticação consumidos em produção por diversos aplicativos móveis.

---

## 🛡️ Versões Suportadas

Apenas as versões mais recentes na branch ativa `master` recebem patches de segurança e hotfixes regulares:

| Versão | Suporte a Patches de Segurança |
|:---|:---|
| `v0.1.x` (Atual) | Sim (Versão ativa em desenvolvimento) |
| `< v0.1.0` | Não (Atualização recomendada) |

---

## 🚨 Como Reportar uma Vulnerabilidade

**Por favor, NÃO abra Issues públicas no GitHub para reportar vulnerabilidades de segurança.**

Se você identificou uma falha de segurança (ex: vazamento de credenciais em previews, má sanitização em campos de texto, inputs não seguros ou dependências comprometidas):

1. Envie um e-mail confidencial detalhado para:
   📧 **`gabriel.desenvolvedor.97@gmail.com`**
2. No assunto do e-mail, utilize:
   `[SECURITY VULNERABILITY] DesignSystemAndroid - <Resumo Breve>`
3. No corpo da mensagem, inclua:
   - **Descrição detalhada:** Explicação do problema ou vetor de vulnerabilidade.
   - **Módulos afetados:** (ex: `:core-ds`, `:design-system`, `:ds-templates`).
   - **Passos para reprodução:** Trecho de código ou cenário demonstrativo.
   - **Impacto potencial:** Avaliação de risco.

---

## ⏱️ Compromisso e SLA de Resposta

* **Confirmação inicial de recebimento:** Em até **24 a 48 horas**.
* **Avaliação de severidade e triagem:** Em até **72 horas**.
* **Lançamento de patch corretivo:** Prioridade máxima com publicação de release no GitHub Packages.