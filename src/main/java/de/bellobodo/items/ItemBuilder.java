package de.bellobodo.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

	private final ItemStack item;

	private final ItemMeta meta;

	public ItemBuilder(Material material) {
		item = new ItemStack(material);
		meta = item.getItemMeta();
	}


	public ItemBuilder setDamage(final short dmg) {
		item.setDurability(dmg);
		return this;
	}

	public ItemBuilder setDamage(final int dmg) {
		setDamage((short) dmg);
		return this;
	}


	public ItemBuilder setName(final String name) {
		meta.setDisplayName(name);
		return this;
	}

	public ItemBuilder setLore(final List<String> lore) {
		meta.setLore(lore);
		return this;
	}

	public ItemBuilder setLore(final String... lore) {
		return setLore(new ArrayList<>(Arrays.asList(lore)));
	}

	public ItemBuilder appendLore(final List<String> appendLore) {
		List<String> lore = item.getItemMeta().getLore();
		if (lore != null) lore.addAll(appendLore);
		else lore = appendLore;
		return setLore(lore);
	}

	public ItemBuilder enchant(final Enchantment ench) {
		return enchant(ench, ench.getStartLevel());
	}

	public ItemBuilder enchant(final Map<Enchantment, Integer> enchantments) {
		for (Map.Entry<Enchantment, Integer> enchant : enchantments.entrySet()) {
			enchant(enchant.getKey(), enchant.getValue());
		}
		return this;
	}

	public ItemBuilder enchant(final Enchantment ench, final int value) {
		if (item.getType().equals(Material.ENCHANTED_BOOK)) {
			final EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();

			if (meta == null) return this;

			meta.addStoredEnchant(ench, value, true);
		} else {
			item.addUnsafeEnchantment(ench, value);
		}
		return this;
	}

	public ItemBuilder appendLore(final String... appendLore) {
		return appendLore(new ArrayList<>(Arrays.asList(appendLore)));
	}

	public ItemBuilder setAmount(final int amount) {
		item.setAmount(amount);
		return this;
	}

	public ItemBuilder hideFlags(final ItemFlag itemFlag) {
		meta.addItemFlags(itemFlag);
		return this;
	}

	public ItemBuilder hideFlags() {
		hideFlags(ItemFlag.HIDE_ATTRIBUTES);
		hideFlags(ItemFlag.HIDE_DESTROYS);
		hideFlags(ItemFlag.HIDE_DYE);
		hideFlags(ItemFlag.HIDE_ENCHANTS);
		hideFlags(ItemFlag.HIDE_PLACED_ON);
		hideFlags(ItemFlag.HIDE_DESTROYS);
		hideFlags(ItemFlag.HIDE_POTION_EFFECTS);
		hideFlags(ItemFlag.HIDE_ARMOR_TRIM);
		return this;
	}


	public ItemStack build() {
		item.setItemMeta(meta);
		return item;
	}
	
}