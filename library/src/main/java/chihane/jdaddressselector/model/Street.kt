package chihane.jdaddressselector.model

import chihane.jdaddressselector.global.Database
import com.dbflow5.annotation.Column
import com.dbflow5.annotation.PrimaryKey
import com.dbflow5.annotation.Table
import com.dbflow5.structure.BaseModel

@Table(database = Database::class, name = "Street")
class Street : BaseModel() {
    @JvmField
    @PrimaryKey
    var id = 0

    @JvmField
    @Column
    var county_id = 0

    @JvmField
    @Column
    var name: String? = null
}