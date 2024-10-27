package com.sa1zer.ejconfig.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.sa1zer.ejconfig.exception.ConfigException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

abstract class BaseConfig {

    val file: Path

    constructor(file: Path) {
        this.file = file
    }

    constructor(file: Path, parent: Path) : this(parent.resolve(file)) {
    }

    constructor(fileName: String) : this(Paths.get(fileName)) {

    }

    abstract fun getMapper(): ObjectMapper

    fun createFile() {
        if (!Files.isDirectory(file.parent)) {
            Files.createDirectories(file.parent)
        }
        if (!Files.isRegularFile(file)) {
            Files.createFile(file)
        }
    }

    fun isExists(): Boolean = Files.isRegularFile(file)

    fun <T> fromFile(obj: T): T {
        obj ?: throw ConfigException("Config is null!")

        return fromFile(obj.javaClass)
    }

    fun <T> fromFile(klass: Class<T>): T {
        if(!isExists()) throw ConfigException("Config file does not exist!")

        return getMapper().readValue(file.toFile(), klass)
    }

    fun toFile(obj: Any, rewrite: Boolean = false) {
        if(!isExists()) {
            createFile()
        }

        val data = getMapper().writeValueAsString(obj)

        if(rewrite)
            Files.writeString(file, data, StandardOpenOption.TRUNCATE_EXISTING)
        else Files.writeString(file, data)
    }

    fun <T> readOrCreate(obj: T): T {
        obj ?: throw ConfigException("Config is null!")

        if(!isExists())
            toFile(obj)

        return fromFile(obj.javaClass)
    }

}