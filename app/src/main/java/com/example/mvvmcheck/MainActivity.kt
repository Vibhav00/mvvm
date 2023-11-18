package com.example.mvvmcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.log

class MainActivity : AppCompatActivity(), CatAdapter.OnClicItem {
    lateinit var viewModelMy: ViewModelMy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val catRepo = CatRepository(DatabaseMain(this))
        val booksViewModelProviderFactory = MyViewModelProviderFactory(application, catRepo)
//        DisplayToast.displayToast(this,"here is the toast ...")
//        val recyclerview = findViewById<RecyclerView>(R.id.rv)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        val tv:TextView=findViewById(R.id.tv)
        viewModelMy =
            ViewModelProvider(this, booksViewModelProviderFactory).get(ViewModelMy::class.java)
        replaceFragment(FragmentOne(5, this))


/**          for shared preferences  **/
//       EncryptedSharedPreferencesderived.getSharedPreferences(this).setName()
//        val sp=EncryptedSharedPreferencesderived.getSharedPreferences(this).getName()
//        Log.e("vibhav",sp)

//        viewModel.catList.observe(this, Observer {
//            Log.e("vibhav123", it.toString())
//            findViewById<ProgressBar>(R.id.pb).visibility= View.GONE
//            recyclerview.visibility= View.VISIBLE

//            tv.text = it.headers().toString()
        // This will pass the ArrayList to our Adapter
//            val adapter =CatAdapter(it)

        // Setting the Adapter with the recyclerview
//            recyclerview.adapter = adapter
//        })

        findViewById<BottomNavigationView>(R.id.bnv).setOnItemSelectedListener {
            when (it.itemId) {

                R.id.home -> replaceFragment(FragmentOne(5, this))
                R.id.profile -> replaceFragment(SecondFragment())
                R.id.settings -> replaceFragment(ThirdFragment())

                else -> {


                }

            }
            true
        }


    }


    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flid, fragment)
        fragmentTransaction.commit()


    }


    override fun onclickItem(pos: Int, cat: Cat) {
        Toast.makeText(this, "from main activity", Toast.LENGTH_SHORT).show()
    }
}