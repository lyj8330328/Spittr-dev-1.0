// package myspittr.config;
//
// import javax.servlet.MultipartConfigElement;
// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRegistration.Dynamic;
//
// import org.springframework.web.WebApplicationInitializer;
// import org.springframework.web.servlet.DispatcherServlet;
//
// public class MyServletInitializer implements WebApplicationInitializer {
//
// @Override
// public void onStartup(ServletContext arg0) throws ServletException {
// // TODO Auto-generated method stub
// // ×¢²áServlet
// DispatcherServlet dServlet = new DispatcherServlet();
// Dynamic registration = arg0.addServlet("appServlet", dServlet);
// registration.addMapping("/");
// registration.setMultipartConfig(new
// MultipartConfigElement("/tmp/spittr/uploads"));
// }
//
// }
