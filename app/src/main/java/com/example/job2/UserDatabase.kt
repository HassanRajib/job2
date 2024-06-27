package com.example.job2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao

    companion object{
        @Volatile
        private var INSTANC:UserDatabase?=null

        fun getDatabase(context: Context):UserDatabase{
            return INSTANC?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANC = instance
                instance
            }
        }
    }
}