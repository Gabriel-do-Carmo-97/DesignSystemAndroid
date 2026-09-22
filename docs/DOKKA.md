# 📚 Documentação de API com Dokka

O projeto está configurado com o plugin **Dokka** para gerar documentação em formato HTML/Markdown diretamente a partir dos KDocs do código-fonte.

## Como gerar a documentação localmente:

### Portal consolidado (Multi-Módulo):
Gera o portal unificado com todos os módulos (`app`, `core`, `components`, `templates`, `navigation-flows`):
```bash
./gradlew dokkaHtmlMultiModule
```
Os arquivos gerados estarão disponíveis na raiz do projeto em:
`build/dokka/htmlMultiModule/`

### Documentação individual por submódulo:
```bash
./gradlew dokkaHtml
```
Os arquivos gerados estarão disponíveis em `build/dokka/html/` em cada subprojeto.
