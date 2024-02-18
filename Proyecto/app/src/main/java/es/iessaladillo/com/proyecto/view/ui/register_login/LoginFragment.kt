package es.iessaladillo.com.proyecto.view.ui.register_login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import es.iessaladillo.com.proyecto.databinding.FragmentLoginBinding
import es.iessaladillo.com.proyecto.view.ui.character_list.CharacterActivity

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = LoginFragment()
    }

    private fun setUpViews() {
        auth = Firebase.auth
        with(binding){
            emailLayout.emailTxte.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    //NOTHING
                }

                override fun afterTextChanged(s: Editable) {
                    //NOTHING
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    checkEmail(s.toString().trim())
                }
            })
            passwordLayout.passwordTxte.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    //NOTHING
                }

                override fun afterTextChanged(s: Editable) {
                    //NOTHING
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    checkPassword(s.toString().trim())
                }
            })
            loginBtn.setOnClickListener {
                checkPassword(binding.passwordLayout.passwordTxte.text.toString())
                checkEmail(binding.emailLayout.emailTxte.text.toString())
                if (binding.emailLayout.emailTextInputLayout.error == null && binding.passwordLayout.passwordTextInputLayout.error == null) {
                    login(binding.emailLayout.emailTxte.text.toString(), binding.passwordLayout.passwordTxte.text.toString())
                }
            }
        }

    }

    private fun checkEmail(email: String) {
        if (!email.contains("@gmail.com")) {
            binding.emailLayout.emailTextInputLayout.error = "Correo electrónico inválido"
        } else {
            binding.emailLayout.emailTextInputLayout.error = null
        }
    }

    private fun checkPassword(pass: String) {
        if (pass.length < 6 || pass.length > 12) {
            binding.passwordLayout.passwordTextInputLayout.error =
                "Contraseña invalida, debe contener de 6 a 12 caracteres"
        } else {
            binding.passwordLayout.passwordTextInputLayout.error = null
        }
    }

    private fun login(email: String, password: String) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    //Log.d(TAG, "signInWithEmail:success")
                    //val user = auth.currentUser
                    val intent = Intent(requireContext(), CharacterActivity::class.java)
                    intent.putExtra("user_email", email)
                    startActivity(intent)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        requireContext(),
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.emailLayout.emailTextInputLayout.error = "Correo electrónico Erroneo"
                    binding.passwordLayout.passwordTextInputLayout.error = "Contraseña Erronea"
                }
            }
    }
}