package com.upb.vlibrary.ui.multimedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upb.vlibrary.databinding.FragmentAdminBinding
import com.upb.vlibrary.databinding.FragmentMultimediaMainBinding

class MultimediaMainFragment: Fragment() {

   private lateinit var binding: FragmentMultimediaMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMultimediaMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}