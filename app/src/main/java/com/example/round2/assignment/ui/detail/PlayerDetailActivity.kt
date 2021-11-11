package com.example.round2.assignment.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.request.ImageRequest
import com.example.round2.assignment.BR
import com.example.round2.assignment.R
import com.example.round2.assignment.data.models.Data
import com.example.round2.assignment.databinding.ActivityPlayerDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerData = intent.getParcelableExtra<Data>("player")
        binding.apply {
            setVariable(BR.player, playerData)
        }
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
