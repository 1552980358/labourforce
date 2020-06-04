package lib.github1552980358.labourforce.base

import lib.github1552980358.labourforce.LabourForce
import lib.github1552980358.labourforce.commands.LabourCommand
import lib.github1552980358.labourforce.commands.LabourLv
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.message.WorkMessage
import lib.github1552980358.labourforce.labours.work.LabourWork

/**
 * [KotlinExtension]
 * @author  : 1552980328
 * @since   : 0.3
 * @date    : 2020/6/4
 * @time    : 12:39
 **/

/**
 * All following functions are provided for kotlin classes only
 * that all of them they can be called anywhere within .kt file
 *
 * 以下全部函数皆为 kotlin 打造, 全部能在任何 .kt 后缀文件内直接唤出
 **/

/**
 * [onDuty]
 * @author 1552980358
 * @since 0.3
 **/
fun onDuty() = LabourForce.onDuty

/** ------------------------------------------------------ **/
/** LabourCommand **/

/**
 * [employLabour]
 * @param labourName
 * @param lv
 * @param cover
 * @return [LabourCommand]
 * @author 1552980358
 * @since 0.3
 **/
fun employLabour(labourName: String, lv: LabourLv, cover: Boolean = false) =
    onDuty().employLabour(labourName, lv, cover)

/**
 * [employLabour]
 * @param labourName
 * @param labourIdentity
 * @return [LabourCommand]
 * @author 1552980358
 * @since 0.3
 **/
fun employLabour(labourName: String, labourIdentity: LabourIdentity?, cover: Boolean = false) =
    onDuty().employLabour(labourName, labourIdentity, cover)

/**
 * [fireLabour]
 * @param labourName [String]
 * @return [LabourCommand]
 * @author 1552980358
 * @since 0.3
 **/
fun fireLabour(labourName: String) = onDuty().fireLabour(labourName)

/**
 * [sendWork2Labour]
 * @param labourName [String]
 * @param labourWork [LabourWork]
 * @return [LabourCommand]
 * @author 1552980358
 * @since 0.3
 **/
fun sendWork2Labour(labourName: String, labourWork: LabourWork, clearList: Boolean = false) =
    onDuty().sendWork2Labour(labourName, labourWork, clearList)

/**
 * [sendMsg2Labour]
 * @param labourName [String]
 * @param workMessage [WorkMessage]?
 * @author 1552980358
 * @since v0.3
 **/
fun sendMsg2Labour(labourName: String, workMessage: WorkMessage?) =
    onDuty().sendMsg2Labour(labourName, workMessage)

/** ------------------------------------------------------ **/
