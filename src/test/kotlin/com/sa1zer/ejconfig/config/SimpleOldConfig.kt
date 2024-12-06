package com.sa1zer.ejconfig.config

data class SimpleOldConfig(
    var name: String = "TestVal",
    var number: Int = 10,
    val list: ArrayList<String> = arrayListOf("str1", "str2", "str3", "str4", "str5"),
    val newList: ArrayList<String> = arrayListOf("str1", "str2", "str3", "str4", "str5"),
    var bool: Boolean = true
) {
}