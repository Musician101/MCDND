package io.musician101.mcdnd.sponge.handler.spell;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.clazz.ProficiencyBonus;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.combat.MCDNDDamageType;
import io.musician101.mcdnd.sponge.combat.MCDNDDamageTypes;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.CharacterClassData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.FeatureListData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.MCDNDHealthData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.World;

//TODO redo this handler
public class AcidSplashHandler {

    private final AbilityScoreType abilityScoreType = AbilityScoreTypes.DEXTERITY;
    private final MCDNDDamageType damageType = MCDNDDamageTypes.ACID;
    private final Map<Integer, Dice> diceMap = ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6)).put(5, new Dice(6, 2)).put(11, new Dice(6, 3)).put(17, new Dice(6, 4)).build();
    private final List<UUID> entityIds;
    private final UUID playerId;
    private final World world;

    public AcidSplashHandler(List<UUID> entityIds, UUID playerId, World world) {
        this.entityIds = entityIds;
        this.playerId = playerId;
        this.world = world;
    }

    private Optional<Integer> getSaveDC() {
        Optional<Player> playerOptional = Sponge.getServer().getPlayer(playerId);
        if (!playerOptional.isPresent()) {
            return Optional.empty();
        }

        Player player = playerOptional.get();
        Optional<AbilityScoreData> abilityScoreDataOptional = player.get(AbilityScoreData.class);
        if (!abilityScoreDataOptional.isPresent()) {
            return Optional.empty();
        }

        AbilityScoreData abilityScoreData = abilityScoreDataOptional.get();
        Optional<Integer> scoreOptional = abilityScoreData.get(AbilityScoreTypes.DEXTERITY);
        if (!scoreOptional.isPresent()) {
            return Optional.empty();
        }

        int mod = (scoreOptional.get() - 10) / 2;
        Optional<CharacterClassData> characterClassData = player.get(CharacterClassData.class);
        if (!characterClassData.isPresent()) {
            return Optional.empty();
        }

        //arcane trickster, eldritch knight, wizard = 8 + int mod + prof bonus
        //cleric, druid, ranger = 8 + wis mod + prof bonus
        //bard, paladin, sorcerer, warlock = 8 + cha mod + prof bonus
        //TODO left off here
        int proficiencyBonus = ProficiencyBonus.getBonus(characterClassData.get().asMap());
        return Optional.of(8 + mod + proficiencyBonus);
    }

    private int getScoreMod(Player player, CharacterClassData ccd, int score) {
        List<Feature> features = player.get(FeatureListData.class).get().asList();
        Map<CharacterClassType, Integer> map = ccd.asMap();
        Function<Integer, Integer> function = null;
        for (Entry<CharacterClassType, Integer> entry : map.entrySet()) {
            if (function == null) {
                //TODO cannot continue until other classes are complete
                //if (features.contains())
            }
        }

        return 0;
    }

    public void handle() {
        //TODO left off here
        for (UUID entityId : entityIds) {
            Optional<Entity> entityOptional = world.getEntity(entityId);
            if (!entityOptional.isPresent()) {
                continue;
            }

            Entity entity = entityOptional.get();
            Optional<AbilityScoreData> abilityScoreDataOptional = entity.get(AbilityScoreData.class);
            if (!abilityScoreDataOptional.isPresent()) {
                continue;
            }

            AbilityScoreData abilityScoreData = abilityScoreDataOptional.get();
            Map<AbilityScoreType, Integer> map = abilityScoreData.asMap();
            int score = map.get(AbilityScoreTypes.DEXTERITY);
            int mod = (score - 10) / 2;
            int finalScore = score + mod;
            Optional<MCDNDHealthData> healthDataOptional = entity.get(MCDNDHealthData.class);
            if (!healthDataOptional.isPresent()) {
                continue;
            }

            MCDNDHealthData healthData = healthDataOptional.get();
            healthData.asInt();
        }
    }
}
