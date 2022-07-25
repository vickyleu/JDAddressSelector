package chihane.jdaddressselector

import chihane.jdaddressselector.model.City
import chihane.jdaddressselector.model.County
import chihane.jdaddressselector.model.Province
import chihane.jdaddressselector.model.Street

interface OnAddressSelectedListener {
    fun onAddressSelected(province: Province?, city: City?, county: County?, street: Street?)
}