package io.musician101.mcdnd.sponge.shape;

import com.flowpowered.math.vector.Vector3d;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Cylinder extends Shape
{
    final int height;
    final int radius;

    public Cylinder(int radius, int height)
    {
        super("Cylinder", "A cylinder's point of origin is the center of a circle of a particular radius, as given in the spell description. The circle must either be on the ground or at the height of the spell effect. The energy in a cylinder expands in straight lines from the point of origin to the perimeter of the circle, forming the base of the cylinder. The spell's effect then shoots up from the base or down from the top, to a distance equal to the height of they cylinder.", "A cylinder's point of origin is included in the cylinder's area of effect.");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public List<Location<World>> getArea(Direction direction, Location<World> location)
    {
        List<Location<World>> locations = new ArrayList<>();
        Vector3d directionVector = direction.toVector3d();
        Vector3d startingLocation = location.getPosition();
        World world = location.getExtent();
        for (int h = 1; h < height / 5; h++)
        {
            Vector3d middle = startingLocation.clone().add(directionVector.mul(h - 1));
            locations.add(new Location<>(world, middle));
            int xCenter = startingLocation.getFloorX();
            for (int x = xCenter - radius; x <= xCenter; x++)
            {
                int zCenter = startingLocation.getFloorZ();
                for (int z = zCenter - radius; z <= zCenter; z++)
                    if (((x - xCenter)^2 + (z - zCenter)^2) <= (radius^2))
                        locations.add(new Location<>(world, xCenter - (x - xCenter), middle.getY(), zCenter - (z - zCenter)));
            }
        }

        return locations;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.HEIGHT, height)
                .set(MCDNDKeys.RADIUS, radius);
    }
}
