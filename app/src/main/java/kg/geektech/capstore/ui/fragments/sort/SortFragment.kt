package kg.geektech.capstore.ui.fragments.sort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentSortBinding

class SortFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSortBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
        binding.tvPopular.setOnClickListener {
            it.setBackgroundResource(R.drawable.back_for_sort_text_selected)
            binding.tvNew.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvCheap.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvExpensive.setBackgroundResource(R.drawable.back_for_sort_text_def)
        }
        binding.tvNew.setOnClickListener {
            it.setBackgroundResource(R.drawable.back_for_sort_text_selected)
            binding.tvPopular.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvCheap.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvExpensive.setBackgroundResource(R.drawable.back_for_sort_text_def)
        }
        binding.tvCheap.setOnClickListener {
            it.setBackgroundResource(R.drawable.back_for_sort_text_selected)
            binding.tvNew.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvPopular.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvExpensive.setBackgroundResource(R.drawable.back_for_sort_text_def)
        }
        binding.tvExpensive.setOnClickListener {
            it.setBackgroundResource(R.drawable.back_for_sort_text_selected)
            binding.tvNew.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvCheap.setBackgroundResource(R.drawable.back_for_sort_text_def)
            binding.tvPopular.setBackgroundResource(R.drawable.back_for_sort_text_def)
        }
    }
}