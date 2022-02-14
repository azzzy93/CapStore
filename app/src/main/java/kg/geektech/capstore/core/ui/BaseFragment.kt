package kg.geektech.capstore.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import kg.geektech.capstore.R

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB
    private var _view: View? = null
    protected lateinit var navController: NavController

    protected abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    protected abstract fun bindViewBinding(view: View): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_view == null) {
            binding = inflateViewBinding(inflater, container, savedInstanceState)
            _view = binding.root
        } else {
            binding = bindViewBinding(_view!!)
        }
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        initViews()
        initListeners()
        initViewModel()
    }

    open fun initViews() {}

    open fun initListeners() {}

    open fun initViewModel() {}

    protected fun navigateFragment(resId: Int) {
        navController.navigate(resId)
    }
}