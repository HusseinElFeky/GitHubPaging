package com.husseinelfeky.githubpaging.repository

import androidx.paging.DataSource
import com.husseinelfeky.githubpaging.persistence.dao.GitHubDao
import com.husseinelfeky.githubpaging.persistence.entities.GitHubRepo
import com.husseinelfeky.githubpaging.persistence.entities.User
import com.husseinelfeky.githubpaging.persistence.entities.UserWithRepos

class ReposLocalDataSource(private val gitHubDao: GitHubDao) {

    fun getUsersWithRepos(): DataSource.Factory<Int, UserWithRepos> =
        gitHubDao.getUsersWithRepos()

    suspend fun saveUser(user: User) =
        gitHubDao.insertUser(user)

    suspend fun saveRepo(gitHubRepo: GitHubRepo) =
        gitHubDao.insertRepo(gitHubRepo)
}