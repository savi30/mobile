package com.savi30.reads.data

import java.io.Serializable
import java.sql.Timestamp

data class Log(
    var timestamp: Timestamp,
    var pagesRead: Int,
    var notes: String
) : Serializable
