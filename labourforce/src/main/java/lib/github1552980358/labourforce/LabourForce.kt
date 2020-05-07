package lib.github1552980358.labourforce

import lib.github1552980358.labourforce.commands.LabourCommand

/**
 * @File    : LabourForce
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:03
 **/

class LabourForce: LabourCommand {
    
    companion object {
        
        @JvmStatic
        val startOperate by lazy { LabourForce() }
        
    }
    
    
    
}