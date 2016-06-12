package io.musician101.sponge.mcdnd.race;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.MCDNDCatalogType;
import io.musician101.sponge.mcdnd.race.trait.Trait;
import io.musician101.sponge.mcdnd.util.Interfaces.Listed;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.util.annotation.CatalogedBy;

import javax.annotation.Nonnull;
import java.util.List;

@CatalogedBy(CharacterRaces.class)
public class CharacterRace extends MCDNDCatalogType implements DataSerializable, Listed<Trait>
{
    private final List<Trait> traits;

    public CharacterRace(String name, List<Trait> traits)
    {
        super(name);
        this.traits = traits;
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
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.TRAITS, traits);
    }

    @Override
    public List<Trait> getList()
    {
        return traits;
    }

    @Override
    public Trait get(int index)
    {
        return traits.get(index);
    }
}
