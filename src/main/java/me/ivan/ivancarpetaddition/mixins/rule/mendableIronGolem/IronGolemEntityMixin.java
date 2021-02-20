package me.ivan.ivancarpetaddition.mixins.rule.mendableIronGolem;

import me.ivan.ivancarpetaddition.IvanCarpetAdditionSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(IronGolemEntity.class)
public class IronGolemEntityMixin extends GolemEntity {
    protected IronGolemEntityMixin(EntityType<? extends GolemEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected boolean interactMob(PlayerEntity player, Hand hand) {
        if (IvanCarpetAdditionSettings.mendableIronGolem) {
            ItemStack itemStack = player.getStackInHand(hand);
            Item item = itemStack.getItem();
            if (item != Items.IRON_INGOT) {
                return false;
            } else {
                float f = this.getHealth();
                this.heal(25.0F);
                if (this.getHealth() == f) {
                    return false;
                } else {
                    float g = 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F;
                    this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0F, g);
                    if (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }

                    return true;
                }
            }
        }
        return false;
    }
}
