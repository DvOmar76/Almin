package com.example.almin.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.almin.DBRoom.ShowDatabase
import com.example.almin.DBRoom.Shows
import com.example.almin.Fragments.LocalDatabaseFragment
import com.example.almin.R
import com.example.almin.databinding.ItemRowLocalBinding

class RVAdapterLocal(val listShow:List<Shows>,val fragment: LocalDatabaseFragment):RecyclerView.Adapter<RVAdapterLocal.RVHolder>() {
    class RVHolder(view: View):RecyclerView.ViewHolder(view){
        val binding=ItemRowLocalBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        return RVHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_row_local,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        with(holder){
            val name=listShow[position].name
            val image=listShow[position].imageUrl
            binding.textView.setText(name)
            if (image=="no Image"){
                Glide.with(binding.imageView2)
                    .load("https://upload.wikimedia.org/wikipedia/commons/0/0a/No-image-available.png")
                    .centerCrop()
                    .into(binding.imageView2)
            }
            Glide.with(binding.imageView2)
                .load(image)
                .centerCrop()
                .into(binding.imageView2)

            binding.btnDelete.setOnClickListener {
                ShowDatabase.getInstance(fragment.requireContext()).ShowDao().deleteShow(listShow[position])
                val list= ShowDatabase.getInstance(fragment.requireContext()).ShowDao().getAll()
                fragment.binding.recyclerViewLocal.adapter= RVAdapterLocal(list,fragment)
                fragment.binding.recyclerViewLocal.layoutManager= LinearLayoutManager(fragment.requireContext())
            }
            binding.linearLayout.setOnClickListener {
                Toast.makeText(fragment.requireContext(), "${listShow[position].summary}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount()=listShow.size
}