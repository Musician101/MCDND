package io.musician101.mcdnd.sponge.clazz.feature.subclass.college;

import com.google.common.collect.Lists;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import io.musician101.mcdnd.sponge.equipment.armor.Armors;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapons;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class ValorCollege {

    public static final Feature BARD_EXTRA_ATTACK = builder().name("Extra Attack").levelRequirement(6).description("Starting at 6th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.").build();
    public static final Feature BATTLE_MAGIC = builder().name("Battle Magic").levelRequirement(14).description("At 14th level, you have mastered the art of weaving spellcasting and weapon use into a single harmonious act. When you use your action to cast a bard spell, you can make one weapon attack as a bonus action.").build();
    public static final Feature BONUS_PROFICIENCIES = builder().name("Bonus Proficiencies").levelRequirement(3).description("When you join the college of Valor at 3rd level, you gain proficiency with medium armor, shields, and martial weapons.").addProperty(MCDNDKeys.ARMORS, Lists.asList(Armors.SHIELD, Armors.getMediumArmor().toArray(new Armor[Armors.getMediumArmor().size()]))).addProperty(MCDNDKeys.WEAPONS, Weapons.getMartialWeapons()).build();
    public static final Feature COMBAT_INSPIRATION = builder().name("Combat Inspiration").levelRequirement(3).description("Also at 3rd level, you learn to inspire others in battle. A creature that has a Bardic Inspiration die from you can roll that die and add the number rolled to a weapon damage roll it just made. Alternatively, when an attack roll is made against the creature, it can use its reaction to roll the Bardic Inspiration die and add the number rolled to its AC against that attack, after seeing the roll but before knowing whether it hits or misses.").build();

    private ValorCollege() {

    }
}
