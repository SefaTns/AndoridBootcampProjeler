package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.Works

@Database(entities = [Works::class], version = 1)
abstract class DataBase : RoomDatabase(){
    abstract fun getWorksDao() : WorksDao
}