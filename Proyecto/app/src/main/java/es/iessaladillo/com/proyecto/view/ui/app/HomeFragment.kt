package es.iessaladillo.com.proyecto.view.ui.app

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
     private var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        configureVideoInternet()
        configureVideoLocal()
    }

    private fun configureVideoLocal() {
        val mcWeb = MediaController(requireContext())
        val path = "android.resource://" + context?.packageName + "/" + R.raw.starwars
        binding.videoViewLocal.setVideoURI(Uri.parse(path))
        binding.videoViewLocal.setMediaController(mcWeb)
    }

    private fun configureVideoInternet() {
        val mcWeb = MediaController(requireContext())
        binding.videoView.setVideoPath("https://freetestdata.com/wp-content/uploads/2022/02/Free_Test_Data_1MB_MP4.mp4")
        binding.videoView.setMediaController(mcWeb)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = HomeFragment()
    }
}