package lib.github1552980358.labourforce.labours

import lib.github1552980358.labourforce.labours.base.BaseLabour
import lib.github1552980358.labourforce.labours.base.LabourDuty
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.message.WorkMessage
import lib.github1552980358.labourforce.labours.work.LabourWork

/**
 * @File    : [MidLvLabour]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:47
 **/

class MidLvLabour: BaseLabour(), LabourIdentity {
    
    /**
     * [workList]
     * @author 1552980358
     * @since v0.1
     **/
    private val workList = arrayListOf<LabourWork>()
    
    /**
     * [run]
     * @author 1552980358
     * @since v0.1
     **/
    override fun run() {
        
        while (dutyStatus != LabourDuty.EndWork) {
            
            // Check whether work has received
            // 检查是否接收到新工作
            if (workList.isEmpty()) {
                sleep(checkInterval)
                continue
            }
            
            // New work in list
            // 列表中有新工作
            currentWork = workList.removeAt(0)
            
            if (dutyStatus == LabourDuty.EndWork)
                break
            
            super.run()
        }
    }
    
    /**
     * [onWorkReceive]
     * @author 1552980358
     * @since v0.1
     **/
    @Synchronized
    override fun onWorkReceive(labourWork: LabourWork?) {
        labourWork?:return
        workList.add(labourWork)
    }
    
    /**
     * [offDuty]
     * @author 1552980358
     * @since v0.1
     **/
    override fun offDuty() {
        dutyStatus = LabourDuty.EndWork
        workList.clear()
        currentWork = null
    }
    
    /**
     * [isWorking]
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
        currentWork?.receiveMessage(workMessage, currentWork?.productionLine)
    }
    
}