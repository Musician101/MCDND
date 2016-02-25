package musician101.mcdnd.magic;

import musician101.mcdnd.util.CustomMap;

import java.util.Map;

@Deprecated
public class ScryingSpell extends Spell
{
    private final Map<String, Integer> connectionMap;
    private final Map<String, Integer> knowledgeMap;

    public ScryingSpell()
    {
        super("Scrying", SpellTypes.DIVINATION, SpellLevels.L5, 600, 0, true, true, "a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water", 600, true, "You can see and hear a particular creature you choose that is on the same plane of existence as you. The target must make a Wisdom saving throw, which is modified by how well you know the target and the sort of physical connection you have to it. If a target knows you're casting this spell, it can fail the saving throw voluntarily if it wants to be observed.", "On a successful save, the target isn't affected, and you can't use this spell against it again for 24 hours.", "On a failed save, the spell creates an invisible sensor within 10 feet of the target. You can see and hear through the sensor as if you were there. The sensor moves with the target, remaining within 10 feet of it for the duration. A creature that can see invisible objects sees the sensor as a luminous orb about the size of your fist.", "Instead of targeting a creature, you can choose a location you have seen before as the target of this spell. When you do, the sensor appears at that location and doesn't move.");
        knowledgeMap = new CustomMap<String, Integer>().add("Secondhand", 5).add("Firsthand", 0).add("Familiar", -5);
        connectionMap = new CustomMap<String, Integer>().add("Likeness", -2).add("Possession", -4).add("Body part", -10);
    }

    public Map<String, Integer> getConnectionMap()
    {
        return connectionMap;
    }

    public Map<String, Integer> getKnowledgeMap()
    {
        return knowledgeMap;
    }
}
