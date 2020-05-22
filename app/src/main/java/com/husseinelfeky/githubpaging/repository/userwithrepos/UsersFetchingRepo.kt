package com.husseinelfeky.githubpaging.repository.userwithrepos

import com.husseinelfeky.githubpaging.common.paging.datasource.common.CachingLayer
import com.husseinelfeky.githubpaging.common.paging.datasource.indexed.IndexedDataSource
import com.husseinelfeky.githubpaging.persistence.entities.User
import io.reactivex.Completable

class UsersFetchingRepo : IndexedDataSource<Int, User>(), CachingLayer {

    private val api = UserWithReposDataSource.gitHubApi

    private val dao = UserWithReposDataSource.gitHubDao

    override fun getPageSize(): Int = 2

    override fun fetchItemsFromNetwork(item: Int, vararg params: Any?) =
        api.getUsers(item, getPageSize())
            .doOnSuccess {
                updateNetworkEndPosition(Int.MAX_VALUE)
            }

    override fun fetchItemsFromDatabase(item: Int, vararg params: Any?) =
        dao.getUsers(getPageSize(), item)
            .doOnSuccess {
                updateDatabaseEndPosition(item, it.size)
            }

    override fun saveItemsToDatabase(itemsList: List<Any>): Completable =
        dao.insertUsers(itemsList as List<User>)
}
