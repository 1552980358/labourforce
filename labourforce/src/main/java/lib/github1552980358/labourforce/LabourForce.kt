package lib.github1552980358.labourforce

import lib.github1552980358.labourforce.commands.LabourCommand
import lib.github1552980358.labourforce.commands.LabourSource

/**
 * @File    : [LabourForce]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:03
 **/

class LabourForce private constructor(): LabourCommand, LabourSource {
    
    companion object {
        
        /** [onDuty] **/
        @JvmStatic
        val onDuty by lazy { LabourForce() }
        
    }
    
}