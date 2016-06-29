package io.musician101.sponge.mcdnd.magic.spelleffect;

import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.DamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.Dice;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.magic.spelleffect.SpellEffect.builder;

public class ControlWaterSpellEffects
{
    public static final SpellEffect FLOOD = builder().name("Flood")
            .description("You cause the water level of all standing water in the area to rise by as much as 20 feet. If the area includes a shore, the flooding water spills over onto dry land.", "If you choose an area in a large body of water, you instead create a 20-foot tall wave that travels from one side of the area to the other and then crashes down. Any Huge or smaller vehicles in the wave's path are carried with it to the other side. Any Huge or smaller vehicles struck by the wave have a 25 percent chance of capsizing.", "The water level remains elevated until the spell ends or you choose a different effect. If this effect produced a wave, the wave repeats on the start of your next turn while the flood effect lasts.")
            .build();
    public static final SpellEffect PART_WATER = builder().name("Part Water")
            .description("You cause water in the area to move apart and create a trench. The trench extends across the spell's area, and the separated water forms a wall to either side. The trench remains until the spell ends or you choose a different effect. The water then slowly fills in the trench over the course of the next round until the normal water level is restored.")
            .build();
    public static final SpellEffect REDIRECT_FLOW = builder().name("Redirect Flow")
            .description("You cause flowing water in area to move in a direction you choose, even if the water has to flow over obstacles, up walls, or in other unlikely directions. The water in the area moves as you direct it, but once it moves beyond the spell's area, it resumes its flow based on the terrain conditions. The water continues to move in the direction you chose until the spell ends or you choose a different effect.")
            .build();
    public static final SpellEffect WHIRLPOOL = builder().name("Whirlpool")
            .description("This effect requires a body of water at least 50 feet square and 25 feet deep. You cause a whirlpool to form in the center of the area. The whirlpool forms a vortex is pulled 10 feet toward it. A creature can swim away from the vortex by making a Strength (Athletics) check against your spell save DC.", "When a creature enters the vortex for the first time one a turn or starts its turn there, it must make a Strength saving throw. On a failed save the creature takes 2d8 bludgeoning damage and is caught in the vortex until the spell ends. On a successful save, the creature takes half damage, and isn't caught in the vortex. A creature caught in the vortex can use its action to try to swim away from the vortex as described above, but has disadvantage on the Strength (Athletics) check to do so.", "The first time each turn that an object enters the vortex, the object takes 2d8 bludgeoning damage; this damage occurs each round it remains in the vortex.")
            .addProperty(MCDNDKeys.DAMAGE, new Damage(DamageTypes.BLUDGEONING, new Dice(8, 2)))
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.ATHLETICS)
            .build();
    public static final List<SpellEffect> ALL = Arrays.asList(FLOOD, PART_WATER, REDIRECT_FLOW, WHIRLPOOL);
}
