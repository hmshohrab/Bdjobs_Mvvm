package com.relevanttech.bdjobs_mvvm.apps.core.data.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.Message

@Database(
    entities = [Message::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {


    companion object {
        private val DB_NAME = "BuildConfig.DB_NAME"

        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null)
                instance =
                    create(
                        context.applicationContext
                    )

            return instance
        }

        private fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context, AppDatabase::class.java,
                DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}