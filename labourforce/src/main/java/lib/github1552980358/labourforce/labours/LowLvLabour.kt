package lib.github1552980358.labourforce.labours

import lib.github1552980358.labourforce.labours.base.BaseLabour
import lib.github1552980358.labourforce.labours.base.LabourDuty
import lib.github1552980358.labourforce.labours.message.WorkMessage
import lib.github1552980358.labourforce.labours.work.LabourWork

/**
 * @File    : [LowLvLabour]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 21:36
 **/

class LowLvLabour(threadName: String): BaseLabour(threadName) {
    
    /**
     * [nextWork]
     * @author 1552980358
     * @since v0.1
     **/
    private var nextWork: LabourWork? = null
    
    /**
     * [run]
     * @author 1552980358
     * @since v0.1
     ***/
    override fun run() {
        while (dutyStatus != LabourDuty.EndWork) {
        
            // Check whether work has received
            // 检查是否接收到新工作
            if (nextWork == null) {
                sleep(checkInterval)
                continue
            }
        
            // New work received
            // 接收到新工作
            currentWork = nextWork
            nextWork = null
            
            if (dutyStatus == LabourDuty.EndWork)
                break
        
            super.run()
        }
    }
    
    /**
     * [onWorkReceive]
     * @param labourWork [LabourWork]?
     * @param clearList [Boolean]<false>
     * @author 1552980358
     * @since v0.1
     **/
    override fun onWorkReceive(labourWork: LabourWork?, clearList: Boolean) {
        nextWork = labourWork
    }
    
    /**
     * [offDuty]
     * @author 1552980358
     * @since v0.1
     **/
    override fun offDuty() {
        dutyStatus = LabourDuty.EndWork
        nextWork = null
        currentWork = null
    }
    
    /**
     * [isWorking]
     * @return [Boolean]
     * @author 1552980358
     * @since v0.1
     **/
    override fun isWorking(): Boolean {
        return currentWork == null
    }
    
    /**
     * [onReceiveMessage]
     * @param workMessage [WorkMessage]
     * @author 1552980358
     * @since v0.1
     **/
    override fun onReceiveMessage(workMessage: WorkMessage?) {
        currentWork?.onMessageReceive(workMessage, currentWork?.productionLine, currentWork?.handler)
    }
}