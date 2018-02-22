package io.musician101.mcdnd.sponge.shape;

import com.flowpowered.math.vector.Vector3d;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class Cone extends Shape {

    final int length;

    public Cone(int length) {
        super("Cone", "A cone extends in a direction you choose from its point of origin. A cone's width at a given point along its length is equal to that point's distance from the point of origin. A cone's area of effect specifies its maximum length.", "A cone's point of origin is not included in the cone's area of effect, unless you decide otherwise.");
        this.length = length;
    }

    @Override
    public List<Location<World>> getArea(Direction direction, Location<World> location) {
        Vector3d directionVector = direction.toVector3d();
        Vector3d startingLocation = location.getPosition().clone().add(directionVector);
        World world = location.getExtent();
        List<Location<World>> locations = Collections.singletonList(new Location<>(world, startingLocation));
        for (int x = 1; x < length / 5; x++) {
            Vector3d middle = startingLocation.clone().add(directionVector.clone().mul(x));
            locations.add(new Location<>(world, middle));
            for (int y = 0; y < x - 1; y++) {
                if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
                }
                else if (direction == Direction.NORTHEAST || direction == Direction.SOUTHWEST) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.SOUTHEAST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.NORTHWEST.toVector3d().mul(y))));
                }
                else if (direction == Direction.EAST || direction == Direction.WEST) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                }
                else if (direction == Direction.SOUTHEAST || direction == Direction.NORTHWEST) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.NORTHWEST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.SOUTHEAST.toVector3d().mul(y))));
                }
            }
        }
        return locations;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.LENGTH, length);
    }
}
