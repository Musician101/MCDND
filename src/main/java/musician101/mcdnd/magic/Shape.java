package musician101.mcdnd.magic;

import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.EffectsArea;
import musician101.mcdnd.util.Interfaces.Named;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
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
        public List<BlockPos> getArea(Entity entity)
        {
            BlockPos pos = entity.getPosition();
            List<BlockPos> list = new ArrayList<>();
            int x = pos.getX();
            int z = pos.getZ();
            //TODO doesn't take diagonals into consideration
            EnumFacing dir = EnumFacing.fromAngle(entity.rotationPitch);
            if (dir == EnumFacing.NORTH)
                z = -1;
            else if (dir == EnumFacing.SOUTH)
                z = +1;
            else if (dir == EnumFacing.WEST)
                x = -1;
            else if (dir == EnumFacing.EAST)
                x = +1;

            list.add(new BlockPos(x, pos.getY(), z));

            for (int i = 1; i < 2; i++)
            {
                if (dir == EnumFacing.NORTH)
                {
                    z = -i;
                    list.add(new BlockPos(x - 1, pos.getY(), z));
                    list.add(new BlockPos(x, pos.getY(), z));
                    list.add(new BlockPos(x + 1, pos.getY(), z));
                }
                else if (dir == EnumFacing.SOUTH)
                {
                    z = +i;
                    list.add(new BlockPos(x - 1, pos.getY(), z));
                    list.add(new BlockPos(x, pos.getY(), z));
                    list.add(new BlockPos(x + 1, pos.getY(), z));
                }
                else if (dir == EnumFacing.WEST)
                {
                    x = -i;
                    list.add(new BlockPos(x, pos.getY(), z - 1));
                    list.add(new BlockPos(x, pos.getY(), z));
                    list.add(new BlockPos(x, pos.getY(), z + 1));
                }
                else if (dir == EnumFacing.EAST)
                {
                    x = +i;
                    list.add(new BlockPos(x, pos.getY(), z - 1));
                    list.add(new BlockPos(x, pos.getY(), z));
                    list.add(new BlockPos(x, pos.getY(), z + 1));
                }
            }

            return list;
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

        //TODO Might need to consider side lengths that are even
        @Override
        public List<BlockPos> getArea(Entity entity)
        {
            BlockPos pos = entity.getPosition();
            List<BlockPos> list = new ArrayList<>();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getY();
            return list;
        }
    }

    public static class Cylinder extends Shape
    {
        final int height;
        final int radius;

        public Cylinder(int radius, int height)
        {
            super("Cylinder", "A cylinder's point of origin is the center of a circle of a particular radius, as " +
                    "given in the spell description. The circle must either be on the ground or at the height of the " +
                    "spell effect. The energy in a cylinder expands in straight lines from the point of origin to the" +
                    " perimeter of the circle, forming the base of the cylinder. The spell's effect then shoots up " +
                    "from the base or down from the top, to a distance equal to the height of they cylinder.", "A " +
                    "cylinder's point of origin is included in the cylinder's area of effect.");
            this.radius = radius;
            this.height = height;
        }

        @Override
        public List<BlockPos> getArea(Entity entity)
        {
            // TODO Auto-generated method stub
            return null;
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

        @Override
        public List<BlockPos> getArea(Entity entity)
        {
            // TODO Auto-generated method stub
            return null;
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
        public List<BlockPos> getArea(Entity entity)
        {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
