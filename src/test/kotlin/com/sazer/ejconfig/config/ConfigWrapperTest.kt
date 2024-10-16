package com.sazer.ejconfig.config

import com.sazer.ejconfig.wrapper.ConfigWrapper
import org.junit.jupiter.api.Test

class ConfigWrapperTest {

    @Test
    fun wrapConfig() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.wrapConfig("testing/config.yml", config)

        println(wrapConfig)
    }

    @Test
    fun wrapJsonConfig() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.wrapConfig("testing/config.json", config)

        println(wrapConfig)
    }
}