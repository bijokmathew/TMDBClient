package com.example.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityArtistBinding
import com.example.tmdbclient.presentation.di.core.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adaptor: ArtistAdaptor
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        viewModel = ViewModelProvider(this,factory)[ArtistViewModel::class.java]
        initRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.action_update -> {
                updateArtistItem()
                true
            }else->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    fun updateArtistItem(){
        binding.artistProgressBar.visibility = View.VISIBLE
        viewModel.updateArtists().observe(
            this,
            Observer {
                if (it != null) {
                    adaptor.setList(it)
                    adaptor.notifyDataSetChanged()
                    binding.artistProgressBar.visibility = View.GONE
                } else {
                    Toast.makeText(this, "No data Found", Toast.LENGTH_LONG).show()
                    binding.artistProgressBar.visibility = View.GONE
                }
            }
        )
    }
    fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this@ArtistActivity)
        adaptor = ArtistAdaptor()
        binding.artistRecyclerView.adapter = adaptor
        displayArtist()
    }
    fun displayArtist(){
        binding.artistProgressBar.visibility=View.VISIBLE
        viewModel.getArtists().observe(
            this,
            Observer {
                if(it !=null){
                    adaptor.setList(it)
                    adaptor.notifyDataSetChanged()
                    binding.artistProgressBar.visibility=View.GONE
                } else{
                    Toast.makeText(this,"No data Found", Toast.LENGTH_LONG).show()
                    binding.artistProgressBar.visibility=View.GONE
                }
            }
        )
    }
}