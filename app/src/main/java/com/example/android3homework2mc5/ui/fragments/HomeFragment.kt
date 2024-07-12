package com.example.android3homework2mc5.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.android3homework2mc5.R
import com.example.android3homework2mc5.databinding.FragmentHomeBinding
import com.example.android3homework2mc5.ui.adapters.PhotosAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    private var photosAdapter: PhotosAdapter? = PhotosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //это проверяет работает или нет
       // Toast.makeText(requireContext(), viewModel.getPhotos().photos.photo.toString(), Toast.LENGTH_LONG).show()

        setupRecyclerView()
        showPhotos()
    }

    private fun setupRecyclerView() {
        photosAdapter?.let {
            binding.rvPhotos.adapter = it
        }
    }

    private fun showPhotos() {
        photosAdapter?.let {
            val photos = viewModel.getPhotos().photos.photo
            it.submitList(photos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        photosAdapter = null
    }
}