package com.example.serverinfo;

import net.fabricmc.api.ClientModInitializer;

public class ServerInfoMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[ServerInfo] Mod loaded! Nhan !server de xem thong tin.");
    }
}
mixin/ServerInfoMixin.java
