package com.springapllication.Application1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.springapllication.Application1.Model.Folder;
import com.springapllication.Application1.Model.Student;
import com.springapllication.Application1.Repository.DFolderRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import java.net.http.HttpHeaders;
@AutoConfigureMockMvc
@SpringBootTest
public class TestClass {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private DFolderRepository Frepo;
	@Test
	public void putfile() throws Exception {
		mockMvc.perform(post("/api/folderName/{folderName1}","testingfilder"))
		.andExpect(status().isOk());
		mockMvc.perform(post("/api/folderName/{folderName1}","testingfilder1"))
		.andExpect(status().isOk());
	}
//	@Test
//	public void testFileUpload() throws Exception {
////	    Folder testFile = new Folder("testfile.txt");
//		Student st=new Student("harsha",(long) 5,"test9.txt","text/plain","data".getBytes());
//	    //byte[] fileContent = Folder.readAllBytes(testFile.toPath());
//
//	    mockMvc.perform(
//	            post("/api/5/harsha/fileName"))
////	            .contentType(st)
////	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
////	            .param("person", "harsha1"))
//	    .andExpect(status().isOk());
//	}
//	@Test
//    public void testFileUpload() throws Exception {
//        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "test data".getBytes());
//
//        mockMvc.perform(post("/api/5/harsha/fileName"))
//        		.param(MultipartFile(file))
//                .andExpect(status().isOk());
//               // .andExpect(content().string("File uploaded!"));
//    }
	@Test
	public void testGetAllFolders() throws Exception {
		mockMvc.perform(get("/api/folders"))
		.andExpect(status().isOk());
		}
	@Test
	public void testGetFile() throws Exception{
		mockMvc.perform(get("/api/3/9"))
		.andExpect(status().isOk());
	}
	@Test
	public void getfilesinfolder() throws Exception{
		mockMvc.perform(get("/api//{fid}",9))
		.andExpect(status().isOk());
	}
	@Test
	public void testDeltetFolder() throws Exception {
		Folder fld=new Folder("harsha1");
		Frepo.save(fld);
		mockMvc.perform(delete("/api/delete/49"))
	.andExpect(status().isOk());
	}
	@Test
	public void testdeleteFile() throws Exception{
		mockMvc.perform(delete("/api/delete/5/30"))
		.andExpect(status().isOk());
	}
	@Test
	public void updateFolder() throws Exception{
		mockMvc.perform(put("/api/updateFolder1/2/testthefolder5"))
		.andExpect(status().isOk());
	}
	@Test
	public void createFile() throws Exception{
		Long folderid = (long ) 41;
		String url = "/api/"+folderid+"/Person/fileName";
		MockMultipartFile file = new MockMultipartFile("file1", "test.txt", "text/plain", "Hello World".getBytes());
		mockMvc.perform(multipart(url).file(file))
		    .andExpect(status().isOk());
		
	}
	@Test
	public void settertest() throws Exception{
		String[] args={"agr1","arg2"};
		Application1Application.main(args);
		Folder fld=new Folder("");
		fld.setFolderName("harsha");
		Student S=new Student("",(long)2,"","","".getBytes());
		S.setFolderNamee((long) 5);
		S.setFName("fFname");
		S.setFtype("Fname.py");
		S.setPerson("FnamePerson");
		S.setFile("data".getBytes());
		
	}
	@Test
	public void updateFile()  throws Exception{
		mockMvc.perform(put("/api/9/testingfolder6"))
		.andExpect(status().isOk());
	}
	
}
