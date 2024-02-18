package es.iessaladillo.com.proyecto.view.ui.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.FragmentInfoBinding
import es.iessaladillo.com.proyecto.databinding.FragmentLoginBinding
import es.iessaladillo.com.proyecto.view.ui.register_login.LoginFragment

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        with(binding.webView){
            loadUrl("https://es.wikipedia.org/wiki/Star_Wars")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = InfoFragment()
    }
}