package com.demo.scheduling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	private static final Logger log = LogManager.getLogger(Scheduler.class);
	@Scheduled(fixedRate = 2000)
	
	public void hello ()
	{
       log.info("Hello This Is Scheduled Msg");
	}
	
	
	

}
