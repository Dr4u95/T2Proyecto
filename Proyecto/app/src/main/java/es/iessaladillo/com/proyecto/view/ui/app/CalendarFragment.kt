package es.iessaladillo.com.proyecto.view.ui.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import es.iessaladillo.com.proyecto.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding?= null
    private val binding get() = _binding!!
    private var contador = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        configureCalendar()
    }

    private fun configureCalendar() {
        binding.calendar.setOnDateChangeListener{_,year,month,day ->
            val fecha = "$day/${month+1}/$year"
            contador++
            binding.seekBar.incrementProgressBy(1)
            if(contador == 5){
                with(binding){
                    seekBar.visibility = View.GONE
                    progressbar.visibility = View.GONE
                    img1.visibility = View.VISIBLE
                    img2.visibility = View.VISIBLE
                    img3.visibility = View.VISIBLE
                }
            }
            Toast.makeText(requireContext(),"Ha seleccionado la fecha: $fecha",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = CalendarFragment()
    }
}