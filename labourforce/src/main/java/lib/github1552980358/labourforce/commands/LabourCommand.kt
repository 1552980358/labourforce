package lib.github1552980358.labourforce.commands

import lib.github1552980358.labourforce.labours.HighLvLabour
import lib.github1552980358.labourforce.labours.LowLvLabour
import lib.github1552980358.labourforce.labours.MidLvLabour
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.message.WorkMessage
import lib.github1552980358.labourforce.labours.work.LabourWork

/**
 * @File    : [LabourCommand]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:11
 **/

interface LabourCommand {
    
    companion object {
        
        /**
         * [labours]
         * @author 1552980358
         * @since v0.1
         **/
        val labours = mutableMapOf<String, LabourIdentity>()
        
    }
    
    /**
     * [employLabour]
     * @param name
     * @param labourIdentity
     * @return [LabourCommand]
     * @author 1552980358
     * @since v0.1
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
     * @author 1552980358
     * @since v0.1
     **/
    fun employLabour(name: String, lv: LabourLv, cover: Boolean = false): LabourCommand {
        if (labours.contains(name)) {
            if (!cover) {
                return this
            }
        }
        // If not casting as LabourIdentity, compilation won't be passed
        // 如果不转义为 [LabourIdentity], 编译会无法通过
        //@Suppress("USELESS_CAST")
        @Suppress("USELESS_CAST")
        labours[name] = when (lv) {
            LabourLv.High -> HighLvLabour(name).goWork()
            LabourLv.Mid -> MidLvLabour(name).goWork()
            LabourLv.Low -> LowLvLabour(name).goWork()
        }
        return this
    }
    
    /**
     * [fireLabour]
     * @param name
     * @return [LabourCommand]
     * @author 1552980358
     * @since v0.1
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
     * @author 1552980358
     * @since v0.1
     **/
    fun sendWork2Labour(name: String, labourWork: LabourWork, clearList: Boolean = false): LabourCommand {
        if (labours.contains(name))
            labours[name]?.onWorkReceive(labourWork, clearList)
        return this
    }
    
    /**
     * [sendMsg2Labour]
     * @param name [String]
     * @author 1552980358
     * @since v0.1
     **/
    fun sendMsg2Labour(name: String, workMessage: WorkMessage?) {
        labours[name]?.onReceiveMessage(workMessage)
    }
    
}