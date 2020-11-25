package com.order.management.orderservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.order.management.orderservice.model.OrderDetails;
import com.order.management.orderservice.repository.OrderRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	OrderRepository order;
	
public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		String path="C:\\Users\\856336\\Desktop\\Report";
		List<OrderDetails> orderdetails = order.findAll();
		
		File file = ResourceUtils.getFile("classpath:report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orderdetails);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "value");
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if(reportFormat.equalsIgnoreCase("html")) {
		JasperExportManager.exportReportToHtmlFile(jasperprint, path+"\\order.html")	;
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperprint,path+"\\order.pdf");
		}
		
		return "report generated in path :"+path;
		
	}

}
