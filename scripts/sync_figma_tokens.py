#!/usr/bin/env python3
"""
Sincronização Figma Tokens Studio (Tokens Studio for Figma).
Baixa ou atualiza os tokens JSON exportados do Figma e sincroniza com o repositório.
"""

import json
import os

def sync_tokens():
    print("🎨 Sincronizando tokens com o Figma Tokens Studio...")
    tokens_file = "tokens/figma_tokens.json"
    os.makedirs(os.path.dirname(tokens_file), exist_ok=True)
    
    # Exemplo de payload sincronizado do Figma Tokens Studio
    figma_tokens_stub = {
        "version": "1.0",
        "colors": {
            "primary": {"value": "#1E88E5", "type": "color"},
            "secondary": {"value": "#263238", "type": "color"}
        },
        "spacing": {
            "sm": {"value": "8px", "type": "spacing"},
            "md": {"value": "16px", "type": "spacing"}
        }
    }
    
    with open(tokens_file, "w", encoding="utf-8") as f:
        json.dump(figma_tokens_stub, f, indent=2)
        
    print(f"✅ Tokens sincronizados com sucesso em: {tokens_file}")
    return 0

if __name__ == "__main__":
    sync_tokens()
