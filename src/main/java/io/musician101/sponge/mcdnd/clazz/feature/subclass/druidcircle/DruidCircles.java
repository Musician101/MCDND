package io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle.DruidCircle.builder;
import static io.musician101.sponge.mcdnd.util.list.FeatureList.of;

public class DruidCircles
{
    public static final DruidCircle CIRCLE_OF_THE_LAND = builder().name("Circle of the Land")
            .description("The Circle of the Land is made of mystics and sages who safeguard ancient knowledge and rites through a vast oral tradition. These druids meet within sacred circles of trees or standing stones to whisper primal secrets in Druidic. The circle's wisest members preside as the cief priests of communities that hold to the Old Faith and serve as advisors to the rulers of those folk. As a member of this circle, your magic is influenced by the land where you were initiated into the circle's mysterious rites.")
            .addToMap(2, of(Arrays.asList(CircleOfTheWind.BONUS_CANTRIP, CircleOfTheWind.NATURAL_RECOVERY)))
            .addToMap(3, of(Collections.singletonList(CircleOfTheWind.CIRCLE_SPELLS)))
            .addToMap(6, of(Collections.singletonList(CircleOfTheWind.LANDS_STRIDE)))
            .addToMap(10, of(Collections.singletonList(CircleOfTheWind.NATURES_WARD)))
            .addToMap(14, of(Collections.singletonList(CircleOfTheWind.NATURES_SANCTUARY)))
            .build();

    //TODO left off here page 62/63
    private DruidCircles()
    {

    }
}
