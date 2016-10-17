package io.musician101.mcdnd.sponge.magic;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class SpellComponents implements DataSerializable
{
    private final boolean isVerbal;
    private final boolean isSomatic;
    private final String materials;

    private SpellComponents()
    {
        this(false, false, "");
    }

    private SpellComponents(boolean isVerbal, boolean isSomatic)
    {
        this(isVerbal, isSomatic, "");
    }

    private SpellComponents(boolean isVerbal, boolean isSomatic, String materials)
    {
        this.isVerbal = isVerbal;
        this.isSomatic = isSomatic;
        this.materials = materials;
    }

    public boolean isSomatic()
    {
        return isSomatic;
    }

    public boolean isVerbal()
    {
        return isVerbal;
    }

    public String getMaterials()
    {
        return materials;
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
                .set(MCDNDKeys.IS_VERBAL, isVerbal)
                .set(MCDNDKeys.IS_SOMATIC, isSomatic)
                .set(MCDNDKeys.MATERIALS, materials);
    }

    public static SpellComponents of()
    {
        return new SpellComponents();
    }

    public static SpellComponents of(boolean isVerbal, boolean isSomatic)
    {
        return new SpellComponents(isVerbal, isSomatic);
    }

    public static SpellComponents of(boolean isVerbal, boolean isSomatic, String materials)
    {
        return new SpellComponents(isVerbal, isSomatic, materials);
    }
}
