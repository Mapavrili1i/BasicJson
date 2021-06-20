package com.example.jsoncurrencyapp.model.Test3

data class CaseStudy(
    val app_store_url: String,
    val client: String,
    val hero_image: String,
    val id: Int,
    val is_enterprise: Boolean,
    val sections: List<Section>,
    val teaser: String,
    val title: String,
    val vertical: String
)