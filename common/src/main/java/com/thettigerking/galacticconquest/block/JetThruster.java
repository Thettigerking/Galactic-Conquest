package com.thettigerking.galacticconquest.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.valkyrienskies.mod.common.blockentity.DebugPhysicsTickables;
import org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity;
import org.valkyrienskies.mod.common.blockentity.TestThrusterBlockEntity;
import org.valkyrienskies.mod.common.getShipObjectManagingPos;

public class JetThruster extends DirectionalBlock implements EntityBlock {

    public static final BooleanProperty LIT = RedstoneLampBlock.LIT;

    public JetThruster(Properties properties) {
        super(properties.strength(10.0f, 1200.0f).sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState()
                .setValue(LIT, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos()))
                .setValue(FACING, blockPlaceContext.getPlayer() != null && blockPlaceContext.getPlayer().isCrouching()
                        ? blockPlaceContext.getNearestLookingDirection().getOpposite()
                        : blockPlaceContext.getHorizontalDirection());
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (!level.isClientSide()) {
            boolean bl2 = blockState.getValue(LIT);
            if (bl2 != level.hasNeighborSignal(blockPos)) {
                if (bl2) {
                    level.scheduleTick(blockPos, this, 4);
                } else {
                    level.setBlock(blockPos, blockState.cycle(LIT), 2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(LIT) && !serverLevel.hasNeighborSignal(blockPos)) {
            serverLevel.setBlock(blockPos, blockState.cycle(LIT), 2);
        }
        if (serverLevel.getBlockEntity(blockPos) instanceof TestThrusterBlockEntity blockEntity) {
            if (!blockEntity.added) {
                blockEntity.added = true;
                DebugPhysicsTickables.add(blockEntity);
            }
            blockEntity.isActive = blockState.getValue(LIT);
            blockEntity.shipMountedTo = serverLevel.getShipObjectManagingPos(blockPos) != null
                    ? serverLevel.getShipObjectManagingPos(blockPos).id
                    : -1L;
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TestThrusterBlockEntity(blockPos, blockState);
    }
}