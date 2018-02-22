package io.musician101.mcdnd.sponge.data.type.skill;

import io.musician101.mcdnd.sponge.clazz.ProficiencyBonus;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.MCDNDCatalogType;
import java.util.Optional;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(SkillTypes.class)
public class SkillType extends MCDNDCatalogType {

    private final AbilityScoreType type;

    public SkillType(String name, AbilityScoreType type) {
        super(name);
        this.type = type;
    }

    public Optional<Integer> getMod(AbilityScoreData score, ProficiencyBonus bonus, SkillModType skillModType) {
        Optional<Integer> optional = score.get(type);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(skillModType.calculateMod(type.getMod(optional.get()), bonus));
    }

    public AbilityScoreType getScoreType() {
        return type;
    }
}
