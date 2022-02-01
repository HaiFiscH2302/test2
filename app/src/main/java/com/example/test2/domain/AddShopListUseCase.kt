package com.example.test2.domain

class AddShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopList(shopItem: ShopItem) {
        shopListRepository.addShopList(shopItem)
    }
}