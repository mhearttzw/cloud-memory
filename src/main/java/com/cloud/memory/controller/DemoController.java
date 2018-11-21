package com.cloud.memory.controller;
 
import com.cloud.memory.common.annotation.MultiRequestBody;
import com.cloud.memory.entity.Dog;
import com.cloud.memory.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**
 * 演示控制器
 * @author 明明如月
 * @date 2018/08/27
 */
@Controller
@RequestMapping("/xhr/test")
public class DemoController {
 
    @RequestMapping("/demo")
    @ResponseBody
     public String multiRequestBodyDemo1(@MultiRequestBody Dog dog, @MultiRequestBody User user) {
        System.out.println(dog.toString()+user.toString());
        return dog.toString()+";"+user.toString();
    }
 
 
    @RequestMapping("/demo2")
    @ResponseBody
    public String multiRequestBodyDemo2(@MultiRequestBody("dog") Dog dog, @MultiRequestBody User user) {
        System.out.println(dog.toString()+user.toString());
        return dog.toString()+";"+user.toString();
    }
 
    @RequestMapping("/demo3")
    @ResponseBody
    public String multiRequestBodyDemo3(@MultiRequestBody("dog") Dog dog, @MultiRequestBody("user") User user) {
        System.out.println(dog.toString()+user.toString());
        return dog.toString()+";"+user.toString();
    }
 
 
 
    @RequestMapping("/demo4")
    @ResponseBody
    public String multiRequestBodyDemo4(@MultiRequestBody("dog") Dog dog, @MultiRequestBody Integer age) {
        System.out.println(dog.toString() + age.toString());
        return dog.toString() + ";age属性为："+age.toString();
    }
 
 
    @RequestMapping("/demo5")
    @ResponseBody
    public String multiRequestBodyDemo5(@MultiRequestBody("color") String color, @MultiRequestBody("age") Integer age) {
        return "color="+color + "; age=" + age;
    }
 
    @RequestMapping("/demo6")
    @ResponseBody
    public String multiRequestBodyDemo6(@MultiRequestBody("dog") Dog dog, @MultiRequestBody Integer age) {
        System.out.println(dog.toString() + age.toString());
        return dog.toString() + ";age属性为："+age.toString();
    }
 
 
    @RequestMapping("/demo7")
    @ResponseBody
    public String multiRequestBodyDemo7(@MultiRequestBody Dog color2, @MultiRequestBody("age") Integer age) {
        return "color="+color2 + "; age=" + age;
    }
 
 
    @RequestMapping("/demo9")
    @ResponseBody
    public String multiRequestBodyDemo9( @MultiRequestBody Dog dog) {
        return dog.toString();
    }
   @RequestMapping("/demo10")
    @ResponseBody
    public String multiRequestBodyDemo10( @MultiRequestBody(parseAllFields = false,required = false) Dog dog) {
        return dog.toString();
    }
 
}
