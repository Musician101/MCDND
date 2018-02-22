package io.musician101.mcdnd.sponge.data.type;

import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(CurrencyTypes.class)
public class CurrencyType extends MCDNDCatalogType {

    public CurrencyType(String name) {
        super(name);
    }
}
