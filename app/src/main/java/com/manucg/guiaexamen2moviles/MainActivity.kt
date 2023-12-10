package com.manucg.guiaexamen2moviles

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import com.manucg.guiaexamen2moviles.databinding.ActivityMainBinding
import com.manucg.guiaexamen2moviles.modelo.Usuario
import com.manucg.guiaexamen2moviles.ui.Tabs.TabsViewModel
import com.manucg.guiaexamen2moviles.ui.operaciones.OperacionesViewModel
import com.manucg.guiaexamen2moviles.ui.Tabs.usuarios.UsuariosFragment

class MainActivity : AppCompatActivity(), OnInteractionListener, UsuariosFragment.OnListFragmentInteractionListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val operacionesVM: OperacionesViewModel by viewModels()
    lateinit var textMain : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()


        textMain=findViewById(R.id.textMain)
        textMain.text = operacionesVM.numero.toString()
        val buttonDecremento : Button = findViewById(R.id.buttonDecremento)
        buttonDecremento.setOnClickListener {
            operacionesVM.numero -= 1
            textMain.text = operacionesVM.numero.toString()
        }
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

    private fun setup() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_operaciones, R.id.nav_TabsFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onAction(view: View) {
        val v = view as Button
        when (v.id) {
            R.id.buttonIncremento -> {
                textMain.text = operacionesVM.numero.toString()
            }
            R.id.buttonHidden -> {
                var botonera = findViewById<Group>(R.id.botonera)
                if (botonera.visibility == View.GONE){
                    botonera.visibility = View.VISIBLE
                } else {
                    botonera.visibility = View.GONE
                }
            }
            else -> {}
        }
    }

    override fun onListFragmentInteraction(item: Usuario?) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
        val vm : TabsViewModel by viewModels()
        vm.nombre = item!!.nombre
        vm.edad = item!!.edad
        findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.nav_detalleUsuario)
    }

}