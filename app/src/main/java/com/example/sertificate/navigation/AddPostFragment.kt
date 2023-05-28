package com.example.sertificate.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sertificate.R
import com.example.sertificate.databinding.FragmentAddPostBinding
import com.example.sertificate.databinding.FragmentMainBinding

class AddPostFragment : Fragment(R.layout.fragment_add_post) {
    lateinit var binding: FragmentAddPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddPostBinding.bind(view)
    }

}