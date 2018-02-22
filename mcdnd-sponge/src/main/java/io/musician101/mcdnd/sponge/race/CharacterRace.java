package io.musician101.mcdnd.sponge.race;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.MCDNDCatalogType;
import io.musician101.mcdnd.sponge.race.trait.Trait;
import io.musician101.mcdnd.sponge.util.Interfaces.Listed;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(CharacterRaces.class)
public class CharacterRace extends MCDNDCatalogType implements DataSerializable, Listed<Trait> {

    private final List<Trait> traits;

    public CharacterRace(String name, List<Trait> traits) {
        super(name);
        this.traits = traits;
    }

    @Override
    public Trait get(int index) {
        return traits.get(index);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public List<Trait> getList() {
        return traits;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.NAME, name).set(MCDNDKeys.TRAITS, traits);
    }
}
