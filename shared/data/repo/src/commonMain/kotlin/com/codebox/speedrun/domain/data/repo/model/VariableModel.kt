package com.codebox.speedrun.domain.data.repo.model

data class VariableModel(
    val id: String,
    val name: String,
    val category: String,
    val scope: String,
    val mandatory: Boolean,
    val userDefined: Boolean,
    val obsoletes: Boolean,
    val isSubcategory: Boolean,
    val values: List<Value>
) {
    data class Value(
        val id: String,
        val label: String,
    )
}
