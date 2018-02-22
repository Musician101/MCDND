package io.musician101.mcdnd.sponge.clazz.feature.subclass.druidcircle;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.mcdnd.sponge.clazz.feature.subclass.druidcircle.DruidCircle.builder;

public class DruidCircles {

    public static final DruidCircle CIRCLE_OF_THE_LAND = builder().name("Circle of the Land").description("The Circle of the Land is made of mystics and sages who safeguard ancient knowledge and rites through a vast oral tradition. These druids meet within sacred circles of trees or standing stones to whisper primal secrets in Druidic. The circle's wisest members preside as the cief priests of communities that hold to the Old Faith and serve as advisors to the rulers of those folk. As a member of this circle, your magic is influenced by the land where you were initiated into the circle's mysterious rites.").addToMap(2, Arrays.asList(CircleOfTheLand.BONUS_CANTRIP, CircleOfTheLand.NATURAL_RECOVERY)).addToMap(3, Collections.singletonList(CircleOfTheLand.CIRCLE_SPELLS)).addToMap(6, Collections.singletonList(CircleOfTheLand.LANDS_STRIDE)).addToMap(10, Collections.singletonList(CircleOfTheLand.NATURES_WARD)).addToMap(14, Collections.singletonList(CircleOfTheLand.NATURES_SANCTUARY)).build();
    public static final DruidCircle CIRCLE_OF_THE_MOON = builder().name("Circle of the Moon").addLineToDescription("Druids of the Circle of the Moon are fierce guardians of the wilds. Their order gathers under the full moon to share news and trade warnings. They haunt the deepest parts of the wilderness, where they might go for weeks on end before crossing paths with another humanoid creature, let alone another druid.").addLineToDescription("Changeable as the moon, a druid of this circle might prowl as a great cat one night, soar over the treetops as an eagle the next day, and crash through the undergrowth in bear form to drive off a trespassing monster. The wild is in the druid's blood.").addToMap(2, Arrays.asList(CircleOfTheMoon.COMBAT_WILD_SHAPE, CircleOfTheMoon.CIRCLE_FORMS)).addToMap(6, Collections.singletonList(CircleOfTheMoon.PRIMAL_STRIKE)).addToMap(10, Collections.singletonList(CircleOfTheMoon.ELEMENTAL_WILD_SHAPE)).addToMap(14, Collections.singletonList(CircleOfTheMoon.THOUSAND_FORMS)).build();

    private DruidCircles() {

    }
}
