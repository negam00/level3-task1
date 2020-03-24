package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_profile.*

class CreateProfileActivity : AppCompatActivity() {
    private var profileImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        initViews()
    }

    private fun initViews() {
        btnGallery.setOnClickListener { onGalleryClick() }
        btnConfirm.setOnClickListener { onConfirmClick() }
    }


    private fun onGalleryClick() {
        val galIntent = Intent(Intent.ACTION_PICK)

        galIntent.type = "image/*"
        startActivityForResult(galIntent, GALLERY_REQ_CODE)
    }


    private fun onConfirmClick() {
        val profile = Profile(etFirstName.text.toString(),
            etLastName.text.toString(),
            etDesc.text.toString(),
            profileImageUri)

        val profileActIntent = Intent(this, ProfileActivity::class.java)
        profileActIntent.putExtra(ProfileActivity.PROFILE_EXTRA, profile)
        startActivity(profileActIntent)
    }

    companion object {
        const val GALLERY_REQ_CODE = 100
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                GALLERY_REQ_CODE -> {
                    profileImageUri = data?.data
                    ivProfileImage.setImageURI(profileImageUri)
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
