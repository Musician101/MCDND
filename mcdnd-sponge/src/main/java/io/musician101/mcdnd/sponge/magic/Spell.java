package io.musician101.mcdnd.sponge.magic;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.spell.SpellLevel;
import io.musician101.mcdnd.sponge.data.type.spell.SpellType;
import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class Spell extends MCDNDBuildable {

    private final double castingTime;
    private final boolean isRitual;
    private final int range;
    private final SpellComponents spellComponents;
    private final SpellDuration spellDuration;
    private final SpellLevel spellLevel;
    private final SpellType spellType;

    protected Spell(String name, List<String> description, boolean isRitual, DataContainer properties, double castingTime, int range, SpellComponents spellComponents, SpellDuration spellDuration, SpellLevel spellLevel, SpellType spellType) {
        super(name, properties, description);
        this.isRitual = isRitual;
        this.castingTime = castingTime;
        this.range = range;
        this.spellComponents = spellComponents;
        this.spellDuration = spellDuration;
        this.spellLevel = spellLevel;
        this.spellType = spellType;
    }

    public static SpellBuilder builder() {
        return Sponge.getRegistry().createBuilder(SpellBuilder.class);
    }

    public double getCastingTime() {
        return castingTime;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public int getRange() {
        return range;
    }

    public SpellComponents getSpellComponents() {
        return spellComponents;
    }

    public SpellDuration getSpellDuration() {
        return spellDuration;
    }

    public SpellLevel getSpellLevel() {
        return spellLevel;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public boolean isRitual() {
        return isRitual;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.IS_RITUAL, isRitual).set(MCDNDKeys.CASTING_TIME, castingTime).set(MCDNDKeys.RANGE, range).set(MCDNDKeys.SPELL_COMPONENTS, spellComponents).set(MCDNDKeys.SPELL_DURATION, spellDuration).set(MCDNDKeys.SPELL_LEVEL, spellLevel).set(MCDNDKeys.SPELL_TYPE, spellType);
    }
}
