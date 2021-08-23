package com.example.shaadi.ui.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaadi.R
import com.example.shaadi.data.entities.UserResult
import com.example.shaadi.databinding.FragmentHomeBinding
import com.example.shaadi.ui.adapter.UserAdapter
import com.example.shaadi.ui.recyclinterface.UserItemActionListener
import com.example.shaadi.ui.viewmodel.HomeViewModel
import com.example.shaadi.utils.Resource
import com.example.shaadi.utils.snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), UserItemActionListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = UserAdapter(this)
        binding.userRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.userRecyclerview.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.usersList.observe(viewLifecycleOwner, {
            when (it.status) {

                Resource.Status.LOADING -> {
                    binding.progressBar.isVisible = true

                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.isVisible = false

                    if (!it.data.isNullOrEmpty()) {
                        binding.tvEmpty.isVisible = false
                        adapter.setItems(ArrayList(it.data))
                    } else {
                        binding.tvEmpty.isVisible = true

                    }

                }
                Resource.Status.ERROR -> {
                    binding.progressBar.isVisible = false
                    it.message?.let { messageString -> snackbar(messageString) }
                }

            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onAcceptButtonClick(user: UserResult) {
        viewModel.accept(user)
    }

    override fun onIgnoreButtonClick(user: UserResult) {
        viewModel.decline(user)
    }


}