package com.example.dz16permission

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dz16permission.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Тулбар
        var toolbarMain = binding.toolbarMain
        setSupportActionBar(toolbarMain)
        title = " Открытый доступ"
        toolbarMain.subtitle = "  Версия 1.Главная страница"
        toolbarMain.setLogo(R.drawable.pleer)
        //Отработка нажатия клавиши
        binding.cameraBtn.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            permissionLauncherCamera.launch(permission)

        }
        binding.contactsBtn.setOnClickListener {
            val permission = Manifest.permission.READ_CONTACTS
            permissionLauncherContacts.launch(permission)
        }
    }
    //Запрос Исключений и Интент, переход на другие активити
    private val permissionLauncherContacts = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        } else {
            Snackbar.make(binding.root, "Разрешения не предоставлены", Snackbar.LENGTH_LONG).show()
        }
    }

    private val permissionLauncherCamera = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        } else {
            Snackbar.make(binding.root, "Разрешения не предоставлены", Snackbar.LENGTH_LONG).show()
        }
    }

    //Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 22.12.2024",
                    Toast.LENGTH_LONG).show()
            }
            R.id.exitMenuMain ->{
                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}