package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Works
import com.example.todoapp.data.repo.WorksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(private var worksRepository: WorksRepository) : ViewModel() {

    var worksList = MutableLiveData<List<Works>>()

    init {
        loadWorks()
    }

    fun loadWorks() {
        CoroutineScope(Dispatchers.Main).launch {
            worksList.value = worksRepository.loadWorks()
        }
    }

    fun delete(work_id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            worksRepository.delete(work_id)
            loadWorks()
        }
    }

    fun search(search : String) {
        CoroutineScope(Dispatchers.Main).launch {
            worksList.value = worksRepository.search(search)
        }
    }
}