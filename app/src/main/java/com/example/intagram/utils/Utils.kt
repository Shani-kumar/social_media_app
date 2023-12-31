package com.example.intagram.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import android.net.Uri
import java.util.UUID

fun uploadImage(uri: Uri, folderName: String,callback:(String)-> Unit) {
    var imageUrl:String ?= null
    FirebaseStorage.getInstance().getReference(folderName).child(UUID.randomUUID().toString())
        .putFile(uri)
        .addOnSuccessListener {
            it.storage.downloadUrl.addOnSuccessListener {
                imageUrl = it.toString()
                callback(imageUrl!!)
            }
        }

}