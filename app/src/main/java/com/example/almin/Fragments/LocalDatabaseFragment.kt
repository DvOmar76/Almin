package com.example.almin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.almin.databinding.FragmentLocalDatabaseBinding

class LocalDatabaseFragment : Fragment() {
   lateinit var binding: FragmentLocalDatabaseBinding
    val viewModelLocalDBFragment by lazy { ViewModelProvider(requireActivity()).get(com.example.almin.Models.ViewModelLocalDBFragment::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLocalDatabaseBinding.inflate(inflater,container,false)

        viewModelLocalDBFragment.getShows(this)
        return binding.root
    }



}