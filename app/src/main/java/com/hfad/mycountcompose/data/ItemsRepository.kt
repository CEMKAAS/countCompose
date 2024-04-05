package com.hfad.mycountcompose.data

interface ItemsRepository {

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Constanta)
}