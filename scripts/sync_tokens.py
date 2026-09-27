#!/usr/bin/env python3
"""
Figma Token Sync Automation Script
===================================
Este script converte definições de tokens de design exportadas do Figma
(Tokens Studio ou Figma Variables JSON) para classes e objetos Kotlin do WGC Design System (:core).

Uso:
    python scripts/sync_tokens.py --input tokens.json --output core/src/main/java/br/com/wgc/design_system/core/
"""

import json
import os
import sys
import argparse

def parse_color_token(token_val):
    if isinstance(token_val, str) and token_val.startswith("#"):
        clean_hex = token_val.lstrip("#")
        if len(clean_hex) == 6:
            return f"0xFF{clean_hex.upper()}L"
        elif len(clean_hex) == 8:
            return f"0x{clean_hex.upper()}L"
    return None

def generate_kotlin_colors(tokens_data):
    lines = [
        "package br.com.wgc.design_system.core.colors",
        "",
        "/**",
        " * Tokens de Cores gerados automaticamente via scripts/sync_tokens.py",
        " * ORIGEM: Figma Tokens Studio / Figma Variables",
        " */",
        "object WgcCoreDsGeneratedColors {"
    ]
    
    if "colors" in tokens_data:
        for name, value in sorted(tokens_data["colors"].items()):
            hex_val = parse_color_token(value.get("value", value) if isinstance(value, dict) else value)
            if hex_val:
                safe_name = name.replace("-", "_").replace(" ", "_")
                lines.append(f"    const val {safe_name}: Long = {hex_val}")
                
    lines.append("}")
    lines.append("")
    return "\n".join(lines)

def main():
    parser = argparse.ArgumentParser(description="Sincronizador de Tokens Figma para Kotlin")
    parser.add_argument("--input", default="tokens.json", help="Arquivo JSON de entrada exportado do Figma")
    parser.add_argument("--output", default="core/src/main/java/br/com/wgc/design_system/core/", help="Diretório de saída Kotlin")
    parser.add_argument("--dry-run", action="store_true", help="Apenas simula a conversão sem gravar arquivos")
    
    args = parser.parse_args()
    
    if not os.path.exists(args.input):
        print(f"[INFO] Arquivo {args.input} não encontrado. Gerando template padrão de sincronização...")
        template_data = {
            "colors": {
                "wgc_primary_500": {"value": "#0D47A1"},
                "wgc_secondary_500": {"value": "#1ABC9C"},
                "wgc_success_500": {"value": "#2ECC71"},
                "wgc_error_500": {"value": "#E74C3C"},
                "wgc_warning_500": {"value": "#F39C12"}
            },
            "spacing": {
                "xs8": {"value": 8},
                "md16": {"value": 16},
                "lg24": {"value": 24}
            }
        }
        with open(args.input, "w", encoding="utf-8") as f:
            json.dump(template_data, f, indent=2)
        print(f"[SUCCESS] Template criado em {args.input}")
    
    with open(args.input, "r", encoding="utf-8") as f:
        data = json.load(f)
        
    kt_code = generate_kotlin_colors(data)
    
    if args.dry_run:
        print("[DRY-RUN] Código Kotlin gerado:")
        print(kt_code)
    else:
        out_file = os.path.join(args.output, "colors", "WgcCoreDsGeneratedColors.kt")
        os.makedirs(os.path.dirname(out_file), exist_ok=True)
        with open(out_file, "w", encoding="utf-8") as f:
            f.write(kt_code)
        print(f"[SUCCESS] Tokens sincronizados com sucesso em: {out_file}")

if __name__ == "__main__":
    main()
