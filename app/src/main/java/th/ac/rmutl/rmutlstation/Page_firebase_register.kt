package th.ac.rmutl.rmutlstation



import android.content.Intent

//import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import android.view.View

import android.widget.Button

import android.widget.EditText

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase



class Page_firebase_register : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_firebase_register)

        val registerBtn = findViewById<View>(R.id.b_register) as Button

        mDatabase = FirebaseDatabase.getInstance().getReference("dataUsers")

        registerBtn.setOnClickListener(View.OnClickListener {

                view -> registerUser()
        })
    }

    private fun registerUser () {

        val emailTxt = findViewById<View>(R.id.email) as EditText

        val passwordTxt = findViewById<View>(R.id.password) as EditText

        val nameTxt = findViewById<View>(R.id.name) as EditText

        var email = emailTxt.text.toString()

        var password = passwordTxt.text.toString()

        var name = nameTxt.text.toString()


        if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty()) {

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->

                if (task.isSuccessful) {

                    val user = mAuth.currentUser

                    val uid = user!!.uid

                    mDatabase.child(uid).child("Name").setValue(name)

                    startActivity(Intent(this, Page_firebase_home::class.java))

                    Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()

                }else {

                    Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()

                }

            })

        }else {

            Toast.makeText(this,"Please fill up the Credentials :|", Toast.LENGTH_LONG).show()
        }
    }
}