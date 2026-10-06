package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.atan

class FragmentLogin: Fragment() {
    private lateinit var ETX_FRGLogin_UserName: EditText
    private lateinit var ETX_FRGLogin_Password: EditText
    private lateinit var TXV_FRGLogin_RecoverPassword: TextView
    private lateinit var BTN_FRGLogin_Login: Button
    private lateinit var BTN_FRGLogin_Register: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmet_login,container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureListeners()
    }

    private fun initializeViews(view: View) {
        ETX_FRGLogin_UserName=view.findViewById(R.id.ETX_FRGLogin_UserName)
        ETX_FRGLogin_Password=view.findViewById(R.id.ETX_FRGLogin_Password)
        TXV_FRGLogin_RecoverPassword=view.findViewById(R.id.TXV_FRGLogin_RecoverPassword)
        BTN_FRGLogin_Login=view.findViewById(R.id.BTN_FRGLogin_Login)
        BTN_FRGLogin_Register=view.findViewById(R.id.BTN_FRGLogin_Register)
    }

    private fun configureListeners() {
        TXV_FRGLogin_RecoverPassword.setOnClickListener() {

        }

        BTN_FRGLogin_Login.setOnClickListener() {
            SignIn()
        }

        BTN_FRGLogin_Register.setOnClickListener(){

        }
    }

    private fun SignIn(){
        val user = ETX_FRGLogin_UserName.text.toString().trim()
        val password=ETX_FRGLogin_Password.text.toString().trim()
        if(!verifyIntegrity(user,password)){
            return
        }
        if(verifyCredentials(user,password)){
            Toast.makeText(requireContext(),getString(R.string.loginWelcome),Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(requireContext(),getString(R.string.loginError),Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyIntegrity(user: String, password: String): Boolean {
        var res = true
        if(user.isNotEmpty()){
            ETX_FRGLogin_UserName.error=getString(R.string.userEmpty)
        }
        else
        {
            ETX_FRGLogin_UserName.error=null
        }

        if(user.isNotEmpty()){
            ETX_FRGLogin_Password.error=getString(R.string.passwordEmpty)
        }
        else
        {
            ETX_FRGLogin_Password.error=null
        }
        return res
    }

    private fun verifyCredentials(user: String, password: String): Boolean {
        return user=="admin" && password=="123456"
    }
}