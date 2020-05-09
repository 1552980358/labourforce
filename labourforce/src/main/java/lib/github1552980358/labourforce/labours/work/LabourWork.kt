package lib.github1552980358.labourforce.labours.work

import android.os.Handler
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
    
    /**
     * [Handler]
     * @author 1552980358
     * @since v0.1
     **/
    var handler = null as Handler?
        private set
    
    constructor(handler: Handler? = null): super() {
        this.handler = handler
    }
    constructor(priority: WorkPriority? = null, handler: Handler? = null): this(handler) {
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
    abstract fun workContent(workProduct: MutableMap<String, Any?>?, handler: Handler?)
    
    /**
     * [workFail]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @param e [Exception]
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workFail( e: Exception,workProduct: MutableMap<String, Any?>?, handler: Handler?)
    
    /**
     * [workDone]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun workDone(workProduct: MutableMap<String, Any?>?, handler: Handler?)
    
    /**
     * [dutyEnd]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    abstract fun dutyEnd(workProduct: MutableMap<String, Any?>?, handler: Handler?)
    
    /**
     * [dutyEnd]
     * @param workMessage [WorkMessage]
     * @param workProduct [MutableMap]<[String], [Any]?>
     **/
    fun receiveMessage(@Suppress("UNUSED_PARAMETER") workMessage: WorkMessage?, @Suppress("UNUSED_PARAMETER") workProduct: MutableMap<String, Any?>?) {
    
    }
    
}