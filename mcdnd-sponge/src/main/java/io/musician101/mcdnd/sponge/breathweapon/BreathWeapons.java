package io.musician101.mcdnd.sponge.breathweapon;

import io.musician101.mcdnd.sponge.combat.MCDNDDamageTypes;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.shape.Cone;
import io.musician101.mcdnd.sponge.shape.Line;

import static io.musician101.mcdnd.sponge.breathweapon.BreathWeapon.builder;

public class BreathWeapons
{
    private static final AbilityScoreType CON = AbilityScoreTypes.CONSTITUTION;
    private static final AbilityScoreType DEX = AbilityScoreTypes.DEXTERITY;
    private static final Cone CONE = new Cone(15);
    private static final Line LINE = new Line(5, 30);
    public static final BreathWeapon ACID_LINE = builder().shape(LINE).abilityScoreType(DEX)
            .damageType(MCDNDDamageTypes.ACID).build();
    public static final BreathWeapon FIRE_LINE = builder().shape(LINE).abilityScoreType(DEX)
            .damageType(MCDNDDamageTypes.FIRE).build();
    public static final BreathWeapon LIGHTNING_LINE = builder().shape(LINE).abilityScoreType(DEX)
            .damageType(MCDNDDamageTypes.LIGHTNING).build();
    public static final BreathWeapon COLD_CONE = builder().shape(CONE).abilityScoreType(CON)
            .damageType(MCDNDDamageTypes.COLD).build();
    public static final BreathWeapon FIRE_CONE = builder().shape(CONE).abilityScoreType(DEX)
            .damageType(MCDNDDamageTypes.FIRE).build();
    public static final BreathWeapon POISON_CONE = builder().shape(CONE).abilityScoreType(CON)
            .damageType(MCDNDDamageTypes.POISON).build();
}
