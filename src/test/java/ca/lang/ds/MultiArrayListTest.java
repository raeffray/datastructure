package ca.lang.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MultiArrayListTest {

	@Test
	public void test_add_get() {
		
		MultiArrayList<String> mal = new MultiArrayList<>();
		
		String value = "FOO"; 
		
		mal.add(50, value);
		
		assertThat(mal.get(50), equalTo(value));
	}
	
}
