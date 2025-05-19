package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.WorksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var worksRepository: WorksRepository) : ViewModel() {

    fun update(work_id : Int, work_name : String) {
        CoroutineScope(Dispatchers.Main).launch {
            worksRepository.update(work_id, work_name)
        }
    }
}