package com.example.serverinfo.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ServerInfoMixin {

    private static final String CMD = "!server";

    @Inject(
        method = "sendChatMessage(Ljava/lang/String;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onSendChat(String message, CallbackInfo ci) {
        if (!message.equalsIgnoreCase(CMD)) return;
        ci.cancel();

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler handler = (ClientPlayNetworkHandler)(Object)this;
        ClientWorld world = client.world;

        ServerInfo serverInfo = client.getCurrentServerEntry();
        String ip      = serverInfo != null ? serverInfo.address : "Single Player";
        String name    = serverInfo != null ? serverInfo.name : "Single Player";
        String version = client.getGameVersion();
        String motd    = serverInfo != null && serverInfo.label != null
                         ? serverInfo.label.getString() : "N/A";
        int ping       = serverInfo != null ? (int) serverInfo.ping : 0;

        String dimension = "N/A";
        int playerCount  = 0;
        long time        = 0;

        if (world != null) {
            dimension   = world.getRegistryKey().getValue().toString();
            playerCount = world.getPlayers().size();
            time        = world.getTime();
        }

        int fps = client.getCurrentFps();

        handler.sendChatMessage("--- Server Info ---");
        handler.sendChatMessage("Name: " + name);
        handler.sendChatMessage("IP: " + ip);
        handler.sendChatMessage("MOTD: " + motd);
        handler.sendChatMessage("Ping: " + ping + "ms");
        handler.sendChatMessage("Version: " + version);
        handler.sendChatMessage("Dimension: " + dimension);
        handler.sendChatMessage("Players: " + playerCount);
        handler.sendChatMessage("Time: " + time);
        handler.sendChatMessage("FPS: " + fps);
        handler.sendChatMessage("-------------------");
    }
}
