package lib.github1552980358.labourforce.commands

import lib.github1552980358.labourforce.labours.base.LabourIdentity

/**
 * @File    : LabourCommand
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:11
 **/

interface LabourCommand {
    
    companion object {
        
        /** [labours] **/
        val labours = mutableMapOf<String, LabourIdentity>()
        
    }
    
    /**
     * [employLabour]
     * @param name
     * @param labourIdentity
     * @return [LabourCommand]
     **/
    fun employLabour(name: String, labourIdentity: LabourIdentity?): LabourCommand {
        labourIdentity?:return this
        labours[name] = labourIdentity
        return this
    }
    
    /**
     * [fireLabour]
     * @param name
     * @return [LabourCommand]
     **/
    fun fireLabour(name: String): LabourCommand {
        labours[name]?.offDuty()
        return this
    }
    
}