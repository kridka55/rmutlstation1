package th.ac.rmutl.rmutlstation


//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
//import kotlinx.android.synthetic.main.activity_main2.*
//import kotlinx.android.synthetic.main.activity_maps.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val phoneNumber1 ="191"
        val phoneNumber2 ="1669"
        val phoneNumber3 ="1192"
        val phoneNumber4 ="199"


        imageView9.setOnClickListener {Toast.makeText(this@Main2Activity, "Dial 191", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +phoneNumber1)
            startActivity(intent)
        }
        imageView10.setOnClickListener {Toast.makeText(this@Main2Activity, "Dial 1669", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +phoneNumber2)
            startActivity(intent)
        }
        imageView11.setOnClickListener {Toast.makeText(this@Main2Activity, "Dial 1192", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +phoneNumber3)
            startActivity(intent)
        }
        imageView12.setOnClickListener {Toast.makeText(this@Main2Activity, "Dial 199", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +phoneNumber4)
            startActivity(intent)
        }
    }
}
