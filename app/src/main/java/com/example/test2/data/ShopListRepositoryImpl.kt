package com.example.test2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test2.domain.ShopItem
import com.example.test2.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for(i in 0 until 100) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopList(item)
        }
    }

    override fun addShopList(shopItem: ShopItem) {
        shopItem.id = autoIncrementId++
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}