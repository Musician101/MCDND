package io.musician101.mcdnd.sponge.clazz.feature.subclass.primalpaths.totem;

import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import java.util.Arrays;
import java.util.List;

public class Totem implements Described, Named {

    private final List<String> description;
    private final String name;

    protected Totem(String name, String... description) {
        this.name = name;
        this.description = Arrays.asList(description);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    public static class BearTotem extends Totem {

        public BearTotem(String description) {
            super("Bear", description);
        }
    }

    public static class EagleTotem extends Totem {

        public EagleTotem(String description) {
            super("Eagle", description);
        }
    }

    public static class WolfTotem extends Totem {

        public WolfTotem(String description) {
            super("Wolf", description);
        }
    }
}
