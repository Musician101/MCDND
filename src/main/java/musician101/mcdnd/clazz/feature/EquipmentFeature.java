package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.clazz.feature.EquipmentFeature.EquipmentChoices;
import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.util.Interfaces.Listed;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EquipmentFeature extends ListFeature<EquipmentChoices>
{
    public EquipmentFeature(EquipmentChoices... equipmentChoices)
    {
        super("Equipment", Arrays.asList(equipmentChoices), "You start with the following equipment, in addition to "
                + "the equipment granted by your background:");
    }

    public static class EquipmentChoices extends ListFeature<EquipmentChoice>
    {
        public EquipmentChoices(String description, EquipmentChoice... choices)
        {
            super("EquipmentChoices", Arrays.asList(choices), description);
        }
    }

    public static class EquipmentChoice
    {
        public static class SingleChoice extends EquipmentChoice
        {
            final int amount;
            final Equipment equipment;

            public SingleChoice(Equipment equipment)
            {
                this(equipment, 1);
            }

            public SingleChoice(Equipment equipment, int amount)
            {
                this.equipment = equipment;
                this.amount = amount;
            }

            public Equipment getEquipment()
            {
                return equipment;
            }

            public int getAmount()
            {
                return amount;
            }
        }

        public static class ListChoice extends EquipmentChoice implements Listed<Equipment>
        {
            final List<Equipment> equipment;

            public ListChoice(List<Equipment> equipment)
            {
                this.equipment = equipment;
            }

            public ListChoice(Equipment... equipment)
            {
                this.equipment = Arrays.asList(equipment);
            }

            @Override
            public List<Equipment> getList()
            {
                return equipment;
            }

            @Override
            public Equipment get(int index)
            {
                return equipment.get(index);
            }
        }

        public static class MultipleChoice extends EquipmentChoice implements Mapped<Equipment, Integer>
        {
            final Map<Equipment, Integer> equipment;

            public MultipleChoice(Map<Equipment, Integer> equipment)
            {
                this.equipment = equipment;
            }

            @Override
            public boolean containsKey(Equipment key)
            {
                return equipment.containsKey(key);
            }

            @Override
            public Map<Equipment, Integer> getMap()
            {
                return equipment;
            }

            @Override
            public Integer get(Equipment key)
            {
                return equipment.get(key);
            }
        }
    }
}
