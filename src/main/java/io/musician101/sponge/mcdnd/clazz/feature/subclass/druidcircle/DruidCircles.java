package io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle;

import static io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle.DruidCircle.builder;
import static io.musician101.sponge.mcdnd.util.list.FeatureList.of;

public class DruidCircles
{
    public static final DruidCircle CIRCLE_OF_THE_LAND = builder().name("Circle of the Land")
            .description("The Circle of the Land is made of mystics and sages who safeguard ancient knowledge and rites through a vast oral tradition. These druids meet within sacred circles of trees or standing stones to whisper primal secrets in Druidic. The circle's wisest members preside as the cief priests of communities that hold to the Old Faith and serve as advisors to the rulers of those folk. As a member of this circle, your magic is influenced by the land where you were initiated into the circle's mysterious rites.")
            .addToMap(2, of(CircleOfTheLand.BONUS_CANTRIP, CircleOfTheLand.NATURAL_RECOVERY))
            .addToMap(3, of(CircleOfTheLand.CIRCLE_SPELLS))
            .addToMap(6, of(CircleOfTheLand.LANDS_STRIDE))
            .addToMap(10, of(CircleOfTheLand.NATURES_WARD))
            .addToMap(14, of(CircleOfTheLand.NATURES_SANCTUARY))
            .build();
    public static final DruidCircle CIRCLE_OF_THE_MOON = builder().name("Circle of the Moon")
            .addLineToDescription("Druids of the Circle of the Moon are fierce guardians of the wilds. Their order gathers under the full moon to share news and trade warnings. They haunt the deepest parts of the wilderness, where they might go for weeks on end before crossing paths with another humanoid creature, let alone another druid.")
            .addLineToDescription("Changeable as the moon, a druid of this circle might prowl as a great cat one night, soar over the treetops as an eagle the next day, and crash through the undergrowth in bear form to drive off a trespassing monster. The wild is in the druid's blood.")
            .addToMap(2, of(CircleOfTheMoon.COMBAT_WILD_SHAPE, CircleOfTheMoon.CIRCLE_FORMS))
            .addToMap(6, of(CircleOfTheMoon.PRIMAL_STRIKE))
            .addToMap(10, of(CircleOfTheMoon.ELEMENTAL_WILD_SHAPE))
            .addToMap(14, of(CircleOfTheMoon.THOUSAND_FORMS))
            .build();

    private DruidCircles()
    {

    }
}
