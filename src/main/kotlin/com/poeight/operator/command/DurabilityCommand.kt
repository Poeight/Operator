package com.poeight.operator.command

import com.poeight.operator.internal.util.DurabilityUtil
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand

/**
 *
 * @author poeight
 * @since 2023/12/4 11:05
 * @des TODO
 *
 */

object DurabilityCommand {

    @CommandBody
    val add = subCommand {
        dynamic("durability"){
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                DurabilityUtil.addDurability(sender, item, context["durability"].toShort())
            }
        }
    }

    @CommandBody
    val fix = subCommand {
        execute<Player>() { sender, _, _ ->
            val item = sender.inventory.itemInMainHand
            DurabilityUtil.fix(sender, item)
        }
    }

    @CommandBody
    val set = subCommand {
        dynamic("durability"){
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                DurabilityUtil.setDurability(sender, item, context["durability"].toShort())
            }
        }
    }

    @CommandBody
    val take = subCommand {
        dynamic("durability"){
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                DurabilityUtil.takeDurability(sender, item, context["durability"].toShort())
            }
        }
    }
}