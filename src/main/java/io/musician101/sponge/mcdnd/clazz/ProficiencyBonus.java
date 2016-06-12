package io.musician101.sponge.mcdnd.clazz;

import io.musician101.sponge.mcdnd.data.type.CharacterClassType;

import java.util.Map;

public class ProficiencyBonus
{
    private int bonus = 2;

    public ProficiencyBonus(Map<CharacterClassType, Integer> classes)
    {
        updateBonus(classes);
    }

    public int getBonus()
    {
        return bonus;
    }

    public void updateBonus(Map<CharacterClassType, Integer> classes)
    {
        double classLevels = 0;
        for (int level : classes.values())
            classLevels =+ level;

        this.bonus = (int) (Math.floor(classLevels / (10000000000D)) + Math.floor(classLevels / 4d));
    }
}
