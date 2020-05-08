package lib.github1552980358.labourforce.labours

import lib.github1552980358.labourforce.labours.base.BaseLabour
import lib.github1552980358.labourforce.labours.base.LabourDuty
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.base.LabourWork

/**
 * @File    : [LowLvLabour]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 21:36
 **/

class LowLvLabour: BaseLabour(), LabourIdentity {
    
    var nextWork: LabourWork? = null
    
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
    
    override fun onWorkReceive(labourWork: LabourWork?) {
        nextWork = labourWork
    }
    
    override fun offDuty() {
        dutyStatus = LabourDuty.EndWork
        nextWork = null
        currentWork = null
    }
    
    override fun isWorking(): Boolean {
        return currentWork == null
    }
    
    override fun onReceiveMessage() {
    }
}