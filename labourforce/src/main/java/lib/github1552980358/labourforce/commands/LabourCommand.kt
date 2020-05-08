package lib.github1552980358.labourforce.commands

import lib.github1552980358.labourforce.labours.HighLvLabour
import lib.github1552980358.labourforce.labours.LowLvLabour
import lib.github1552980358.labourforce.labours.MidLvLabour
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.base.LabourWork

/**
 * @File    : [LabourCommand]
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
    fun employLabour(name: String, labourIdentity: LabourIdentity?, cover: Boolean = false): LabourCommand {
        labourIdentity?:return this
        if (labours.contains(name)) {
            if (!cover) {
                return this
            }
        }
        labours[name] = labourIdentity
        return this
    }
    
    /**
     * [employLabour]
     * @param name
     * @param lv
     * @param cover
     * @return [LabourCommand]
     **/
    fun employLabour(name: String, lv: LabourLv, cover: Boolean = false): LabourCommand {
        if (labours.contains(name)) {
            if (!cover) {
                return this
            }
        }
        labours[name] = when (lv) {
            LabourLv.High -> HighLvLabour()
            LabourLv.Mid -> MidLvLabour()
            LabourLv.Low -> LowLvLabour()
        }
        return this
    }
    
    /**
     * [fireLabour]
     * @param name
     * @return [LabourCommand]
     **/
    fun fireLabour(name: String): LabourCommand {
        labours[name]?.offDuty()
        labours.remove(name)
        return this
    }
    
    /**
     * [sendWork2Labour]
     * @param name [String]
     * @param labourWork [LabourWork]
     * @return [LabourCommand]
     **/
    fun sendWork2Labour(name: String, labourWork: LabourWork): LabourCommand {
        if (labours.contains(name))
            labours[name]?.onWorkReceive(labourWork)
        return this
    }
    
    /**
     * [sendWork2Labour]
     * @param name [String]
     * @author 1552980358
     * @since v0.1
     **/
    fun sendMsg2Labour(name: String) {
    
    }
    
}