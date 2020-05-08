package lib.github1552980358.labourforce.labours.base

/**
 * @File    : [BaseLabour]
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
    
    override fun run() {
        try {
            currentWork?.workContent(currentWork?.workProduct)
        
            // Labour stop working
            // 劳工停止工作
            if (dutyStatus == LabourDuty.EndWork)
                throw dutyEnd
        
            // Work done
            // 工作完成
            throw workDone
        } catch (e: WorkDoneSignal) {
            currentWork?.workDone(currentWork?.workProduct)
        } catch (e: DutyEndSignal) {
            currentWork?.dutyEnd(currentWork?.workProduct)
        } catch (e: Exception) {
            //e.printStackTrace()
            currentWork?.workFail(currentWork?.workProduct, e)
        }
    
        // Recycle
        // 回收
        currentWork = null
    }
    
    /** [checkInterval] **/
    var checkInterval = 100L
    
    /** [currentWork] **/
    internal var currentWork: LabourWork? = null
    
}