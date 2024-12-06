package com.sa1zer.ejconfig.config

import com.sa1zer.ejconfig.wrapper.ConfigWrapper
import org.junit.jupiter.api.Test

class ConfigWrapperTest {

    @Test
    fun of() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.of("testing/config.yml", config)

        println(wrapConfig.getConfig())
    }

    @Test
    fun wrapJsonConfig() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.of("testing/config.json", config)

        println(wrapConfig.getConfig())
    }

    @Test
    fun wrapJsonOldConfig() {
        val config = SimpleOldConfig()

        val wrapConfig = ConfigWrapper.of("testing/config_old.yml", config)
        wrapConfig.save()

        println(wrapConfig.getConfig())
    }

    @Test
    fun save() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.of("testing/save.yml", config)

        val config1 = wrapConfig.getConfig()
        config1.name = "awdawdadwawdwad"
        config1.bool = false
        config1.number = 11
        config1.list.add("111")
        config1.list.add("7")
        config1.list.add("5")

        wrapConfig.save()

        println(wrapConfig)
    }
}