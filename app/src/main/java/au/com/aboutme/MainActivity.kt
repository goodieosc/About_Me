package au.com.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import au.com.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Needed for databinding extension is class name + 'Binding'
    private lateinit var binding: ActivityMainBinding

    //Create binding object from MyName data class
    private val myName: MyName = MyName("Oscar Goodwin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //Bind to activity_main.xml
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //Tie together the data class created with the binding to main_activity.xml.
        binding.myName = myName

    //findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }

        binding.doneButton.setOnClickListener {addNickname(it)}


    }

    fun addNickname(view: View){

//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh U
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}