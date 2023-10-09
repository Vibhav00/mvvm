package com.example.mvvmcheck

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.CallAdapter


class FragmentOne(var k:Int,val mainActivity: MainActivity) : Fragment(),CatAdapter.OnClicItem{
      lateinit var btn:Button
      lateinit var viewModelMy: ViewModelMy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val textView:TextView=view.findViewById(R.id.tv)
        viewModelMy=(activity as MainActivity).viewModelMy
        viewModelMy.getCats()
        val recyclerview = view.findViewById<RecyclerView>(R.id.rv)
      btn = view.findViewById(R.id.btn)
        recyclerview.layoutManager = LinearLayoutManager(this.requireContext())
        viewModelMy.catList.observe(this.requireActivity(), Observer {
//            Log.e("vibhav123", it.toString())
            view.findViewById<ProgressBar>(R.id.pb).visibility= View.GONE
            recyclerview.visibility= View.VISIBLE

//            tv.text = it.headers().toString()
            // This will pass the ArrayList to our Adapter
            if(it!=null){



            val adapter =CatAdapter(it,this,mainActivity)
                Toast.makeText(mainActivity,"from fragment ${k}", Toast.LENGTH_SHORT).show()
            recyclerview.adapter = adapter
            }

            // Setting the Adapter with the recyclerview
//        textView.setText(it.toString())
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View= inflater.inflate(R.layout.fragment_one, container, false)

        return view

    }


    override fun onclickItem(pos: Int, cat: Cat) {
        val catDatabase= CatDatabase(0,cat.height,cat.id,cat.url,cat.width)
       val k=viewModelMy.saveCat(catDatabase)
        Log.e("vibhav","succesfully saved 👩‍🦰")
    }

}