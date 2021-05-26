package com.viper.match

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * created by viper on 2021/5/23
 * desc
 */
abstract class AppDataBase : RoomDatabase() {

    companion object {
        private const val DATA_BASE_NAME = "match.db"

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDataBase::class.java, DATA_BASE_NAME).build()
    }
}