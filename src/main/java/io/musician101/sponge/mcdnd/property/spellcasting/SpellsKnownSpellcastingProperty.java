package io.musician101.sponge.mcdnd.property.spellcasting;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;

public class SpellsKnownSpellcastingProperty extends SpellcastingProperty
{
    private final Feature spellsKnown;

    public SpellsKnownSpellcastingProperty(Feature cantrips, Feature ritualCasting, Feature spellcastingAbility, Feature spellcastingFocus, Feature spellsKnown, Feature spellSlots, String... description)
    {
        super(cantrips, ritualCasting, spellcastingAbility, spellcastingFocus, spellSlots, description);
        this.spellsKnown = spellsKnown;
    }

    public Feature getSpellsKnown()
    {
        return spellsKnown;
    }
}
