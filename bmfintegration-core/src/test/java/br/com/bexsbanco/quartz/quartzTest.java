package br.com.bexsbanco.quartz;

import org.junit.Ignore;
import org.junit.Test;

import br.com.bexsbanco.scheduler.BmfScheduler;

public class quartzTest {

	@Test
	public void testScheduler() {

		BmfScheduler.startScheduler();
		
		try {
			Thread.sleep(20000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		BmfScheduler.shutdownScheduler();
		
	}
}
