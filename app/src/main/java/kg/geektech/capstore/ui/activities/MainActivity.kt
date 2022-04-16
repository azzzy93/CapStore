package kg.geektech.capstore.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        showOrHideView()
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.bottomNav.setupWithNavController(navController)

        val mBottomNavigationMenuView: BottomNavigationMenuView =
            binding.bottomNav.getChildAt(0) as BottomNavigationMenuView
        val view = mBottomNavigationMenuView.getChildAt(1)
        val itemView: BottomNavigationItemView = view as BottomNavigationItemView
        val cartBadge: View = LayoutInflater.from(this)
            .inflate(R.layout.layout_for_counter, mBottomNavigationMenuView, false)
        cartBadge.findViewById<TextView>(R.id.tv_count).text = "5"
        itemView.addView(cartBadge)
    }

    private fun showOrHideView() {
        if (true) {
            navController.navigate(R.id.startFragment)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNav.isVisible = !(destination.id == R.id.registrationFragment ||
                    destination.id == R.id.restorePasswordFragment ||
                    destination.id == R.id.signInFragment ||
                    destination.id == R.id.startFragment)
        }
    }
}