@file:Suppress("unused")

package lib.github1552980358.labourforce.labours.work

import android.os.Handler
import lib.github1552980358.labourforce.labours.base.WorkPriority
import lib.github1552980358.labourforce.labours.message.WorkMessage

/**
 * @File    : LabourWorkBuilder
 * @Author  : 1552980358
 * @Date    : 2020/5/8
 * @TIME    : 13:49
 **/

class LabourWorkBuilder {
    
    companion object {
    
        /**
         * [getBuilder]
         * @return [LabourWorkBuilder]
         * @author 1552980358
         * @since v0.1
         **/
        @JvmStatic
        fun getBuilder(): LabourWorkBuilder {
            return LabourWorkBuilder()
        }
    
        /**
         * [getBuilder]
         * @param handler [Handler]?
         * @return [LabourWorkBuilder]
         * @author 1552980358
         * @since v0.1
         **/
        @JvmStatic
        fun getBuilder(handler: Handler? = null): LabourWorkBuilder {
            return LabourWorkBuilder(handler)
        }
    
        /**
         * [getBuilder]
         * @param priority [WorkPriority]<null>
         * @param handler [Handler]<null>
         * @return [LabourWorkBuilder]
         * @author 1552980358
         * @since v0.1
         **/
        @JvmStatic
        fun getBuilder(priority: WorkPriority? = null, handler: Handler? = null): LabourWorkBuilder {
            return LabourWorkBuilder(priority, handler)
        }
    
        /**
         * [WorkDone]
         * @author 1552980358
         * @since v0.1
         **/
        fun interface WorkDone {
            /**
             * [workDone]
             * @param workProduct [MutableMap]<[String], [Any]?>
             * @author 1552980358
             * @since v0.1
             **/
            fun workDone(workProduct: MutableMap<String, Any?>?, handler: Handler?)
        }
    
        /**
         * [WorkFail]
         * @author 1552980358
         * @since v0.1
         **/
        fun interface WorkFail {
            /**
             * [workFail]
             * @param workProduct [MutableMap]<[String], [Any]?>
             * @author 1552980358
             * @since v0.1
             **/
            fun workFail(e: Exception,workProduct: MutableMap<String, Any?>?,  handler: Handler?)
        }
    
        /**
         * [WorkContent]
         * @author 1552980358
         * @since v0.1
         **/
        fun interface WorkContent {
            /**
             * [workContent]
             * @param workProduct [MutableMap]<[String], [Any]?>
             * @author 1552980358
             * @since v0.1
             **/
            fun workContent(workProduct: MutableMap<String, Any?>?, handler: Handler?)
        }
    
        /**
         * [DutyEnd]
         * @author 1552980358
         * @since v0.1
         **/
        fun interface DutyEnd {
            /**
             * [dutyEnd]
             * @param workProduct [MutableMap]<[String], [Any]?>
             * @author 1552980358
             * @since v0.1
             **/
            fun dutyEnd(workProduct: MutableMap<String, Any?>?, handler: Handler?)
        }

        /**
         * [MessageReceived]
         * @author 1552980358
         * @since v0.3
         **/
        fun interface MessageReceived {
            /**
             * [messageReceived]
             * @param workMessage [WorkMessage]?
             * @param workProduct [MutableMap]<[String], [Any]?>?
             * @param handler [Handler]?
             * @author 1552980358
             * @since v0.3
             **/
            fun messageReceived(workMessage: WorkMessage?, workProduct: MutableMap<String, Any?>?, handler: Handler?)
        }
        
    }
    
    private constructor(handler: Handler? = null): super() {
        this.handler = handler
    }
    @Suppress("UNUSED_PARAMETER")
    private constructor(priority: WorkPriority? = null, handler: Handler? = null): this(handler) {
        this.priority = priority
    }
    
    /**
     * [handler]
     * @author 1552980358
     * @since v0.1
     **/
    private var handler: Handler? = null
    
    /**
     * [priority]
     * @author 1552980358
     * @since v0.1
     **/
    private var priority: WorkPriority? = null
    
    /**
     * [workContentInterface]
     * @author 1552980358
     * @since v0.1
     **/
    private var workContentInterface: WorkContent? = null
    
    /**
     * [workDoneInterface]
     * @author 1552980358
     * @since v0.1
     **/
    private var workDoneInterface: WorkDone? = null
    
    /**
     * [workFailInterface]
     * @author 1552980358
     * @since v0.1
     **/
    private var workFailInterface: WorkFail? = null
    
    /**
     * [dutyEndInterface]
     * @author 1552980358
     * @since v0.1
     **/
    private var dutyEndInterface: DutyEnd? = null

    /**
     * [messageReceivedInterface]
     * @author 1552980358
     * @since v0.3
     **/
    private var messageReceivedInterface: MessageReceived? = null
    
    /**
     * [setWorkContent]
     * @param workContent [WorkContent]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate", "unused")
    fun setWorkContent(workContent: WorkContent) = this.apply {
        this.workContentInterface = workContent
    }
    
    /**
     * [setWorkDone]
     * @param workDone [WorkDone]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate")
    fun setWorkDone(workDone: WorkDone) = this.apply {
        this.workDoneInterface = workDone
    }
    
    /**
     * [setWorkDone]
     * @param workFail [WorkFail]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate", "unused")
    fun setWorkFail(workFail: WorkFail) = this.apply {
        this.workFailInterface = workFail
    }
    
    /**
     * [setDutyEnd]
     * @param dutyEnd [DutyEnd]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate", "unused")
    fun setDutyEnd(dutyEnd: DutyEnd) = this.apply {
        this.dutyEndInterface = dutyEnd
    }
    
    /**
     * [build]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate", "unused")
    fun build() = object : LabourWork(priority, handler) {
        
        /**
         * [workContent]
         * @param workProduct [MutableMap]<[String], [Any]?>
         * @param handler [Handler]?
         * @author 1552980358
         * @since v0.1
         **/
        override fun workContent(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
            workContentInterface!!.workContent(workProduct, handler)
        }
    
        /**
         * [workFail]
         * @param e [Exception]
         * @param workProduct [MutableMap]
         * @param handler [Handler]?
         * @author 1552980358
         * @since v0.1
         **/
        override fun workFail(e: Exception, workProduct: MutableMap<String, Any?>?, handler: Handler?) {
            workFailInterface?.workFail(e, workProduct, handler)
        }
    
        /**
         * [workDone]
         * @param workProduct [MutableMap]<[String], [Any]?>
         * @param handler [Handler]?
         * @author 1552980358
         * @since v0.1
         **/
        override fun workDone(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
            workDoneInterface?.workDone(workProduct, handler)
        }
    
        /**
         * [dutyEnd]
         * @param workProduct [MutableMap]<[String], [Any]?>
         * @param handler [Handler]?
         * @author 1552980358
         * @since v0.1
         **/
        override fun dutyEnd(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
            dutyEndInterface?.dutyEnd(workProduct, handler)
        }

        /**
         * [messageReceived]
         * @param workMessage [WorkMessage]?
         * @param workProduct [MutableMap]<[String], [Any]?>?
         * @param handler [Handler]?
         * @author 1552980358
         * @since v0.3
         **/
        override fun messageReceived(workMessage: WorkMessage?, workProduct: MutableMap<String, Any?>?, handler: Handler?) {
            messageReceivedInterface?.messageReceived(workMessage, workProduct, handler)
        }

    }
    
}