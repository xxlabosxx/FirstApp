package com.gustavolabos.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import com.gustavolabos.myapplication.databinding.ActivityMainBinding
import com.gustavolabos.myapplication.databinding.TelaLinearBinding
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}