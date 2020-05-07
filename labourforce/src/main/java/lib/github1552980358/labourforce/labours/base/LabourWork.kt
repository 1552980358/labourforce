package lib.github1552980358.labourforce.labours.base

/**
 * @File    : LabourWork
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:20
 **/

abstract class LabourWork {
    
    /**
     * [workProduct]
     * @author 1552980358
     **/
    val workProduct = mutableMapOf<String, Any?>()
    //val workMessages = arrayListOf<>()
    
    /**
     * [workContent]
     * @param workMessage
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workContent(workMessage: MutableMap<String, Any?>?)
    
    /**
     * [workFail]
     * @param workMessage
     * @param e
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workFail(workMessage: MutableMap<String, Any?>?, e: Exception)
    
    /**
     * [workDone]
     * @param workMessage
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workDone(workMessage: MutableMap<String, Any?>?)
    
    /**
     * [dutyEnd]
     * @param workMessage
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun dutyEnd(workMessage: MutableMap<String, Any?>?)
    
}