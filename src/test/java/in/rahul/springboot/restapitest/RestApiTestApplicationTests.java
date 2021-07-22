package in.rahul.springboot.restapitest;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void verifyHelloMessage() throws Exception{
		String patternString = "(Hello Rest Testing! From host: ).*\\/\\d+.\\d+.\\d+.\\d+";
		Matcher<String> regexMatcher = Matchers.matchesRegex(patternString);

		this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
				.andExpect(content().string(regexMatcher));
	}

}
