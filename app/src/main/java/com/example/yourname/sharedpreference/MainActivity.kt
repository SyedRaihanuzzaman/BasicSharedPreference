package com.example.yourname.sharedpreference


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yourname.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        sharedPreferences = getSharedPreferences("NoteData",Context.MODE_PRIVATE)

        binding.saveNoteBtn.setOnClickListener {
            val note = binding.noteEt.text.toString()

            val sharedEdit = sharedPreferences.edit()
            sharedEdit.putString("note",note)
            sharedEdit.apply()
            Toast.makeText(this, "Note Added Successfully", Toast.LENGTH_SHORT).show()
            binding.noteEt.text.clear()
        }


        binding.displayNoteBtn.setOnClickListener {

            val storedNote = sharedPreferences.getString("note","")
            binding.noteTV.text = "$storedNote"
        }

    }
}