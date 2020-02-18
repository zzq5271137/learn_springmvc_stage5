package com.mycomp.springmvc.web.controller;

import com.mycomp.springmvc.domain.Pet;
import com.mycomp.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping("/testDriven")
    public String testDriven() {
        return "/results/testViewResult.jsp";
    }

    /*
     * 接收参数(想要修改的user的id)并将数据展示到页面的方法
     */
    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        System.out.println("update, id = " + id);

        // 模拟从数据库中查找
        User user = new User();
        user.setName("zzq");
        user.setAge(10);
        user.setGender(1);

        /*
         * 多选
         */
        // 这个人的爱好 (fm:checkboxes中的path属性, 要求是一个String的数组, 详见testFormResult.jsp)
        String[] hobby = new String[]{"篮球", "足球"};
        user.setHobby(hobby);

        // 所有的可选爱好
        List<String> allHobbies = new ArrayList<>();
        allHobbies.add("篮球");
        allHobbies.add("足球");
        allHobbies.add("乒乓球");
        // 也需要存到model里 (fm:checkboxes中的items属性, 要求是一个list, 详见testFormResult.jsp)
        model.addAttribute("allHobbies", allHobbies);

        /*
         * 下拉列表
         */
        // 所有的可选宠物
        List<Pet> allPets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setPetId(1);
        pet1.setPetName("狗");
        Pet pet2 = new Pet();
        pet2.setPetId(2);
        pet2.setPetName("猫");
        Pet pet3 = new Pet();
        pet3.setPetId(3);
        pet3.setPetName("仓鼠");
        allPets.add(pet1);
        allPets.add(pet2);
        allPets.add(pet3);
        // fm:select中的items属性
        model.addAttribute("allPets", allPets);

        // 这个人的宠物 (它的petId, 为fm:select中的path属性)
        user.setPet(pet2);


        model.addAttribute("user", user);
        // model.addAttribute("command", user);

        return "/results/testFormShowDataResult.jsp";
    }

    /*
     * 真正执行update的方法;
     *
     * @Valid: 开启校验;
     * BindingResult对象: 接收错误信息;
     * 设置校验规则详见User.java
     */
    @RequestMapping("doUpdate")
    public String doUpdate(@Valid User user, BindingResult bindingResult, Model model) {
        // 先判断有没有错误信息
        if (bindingResult.getErrorCount() != 0) {
            // 获取所有的错误信息集合
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                // 打印错误信息
                System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage());

                // 使用<fm:errors path="name"/>标签, 可以把错误信息显示到页面上, 详见testFormShowDataResult.jsp
            }

            // 所有的可选爱好
            List<String> allHobbies = new ArrayList<>();
            allHobbies.add("篮球");
            allHobbies.add("足球");
            allHobbies.add("乒乓球");
            // 也需要存到model里 (fm:checkboxes中的items属性, 要求是一个list, 详见testFormResult.jsp)
            model.addAttribute("allHobbies", allHobbies);

            // 所有的可选宠物
            List<Pet> allPets = new ArrayList<>();
            Pet pet1 = new Pet();
            pet1.setPetId(1);
            pet1.setPetName("狗");
            Pet pet2 = new Pet();
            pet2.setPetId(2);
            pet2.setPetName("猫");
            Pet pet3 = new Pet();
            pet3.setPetId(3);
            pet3.setPetName("仓鼠");
            allPets.add(pet1);
            allPets.add(pet2);
            allPets.add(pet3);
            // fm:select中的items属性
            model.addAttribute("allPets", allPets);

            model.addAttribute("user", user);

            // 有错误信息, 跳回原来的界面
            return "/results/testFormShowDataResult.jsp";
        } else {
            Integer petId = user.getPet().getPetId();
            switch (petId) {
                case 1:
                    user.getPet().setPetName("狗");
                    break;
                case 2:
                    user.getPet().setPetName("猫");
                    break;
                case 3:
                    user.getPet().setPetName("仓鼠");
                    break;
            }
            System.out.println("修改成功: " + user);
            model.addAttribute("user", user);
            return "/results/testFormDoUpdateResult.jsp";
        }
    }

}
