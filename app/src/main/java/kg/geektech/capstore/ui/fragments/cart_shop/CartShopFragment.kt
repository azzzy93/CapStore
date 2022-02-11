package kg.geektech.capstore.ui.fragments.cart_shop

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentCartShopBinding
import kg.geektech.capstore.extensions.showCustomToast
import kg.geektech.capstore.models.Products

class CartShopFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCartShopBinding
    private lateinit var adapter: CartShopAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initView()
        initListeners()
    }

    private fun initView() {
        binding.tvSumValue.text = "0 сом"
        binding.tvDeliveryPrice.text = "0 сом"
    }

    private fun initListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
        binding.btnBuy.setOnClickListener {
            showCustomAlertDialog(getString(R.string.custom_alert_dialog_text))
        }
    }

    private fun showCustomAlertDialog(text: String) {
        val alert = View.inflate(requireContext(), R.layout.custom_alert_dialog, null)
        val textView = alert.findViewById<TextView>(R.id.tv_custom_alert_dialog)
        textView.text = text
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(alert)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val btnToMainPage = alert.findViewById<MaterialButton>(R.id.btn_to_main_page)
        btnToMainPage.setOnClickListener {
            dialog.dismiss()
            dismiss()
            navigateFragment(R.id.homeFragment)
        }
    }

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }

    private fun initAdapter() {
        adapter = CartShopAdapter(fillList())
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter.setOnItemClick(object : CartShopAdapter.OnItemClick {
            override fun onItemClick(sum: String?, btn: String?) {
                if (btn == "trash") {
                    requireContext().showCustomToast(
                        getString(R.string.item_removed_from_cart),
                        requireActivity(),
                        layoutInflater
                    )
                } else if (btn == "sum") {
                    binding.tvSumValue.text = sum
                }
            }
        })
    }

    private fun fillList(): ArrayList<Products> {
        val data = ArrayList<Products>()
        for (i in 0..10) {
            data.add(
                Products(
                    img = R.drawable.img_cap,
                    brand = "Adidas",
                    model = "Golden State Warriors Icon 59FIFTY Fitted Cap",
                    price = 2500,
                    count = 0,
                    size = "S"
                )
            )
        }
        return data
    }
}