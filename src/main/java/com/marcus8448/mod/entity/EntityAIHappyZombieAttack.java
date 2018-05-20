package com.marcus8448.mod.entity;

import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAIHappyZombieAttack extends EntityAIAttackMelee {
    private int raiseArmTicks;
    private EntityHappyZombie happyZombie;

    public EntityAIHappyZombieAttack(EntityHappyZombie zombieIn, double speedIn, boolean longMemoryIn) {
        super(zombieIn, speedIn, longMemoryIn);
        this.happyZombie = zombieIn;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        super.resetTask();
        this.happyZombie.setArmsRaised(false);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
            this.happyZombie.setArmsRaised(true);
        } else {
            this.happyZombie.setArmsRaised(false);
        }
    }
}