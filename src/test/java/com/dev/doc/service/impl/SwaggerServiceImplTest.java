package com.dev.doc.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.base.json.JsonUtils;
import com.dev.base.test.BaseTest;
import com.dev.base.util.FreeMarkerUtil;
import com.dev.doc.service.SwaggerService;

import io.swagger.models.Swagger;

public class SwaggerServiceImplTest extends BaseTest {
	
	@Autowired
	private SwaggerService swaggerService;

	@Test
	public void testBuildApiDoc() throws Exception {
		Swagger swagger = swaggerService.buildApiDoc(14L, 366L);
		System.out.println(JsonUtils.toFormatJson(swagger));
		// FileUtils.writeStringToFile(new File("d://dev.json"),
		// JsonUtils.toFormatJson(swagger));
	}

	@Test
	public void testBuildDocTmplData() {
		Map<String, Object> result = swaggerService.buildDocTmplData(973L, 927L);
		System.out.println(JsonUtils.toJson(result));
	}

	@Test
	public void testExportDoc() throws Exception {
		Map<String, Object> result = swaggerService.buildDocTmplData(14L, 366L);
		Writer writer = new FileWriter(new File("word.html"));
		FreeMarkerUtil.process("doc.ftl", result, writer);
		System.out.println(JsonUtils.toJson(result));
	}
}
