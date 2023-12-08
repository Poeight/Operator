package com.poeight.operator.command

import com.poeight.operator.internal.util.UnbreakableUtil
import org.bukkit.entity.Player
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper

/**
 *
 * @author poeight
 * @since 2023/11/29 23:35
 * @des TODO
 *
 */
@CommandHeader(name = "operator", aliases =  [ "oper" , "opi" ], permissionDefault = PermissionDefault.OP )
object OperatorCommand {

    @CommandBody
    val main = mainCommand {
        createHelper(true)
    }

    @CommandBody
    val cmd = CustomModelDataCommand

    @CommandBody
    val durability = DurabilityCommand

    @CommandBody
    val enchant = EnchantCommand

    @CommandBody
    val lore = LoreCommand

    @CommandBody
    val material = MaterialCommand

    @CommandBody
    val name = NameCommand

    @CommandBody
    val unbreakable = subCommand {
        dynamic("boolean") {
            execute<Player>() { sender, context, _ ->
                val item = sender.inventory.itemInMainHand
                UnbreakableUtil.setUnbreakable(sender, item, context["boolean"].toBoolean())
            }
        }
    }

}