package musician101.mcdnd.clazz.feature;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.util.Interfaces.Listed;
import musician101.mcdnd.util.Interfaces.Mapped;

public class EquipmentChoice
{
	public static class SingleEquipmentFeature extends EquipmentChoice
	{
		int amount;
		Equipment equipment;
		
		public SingleEquipmentFeature(Equipment equipment)
		{
			this(equipment, 1);
		}
		
		public SingleEquipmentFeature(Equipment equipment, int amount)
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
	
	public static class ListEquipmentChoice extends EquipmentChoice implements Listed<Equipment>
	{
		List<Equipment> equipment;
		
		public ListEquipmentChoice(List<Equipment> equipment)
		{
			this.equipment = equipment;
		}
		
		public ListEquipmentChoice(Equipment... equipment)
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
	
	public static class MultipleEquipmentChoice extends EquipmentChoice implements Mapped<Equipment, Integer>
	{
		Map<Equipment, Integer> equipment;
		
		public MultipleEquipmentChoice(Map<Equipment, Integer> equipment)
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
