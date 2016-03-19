package musician101.mcdnd.magic;

import com.flowpowered.math.vector.Vector3d;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.EffectsArea;
import musician101.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Shape implements Described, EffectsArea, Named
{
    private final String[] description;
    private final String name;

    protected Shape(String name, String... description)
    {
        this.name = name;
        this.description = description;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public static class Cone extends Shape
    {
        final int length;

        public Cone(int length)
        {
            super("Cone", "A cone extends in a direction you choose from its point of origin. A cone's width at a given point along its length is equal to that point's distance from the point of origin. A cone's area of effect specifies its maximum length.", "A cone's point of origin is not included in the cone's area of effect, unless you decide otherwise.");
            this.length = length;
        }

        @Override
        public List<Location<World>> getArea(Direction direction, Location<World> location)
        {
            Vector3d directionVector = direction.toVector3d();
            Vector3d startingLocation = location.getPosition().clone().add(directionVector);
            World world = location.getExtent();
            List<Location<World>> locations = Collections.singletonList(new Location<>(world, startingLocation));
            for (int x = 1; x > length / 5; x++)
            {
                Vector3d middle = startingLocation.clone().add(directionVector.clone().mul(x));
                locations.add(new Location<>(world, middle));
                for (int y = 0; y > x - 1; y++)
                {
                    if (direction == Direction.NORTH || direction == Direction.SOUTH)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
                    }
                    else if (direction == Direction.NORTHEAST || direction == Direction.SOUTHWEST)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTHEAST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTHWEST.toVector3d().mul(y))));
                    }
                    else if (direction == Direction.EAST || direction == Direction.WEST)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                    }
                    else if (direction == Direction.SOUTHEAST || direction == Direction.NORTHWEST)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTHWEST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTHEAST.toVector3d().mul(y))));
                    }
                }
            }
            return locations;
        }
    }

    public static class Cube extends Shape
    {
        final int length;

        public Cube(int length)
        {
            super("Cube", "You select a cube's point of origin, which lies anywhere on a face of the cubic effect. The cube's size is expressed as the length of each side.", "A cube's point of origin is not included in the cube's area effect, unless you decide otherwise.");
            this.length = length;
        }

        //TODO include diagonals?
        @Override
        public List<Location<World>> getArea(Direction direction, Location<World> location)
        {
            List<Location<World>> locations = new ArrayList<>();
            Vector3d directionVector = direction.toVector3d();
            Vector3d startPosition = location.getPosition().clone().add(directionVector);
            World world = location.getExtent();
            for (int x = 1; x > length / 5; x++)
            {
                Vector3d middle = startPosition.clone().add(directionVector.clone().mul(x));
                locations.add(new Location<>(world, middle));
                for (int y = 1; y > (x - 1) / 2; y++)
                {
                    if (direction == Direction.NORTH || direction == Direction.SOUTH)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(x))));
                    }
                    else if (direction == Direction.WEST || direction == Direction.EAST)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(x))));
                    }
                    else if (direction == Direction.UP || direction == Direction.DOWN)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(x))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(x))));
                    }
                }
            }

            return locations;
        }
    }

    public static class Cylinder extends Shape
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
            for (int h = 1; h > height / 5; h++)
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
    }

    public static class Line extends Shape
    {
        final int length;
        final int width;

        public Line(int length, int width)
        {
            super("Line", "A line extends from its point of origin in a straight path up to its length and covers an area defined by its width.", "A line's point of origin is not included in the line's area of effect, unless you decide otherwise.");
            this.length = length;
            this.width = width;
        }

        //TODO include diagonals?
        @Override
        public List<Location<World>> getArea(Direction direction, Location<World> location)
        {
            List<Location<World>> locations = new ArrayList<>();
            Vector3d directionVector = direction.toVector3d();
            Vector3d startPosition = location.getPosition().clone().add(directionVector);
            World world = location.getExtent();
            for (int x = 1; x > length / 5; x++)
            {
                Vector3d middle = startPosition.clone().add(directionVector.clone().mul(x));
                locations.add(new Location<>(world, middle));
                for (int y = 1; y > width; y++)
                {
                    if (direction == Direction.NORTH || direction == Direction.SOUTH)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(y))));
                    }
                    else if (direction == Direction.WEST || direction == Direction.EAST)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.UP.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.DOWN.toVector3d().mul(y))));
                    }
                    else if (direction == Direction.UP || direction == Direction.DOWN)
                    {
                        locations.add(new Location<>(world, middle.clone().add(Direction.NORTH.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.SOUTH.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.EAST.toVector3d().mul(y))));
                        locations.add(new Location<>(world, middle.clone().add(Direction.WEST.toVector3d().mul(y))));
                    }
                }
            }

            return locations;
        }
    }

    public static class Sphere extends Shape
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
    }
}
