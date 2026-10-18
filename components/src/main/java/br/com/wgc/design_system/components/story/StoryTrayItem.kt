package br.com.wgc.design_system.components.story

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

data class StoryTrayItem(
    val id: String,
    val userName: String,
    val imageUrl: String? = null,
    val storyState: StoryState = StoryState.UNSEEN,
    val isUserStory: Boolean = false
)
