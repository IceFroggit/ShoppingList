package com.example.shoppinglist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun getShopList(): List<ShopItem>

    fun getShopItem(id:Int): ShopItem

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

}
