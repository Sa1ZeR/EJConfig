package com.sazer.ejconfig.wrapper

import com.sazer.ejconfig.config.ConfigType
import com.sazer.ejconfig.config.JsonConfig
import com.sazer.ejconfig.config.YamlConfig
import com.sazer.ejconfig.utils.FileUtils

object ConfigWrapper {

    @JvmStatic
    fun <T> wrapConfig(file: String, config: T): T {
        return when(FileUtils.getFileType(file)) {
            ConfigType.YAML -> return YamlConfig(file).readOrCreate(config)
            ConfigType.JSON -> return JsonConfig(file).readOrCreate(config)
        }
    }
}