package com.codebox.speedrun.domain.networking.api.leaderboards.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VariablesResponse(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "category")
    val category: String,
    @SerialName(value = "scope")
    val scope: Scope,
    @SerialName(value = "mandatory")
    val mandatory: Boolean,
    @SerialName(value = "user-defined")
    val userDefined: Boolean,
    @SerialName(value = "obsoletes")
    val obsoletes: Boolean,
    @SerialName(value = "values")
    val values: Values,
    @SerialName(value = "is-subcategory")
    val isSubcategory: Boolean,
) {
    @Serializable
    data class Scope(
        @SerialName(value = "type")
        val type: String
    )

    @Serializable
    data class Values(
        @SerialName(value = "values")
        val values: Map<String, Label>,
//        @SerialName(value = "default")
//        val default: Any?
    ) {
        @Serializable
        data class Label(
            @SerialName(value = "label")
            val label: String,
        )
    }
}
