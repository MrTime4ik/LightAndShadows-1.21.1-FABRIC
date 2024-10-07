package ru.frameworkteam.lightandshadows.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.frameworkteam.lightandshadows.LightAndShadows;

@Mixin(ServerPlayerEntity.class)
public class DeathMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    private void onDeath(DamageSource source, CallbackInfo info) {
        LightAndShadows.LOGGER.info("You die!");
        System.out.println("You die!");
    }
}