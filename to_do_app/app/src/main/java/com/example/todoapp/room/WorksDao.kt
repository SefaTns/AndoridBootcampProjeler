package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Works

@Dao
interface WorksDao {

    @Query("SELECT * FROM works")
    suspend fun loadWorks() : List<Works>

    @Insert
    suspend fun registry(works: Works)

    @Update
    suspend fun update(works: Works)

    @Delete
    suspend fun delete(works: Works)

    @Query("SELECT * FROM works WHERE work_name like '%' || :search || '%'")
    suspend fun search(search : String) : List<Works>
}