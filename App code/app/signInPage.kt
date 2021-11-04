package com.example.ancient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.ancient.DAO.userDao
import com.example.ancient.models.user
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in_page.*

class signInPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_page)



        signInButton.setOnClickListener {

            if( userName.text.toString().trim().isEmpty()  )
            {
               val toast = Toast.makeText(this,"All fields must be filled before signing in",Toast.LENGTH_SHORT).show()
            }else if (rollno.text.toString().trim().isEmpty())
            {
                val toast = Toast.makeText(this,"All fields must be filled before signing in",Toast.LENGTH_SHORT).show()
            }else if(email.text.toString().trim().isEmpty())
            {
                val toast = Toast.makeText(this,"All fields must be filled before signing in",Toast.LENGTH_SHORT).show()
            }else if(password.text.toString().trim().isEmpty())
            {
                val toast = Toast.makeText(this,"All fields must be filled before signing in",Toast.LENGTH_SHORT).show()
            }else if(confirmPassword.text.toString().trim().isEmpty())
            {
                val toast = Toast.makeText(this,"All fields must be filled before signing in",Toast.LENGTH_SHORT).show()
            }

            else
            {
                if(password.text.toString() != confirmPassword.text.toString())
                {
                    val toast =Toast.makeText(this,"Both passwords must be the same",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val userName = userName.text.toString()
                    val rollNo  = rollno.text
                    val email = email.text
                    val password = password.text

                    val user = user(userName,rollNo.toString(),email.toString(),password.toString(),"absent","absent","absent","absent","absent","absent","absent","absent","absent","absent")
                    val userDao = userDao()
                    userDao.addUser(user)

                    val intent =Intent(this,loginPage::class.java)
                    startActivity(intent)
                    finish()
                }
            }




        }
    }


}