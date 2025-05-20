package com.under.ceaseless.content.entity;

import com.under.ceaseless.content.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SandmiteEntity extends HostileEntity {

    public SandmiteEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createSandmiteAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 30.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.ARMOR, 2.0)
                .add(EntityAttributes.ATTACK_KNOCKBACK, 0.5)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERMITE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDERMITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMITE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_ENDERMITE_STEP, 0.15F, 1.0F);
    }

    @Override
    public void tick() {
        this.bodyYaw = this.getYaw();
        super.tick();
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        this.setYaw(bodyYaw);
        super.setBodyYaw(bodyYaw);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.getWorld().isClient) {
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(
                        ParticleTypes.PORTAL,
                        this.getParticleX(0.5),
                        this.getRandomBodyY(),
                        this.getParticleZ(0.5),
                        (this.random.nextDouble() - 0.5) * 2.0,
                        -this.random.nextDouble(),
                        (this.random.nextDouble() - 0.5) * 2.0
                );
            }
        }
    }

    public static boolean canSandmiteSpawn(EntityType<SandmiteEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (!HostileEntity.canSpawnIgnoreLightLevel(type, world, spawnReason, pos, random)) {
            return false;
        } else if (SpawnReason.isAnySpawner(spawnReason)) {
            return true;
        } else {
            BlockPos blockBelow = pos.down();
            BlockState blockStateBelow = world.getBlockState(blockBelow);

            if (!blockStateBelow.isSolidBlock(world, blockBelow)) {
                return false;
            }

            PlayerEntity player = world.getClosestPlayer(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5.0, true);
            return player == null;
        }
    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean attacked = super.tryAttack(world, target);
        if (attacked && target instanceof LivingEntity livingTarget) {
            if (this.random.nextFloat() < 0.25f) {
                livingTarget.addStatusEffect(new StatusEffectInstance(
                        ModEffects.PURPLEXED,
                        random.nextInt(200) + 100,
                        0
                ));
            }
        }
        return attacked;
    }
}