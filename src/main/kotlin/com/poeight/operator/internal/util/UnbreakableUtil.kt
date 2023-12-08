package com.poeight.operator.internal.util

import com.poeight.operator.Operator
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.sendLang

/**
 *
 * @author poeight
 * @since 2023/12/9 1:25
 * @des TODO
 *
 */

object UnbreakableUtil {

    fun setUnbreakable(player: Player, itemStack: ItemStack, boolean: Boolean) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            itemMeta.isUnbreakable = boolean
            itemStack.itemMeta = itemMeta
        }
    }
}