package com.hfad.mycountcompose.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ConstantaRepository(private val constantaDao: ConstantaDao) {

    suspend fun insertNewStatisticData(constanta: Constanta) {
        withContext(Dispatchers.IO) {
            constantaDao.insertConstantaData(constanta)
        }
    }

    suspend fun removeStatisticDataById(id: Long) {
        withContext(Dispatchers.IO) {
            constantaDao.deleteStatisticDataById(id)
        }
    }
}