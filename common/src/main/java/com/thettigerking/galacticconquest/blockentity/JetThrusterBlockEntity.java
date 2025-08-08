/*package com.thettigerking.galacticconquest.blockentity;

import kotlin.jvm.Volatile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.api.world.properties.DimensionId;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.blockentity.DebugPhysicsTickables;
import org.valkyrienskies.mod.common.dimensionId;
import org.valkyrienskies.mod.common.util.DimensionIdProvider;
import org.valkyrienskies.mod.common.util.ITestTickable;

public class TestThrusterBlockEntity extends BlockEntity implements ITestTickable {
    private boolean added = false;

    @Volatile
    private boolean isActive = false;

    @Volatile
    private long shipMountedTo = -1L;

    public TestThrusterBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ValkyrienSkiesMod.TEST_THRUSTER_BLOCK_ENTITY_TYPE, blockPos, blockState);
    }

    public Direction getFacing() {
        return getBlockState().getValue(BlockStateProperties.FACING);
    }

    public BlockPos getPos() {
        return worldPosition;
    }

    @Override
    public void setRemoved() {
        DebugPhysicsTickables.remove(this); //(this);
        super.setRemoved();
    }

    @Override
    public boolean matchesDimension(DimensionIdProvider dimensionId) {
        return level != null && level.dimension().equals(dimensionId); // .dimensionId.equals(dimensionId);
    }

    @VsBeta
    @Override
    public void physTick(PhysLevel physLevel, double delta) {
        if (!isActive || shipMountedTo < 0) {
            return;
        }
        Ship ship = physLevel.getShipById(shipMountedTo);
        if (ship == null) {
            return;
            ship.f(
                    this.getFacing().getNormal().multiply(50000));
            this.getPos().offset(1, 1, 1).subtract((Vec3i) ship.getTransform().getPositionInShip());
        }

        public boolean matchesDimension (String s){
            return false;
        }
    }

    @Override
    public boolean matchesDimension(@NotNull String s) {
        return false;
    }
}*/