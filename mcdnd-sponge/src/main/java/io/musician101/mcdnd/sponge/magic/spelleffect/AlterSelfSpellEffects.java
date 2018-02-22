package io.musician101.mcdnd.sponge.magic.spelleffect;

import io.musician101.mcdnd.sponge.combat.MCDNDDamageTypes;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.magic.spelleffect.SpellEffect.builder;

public class AlterSelfSpellEffects {

    public static final SpellEffect AQUATIC_ADAPTATION = builder().name("Aquatic Adaptation").description("You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed.").build();
    public static final SpellEffect CHANGE_APPEARANCE = builder().name("Change Appearance").description("You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also can't appear as a creature of a different size than you, and your basic shape stays the same; if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again.").build();
    public static final SpellEffect NATURAL_WEAPONS = builder().name("Natural Weapons").description("You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.").addProperty(MCDNDKeys.DICE, new Dice(6, 1)).addProperty(MCDNDKeys.DAMAGE_TYPES, Arrays.asList(MCDNDDamageTypes.BLUDGEONING, MCDNDDamageTypes.PIERCING, MCDNDDamageTypes.SLASHING)).build();
    public static final List<SpellEffect> ALL = Arrays.asList(AQUATIC_ADAPTATION, CHANGE_APPEARANCE, NATURAL_WEAPONS);
}
