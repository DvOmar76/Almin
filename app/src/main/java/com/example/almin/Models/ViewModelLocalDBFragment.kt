package com.example.almin.Models

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almin.Adapters.RVAdapterLocal
import com.example.almin.DBRoom.ShowDatabase
import com.example.almin.Fragments.LocalDatabaseFragment

class ViewModelLocalDBFragment(application: Application): AndroidViewModel(application)  {

    fun getShows( fragment: LocalDatabaseFragment){
        val list= ShowDatabase.getInstance(fragment.requireContext()).ShowDao().getAll()
        Log.d("asdf555",list.toString())
        if (list.isNotEmpty()){
            fragment.binding.recyclerViewLocal.adapter= RVAdapterLocal(list,fragment)
            fragment.binding.recyclerViewLocal.layoutManager= LinearLayoutManager(fragment.requireContext())
        }
        else{
            Toast.makeText(fragment.requireContext(), "empty", Toast.LENGTH_SHORT).show()
        }

    }
}