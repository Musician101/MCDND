package io.musician101.sponge.mcdnd.data.type.skill;

public class SkillModTypes
{
    public static final SkillModType EXPERTISE = new SkillModType("Expertise", bonus -> bonus * 2);
    public static final SkillModType JACK_OF_ALL_TRADES = new SkillModType("Jack of All Trades", bonus -> bonus / 2);
    public static final SkillModType NONE = new SkillModType("None", bonus -> 0);
    public static final SkillModType PROFICIENT = new SkillModType("Proficient", bonus -> bonus);

    private SkillModTypes()
    {

    }
}
