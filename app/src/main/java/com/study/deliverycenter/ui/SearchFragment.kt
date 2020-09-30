package com.study.deliverycenter.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.study.deliverycenter.R
import com.study.deliverycenter.utils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val context = requireContext()

        searchButton.setOnClickListener {
            if (!checkInternetConnection(context)) {
                val dialogBuilder = AlertDialog.Builder(context)
                dialogBuilder.setMessage(getString(R.string.check_connection_message))
                    .setPositiveButton("OK") { dialog, _ -> dialog.cancel() }

                val dialog = dialogBuilder.create()
                dialog.setTitle(getString(R.string.check_connection_title))
                dialog.show()
            } else if (searchCityText.text.isNullOrEmpty()) {
                val dialogBuilder = AlertDialog.Builder(context)
                dialogBuilder.setMessage(getString(R.string.search_city_alert_message))
                    .setPositiveButton("OK") { dialog, _ -> dialog.cancel() }

                val dialog = dialogBuilder.create()
                dialog.setTitle(getString(R.string.search_city_alert_title))
                dialog.show()
            } else {
                val city = searchCityText.text.toString()
                activity!!.supportFragmentManager.beginTransaction()
                    .add(R.id.container, MainFragment.newInstance(city))
                    .addToBackStack(null)
                    .commit()
                searchButton.hideKeyboard()
            }
        }
    }

    private fun checkInternetConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }

}