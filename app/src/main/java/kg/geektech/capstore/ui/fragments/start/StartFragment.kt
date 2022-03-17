package kg.geektech.capstore.ui.fragments.start

import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun bind(): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.btnSignIn.setOnClickListener {
            navigateFragment(R.id.signInFragment)
        }

        binding.btnRegAcc.setOnClickListener {
            navigateFragment(R.id.registrationFragment)
        }
    }
}