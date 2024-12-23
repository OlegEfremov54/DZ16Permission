package com.example.dz16permission

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz16permission.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Адаптер
        val adapter = ContactAdapter(Contact.list)

        //Запускаеm менеджер
        var recyclerViewRV = binding.recyclerViewRV
        recyclerViewRV.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewRV.adapter = adapter

         //Тулбар
        var toolbarContact= binding.toolbarContact
        setSupportActionBar(toolbarContact)

        setSupportActionBar(toolbarContact)
        title = " Открытый доступ"
        toolbarContact.subtitle = "  Версия 1.Страница контактов"
        toolbarContact.setLogo(R.drawable.pleer)

    }

    //Инициализация меню
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