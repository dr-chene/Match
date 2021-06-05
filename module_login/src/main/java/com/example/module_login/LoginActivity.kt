package com.example.module_login

import android.view.View
import com.example.module_login.databinding.ActivityLoginBinding
import com.example.module_login.viewmodel.LoginViewModel
import com.viper.lib_base.view.BaseActivity
import com.viper.lib_net.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private var isLogin = true
    private val viewModel by viewModel<LoginViewModel>()

    override fun onInitView() {
        binding.input.apply {
            loginInputRepassword.visibility = View.GONE
            loginInputTelephone.visibility = View.GONE
        }
    }

    override fun onInitAction() {
        binding.loginIcBack.setOnClickListener {
            onBackPressed()
        }
        binding.loginBtnRegister.setOnClickListener {
            synchronized(isLogin) {
                binding.apply {
                    if (isLogin) {
                        loginBtnLogin.text = resources.getText(R.string.register_btn)
                        loginBtnRegister.text = resources.getText(R.string.login_btn)
                    } else {
                        loginBtnLogin.text = resources.getText(R.string.login_btn)
                        loginBtnRegister.text = resources.getText(R.string.register_btn)
                    }
                }
                isLogin = !isLogin
                binding.input.loginInputRepassword.visibility =
                    if (!isLogin) View.VISIBLE else View.GONE
                binding.input.loginInputTelephone.visibility =
                    if (!isLogin) View.VISIBLE else View.GONE
            }
        }
        binding.loginBtnLogin.setOnClickListener {
            binding.input.apply {
                val username = loginAccount.text.toString()
                val password = loginPassword.text.toString()
                if (isLogin) {
                    if (username.isNotBlank() && password.isNotBlank()) login(username, password)
                } else {
                    if (password != loginRepassword.text.toString()) {
                        "前后密码不一致，请确认".showToast()
                    } else check(
                        loginAccount.text.toString(),
                        password,
                        loginTelephone.text.toString()
                    )
                }
            }
        }
    }

    override fun getContentViewResId() = R.layout.activity_login

    private fun check(username: String, password: String, telephone: String?) {
        if (username.isBlank()) {
            "用户名不能为空".showToast()
            return
        }
        if (password.isBlank()) {
            "密码不能为空".showToast()
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.check(username).apply {
                if (!flag) {
                    message.showToast()
                } else {
                    register(username, password, telephone)
                }
            }
        }
    }

    private fun login(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.login(username, password).request().result {
                token = it
                if (it != null)MmkvUtils.saveToken(it)
                "登录成功".showToast()
                loginSuccess()
            }
        }
    }

    private suspend fun register(username: String, password: String, telephone: String?) {
        viewModel.register(username, password, telephone).apply {
            if (flag) {
                login(username, password)
            } else message.showToast()
        }
    }

    private fun loginSuccess() {
        finish()
    }
}