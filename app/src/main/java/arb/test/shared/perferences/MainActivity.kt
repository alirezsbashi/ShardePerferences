package arb.test.shared.perferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared = getSharedPreferences("Test" , Context.MODE_PRIVATE)

        save.setOnClickListener {

            val edit = shared.edit()
            edit.putString("txt" , edt.text.toString())
            Toast.makeText(this , "Was Saved" , Toast.LENGTH_SHORT).show()
            edit.apply()
        }

        show.setOnClickListener {

            txt.text = shared.getString("txt" , "No imported" )
            Toast.makeText(this ,  shared.getString("txt" , "No imported" ) , Toast.LENGTH_SHORT).show()
        }

    }
}
