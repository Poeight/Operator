package com.poeight.operator.internal.util

import com.poeight.operator.Operator
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import taboolib.module.nms.MinecraftVersion
import taboolib.platform.util.sendLang

/**
 *
 * @author poeight
 * @since 2023/12/4 11:07
 * @des TODO
 *
 */

object DurabilityUtil {

    // 增加耐久 -> 减少损耗值
    fun addDurability(player: Player, itemStack: ItemStack, durability: Short) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        if (itemStack.type.maxDurability != 0.toShort()) {
            itemStack.durability.let {
                itemStack.durability = (itemStack.durability - durability).toShort()
            }
        }
    }

    fun fix(player: Player, itemStack: ItemStack) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
/**
 *      似乎不需要分版本, 先注释掉, 需要再改
        when(val version = MinecraftVersion.majorLegacy) {
            // 1.8 - 1.12
            in 0 .. 11299 -> {
                if (itemStack.type.maxDurability != 0.toShort()) itemStack.durability = itemStack.type.maxDurability
            }
            // >= 1.13
            in 11300 .. Int.MAX_VALUE -> {
                itemStack.itemMeta?.let { itemMeta ->
                    // 修改耐久度为最大耐久度
                }
            }
}
*/
        if (itemStack.type.maxDurability != 0.toShort()) itemStack.durability = 0
    }


    // 设置耐久 -> 增加损耗值
    fun setDurability(player: Player, itemStack: ItemStack, durability: Short) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        if (itemStack.type.maxDurability != 0.toShort()) {
            itemStack.durability.let {
                itemStack.durability = (itemStack.type.maxDurability - durability).toShort()
            }
        }
    }

    // 减少耐久 -> 增加损耗值
    fun takeDurability(player: Player, itemStack: ItemStack, durability: Short) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        if (itemStack.type.maxDurability != 0.toShort()) {
            itemStack.durability.let {
                itemStack.durability = (itemStack.durability + durability).toShort()
            }
        }
    }
}