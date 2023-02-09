package com.codebox.speedrun.domain.data.repo.model

import com.codebox.speedrun.domain.data.common.enums.RunTypeEnum
import com.speedrun.domain.repo.common.model.LinkModel

data class CategoryModel(
    val id: String,
    val links: List<LinkModel>,
    val miscellaneous: Boolean,
    val name: String,
    val players: Players,
    val rules: String?,
    val type: RunTypeEnum,
    val weblink: String,
    val variables: List<VariableModel>
) {
    data class Players(
        val type: String,
        val value: Int
    )
}
