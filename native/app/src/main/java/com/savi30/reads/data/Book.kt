package com.savi30.reads.data

import java.io.Serializable

data class Book(
    var id: Int? = -1,
    var name: String? = "",
    var authors: List<String>? = mutableListOf(),
    var noPages: Int? = 0,
    var progress: Double? = 0.0,
    var log: List<Log>? = mutableListOf()
) : Serializable