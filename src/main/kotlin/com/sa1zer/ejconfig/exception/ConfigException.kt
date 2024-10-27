package com.sa1zer.ejconfig.exception

import java.io.IOException

class ConfigException : IOException {

    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}