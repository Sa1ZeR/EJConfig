package com.sa1zer.ejconfig.config.printer

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter


class JsonPrettyPrinter() : DefaultPrettyPrinter() {

    init {
        super._arrayIndenter = DefaultIndenter()
        super._objectFieldValueSeparatorWithSpaces = _separators.objectFieldValueSeparator.toString() + " "
    }

    override fun createInstance(): DefaultPrettyPrinter {
        return JsonPrettyPrinter()
    }
}