package io.musician101.sponge.mcdnd;

import io.musician101.common.java.minecraft.sponge.AbstractSpongePlugin;
import io.musician101.sponge.mcdnd.clazz.feature.FeatureBuilder;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.domain.DivineDomainBuilder;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.PrimalPathBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.AbilityScoreDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.AbilityScoreIncreaseDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.AlignmentDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.ArmorClassDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.ArmorProficiencyDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.CharacterClassDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.HitDiceDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.SavingThrowProficiencyDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.SkillProficiencyDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.builder.WeaponProficiencyDataBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableAbilityScoreData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableAbilityScoreIncreaseData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableAlignmentData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableArmorClassData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableArmorProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableCharacterClassData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableHitDiceData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableSavingThrowProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableSkillProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableWeaponProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreIncreaseData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AlignmentData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorClassData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.CharacterClassData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.HitDiceData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.SavingThrowProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.SkillProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.WeaponProficiencyData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.Alignment;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.data.type.WeaponType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillModType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.magic.SpellBuilder;
import io.musician101.sponge.mcdnd.race.trait.TraitBuilder;
import io.musician101.sponge.mcdnd.registry.AbilityScoreTypeRegistryModule;
import io.musician101.sponge.mcdnd.registry.AlignmentRegistryModule;
import io.musician101.sponge.mcdnd.registry.CharacterClassTypeRegistryModule;
import io.musician101.sponge.mcdnd.registry.skill.SkillModTypeRegistryModule;
import io.musician101.sponge.mcdnd.registry.skill.SkillTypeRegistryModule;
import io.musician101.sponge.mcdnd.registry.spell.SpellLevelRegistryModule;
import io.musician101.sponge.mcdnd.registry.spell.SpellTypeRegistryModule;
import io.musician101.sponge.mcdnd.registry.weapon.WeaponRegistryModule;
import io.musician101.sponge.mcdnd.registry.weapon.WeaponTypeRegistryModule;
import io.musician101.sponge.mcdnd.util.table.TableBuilder;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

//TODO not processing correctly
//TODO add plugin description and author
@Plugin(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
public class SpongeMCDND extends AbstractSpongePlugin
{
    @Listener
    @Override
    public void onServerStart(GameStartedServerEvent gameStartedServerEvent)
    {
        registerCatalogRegistryModules();
        registerBuilders();
        registerDataBuilders();
    }

    private void registerBuilders()
    {
        Sponge.getRegistry().registerBuilderSupplier(DivineDomainBuilder.class, DivineDomainBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(FeatureBuilder.class, FeatureBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(PrimalPathBuilder.class, PrimalPathBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(SpellBuilder.class, SpellBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(TableBuilder.class, TableBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(TraitBuilder.class, TraitBuilder::new);
    }

    private void registerCatalogRegistryModules()
    {
        Sponge.getRegistry().registerModule(AbilityScoreType.class, new AbilityScoreTypeRegistryModule());
        Sponge.getRegistry().registerModule(Alignment.class, new AlignmentRegistryModule());
        Sponge.getRegistry().registerModule(CharacterClassType.class, new CharacterClassTypeRegistryModule());
        Sponge.getRegistry().registerModule(SkillModType.class, new SkillModTypeRegistryModule());
        Sponge.getRegistry().registerModule(SkillType.class, new SkillTypeRegistryModule());
        Sponge.getRegistry().registerModule(SpellType.class, new SpellTypeRegistryModule());
        Sponge.getRegistry().registerModule(SpellLevel.class, new SpellLevelRegistryModule());
        Sponge.getRegistry().registerModule(Weapon.class, new WeaponRegistryModule());
        Sponge.getRegistry().registerModule(WeaponType.class, new WeaponTypeRegistryModule());
    }

    private void registerDataBuilders()
    {
        Sponge.getDataManager().register(AbilityScoreData.class, ImmutableAbilityScoreData.class, new AbilityScoreDataBuilder());
        Sponge.getDataManager().register(AbilityScoreIncreaseData.class, ImmutableAbilityScoreIncreaseData.class, new AbilityScoreIncreaseDataBuilder());
        Sponge.getDataManager().register(AlignmentData.class, ImmutableAlignmentData.class, new AlignmentDataBuilder());
        Sponge.getDataManager().register(ArmorClassData.class, ImmutableArmorClassData.class, new ArmorClassDataBuilder());
        Sponge.getDataManager().register(ArmorProficiencyData.class, ImmutableArmorProficiencyData.class, new ArmorProficiencyDataBuilder());
        Sponge.getDataManager().register(AbilityScoreData.class, ImmutableAbilityScoreData.class, new AbilityScoreDataBuilder());
        Sponge.getDataManager().register(CharacterClassData.class, ImmutableCharacterClassData.class, new CharacterClassDataBuilder());
        Sponge.getDataManager().register(HitDiceData.class, ImmutableHitDiceData.class, new HitDiceDataBuilder());
        Sponge.getDataManager().register(SavingThrowProficiencyData.class, ImmutableSavingThrowProficiencyData.class, new SavingThrowProficiencyDataBuilder());
        Sponge.getDataManager().register(SkillProficiencyData.class, ImmutableSkillProficiencyData.class, new SkillProficiencyDataBuilder());
        Sponge.getDataManager().register(WeaponProficiencyData.class, ImmutableWeaponProficiencyData.class, new WeaponProficiencyDataBuilder());
    }

    //TODO remove all hardcoded enum classes
    //TODO NPC: ability score, size, armor class, hit points, resistances, actions
    //TODO go through all registry modules and remove immutablemap as necessary
}
