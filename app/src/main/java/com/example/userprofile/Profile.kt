package com.example.userprofile

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Profile (
    val FirstName: String,
    val LastName: String,
    val desc: String,
    val imageUri: Uri?
) :Parcelable