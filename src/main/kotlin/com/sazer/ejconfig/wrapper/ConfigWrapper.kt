package com.sazer.ejconfig.wrapper

import com.sazer.ejconfig.config.BaseConfig
import com.sazer.ejconfig.config.ConfigType
import com.sazer.ejconfig.config.JsonConfig
import com.sazer.ejconfig.config.YamlConfig
import com.sazer.ejconfig.utils.FileUtils
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

class ConfigWrapper<T>(
    private val config: BaseConfig,
    private val source: T
) {

    fun getConfig(): T {
        return source
    }

    fun save() {
        config.toFile(source!!, true)
    }

    companion object {

        @JvmStatic
        fun <T> of(file: Path, config: T): ConfigWrapper<T> {
            return when(FileUtils.getFileType(file.fileName.toString())) {
                ConfigType.YAML -> {
                    val yamlConfig = YamlConfig(file)
                    return ConfigWrapper(yamlConfig, yamlConfig.readOrCreate(config))
                }
                ConfigType.JSON -> {
                    val jsonConfig = JsonConfig(file)
                    return ConfigWrapper(jsonConfig, jsonConfig.readOrCreate(config))
                    }
                }
        }

        @JvmStatic
        fun <T> of(file: String, config: T): ConfigWrapper<T> {
            return of(Paths.get(file), config)
        }

        @JvmStatic
        fun <T> of(file: File, config: T): ConfigWrapper<T> {
            return of(file.toPath(), config)
        }
    }
}