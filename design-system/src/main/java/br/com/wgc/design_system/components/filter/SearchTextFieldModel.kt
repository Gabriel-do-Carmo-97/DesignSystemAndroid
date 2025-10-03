package br.com.wgc.design_system.components.filter

data class SearchTextFieldModel<T>(
    val title: String,
    val items: List<T>
)