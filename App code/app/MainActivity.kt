package com.example.ancient

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.ancient.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_layout.*


class MainActivity : AppCompatActivity() {

    lateinit var db : FirebaseFirestore
    lateinit var selectedItem : String
    lateinit var rollno: String
    lateinit var window: PopupWindow
    lateinit var window1 : PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()

        //spinner functionality
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.lectures, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter




        //get data
        rollno = intent.getStringExtra("rollNumber").toString()




        //popUp window
        window = PopupWindow(this)
        val view = layoutInflater.inflate(R.layout.popup_layout,null)
        window.contentView=view
        val popup = findViewById<ImageView>(R.id.popUpImage)


        window1 = PopupWindow(this)
        val view1 = layoutInflater.inflate(R.layout.popup1_layout,null)
        window1.contentView = view1
        val popup1 = findViewById<ImageView>(R.id.popUpImage1)





        scan.setOnClickListener {
            //attendance checking
            selectedItem = spinner.selectedItem.toString()
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)


            if (result != null) {
                check(result.contents.toString())
            }
            else
            {
                val toast = Toast.makeText(this,"Incorrect lecture selected for attendance",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun check(result : String) {

            if(result != selectedItem)
            {
                val toast = Toast.makeText(this,"Incorrect lecture selected for attendance",Toast.LENGTH_SHORT).show()
                window1.showAsDropDown(popup1)
                popup1.setOnClickListener{
                    window1.dismiss()
                }

            }else {


                val docRef = db.collection("user").document(rollno)
                docRef.update(selectedItem, "present")

                val toast = Toast.makeText(this, "Attendance Marked", Toast.LENGTH_SHORT).show()
                window.showAsDropDown(popup)
                popup.setOnClickListener{
                    window.dismiss()
                }

            }
        }
    }









