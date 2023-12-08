package com.poeight.operator.internal.util

import com.poeight.operator.Operator
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.sendLang
import java.util.*

/**
 *
 * @author poeight
 * @since 2023/12/4 13:06
 * @des TODO
 *
 */

object EnchantUtil {

    fun addEnchant(player: Player, itemStack: ItemStack, ench: String, level: Int) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        val enchantment = Enchantment.getByName(ench.uppercase(Locale.getDefault()))
        // 检查是否有该附魔
        if(enchantment == null) {
            player.sendLang("enchant-not-found", Operator.prefix)
            return
        }
        itemStack.addUnsafeEnchantment(enchantment, level)
    }

    fun removeAllEnchant(player: Player, itemStack: ItemStack) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        if (itemStack.enchantments.isNotEmpty()) {
            itemStack.enchantments.let {
                for (enchantments in itemStack.enchantments) {
                    itemStack.removeEnchantment(enchantments.key)
                }
            }
        }
    }

    fun removeEnchant(player: Player, itemStack: ItemStack, ench: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        val enchantment = Enchantment.getByName(ench.uppercase(Locale.getDefault()))
        // 检查是否有该附魔
        if(enchantment == null) {
            player.sendLang("enchant-not-found", Operator.prefix)
            return
        }
        // 检查物品上有没有该附魔
        itemStack.enchantments.let {
            if (enchantment !in itemStack.enchantments) {
                player.sendLang("enchant-not-found-in-item", Operator.prefix)
                return
            }
            itemStack.removeEnchantment(enchantment)
        }
    }
}