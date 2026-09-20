# Script de Migracao de Namespace para Design System WGC (PowerShell)

param(
    [switch]$Force = $false
)

Write-Host "Iniciando migracao de namespace..."

# 1. Substituir referencias em arquivos Kotlin
Write-Host "Buscando arquivos Kotlin..."
$ktFiles = Get-ChildItem -Path @("core", "components", "templates", "navigation-flows", "app") -Recurse -Filter "*.kt" -File
Write-Host "Encontrados: $($ktFiles.Count) arquivos Kotlin"

Write-Host "Migrando namespaces em arquivos Kotlin..."
foreach ($file in $ktFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $original = $content
    $content = $content.Replace("br.com.wgc.core_ds", "br.com.wgc.design_system.core")
    $content = $content.Replace("br.com.wgc.ds_templates", "br.com.wgc.design_system.templates")
    $content = $content.Replace("br.com.wgc.ds_navigation_flows", "br.com.wgc.design_system.navigation")
    if ($content -ne $original) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
    }
}

# 2. Substituir referencias em arquivos XML
Write-Host "Buscando arquivos XML..."
$xmlFiles = Get-ChildItem -Path @("core", "components", "templates", "navigation-flows", "app") -Recurse -Filter "*.xml" -File
Write-Host "Encontrados: $($xmlFiles.Count) arquivos XML"

Write-Host "Migrando namespaces em arquivos XML..."
foreach ($file in $xmlFiles) {
    $content = [System.IO.File]::ReadAllText($file.FullName, [System.Text.Encoding]::UTF8)
    $original = $content
    $content = $content.Replace("br.com.wgc.core_ds", "br.com.wgc.design_system.core")
    $content = $content.Replace("br.com.wgc.ds_templates", "br.com.wgc.design_system.templates")
    $content = $content.Replace("br.com.wgc.ds_navigation_flows", "br.com.wgc.design_system.navigation")
    if ($content -ne $original) {
        [System.IO.File]::WriteAllText($file.FullName, $content, [System.Text.Encoding]::UTF8)
    }
}

# 3. Mover diretorios para refletir os novos packages
function Move-DirSafe($src, $dst) {
    if (Test-Path $src) {
        Write-Host "Movendo $src -> $dst"
        $parent = Split-Path -Parent $dst
        if (-not (Test-Path $parent)) {
            New-Item -ItemType Directory -Force -Path $parent | Out-Null
        }
        Move-Item -Path $src -Destination $dst -Force
    }
}

# Core
Move-DirSafe "core/src/main/java/br/com/wgc/core_ds" "core/src/main/java/br/com/wgc/design_system/core"
Move-DirSafe "core/src/test/java/br/com/wgc/core_ds" "core/src/test/java/br/com/wgc/design_system/core"
Move-DirSafe "core/src/androidTest/java/br/com/wgc/core_ds" "core/src/androidTest/java/br/com/wgc/design_system/core"

# Templates
Move-DirSafe "templates/src/main/java/br/com/wgc/ds_templates" "templates/src/main/java/br/com/wgc/design_system/templates"
Move-DirSafe "templates/src/test/java/br/com/wgc/ds_templates" "templates/src/test/java/br/com/wgc/design_system/templates"
Move-DirSafe "templates/src/androidTest/java/br/com/wgc/ds_templates" "templates/src/androidTest/java/br/com/wgc/design_system/templates"
Move-DirSafe "templates/src/screenshotTest/kotlin/br/com/wgc/ds_templates" "templates/src/screenshotTest/kotlin/br/com/wgc/design_system/templates"

# Navigation Flows
Move-DirSafe "navigation-flows/src/main/java/br/com/wgc/ds_navigation_flows" "navigation-flows/src/main/java/br/com/wgc/design_system/navigation"

Write-Host "Migracao concluida com sucesso!"