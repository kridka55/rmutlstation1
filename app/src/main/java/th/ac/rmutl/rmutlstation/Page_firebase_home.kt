package th.ac.rmutl.rmutlstation


//import android.support.v7.app.AppCompatActivity
import android.app.AlertDialog.Builder
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.page_firebase_home.*

class Page_firebase_home : AppCompatActivity() {

    lateinit var mDatabase : DatabaseReference
    var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser
   // var str_1: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_firebase_home)


        b_logout.setOnClickListener {


            mAuth.signOut()
            val intent = Intent(this, Page_firebase_login::class.java)
            // start your next activity
            startActivity(intent)


            Toast.makeText(this, "Signed Out :(", Toast.LENGTH_LONG).show()
           // startActivity(Intent(this, MainActivity::class.java))


        }

        b_Page_firebase_map_1.setOnClickListener {
            val intent = Intent(this, Page_firebase_map_1::class.java)
            // start your next activity
            startActivity(intent)
        }
       b_Page_firebase_show_1.setOnClickListener {
           val intent = Intent(this, Page_firebase_show_1::class.java)
           // start your next activity
           startActivity(intent)
       }
       b_Main2Activity.setOnClickListener {
           val intent = Intent(this, Main2Activity::class.java)
           // start your next activity
           startActivity(intent)
       }

        val nameTxt = findViewById<View>(R.id.nameTxt) as TextView
       val  text_status = findViewById<View>(R.id.text_status) as TextView

        var uid = user!!.uid
        //                car_type.setText(str_car_type);

        mDatabase = FirebaseDatabase.getInstance().getReference("dataUsers")

        mDatabase.child(uid).child("Name").addValueEventListener( object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                //nameTxt.text =  "Welcome " + snapshot.value.toString()
                nameTxt.text =  "" + snapshot.value.toString()


               // var str_1 = nameTxt.text.toString()
//                var str_1 = "" + snapshot.value.toString()
//
//                if (str_1 == "admin") {
//                   text_status.setText("Admin");
//
//                    val intent = Intent(this@Page_firebase_home, Page_firebase_admin_home::class.java)
//                    startActivity(intent)
//                }


            }
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.signOut) {
            mAuth.signOut()
            Toast.makeText(this, "Signed Out :(", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Page_firebase_login::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


    //    private void collectParamsAndStartEventActivity() {
//        Intent dateIntent = new Intent(this, EventActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString(INTENT_NAME, DATE_INTENT);
//        bundle.putInt(YEAR, mYear);
//        bundle.putInt(MONTH, mMonth);
//        bundle.putInt(DAY, mDay);
//        dateIntent.putExtras(bundle);
//        startActivity(dateIntent);
//    }


/////////////////////////////////////

    override fun onBackPressed() {
        val dialog = Builder(this@Page_firebase_home)
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
    }  /////////////// onBackPressed

}


