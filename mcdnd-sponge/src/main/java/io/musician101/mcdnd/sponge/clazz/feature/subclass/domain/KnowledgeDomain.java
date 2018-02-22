package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.skill.SkillTypes;
import io.musician101.mcdnd.sponge.data.type.spell.SpellLevels;
import io.musician101.mcdnd.sponge.magic.Spell;
import io.musician101.mcdnd.sponge.magic.Spells;
import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class KnowledgeDomain {

    public static final Feature BLESSINGS_OF_KNOWLEDGE = builder().name("Blessings of Knowledge").addLineToDescription("At 1st level, you learn two languages of your choice. You also become proficient in your choice of two of the following skills: Arcana, History, Nature, or Religion.").addLineToDescription("Your proficiency bonus is double for any ability check you make that uses either of those skills.").addProperty(MCDNDKeys.SKILL_TYPES, Arrays.asList(SkillTypes.ARCANA, SkillTypes.HISTORY, SkillTypes.NATURE, SkillTypes.RELIGION)).build();
    public static final Feature DOMAIN_SPELLS = builder().name("Knowledge").addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, List<Spell>>builder().put(1, Arrays.asList(Spells.COMMAND, Spells.IDENTIFY)).put(3, Arrays.asList(Spells.AUGURY, Spells.SUGGESTION)).put(5, Arrays.asList(Spells.NONDETECTION, Spells.SPEAK_WITH_DEAD)).put(7, Arrays.asList(Spells.ARCANE_EYE, Spells.CONFUSION)).put(9, Arrays.asList(Spells.LEGEND_LORE, Spells.SCRYING)).build()).build();
    public static final Feature KNOWLEDGE_OF_THE_AGES = builder().name("Channel Divinity: Knowledge of the Ages").levelRequirement(2).description("Starting at 2nd level, you can use your Channel Divinity to tap into a divine well of knowledge. As an action you choose one skill or tool. For 10 minutes, you have proficiency with the chosen skill or tool.").build();
    public static final Feature POTENT_SPELLCASTING = builder().name("Potent Spellcasting").levelRequirement(8).description("Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.").addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM).addProperty(MCDNDKeys.SPELL_LEVEL, SpellLevels.CANTRIP).build();
    public static final Feature READ_THOUGHTS = builder().name("Channel Divinity: Read Thoughts").levelRequirement(6).addLineToDescription("At 6th level, you can use your Channel Divinity to read a creature's thoughts. You can then use your access to the creature's mind to command it.").addLineToDescription("As an action, choose one creature that you can see within 60 feet of you. That creature must make a Wisdom saving throw. If the creature succeeds on the saving throw, you can't use this feature on it again until you finish a long rest.").addLineToDescription("If the creature fails its save, you can read its surface thoughts (those foremost in its mind, reflecting its current emotions and what it is actively thinking about) when it is within 60 feet of you. This effect lasts for 1 minute.").addLineToDescription("During that time, you can use your action to end this effect and cast the Suggestion spell on the creature without expending a spell slot. The target automatically fails its saving throw against the spell.").build();
    public static final Feature VISIONS_OF_THE_PAST = builder().name("Visions of the Past").levelRequirement(17).addLineToDescription("Starting at the 17th level, you can call up visions of the past that relate to an object you hold or your immediate surroundings. You spend at least 1 minute in meditation and prayer, then receive dreamlike, shadowy glimpses of recent events. You can meditate in this way fro a number of minutes equal to your Wisdom score and must maintain concentration during that time, as if you were casting a spell.").addLineToDescription("Once you use this feature, you can't use it again until you finish a short or a long rest.").addLineToDescription("Object Reading: Holding an object as you meditate, you can see visions of the object's previous owner. After meditating for 1 minute, you learn how the owner acquired and lost the object, as well as the most recent significant event involving the object and that owner. If the object was owned by another creature in the recent past (within a number of days equal to your Wisdom score), you can spend 1 additional minute for each owner to learn the same information about that creature.").addLineToDescription("Area Reading: As you meditate, you see visions of recent events in your immediate vicinity (a room, street, tunnel clearing, or the like, up to a 50-foot cube), going back a number of days equal to your Wisdom score. For each minute you meditate, you learn about one significant event, beginning with the most recent. Significant events typically involve powerful emotions, such as battles and betrayals, marriages, and murders, births and funerals. However, they might also include more mundane events that are nevertheless important in your current situation.").build();

    private KnowledgeDomain() {

    }
}
