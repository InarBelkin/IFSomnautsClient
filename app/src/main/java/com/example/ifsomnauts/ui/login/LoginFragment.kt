package com.example.ifsomnauts.ui.login

import android.app.Activity.RESULT_OK
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.ifsomnauts.R
import com.example.ifsomnauts.databinding.LoginFragmentBinding
import com.example.ifsomnauts.repository.AuthRepository
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        binding.lifecycleOwner = this;
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
        binding.buttonLogin.setOnClickListener {
            launchSignFlow();
        }

        return binding.root;

    }

    private fun launchSignFlow() {
        var providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build();
        signInLauncher.launch(signInIntent);
    }

    private fun onSignInResult(res: FirebaseAuthUIAuthenticationResult?) {
        val response = res?.idpResponse;
        if (res?.resultCode == RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser;
            AuthRepository.user.value = user;
            findNavController().popBackStack();
        }
    }


}