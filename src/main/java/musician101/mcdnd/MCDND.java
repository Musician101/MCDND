package musician101.mcdnd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
public class MCDND
{
    public static Logger log;
    public static MCDND instance;

    @Listener
    public void preInit(GameStartedServerEvent event)
    {
        log = LoggerFactory.getLogger(Reference.ID.toUpperCase());
        instance = this;
    }

    //TODO character sheet keybind
    //TODO guihandler init here and in proxy. check Botania for example
    //TODO remove all hardcoded enum classes
    //TODO NPC: ability score, size, armor class, hit points, resistances, actions
}
