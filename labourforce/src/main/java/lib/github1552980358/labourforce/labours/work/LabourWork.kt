package lib.github1552980358.labourforce.labours.work

import lib.github1552980358.labourforce.labours.base.WorkPriority
import lib.github1552980358.labourforce.labours.message.WorkMessage

/**
 * @File    : [LabourWork]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 18:20
 **/

abstract class LabourWork {
    
    /**
     * [priority]
     * @author 1552980358
     * @since v0.1
     **/
    var priority: WorkPriority? = null
        private set
    
    constructor(): super()
    constructor(priority: WorkPriority): this() {
        this.priority = priority
    }
    
    /**
     * [workProduct]
     * @author 1552980358
     * @since v0.1
     **/
    val workProduct = mutableMapOf<String, Any?>()
    //val workMessages = arrayListOf<>()
    
    /**
     * [workContent]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workContent(workProduct: MutableMap<String, Any?>?)
    
    /**
     * [workFail]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @param e [Exception]
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workFail(workProduct: MutableMap<String, Any?>?, e: Exception)
    
    /**
     * [workDone]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workDone(workProduct: MutableMap<String, Any?>?)
    
    /**
     * [dutyEnd]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun dutyEnd(workProduct: MutableMap<String, Any?>?)
    
    /**
     * [dutyEnd]
     * @param workMessage [WorkMessage]
     * @param workProduct [MutableMap]<[String], [Any]?>
     **/
    fun receiveMessage(@Suppress("UNUSED_PARAMETER") workMessage: WorkMessage?, @Suppress("UNUSED_PARAMETER") workProduct: MutableMap<String, Any?>?) {
    
    }
    
}