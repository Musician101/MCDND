package musician101.mcdnd.combat;

import java.util.Arrays;
import java.util.List;

public class DamageTypes
{
    public static final DamageType ACID = new DamageType("Acid");
    public static final DamageType BLUDGEONING = new DamageType("Bludgeoning");
    public static final DamageType COLD = new DamageType("Cold");
    public static final DamageType FIRE = new DamageType("Fire");
    public static final DamageType FORCE = new DamageType("Force");
    public static final DamageType LIGHTNING = new DamageType("Lightning");
    public static final DamageType NECROTIC = new DamageType("Necrotic");
    public static final DamageType NONE = new DamageType("None");
    public static final DamageType PIERCING = new DamageType("Piercing");
    public static final DamageType POISON = new DamageType("Poison");
    public static final DamageType PSYCHIC = new DamageType("Psychic");
    public static final DamageType RADIANT = new DamageType("Radiant");
    public static final DamageType SLASHING = new DamageType("Slashing");
    public static final DamageType THUNDER = new DamageType("Thunder");
    public static final List<DamageType> ALL = Arrays.asList(ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, NONE, PIERCING, POISON, PSYCHIC, RADIANT, SLASHING, THUNDER);
}
