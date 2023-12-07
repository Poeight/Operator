package com.poeight.operator.command

import com.poeight.operator.internal.util.CustomModelDataUtil
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand

/**
 *
 * @author poeight
 * @since 2023/12/4 10:55
 * @des TODO
 *
 */

object CustomModelDataCommand {

    @CommandBody
    val set = subCommand {
        dynamic("custom-model-data") {
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                CustomModelDataUtil.setCustomModelData(sender, item, context["custom-model-data"].toInt())
            }
        }
    }
}