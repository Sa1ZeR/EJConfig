package com.sazer.ejconfig.wrapper

import com.sazer.ejconfig.config.ConfigType
import com.sazer.ejconfig.config.JsonConfig
import com.sazer.ejconfig.config.YamlConfig
import com.sazer.ejconfig.utils.FileUtils
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

object ConfigWrapper {

    @JvmStatic
    fun <T> of(file: Path, config: T): T {
        return when(FileUtils.getFileType(file.fileName.toString())) {
            ConfigType.YAML -> return YamlConfig(file).readOrCreate(config)
            ConfigType.JSON -> return JsonConfig(file).readOrCreate(config)
        }
    }

    @JvmStatic
    fun <T> of(file: String, config: T): T {
        return of(Paths.get(file), config)
    }

    @JvmStatic
    fun <T> of(file: File, config: T): T {
        return of(file.toPath(), config)
    }
}