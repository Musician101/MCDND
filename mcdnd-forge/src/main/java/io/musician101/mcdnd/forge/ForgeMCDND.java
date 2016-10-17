package io.musician101.mcdnd.forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = ForgeMCDND.MOD_ID,
        name = ForgeMCDND.MOD_NAME,
        version = ForgeMCDND.VERSION
)
public class ForgeMCDND
{

    public static final String MOD_ID = "mcdnd";
    public static final String MOD_NAME = "Mcdnd";
    public static final String VERSION = "ALPHA-1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
