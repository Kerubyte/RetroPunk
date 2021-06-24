package com.kerubyte.retropunk.ui.fragment.title

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerubyte.retropunk.R
import com.kerubyte.retropunk.application.util.Status
import com.kerubyte.retropunk.databinding.FragmentTitleBinding
import com.kerubyte.retropunk.ui.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TitleFragment : Fragment() {

    private val titleViewModel: TitleFragmentViewModel by viewModels()
    private lateinit var binding: FragmentTitleBinding
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_title,
            container,
            false
        )
        setUpRecycler()
        setUpObservers()

        return binding.root
    }

    private fun setUpRecycler() {

        myAdapter = MainAdapter()
        binding.recyclerTitleFragment.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun setUpObservers() {
        titleViewModel.beerResponse.observe(viewLifecycleOwner, {
            when (it.status) {

                Status.SUCCESS -> {
                    binding.widgetProgressBar.visibility = View.GONE
                    binding.recyclerTitleFragment.visibility = View.VISIBLE
                    it.data?.let { response ->
                        if (response.isNotEmpty()) {
                            response.let { res ->
                                myAdapter.differ.submitList(res)

                            }
                        } else {
                            Log.d("titleFrag", "empty response")
                        }

                    }
                }

                Status.LOADING -> {
                    binding.recyclerTitleFragment.visibility = View.GONE
                    binding.widgetProgressBar.visibility = View.VISIBLE
                }

                Status.ERROR -> {
                    binding.widgetProgressBar.visibility = View.GONE

                    Log.d("titleFrag", "error status")
                }
            }
        })
    }
}