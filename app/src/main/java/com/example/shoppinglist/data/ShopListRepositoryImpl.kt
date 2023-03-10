package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

//object является singletone, это нужно чтобы, что не получилось так, что на ожном экране мы раюотаем с одним репозиторием, а в другом экране с другим репозиторием

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    init {
        for (i in 0 until 10){
            val item = ShopItem("Name $i",i,true)
            addShopItem(item )
        }
    }
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
       return shopListLD
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)
    }
    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}