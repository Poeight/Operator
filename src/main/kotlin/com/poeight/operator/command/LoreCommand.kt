package com.poeight.operator.command

import com.poeight.operator.internal.util.LoreUtil
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand

/**
 *
 * @author poeight
 * @since 2023/11/30 23:38
 * @des TODO
 *
 */

object LoreCommand {

    @CommandBody
    val add = subCommand {
        dynamic("lore") {
            execute<Player>() { sender, _, argument ->
                val item = sender.inventory.itemInMainHand
                LoreUtil.addLore(sender, item, argument)
            }
        }
    }

    @CommandBody
    val clear = subCommand {
        execute<Player>() { sender, _, _ ->
            val item = sender.inventory.itemInMainHand
            LoreUtil.clearLore(sender, item)
        }
    }

    @CommandBody
    val insert = subCommand {
        dynamic("index") {
            dynamic("lore") {
                execute<Player>() { sender, context, _ ->
                    val item = sender.inventory.itemInMainHand
                    val index = context["index"]
                    val lore = context["lore"]
                    LoreUtil.insertLore(sender, item, index, lore)
                }
            }
        }
    }

    @CommandBody
    val remove = subCommand {
        dynamic("index") {
            execute<Player>() { sender, _, argument ->
                val item = sender.inventory.itemInMainHand
                LoreUtil.removeLore(sender, item, argument)
            }
        }
    }
}