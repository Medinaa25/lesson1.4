package kg.geektech.lesson14.models

import java.io.Serializable

data class News(
    val title: String,
    val createdAt: Long
): Serializable
