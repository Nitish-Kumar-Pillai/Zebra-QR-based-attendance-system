package com.example.ancient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login_page.*

class loginPage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var TAG: String = "loginTag"
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()

        newAccount.setOnClickListener {
            val intent = Intent(this, signInPage::class.java)
            startActivity(intent)
            finish()
        }
        loginButton.setOnClickListener {
            if (loginRollno.text.toString().trim().isEmpty()) {
                val toast = Toast.makeText(
                    this, "All fields must be filled before signing in",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (loginPassword.text.toString().trim().isEmpty()) {
                val toast = Toast.makeText(
                    this, "All fields must be filled before signing in",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val rollno = loginRollno.text.toString()
                val password = loginPassword.text.toString()

                check(rollno,password)
            }

        }
    }


    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun check(rollno: String, password: String) {
        val documentReference = db.collection("user").document(rollno)
        documentReference.get().addOnSuccessListener {
            if(it.exists())
            {
                val Password = it.get("password")
                if(password==Password)
                {
                    //passing data
                       val intent = Intent(this, MainActivity::class.java)
                           .putExtra("rollNumber",rollno)
                    startActivity(intent)


                }
                else
                {
                    Toast.makeText(
                        baseContext, "Incorrect credentials",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            else
            {
                Toast.makeText(
                    baseContext, "User Does Not Exist",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.addOnFailureListener {
            Toast.makeText(
                baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}
