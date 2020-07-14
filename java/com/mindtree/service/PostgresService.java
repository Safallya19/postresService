package com.mindtree.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mindtree.kafka.connector.consumer.KafkaConsmerPro;
import com.mindtree.kafka.connector.consumer.KafkaConsumerConnector;
import com.mindtree.kafka.listener.ListnerKafka;
import com.mindtree.model.DBData;
import com.mindtree.postgres.connector.DatabaseExecute;
import com.mindtree.postgres.connector.MTLibPostgresConnect;

@Service
public class PostgresService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	 KafkaConsmerPro pro = new KafkaConsmerPro();
	ListnerKafka kl = new ListnerKafka();
	DBData db = new DBData();
	
	//@MTLibPostgresConnect(query = "insert into tbl_emp(id,name,email) values(16,'amit', 'amit@mindtree.com')",  datasourceUrl = "jdbc:postgresql://localhost:5432/postgres", datasourcePassword = "admin", datasourceUsername = "postgres", processingMethod = "dbResponse")
	public void pgDatabase() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
		System.out.println("FLow Control: Custom code : Invoking connector library API");
		
		//Library class
		DatabaseExecute dbExecute = new DatabaseExecute();
		
		 
		/*
		 * data.setEmail("sumnat@mindtree.com"); data.setId(17);
		 * data.setFirst_name("sumant");
		 */
		dbExecute.executeQuery(this); 

	}
	
	public String topicName(String topic) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		   String topicName=null;
		if(topic.equals("KAFKA_MINDTREE")) {
			//consumeKafkaMindtree(topic);
			topicName=topic;
			
		}
		else if(topic.equals("KAFKA_MINDTREE_DEMO")) {
			//consumeKafkaMindtreeDemo(topic);
			topicName=topic;
		}
		return "from this topic:"+topicName;
	}
	
	/*
	 * @KafkaConsumerConnector(topicName="KAFKA_MINDTREE", groupId= "group_id",
	 * message="message from kafka mindtree sample service") public void
	 * consumeKafkaMindtree(String message) throws NoSuchMethodException,
	 * SecurityException, IllegalAccessException, IllegalArgumentException,
	 * InvocationTargetException, SQLException { // pro.process(this, topic,kl);
	 * porocessMessage(this, message); }
	 */
	
	  @KafkaListener(id = "postgre-consumer", topics = "KAFKA_MINDTREE") 
	  public void consumeMessage(String message)
	     {  
		  System.out.println("Got message: " + message); 
		  }
	
	public void porocessMessage(Object c, String msg) throws NoSuchMethodException, SecurityException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException, SQLException {
        Class<?> clzz = c.getClass();
       Method m = clzz.getDeclaredMethod("consumeKafkaMindtree", new Class[] {String.class});
       //m.invoke(c);
       KafkaConsumerConnector annotations = m.getAnnotation(KafkaConsumerConnector.class); 
      String topicName = annotations.topicName();
      String message = msg;
      System.out.println("====message from kafka===="+message);
      pgDatabase();
      kl.consume(topicName, message);
      }
	

}
