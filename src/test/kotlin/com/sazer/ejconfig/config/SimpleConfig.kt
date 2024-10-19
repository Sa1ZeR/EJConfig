package com.sazer.ejconfig.config

data class SimpleConfig(
    var name: String = "TestVal",
    val number: Int = 10,
    val list: ArrayList<String> = arrayListOf("str1", "str2", "str3", "str4", "str5"),
    val bool: Boolean = true
) {
}