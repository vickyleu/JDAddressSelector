package chihane.jdaddressselector

import android.content.Context
import chihane.jdaddressselector.global.Database
import chihane.jdaddressselector.model.*
import com.dbflow5.config.FlowConfig
import com.dbflow5.config.FlowManager
import com.dbflow5.config.database
import com.dbflow5.query.select

class DefaultAddressProvider(context: Context) : AddressProvider {
    val db = database<Database>();
    override fun provideProvinces(addressReceiver: AddressProvider.AddressReceiver<Province?>) {
        (select from Province::class) // some conditions
            .flowQueryList(db).use { list ->
                // list is just backed by an active cursor.
                addressReceiver.send(ArrayList<Province>(list))
            }
    }

    override fun provideCitiesWith(
        provinceId: Int,
        addressReceiver: AddressProvider.AddressReceiver<City?>
    ) {
        (select from City::class
                where
                City_Table.province_id.eq(provinceId)
                ) // some conditions
            .flowQueryList(db).use { list ->
                // list is just backed by an active cursor.
                addressReceiver.send(ArrayList<City>(list))
            }
    }

    override fun provideCountiesWith(
        cityId: Int,
        addressReceiver: AddressProvider.AddressReceiver<County?>
    ) {
        (select from County::class
                where
                County_Table.city_id.eq(cityId)
                ) // some conditions
            .flowQueryList(db).use { list ->
                // list is just backed by an active cursor.
                addressReceiver.send(ArrayList<County>(list))
            }
    }

    override fun provideStreetsWith(
        countyId: Int,
        addressReceiver: AddressProvider.AddressReceiver<Street?>
    ) {
        (select from Street::class
                where
                Street_Table.county_id.eq(countyId)
                ) // some conditions
            .flowQueryList(db).use { list ->
                // list is just backed by an active cursor.
                addressReceiver.send(ArrayList<Street>(list))
            }
    }

    init {
        FlowManager.init(FlowConfig.Builder(context.applicationContext).build())
    }
}