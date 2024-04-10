package com.hfad.mycountcompose.data

interface ItemsRepository {
    suspend fun insertItem(item: Constanta)
}