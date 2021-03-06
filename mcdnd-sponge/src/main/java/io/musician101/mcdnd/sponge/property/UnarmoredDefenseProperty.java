package io.musician101.mcdnd.sponge.property;

import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import java.util.Optional;

public class UnarmoredDefenseProperty implements MCDNDProperty {

    public Optional<Integer> getArmorClass(AbilityScoreData score) {
        AbilityScoreType con = AbilityScoreTypes.CONSTITUTION;
        AbilityScoreType dex = AbilityScoreTypes.DEXTERITY;
        Optional<Integer> conScore = score.get(con);
        Optional<Integer> dexScore = score.get(dex);
        if (!conScore.isPresent()) {
            return Optional.empty();
        }

        if (!dexScore.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(10 + dex.getMod(dexScore.get()) + con.getMod(conScore.get()));
    }
}
