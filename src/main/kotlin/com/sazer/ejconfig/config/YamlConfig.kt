package com.sazer.ejconfig.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.nio.file.Path

class YamlConfig : BaseConfig {

    private lateinit var mapper: ObjectMapper

    constructor(file: Path) : super(file)
    constructor(file: Path, parent: Path) : super(file, parent)
    constructor(fileName: String) : super(fileName) {
    }

    override fun init() {
            mapper = ObjectMapper(YAMLFactory())
            mapper.registerKotlinModule()
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            //mapper.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
    }

    override fun getMapper(): ObjectMapper = mapper

}