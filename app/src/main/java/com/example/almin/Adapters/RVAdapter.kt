package com.example.almin.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.almin.DBRoom.ShowDatabase
import com.example.almin.DBRoom.Shows
import com.example.almin.Fragments.ApiFragment
import com.example.almin.R
import com.example.almin.Retrofit.Ob
import com.example.almin.databinding.ItemRowApiBinding

class RVAdapter(val shows:ArrayList<Ob>,val fragment: ApiFragment):RecyclerView.Adapter<RVAdapter.RVHolder>() {
    class RVHolder(view: View):RecyclerView.ViewHolder(view){
        val binding=ItemRowApiBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
       return RVHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.item_row_api,
           parent,
           false
       ))
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
      with(holder){
          val name=shows[position].name
          val language =shows[position].language
          val summary =shows[position].summary
          var imageUrl=shows[position].imageUrl
          binding.btnItemApi.setText(name)
          binding.btnItemApi.setOnClickListener {
              ShowDatabase.getInstance(fragment.requireContext()).ShowDao().addShow(Shows(0,name,language,summary,imageUrl!!))
          }
      }

    }

    override fun getItemCount()=shows.size
}