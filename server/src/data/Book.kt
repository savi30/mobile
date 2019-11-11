data class Book(
    var id: Int? = -1,
    var name: String? = "",
    var authors: List<String>? = mutableListOf(),
    var noPages: Int? = 0,
    var progress: Double? = 0.0,
    var logs: List<Log>? = mutableListOf()
) : Serializable