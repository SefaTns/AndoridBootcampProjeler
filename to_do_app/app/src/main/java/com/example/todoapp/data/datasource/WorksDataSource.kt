package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.Works
import com.example.todoapp.room.WorksDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorksDataSource (private var worksDao: WorksDao) {

    suspend fun loadWorks() : List<Works> = withContext(Dispatchers.IO){
        return@withContext worksDao.loadWorks()
    }

    suspend fun registry(works_name : String) {
        val new_work = Works(0, works_name)
        worksDao.registry(new_work)
    }

    suspend fun update(work_id : Int, work_name : String) {
        val updated_work = Works(work_id, work_name)
        worksDao.update(updated_work)
    }

    suspend fun delete(work_id : Int) {
        val deleted_work = Works(work_id, "")
        worksDao.delete(deleted_work)
    }

    suspend fun search(search : String) : List<Works> = withContext(Dispatchers.IO) {
        return@withContext worksDao.search(search)
    }
}