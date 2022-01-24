package kg.geektech.capstore.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        showOrHideView()
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNav.setupWithNavController(navController)
    }

    private fun showOrHideView() {
        navController.navigate(R.id.startFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.registrationFragment ||
                destination.id == R.id.restorePasswordFragment ||
                destination.id == R.id.signInFragment ||
                destination.id == R.id.startFragment
            ) {
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }
}