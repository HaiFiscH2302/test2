package com.example.test2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test2.data.ShopListRepositoryImpl
import com.example.test2.domain.DeleteShopItemUseCase
import com.example.test2.domain.EditShopItemUseCase
import com.example.test2.domain.GetShopListUseCase
import com.example.test2.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun editListItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }
}