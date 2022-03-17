package kg.geektech.capstore.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import kg.geektech.capstore.R

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB
    protected abstract fun bind(): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bind()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
        initViewModel()
    }

    open fun initViews() {}

    open fun initListeners() {}

    open fun initViewModel() {}

    protected fun navigateFragment(fragmentId: Int? = null, bundle: Bundle? = null) {
        val navController =
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
        if (fragmentId != null && bundle != null) {
            navController.navigate(fragmentId, bundle)
        } else if (fragmentId != null && bundle == null) {
            navController.navigate(fragmentId)
        } else {
            navController.navigateUp()
        }
    }
}