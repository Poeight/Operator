package com.poeight.operator.command

import com.poeight.operator.internal.util.NameUtil
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand

/**
 *
 * @author poeight
 * @since 2023/11/30 23:11
 * @des TODO
 *
 */

object NameCommand {

    @CommandBody
    val remove = subCommand {
        execute<Player>() { sender, _, _ ->
            val item = sender.inventory.itemInMainHand
            NameUtil.removeName(sender, item)
        }
    }

    @CommandBody
    val set = subCommand {
        dynamic("name") {
            execute<Player>() { sender, _, argument ->
                val item = sender.inventory.itemInMainHand
                NameUtil.setName(sender, item, argument)
            }
        }
    }

}