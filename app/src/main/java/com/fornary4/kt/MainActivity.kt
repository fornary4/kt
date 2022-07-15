package com.fornary4.kt


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fornary4.kt.database.AppDatabase
import com.fornary4.kt.databinding.ActivityMainBinding
import com.fornary4.kt.entity.User
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)



        binding.addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        binding.updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }

        binding.deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastname("Hanks")
            }
        }

        binding.queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("forntag", user.toString())
                }
            }
        }
        

    }






}


