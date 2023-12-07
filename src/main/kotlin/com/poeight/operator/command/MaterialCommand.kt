package com.poeight.operator.command

import com.poeight.operator.internal.util.MaterialUtil.setMaterial
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.subCommand
import java.util.*

/**
 *
 * @author poeight
 * @since 2023/11/30 22:07
 * @des TODO
 *
 */

object MaterialCommand {

    @CommandBody
    val set = subCommand {
        dynamic("material") {
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                setMaterial(sender, item, context["material"].uppercase(Locale.getDefault()))
            }
        }
    }
}