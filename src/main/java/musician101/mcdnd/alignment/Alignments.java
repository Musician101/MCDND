package musician101.mcdnd.alignment;

import java.util.Arrays;
import java.util.List;

public class Alignments
{
    public static final Alignment LAWFUL_GOOD = new Alignment("Lawful Good", "LG", "Lawful good creatures can be counted on to do the right thing as expected by society.");
    public static final Alignment NEUTRAL_GOOD= new Alignment("Neutral Good", "NG", "Neutral good folk do the best they can to help others according to their needs.");
    public static final Alignment CHAOTIC_GOOD= new Alignment("Chaotic Good", "CG", "Chaotic good creatures act as their conscience directs, with little regard for what others expect.");
    public static final Alignment LAWFUL_NEUTRAL= new Alignment("Lawful Neutral", "LN", "Lawful neutral individuals act in accordance with law, tradition, or personal codes.");
    public static final Alignment NEUTRAL= new Alignment("Neutral", "N", "Neutral is the alignment of those who prefer to steer clear of moral questions and don't takes sides, doing what seems best at the time.");
    public static final Alignment CHAOTIC_NEUTRAL= new Alignment("Chaotic Neutral", "CN", "Chaotic neutral creatures follow their whims, holding their personal freedom above all else.");
    public static final Alignment LAWFUL_EVIL= new Alignment("Lawful Evil", "LE", "Lawful evil creatures methodically take what they want, within the limits of a code of tradition, loyalty, or order.");
    public static final Alignment NEUTRAL_EVIL= new Alignment("Neutral Evil", "NE", "Neutral evil is the alignment of those who do whatever they can get away with, without compassion or qualms.");
    public static final Alignment CHAOTIC_EVIL= new Alignment("Chaotic Evil", "CE", "Chaotic creatures act with arbitrary violence, spurred by their greed, hatred, or bloodlust.");
    public static final List<Alignment> ALL = Arrays.asList(LAWFUL_GOOD, NEUTRAL_GOOD, CHAOTIC_GOOD, LAWFUL_NEUTRAL, NEUTRAL, LAWFUL_EVIL, NEUTRAL_EVIL);
}
