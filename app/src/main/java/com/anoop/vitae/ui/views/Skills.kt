package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.anoop.domain.model.Skill
import com.anoop.vitae.ui.theme.VitaeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Skills(skills: List<Skill>) =
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.sizing2),
        verticalArrangement = Arrangement.Center
    ) {
        skills.forEach {
            Skill(skill = it)
        }
    }

@Composable
fun Skill(skill: Skill) {
    SuggestionChip(
        onClick = {},
        label = {
            Text(
                text = skill.name,
                style = VitaeTheme.typography.labelSmall
            )
        }
    )
}