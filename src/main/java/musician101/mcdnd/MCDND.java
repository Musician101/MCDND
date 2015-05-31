package musician101.mcdnd;

import musician101.mcdnd.lib.Reference;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid=Reference.ID, name=Reference.NAME, version=Reference.VERSION)
public class MCDND
{
	@Instance(value=Reference.ID)
	public static MCDND instance;
	
	public static Logger log;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		log = event.getModLog();
	}
	
	@EventHandler
	public void onServerStart(FMLServerStartingEvent event)
	{
		if (event.getSide().isClient())
		{
			event.getModState();
			Loader.instance().runtimeDisableMod(Reference.ID);
			return;
		}
		
		//TODO character sheet keybind
		//TODO guihandler init here and in proxy. check Botania for example
	}
	
	//TODO NPC: ability score, size, armor class, hit points, resistances, actions
}
