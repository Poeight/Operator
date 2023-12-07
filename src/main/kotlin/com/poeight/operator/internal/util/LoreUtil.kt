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
 * @since 2023/11/30 23:48
 * @des TODO
 *
 */

object LoreUtil {

    fun addLore(player: Player, itemStack: ItemStack, description: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 添加lore后塞回去
            itemMeta.lore = (itemMeta.lore ?: ArrayList()).also { lore ->
                lore.addAll(ChatColor.translateAlternateColorCodes('&', description).split("\\n"))
            }
            itemStack.itemMeta = itemMeta
        }
    }

    fun clearLore(player: Player, itemStack: ItemStack) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 清空lore后塞回去
            itemMeta.lore =  (itemMeta.lore ?: ArrayList()).also { lore ->
                lore.clear()
            }
            itemStack.itemMeta = itemMeta
        }
    }

    fun insertLore(player:Player, itemStack: ItemStack, index: String, description: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 插入lore后塞回去
            itemMeta.lore =  (itemMeta.lore ?: ArrayList()).also { lore ->
                lore.add(index.toInt(), description)
            }
            itemStack.itemMeta = itemMeta
        }
    }

    fun removeLore(player: Player, itemStack: ItemStack, index: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        // 拿到所有index, 通过循环挨个删
        itemStack.itemMeta?.let { itemMeta ->
            // 删除指定lore后塞回去
            itemMeta.lore =  (itemMeta.lore ?: ArrayList()).also { lore ->
                lore.removeAt(index.toInt()-1)
            }
            itemStack.itemMeta = itemMeta
        }
    }

}