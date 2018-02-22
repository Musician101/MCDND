package io.musician101.mcdnd.sponge.condition;

import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class Condition extends MCDNDBuildable {

    protected Condition(String name, DataContainer properties, List<String> description) {
        super(name, properties, description);
    }

    public static ConditionBuilder builder() {
        return Sponge.getRegistry().createBuilder(ConditionBuilder.class);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
