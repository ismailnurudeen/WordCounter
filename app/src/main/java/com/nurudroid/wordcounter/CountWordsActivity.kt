package com.nurudroid.wordcounter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CountWordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Check if the intent that started this activity has the ACTION_PROCESS_TEXT intent action
        if (intent.action == Intent.ACTION_PROCESS_TEXT) {

            // Get selected text from intent extra using the EXTRA_PROCESS_TEXT key
            // And returning an empty string if it's null.
            val selectedText = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT) ?: ""
            Toast.makeText(this,"Selected Text has ${countWords(selectedText)} words",Toast.LENGTH_LONG).show()

            // Very important to end activity immediately if you're not display a layout
            finish()
        }
    }

    private fun countWords(textBlock: String): Int {
        val words = textBlock.split(" ")
        return words.size
    }
}
