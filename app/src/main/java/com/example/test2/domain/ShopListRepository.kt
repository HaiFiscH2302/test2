package com.example.test2.domain

interface ShopListRepository {
    fun addShopList(shopItem: ShopItem)
    fun deleteShopItem(shopIem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList(): List <ShopItem>
}