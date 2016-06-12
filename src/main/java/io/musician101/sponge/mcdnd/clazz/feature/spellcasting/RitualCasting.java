package io.musician101.sponge.mcdnd.clazz.feature.spellcasting;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import org.spongepowered.api.data.MemoryDataContainer;

import java.util.Arrays;

public class RitualCasting extends Feature
{
    public RitualCasting(String... description)
    {
        super("Ritual Casting", 1, new MemoryDataContainer(), Arrays.asList(description));
    }
}
