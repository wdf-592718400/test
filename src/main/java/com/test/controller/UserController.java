package com.test.controller;


import com.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
            if(userService.select(request).isEmpty()){
                userService.insert(request);
                res.put("status", 1);
            }
            res.put("msg", "处理成功");
            res.put("data", userService.select(request));
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
            userService.delete(request);
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.select(request));
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
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ select 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody Map<String, Object> request){
        Map<String, Object> res = new HashMap<>();
        try{
            userService.update(request);
            res.put("msg", "处理成功");
            res.put("status", 1);
            res.put("data", userService.select(request));
            return res;
        }
        catch (Exception e){
            throw new NumberFormatException("\n************ update 出错原因 ************\n" + e + "\n**********************************\n");
        }
    }

}
