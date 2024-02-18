package es.iessaladillo.com.proyecto.view.ui.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import es.iessaladillo.com.proyecto.databinding.FragmentBattleBinding
import es.iessaladillo.com.proyecto.model.EnemyAdapter
import es.iessaladillo.com.proyecto.model.EnemyProvider

class BattleFragment : Fragment() {
    private var _binding: FragmentBattleBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: EnemyAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBattleBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }
    private fun setUpViews() {
        configureAdapter()
        configureSearch()
    }

    private fun configureSearch() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }
        })
    }

    private fun configureAdapter() {
        val pair = EnemyProvider.getNameAndPhotoUrl()
        adapter = EnemyAdapter(requireContext(),pair)
        binding.listEnemy.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = BattleFragment()
    }
}