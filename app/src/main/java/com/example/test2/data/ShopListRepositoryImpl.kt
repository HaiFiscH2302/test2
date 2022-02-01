package com.example.test2.data

import com.example.test2.domain.ShopItem
import com.example.test2.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    init {
        for(i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopList(item)
        }
    }

    override fun addShopList(shopItem: ShopItem) {
        shopItem.id = autoIncrementId++
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElem = getShopItem(shopItem.id)
        shopList.remove(oldElem)
        addShopList(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
         return shopList.find {
             it.id == shopItemId
         } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList
    }
}