package ru.stas.todolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_update_screen.*
import kotlinx.android.synthetic.main.activity_update_screen.create_priority
import kotlinx.android.synthetic.main.activity_update_screen.create_title

class UpdateCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_screen)
        val pos = intent.getIntExtra("id",-1)
        if(pos!=1){
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority
            create_title.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateData(pos,title,priority)
            }
        }
    }

    private fun myIntent(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}