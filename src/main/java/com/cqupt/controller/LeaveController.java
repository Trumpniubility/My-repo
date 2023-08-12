package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.Service.LeaveService;
import com.cqupt.entity.Constant;
import com.cqupt.entity.Leave;
import com.cqupt.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    //学生 提交请假信息 删除请假信息  添加请假信息 查询请假结果
    //教师 审批学生请假信息

    //学生提交请假信息
    @PostMapping("/saveLeave")
    public Result addL(@RequestBody Leave leave){
        //调用方法判断请假信息是否符合要求
        String checkResult = leaveService.checkLeave(leave);
        if(checkResult!=null){
            //返回错误信息提示学生修改
            return Result.error(checkResult);
        }

        boolean result = leaveService.save(leave);
        if (!result) {
            return Result.error("提交失败");
        }

        return Result.success("提交成功");
    }

    //学生删除请假信息
    @DeleteMapping("/{id}")
    public Result deleteL(@PathVariable Integer id) {
        boolean b = leaveService.removeById(id);

        if (!b) {
            return Result.error("删除失败");
        }

        return Result.success("删除成功");
    }

    //学生修改请假信息
    @PutMapping
    public Result updateSE(@RequestBody Leave leave) {
        boolean result = leaveService.updateById(leave);

        if (!result) {
            return Result.error("修改失败");
        }

        return Result.success("修改成功");
    }

    //学生查看请假信息详情  (等待修改)
    @GetMapping("/{id}")
    @ResponseBody
    public Result selectLeaveById(@PathVariable("id") Integer id) {
        //根据学号判断学生请假信息是否存在，因为学生可能申请多条请假信息
        Leave leave = leaveService.getById(id);
        if(leave==null){
            return Result.error("很抱歉，未查询到您的请假信息");
        }

        QueryWrapper<Leave> wrapper  = new QueryWrapper<>();
        //需要返回的是前台学生的请假编号，理由，天数，学号，姓名，审核状态，审核信息（是否同意）
        QueryWrapper<Leave> queryWrapper = wrapper.select("leave_num", "reason", "day_num", "stu_no", "stu_name", "status", "opinion");

        Map<String, Object> map = leaveService.getMap(queryWrapper);
        return Result.success("查询成功",map);
    }

    //为老师展示所有等待审批的请假信息
    @PostMapping
    public Result listLeave() {
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("staus", 1);
        List<Leave> list = leaveService.list(queryWrapper);
        if (list.size()==0){
            return Result.error("当前没有需要审批的信息");
        }

        return Result.success(list);
    }

    //老师审批学生请假信息
    @PostMapping(value = "/audit")
    @ResponseBody
    public Result examineApply(@RequestBody Leave leave) {
        //设置审批时间
        leave.setAuditTime(new Date());
        // 审核通过 判断当前状态
        if (Constant.LEAVE_PASS_NUM == leave.getStatus()) {
            leave.setStatus(Constant.LEAVE_PASS_NUM);  //更新审核状态
            leave.setOpinion("[" + Constant.LEAVE_PASS + "]:" + leave.getOpinion()); // 设置审核意见
        }
        // 审核驳回
        if (Constant.LEAVE_REJECT_NUM == leave.getStatus()) {
            leave.setStatus(Constant.LEAVE_REJECT_NUM);
            leave.setOpinion("[" + Constant.LEAVE_REJECT + "]:" + leave.getOpinion());
        }
       //更新信息
        boolean b = leaveService.updateById(leave);
        if (b) {
            return Result.success("教师审查成功");
        }
        return Result.error("教师审查失败");
    }

}
