# Script de Migração de Namespace para Design System WGC (PowerShell)
# Este script ajuda a migrar automaticamente os namespaces para o novo padrão

Write-Host "🔄 Iniciando migração de namespace..." -ForegroundColor Cyan
Write-Host "⚠️  Este script modificará arquivos no seu projeto" -ForegroundColor Yellow
Write-Host ""

$confirmation = Read-Host "Deseja continuar? (y/n)"
if ($confirmation -ne "y" -and $confirmation -ne "Y") {
    Write-Host "❌ Migração cancelada" -ForegroundColor Red
    exit 1
}

$backupDir = "backup-$(Get-Date -Format 'yyyyMMdd-HHmmss')"
Write-Host "📋 Backup criado em: $backupDir" -ForegroundColor Green
New-Item -ItemType Directory -Force -Path $backupDir | Out-Null
Copy-Item -Recurse -Force . "$backupDir/"

Write-Host "🔍 Buscando arquivos Kotlin..." -ForegroundColor Cyan
$ktFiles = Get-ChildItem -Recurse -Filter "*.kt" -File
Write-Host "Encontrados: $($ktFiles.Count) arquivos Kotlin" -ForegroundColor Green

Write-Host "🔄 Migrando namespaces em arquivos Kotlin..." -ForegroundColor Cyan
foreach ($file in $ktFiles) {
    $content = Get-Content $file.FullName -Raw
    $content = $content -replace 'br\.com\.wgc\.core_ds', 'br.com.wgc.design_system.core'
    $content = $content -replace 'br\.com\.wgc\.design_system\.', 'br.com.wgc.design_system.components.'
    $content = $content -replace 'br\.com\.wgc\.ds_templates', 'br.com.wgc.design_system.templates'
    $content = $content -replace 'br\.com\.wgc\.ds_navigation_flows', 'br.com.wgc.design_system.navigation'
    Set-Content $file.FullName $content -NoNewline
}

Write-Host "🔍 Buscando arquivos XML..." -ForegroundColor Cyan
$xmlFiles = Get-ChildItem -Recurse -Filter "*.xml" -File
Write-Host "Encontrados: $($xmlFiles.Count) arquivos XML" -ForegroundColor Green

Write-Host "🔄 Migrando namespaces em arquivos XML..." -ForegroundColor Cyan
foreach ($file in $xmlFiles) {
    $content = Get-Content $file.FullName -Raw
    $content = $content -replace 'br\.com\.wgc\.core_ds', 'br.com.wgc.design_system.core'
    $content = $content -replace 'br\.com\.wgc\.ds_templates', 'br.com.wgc.design_system.templates'
    $content = $content -replace 'br\.com\.wgc\.ds_navigation_flows', 'br.com.wgc.design_system.navigation'
    Set-Content $file.FullName $content -NoNewline
}

Write-Host "🔍 Buscando arquivos Gradle..." -ForegroundColor Cyan
$gradleFiles = Get-ChildItem -Recurse -Filter "*.gradle*" -File
Write-Host "Encontrados: $($gradleFiles.Count) arquivos Gradle" -ForegroundColor Green

Write-Host "🔄 Migrando namespaces em arquivos Gradle..." -ForegroundColor Cyan
foreach ($file in $gradleFiles) {
    $content = Get-Content $file.FullName -Raw
    $content = $content -replace 'br\.com\.wgc\.core_ds', 'br.com.wgc.design_system.core'
    $content = $content -replace 'br\.com\.wgc\.ds_templates', 'br.com.wgc.design_system.templates'
    $content = $content -replace 'br\.com\.wgc\.ds_navigation_flows', 'br.com.wgc.design_system.navigation'
    Set-Content $file.FullName $content -NoNewline
}

Write-Host "✅ Migração concluída!" -ForegroundColor Green
Write-Host ""
Write-Host "📝 Próximos passos:" -ForegroundColor Cyan
Write-Host "1. Revise as mudanças com: git diff"
Write-Host "2. Execute os testes: ./gradlew test"
Write-Host "3. Compile o projeto: ./gradlew build"
Write-Host "4. Se tudo estiver correto, commit as mudanças"
Write-Host ""
Write-Host "📦 Backup disponível em: $backupDir/" -ForegroundColor Green