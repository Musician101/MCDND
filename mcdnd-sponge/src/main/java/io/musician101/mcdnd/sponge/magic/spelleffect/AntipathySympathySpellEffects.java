package io.musician101.mcdnd.sponge.magic.spelleffect;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;

import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.magic.spelleffect.SpellEffect.builder;

public class AntipathySympathySpellEffects
{
    public static final SpellEffect ANTIPATHY = builder().name("Antipathy")
            .description("The enchantment causes creatures of the kind you designated to feel an intense urge to leave the area and avoid the target. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or become frightened. The creature remains frightened while it can see the target or is within 60 feet of it. While frightened by the target, the creature must use its movement to the nearest safe spot from which it can't see the target. If the creature moves more than 60 feet from the target and can't see it, the creature is no longer frightened, but the creature becomes frightened again if it regains sight of the target or moves within 60 feet of it.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM)
            .build();
    public static final SpellEffect SYMPATHY = builder().name("Sympathy")
            .addLineToDescription("The enchantment causes the specified creatures to feel an intense urge to approach the target while within 60 feet of it or able to see it. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or use its movement on each of its turns to enter the area or move within reach of the target. When the creature has done so, it can't willingly move away from the target.")
            .addLineToDescription("If the target damages or otherwise harms an affected creature, the affected creature can make a Wisdom saving throw to end the effect, as described below.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM)
            .build();
    public static final SpellEffect ENDING_THE_EFFECT = builder().name("Ending the Effect")
            .addLineToDescription("If an affected creature ends its turn while not within 60 feet of the target or able to see it, the creature makes a Wisdom saving throw. On a successful save, the creature is no longer affected by the target and recognizes the feeling of repugnance or attraction as magical. In addition, a creature affected by the spell is allowed another Wisdom saving throw every 24 hours while the spell persists.")
            .addLineToDescription("A creature that successfully saves against this effect is immune to it for 1 minute, after which time it can be affected again.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM)
            .build();
    public static final List<SpellEffect> ALL = Arrays.asList(ANTIPATHY, SYMPATHY, ENDING_THE_EFFECT);
}
