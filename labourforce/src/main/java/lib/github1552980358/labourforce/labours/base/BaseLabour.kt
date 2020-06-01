package lib.github1552980358.labourforce.labours.base

import lib.github1552980358.labourforce.labours.work.LabourWork

/**
 * @File    : [BaseLabour]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:49
 **/

abstract class BaseLabour: Thread(), LabourIdentity {
    
    companion object {
        
        /**
         * [workDone]
         * @author 1552980358
         * @since v0.1
         **/
        val workDone = WorkDoneSignal()
        
        /**
         * [dutyEnd]
         * @author 1552980358
         * @since v0.1
         **/
        val dutyEnd = DutyEndSignal()
        
    }
    
    /**
     * [dutyStatus]
     * @author 1552980358
     * @since v0.2
     **/
    open var dutyStatus = LabourDuty.DoWork
    
    /**
     * [checkInterval]
     * @author 1552980358
     * @since v0.1
     **/
    var checkInterval = 100L
    
    /**
     * [currentWork]
     * @author 1552980358
     * @since v0.1
     **/
    internal var currentWork: LabourWork? = null
    
    /**
     * [run]
     * @author 1552980358
     * @since v0.1
     **/
    override fun run() {
        try {
            
            currentWork?.workContent(currentWork?.productionLine, currentWork?.handler)
        
            // Labour stop working
            // 劳工停止工作
            if (dutyStatus == LabourDuty.EndWork)
                throw dutyEnd
        
            // Work done
            // 工作完成
            throw workDone
        } catch (e: WorkDoneSignal) {
            currentWork?.workDone(currentWork?.productionLine, currentWork?.handler)
        } catch (e: DutyEndSignal) {
            currentWork?.dutyEnd(currentWork?.productionLine, currentWork?.handler)
        } catch (e: Exception) {
            //e.printStackTrace()
            currentWork?.workFail(e, currentWork?.productionLine, currentWork?.handler)
        }
    
        // Recycle
        // 回收
        currentWork = null
    }
    
    /**
     * [goWork]
     * @return [LabourIdentity]
     * @author 1552980358
     * @since v0.2
     **/
    fun goWork(): LabourIdentity {
        start()
        return this
    }
    
}