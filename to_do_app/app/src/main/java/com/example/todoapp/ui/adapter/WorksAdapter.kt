package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Works
import com.example.todoapp.R
import com.example.todoapp.databinding.WorkCardTasarimBinding
import com.example.todoapp.ui.fragment.HomepageFragmentDirections
import com.example.todoapp.ui.viewmodel.HomepageViewModel
import com.google.android.material.snackbar.Snackbar

class WorksAdapter(
    var context: Context,
    var worksList: List<Works>,
    var viewModel: HomepageViewModel) : RecyclerView.Adapter<WorksAdapter.WorkCardTasarim>(){


    inner class WorkCardTasarim(var tasarimBinding: WorkCardTasarimBinding) : RecyclerView.ViewHolder(tasarimBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkCardTasarim {
        val tasarimBinding = WorkCardTasarimBinding.inflate(LayoutInflater.from(context), parent, false)
        return WorkCardTasarim(tasarimBinding)
    }

    override fun getItemCount(): Int {
        return worksList.size
    }

    override fun onBindViewHolder(holder: WorkCardTasarim, position: Int) {

        val work = worksList.get(position)
        val t = holder.tasarimBinding

        t.textViewWork.text = work.work_name
        t.cardViewWork.setOnClickListener {
            val temp = HomepageFragmentDirections.detailNav(work = work)
            Navigation.findNavController(it).navigate(temp)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${work.work_name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    //sil(kisi.kisi_id)
                    viewModel.delete(work.work_id)
                }.show()
        }
    }
}