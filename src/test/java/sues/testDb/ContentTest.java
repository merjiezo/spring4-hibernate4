package sues.testDb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import sues.Service.ContentService;
import sues.model.Content;

@ContextConfiguration(locations="classpath:/app.xml")
public class ContentTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ContentService contentService;
	
	@Test
	public void testContentQuery() throws Exception {
		List<Content> result = contentService.getContent("1");
		System.out.println(result.get(0).getContents());
	}
	
	@Test
	public void textContentUp() throws Exception {
		System.out.println(contentService.updateRec("1", "changed1"));
	}
	
	@Test
	public void textContentInsert() throws Exception {
		System.out.println(contentService.insertOneRec("5", "qwe"));
	}

}