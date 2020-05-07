package lib.github1552980358.labourforce.labours.base

/**
 * @File    : BaseLabour
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:49
 **/

open class BaseLabour: Thread() {
    
    companion object {
        
        /** [workDone] **/
        val workDone = WorkDoneSignal()
        
        /** [dutyEnd] **/
        val dutyEnd = DutyEndSignal()
        
    }
    
    open var dutyStatus = LabourDuty.DoWork
    
    /** [checkInterval] **/
    var checkInterval = 100L
        private set
    
    /** [currentWork] **/
    internal var currentWork: LabourWork? = null
    
}