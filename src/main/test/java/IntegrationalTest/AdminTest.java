package IntegrationalTest;

import com.samsolutions.myapp.config.AppConfig;
import com.samsolutions.myapp.config.WebConfig;
import com.samsolutions.myapp.service.impl.UserDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class, WebConfig.class})
@AutoConfigureMockMvc
@TestPropertySource("/app.properties")
@WithUserDetails(value = "admin", userDetailsServiceBeanName = "userDetailsServiceImpl")
public class AdminTest {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserDAOServiceImpl userDaoService;

	@Test
	public void getAdminPageSuccess() throws Exception {
		this.mockMvc.perform(get("/admin"))
				.andExpect(status().isOk());
	}

}
