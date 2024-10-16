package com.sazer.ejconfig.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.nio.file.Path

class JsonConfig : BaseConfig {

    private lateinit var mapper: ObjectMapper

    constructor(file: Path) : super(file)
    constructor(file: Path, parent: Path) : super(file, parent)
    constructor(fileName: String) : super(fileName)

    override fun init() {
        mapper = ObjectMapper()
        mapper.registerKotlinModule()
    }

    override fun getMapper(): ObjectMapper = mapper
}