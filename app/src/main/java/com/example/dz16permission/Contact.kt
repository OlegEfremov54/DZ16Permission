package com.example.dz16permission

data class Contact(val name: String, var phone: String) {
    companion object {
        val list = listOf(
            Contact("Иван", "223344"),
            Contact("Петр", "225566"),
            Contact("Маша", "334411"),
            Contact("Ариша", "676767"),
            Contact("Костя", "232323"),

        )
    }
}