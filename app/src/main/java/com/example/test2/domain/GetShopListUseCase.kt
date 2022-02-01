package com.example.test2.domain

class GetShopListUseCase (private val shopListRepository: ShopListRepository){
    fun getShopList(): List <ShopItem> {
        return shopListRepository.getShopList()
    }
}