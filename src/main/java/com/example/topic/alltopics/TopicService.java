package com.example.topic.alltopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service      //this is stereotype  // this mark the class as a spring business service
public class TopicService 
{
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1","Spring frameWork","Spring FrameWork description"),
			new Topic("2","core java"," core Java description"),
			new Topic("3","Data Structure and Algorithm","DSA description")
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
		for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) 
	{
		topics.removeIf(t->t.getId().equals(id));
	}

}
