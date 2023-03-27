package com.springapllication.Application1.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.springapllication.Application1.Model.Folder;
import com.springapllication.Application1.Model.Student;
import com.springapllication.Application1.Repository.DFolderRepository;
import com.springapllication.Application1.Repository.StudentRepository;
import com.springapllication.Application1.Service.Services;

@RestController
//@Controller
//@ResponseBody
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private Services services;
	@Autowired
	private StudentRepository Srepo;
	@Autowired
	private DFolderRepository Frepo;
	@PostMapping("/{fida}/{person}/fileName")
	public ResponseEntity<String> createFile(@RequestParam("file1") MultipartFile file, @PathVariable String fida ,@PathVariable String person)throws IOException {	
		Long fid=Long.parseLong(fida);
		List<Student> s1=Srepo.findAll();
		for(Student std:s1) {
			if(std.getFName().equals(file.getOriginalFilename()) && std.getFolderNamee()==fid) {
				return ResponseEntity.ok("exiting file");
			}
		}
		Student std1=new Student(person, fid,file.getOriginalFilename(),file.getContentType(),file.getBytes());
		Srepo.save(std1);
		return ResponseEntity.ok("created");
	}

	@PostMapping("/folderName/{folderName1}")
	public ResponseEntity<String> createFolder(@PathVariable String folderName1){
		
		String name=folderName1;
		List<Folder> f1=Frepo.findAll();
		for(Folder f2:f1) {
			if(f2.getFolderName().equals(name)) {
				return ResponseEntity.ok("exiting folder");
			}
		}
		Folder fld=new Folder(name);
		Frepo.save(fld);
		return ResponseEntity.ok("created");
	}
	@PutMapping("/{fida1}/{folderNamenew}")
	public ResponseEntity<String> updateFileName(@PathVariable String fida1,@PathVariable String folderNamenew){
		Long fid=Long.parseLong(fida1);
		Student f=Srepo.findById(fid).orElse(null);
		f.setFName(folderNamenew);
		Srepo.save(f);
		return ResponseEntity.ok("updated");
	}
	@GetMapping("/folders")
	
	public List<Folder> getfolder() {
		return services.getallFolders();
	}
	@GetMapping("/{fid}")
	public ArrayList<Student> getFiles(@PathVariable Long fid){
		ArrayList<Student> cars = new ArrayList<Student>();
		List<Student> std=Srepo.findAll();
		for(Student std1:std) {
			if (std1.getFolderNamee()==fid){
				cars.add(std1);
			}
		}
		
		return cars;
	}
	@GetMapping("/{fida}/{ida}")
	public Student getFolder(@PathVariable String fida,@PathVariable String ida){
		Long fid=Long.parseLong(fida);
		
		Long id=Long.parseLong(ida);
		List<Student> std =Srepo.findAll();
		for(Student std1:std) {
			if(std1.getFolderNamee()==fid && std1.getId()==id) {
				return std1;
			}
		}
		return null;
	}
	@DeleteMapping("/delete/{fida}")
	public ResponseEntity<String> deleteFolder(@PathVariable String fida){
		Long fid=Long.parseLong(fida);
		Frepo.deleteById(fid);
		List<Student> std =Srepo.findAll();
		for(Student std1:std) {
			if(std1.getFolderNamee()==fid) {
				Srepo.deleteById(std1.getId());
			}
		}
		return ResponseEntity.ok("Deleted");
	}
	@DeleteMapping("/delete/{fid}/{fileid}")
	public ResponseEntity<String> deleteFolder(@PathVariable Long fid,@PathVariable Long fileid){
		Srepo.deleteById(fileid);
		return ResponseEntity.ok("deleted");
	}
	@PutMapping("/updateFolder1/{fida}/{folderName}")
	public ResponseEntity<String> updateFolder(@PathVariable String fida,@PathVariable String folderName) throws IOException{
		Long fid=Long.parseLong(fida);
		List<Folder> fld=Frepo.findAll();
		for(Folder fd:fld) {
			if (fd.getId()==fid) {
				fd.setFolderName(folderName);
				Frepo.save(fd);
				return ResponseEntity.ok("updated folder");
			}
		}
		return ResponseEntity.ok(null);
	}


}
