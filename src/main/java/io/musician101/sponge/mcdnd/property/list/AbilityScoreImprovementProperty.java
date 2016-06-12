package io.musician101.sponge.mcdnd.property.list;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class AbilityScoreImprovementProperty extends ListProperty<Integer>
{
    public AbilityScoreImprovementProperty()
    {
        super(Arrays.asList(4, 8, 12, 16, 19));
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
                .set(MCDNDKeys.INTEGER_LIST, list);
    }
}
