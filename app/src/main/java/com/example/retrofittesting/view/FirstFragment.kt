package com.example.retrofittesting.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofittesting.viewmodel.DataLoaderViewModel
import com.example.retrofittesting.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private val viewModel: DataLoaderViewModel by viewModels()

//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.usersLiveData.observe(viewLifecycleOwner) {
            users->
            binding?.textviewFirst?.text = users.toString()
        }

        binding?.buttonFirst?.setOnClickListener{
            viewModel.loadUsersList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}