package io.musician101.mcdnd.sponge.shape;

import com.flowpowered.math.vector.Vector3d;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class Sphere extends Shape
{
    final int radius;

    public Sphere(int radius)
    {
        super("Sphere", "You select a sphere's point of origin, and the sphere extends outward from that point. The sphere's size is expressed as a radius in feet that extends from the point.", "A sphere's point of origin is included in the sphere's are of effect.");
        this.radius = radius;
    }

    @Override
    public List<Location<World>> getArea(Direction direction, Location<World> location)
    {
        World world = location.getExtent();
        Vector3d startingLocation = location.getPosition();
        List<Location<World>> locations = Collections.singletonList(new Location<>(world, startingLocation));
        int xCenter = startingLocation.getFloorX();
        for (int x = xCenter - radius; x <= xCenter; x++)
        {
            int yCenter = startingLocation.getFloorY();
            for (int y = yCenter - radius; y <= yCenter; y++)
            {
                int zCenter = startingLocation.getFloorZ();
                for (int z = zCenter - radius; z <= zCenter; z++)
                    if (((x - xCenter)^2 + (z - zCenter)^2) <= (radius^2))
                        locations.add(new Location<>(world, xCenter - (x - xCenter), yCenter - (y - yCenter), zCenter - (z - zCenter)));
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
                .set(MCDNDKeys.RADIUS, radius);
    }
}
