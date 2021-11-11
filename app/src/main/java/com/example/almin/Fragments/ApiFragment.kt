package com.example.almin. Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.almin.DBRoom.Shows
import com.example.almin.Models.ViewModelApiFragment
import com.example.almin.databinding.FragmentApiBinding


class ApiFragment : Fragment() {
    lateinit var binding: FragmentApiBinding
    val viewModelApiFragment by lazy { ViewModelProvider(requireActivity()).get(ViewModelApiFragment::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentApiBinding.inflate(inflater,container,false)
        binding.btnSearch.setOnClickListener {
            val name=binding.edSearch.text.toString()
            if (name.isNotEmpty())
            {
                viewModelApiFragment.search(name,this)
            }
            else
            {
                Toast.makeText(requireContext(), "enter name", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
    companion object{
        lateinit var show:Shows
    }

    }






