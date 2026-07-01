package com.example.serverinfo;

import net.fabricmc.api.ClientModInitializer;

public class ServerInfoMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[ServerInfo] Loaded! Nhan !server trong chat.");
    }
}
