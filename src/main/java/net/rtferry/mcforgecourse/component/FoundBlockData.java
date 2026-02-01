package net.rtferry.mcforgecourse.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class FoundBlockData {
    private final BlockState block;
    private final BlockPos position;

    public static final Codec<FoundBlockData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(BlockState.CODEC.fieldOf("block").forGetter(FoundBlockData::getBlock),
                    BlockPos.CODEC.fieldOf("position").forGetter(FoundBlockData::getPosition)).apply(instance, FoundBlockData::new));

    public FoundBlockData(BlockState block, BlockPos position) {
        this.block = block;
        this.position = position;
    }

    public BlockState getBlock() {
        return block;
    }

    public BlockPos getPosition() {
        return position;
    }

    public String getOutputString() {
        return block.getBlock().getName().getString() + " at " + "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.block,this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        } else {
            return obj instanceof FoundBlockData fbd && this.block == fbd.block && this.position == fbd.position;
        }
    }
}
