package com.test.controller;


import com.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        res.put("status", 0);
        try{
            request.put("create_time", new Date());
            if(userService.selectAll(request).isEmpty()){
                userService.insert(request);
                res.put("status", 1);
            }
            res.put("msg", "处理成功");
            res.put("data", userService.select(request));
            System.out.println("添加成功  ------------------  " + userService.selectAll(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ insert 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object delete(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.select(request));
            userService.delete(request);
            System.out.println("删除成功  ------------------  " + userService.selectAll(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ delete 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Object select(@RequestBody Map<String,Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.select(request));
            res.put("key", UUID.randomUUID().toString().replaceAll("-", ""));
            userService.insertKey(res);
            System.out.println("查询成功  ------------------  " + userService.selectAll(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ select 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/forget/password", method = RequestMethod.POST)
    public Object forgetPassword(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        res.put("msg", "处理成功");
        res.put("status", 0);
        try{
            if(!userService.forgetPassword(request).isEmpty()){
                res.put("status", 1);
            }
            res.put("data", userService.forgetPassword(request));
            System.out.println("查询成功  ------------------  " + userService.selectAll(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ select 出错原因 ************\n" + e + "\n**********************************\n");
        }

    }

    @RequestMapping(value = "/reset/password", method = RequestMethod.POST)
    public Object resetPassword(@RequestBody Map<String, Object> request){
        System.out.println(request);
        Map<String, Object> res = new HashMap<>();
        res.put("msg", "处理成功");
        res.put("status", 0);
        try{
            if(!userService.selectId(request).get(0).get("password").equals(request.get("password"))){
                res.put("status", 1);
                userService.resetPassword(request);
            }
            System.out.println("修改成功  ------------------  " + userService.selectId(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            userService.update(request);
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.selectId(request));
            System.out.println("修改成功  ------------------  " + userService.selectAll(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/select/key", method = RequestMethod.POST)
    public Object selectKey(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            if(request.get("key") == ""){
                request.put("key", 111);
            }
            userService.selectKey(request);
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("key", userService.selectKey(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/delete/key", method = RequestMethod.POST)
    public void deleteKey(@RequestBody Map<String, Object> request){
        System.out.println("Key:" + request.get("key") + "\t已删除");
        try{
            if(request.get("key") == ""){
                return;
            }
            userService.deleteKey(request);
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/select/own/information", method = RequestMethod.POST)
    public Object ownInformation(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.selectId(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

}
