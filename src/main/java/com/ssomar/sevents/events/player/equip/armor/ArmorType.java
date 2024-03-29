package com.ssomar.sevents.events.player.equip.armor;

import org.bukkit.inventory.ItemStack;

/**
 * @author Arnah
 * @since Jul 30, 2015
 */
public enum ArmorType{
	HELMET(5), CHESTPLATE(6), LEGGINGS(7), BOOTS(8);

	private final int slot;

	ArmorType(int slot){
		this.slot = slot;
	}

	/**
	 * Attempts to match the ArmorType for the specified ItemStack.
	 *
	 * @param itemStack The ItemStack to parse the type of.
	 * @return The parsed ArmorType, or null if not found.
	 */
	public static ArmorType matchType(final ItemStack itemStack, boolean noHead){
		if(PlayerEquipArmorListener.isAirOrNull(itemStack)) return null;
		String type = itemStack.getType().name();
		//System.out.println("type: "+type);
		if(!noHead && (type.endsWith("_SKULL") || type.endsWith("_HEAD"))) return HELMET;
		else if(type.endsWith("_HELMET")) return HELMET;
		else if(type.endsWith("_CHESTPLATE") || type.equals("ELYTRA")) return CHESTPLATE;
		else if(type.endsWith("_LEGGINGS")) return LEGGINGS;
		else if(type.endsWith("_BOOTS")) return BOOTS;
		else if(type.equals("CARVED_PUMPKIN")) return HELMET;
		else return null;
	}

	public static boolean canReplaceUsingHotBar(final ItemStack itemStack){
		if(PlayerEquipArmorListener.isAirOrNull(itemStack)) return false;
		String type = itemStack.getType().name();
		if(type.equals("CARVED_PUMPKIN")) return false;
		return true;
	}

	public int getSlot(){
		return slot;
	}
}