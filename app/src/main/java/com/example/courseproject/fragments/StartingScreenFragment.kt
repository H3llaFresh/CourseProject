package com.example.courseproject.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.courseproject.R
import com.example.courseproject.viewmodels.StartingScreenViewModel

class StartingScreenFragment : Fragment(R.layout.fragment_start_screen) {

    private val startingScreenViewModel: StartingScreenViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startingScreenViewModel.routeToLoginOrMain(view)
    }
}