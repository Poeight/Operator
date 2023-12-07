package com.poeight.operator.internal.util

import com.poeight.operator.Operator.prefix
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.sendLang

/**
 *
 * @author poeight
 * @since 2023/11/30 22:23
 * @des TODO
 *
 */

object MaterialUtil {

    fun setMaterial(player: Player, itemStack: ItemStack, material: String) {
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", prefix)
            return
        }
        // 更改物品材质
        itemStack.type = Material.getMaterial(material, false) ?: return
    }
}