package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.abilityscore.AbilityScoreTypes;
import musician101.mcdnd.combat.DamageTypes;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.spelleffect.SpellEffect.AbilityScoreDCSaveSpellEffect;
import musician101.mcdnd.magic.spelleffect.SpellEffect.DamageDealingMultiDamageTypeSpellEffect;

import java.util.Arrays;

public class SpellEffects
{
    public static class AlterSpellEffects
    {
        public static final SpellEffect AQUATIC_ADAPTATION = new AquaticAdaptationSpellEffect();
        public static final SpellEffect CHANGE_APPEARANCE = new ChangeAppearanceSpellEffect();
        public static final SpellEffect NATURAL_WEAPONS = new NaturalWeaponsSpellEffect();

        public static class AquaticAdaptationSpellEffect extends SpellEffect
        {
            private AquaticAdaptationSpellEffect()
            {
                name = "Aquatic Adaptation";
                description = new String[]{"You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed."};
            }
        }

        public static class ChangeAppearanceSpellEffect extends SpellEffect
        {
            private ChangeAppearanceSpellEffect()
            {
                name = "Change Appearance";
                description = new String[]{"You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also can't appear as a creature of a different size than you, and your basic shape stays the same; if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again."};
            }
        }

        public static class NaturalWeaponsSpellEffect extends DamageDealingMultiDamageTypeSpellEffect
        {
            private NaturalWeaponsSpellEffect()
            {
                name = "Natural Weapons";
                damageAmount = new Dice(6, 1);
                damageTypes = Arrays.asList(DamageTypes.BLUDGEONING, DamageTypes.PIERCING, DamageTypes.SLASHING);
                description = new String[]{"You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it."};
            }
        }
    }

    public static class AntimagicFieldSpellEffects
    {
        public static final SpellEffect TARGETED_EFFECTS = new TargetedEffectsSpellEffect();
        public static final SpellEffect AREAS_OF_MAGIC = new AreasOfMagicSpellEffect();
        public static final SpellEffect SPELLS = new SpellsSpellEffect();
        public static final SpellEffect MAGIC_ITEMS = new MagicItemsSpellEffect();
        public static final SpellEffect MAGICAL_TRAVEL = new MagicalTravelSpellEffect();
        public static final SpellEffect CREATURES_AND_OBJECTS = new CreaturesAndObjectsSpellEffect();
        public static final SpellEffect DISPEL_MAGIC = new DispelMagicSpellEffect();

        public static class TargetedEffectsSpellEffect extends SpellEffect
        {
            private TargetedEffectsSpellEffect()
            {
                name = "Target Effects";
                description = new String[]{"Spells and other magical effects, such as Magic Missile and Charm Person, that target a creature or an object in the sphere have no effect on that target."};
            }
        }

        public static class AreasOfMagicSpellEffect extends SpellEffect
        {
            private AreasOfMagicSpellEffect()
            {
                name = "Areas of Magic";
                description = new String[]{"The area of another spell or magical effect, such as Fireball, can't extend into the sphere. If the sphere overlaps an area of magic, the part of the area that is covered by the sphere is suppressed. For example, the flames created by a Wall of Fire are suppressed within the sphere, creating a gap in the wall if the overlap is large enough."};
            }
        }

        public static class SpellsSpellEffect extends SpellEffect
        {
            private SpellsSpellEffect()
            {
                name = "Spells";
                description = new String[]{"Any active spell or other magical effect on a creature or an object in the sphere is suppressed while the creature or object is in it."};
            }
        }

        public static class MagicItemsSpellEffect extends SpellEffect
        {
            private MagicItemsSpellEffect()
            {
                name = "Magic Items";
                description = new String[]{"The properties and power of magic items are suppressed in the sphere. For example, a +1 Longsword in the sphere functions as a nonmagical longsword.", "A magic weapon's properties and powers are suppressed if it is used against a target in the sphere or wielded by an attacker in the sphere. If a magic weapon or a piece of magic ammunition fully leaves the sphere (for example, if you fire a magic arrow or throw a magic spear at a target outside the sphere), the magic of the item ceases to be suppressed as soon as it exits."};
            }
        }

        public static class MagicalTravelSpellEffect extends SpellEffect
        {
            private MagicalTravelSpellEffect()
            {
                name = "Magical Travel";
                description = new String[]{"Teleportation and planar travel fail to work in the sphere, whether the sphere is in the destination or the departure point for such magical travel. A portal to another location, world, or plane of existence, as well as an opening to an extradimensional space such as that created by the Rope Trick spell, temporarily closes while in the sphere."};
            }
        }

        public static class CreaturesAndObjectsSpellEffect extends SpellEffect
        {
            private CreaturesAndObjectsSpellEffect()
            {
                name = "Creatures and Objects";
                description = new String[]{"A creature or object summoned or created by magic temporarily winks out of existence in the sphere. Such a creature instantly reappears once the space the creature occupied is no longer within the sphere."};
            }
        }

        public static class DispelMagicSpellEffect extends SpellEffect
        {
            private DispelMagicSpellEffect()
            {
                name = "Dispel Magic";
                description = new String[]{"Spells and magical effects such as Dispel Magic have no effect on the sphere. Likewise, the spheres created by different Antimagic Field spells don't nullify each other."};
            }
        }
    }

    public static class AntipathySympathySpellEffects
    {
        public static final SpellEffect ANTIPATHY = new AntipathySpellEffect();
        public static final SpellEffect SYMPATHY = new SympathySpellEffect();
        public static final SpellEffect ENDING_THE_EFFECT = new EndingTheEffectSpellEffect();

        public static class AntipathySpellEffect extends AbilityScoreDCSaveSpellEffect
        {
            private AntipathySpellEffect()
            {
                name = "Antipathy";
                type = AbilityScoreTypes.WIS;
                description = new String[]{"The enchantment causes creatures of the kind you designated to feel an intense urge to leave the area and avoid the target. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or become frightened. The creature remains frightened while it can see the target or is within 60 feet of it. While frightened by the target, the creature must use its movement to the nearest safe spot from which it can't see the target. If the creature moves more than 60 feet from the target and can't see it, the creature is no longer frightened, but the creature becomes frightened again if it regains sight of the target or moves within 60 feet of it."};
            }
        }

        public static class SympathySpellEffect extends AbilityScoreDCSaveSpellEffect
        {
            private SympathySpellEffect()
            {
                name = "Sympathy";
                type = AbilityScoreTypes.WIS;
                description = new String[]{"The enchantment causes the specified creatures to feel an intense urge to approach the target while within 60 feet of it or able to see it. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or use its movement on each of its turns to enter the area or move within reach of the target. When the creature has done so, it can't willingly move away from the target.", "If the target damages or otherwise harms an affected creature, the affected creature can make a Wisdom saving throw to end the effect, as described below."};
            }
        }

        public static class EndingTheEffectSpellEffect extends AbilityScoreDCSaveSpellEffect
        {
            private EndingTheEffectSpellEffect()
            {
                name = "Ending the Effect";
                type = AbilityScoreTypes.WIS;
                description = new String[]{"If an affected creature ends its turn while not within 60 feet of the target or able to see it, the creature makes a Wisdom saving throw. On a successful save, the creature is no longer affected by the target and recognizes the feeling of repugnance or attraction as magical. In addition, a creature affected by the spell is allowed another Wisdom saving throw every 24 hours while the spell persists.", "A creature that successfully saves against this effect is immune to it for 1 minute, after which time it can be affected again."};
            }
        }
    }
}
