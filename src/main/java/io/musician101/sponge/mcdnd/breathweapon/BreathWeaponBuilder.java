package io.musician101.sponge.mcdnd.breathweapon;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.shape.Shape;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BreathWeaponBuilder implements ResettableBuilder<BreathWeapon, BreathWeaponBuilder>
{
    private AbilityScoreType scoreType;
    private MCDNDDamageType damageType;
    private List<String> description = Arrays.asList("You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation", "When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at the 6th level, 4d6 at 11th level, and 5d6 at 16th level.", "After you use your breath weapon, you can't use it again until you complete a short or long rest.");
    private Map<Integer, Dice> diceMap = ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6, 2)).put(6, new Dice(6, 3)).put(11, new Dice(6, 4)).put(16, new Dice(6, 5)).build();
    private Shape shape;
    private String name = "Breath Weapon";

    public BreathWeaponBuilder abilityScoreType(AbilityScoreType scoreType)
    {
        this.scoreType = scoreType;
        return this;
    }

    public BreathWeaponBuilder damageType(MCDNDDamageType damageType)
    {
        this.damageType = damageType;
        return this;
    }

    public BreathWeaponBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public BreathWeaponBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    public BreathWeaponBuilder damageMap(Map<Integer, Dice> diceMap)
    {
        this.diceMap = diceMap;
        return this;
    }

    public BreathWeaponBuilder shape(Shape shape)
    {
        this.shape = shape;
        return this;
    }

    public BreathWeaponBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public BreathWeapon build()
    {
        return new BreathWeapon(name, damageType, scoreType, shape, description, diceMap);
    }

    @Nonnull
    @Override
    public BreathWeaponBuilder from(@Nonnull BreathWeapon value)
    {
        return name(value.getName()).abilityScoreType(value.getValue()).description(value.getDescription())
                .damageMap(value.getMap()).damageType(value.getDamageType());
    }

    @Nonnull
    @Override
    public BreathWeaponBuilder reset()
    {
        scoreType = null;
        damageType = null;
        description = Arrays.asList("You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation", "When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at the 6th level, 4d6 at 11th level, and 5d6 at 16th level.", "After you use your breath weapon, you can't use it again until you complete a short or long rest.");
        diceMap = ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6, 2)).put(6, new Dice(6, 3)).put(11, new Dice(6, 4)).put(16, new Dice(6, 5)).build();
        shape = null;
        name = "Breath Weapon";
        return this;
    }
}
