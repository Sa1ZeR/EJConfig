package com.sa1zer.ejconfig.config

data class SimpleConfig(
    var name: String = "TestVal",
    var number: Int = 10,
    val list: ArrayList<String> = arrayListOf("str1", "str2", "str3", "str4", "str5"),
    var bool: Boolean = true
) {
}