package cz.utb.fai.counterviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cz.utb.fai.counterviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //maps
        viewModel.navigateToMaps.observe(this, Observer { shouldNavigate ->
            if (shouldNavigate) {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
                viewModel.onMapsNavigated() // Reset the event state
            }
        })

        binding.btnMap.setOnClickListener {
            viewModel.onOpenMapsClicked()
        }

    }
}