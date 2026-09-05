# 📚 Documentação de API com Dokka

O projeto está configurado com o plugin **Dokka** para gerar documentação em formato HTML/Markdown diretamente a partir dos KDocs do código-fonte.

## Como gerar a documentação localmente:
Execute a task do Gradle correspondente:
```bash
./gradlew dokkaHtml
```
Os arquivos gerados estarão disponíveis em `build/dokka/html/` em cada subprojeto.
