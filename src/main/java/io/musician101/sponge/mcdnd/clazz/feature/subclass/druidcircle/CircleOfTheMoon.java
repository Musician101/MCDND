package io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.Spells;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class CircleOfTheMoon
{
    public static final Feature COMBAT_WILD_SHAPE = builder().name("Combat Wild Shape").levelRequirement(2)
            .addLineToDescription("When you choose this circle at 2nd level, you gain the ability to use Wild Shape on your turn as a bonus action, rather than as an action.")
            .addLineToDescription("Additionally, while you are transformed by Wild Shape, you can use a bonus action to expend one spell slot to regain 1d8 hit points per level of the spell slot expended.")
            .addProperty(MCDNDKeys.SPELL_LEVEL_DICE_FUNCTION, level -> new Dice(8, level.getValue()))
            .build();
    public static final Feature CIRCLE_FORMS = builder().name("Circle Forms").levelRequirement(2)
            .addLineToDescription("The rites of your circle grant you the ability to transform into more dangerous animal forms. Starting at 2nd level, you can use your Wild Shape to transform into a beast with a challenge rating as high as 1 (you ignore the Max. CR column of the Beast Shapes table, but must abide by the other limitations there).")
            .addLineToDescription("Starting at 6th level, you can transform into a beast with a challenge rating as high as your druid level divided by 3, rounded down.")
            .addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, level -> (int) Math.ceil(level / 3))
            .build();
    public static final Feature PRIMAL_STRIKE = builder().name("Primal Strike").levelRequirement(6)
            .description("Starting at 6th level, your attacks in beast form count as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.")
            .build();
    public static final Feature ELEMENTAL_WILD_SHAPE = builder().name("Elemental Wild Shape").levelRequirement(10)
            .description("At 10th level, you can expend two uses of Wild Shape at the same time to transform into an air elemental, an earth elemental, a fire elemental, or a water elemental.")
            .addProperty(MCDNDKeys.INTEGER, 2)
            .build();
    public static final Feature THOUSAND_FORMS = builder().name("Thousand Forms").levelRequirement(14)
            .description("By 14th level, you have learned to use magic to alter your physical form in more subtle ways. You can cast the Alter Self spell at will.")
            .addProperty(MCDNDKeys.SPELL, Spells.ALTER_SELF)
            .build();

    private CircleOfTheMoon()
    {

    }
}
