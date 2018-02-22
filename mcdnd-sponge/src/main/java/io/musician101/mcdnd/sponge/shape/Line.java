package io.musician101.mcdnd.sponge.shape;

import com.flowpowered.math.vector.Vector3d;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class Line extends Shape {

    final int length;
    final int width;

    public Line(int length, int width) {
        super("Line", "A line extends from its point of origin in a straight path up to its length and covers an area defined by its width.", "A line's point of origin is not included in the line's area of effect, unless you decide otherwise.");
        this.length = length;
        this.width = width;
    }

    //TODO include diagonals?
    @Override
    public List<Location<World>> getArea(Direction direction, Location<World> location) {
        List<Location<World>> locations = new ArrayList<>();
        Vector3d directionVector = direction.toVector3d();
        Vector3d startPosition = location.getPosition().clone().add(directionVector);
        World world = location.getExtent();
        for (int x = 1; x < length / 5; x++) {
            Vector3d middle = startPosition.clone().add(directionVector.clone().mul(x));
            locations.add(new Location<>(world, middle));
            for (int y = 1; y < width; y++) {
                if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(y))));
                }
                else if (direction == Direction.WEST || direction == Direction.EAST) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(y))));
                }
                else if (direction == Direction.UP || direction == Direction.DOWN) {
                    locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                    locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
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
        return DataContainer.createNew().set(MCDNDKeys.LENGTH, length).set(MCDNDKeys.WIDTH, width);
    }
}
