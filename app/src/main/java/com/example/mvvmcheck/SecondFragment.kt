package com.example.mvvmcheck

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData


class SecondFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        return view;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("vibhavChcek", view.toString())
        val tv: TextView = view.findViewById<TextView>(R.id.tv)
        (activity as MainActivity).viewModelMy.getAllCat().observe(this.requireActivity()) {
            tv.text = it.size.toString()
        }

//        Log.d("vibhavCheck",temp.toString())
//        tv.text=.toString()
        Toast.makeText(this.requireContext(), "from second Fragment ", Toast.LENGTH_SHORT).show()

    }

}