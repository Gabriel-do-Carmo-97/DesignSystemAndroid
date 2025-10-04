package br.com.wgc.design_system.mock

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.wgc.design_system.components.cards.carddetail.ProductDetailModel
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategoryModel
import br.com.wgc.design_system.components.sections.items.product.ItemSectionCardModel
import java.math.BigDecimal

data object MockData {
    val listItemSectionCircleCategoryModel = listOf(
        ItemSectionCircleCategoryModel(
            name = "HamburgSSSSSuer",
            image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
        ),
        ItemSectionCircleCategoryModel(
            name = "HambuAAAArguer",
            image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
        ),
        ItemSectionCircleCategoryModel(
            name = "HamburaSDguer",
            image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
        ),
        ItemSectionCircleCategoryModel(
            name = "Hambaurguer",
            image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
        )
    )


    val listItemSectionCardModel = listOf(
        ItemSectionCardModel(
            name = "Chocolate",
            price = BigDecimal("3.99"),
            image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
            description = LoremIpsum(100).values.first()
        ),
        ItemSectionCardModel(
            name = "Sorvete",
            price = BigDecimal("5.99"),
            image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
            description = LoremIpsum(100).values.first()
        ),
        ItemSectionCardModel(
            name = "Bolo",
            price = BigDecimal("11.99"),
            image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
            description = LoremIpsum(100).values.first()
        ),


        ItemSectionCardModel(
            name = "Hambudeedededrguer",
            price = BigDecimal("12.99"),
            image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
        ),

        ItemSectionCardModel(
            name = "Pizza",
            price = BigDecimal("19.99"),
            image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
        ),
        ItemSectionCardModel(
            name = "Batata friASCCSAACta",
            price = BigDecimal("7.99"),
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
        ),
        ItemSectionCardModel(
            name = "Cerveja",
            price = BigDecimal("5.99"),
            image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
        ),
        ItemSectionCardModel(
            name = "Refrigerante",
            price = BigDecimal("4.99"),
            image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
        ),
        ItemSectionCardModel(
            name = "Suco",
            price = BigDecimal("7.99"),
            image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
        ),
        ItemSectionCardModel(
            name = "Água",
            price = BigDecimal("2.99"),
            image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
        )
    )


    val listProductDetailModel = listOf(
        ProductDetailModel(
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            imageDescription = "Imagem do produto",
            name = "Batata fritSCACACAa",
            price = BigDecimal("7.99"),
            description = LoremIpsum(100).values.first()
        ),
        ProductDetailModel(
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            imageDescription = "Imagem do produto",
            name = "Batata friCADCADCADta",
            price = BigDecimal("7.99"),
            description = LoremIpsum(100).values.first()
        ),
        ProductDetailModel(
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            imageDescription = "Imagem do produto",
            name = "Batata friCDCDCDta",
            price = BigDecimal("7.99"),
            description = LoremIpsum(100).values.first()
        ),
        ProductDetailModel(
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            imageDescription = "Imagem do produto",
            name = "BataASDASDta frita",
            price = BigDecimal("7.99"),
            description = LoremIpsum(100).values.first()
        ),
        ProductDetailModel(
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            imageDescription = "Imagem do produto",
            name = "BatataSDA frita",
            price = BigDecimal("7.99"),
            description = LoremIpsum(100).values.first()
        )
    )


}