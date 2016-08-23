package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.subclass.domain.DivineDomain.builder;
import static io.musician101.sponge.mcdnd.util.list.FeatureList.of;

public class DivineDomains
{
    //TODO redo subclasses so that they properly have the level
    public static final DivineDomain KNOWLEDGE_DOMAIN = builder().name("Knowledge Domain")
            .description("The gods of knowledge-including Oghma, Boccob, Gilean, Aureon, and Thoth-value learning and understanding above all. Some teach that knowledge is to be gathered and shared in libraries and universities, or promote the practical knowledge of craft and invention. Some deities hoard knowledge and keep its secrets to themselves. And some promise their followers that they will gain tremendous power if they unlock the secrets of the multiverse. Followers of these gods study esoteric lore, collect old tomes, delve into the secret places of the earth, and learn all they can. Some gods of knowledge promote the practical knowledge of craft and invention, including smith deities like Gond, Reors, Onatar, Moradin, Hephaestus, and Goibhniu.")
            .addToMap(1, of(Arrays.asList(KnowledgeDomain.DOMAIN_SPELLS, KnowledgeDomain.DOMAIN_SPELLS, KnowledgeDomain.BLESSINGS_OF_KNOWLEDGE)))
            .addToMap(2, of(Collections.singletonList(KnowledgeDomain.KNOWLEDGE_OF_THE_AGES)))
            .addToMap(6, of(Collections.singletonList(KnowledgeDomain.READ_THOUGHTS)))
            .addToMap(8, of(Collections.singletonList(KnowledgeDomain.POTENT_SPELLCASTING)))
            .addToMap(17, of(Collections.singletonList(KnowledgeDomain.VISIONS_OF_THE_PAST)))
            .build();
    public static final DivineDomain LIFE_DOMAIN = builder().name("Life Domain")
            .description("The Life domain focuses on the vibrant positive energy-one of the fundamental forces of the universe-that sustains all life. The gods of life promote vitality and health through healing the sick and wounded, caring for those in need, and driving away the forces of death and undeath. Almost any non-evil deity can claim influence over this domain, particularly agricultural deities (such as Chauntea, Arawai, and Demeter), sun gods (such as Lathander, Pelor, and Re-Horakhty), gods of healing or endurance (such as Ilmater, Mishakal, Apollo, and Diancecht), and gods of home and community (such as Hestia, Hathor, and Boldrei).")
            .addToMap(1, of(Arrays.asList(LifeDomain.DOMAIN_SPELLS, LifeDomain.BONUS_PROFICIENCY, LifeDomain.DISCIPLE_OF_LIFE)))
            .addToMap(2, of(Collections.singletonList(LifeDomain.PRESERVE_LIFE)))
            .addToMap(6, of(Collections.singletonList(LifeDomain.BLESSED_HEALER)))
            .addToMap(8, of(Collections.singletonList(LifeDomain.DIVINE_STRIKE)))
            .addToMap(17, of(Collections.singletonList(LifeDomain.SUPREME_HEALING)))
            .build();
    public static final DivineDomain LIGHT_DOMAIN = builder().name("Light Domain")
            .description("Gods of light-including Helm, Lathander, Pholtus, Branchala, the Silver Flame, Belenus, Apollo, and Re-Horakhty-promote the ideals of rebirth and renewal, truth, vigilance, and beauty, often using the symbol of the sun. Some of these gods are portrayed as the sun itself or as a charioteer who guides the sun across the sky. Others are tireless sentinels whose eyes pierce every shadow and see through every deception. Some are deities of beauty and artistry, who teach that art is a vehicle for the soul's improvement. Clerics of a god of light are enlightened souls infused with radiance and the power of their gods' discerning vision, charged with chasing away lies and burning away darkness.")
            .addToMap(1, of(Arrays.asList(LightDomain.DOMAIN_SPELLS, LightDomain.BONUS_CANTRIP, LightDomain.WARDING_FLARE)))
            .addToMap(2, of(Collections.singletonList(LightDomain.RADIANCE_OF_THE_DAWN)))
            .addToMap(6, of(Collections.singletonList(LightDomain.IMPROVED_FLARE)))
            .addToMap(8, of(Collections.singletonList(LightDomain.POTENT_SPELLCASTING)))
            .addToMap(17, of(Collections.singletonList(LightDomain.CORONA_OF_LIGHT)))
            .build();
    public static final DivineDomain NATURE_DOMAIN = builder().name("Nature Domain")
            .description("Gods of nature are as varied as the natural world itself, from inscrutable gods of the deep forests (such as Silvanus, Obad-Hai, Chislev, Balinor, and Pan) to friendly deities associated with particular springs and groves (suc as Eldath). Druids revere nature as a whole and might server one of these deities, practicing mysterious rites and reciting all-but-forgotten prayers in their own secret tongue. But many of these gods have clerics as well, champions who take a more active role in advancing the interests of a particular nature god. These clerics might hunt the evil monstrosities that despoil the woodlands, bless the harvest of the faithful, or wither the crops of those who anger their gods.")
            .addToMap(1, of(Arrays.asList(NatureDomain.DOMAIN_SPELLS, NatureDomain.ACOLYTE_OF_NATURE, NatureDomain.BONUS_PROFICIENCY)))
            .addToMap(2, of(Collections.singletonList(NatureDomain.CHARM_ANIMALS_AND_PLANTS)))
            .addToMap(6, of(Collections.singletonList(NatureDomain.DAMPEN_ELEMENTS)))
            .addToMap(8, of(Collections.singletonList(NatureDomain.DIVINE_STRIKE)))
            .addToMap(17, of(Collections.singletonList(NatureDomain.MASTER_OF_NATURE)))
            .build();
    public static final DivineDomain TEMPEST_DOMAIN = builder().name("Tempest Domain")
            .description("Gods whose portfolios include the tempest domain-including Talos, Umberlee, Kord, Zeboim, the Devourer, Zeus, and Thor-govern storms, sea, and sky. They include gods of lightning and thunder, gods of earthquakes, some fire gods, and certain gods of violence, physical strength, and courage. In some pantheons, a god of this domain rules over other deities and is known for swift justice delivered by thunderbolts. In the pantheons of seafaring people, gods of this domain are ocean deities and the patrons of sailors. Tempest gods send their clerics to inspire fear in the common folk, either to keep those folk on the path of righteousness or to encourage them to offer sacrifices of propitiation to ward off divine wrath.")
            .addToMap(1, of(Arrays.asList(TempestDomain.DOMAIN_SPELLS, TempestDomain.BONUS_PROFICIENCIES, TempestDomain.WRATH_OF_THE_STORM)))
            .addToMap(2, of(Collections.singletonList(TempestDomain.DESTRUCTIVE_WRATH)))
            .addToMap(6, of(Collections.singletonList(TempestDomain.THUNDERBOLT_STRIKE)))
            .addToMap(8, of(Collections.singletonList(TempestDomain.DIVINE_STRIKE)))
            .addToMap(17, of(Collections.singletonList(TempestDomain.STORMBORN)))
            .build();
    public static final DivineDomain TRICKERY_DOMAIN = builder().name("Trickery Domain")
            .description("Gods of trickery-such as Tymora, Beshaba, Olidammara the Traveler, Garl Glittergold, and Loki-are mischief-makers and instigators who stand as a constant challenge to the accepted order among both gods and mortals. They're patrons of thieves scoundrels, gamblers, rebels, and liberators. Their clerics are a disruptive force in the world, puncturing pride, mocking tyrants, stealing from the rich, freeing captives, and flouting hollow traditions. They prefer subterfuge, pranks, deception and theft rather than direct confrontation.")
            .addToMap(1, of(Arrays.asList(TrickeryDomain.DOMAIN_SPELLS, TrickeryDomain.BLESSING_OF_THE_TRICKSTER)))
            .addToMap(2, of(Collections.singletonList(TrickeryDomain.INVOKE_DUPLICITY)))
            .addToMap(6, of(Collections.singletonList(TrickeryDomain.CLOAK_OF_SHADOWS)))
            .addToMap(8, of(Collections.singletonList(TrickeryDomain.DIVINE_STRIKE)))
            .addToMap(17, of(Collections.singletonList(TrickeryDomain.IMPROVED_DUPLICITY)))
            .build();
    public static final DivineDomain WAR_DOMAIN = builder()
            .description("War has many manifestations. It can make heroes of ordinary people. It can be desperate and horrific, with acts of cruelty and cowardice eclipsing instances of excellence and courage. In either case, the gods of war watch over warriors and reward them for their great deeds. The clerics of such gods excel in battle, inspiring others to fight the good fight or offering acts of violence as prayers. Gods of war include champions of honor and chivalry (such as Torm, Heironeous, and Kiri-Jolith) as well as gods of destruction and pillage (such as Erythnul, the Fury, Gruumush, and Ares) and gods of conquest and domination (such as Bane, Hextor, and Maglubiyet). Other war gods (such as Tempus, Nike, and Nuada) take a more neutral stance, promoting war in all its manifestations and supporting warriors in any circumstance.")
            .addToMap(1, of(Arrays.asList(WarDomain.DOMAIN_SPELLS, WarDomain.BONUS_PROFICIENCIES, WarDomain.WAR_PRIEST)))
            .addToMap(2, of(Collections.singletonList(WarDomain.GUIDED_STRIKE)))
            .addToMap(6, of(Collections.singletonList(WarDomain.WAR_GODS_BLESSING)))
            .addToMap(8, of(Collections.singletonList(WarDomain.DIVINE_STRIKE)))
            .addToMap(17, of(Collections.singletonList(WarDomain.AVATAR_OF_BATTLE)))
            .build();

    private DivineDomains()
    {

    }
}
