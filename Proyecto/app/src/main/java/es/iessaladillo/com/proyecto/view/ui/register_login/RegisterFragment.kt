package es.iessaladillo.com.proyecto.view.ui.register_login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.auth
import es.iessaladillo.com.proyecto.databinding.FragmentRegisterBinding
import es.iessaladillo.com.proyecto.view.ui.character_list.CharacterActivity


class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        auth = Firebase.auth
        with(binding){
            emailLayout.emailTxte.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) { checkEmail(s.toString().trim()) }
            })
            passwordLayout.passwordTxte.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {checkPassword(s.toString().trim()) }
            })
            registerBtn.setOnClickListener {
                checkPassword(binding.passwordLayout.passwordTxte.text.toString())
                checkEmail(binding.emailLayout.emailTxte.text.toString())
                if (binding.emailLayout.emailTextInputLayout.error == null && binding.passwordLayout.passwordTextInputLayout.error == null) {
                    register(binding.emailLayout.emailTxte.text.toString(), binding.passwordLayout.passwordTxte.text.toString())
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


    private fun register(email: String, password: String) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Registro exitoso
                    val intent = Intent(requireContext(), CharacterActivity::class.java)
                    intent.putExtra("user_email", email)
                    startActivity(intent)
                } else {
                    // Registro fallido
                    if (task.exception is FirebaseAuthUserCollisionException) {
                        showToast("El correo ya está en uso")
                    } else {
                        showToast("Error: " + task.exception!!.message)
                    }
                }
            }
    }
    private fun showToast(text:String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
    companion object { fun newInstance(): RegisterFragment = RegisterFragment() }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}