package io.musician101.sponge.mcdnd.combat;

import java.util.Arrays;
import java.util.List;

public class MCDNDDamageTypes
{
    public static final MCDNDDamageType ACID = new MCDNDDamageType("Acid");
    public static final MCDNDDamageType BLUDGEONING = new MCDNDDamageType("Bludgeoning");
    public static final MCDNDDamageType COLD = new MCDNDDamageType("Cold");
    public static final MCDNDDamageType FIRE = new MCDNDDamageType("Fire");
    public static final MCDNDDamageType FORCE = new MCDNDDamageType("Force");
    public static final MCDNDDamageType LIGHTNING = new MCDNDDamageType("Lightning");
    public static final MCDNDDamageType NECROTIC = new MCDNDDamageType("Necrotic");
    public static final MCDNDDamageType NONE = new MCDNDDamageType("None");
    public static final MCDNDDamageType PIERCING = new MCDNDDamageType("Piercing");
    public static final MCDNDDamageType POISON = new MCDNDDamageType("Poison");
    public static final MCDNDDamageType PSYCHIC = new MCDNDDamageType("Psychic");
    public static final MCDNDDamageType RADIANT = new MCDNDDamageType("Radiant");
    public static final MCDNDDamageType SLASHING = new MCDNDDamageType("Slashing");
    public static final MCDNDDamageType THUNDER = new MCDNDDamageType("Thunder");
    public static final List<MCDNDDamageType> ALL = Arrays.asList(ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, NONE, PIERCING, POISON, PSYCHIC, RADIANT, SLASHING, THUNDER);
}
