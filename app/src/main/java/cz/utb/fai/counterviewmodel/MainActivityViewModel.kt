package cz.utb.fai.counterviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    // MutableLiveData for private mutable counter
    private val _counter = MutableLiveData<Int>()

    // Expose LiveData to observe changes
    val counter: LiveData<Int> get() = _counter

    // MutableLiveData for easy two-way data binding
    val nameMutable = MutableLiveData<String>()
    val emailMutable = MutableLiveData<String>()

    // Initial values
    init {
        _counter.value = 0
        nameMutable.value = ""
        emailMutable.value = ""
    }

    // incrementing of counter
    fun increment() {
        // incrementing of LiveData - get the Int number from .value, if not set, it returns 0
        _counter.value = ( _counter.value ?: 0) + 1
    }

    //Maps
    private val _navigateToMaps = MutableLiveData<Boolean>()
    val navigateToMaps: LiveData<Boolean> get() = _navigateToMaps

    fun onOpenMapsClicked() {
        _navigateToMaps.value = true
    }

    fun onMapsNavigated() {
        _navigateToMaps.value = false
    }


}
