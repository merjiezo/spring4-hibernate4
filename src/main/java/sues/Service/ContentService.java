package sues.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import sues.model.Content;
import sues.model.ContentDao;

@Transactional
@Service
public class ContentService {
	
	@Autowired
	private ContentDao contentDao;
	
	public boolean insertOneRec(String row, String contents) throws Exception {
		final Content con = new Content(row, contents);
		return contentDao.addContent(con);
	}
	
	public boolean updateRec(String row, String content) throws Exception {
		final Content con = new Content();
		con.setRow(row);
		con.setContents(content);
		return contentDao.updateContent(con);
	}
	
	public List<Content> getContent(String row) {
		List<Content> result = contentDao.queryOneRecordById(row);
		return result;
	}

}