#!/bin/bash

# Script de Migração de Namespace para Design System WGC
# Este script ajuda a migrar automaticamente os namespaces para o novo padrão

set -e

echo "🔄 Iniciando migração de namespace..."
echo "⚠️  Este script modificará arquivos no seu projeto"
echo ""
read -p "Deseja continuar? (y/n) " -n 1 -r
echo ""
if [[ ! $REPLY =~ ^[Yy]$ ]]; then
    echo "❌ Migração cancelada"
    exit 1
fi

echo "📋 Backup criado em: backup-$(date +%Y%m%d-%H%M%S)"
mkdir -p "backup-$(date +%Y%m%d-%H%M%S)"
cp -r . "backup-$(date +%Y%m%d-%H%M%S)/"

echo "🔍 Buscando arquivos Kotlin..."
KT_FILES=$(find . -name "*.kt" -type f)
echo "Encontrados: $(echo "$KT_FILES" | wc -l) arquivos Kotlin"

echo "🔄 Migrando namespaces em arquivos Kotlin..."
for file in $KT_FILES; do
    sed -i 's/br\.com\.wgc\.core_ds/br.com.wgc.design_system.core/g' "$file"
    sed -i 's/br\.com\.wgc\.design_system\./br.com.wgc.design_system.components./g' "$file"
    sed -i 's/br\.com\.wgc\.ds_templates/br.com.wgc.design_system.templates/g' "$file"
    sed -i 's/br\.com\.wgc\.ds_navigation_flows/br.com.wgc.design_system.navigation/g' "$file"
done

echo "🔍 Buscando arquivos XML..."
XML_FILES=$(find . -name "*.xml" -type f)
echo "Encontrados: $(echo "$XML_FILES" | wc -l) arquivos XML"

echo "🔄 Migrando namespaces em arquivos XML..."
for file in $XML_FILES; do
    sed -i 's/br\.com\.wgc\.core_ds/br.com.wgc.design_system.core/g' "$file"
    sed -i 's/br\.com\.wgc\.ds_templates/br.com.wgc.design_system.templates/g' "$file"
    sed -i 's/br\.com\.wgc\.ds_navigation_flows/br.com.wgc.design_system.navigation/g' "$file"
done

echo "🔍 Buscando arquivos Gradle..."
GRADLE_FILES=$(find . -name "*.gradle*" -type f)
echo "Encontrados: $(echo "$GRADLE_FILES" | wc -l) arquivos Gradle"

echo "🔄 Migrando namespaces em arquivos Gradle..."
for file in $GRADLE_FILES; do
    sed -i 's/br\.com\.wgc\.core_ds/br.com.wgc.design_system.core/g' "$file"
    sed -i 's/br\.com\.wgc\.ds_templates/br.com.wgc.design_system.templates/g' "$file"
    sed -i 's/br\.com\.wgc\.ds_navigation_flows/br.com.wgc.design_system.navigation/g' "$file"
done

echo "✅ Migração concluída!"
echo ""
echo "📝 Próximos passos:"
echo "1. Revise as mudanças com: git diff"
echo "2. Execute os testes: ./gradlew test"
echo "3. Compile o projeto: ./gradlew build"
echo "4. Se tudo estiver correto, commit as mudanças"
echo ""
echo "📦 Backup disponível em: backup-$(date +%Y%m%d-%H%M%S)/"