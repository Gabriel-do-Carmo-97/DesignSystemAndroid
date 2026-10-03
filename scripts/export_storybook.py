#!/usr/bin/env python3
"""
WGC Design System - Storybook / Catalog Exporter (Passo 87)
Exports an interactive HTML catalog of all Design System components.
"""

import os

def generate_catalog():
    output_dir = os.path.join(os.path.dirname(__file__), "..", "build", "catalog")
    os.makedirs(output_dir, exist_ok=True)
    html_file = os.path.join(output_dir, "index.html")

    html = """<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>WGC Design System - Catálogo Interativo</title>
    <style>
        body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; margin: 0; padding: 2rem; background: #f8f9fa; }
        h1 { color: #0D47A1; }
        .grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(280px, 1fr)); gap: 1.5rem; margin-top: 2rem; }
        .card { background: white; padding: 1.5rem; border-radius: 12px; box-shadow: 0 2px 8px rgba(0,0,0,0.08); border-left: 4px solid #0D47A1; }
        .tag { display: inline-block; background: #e3f2fd; color: #0D47A1; padding: 0.2rem 0.6rem; border-radius: 20px; font-size: 0.8rem; font-weight: 600; margin-bottom: 0.5rem; }
    </style>
</head>
<body>
    <h1>🎨 WGC Design System - Catálogo de Componentes</h1>
    <p>Guia de referência para engenheiros e designers do ecossistema WGC.</p>
    <div class="grid">
        <div class="card"><span class="tag">:core</span><h3>Tokens & Cores</h3><p>Tokens de espaçamento, tipografia, elevação, motion e temas whitelabel.</p></div>
        <div class="card"><span class="tag">:components</span><h3>Buttons & Inputs</h3><p>WgcClassicButton, WgcPhoneNumberInput, WgcCurrencyInput, WgcCreditCardInput.</p></div>
        <div class="card"><span class="tag">:components</span><h3>Microinterações & Overlays</h3><p>WgcBottomSheet, WgcSwipeableCard, WgcSegmentedControl, WgcProgressDial.</p></div>
        <div class="card"><span class="tag">:templates</span><h3>Templates de Negócio</h3><p>Auth, Extrato Pix, Checkout, Perfil, Central de Ajuda e Notificações.</p></div>
        <div class="card"><span class="tag">:navigation-flows</span><h3>Fluxos Type-Safe</h3><p>Grafos desacoplados com Kotlinx Serialization e Route Guards.</p></div>
    </div>
</body>
</html>"""

    with open(html_file, "w", encoding="utf-8") as f:
        f.write(html)
    print(f"[OK] Catálogo Storybook gerado em {html_file}")

if __name__ == "__main__":
    generate_catalog()
