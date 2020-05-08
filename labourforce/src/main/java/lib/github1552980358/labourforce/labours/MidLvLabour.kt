package lib.github1552980358.labourforce.labours

import lib.github1552980358.labourforce.labours.base.BaseLabour
import lib.github1552980358.labourforce.labours.base.DutyEndSignal
import lib.github1552980358.labourforce.labours.base.LabourDuty
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.base.LabourWork
import lib.github1552980358.labourforce.labours.base.WorkDoneSignal
import java.io.File

/**
 * @File    : [MidLvLabour]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:47
 **/

class MidLvLabour: BaseLabour(), LabourIdentity {
    
    /** [workList] **/
    private val workList = arrayListOf<LabourWork>()
    
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
     **/
    @Synchronized
    override fun onWorkReceive(labourWork: LabourWork?) {
        labourWork?:return
        workList.add(labourWork)
    }
    
    /**
     * [offDuty]
     **/
    override fun offDuty() {
        dutyStatus = LabourDuty.EndWork
        workList.clear()
        currentWork = null
    }
    
    /**
     * [isWorking]
     **/
    override fun isWorking(): Boolean {
        return currentWork == null
    }
    
    /**
     * [onReceiveMessage]
     **/
    override fun onReceiveMessage() {
    
    }
    
}