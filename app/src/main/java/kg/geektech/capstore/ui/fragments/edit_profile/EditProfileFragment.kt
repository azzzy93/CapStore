package kg.geektech.capstore.ui.fragments.edit_profile

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.navArgs
import kg.geektech.capstore.R
import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.core.extensions.load
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.databinding.FragmentEditProfileBinding

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
    private val args: EditProfileFragmentArgs by navArgs()

    override fun bind(): FragmentEditProfileBinding {
        return FragmentEditProfileBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding.etName.setText(args.userName)
        binding.etEmail.setText(args.userEmail)
        binding.etPhoneNumber.setText(args.userPhone)
        binding.etAddress.setText(args.userAddress)
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            navController.navigateUp()
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