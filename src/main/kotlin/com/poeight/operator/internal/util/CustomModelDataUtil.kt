package com.poeight.operator.internal.util

import com.poeight.operator.Operator
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.module.nms.MinecraftVersion
import taboolib.platform.util.sendLang

/**
 *
 * @author poeight
 * @since 2023/12/4 10:35
 * @des TODO
 *
 */

object CustomModelDataUtil {

    fun setCustomModelData(player: Player, itemStack: ItemStack, cmd: Int) {
        // 检查游戏版本
        if(MinecraftVersion.majorLegacy < 11300) {
            player.sendLang("not-support", Operator.prefix)
            return
        }
        // 检查是否有物品
        if (itemStack.type == Material.AIR) {
            player.sendLang("empty-item", Operator.prefix)
            return
        }
        itemStack.itemMeta?.let { itemMeta ->
            // 修改CustomModelData后塞回去
            itemMeta.setCustomModelData(cmd)
            itemStack.itemMeta = itemMeta
        }
    }
}