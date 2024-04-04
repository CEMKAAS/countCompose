package com.hfad.mycountcompose.data

data class ConstantaData(
    val id: Long,
    val title: String, // Название описание (название счетчика)

    val count: Int, // Кол-во

    val step: Int,  // Шаг счетчика

    val lastCost: Int, // Последний счетчик

    val time: String // Последнее время изменения

) {

    fun toStatisticDbEntity(): Constanta = Constanta(
        id = 0,
        title = title,
        count = count,
        step = step,
        lastCost = lastCost,
        time = time
    )

}
