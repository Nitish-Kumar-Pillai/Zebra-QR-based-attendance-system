package com.example.ancient.DAO

import android.util.Log
import android.widget.Toast
import com.example.ancient.models.user
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class userDao {

    private val TAG = "checkTag"
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("user")

    fun addUser(user: user?) {
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.rollno.toString()).set(it)
            }

        }
    }


}







