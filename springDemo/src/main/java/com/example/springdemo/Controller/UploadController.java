package com.example.springdemo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
@Controller
public class UploadController {
    @Autowired
    private HttpServletRequest request;
    @PostMapping(value = "fileUpload")
    public String uploadPage(@RequestParam("file") MultipartFile file, Model model) {
        String filePath = null;
        if (!file.isEmpty()) {
            try {
              //  filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();  //上传到项目webapp下的upload中，只限本地，因为上传后项目为jar包，没有路径
                File tempDir=FileUtils.getTempDirectory();           //找到系统的tmp目录
                filePath=tempDir+"/upload/"+file.getOriginalFilename();          //提前创建upload目录
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("filename",file.getOriginalFilename());
            return "filepage";
        }
        return "error";
    }

    @GetMapping(value = "/upload")
    public String setUpload() {
        return "uploadfile";
    }

    @GetMapping(value = {"{filename}","adu/{filename}"})
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename) throws Exception{
      //  String path = request.getServletContext().getRealPath("/upload/");
        String tmp=FileUtils.getTempDirectory().getAbsolutePath();
        String path=tmp+"/upload/";
       filename = new String(filename.getBytes(), "UTF-8");
        File file = new File(path + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachent",filename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    @GetMapping(value = "/adu/filelist")
    public String download(Model model){
        String tmp=FileUtils.getTempDirectory().getAbsolutePath();
        String path=tmp+"/upload/";
        File file=new File(path);
        if(file.isDirectory()){
            File f[]=file.listFiles();
            List<String> list=new ArrayList<>();
            for(int i=0;i<f.length;i++){
                String fileName=f[i].getName();
                list.add(fileName);
                System.out.print(fileName);
            }
            model.addAttribute("fileName",list);
            return "filelist";
        }
        return "error";
    }
    @GetMapping(value = "/boot")
    public String boot(){
        return "bootstrap_upload";
    }

}