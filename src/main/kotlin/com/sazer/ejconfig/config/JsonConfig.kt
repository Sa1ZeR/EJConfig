package com.sazer.ejconfig.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.nio.file.Path
class JsonConfig : BaseConfig {

    private var mapper: ObjectMapper? = null

    constructor(file: Path) : super(file)
    constructor(file: Path, parent: Path) : super(file, parent)
    constructor(fileName: String) : super(fileName)

    override fun getMapper(): ObjectMapper {
        if (mapper == null) {
            mapper = ObjectMapper()
            mapper?.registerKotlinModule()
        }

        return mapper!!
    }
}

