package com.example.Calculadora_Bolton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

//precisa tbm implementar a interface NavigationView.OnNavigationItemSelectedListener
class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //puxa la na main activity
        var drawerlayout: DrawerLayout = findViewById(R.id.drawer_layout)
        //puxa a toolbar no toolbar.xml, sempre selecionar esse tipo de toolbar
        var tb: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(tb)
        //inicia o navigation view(menu da esquerda)
        var navview: NavigationView = findViewById(R.id.Nav_View)
        navview.setNavigationItemSelectedListener(this)



        // so sei q é o sanduiche
        var act: ActionBarDrawerToggle? = null
        act = ActionBarDrawerToggle(this,drawerlayout,tb,R.string.open,R.string.close )
        drawerlayout.addDrawerListener(act)
        act.setDrawerIndicatorEnabled(true)
        act.syncState()
        //nao vai rodar enquanto nao for la nos temas e criar o noactionbar e botar no androidmanifest.xml
        //android:theme="@style/Theme.DrawerLayout.noActionBar"




        // fragmanager é usado para criar uma instancia de um fragmento
        // e fragtrans é o que adiciona e troca o fragmento
        //var fragManager: FragmentManager? = null
        //var fragTrans: FragmentTransaction? = null

        //vamos carregar o fragmento default pra aplicação nao vir em branco
        //fragManager = supportFragmentManager
        //fragTrans = fragManager.beginTransaction()

        //fragmento default da main page
        val tx = supportFragmentManager.beginTransaction()
        tx.add(R.id.container_fragment, mainFragment())
        tx.commit()


        //fragTrans.add(R.id.container_fragment, fragment: MainFragment)





    }


    //evento de click
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // joga a navbar para esquerda qnd o item for selecionado
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)


        //itens do menu

        if (item.itemId == R.id.homeBTN){
            val tx = supportFragmentManager.beginTransaction()
            //replace pq ja adicionamos antes
            tx.replace(R.id.container_fragment, mainFragment())
            tx.commit()
        }

        if (item.itemId == R.id.BTNboltonAnt){
            val tx = supportFragmentManager.beginTransaction()
            tx.replace(R.id.container_fragment, boltonAnterior())
            tx.commit()
        }

        if (item.itemId == R.id.BTNboltonTot){
            val tx = supportFragmentManager.beginTransaction()
            tx.replace(R.id.container_fragment, boltonTotal())
            tx.commit()
        }

        if (item.itemId == R.id.situ1){
            val tx = supportFragmentManager.beginTransaction()
            tx.replace(R.id.container_fragment, situ1())
            tx.commit()
        }

        if (item.itemId == R.id.situ2){
            val tx = supportFragmentManager.beginTransaction()
            tx.replace(R.id.container_fragment, situ2())
            tx.commit()
        }
        return true
    }



}