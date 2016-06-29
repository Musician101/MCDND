package io.musician101.sponge.mcdnd.data.key;

import io.musician101.sponge.mcdnd.armor.ArmorClass;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoices;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.college.BardCollege;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.domain.DivineDomain;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.PrimalPath;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem.Totem;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.DamageType;
import io.musician101.sponge.mcdnd.condition.Condition;
import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.Alignment;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.data.type.WeaponType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillModType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.equipment.armor.Armor;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import io.musician101.sponge.mcdnd.equipment.tool.Tool;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperty;
import io.musician101.sponge.mcdnd.language.Language;
import io.musician101.sponge.mcdnd.magic.Spell;
import io.musician101.sponge.mcdnd.magic.SpellComponents;
import io.musician101.sponge.mcdnd.magic.SpellDuration;
import io.musician101.sponge.mcdnd.magic.spelleffect.SpellEffect;
import io.musician101.sponge.mcdnd.property.ProficienciesProperty;
import io.musician101.sponge.mcdnd.property.RageProperty;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.property.UnarmoredDefenseProperty;
import io.musician101.sponge.mcdnd.property.list.AbilityScoreImprovementProperty;
import io.musician101.sponge.mcdnd.property.single.AbilityScoreDCSaveProperty;
import io.musician101.sponge.mcdnd.property.single.HitPointsProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingTraitProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellsKnownSpellcastingProperty;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.race.trait.Trait;
import io.musician101.sponge.mcdnd.util.DualIntegerFunction;
import io.musician101.sponge.mcdnd.util.DualIntegerMap;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import io.musician101.sponge.mcdnd.util.list.SpellList;
import io.musician101.sponge.mcdnd.util.list.TraitList;
import io.musician101.sponge.mcdnd.util.table.Table;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import static org.spongepowered.api.data.DataQuery.of;
import static org.spongepowered.api.data.key.KeyFactory.makeListKey;
import static org.spongepowered.api.data.key.KeyFactory.makeMapKey;
import static org.spongepowered.api.data.key.KeyFactory.makeSingleKey;

public class MCDNDKeys
{
    public static final Key<Value<Dice>> DICE = makeSingleKey(Dice.class, Value.class, of("Dice"));
    public static final Key<Value<Integer>> ABILITY_SCORE = makeSingleKey(Integer.class, Value.class, of("AbilityScore"));
    public static final Key<Value<AbilityScoreDCSaveProperty>> ABILITY_SCORE_DC_SAVE_PROPERTY = makeSingleKey(AbilityScoreDCSaveProperty.class, Value.class, of("AbilityScoreDCSaveProperty"));
    public static final Key<Value<AbilityScoreImprovementProperty>> ABILITY_SCORE_IMPROVEMENT_PROPERTY = makeSingleKey(AbilityScoreImprovementProperty.class, Value.class, of("AbilityScoreImprovementProperty"));
    public static final Key<MapValue<AbilityScoreType, Integer>> ABILITY_SCORE_INCREASE = makeMapKey(AbilityScoreType.class, Integer.class, of("AbilityScoreIncrease"));
    public static final Key<Value<AbilityScoreType>> ABILITY_SCORE_TYPE = makeSingleKey(AbilityScoreType.class, Value.class, of("AbilityScoreTypeList"));
    public static final Key<ListValue<AbilityScoreType>> ABILITY_SCORE_TYPES = makeListKey(AbilityScoreType.class, of("AbilityScoreTypes"));
    public static final Key<MapValue<AbilityScoreType, Integer>> ABILITY_SCORES = makeMapKey(AbilityScoreType.class, Integer.class, of("AbilityScores"));
    public static final Key<Value<Alignment>> ALIGNMENT = makeSingleKey(Alignment.class, Value.class, of("Alignment"));
    public static final Key<Value<Integer>> AMOUNT = makeSingleKey(Integer.class, Value.class, of("Amount"));
    public static final Key<Value<Armor>> ARMOR = makeSingleKey(Armor.class, Value.class, of("Armor"));
    public static final Key<Value<ArmorClass>> ARMOR_CLASS = makeSingleKey(ArmorClass.class, Value.class, of("ArmorClass"));
    public static final Key<Value<Integer>> ARMOR_CLASS_BONUS = makeSingleKey(Integer.class, Value.class, of("ArmorClassBonus"));
    public static final Key<ListValue<Armor>> ARMORS = makeListKey(Armor.class, of("Armors"));
    public static final Key<ListValue<Armor>> ARMOR_PROFICIENCIES = makeListKey(Armor.class, of("ArmorProficiencies"));
    public static final Key<Value<ArmorTypes>> ARMOR_TYPE = makeSingleKey(ArmorTypes.class, Value.class, of("ArmorType"));
    public static final Key<ListValue<ArmorTypes>> ARMOR_TYPES = makeListKey(ArmorTypes.class, of("ArmorTypes"));
    public static final Key<Value<String>> ARMOR_STRING = makeSingleKey(String.class, Value.class, of("ArmorString"));
    public static final Key<ListValue<BardCollege>> BARD_COLLEGES = makeListKey(BardCollege.class, of("BardColleges"));
    public static final Key<MapValue<Integer, Dice>> BARDIC_INSPIRATION_MAP = makeMapKey(Integer.class, Dice.class, of("BardicInspirationMap"));
    public static final Key<Value<Integer>> BASE_HEIGHT = makeSingleKey(Integer.class, Value.class, of("BaseHeight"));
    public static final Key<Value<Integer>> BASE_WEIGHT = makeSingleKey(Integer.class, Value.class, of("BaseWeight"));
    public static final Key<MapValue<Integer, Integer>> BRUTAL_CRITICAL_MAP = makeMapKey(Integer.class, Integer.class, of("IntegerIntegerMap"));
    public static final Key<Value<Feature>> CANTRIPS = makeSingleKey(Feature.class, Value.class, of("Cantrips"));
    public static final Key<MapValue<Integer, Integer>> CANTRIP_SLOT_AMOUNT = makeMapKey(Integer.class, Integer.class, of("CantripSlots"));
    public static final Key<Value<Double>> CASTING_TIME = makeSingleKey(Double.class, Value.class, of("CastingTime"));
    public static final Key<MapValue<CharacterClassType, Integer>> CHARACTER_CLASSES = makeMapKey(CharacterClassType.class, Integer.class, of("CharacterClasses"));
    public static final Key<MapValue<CharacterClassType, HitDice>> CHARACTER_HIT_DICE = makeMapKey(CharacterClassType.class, HitDice.class, of("HitDice"));
    public static final Key<Value<CharacterSize>> CHARACTER_SIZE = makeSingleKey(CharacterSize.class, Value.class, of("CharacterSize"));
    public static final Key<Value<String>> CLASS_NAME = makeSingleKey(String.class, Value.class, of("ClassName"));
    public static final Key<Value<Cost>> COST = makeSingleKey(Cost.class, Value.class, of("Cost"));
    public static final Key<Value<Damage>> DAMAGE = makeSingleKey(Damage.class, Value.class, of("Damage"));
    public static final Key<Value<DamageType>> DAMAGE_TYPE = makeSingleKey(DamageType.class, Value.class, of("DamageType"));
    public static final Key<ListValue<DamageType>> DAMAGE_TYPES = makeListKey(DamageType.class, of("DamageTypes"));
    public static final Key<ListValue<String>> DESCRIPTION = makeListKey(String.class, of("Description"));
    public static final Key<ListValue<DivineDomain>> DIVINE_DOMAINS = makeListKey(DivineDomain.class, of("DivineDomains"));
    public static final Key<Value<Equipment>> EQUIPMENT = makeSingleKey(Equipment.class, Value.class, of("EquipmentSingle"));
    public static final Key<ListValue<Equipment>> EQUIPMENT_LIST = makeListKey(Equipment.class, of("EquipmentList"));
    public static final Key<MapValue<Equipment, Integer>> EQUIPMENT_MAP = makeMapKey(Equipment.class, Integer.class, of("EquipmentMap"));
    public static final Key<ListValue<EquipmentChoices>> EQUIPMENT_CHOICES_LIST = makeListKey(EquipmentChoices.class, of("EquipmentChoicesList"));
    public static final Key<ListValue<EquipmentChoice>> EQUIPMENT_CHOICES = makeListKey(EquipmentChoice.class, of("EquipmentChoices"));
    public static final Key<Value<Dice>> HEIGHT_DICE = makeSingleKey(Dice.class, Value.class, of("HeightDice"));
    public static final Key<Value<HitDice>> HIT_DICE_PROPERTY = makeSingleKey(HitDice.class, Value.class, of("HitDiceProperty"));
    public static final Key<Value<HitPointsProperty>> HP_PROPERTY = makeSingleKey(HitPointsProperty.class, Value.class, of("HitPointsProperty"));
    public static final Key<Value<Integer>> INTEGER = makeSingleKey(Integer.class, Value.class, of("IntegerList"));
    public static final Key<MapValue<Integer, Dice>> INTEGER_DICE_MAP = makeMapKey(Integer.class, Dice.class, of("IntegerDiceMap"));
    public static final Key<ListValue<Integer>> INTEGERS = makeListKey(Integer.class, of("Integers"));
    public static final Key<Value<Boolean>> IS_RITUAL = makeSingleKey(Boolean.class, Value.class, of("IsRitual"));
    public static final Key<ListValue<Language>> LANGUAGES = makeListKey(Language.class, of("Languages"));
    public static final Key<Value<Integer>> MOVEMENT_SPEED = makeSingleKey(Integer.class, Value.class, of("MovementSpeed"));
    public static final Key<Value<String>> NAME = makeSingleKey(String.class, Value.class, of("Name"));
    public static final Key<MapValue<Integer, FeatureList>> FEATURES_MAP = makeMapKey(Integer.class, FeatureList.class, of("FeaturesMap"));
    public static final Key<MapValue<Equipment, Integer>> PACK_CONTENTS = makeMapKey(Equipment.class, Integer.class, of("PackContents"));
    public static final Key<ListValue<PrimalPath>> PRIMAL_PATHS = makeListKey(PrimalPath.class, of("PrimalPathList"));
    public static final Key<Value<ProficienciesProperty>> PROFICIENCIES = makeSingleKey(ProficienciesProperty.class, Value.class, of("Proficiencies"));
    public static final Key<Value<DataContainer>> PROPERTIES = makeSingleKey(DataContainer.class, Value.class, of("Properties"));
    public static final Key<Value<RageProperty>> RAGE_PROPERTY = makeSingleKey(RageProperty.class, Value.class, of("RageProperty"));
    public static final Key<Value<Feature>> RITUAL_CASTING = makeSingleKey(Feature.class, Value.class, of("RitualCasting"));
    public static final Key<ListValue<AbilityScoreType>> SAVING_THROW_PROFICIENCIES = makeListKey(AbilityScoreType.class, of("AbilityScoreProficiencies"));
    public static final Key<Value<String>> SAVING_THROW_STRING = makeSingleKey(String.class, Value.class, of("SavingThrowString"));
    public static final Key<Value<Armor>> SHIELD = makeSingleKey(Armor.class, Value.class, of("Shield"));
    public static final Key<Value<Integer>> SIDES = makeSingleKey(Integer.class, Value.class, of("Shield"));
    public static final Key<Value<SizeProperty>> SIZE_PROPERTY = makeSingleKey(SizeProperty.class, Value.class, of("SizeProperty"));
    public static final Key<Value<Integer>> SKILL_AMOUNT = makeSingleKey(Integer.class, Value.class, of("SkillAmount"));
    public static final Key<MapValue<SkillType, SkillModType>> SKILL_PROFICIENCIES = makeMapKey(SkillType.class, SkillModType.class, of("SkillProficiencies"));
    public static final Key<Value<SkillType>> SKILL_TYPE = makeSingleKey(SkillType.class, Value.class, of("SkillTypeList"));
    public static final Key<ListValue<SkillType>> SKILL_TYPES = makeListKey(SkillType.class, of("SkillType"));
    public static final Key<Value<String>> SKILL_STRING = makeSingleKey(String.class, Value.class, of("SkillString"));
    public static final Key<MapValue<Integer, Dice>> SONG_OF_REST_MAP = makeMapKey(Integer.class, Dice.class, of("SongOfRestMap"));
    public static final Key<Value<Spell>> SPELL = makeSingleKey(Spell.class, Value.class, of("Spell"));
    public static final Key<Value<SpellList>> SPELLS = makeSingleKey(SpellList.class, Value.class, of("Spells"));
    public static final Key<MapValue<Integer, SpellList>> SPElLS_MAP = makeMapKey(Integer.class, SpellList.class, of("SpellsMap"));
    public static final Key<Value<SpellLevel>> SPELL_LEVEL = makeSingleKey(SpellLevel.class, Value.class, of("SpellLevel"));
    public static final Key<Value<Feature>> SPELL_SLOTS = makeSingleKey(Feature.class, Value.class, of("SpellSlots"));
    public static final Key<MapValue<SpellLevel, DualIntegerMap>> SPELL_SLOTS_MAP = makeMapKey(SpellLevel.class, DualIntegerMap.class, of("SpellSlotsMap"));
    public static final Key<Value<Feature>> SPELLCASTING_ABILITY = makeSingleKey(Feature.class, Value.class, of("SpellcastingAbility"));
    public static final Key<Value<Feature>> SPELLCASTING_FOCUS = makeSingleKey(Feature.class, Value.class, of("SpellcastingAbility"));
    public static final Key<Value<SpellcastingTraitProperty>> SPELLCASTING_TRAIT_PROPERTY = makeSingleKey(SpellcastingTraitProperty.class, Value.class, of("SpellcastingTraitProperty"));
    public static final Key<Value<SpellcastingProperty>> SPELLCASTING_PROPERTY = makeSingleKey(SpellcastingProperty.class, Value.class, of("SpellcastingProperty"));
    public static final Key<Value<Feature>> SPELLS_KNOWN = makeSingleKey(Feature.class, Value.class, of("SpellsKnown"));
    public static final Key<Value<DualIntegerMap>> SPELLS_KNOWN_MAP = makeSingleKey(DualIntegerMap.class, Value.class, of("SpellsKnownMap"));
    public static final Key<Value<SpellsKnownSpellcastingProperty>> SPELLS_KNOWN_SPELLCASTING_PROPERTY = makeSingleKey(SpellsKnownSpellcastingProperty.class, Value.class, of("SpellsKnownSpellcastingProperty"));
    public static final Key<MapValue<Integer, Spell>> SPELL_MAP = makeMapKey(Integer.class, Spell.class, of("SpellMap"));
    public static final Key<Value<Integer>> STARTING_LEVEL = makeSingleKey(Integer.class, Value.class, of("StartingLevel"));
    public static final Key<MapValue<String, TraitList>> SUBRACES = makeMapKey(String.class, TraitList.class, of("Subraces"));
    public static final Key<ListValue<Trait>> TRAITS = makeListKey(Trait.class, of("Traits"));
    public static final Key<Value<String>> TOOL_STRING = makeSingleKey(String.class, Value.class, of("ToolString"));
    public static final Key<Value<Tool>> TOOL = makeSingleKey(Tool.class, Value.class, of("Tool"));
    public static final Key<ListValue<Tool>> TOOLS = makeListKey(Tool.class, of("Tools"));
    public static final Key<ListValue<Totem>> TOTEMS = makeListKey(Totem.class, of("Totems"));
    public static final Key<Value<UnarmoredDefenseProperty>> UNARMORED_DEFENSE_PROPERTY = makeSingleKey(UnarmoredDefenseProperty.class, Value.class, of("UnarmoredDefenseProperty"));
    public static final Key<ListValue<Weapon>> WEAPONS = makeListKey(Weapon.class, of("Weapons"));
    public static final Key<ListValue<Weapon>> WEAPON_PROFICIENCIES = makeListKey(Weapon.class, of("WeaponProficiencies"));
    public static final Key<ListValue<WeaponProperty>> WEAPON_PROPERTIES = makeListKey(WeaponProperty.class, of("WeaponProperties"));
    public static final Key<Value<WeaponType>> WEAPON_TYPE = makeSingleKey(WeaponType.class, Value.class, of("WeaponType"));
    public static final Key<Value<String>> WEAPON_STRING = makeSingleKey(String.class, Value.class, of("WeaponString"));
    public static final Key<Value<Double>> WEIGHT = makeSingleKey(Double.class, Value.class, of("Weight"));
    public static final Key<Value<Dice>> WEIGHT_DICE = makeSingleKey(Dice.class, Value.class, of("WeightDice"));
    public static final Key<Value<Integer>> RANGE = makeSingleKey(Integer.class, Value.class, of("Range"));
    public static final Key<Value<SpellComponents>> SPELL_COMPONENTS = makeSingleKey(SpellComponents.class, Value.class, of("SpellComponents"));
    public static final Key<Value<SpellDuration>> SPELL_DURATION = makeSingleKey(SpellDuration.class, Value.class, of("SpellDuration"));
    public static final Key<Value<SpellType>> SPELL_TYPE = makeSingleKey(SpellType.class, Value.class, of("SpellType"));
    public static final Key<Value<Double>> DURATION = makeSingleKey(Double.class, Value.class, of("Duration"));
    public static final Key<Value<Boolean>> NEEDS_CONCENTRATION = makeSingleKey(Boolean.class, Value.class, of("NeedsConcentration"));
    public static final Key<Value<Boolean>> IS_VERBAL = makeSingleKey(Boolean.class, Value.class, of("IsVerbal"));
    public static final Key<Value<Boolean>> IS_SOMATIC = makeSingleKey(Boolean.class, Value.class, of("IsSomatic"));
    public static final Key<Value<String>> MATERIALS = makeSingleKey(String.class, Value.class, of("Materials"));
    public static final Key<Value<AbilityScoreType>> SAVING_THROW = makeSingleKey(AbilityScoreType.class, Value.class, of("SavingThrow"));
    public static final Key<MapValue<SpellLevel, Integer>> SPELL_LEVEL_INTEGER_MAP = makeMapKey(SpellLevel.class, Integer.class, of("SpellLevelIntegerMap"));
    public static final Key<MapValue<SpellLevel, Double>> SPELL_LEVEL_DOUBLE_MAP = makeMapKey(SpellLevel.class, Double.class, of("SpellLevelDoubleMap"));
    public static final Key<ListValue<SpellEffect>> SPELL_EFFECTS = makeListKey(SpellEffect.class, of("SpellEffects"));
    public static final Key<Value<Table>> TABLE = makeSingleKey(Table.class, Value.class, of("Table"));
    public static final Key<Value<DataContainer>> COLUMNS = makeSingleKey(DataContainer.class, Value.class, of("Columns"));
    public static final Key<ListValue<CharacterSize>> SIZE_COLUMN = makeListKey(CharacterSize.class, of("SizeColumn"));
    public static final Key<ListValue<Integer>> HP_COLUMN = makeListKey(Integer.class, of("HPColumn"));
    public static final Key<ListValue<Integer>> AC_COLUMN = makeListKey(Integer.class, of("ACColumn"));
    public static final Key<ListValue<String>> ATTACK_COLUMN = makeListKey(String.class, of("AttackColumn"));
    public static final Key<ListValue<Integer>> STR_COLUMN = makeListKey(Integer.class, of("StrColumn"));
    public static final Key<ListValue<Integer>> DEX_COLUMN = makeListKey(Integer.class, of("DexColumn"));
    public static final Key<Value<DualIntegerFunction>> FUNCTION = makeSingleKey(DualIntegerFunction.class, Value.class, of("Function"));
    public static final Key<MapValue<SpellLevel, Dice>> SPELL_LEVEL_DICE_MAP = makeMapKey(SpellLevel.class, Dice.class, of("SpellLevelDiceMap"));
    public static final Key<ListValue<Condition>> CONDITIONS = makeListKey(Condition.class, of("Conditions"));
    public static final Key<MapValue<Integer, String>> INTEGER_STRING_MAP = makeMapKey(Integer.class, String.class, of("IntegerStringMap"));
    public static final Key<ListValue<Table>> TABLES = makeListKey(Table.class, of("Tables"));
    public static final Key<ListValue<String>> CONNECTION_COLUMN = makeListKey(String.class, of("ConnectionColumn"));
    public static final Key<ListValue<Integer>> SAVE_MODIFIER_COLUMN = makeListKey(Integer.class, of("SaveModifierColumn"));
    public static final Key<ListValue<String>> KNOWLEDGE_COLUMN = makeListKey(String.class, of("KnowledgeColumn"));

    private MCDNDKeys()
    {

    }
}
