package io.musician101.mcdnd.sponge.language;

import io.musician101.mcdnd.sponge.util.Interfaces.Named;

public class Language implements Named
{
    final boolean isExotic;
    final String name;
    final String script;

    public Language(String name, boolean isExotic)
    {
        this(name, name, isExotic);
    }

    public Language(String name)
    {
        this(name, name);
    }

    public Language(String name, String script)
    {
        this(name, script, false);
    }

    public Language(String name, String script, boolean isExotic)
    {
        this.name = name;
        this.script = script;
        this.isExotic = isExotic;
    }

    public boolean isExotic()
    {
        return isExotic;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public String getScript()
    {
        return script;
    }
}
