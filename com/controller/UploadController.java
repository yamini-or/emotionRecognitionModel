package com.mkyong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

import java.io.File;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import main.java.com.myFile.ListFilesUtil;
import main.java.com.myFile.RunPythonUtil;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.StringWriter;
import javax.script.ScriptEngineManager;
import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import java.io.FileReader;


@Controller

public class UploadController {

    private static String UPLOADED_FOLDER = "//Users//yaminiaggarwal//Documents//temp//";

    //For main page-single or multi upload
    @GetMapping("/")
    public String index() {
        return "homePage";
    }

    @RequestMapping(value="/homePage", params="act1", method = RequestMethod.POST)
    public String home1(ModelMap model) {
        ListFilesUtil listFilesUtil = new ListFilesUtil();
        String videoList = listFilesUtil.listFiles(UPLOADED_FOLDER);
        model.addAttribute("files", videoList);
        return "viewFiles";
    }

    @RequestMapping(value="/homePage", params="act2", method = RequestMethod.POST)
    public String home2() {
        return "upload";
    }

    @PostMapping("/viewFiles") //new annotation since 4.3
    public String selectVideo(@RequestParam("video") String video,
                                   RedirectAttributes redirectAttributes) {
        if (StringUtils.isEmpty(video)) {
                redirectAttributes.addFlashAttribute("message", "Please select a video for analysis");
                redirectAttributes.addFlashAttribute("video", "");
            } else {
                redirectAttributes.addFlashAttribute("message", "You selected '" + video + "'");
                redirectAttributes.addFlashAttribute("video", video);
            }
        return "redirect:/uploadStatus";
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            redirectAttributes.addFlashAttribute("video", "");
            return "redirect:uploadStatus";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("video", file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @PostMapping("/uploadMulti")
    public String multiFileUpload(@RequestParam("files") MultipartFile[] files,
                                  RedirectAttributes redirectAttributes) {

        StringJoiner sj = new StringJoiner(" , ");

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            try {

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);

                sj.add(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String uploadedFileName = sj.toString();
        if (StringUtils.isEmpty(uploadedFileName)) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            //redirectAttributes.addFlashAttribute("video", "");
        } else {
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + uploadedFileName + "'");
            //redirectAttributes.addFlashAttribute("video", file.getOriginalFilename());
        }

        return "redirect:/uploadStatus";

    }


    @GetMapping("/uploadStatus")
    public String uploadStatus(@ModelAttribute("video") String video,
                               RedirectAttributes redirectAttributes) {
        
        redirectAttributes.addFlashAttribute("video", video);
        return "uploadStatus";
    }

    @GetMapping("/uploadMultiPage")
    public String uploadMultiPage() {
        return "uploadMulti";
    }

    @PostMapping("/startAnalysis")
    public String startAnalysis(@ModelAttribute("video") String video,
                                RedirectAttributes redirectAttributes) {

        RunPythonUtil runPythonUtil = new RunPythonUtil();
        String emotionList = runPythonUtil.runPython(video);
        redirectAttributes.addFlashAttribute("emotionList", emotionList);
        return "redirect:/analysisFinal";

    }

    @GetMapping("/analysisFinal")
    public String analysisFinal() {
        return "analysisFinal";
    }



}