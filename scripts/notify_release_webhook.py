#!/usr/bin/env python3
"""
Notificação de Release via Webhook (Slack / Discord / Microsoft Teams).
"""

import os
import sys
import json
import urllib.request

def send_notification(version="v1.0.0", changelog="Novos componentes e correções gerais."):
    webhook_url = os.environ.get("RELEASE_WEBHOOK_URL")
    if not webhook_url:
        print("⚠️ RELEASE_WEBHOOK_URL não definida no ambiente. Notificação pulada localmente.")
        return 0

    payload = {
        "text": f"🚀 *WGC Design System {version} Publicado!*\n\n{changelog}\n\nArtefatos disponíveis no GitHub Packages."
    }

    req = urllib.request.Request(
        webhook_url,
        data=json.dumps(payload).encode("utf-8"),
        headers={"Content-Type": "application/json"}
    )

    try:
        with urllib.request.urlopen(req) as response:
            if response.status == 200:
                print("✅ Notificação de release enviada com sucesso ao canal corporativo!")
                return 0
    except Exception as e:
        print(f"❌ Erro ao enviar webhook: {e}")
        return 1

if __name__ == "__main__":
    version = sys.argv[1] if len(sys.argv) > 1 else "v1.0.0"
    send_notification(version)
