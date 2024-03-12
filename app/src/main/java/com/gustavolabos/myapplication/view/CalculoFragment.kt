package com.gustavolabos.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gustavolabos.myapplication.R
import com.gustavolabos.myapplication.databinding.FragmentCalculoBinding

class CalculoFragment : Fragment() {

    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

//            binding.btnEnviar.setOnClickListener {
//                findNavController().navigate(R.id.homeFragment)
//            }
        }
    }
