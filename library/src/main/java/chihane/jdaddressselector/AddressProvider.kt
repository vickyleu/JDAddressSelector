package chihane.jdaddressselector

import chihane.jdaddressselector.model.City
import chihane.jdaddressselector.model.County
import chihane.jdaddressselector.model.Province
import chihane.jdaddressselector.model.Street

interface AddressProvider {
    fun provideProvinces(addressReceiver: AddressReceiver<Province?>)
    fun provideCitiesWith(provinceId: Int, addressReceiver: AddressReceiver<City?>)
    fun provideCountiesWith(cityId: Int, addressReceiver: AddressReceiver<County?>)
    fun provideStreetsWith(countyId: Int, addressReceiver: AddressReceiver<Street?>)
    interface AddressReceiver<T> {
        fun send(data: List<T>?)
    }
}