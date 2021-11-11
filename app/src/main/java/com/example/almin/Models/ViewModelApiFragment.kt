package com.example.almin.Models

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almin.Adapters.RVAdapter
import com.example.almin.Fragments.ApiFragment
import com.example.almin.Retrofit.APIInterface
import com.example.almin.Retrofit.ApiClint
import com.example.almin.Retrofit.Data
import com.example.almin.Retrofit.Ob
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelApiFragment(application: Application): AndroidViewModel(application) {
    fun search(name: String, fragment: ApiFragment) {
        val listShow=ArrayList<Ob>()

        val apiInterface = ApiClint().getClient()?.create(APIInterface::class.java)
        apiInterface?.search(name)?.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                val r = response.body()
                for (show in r!!) {
                    val name = show.show.name
                    val language = show.show.language
                    val summary = show.show.summary
                    var imageUrl = show.show.image?.medium
                    if (imageUrl.isNullOrEmpty()) {
                        imageUrl = "no Image"
                    }
                    listShow.add(Ob(name, language, summary, imageUrl))
                }
                fragment.binding.recyclerViewApi.adapter = RVAdapter(listShow, fragment)
                fragment.binding.recyclerViewApi.layoutManager =
                    LinearLayoutManager(fragment.requireActivity())


            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Toast.makeText(fragment.context, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}