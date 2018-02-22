package com.dewarder.messenger.ui.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.dewarder.messenger.R
import com.dewarder.messenger.base.BaseActivity
import dagger.android.AndroidInjection

class LoginUsernameActivity : BaseActivity<LoginUsernameViewModel>() {

    lateinit var usernameInput: EditText
    lateinit var proceedButton: View

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = LoginUsernameViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_username)

        usernameInput = findViewById(R.id.username)

        proceedButton = findViewById(R.id.proceed)
        proceedButton.setOnClickListener {
            viewModel.checkEmail(usernameInput.text.toString())
        }
    }

    override fun onViewModelCreated(viewModel: LoginUsernameViewModel) {
        viewModel.emailExist.observe { exist ->
            Toast.makeText(this, "Email exist $exist", Toast.LENGTH_SHORT).show()
        }
    }
}