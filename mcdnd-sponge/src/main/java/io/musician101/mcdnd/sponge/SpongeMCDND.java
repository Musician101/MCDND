package io.musician101.mcdnd.sponge;

import com.google.inject.Inject;
import io.musician101.mcdnd.sponge.breathweapon.BreathWeaponBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.FeatureBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.college.BardCollegeBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.domain.DivineDomainBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.druidcircle.DruidCircleBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.fightingstyle.FightingStyleBuilder;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.primalpaths.PrimalPathBuilder;
import io.musician101.mcdnd.sponge.condition.ConditionBuilder;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.ActionType;
import io.musician101.mcdnd.sponge.data.type.Alignment;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.data.type.CurrencyType;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorType;
import io.musician101.mcdnd.sponge.data.type.WeaponType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillModType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillType;
import io.musician101.mcdnd.sponge.data.type.spell.SpellLevel;
import io.musician101.mcdnd.sponge.data.type.spell.SpellType;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import io.musician101.mcdnd.sponge.magic.SpellBuilder;
import io.musician101.mcdnd.sponge.magic.spelleffect.SpellEffectBuilder;
import io.musician101.mcdnd.sponge.race.trait.TraitBuilder;
import io.musician101.mcdnd.sponge.reference.Reference;
import io.musician101.mcdnd.sponge.registry.AbilityScoreTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.ActionTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.AlignmentRegistryModule;
import io.musician101.mcdnd.sponge.registry.CharacterClassTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.CurrencyTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.MCDNDArmorTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.skill.SkillModTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.skill.SkillTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.spell.SpellLevelRegistryModule;
import io.musician101.mcdnd.sponge.registry.spell.SpellTypeRegistryModule;
import io.musician101.mcdnd.sponge.registry.weapon.WeaponRegistryModule;
import io.musician101.mcdnd.sponge.registry.weapon.WeaponTypeRegistryModule;
import io.musician101.mcdnd.sponge.util.table.TableBuilder;
import io.musician101.musicianlibrary.java.minecraft.sponge.plugin.AbstractSpongePlugin;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

//TODO not processing correctly
//TODO add plugin description and author
@Plugin(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
public class SpongeMCDND extends AbstractSpongePlugin {

    @Inject
    private PluginContainer pluginContainer;

    public static Optional<SpongeMCDND> instance() {
        return Sponge.getPluginManager().getPlugin(Reference.ID).flatMap(PluginContainer::getInstance).filter(SpongeMCDND.class::isInstance).map(SpongeMCDND.class::cast);
    }

    @Nonnull
    @Override
    public PluginContainer getPluginContainer() {
        return pluginContainer;
    }

    @Listener
    public void preInit(GamePreInitializationEvent event) {
        registerCatalogRegistryModules();
        registerBuilders();
        registerDataBuilders();
    }

    private void registerBuilders() {
        Sponge.getRegistry().registerBuilderSupplier(BardCollegeBuilder.class, BardCollegeBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(BreathWeaponBuilder.class, BreathWeaponBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(ConditionBuilder.class, ConditionBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(DivineDomainBuilder.class, DivineDomainBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(DruidCircleBuilder.class, DruidCircleBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(FeatureBuilder.class, FeatureBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(FightingStyleBuilder.class, FightingStyleBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(PrimalPathBuilder.class, PrimalPathBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(SpellBuilder.class, SpellBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(SpellEffectBuilder.class, SpellEffectBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(TableBuilder.class, TableBuilder::new);
        Sponge.getRegistry().registerBuilderSupplier(TraitBuilder.class, TraitBuilder::new);
    }

    private void registerCatalogRegistryModules() {
        Sponge.getRegistry().registerModule(AbilityScoreType.class, new AbilityScoreTypeRegistryModule());
        Sponge.getRegistry().registerModule(ActionType.class, new ActionTypeRegistryModule());
        Sponge.getRegistry().registerModule(Alignment.class, new AlignmentRegistryModule());
        Sponge.getRegistry().registerModule(CharacterClassType.class, new CharacterClassTypeRegistryModule());
        Sponge.getRegistry().registerModule(CurrencyType.class, new CurrencyTypeRegistryModule());
        Sponge.getRegistry().registerModule(MCDNDArmorType.class, new MCDNDArmorTypeRegistryModule());
        Sponge.getRegistry().registerModule(SkillModType.class, new SkillModTypeRegistryModule());
        Sponge.getRegistry().registerModule(SkillType.class, new SkillTypeRegistryModule());
        Sponge.getRegistry().registerModule(SpellType.class, new SpellTypeRegistryModule());
        Sponge.getRegistry().registerModule(SpellLevel.class, new SpellLevelRegistryModule());
        Sponge.getRegistry().registerModule(Weapon.class, new WeaponRegistryModule());
        Sponge.getRegistry().registerModule(WeaponType.class, new WeaponTypeRegistryModule());
    }

    private <D extends DataManipulator<D, M>, M extends ImmutableDataManipulator<M, D>> void registerData(String dataName, String id, Class<D> manipulatorClass, Class<M> immutableDataClass, DataManipulatorBuilder<D, M> builder) {

    }

    private void registerDataBuilders() {
        //TODO replace with DataRegistration#builder()
        /*Sponge.getDataManager().register(AbilityScoreData.class, ImmutableAbilityScoreData.class, new AbilityScoreDataBuilder());
        Sponge.getDataManager().register(AbilityScoreIncreaseData.class, ImmutableAbilityScoreIncreaseData.class, new AbilityScoreIncreaseDataBuilder());
        Sponge.getDataManager().register(AlignmentData.class, ImmutableAlignmentData.class, new AlignmentDataBuilder());
        Sponge.getDataManager().register(ArmorProficiencyData.class, ImmutableArmorProficiencyData.class, new ArmorProficiencyDataBuilder());
        Sponge.getDataManager().register(CharacterArmorClassData.class, ImmutableCharacterArmorClassData.class, new CharacterArmorClassDataBuilder());
        Sponge.getDataManager().register(CharacterClassData.class, ImmutableCharacterClassData.class, new CharacterClassDataBuilder());
        Sponge.getDataManager().register(EquippedItemsData.class, ImmutableEquippedItemsData.class, new EquippedItemsDataBuilder());
        Sponge.getDataManager().register(FeatureListData.class, ImmutableFeatureListData.class, new FeatureListDataBuilder());
        Sponge.getDataManager().register(HitDiceData.class, ImmutableHitDiceData.class, new HitDiceDataBuilder());
        Sponge.getDataManager().register(MCDNDHealthData.class, ImmutableMCDNDHealthData.class, new MCDNDHealthDataBuilder());
        Sponge.getDataManager().register(SavingThrowProficiencyData.class, ImmutableSavingThrowProficiencyData.class, new SavingThrowProficiencyDataBuilder());
        Sponge.getDataManager().register(SkillProficiencyData.class, ImmutableSkillProficiencyData.class, new SkillProficiencyDataBuilder());
        Sponge.getDataManager().register(WeaponProficiencyData.class, ImmutableWeaponProficiencyData.class, new WeaponProficiencyDataBuilder());*/
    }
    //TODO create registry modules for features, traits, and spells?
    //TODO remove all hardcoded enum classes
    //TODO NPC: ability score, size, armor class, hit points, resistances, actions
    //TODO fix package name so it reads io.musician101.mcdnd.sponge
}
