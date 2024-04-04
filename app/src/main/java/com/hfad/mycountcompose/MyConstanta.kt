package com.hfad.mycountcompose

class MyConstanta {

    val DB_NAME = "myConts"

    val DB_VERSION = 1 //Версия базы данных

    val TABLE_NAME = "List" // Название таблицы

    val _ID = "id" // Индефикатор НУМЕРАЦИЯ СТРОК

    val TITLE = "NameCount" // Название описание (название счетчика)

    val COUNT = "Count" // Кол-во

    val STEP = "Step" // Шаг счетчика

    val LASTCOUNT = "LactCount" // Последний счетчик

    val TIME = "Time" // Последнее время изменения

    val TABLE_STRUCTURE_PROJECT = ("CREATE TABLE IF NOT EXISTS $TABLE_NAME ($_ID INTEGER PRIMARY KEY," +
            " $TITLE TEXT, $COUNT INTEGER, $STEP INTEGER, $LASTCOUNT INTEGER, $TIME TEXT)")


}