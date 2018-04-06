package test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;


@EnableEurekaClient
@RestController
@SpringBootApplication
public class SpringController {
	
	public static void main(String[] args)
	{
		String basePackages= "test";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(basePackages);
		ctx.register(MyConfig.class);
		//ctx.refresh();
		App app = ctx.getBean(App.class);
		app.setAge(12);
		app.setName("Vipul");
		//System.out.println(app.getAge());
	
		try {
			app.throwException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured");
		}
		
		ctx.close();
	
	}
}
