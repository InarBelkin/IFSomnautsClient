package com.example.ifsomnauts

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.ifsomnauts.databinding.ActivityMainBinding
import com.example.ifsomnauts.models.account.IsAuthDto
import com.example.ifsomnauts.models.account.userDto
import com.example.ifsomnauts.repository.AuthRepository
import com.example.ifsomnauts.repository.connection.NetworkService

import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.prefs.Preferences

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
            ), drawerLayout
        )

        strangeThings();


        navView.setupWithNavController(navController)
    }

    fun strangeThings(){
        var pref = getPreferences(MODE_PRIVATE);
        var aspCookie = pref.getString(getString(R.string.cookieName),"");
        AuthRepository.authCookie.value = aspCookie;

        val cookie:String = AuthRepository.authCookie.value?:"";
        NetworkService.Instance.account.isAuth(cookie).enqueue(object : Callback<IsAuthDto> {
            override fun onResponse(call: Call<IsAuthDto>, response: Response<IsAuthDto>) {
                val auth = response.body();
                if(auth!=null && auth.isAuth){
                    AuthRepository.user.value = auth.user;
                }
                else{
                    AuthRepository.user.value = null;
                }
            }
            override fun onFailure(call: Call<IsAuthDto>, t: Throwable) {
            }
        })

        AuthRepository.authCookie.observe(this, {
            val prefs = getPreferences(MODE_PRIVATE);
            val ed = prefs.edit()
            ed.putString(getString(R.string.cookieName),it);
            ed.apply();
        });



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}