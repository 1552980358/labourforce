package lib.github1552980358.labourforce.labours.base

/**
 * @File    : LabourIdentity
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:42
 **/

interface LabourIdentity {
    
    /**
     * [onWorkReceive]
     * @param labourWork
     * @author 1552980358
     * @since v0.1
     **/
    fun onWorkReceive(labourWork: LabourWork?)
    
    /**
     * [offDuty]
     * @author 1552980358
     * @since v0.1
     **/
    fun offDuty()
    
    /**
     * [isWorking]
     **/
    fun isWorking(): Boolean
    
    fun onReceiveMessage()
    
}