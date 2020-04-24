package com.husseinelfeky.githubpaging.sectionedRecyclerView.bases

import com.husseinelfeky.githubpaging.sectionedRecyclerView.Section
import com.husseinelfeky.githubpaging.sectionedRecyclerView.SectionParameters

@Suppress("unused")
abstract class BaseSection<T: DiffUtilable>(val items: MutableList<T>, sectionParameters: SectionParameters): Section(sectionParameters) {

    var oldItems: MutableList<T> = items
        private set

    override fun getContentItemsTotal() = items.size

    /**
     * Add items to section.
     */
    fun addItemsToSection(items: MutableList<T>) {
        this.items.addAll(items)
        // Remove duplicates from array
        // items.groupBy { it.getUniqueIdentifier() }.entries.map { it.value.maxBy { it.date } }
        oldItems = this.items
    }

    /**
     * Add item to section.
     */
    fun addItemToSection(item: T) {
        items.add(item)
        oldItems = items
    }

    /**
     * Remove an item from section.
     */
    fun remove(item: T) {
        items.remove(item)
        oldItems = items
    }

    /**
     * Remove all section items.
     */
    fun removeAllItems() {
        items.clear()
        oldItems = items
    }
}