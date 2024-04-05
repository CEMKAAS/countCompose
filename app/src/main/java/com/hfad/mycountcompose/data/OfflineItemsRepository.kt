package com.hfad.mycountcompose.data

class OfflineItemsRepository (private val itemDao: ConstantaDao) : ItemsRepository {
    override suspend fun insertItem(item: Constanta) = itemDao.insertConstantaData(item )
}