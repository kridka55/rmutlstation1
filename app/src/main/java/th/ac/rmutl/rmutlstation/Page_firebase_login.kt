package th.ac.rmutl.rmutlstation


import android.app.AlertDialog
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.page_firebase_home.*
import kotlinx.android.synthetic.main.page_firebase_login.*



class Page_firebase_login : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_firebase_login)

        val loginBtn = findViewById<View>(R.id.b_login) as Button
       // val registerTxt = findViewById<View>(R.id.regTxt) as TextView

        loginBtn.setOnClickListener(View.OnClickListener {

                view -> login()
                avi.show()
        })

//        registerTxt.setOnClickListener(View.OnClickListener {
//                view -> register()
//        })
        b_go_register.setOnClickListener {
            val intent = Intent(this, Page_firebase_register::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    private fun login () {

        val emailTxt = findViewById<View>(R.id.email) as EditText
        var email = emailTxt.text.toString()
        val passwordTxt = findViewById<View>(R.id.password) as EditText
        var password = passwordTxt.text.toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    avi.hide()
                    startActivity(Intent(this, Page_firebase_home::class.java))
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun register () {
//        startActivity(Intent(this, Page_firebase_register::class.java))
//    }




    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this@Page_firebase_login)
        dialog.setTitle("แจ้งเตือน")
        dialog.setIcon(R.mipmap.ic_launcher)
        dialog.setCancelable(true)
        dialog.setMessage("คุณต้องการที่จะออกจากแอพใช่หรือไม่?")
        dialog.setPositiveButton("ใช่") { dialog, which ->
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        dialog.setNegativeButton(
            "ไม่"
        ) { dialog, which -> dialog.cancel() }
        dialog.show()
    }


}
