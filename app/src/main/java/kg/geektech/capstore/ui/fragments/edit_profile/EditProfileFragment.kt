package kg.geektech.capstore.ui.fragments.edit_profile

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.load
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentEditProfileBinding
import kg.geektech.capstore.ui.fragments.profile.ProfileFragment

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>() {

    private val permReqLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                openGallery()
            }
        }
    private val imageChoseLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                binding.ivUser.load(it.toString())
            }
        }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEditProfileBinding {
        return FragmentEditProfileBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentEditProfileBinding {
        return FragmentEditProfileBinding.bind(view)
    }

    override fun initViews() {
        if (arguments != null) {
            binding.etName.setText(arguments?.getString(ProfileFragment.BUNDLE_NAME))
            binding.etEmail.setText(arguments?.getString(ProfileFragment.BUNDLE_EMAIL))
            binding.etPhoneNumber.setText(arguments?.getString(ProfileFragment.BUNDLE_PHONE))
            binding.etAddress.setText(arguments?.getString(ProfileFragment.BUNDLE_ADDRESS))
        }
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        binding.containerForImageProfile.setOnClickListener {
            permReqLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        binding.btnEditProfile.setOnClickListener {
            requireContext().showCustomToast(
                getString(R.string.profile_changed),
                requireActivity(),
                layoutInflater
            )
        }
    }

    private fun openGallery() {
        imageChoseLauncher.launch("image/*")
    }
}