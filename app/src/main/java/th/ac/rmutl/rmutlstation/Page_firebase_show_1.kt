package th.ac.rmutl.rmutlstation


import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.page_firebase_home.*
//import kotlinx.android.synthetic.main.page_firebase_map.*
import kotlinx.android.synthetic.main.page_firebase_map_1.*
import kotlinx.android.synthetic.main.page_firebase_map_1.b_Main2Activity
import kotlinx.android.synthetic.main.page_firebase_map_1.bus1DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus1TextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus2DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus2TextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus3DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus3TextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus4DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus4TextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus5DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus5TextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus6DurationTextView
import kotlinx.android.synthetic.main.page_firebase_map_1.bus6TextView
import kotlinx.android.synthetic.main.page_firebase_show_1.*


class Page_firebase_show_1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap



    var database = FirebaseDatabase.getInstance()

    var datas: MutableList<String> = mutableListOf()

    var b1: String = ""
    var b2: String = ""
    var b3: String = ""
    var b4: String = ""
    var b5: String = ""
    var b6: String = ""
    //private var b_next: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_firebase_show_1)


//        ////////////////
//        val actionBar = supportActionBar
//        actionBar!!.hide()
//        ////////////////

        //  b_next = findViewById(R.id.b_Main2Activity) as FloatingActionButton

//        b_Main2Activity.setOnClickListener {
//            val intent = Intent(this, Main2Activity::class.java)
//            // start your next activity
//            startActivity(intent)
//        }
//        b_next!!.setOnClickListener {
//            val intent = Intent(this, Main2Activity::class.java)
//            // start your next activity
//            startActivity(intent)
//        }

        // val b_next = FloatingActionButton(baseContext)
        val b_next = findViewById(R.id.b_Main2Activity) as FloatingActionButton
        // b_next.title = "Familie"
        b_next.setIcon(R.drawable.phone)
        b_next.size = FloatingActionButton.SIZE_MINI
        //b_next.setColorNormalResId(android.R.color.red)
        // b_next.setColorPressedResId(android.R.color.black_semi_transparent)
        b_next!!.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            // start your next activity
            startActivity(intent)
        }

        b_phone.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            // start your next activity
            startActivity(intent)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



        val bus1 = database.getReference("Seat/Bus1")
        bus1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus1TextView.setText("Bus1 เหลือ " + seatNumber + " ที่นั่ง" )
                b1 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
        val bus2 = database.getReference("Seat/Bus2")
        bus2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus2TextView.setText("Bus2 เหลือ " + seatNumber + " ที่นั่ง" )
                b2 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        val bus3 = database.getReference("Seat/Bus3")
        bus3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus3TextView.setText("Bus3 เหลือ " + seatNumber + " ที่นั่ง" )
                b3 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        val bus4 = database.getReference("Seat/Bus4")
        bus4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus4TextView.setText("Bus4 เหลือ " + seatNumber + " ที่นั่ง" )
                b4 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        val bus5 = database.getReference("Seat/Bus5")
        bus5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus5TextView.setText("Bus5 เหลือ " + seatNumber + " ที่นั่ง" )
                b5 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        val bus6 = database.getReference("Seat/Bus6")
        bus6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val seatNumber = dataSnapshot.child("Seat result").getValue(Int::class.java)
                bus6TextView.setText("Bus6 เหลือ " + seatNumber + " ที่นั่ง" )
                b6 = "" + seatNumber
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })


    }

    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap = googleMap
        val Atikarn1 = LatLng(18.809873, 98.952818)//atikran to pasusas
        val Atikarn2 = LatLng(18.810134, 98.953042)       //
        val Atikarn3 = LatLng(18.811011, 98.953781)  //
        val Atikarn4 = LatLng(18.811165, 98.953891)//
        val Atikarn5 = LatLng(18.811279, 98.953935)//
        val Atikarn6 = LatLng(18.811324, 98.953910)//
        val Pasusas1 = LatLng(18.809944, 98.952711)
        val Pasusas2 = LatLng(18.810054, 98.952580)
        val Pasusas3 = LatLng(18.810359, 98.952255)
        val Pasusas4 = LatLng(18.810407, 98.952224)
        val Pasusas5 = LatLng(18.810439, 98.952220)
        val Pasusas6 = LatLng(18.810478, 98.952227)
        val Pasusas7 = LatLng(18.810882, 98.952381)
        val Pasusas8 = LatLng(18.812586, 98.953136)

        val Pasusas33 = LatLng(18.811411, 98.952622) //Usahakran to elec
        val Usahakran1 = LatLng (18.811327, 98.952939)
        val Usahakran2 = LatLng (18.811340, 98.953028)
        val Usahakran3 = LatLng (18.811443, 98.953194)
        val Usahakran4 = LatLng (18.811463, 98.953284)
        val Usahakran5 = LatLng (18.811306, 98.953783)
        val Usahakran6 = LatLng (18.811324, 98.953910)
        val Usahakran7 = LatLng (18.811390, 98.954024)
        val Usahakran8 = LatLng (18.811412, 98.954161)
        val Usahakran9 = LatLng (18.811395, 98.954265)
        val Usahakran10 = LatLng (18.811254, 98.954653)//ข้ามถนน
        val Usahakran11 = LatLng(18.811238, 98.954717)//ข้ามมาแล้ว
        val Usahakran12 = LatLng (18.810733, 98.955406)//แยก
        val Usahakran13 = LatLng (18.810830, 98.955700)//เกทชอป
        val Usahakran14 = LatLng (18.811141, 98.955731)//
        val Usahakran15 = LatLng (18.811599, 98.955813)//
        val Usahakran16 = LatLng (18.812031, 98.955865)//
        val Usahakran17 = LatLng (18.812253, 98.955830)//
        val Usahakran18 = LatLng (18.812428, 98.955605)//
        val Usahakran19 = LatLng (18.812436, 98.955246)//แยก

        val malin1 = LatLng (18.810733, 98.955406)//แยกไปมาลิน
        val malin2 = LatLng (18.810217, 98.955218)//
        val malin3 = LatLng (18.810131, 98.955210)//
        val malin4 = LatLng(18.810034, 98.955270)//
        val malin5 = LatLng (18.809940, 98.955385)//
        val malin6 = LatLng (18.809917, 98.955548)//
        val malin7 = LatLng(18.809870, 98.955686)//
        val malin8 = LatLng(18.809820, 98.955757)//
        val malin9 = LatLng (18.809627, 98.955910)//
        val malin10 = LatLng(18.809592, 98.955965)//
        val malin11 = LatLng (18.809569, 98.956053)//
        val malin12 = LatLng (18.809560, 98.956164)//
        val malin13 = LatLng(18.809571, 98.956287)//
        val malin14 = LatLng(18.809560, 98.956436)//
        val malin15 = LatLng (18.809609, 98.956808)//จบมาลิน


        var busesRef = database.getReference("buses")
        busesRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                mMap.clear()
                datas = mutableListOf()

                val children = dataSnapshot.children
                children.forEach {
                    val locationString = it.getValue(String::class.java)

                    datas.add(locationString!!)

                    val splitStrings = locationString!!.split(Regex(","))

                    val la = splitStrings.get(0).toDouble()
                    val lo = splitStrings.get(1).toDouble()
                    val time = splitStrings.get(2)
                    val enable = splitStrings.get(3).toInt()
                    val duration = splitStrings.get(4)
                    val busName = splitStrings.get(5)

                    var busText = ""

                    if (busName == "Bus1") {
                        bus1DurationTextView.setText(duration)
                        busText = b1
                    } else if (busName == "Bus2") {
                        bus2DurationTextView.setText(duration)
                        busText = b2
                    } else if (busName == "Bus3") {
                        bus3DurationTextView.setText(duration)
                        busText = b3
                    } else if (busName == "Bus4") {
                        bus4DurationTextView.setText(duration)
                        busText = b4
                    } else if (busName == "Bus5") {
                        bus5DurationTextView.setText(duration)
                        busText = b5
                    } else if (busName == "Bus6") {
                        bus6DurationTextView.setText(duration)
                        busText = b6
                    }

                    if (enable == 0) {
                        if (busName == "Bus1") {
                            bus1DurationTextView.setText("หยุดให้บริการ")
                        } else if (busName == "Bus2") {
                            bus2DurationTextView.setText("หยุดให้บริการ")
                        } else if (busName == "Bus3") {
                            bus3DurationTextView.setText("หยุดให้บริการ")
                        } else if (busName == "Bus4") {
                            bus4DurationTextView.setText("หยุดให้บริการ")
                        } else if (busName == "Bus5") {
                            bus5DurationTextView.setText("หยุดให้บริการ")
                        } else if (busName == "Bus6") {
                            bus6DurationTextView.setText("หยุดให้บริการ")
                        }
                    }


                    val currentPosition = LatLng(la, lo)

                    val Atikarn = MarkerOptions() //อธิการบดี
                    Atikarn.position(LatLng(18.810377, 98.952670)).title("ตึกอธิการบดี")
                    val marker1: Marker? = googleMap?.addMarker(Atikarn)
                    val bitmapDescriptor1 = BitmapDescriptorFactory.fromResource(R.drawable.markone)
                    marker1?.setIcon(bitmapDescriptor1)




                    val Pasusas = MarkerOptions() // ปศุสัส
                    Pasusas.position(LatLng(18.812665, 98.952906)).title("ลานปศุสัตว์")
                    val marker2: Marker? = googleMap?.addMarker(Pasusas)
                    val bitmapDescriptor2 = BitmapDescriptorFactory.fromResource(R.drawable.marktwo)
                    marker2?.setIcon(bitmapDescriptor2)

                    val Food = MarkerOptions() // โรงอาหาร
                    Food.position(LatLng(18.811129, 98.953997)).title("โรงอาหาร")
                    val marker3: Marker? = googleMap?.addMarker(Food)
                    val bitmapDescriptor3 = BitmapDescriptorFactory.fromResource(R.drawable.markthree)
                    marker3?.setIcon(bitmapDescriptor3)

                    val ss = MarkerOptions() // 200ล้าน
                    ss.position(LatLng(18.812495, 98.955293)).title("ตึกเฉลิมพระเกียรติ")
                    val marker4: Marker? = googleMap?.addMarker(ss)
                    val bitmapDescriptor4 = BitmapDescriptorFactory.fromResource(R.drawable.markfour)
                    marker4?.setIcon(bitmapDescriptor4)

                    val malin = MarkerOptions() // มาลิน
                    malin.position(LatLng(18.809527, 98.956679)).title("มาลิน")
                    val marker5: Marker? = googleMap?.addMarker(malin)
                    val bitmapDescriptor5 = BitmapDescriptorFactory.fromResource(R.drawable.markfive)
                    marker5?.setIcon(bitmapDescriptor5)

                    mMap.addPolyline(
                        PolylineOptions()
                            .add(Atikarn1)
                            .add(Pasusas1)
                            .add(Pasusas2)
                            .add(Pasusas3)
                            .add(Pasusas4)
                            .add(Pasusas5)
                            .add(Pasusas6)
                            .add(Pasusas7)
                            .add(Pasusas8)


                            .width(12f)
                            .color(Color.BLUE)
                    )///new

                    mMap.addPolyline(
                        PolylineOptions()
                            .add(Atikarn1)
                            .add(Atikarn2)
                            .add(Atikarn3)
                            .add(Atikarn4)
                            .add(Atikarn5)
                            .add(Atikarn6)



                            .width(12f)
                            .color(Color.BLUE)
                    )



                    mMap.addPolyline(
                        PolylineOptions()
                            .add(Pasusas33)
                            .add(Usahakran1)
                            .add(Usahakran2)
                            .add(Usahakran3)
                            .add(Usahakran4)
                            .add(Usahakran5)//
                            .add(Usahakran6)
                            .add(Usahakran7)
                            .add(Usahakran8)
                            .add(Usahakran9)
                            .add(Usahakran10)//
                            .add(Usahakran11)
                            .add(Usahakran12)
                            .add(Usahakran13)
                            .add(Usahakran14)
                            .add(Usahakran15)//
                            .add(Usahakran16)
                            .add(Usahakran17)
                            .add(Usahakran18)
                            .add(Usahakran19)

                            .width(10f)
                            .color(Color.BLUE)
                    )
                    mMap.addPolyline(
                        PolylineOptions()

                            .add(malin1)//
                            .add(malin2)//
                            .add(malin3)//
                            .add(malin4)//
                            .add(malin5)//
                            .add(malin6)//
                            .add(malin7)//
                            .add(malin8)//
                            .add(malin9)//
                            .add(malin10)//
                            .add(malin11)//
                            .add(malin12)//
                            .add(malin13)//
                            .add(malin14)//
                            .add(malin15)//

                            .width(10f)
                            .color(Color.BLUE)
                    )

                    if (enable == 1) {
                        val conf = Bitmap.Config.ARGB_8888
                        val bmp = Bitmap.createBitmap(250, 250, conf)
                        val canvas1 = Canvas(bmp)


                        val color = Paint()
                        color.setTextSize(50f)
                        color.setColor(Color.BLACK)

                        if (busName == "Bus1") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus1), 0f, 0f, color)
                        } else if (busName == "Bus2") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus2), 0f, 0f, color)
                        } else if (busName == "Bus3") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus3), 0f, 0f, color)
                        } else if (busName == "Bus4") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus4), 0f, 0f, color)
                        } else if (busName == "Bus5") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus5), 0f, 0f, color)
                        } else if (busName == "Bus6") {
                            canvas1.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.bus6), 0f, 0f, color)
                        }

                        canvas1.drawText(busText, 80f, 85f, color)




                        mMap.addMarker(MarkerOptions()
                            .position(currentPosition)
                            .icon(BitmapDescriptorFactory.fromBitmap(bmp))
                            .anchor(0.32f, 0.8f))

                        //    val dhaka = LatLng(18.811888705717067,98.95400612051313)
                        //     mMap.addMarker(MarkerOptions().position(dhaka))



                    }








                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(18.8096079, 98.9529416), 15f))
                    val cameraPosition = CameraPosition.Builder()
                        .target(LatLng(18.8096079, 98.9529416))      // Sets the center of the map to location user
                        .zoom(16.6f)                   // Sets the zoom
                        // .bearing(90f)                // Sets the orientation of the camera to east
                        // .tilt(40f)                   // Sets the tilt of the camera to 30 degrees
                        .build()                   // Creates a CameraPosition from the builder
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))


                }



            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("", "Failed to read value.", error.toException())
            }


        })


    }

}