package kg.geektech.capstore.core.ui

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB

}