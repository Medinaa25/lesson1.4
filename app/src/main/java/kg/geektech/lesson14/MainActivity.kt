package kg.geektech.lesson14

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.geektech.lesson14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

         navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigate(R.id.boardFragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
        R.id.navigation_profile

        )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val fragment = arrayListOf(R.id.navigation_home,R.id.navigation_notifications,R.id.navigation_dashboard,R.id.navigation_profile)
            if (fragment.contains(destination.id)){
                navView.visibility = View.VISIBLE
            }else{
                navView.visibility = View.GONE

            }
            if (destination.id == R.id.boardFragment)
                supportActionBar?.hide()
            else
                supportActionBar?.show()

            }



    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}