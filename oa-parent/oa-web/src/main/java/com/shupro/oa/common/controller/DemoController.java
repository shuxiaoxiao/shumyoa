package com.shupro.oa.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo示例初始化页面
 * @author shu
 *
 */
@Controller
//@RequestMapping("/")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
    
    @RequestMapping(value = "/leftDemo")
    public String leftDemo(Model model) {
        return "/leftDemo";
    }
    
    @RequestMapping(value = "/initLinkButton")
    public String initLinkButton(Model model) {
    	return "/demo/1-button/linkbutton";
    }
    
    @RequestMapping(value = "/initSwitchButton")
    public String initSwitchButton(Model model) {
    	return "/demo/1-button/switchbutton";
    }
    
    @RequestMapping(value = "/initPanel")
    public String initPanel(Model model) {
    	return "/demo/1-panel/basic-panel";
    }
    
    @RequestMapping(value = "/initPanel-js")
    public String initPanel2(Model model) {
    	return "/demo/1-panel/panel-js";
    }
    
    @RequestMapping(value = "/initMessager")
    public String initMessager(Model model) {
    	return "/demo/2-window/message";
    }
    
    @RequestMapping(value = "/initWindow")
    public String initWindow(Model model) {
    	return "/demo/2-window/window";
    }
    
    @RequestMapping(value = "/initWindow-style")
    public String initWindow2(Model model) {
    	return "/demo/2-window/window-style";
    }
    
    @RequestMapping(value = "/initDialog")
    public String initDialog(Model model) {
    	return "/demo/2-window/basic-dialog";
    }
    
    @RequestMapping(value = "/initDialog-js")
    public String initDialog2(Model model) {
    	return "/demo/2-window/dialog-js";
    }
    
    @RequestMapping(value = "/initForm")
    public String initForm(Model model) {
    	return "/demo/3-form/dialog-form";
    }
    
    @RequestMapping(value = "/initForm-valide")
    public String initFormValide(Model model) {
    	return "/demo/3-form/form-valide";
    }
    
    @RequestMapping(value = "/initForm-file")
    public String initFormFile(Model model) {
    	return "/demo/3-form/form-file";
    }
    
    @RequestMapping(value = "/initComboBox")
    public String initComboBox(Model model) {
    	return "/demo/3-combo/basic-combo";
    }
    
    @RequestMapping(value = "/initComboBox-js")
    public String initComboBox2(Model model) {
    	return "/demo/3-combo/combo-js";
    }
    
    @RequestMapping(value = "/initComboBox-cascade")
    public String initComboBox3(Model model) {
    	return "/demo/3-combo/combo-cascade";
    }
    
    @RequestMapping(value = "/initCombogrid")
    public String initCombogrid(Model model) {
    	return "/demo/3-combo/combogrid";
    }
    
    @RequestMapping(value = "/initCombotree")
    public String initCombotree(Model model) {
    	return "/demo/3-combo/combotree";
    }
    
    @RequestMapping(value = "/initGrid")
    public String initGrid(Model model) {
    	return "/demo/5-grid/basic-grid";
    }
    
    @RequestMapping(value = "/initGrid-js")
    public String initGrid2(Model model) {
    	return "/demo/5-grid/grid-js";
    }
    
    @RequestMapping(value = "/initTree")
    public String initTree(Model model) {
    	return "/demo/6-tree/tree";
    }
    
    @RequestMapping(value = "/initTree-js")
    public String initTree2(Model model) {
    	return "/demo/6-tree/tree-js";
    }
    
    @RequestMapping(value = "/initTreegrid")
    public String initTreegrid(Model model) {
    	return "/demo/6-tree/treegrid";
    }
    

}
