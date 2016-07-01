package io.musician101.sponge.mcdnd.equipment.weapon;

import com.google.common.collect.ImmutableList;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;
import io.musician101.sponge.mcdnd.data.type.WeaponTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Weapons
{
    public static final Weapon CLUB = new Weapon("Club", new Cost(CurrencyTypes.SILVER, 1), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(4)), 2, Collections.singletonList(WeaponProperties.LIGHT), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon DAGGER = new Weapon("Dagger", new Cost(CurrencyTypes.GOLD, 2), new Damage(MCDNDDamageTypes.PIERCING, new Dice(4)), 1, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon GREATCLUB = new Weapon("Greatclub", new Cost(CurrencyTypes.SILVER, 2), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(8)), 10, Collections.singletonList(WeaponProperties.TWO_HANDED), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon HANDAXE = new Weapon("Handaxe", new Cost(CurrencyTypes.GOLD, 5), new Damage(MCDNDDamageTypes.SLASHING, new Dice(6)), 2, Arrays.asList(WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon JAVELIN = new Weapon("Javelin", new Cost(CurrencyTypes.SILVER, 5), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_30_120), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon LIGHT_HAMMER = new Weapon("Light Hammer", new Cost(CurrencyTypes.GOLD, 2), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(4)), 2, Arrays.asList(WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon MACE = new Weapon("Mace", new Cost(CurrencyTypes.GOLD, 5), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(6)), 4, WeaponTypes.SIMPLE_MELEE);
    public static final Weapon QUARTERSTAFF = new Weapon("Quarterstaff", new Cost(CurrencyTypes.SILVER, 2), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(6)), 4, Collections.singletonList(WeaponProperties.VERSATILE_D8), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon SICKLE = new Weapon("Sickle", new Cost(CurrencyTypes.GOLD, 1), new Damage(MCDNDDamageTypes.SLASHING, new Dice(4)), 2, Collections.singletonList(WeaponProperties.LIGHT), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon SPEAR = new Weapon("Spear", new Cost(CurrencyTypes.GOLD, 1), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 3, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_20_60, WeaponProperties.VERSATILE_D8), WeaponTypes.SIMPLE_MELEE);
    public static final Weapon UNARMED_STRIKE = new Weapon("Unarmed Strike", new Cost(), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(12)), 0, WeaponTypes.SIMPLE_MELEE);
    public static final Weapon LIGHT_CROSSBOW = new Weapon("Light Crossbow", new Cost(CurrencyTypes.GOLD, 25), new Damage(MCDNDDamageTypes.PIERCING, new Dice(8)), 5, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_80_320, WeaponProperties.LOADING, WeaponProperties.TWO_HANDED), WeaponTypes.SIMPLE_RANGED);
    public static final Weapon DART = new Weapon("Dart", new Cost(CurrencyTypes.COPPER, 5), new Damage(MCDNDDamageTypes.PIERCING, new Dice(4)), 0.25, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponTypes.SIMPLE_RANGED);
    public static final Weapon SHORTBOW = new Weapon("Shortbow", new Cost(CurrencyTypes.GOLD, 25), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_80_320, WeaponProperties.TWO_HANDED), WeaponTypes.SIMPLE_RANGED);
    public static final Weapon SLING = new Weapon("Sling", new Cost(CurrencyTypes.SILVER, 1), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(4)), 0, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_30_120), WeaponTypes.SIMPLE_RANGED);
    public static final Weapon BATTLEAXE = new Weapon("Battleaxe", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.SLASHING, new Dice(8)), 4, Collections.singletonList(WeaponProperties.VERSATILE_D10), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon FLAIL = new Weapon("Flail", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(8)), 2, WeaponTypes.MARTIAL_MELEE);
    public static final Weapon GLAIVE = new Weapon("Glaive", new Cost(CurrencyTypes.GOLD, 20), new Damage(MCDNDDamageTypes.SLASHING, new Dice(10)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon GREATAXE = new Weapon("Greateaxe", new Cost(CurrencyTypes.GOLD, 30), new Damage(MCDNDDamageTypes.SLASHING, new Dice(12)), 7, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon GREATSWORD = new Weapon("Greatsword", new Cost(CurrencyTypes.GOLD, 50), new Damage(MCDNDDamageTypes.SLASHING, new Dice(6, 2)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon HALBERD = new Weapon("Halberd", new Cost(CurrencyTypes.GOLD, 20), new Damage(MCDNDDamageTypes.SLASHING, new Dice(10)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon LANCE = new Weapon("Lance", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.PIERCING, new Dice(12)), 6, Arrays.asList(WeaponProperties.REACH, WeaponProperties.SPECIAL_LANCE), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon LONGSWORD = new Weapon("Longsword", new Cost(CurrencyTypes.GOLD, 15), new Damage(MCDNDDamageTypes.SLASHING, new Dice(8)), 3, Collections.singletonList(WeaponProperties.VERSATILE_D10), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon MAUL = new Weapon("Maul", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(6, 2)), 10, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon MORNINGSTAR = new Weapon("Morningstar", new Cost(CurrencyTypes.GOLD, 15), new Damage(MCDNDDamageTypes.PIERCING, new Dice(8)), 4, WeaponTypes.MARTIAL_MELEE);
    public static final Weapon PIKE = new Weapon("Pike", new Cost(CurrencyTypes.GOLD, 5), new Damage(MCDNDDamageTypes.PIERCING, new Dice(10)), 18, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon RAPIER = new Weapon("Rapier", new Cost(CurrencyTypes.GOLD, 25), new Damage(MCDNDDamageTypes.PIERCING, new Dice(8)), 2, Collections.singletonList(WeaponProperties.FINESSE), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon SCIMITAR = new Weapon("Scimitar", new Cost(CurrencyTypes.GOLD, 25), new Damage(MCDNDDamageTypes.SLASHING, new Dice(6)), 3, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon SHORTSWORD = new Weapon("Shortsword", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon TRIDENT = new Weapon("Trident", new Cost(CurrencyTypes.GOLD, 5), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 4, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_20_60, WeaponProperties.VERSATILE_D8), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon WAR_PICK = new Weapon("War Pick", new Cost(CurrencyTypes.GOLD, 5), new Damage(MCDNDDamageTypes.PIERCING, new Dice(8)), 2, WeaponTypes.MARTIAL_MELEE);
    public static final Weapon WARHAMMER = new Weapon("Warhammer", new Cost(CurrencyTypes.GOLD, 15), new Damage(MCDNDDamageTypes.BLUDGEONING, new Dice(8)), 2, Collections.singletonList(WeaponProperties.VERSATILE_D10), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon WHIP = new Weapon("Whip", new Cost(CurrencyTypes.GOLD, 2), new Damage(MCDNDDamageTypes.SLASHING, new Dice(4)), 3, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.REACH), WeaponTypes.MARTIAL_MELEE);
    public static final Weapon BLOWGUN = new Weapon("Blowgun", new Cost(CurrencyTypes.GOLD, 10), new Damage(MCDNDDamageTypes.PIERCING, new Dice(12)), 1, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_25_100, WeaponProperties.LOADING), WeaponTypes.MARTIAL_RANGED);
    public static final Weapon HAND_CROSSBOW = new Weapon("Hand Crossbow", new Cost(CurrencyTypes.GOLD, 75), new Damage(MCDNDDamageTypes.PIERCING, new Dice(6)), 3, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_30_120, WeaponProperties.LIGHT, WeaponProperties.LOADING), WeaponTypes.MARTIAL_RANGED);
    public static final Weapon HEAVY_CROSSBOW = new Weapon("Heavy Crossbow", new Cost(CurrencyTypes.GOLD, 50), new Damage(MCDNDDamageTypes.PIERCING, new Dice(10)), 18, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_100_400, WeaponProperties.HEAVY, WeaponProperties.LOADING, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_RANGED);
    public static final Weapon LONGBOW = new Weapon("Longbow", new Cost(CurrencyTypes.GOLD, 50), new Damage(MCDNDDamageTypes.PIERCING, new Dice(8)), 2, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_150_600, WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponTypes.MARTIAL_RANGED);
    public static final Weapon NET = new Weapon("Net", new Cost(CurrencyTypes.GOLD, 1), new Damage(MCDNDDamageTypes.NONE, new Dice(1)), 3, Arrays.asList(WeaponProperties.SPECIAL_NET, WeaponProperties.THROWN, WeaponProperties.RANGE_5_15), WeaponTypes.MARTIAL_RANGED);

    public static List<Weapon> getSimpleMeleeWeapons()
    {
        return Arrays.asList(CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE, QUARTERSTAFF, SICKLE,
                SPEAR, UNARMED_STRIKE);
    }

    public static List<Weapon> getSimpleRangedWeapons()
    {
        return Arrays.asList(LIGHT_CROSSBOW, DART, SHORTBOW, SLING);
    }

    public static List<Weapon> getSimpleWeapons()
    {
        return ImmutableList.<Weapon>builder().addAll(getSimpleMeleeWeapons()).addAll(getSimpleRangedWeapons()).build();
    }

    public static List<Weapon> getMartialMeleeWeapons()
    {
        return Arrays.asList(BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL,
                MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP);
    }

    public static List<Weapon> getMartialRangedWeapons()
    {
        return Arrays.asList(BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET);
    }

    public static List<Weapon> getMartialWeapons()
    {
        return ImmutableList.<Weapon>builder().addAll(getMartialMeleeWeapons()).addAll(getMartialRangedWeapons()).build();
    }

    public static List<Weapon> getAll()
    {
        return ImmutableList.<Weapon>builder().addAll(getSimpleWeapons()).addAll(getMartialWeapons()).build();
    }
}
