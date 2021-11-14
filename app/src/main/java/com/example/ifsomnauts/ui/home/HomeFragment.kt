package com.example.ifsomnauts.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ifsomnauts.R
import com.example.ifsomnauts.databinding.FragmentHomeBinding
import com.example.ifsomnauts.repository.AuthRepository
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlin.concurrent.fixedRateTimer

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeViewModel =
            ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding.homeViewmodel = homeViewModel;
        binding.lifecycleOwner = viewLifecycleOwner;

        binding.buttonOtherpage.setOnClickListener {
            //findNavController().popBackStack();
            findNavController().navigate(R.id.worldStoryFragment);
        }

        binding.LogoutButton.setOnClickListener {
            AuthUI.getInstance().signOut(requireContext())
                .addOnCompleteListener {
                    AuthRepository.user.value = FirebaseAuth.getInstance().currentUser;
                }
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}