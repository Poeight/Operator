package com.poeight.operator.command

import com.poeight.operator.internal.util.EnchantUtil
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand

/**
 *
 * @author poeight
 * @since 2023/12/4 12:49
 * @des TODO
 *
 */

object EnchantCommand {

    @CommandBody
    val add = subCommand {
        dynamic("enchant"){
            dynamic("level") {
                execute<Player>() { sender, context, _ ->
                    val item = sender.inventory.itemInMainHand
                    EnchantUtil.addEnchant(sender, item, context["enchant"], context["level"].toInt())
                }
            }
        }
    }

    @CommandBody
    val remove = subCommand {
    dynamic("enchant"){
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                EnchantUtil.removeEnchant(sender, item, context["enchant"])
            }
        }
    }
}