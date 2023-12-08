package com.poeight.operator.internal.util

import com.poeight.operator.Operator
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.sendLang

/**
 *
 * @author poeight
 * @since 2023/11/30 23:13
 * @des TODO
 *
 */

object NameUtil {

    fun removeName(player: Player, itemStack: ItemStack) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 改名后塞回去
            itemMeta.setDisplayName(null)
            itemStack.itemMeta = itemMeta
        }
    }

    fun setName(player: Player, itemStack: ItemStack, name: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 改名后塞回去
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name))
            itemStack.itemMeta = itemMeta
        }
    }
}