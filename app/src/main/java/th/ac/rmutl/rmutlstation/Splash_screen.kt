package th.ac.rmutl.rmutlstation


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class Splash_screen : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        ////////////////
        val actionBar = supportActionBar
        actionBar!!.hide()
        ////////////////

            ////////////////
        Handler().postDelayed({
            val i = Intent(
                this@Splash_screen,
                Page_firebase_login::class.java
            )
            startActivity(i)
            finish()
        }, SPLASH_TIME_OUT.toLong())

    }
}