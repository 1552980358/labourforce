package lib.github1552980358.labourforce.android

import android.app.Application
import lib.github1552980358.labourforce.LabourForce

/**
 * @File    : [Application]
 * @Author  : 1552980358
 * @Date    : 2020/5/9
 * @TIME    : 9:31
 **/

open class Application: Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize
        // 始初化
        LabourForce.onDuty
    }
    
}