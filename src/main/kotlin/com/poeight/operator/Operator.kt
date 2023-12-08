package com.poeight.operator

import org.bukkit.Bukkit
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.module.chat.colored
import taboolib.module.lang.sendLang
import taboolib.platform.BukkitPlugin

object Operator : Plugin() {

    val server by lazy {
        Bukkit.getBukkitVersion()
    }

    val plugin by lazy {
        BukkitPlugin.getInstance()
    }

    val version by lazy {
        plugin.description.version
    }

    val prefix by lazy {
        "&7[&6Operator&7]".colored()
    }

    override fun onEnable() {
        console().sendLang("plugin-enable", prefix, server, version)
    }
}