package com.sazer.ejconfig.config

import com.sazer.ejconfig.wrapper.ConfigWrapper
import org.junit.jupiter.api.Test

class ConfigWrapperTest {

    @Test
    fun of() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.of("testing/config.yml", config)

        println(wrapConfig)
    }

    @Test
    fun wrapJsonConfig() {
        val config = SimpleConfig()

        val wrapConfig = ConfigWrapper.of("testing/config.json", config)

        println(wrapConfig)
    }
}