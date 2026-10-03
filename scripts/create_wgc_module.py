#!/usr/bin/env python3
"""
WGC Design System - Component & Template Scaffold CLI (Passo 99)
Generates compliant Jetpack Compose components adhering to AGENTS.md rules.
"""

import sys
import os

TEMPLATE = """package br.com.wgc.design_system.components.{package_name}

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * {component_name}
 *
 * Componente oficial do WGC Design System.
 */
@Composable
fun {component_name}(
    text: String,
    modifier: Modifier = Modifier,
    actionSlot: (@Composable () -> Unit)? = null
) {{
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md.dp)
    ) {{
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        actionSlot?.invoke()
    }}
}}

@Preview(name = "{component_name} Preview", showBackground = true)
@Composable
private fun {component_name}Preview() {{
    {component_name}(text = "Exemplo de {component_name}")
}}
"""

def create_component(name):
    if not name.startswith("Wgc"):
        name = "Wgc" + name
    package_name = name[3:].lower()
    content = TEMPLATE.format(component_name=name, package_name=package_name)
    target_dir = os.path.join(os.path.dirname(__file__), "..", "components", "src", "main", "java", "br", "com", "wgc", "design_system", "components", package_name)
    os.makedirs(target_dir, exist_ok=True)
    target_file = os.path.join(target_dir, f"{name}.kt")
    with open(target_file, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"[OK] Componente {name} gerado em {target_file}")

if __name__ == "__main__":
    comp_name = sys.argv[1] if len(sys.argv) > 1 else "WgcCustomWidget"
    create_component(comp_name)
