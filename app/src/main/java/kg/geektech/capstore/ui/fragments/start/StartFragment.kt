package kg.geektech.capstore.ui.fragments.start

import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun bind(): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.btnSignIn.setOnClickListener {
            navController.navigate(StartFragmentDirections.actionStartFragmentToSignInFragment())
        }

        binding.btnRegAcc.setOnClickListener {
            navController.navigate(StartFragmentDirections.actionStartFragmentToRegistrationFragment())
        }
    }
}