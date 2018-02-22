package io.musician101.mcdnd.sponge.data.type;

import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(WeaponTypes.class)
public class WeaponType extends MCDNDCatalogType {

    public WeaponType(String name) {
        super(name);
    }
}
