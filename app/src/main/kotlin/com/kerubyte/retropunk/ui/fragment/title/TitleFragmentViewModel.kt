package com.kerubyte.retropunk.ui.fragment.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerubyte.retropunk.application.util.Resource
import com.kerubyte.retropunk.data.BeerRepository
import com.kerubyte.retropunk.domain.model.BeerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitleFragmentViewModel
@Inject
constructor(
    private val beerRepository: BeerRepository
) : ViewModel() {

    private val _beerResponse = MutableLiveData<Resource<BeerResponse>>()
    val beerResponse: LiveData<Resource<BeerResponse>>
        get() = _beerResponse

    private fun getAllBeers() = viewModelScope.launch {
        _beerResponse.postValue(Resource.loading(null))
        beerRepository.getAllBeers().let {
            if (it.isSuccessful) {
                _beerResponse.postValue(Resource.success(it.body()))
            } else {
                _beerResponse.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    init {
        getAllBeers()
    }
}