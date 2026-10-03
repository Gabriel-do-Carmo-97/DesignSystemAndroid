#!/usr/bin/env python3
"""
Compila capturas do Roborazzi em uma galeria HTML estática para documentação viva.
"""

import os
import glob

def build_gallery(images_dir="build/outputs/roborazzi", output_file="build/reports/screenshots_gallery.html"):
    os.makedirs(os.path.dirname(output_file), exist_ok=True)
    images = glob.glob(f"{images_dir}/*.png")
    
    html = """<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>WGC Design System - Galeria de Screenshots</title>
    <style>
        body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif; background: #0F172A; color: #F8FAFC; margin: 0; padding: 24px; }
        h1 { font-size: 24px; border-bottom: 2px solid #334155; padding-bottom: 12px; }
        .grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(280px, 1fr)); gap: 20px; margin-top: 24px; }
        .card { background: #1E293B; border-radius: 12px; padding: 16px; border: 1px solid #334155; }
        .card img { max-width: 100%; border-radius: 8px; border: 1px solid #475569; }
        .card p { font-size: 14px; font-weight: 600; margin: 12px 0 0 0; color: #94A3B8; word-break: break-all; }
    </style>
</head>
<body>
    <h1>🎨 WGC Design System — Visual Gallery</h1>
    <div class="grid">
"""
    for img in sorted(images):
        name = os.path.basename(img)
        html += f"""        <div class="card">
            <img src="{name}" alt="{name}">
            <p>{name}</p>
        </div>\n"""

    html += """    </div>
</body>
</html>"""

    with open(output_file, "w", encoding="utf-8") as f:
        f.write(html)
    print(f"Galeria de screenshots gerada com sucesso em: {output_file}")

if __name__ == "__main__":
    build_gallery()
