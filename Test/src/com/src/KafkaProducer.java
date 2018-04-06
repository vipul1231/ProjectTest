package com.src;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;

public class KafkaProducer {
    private static Producer<Integer, String> producer;
    //private static final String topic= "roll-day-complete";
    ObjectMapper ob = new ObjectMapper();

    Players players = new Players();
    
    public void initialize() {
          Properties producerProps = new Properties();
          producerProps.put("metadata.broker.list", "172.31.3.110:9092");
          producerProps.put("serializer.class", "kafka.serializer.StringEncoder");
          producerProps.put("request.required.acks", "1");
          producerProps.put("group.id", "com.wdtablesystems.ccas.game-service");
          producerProps.put("com.wdts.kafka.topic.submit.name", "roll-day-complete");
          ProducerConfig producerConfig = new ProducerConfig(producerProps);
          producer = new Producer<Integer, String>(producerConfig);
    }
    
    public void publishMesssage() throws Exception{ 
    	File file = new File("src/com/src/test.json");
    	String path = file.getAbsolutePath();
    	System.out.println(path);  	
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        
        FileInputStream file1 = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(file1);
        
        ob.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonFactory jsonFactory = ob.getFactory();
        JsonParser jp = jsonFactory.createParser(input);
        
        JsonToken jsonToken;
        
        while((jsonToken = jp.nextToken()) != null){
        	switch(jsonToken){
        		case START_OBJECT:
        			JsonNode node = jp.readValueAsTree();
        			if(node != null){
        				players = ob.readValue(node.toString(), Players.class);
        			}
			default:
				break;
        	}
        }
        
        MgmCasinoPlayer mgmPlayer = players.getPlayers().get(0);
        
        int playerid = 1000;
        for(int i=0;i<3000;i++){
        	MgmCasinoPlayer testPlayer = new MgmCasinoPlayer();
        	playerid=playerid+10;
        	testPlayer.setPlayerID(Integer.toString(playerid));
        	testPlayer.setCity(mgmPlayer.getCity());
        	testPlayer.setCardId(mgmPlayer.getCardId());
        	testPlayer.setCountry(mgmPlayer.getCountry());
        	testPlayer.setCreditAccount(mgmPlayer.getCreditAccount());
        	testPlayer.setFirstName(mgmPlayer.getFirstName());
        	testPlayer.setLastName(mgmPlayer.getLastName());
        	testPlayer.setSiteID(mgmPlayer.getSiteID());
        	testPlayer.setStopCodes(mgmPlayer.getStopCodes());
        	testPlayer.setRanking(mgmPlayer.getRanking());
        	testPlayer.setState(mgmPlayer.getState());
        	testPlayer.setPreferredName(mgmPlayer.getPreferredName());
        	testPlayer.setMiddleName(mgmPlayer.getMiddleName());
        	testPlayer.setDateOfBirth(mgmPlayer.getDateOfBirth());
        	players.getPlayers().add(testPlayer);
        }
        
        File file2 = new File("src/com/src/output.json");
        ob.writeValue(file2, players);
        
        System.out.println(file2.exists());
        
        
        reader.close();
        
//    	Scanner scanner = new Scanner(System.in);
//        StringBuilder msg = new StringBuilder();
//        msg.append(scanner.nextLine());	
//       
//        
//        //while(reader.read()!= -1){
//        //	msg.append(reader.readLine());
//        //}
//        RollDayComplete playerStatsUpdate =  ob.readValue(msg.toString(), RollDayComplete.class); 
//        //Define topic name and message
//        for(int i=0;i<1;i++)
//        {
//        	String msg1 = ob.writeValueAsString(playerStatsUpdate);
//        	KeyedMessage<Integer, String> keyedMsg = new KeyedMessage<Integer, String>(topic, msg1);
//            producer.send(keyedMsg);
//            System.out.println(msg1);
//        }
//        scanner.close();
        // This publishes message on given topic
        //System.out.println(msg1);
      }
    

    public static void main(String[] args) throws Exception {
          KafkaProducer kafkaProducer = new KafkaProducer();
          // Initialize producer
          kafkaProducer.initialize();            
          // Publish message
          kafkaProducer.publishMesssage();
          //Close the producer
          producer.close();
    }
}