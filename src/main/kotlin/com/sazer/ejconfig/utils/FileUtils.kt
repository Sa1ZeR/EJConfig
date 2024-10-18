package com.sazer.ejconfig.utils

import com.sazer.ejconfig.config.ConfigType
import com.sazer.ejconfig.exception.ConfigException
import java.io.File

object FileUtils {

    @JvmStatic
    fun getFileType(path: String): ConfigType {
        val splitData = path.split(".")
        if(splitData.size <= 1) throw IllegalArgumentException("File is not valid")

        return when (splitData[splitData.size - 1]) {
            "yml" -> ConfigType.YAML
            "yaml" -> ConfigType.YAML
            "json" -> ConfigType.JSON
            else -> throw ConfigException("Unknown file type: $path")
        }
    }
}