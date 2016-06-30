package io.musician101.sponge.mcdnd.property.spellcasting;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.property.MCDNDProperty;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class SpellcastingProperty extends MCDNDProperty implements Described
{
    private final Feature cantrips;
    private final List<String> description;
    private final Feature ritualCasting;
    private final Feature spellcastingAbility;
    private final Feature spellcastingFocus;
    private final Feature spellSlots;

    public SpellcastingProperty(Feature cantrips, Feature ritualCasting, Feature spellcastingAbility, Feature spellcastingFocus, Feature spellSlots, String... description)
    {
        super();
        this.cantrips = cantrips;
        this.spellSlots = spellSlots;
        this.spellcastingAbility = spellcastingAbility;
        this.ritualCasting = ritualCasting;
        this.spellcastingFocus = spellcastingFocus;
        this.description = Arrays.asList(description);
    }

    public Feature getCantrips()
    {
        return cantrips;
    }

    public Feature getRitualCasting()
    {
        return ritualCasting;
    }

    public Feature getSpellcastingAbility()
    {
        return spellcastingAbility;
    }

    public Feature getSpellcastingFocus()
    {
        return spellcastingFocus;
    }

    public Feature getSpellSlots()
    {
        return spellSlots;
    }

    @Override
    public List<String> getDescription()
    {
        return description;
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
                .set(MCDNDKeys.CANTRIPS, cantrips)
                .set(MCDNDKeys.RITUAL_CASTING, ritualCasting)
                .set(MCDNDKeys.SPELLCASTING_ABILITY, spellcastingAbility)
                .set(MCDNDKeys.SPELLCASTING_FOCUS, spellcastingFocus)
                .set(MCDNDKeys.SPELL_SLOTS, spellSlots);
    }
}
