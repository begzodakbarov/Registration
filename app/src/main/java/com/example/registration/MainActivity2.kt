package com.example.registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registration.adapter.RvAdapter
import com.example.registration.databinding.ActivityMain2Binding
import com.example.registration.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso


private const val TAG = "MainActivity2"
class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    lateinit var auth: FirebaseAuth
    lateinit var reference : DatabaseReference
    lateinit var list : ArrayList<User>
    lateinit var  adapter: RvAdapter
    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")

        reference.addValueEventListener(object : ValueEventListener{
            @SuppressLint("SuspiciousIndentation")
            override fun onDataChange(snapshot: DataSnapshot) {
                 list = ArrayList()
                val children = snapshot.children
                for (child in children) {
                    val user = child.getValue(User::class.java)
                    if (user!=null)
                    list.add(user)
                }
                adapter = RvAdapter(list)
                binding.rv.adapter = adapter
                Log.d(TAG, "onDataChange: $list")

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity2, "Error", Toast.LENGTH_SHORT).show()
            }
        })

    }
}