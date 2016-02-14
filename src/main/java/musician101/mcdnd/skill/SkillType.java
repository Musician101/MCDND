package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.util.Interfaces.Named;

public class SkillType implements Named
{
    final AbilityScoreType type;
    final String name;

    public SkillType(String name, AbilityScoreType type)
    {
        this.name = name;
        this.type = type;
    }

    public AbilityScoreType getType()
    {
        return type;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
