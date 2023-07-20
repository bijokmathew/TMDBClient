package com.example.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowBinding
import com.example.tmdbclient.presentation.di.core.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewmodelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adaptor:TvShowAdaptor
    private lateinit var viewModel: TvShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this,factory)[TvShowViewModel::class.java]
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update->{
                updateTvshow()
                true
            } else->{
                super.onOptionsItemSelected(item)
            }
        }

    }

    fun updateTvshow(){
        binding.tvProgressbar.visibility = View.VISIBLE
        viewModel.updateTvshows().observe(
            this,
            Observer {
                if(it !=null){
                    adaptor.setList(it)
                    binding.tvProgressbar.visibility = View.GONE
                    adaptor.notifyDataSetChanged()
                } else {
                    binding.tvProgressbar.visibility = View.GONE
                    Toast.makeText(this,"No Data Available !!", Toast.LENGTH_LONG).show()
                }

            }
        )
    }
    fun initRecyclerView(){
        Log.i("BKM","initRecyclerView")
        binding.apply {
            tvshowRecyclerView.layoutManager = LinearLayoutManager(this@TvShowActivity)
            adaptor = TvShowAdaptor()
            tvshowRecyclerView.adapter = adaptor
            displayTvShow()
        }
    }
    fun displayTvShow(){
        Log.i("BKM","displayTvShow")
        binding.tvProgressbar.visibility = View.VISIBLE
        val result =viewModel.getTvShows().observe(
            this,
            Observer {
                Log.i("BKM","it = ${it}")
                if(it !=null){
                    adaptor.setList(it)
                    binding.tvProgressbar.visibility = View.GONE
                    adaptor.notifyDataSetChanged()
                } else {
                    binding.tvProgressbar.visibility = View.GONE
                    Toast.makeText(this,"No Data Available !!", Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}