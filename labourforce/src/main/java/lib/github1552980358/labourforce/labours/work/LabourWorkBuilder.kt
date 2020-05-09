package lib.github1552980358.labourforce.labours.work

import android.os.Handler
import lib.github1552980358.labourforce.labours.base.WorkPriority

/**
 * @File    : LabourWorkBuilder
 * @Author  : 1552980358
 * @Date    : 2020/5/8
 * @TIME    : 13:49
 **/

class LabourWorkBuilder: LabourWork {
    
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
        interface WorkDone {
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
        interface WorkFail {
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
        interface WorkContent {
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
        interface DutyEnd {
            /**
             * [dutyEnd]
             * @param workProduct [MutableMap]<[String], [Any]?>
             * @author 1552980358
             * @since v0.1
             **/
            fun dutyEnd(workProduct: MutableMap<String, Any?>?, handler: Handler?)
        }
        
    }
    
    constructor(handler: Handler? = null): super(handler)
    constructor(priority: WorkPriority? = null, handler: Handler? = null): super(handler)
    
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
     * [setWorkContent]
     * @param workContent [WorkContent]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate")
    fun setWorkContent(workContent: WorkContent): LabourWorkBuilder {
        this.workContentInterface = workContent
        return this
    }
    
    /**
     * [setWorkDone]
     * @param workDone [WorkDone]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate")
    fun setWorkDone(workDone: WorkDone): LabourWorkBuilder {
        this.workDoneInterface = workDone
        return this
    }
    
    /**
     * [setWorkDone]
     * @param workFail [WorkFail]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate")
    fun setWorkFail(workFail: WorkFail): LabourWorkBuilder {
        this.workFailInterface = workFail
        return this
    }
    
    /**
     * [setDutyEnd]
     * @param dutyEnd [DutyEnd]
     * @return [LabourWorkBuilder]
     * @author 1552980358
     * @since v0.1
     **/
    @Suppress("MemberVisibilityCanBePrivate")
    fun setDutyEnd(dutyEnd: DutyEnd): LabourWorkBuilder {
        this.dutyEndInterface = dutyEnd
        return this
    }
    
    /**
     * [workContent]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    override fun workContent(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
        workContentInterface!!.workContent(workProduct, handler)
    }
    
    /**
     * [workFail]
     * @param workProduct [MutableMap]
     * @author 1552980358
     * @since v0.1
     **/
    override fun workFail(e: Exception,workProduct: MutableMap<String, Any?>?,  handler: Handler?) {
        workFailInterface!!.workFail(e, workProduct, handler)
    }
    
    /**
     * [workDone]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    override fun workDone(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
        workDoneInterface!!.workDone(workProduct, handler)
    }
    
    /**
     * [dutyEnd]
     * @param workProduct [MutableMap]<[String], [Any]?>
     * @author 1552980358
     * @since v0.1
     **/
    override fun dutyEnd(workProduct: MutableMap<String, Any?>?, handler: Handler?) {
        dutyEndInterface!!.dutyEnd(workProduct, handler)
    }
    
}