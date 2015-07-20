package musician101.mcdnd.util;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

public interface IAreaOfEffect
{
	/** Needs to consider diagonals and the choice to include point of origin */
	@Deprecated
	List<BlockPos> getArea(Entity entity);
}
