package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.abilityscore.AbilityScoreTypes;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageTypes;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.Spells;
import musician101.mcdnd.property.ListProperty;
import musician101.mcdnd.property.SingleValueProperty;
import musician101.mcdnd.property.SingleValueProperty.AbilityScoreDCSaveProperty;
import musician101.mcdnd.skill.SkillTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpellEffects
{
    public static class AlterSpellEffects
    {
        private static final String PREFIX = Spells.ALTER_SELF.getId();
        public static final SpellEffect AQUATIC_ADAPTATION = new SpellEffect(PREFIX + "aquatic_adaptation", "Aquatic Adaptation", "You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed.");
        public static final SpellEffect CHANGE_APPEARANCE = new SpellEffect(PREFIX + "change_appearance", "Change Appearance", "You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also can't appear as a creature of a different size than you, and your basic shape stays the same; if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again.");
        public static final SpellEffect NATURAL_WEAPONS = new NaturalWeaponsSpellEffect();
        public static final List<SpellEffect> ALL = Arrays.asList(AQUATIC_ADAPTATION, CHANGE_APPEARANCE, NATURAL_WEAPONS);

        private static class NaturalWeaponsSpellEffect extends SpellEffect
        {
            private NaturalWeaponsSpellEffect()
            {
                super(PREFIX + "natural_weapon", "Natural Weapons", "You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.");
                properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single.dice", new Dice(6, 1)), new ListProperty<>(getId() + "property.list.damage_type", Arrays.asList(DamageTypes.BLUDGEONING, DamageTypes.PIERCING, DamageTypes.SLASHING)));
            }
        }
    }

    public static class AntimagicFieldSpellEffects
    {
        private static final String PREFIX = Spells.ANTIMAGIC_FILED.getId() + ".effect.";
        public static final SpellEffect AREAS_OF_MAGIC = new SpellEffect(PREFIX + "areas_of_magic", "Areas of Magic", "The area of another spell or magical effect, such as Fireball, can't extend into the sphere. If the sphere overlaps an area of magic, the part of the area that is covered by the sphere is suppressed. For example, the flames created by a Wall of Fire are suppressed within the sphere, creating a gap in the wall if the overlap is large enough.");
        public static final SpellEffect CREATURES_AND_OBJECTS = new SpellEffect(PREFIX + "creatures_and_objects", "Creatures and Objects", "A creature or object summoned or created by magic temporarily winks out of existence in the sphere. Such a creature instantly reappears once the space the creature occupied is no longer within the sphere.");
        public static final SpellEffect DISPEL_MAGIC = new SpellEffect(PREFIX + "dispel_magic", "Dispel Magic", "Spells and magical effects such as Dispel Magic have no effect on the sphere. Likewise, the spheres created by different Antimagic Field spells don't nullify each other.");
        public static final SpellEffect SPELLS = new SpellEffect(PREFIX + "spells", "Spells", "Any active spell or other magical effect on a creature or an object in the sphere is suppressed while the creature or object is in it.");
        public static final SpellEffect MAGIC_ITEMS = new SpellEffect(PREFIX + "magic_items", "Magic Items", "The properties and power of magic items are suppressed in the sphere. For example, a +1 Longsword in the sphere functions as a nonmagical longsword.", "A magic weapon's properties and powers are suppressed if it is used against a target in the sphere or wielded by an attacker in the sphere. If a magic weapon or a piece of magic ammunition fully leaves the sphere (for example, if you fire a magic arrow or throw a magic spear at a target outside the sphere), the magic of the item ceases to be suppressed as soon as it exits.");
        public static final SpellEffect MAGICAL_TRAVEL = new SpellEffect(PREFIX + "magic_travel", "Magical Travel", "Teleportation and planar travel fail to work in the sphere, whether the sphere is in the destination or the departure point for such magical travel. A portal to another location, world, or plane of existence, as well as an opening to an extradimensional space such as that created by the Rope Trick spell, temporarily closes while in the sphere.");
        //TODO check the name for this effect
        public static final SpellEffect TARGETED_EFFECTS = new SpellEffect(PREFIX + "targeted_effects", "Targeted Effects", "Spells and other magical effects, such as Magic Missile and Charm Person, that target a creature or an object in the sphere have no effect on that target.");
        public static final List<SpellEffect> ALL = Arrays.asList(TARGETED_EFFECTS, AREAS_OF_MAGIC, SPELLS, MAGIC_ITEMS, MAGICAL_TRAVEL, CREATURES_AND_OBJECTS, DISPEL_MAGIC);
    }

    public static class AntipathySympathySpellEffects
    {
        public static final SpellEffect ANTIPATHY = new AntipathySpellEffect();
        public static final SpellEffect SYMPATHY = new SympathySpellEffect();
        public static final SpellEffect ENDING_THE_EFFECT = new EndingTheEffectSpellEffect();
        public static final List<SpellEffect> ALL = Arrays.asList(ANTIPATHY, SYMPATHY, ENDING_THE_EFFECT);
        private static final String PREFIX = Spells.ANTIPATHY_SYMPATHY.getId() + ".effect.";

        public static class AntipathySpellEffect extends SpellEffect
        {
            private AntipathySpellEffect()
            {
                super(PREFIX + ".antipathy", "Antipathy", "The enchantment causes creatures of the kind you designated to feel an intense urge to leave the area and avoid the target. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or become frightened. The creature remains frightened while it can see the target or is within 60 feet of it. While frightened by the target, the creature must use its movement to the nearest safe spot from which it can't see the target. If the creature moves more than 60 feet from the target and can't see it, the creature is no longer frightened, but the creature becomes frightened again if it regains sight of the target or moves within 60 feet of it.");
                properties = Collections.singletonList(new AbilityScoreDCSaveProperty(getId(), AbilityScoreTypes.WIS));
            }
        }

        public static class SympathySpellEffect extends SpellEffect
        {
            private SympathySpellEffect()
            {
                super(PREFIX + "sympathy", "Sympathy", "The enchantment causes the specified creatures to feel an intense urge to approach the target while within 60 feet of it or able to see it. When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or use its movement on each of its turns to enter the area or move within reach of the target. When the creature has done so, it can't willingly move away from the target.", "If the target damages or otherwise harms an affected creature, the affected creature can make a Wisdom saving throw to end the effect, as described below.");
                properties = Collections.singletonList(new AbilityScoreDCSaveProperty(getId(), AbilityScoreTypes.WIS));
            }
        }

        public static class EndingTheEffectSpellEffect extends SpellEffect
        {
            private EndingTheEffectSpellEffect()
            {
                super(PREFIX + "ending_the_effect", "Ending the Effect", "If an affected creature ends its turn while not within 60 feet of the target or able to see it, the creature makes a Wisdom saving throw. On a successful save, the creature is no longer affected by the target and recognizes the feeling of repugnance or attraction as magical. In addition, a creature affected by the spell is allowed another Wisdom saving throw every 24 hours while the spell persists.", "A creature that successfully saves against this effect is immune to it for 1 minute, after which time it can be affected again.");
                properties = Collections.singletonList(new AbilityScoreDCSaveProperty(getId(), AbilityScoreTypes.WIS));
            }
        }
    }

    public static class ControlWaterSpellEffects
    {
        public static final String PREFIX = Spells.CONTROL_WATER.getId() + ".effect.";
        public static final SpellEffect FLOOD = new SpellEffect(PREFIX + "flood", "Flood", "You cause the water level of all standing water in the area to rise by as much as 20 feet. If the area includes a shore, the flooding water spills over onto dry land.", "If you choose an area in a large body of water, you instead create a 20-foot tall wave that travels from one side of the area to the other and then crashes down. Any Huge or smaller vehicles in the wave's path are carried with it to the other side. Any Huge or smaller vehicles struck by the wave have a 25 percent chance of capsizing.", "The water level remains elevated until the spell ends or you choose a different effect. If this effect produced a wave, the wave repeats on the start of your next turn while the flood effect lasts.");
        public static final SpellEffect PART_WATER = new SpellEffect(PREFIX + "part_water", "Part Water", "You cause water in the area to move apart and create a trench. The trench extends across the spell's area, and the separated water forms a wall to either side. The trench remains until the spell ends or you choose a different effect. The water then slowly fills in the trench over the course of the next round until the normal water level is restored.");
        public static final SpellEffect REDIRECT_FLOW = new SpellEffect(PREFIX + "redirect_flow", "Redirect Flow", "You cause flowing water in area to move in a direction you choose, even if the water has to flow over obstacles, up walls, or in other unlikely directions. The water in the area moves as you direct it, but once it moves beyond the spell's area, it resumes its flow based on the terrain conditions. The water continues to move in the direction you chose until the spell ends or you choose a different effect.");
        public static final SpellEffect WHIRLPOOL = new WhirlpoolSpellEffect();
        public static final List<SpellEffect> ALL = Arrays.asList(FLOOD, PART_WATER, REDIRECT_FLOW, WHIRLPOOL);

        private static class WhirlpoolSpellEffect extends SpellEffect
        {
            private WhirlpoolSpellEffect()
            {
                super(PREFIX + "whirlpool", "Whirlpool", "This effect requires a body of water at least 50 feet square and 25 feet deep. You cause a whirlpool to form in the center of the area. The whirlpool forms a vortex is pulled 10 feet toward it. A creature can swim away from the vortex by making a Strength (Athletics) check against your spell save DC.", "When a creature enters the vortex for the first time one a turn or starts its turn there, it must make a Strength saving throw. On a failed save the creature takes 2d8 bludgeoning damage and is caught in the vortex until the spell ends. On a successful save, the creature takes half damage, and isn't caught in the vortex. A creature caught in the vortex can use its action to try to swim away from the vortex as described above, but has disadvantage on the Strength (Athletics) check to do so.", "The first time each turn that an object enters the vortex, the object takes 2d8 bludgeoning damage; this damage occurs each round it remains in the vortex.");
                properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single.damage", new Damage(DamageTypes.BLUDGEONING, new Dice(8, 2))), new SingleValueProperty<>(getId() + ".property.single.skill_type", SkillTypes.ATHLETICS));
            }
        }
    }
}
