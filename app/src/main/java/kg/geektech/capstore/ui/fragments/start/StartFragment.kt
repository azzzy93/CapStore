package kg.geektech.capstore.ui.fragments.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStartBinding {
        return FragmentStartBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentStartBinding {
        return FragmentStartBinding.bind(view)
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