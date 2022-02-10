package kg.geektech.capstore.ui.fragments.edit_profile

import android.Manifest
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentEditProfileBinding
import kg.geektech.capstore.extensions.load
import kg.geektech.capstore.extensions.showCustomToast
import kg.geektech.capstore.ui.fragments.profile.ProfileFragment

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()
    }

    private fun initView() {
        if (arguments != null) {
            binding.etName.setText(arguments?.getString(ProfileFragment.BUNDLE_NAME))
            binding.etEmail.setText(arguments?.getString(ProfileFragment.BUNDLE_EMAIL))
            binding.etPhoneNumber.setText(arguments?.getString(ProfileFragment.BUNDLE_PHONE))
            binding.etAddress.setText(arguments?.getString(ProfileFragment.BUNDLE_ADDRESS))
        }
    }

    private fun initListeners() {
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