package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

class ShopListDiffCallback(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    //проверяет являются ли обьекты одинаковыми
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].id == newList[newItemPosition].id)
    }

    //проверяет содержимое обьектов
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        //у дата классов метод Equals переопределен поэтому можно так сделать
        return oldItem == newItem
    }

}