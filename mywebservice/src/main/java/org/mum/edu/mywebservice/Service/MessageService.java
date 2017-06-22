package org.mum.edu.mywebservice.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mum.edu.mywebservice.Database.DatabaseClass;
import org.mum.edu.mywebservice.Exception.DataNotFoundException;
import org.mum.edu.mywebservice.Model.Message;

public class MessageService {
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	public MessageService() {
		
		messages.put(1L, new Message(1, "Nebeyou","Peace gaining"));	
		messages.put(2L, new Message(2, "Netsanet","Hello"));	
	}
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	public Message getMessage(long id){
		
		Message msid=messages.get(id);
		if(msid==null){
			throw new DataNotFoundException("Message with id:"+id+" not found.");
		}
		return msid;
	}
	public Message addMessage(Message msg){
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message deleteMessage(long id){
		return messages.remove(id);
	}
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messages=new ArrayList<>();
		Calendar calander=Calendar.getInstance();
		for(Message msg:messages){
			calander.setTime(msg.getCreated());
			if(calander.get(Calendar.YEAR)==year){
				messages.add(msg);
			}
		}
		return messages;
	}
	public List<Message> getAllMessagePaginated(int start,int size ){
		List<Message> msgs=new ArrayList<>(messages.values());
		if(start+size>msgs.size()) return null;
		else return msgs.subList(start, start+size);
		
	}
}
