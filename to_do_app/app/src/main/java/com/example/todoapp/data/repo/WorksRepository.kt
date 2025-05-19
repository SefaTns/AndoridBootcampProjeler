package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.WorksDataSource
import com.example.todoapp.data.entity.Works

class WorksRepository (private var worksDataSource: WorksDataSource) {

    suspend fun loadWorks() : List<Works> = worksDataSource.loadWorks()

    suspend fun registry(work_name : String) = worksDataSource.registry(work_name)

    suspend fun update(work_id : Int, work_name: String) = worksDataSource.update(work_id, work_name)

    suspend fun delete(work_id: Int) = worksDataSource.delete(work_id)

    suspend fun search(search : String) : List<Works> = worksDataSource.search(search)
}