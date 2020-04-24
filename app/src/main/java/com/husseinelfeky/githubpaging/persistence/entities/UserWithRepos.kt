package com.husseinelfeky.githubpaging.persistence.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.husseinelfeky.githubpaging.sectionedRecyclerView.bases.DiffUtilable

//data class UserWithRepos(
//        @Embedded
//        val user: User,
//        @Relation(parentColumn = "id", entityColumn = "userId")
//        val repos: List<GitHubRepo>
//): DiffUtilable {
//        override fun getUniqueIdentifier() = user.id
//}

data class UserWithRepos(
        @Embedded
        val user: User,
        @Relation(parentColumn = "id", entityColumn = "userId")
        val repos: List<GitHubRepo>
)