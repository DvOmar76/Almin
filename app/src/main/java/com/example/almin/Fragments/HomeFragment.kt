package com.example.almin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.almin.R
import com.example.almin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        binding.btnApi.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_apiFragment)
        }
        binding.btnLocalDB.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_localDatabaseFragment)
        }

        return binding.root
    }


}