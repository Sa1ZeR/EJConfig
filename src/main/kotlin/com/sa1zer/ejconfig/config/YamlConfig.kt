package com.sa1zer.ejconfig.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.nio.file.Path

class YamlConfig : BaseConfig {

    private var mapper: ObjectMapper? = null

    constructor(file: Path) : super(file)
    constructor(file: Path, parent: Path) : super(file, parent)
    constructor(fileName: String) : super(fileName) {
    }

    override fun getMapper(): ObjectMapper {
        if(mapper == null) {
            mapper = ObjectMapper(YAMLFactory())
            mapper?.registerKotlinModule()
            mapper?.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            //mapper.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
        }
        return mapper!!
    }

}