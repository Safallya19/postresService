package com.mindtree.postgres.service;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.mindtree.postgres.connector.DatabaseExecute;
import com.mindtree.postgres.connector.MTLibPostgresConnect;
import com.mindtree.postgres.dto.PostgreSQLResponse;
import com.mindtree.postgress.dto.DBData;

@Service
public class PostgreSQLService {

	@MTLibPostgresConnect(query = "Select * from tbl_emp", datasourceUrl = "jdbc:postgresql://localhost:5432/postgres", datasourcePassword = "admin", datasourceUsername = "postgres", processingMethod = "dbResponse")
	public String pgDatabase() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		// Library class
		DatabaseExecute postgresMtConnector = new DatabaseExecute();
		ResultSet rs = postgresMtConnector.executeQuery(this);
		List<DBData> db = new ArrayList<>();

		if (rs != null) {
			while (rs.next()) {
				DBData data = new DBData();
				data.setId(rs.getInt(1));
				data.setName(rs.getString(2));
				data.setEmail(rs.getString(3));
				db.add(data);
			}

		}
		if (db.size() == 0) {
			return "no data found";
		}

		return db.toString();

	}

	public String finalResponse(PostgreSQLResponse data)
			throws ParserConfigurationException, JAXBException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setNamespaceAware(true);

		String postgresResponseXml = convertPostgresResultToString(data);

		return postgresResponseXml;

	}

	public String convertPostgresResultToString(PostgreSQLResponse data) throws JAXBException {

		StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(PostgreSQLResponse.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(data, sw);
		return sw.toString();
	}

}
