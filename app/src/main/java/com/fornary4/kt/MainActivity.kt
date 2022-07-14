package com.fornary4.kt


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fornary4.kt.adapter.FruitAdapter
import com.fornary4.kt.entity.Fruit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private val fruits = mutableListOf(
        Fruit("Apple", R.drawable.apple), Fruit(
            "Banana",
            R.drawable.banana
        ), Fruit("Orange", R.drawable.orange), Fruit(
            "Watermelon",
            R.drawable.watermelon
        ), Fruit("Pear", R.drawable.pear), Fruit(
            "Grape",
            R.drawable.grape
        ), Fruit("Pineapple", R.drawable.pineapple), Fruit(
            "Strawberry",
            R.drawable.strawberry
        ), Fruit("Cherry", R.drawable.cherry), Fruit(
            "Mango",
            R.drawable.mango
        )
    )
    private val fruitList = ArrayList<Fruit>()

    private val drawerLayout: DrawerLayout by lazy {
        findViewById(R.id.drawerLayout)
    }
    private val navigationView: NavigationView by lazy {
        findViewById(R.id.navView)
    }
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        navigationView.setCheckedItem(R.id.navCall)
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Snackbar.make(it, "data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "data restored", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup -> Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

}


